package com.iemr.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.iemr.common.utils.IEMRApplBeans;

@SpringBootApplication
public class CommonApplication extends SpringBootServletInitializer {

	@Bean
	public IEMRApplBeans instantiateBeans() {
		return new IEMRApplBeans();
	}

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { CommonApplication.class });
	}

}
