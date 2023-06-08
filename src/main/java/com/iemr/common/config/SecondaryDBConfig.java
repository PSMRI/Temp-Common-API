package com.iemr.common.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.iemr.common.utils.CryptoUtil;
import com.iemr.common.utils.config.ConfigProperties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "secondaryEntityManagerFactory",
  transactionManagerRef = "secondaryTransactionManager",
  basePackages = { "com.iemr.common.secondary.repository.callreport" }
)
public class SecondaryDBConfig {
	
	@Autowired
	private CryptoUtil cryptoUtil;
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Bean(name = "secondaryDataSource")
	  @ConfigurationProperties(prefix = "secondary.datasource")
	  public DataSource dataSource() {
		 PoolConfiguration p = new PoolProperties();
		  p.setMaxActive(30);
		  p.setMaxIdle(15);
		  p.setMinIdle(5);
		  p.setInitialSize(5);
		  p.setMaxWait(10000);
		  p.setMinEvictableIdleTimeMillis(15000);
		  p.setRemoveAbandoned(true);
		  p.setLogAbandoned(true);
		  p.setRemoveAbandonedTimeout(600);
		  p.setTestOnBorrow(true);
		  p.setValidationQuery("SELECT 1");
		  org.apache.tomcat.jdbc.pool.DataSource datasource = new org.apache.tomcat.jdbc.pool.DataSource();
		  datasource.setPoolProperties(p);
		  

			datasource.setUsername(cryptoUtil.decrypt(ConfigProperties.getPropertyByName("encDbUserNameSec")));
			datasource.setPassword(cryptoUtil.decrypt(ConfigProperties.getPropertyByName("encDbPassSec")));
		  
	    return datasource;
	  }
	  
	  @Bean(name = "secondaryEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean 
	  barEntityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("secondaryDataSource") DataSource dataSource
	  ) {
	    return
	      builder
	        .dataSource(dataSource)
	        .packages("common.iemr.common.secondary.data.report")
	        .persistenceUnit("db_reporting")
	        .build();
	  }
	  @Bean(name = "secondaryTransactionManager")
	  public PlatformTransactionManager barTransactionManager(
	    @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory
	    secondaryEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(secondaryEntityManagerFactory);
	  }
}
