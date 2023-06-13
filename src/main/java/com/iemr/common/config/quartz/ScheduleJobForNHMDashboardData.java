package com.iemr.common.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.service.nhm_dashboard.NHM_DashboardService;

@Service
@Transactional
public class ScheduleJobForNHMDashboardData implements Job {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private NHM_DashboardService nhmDashboardService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Started job for NHM dashboard data pull from cti " + arg0.getClass().getName());
		try {
			String s = nhmDashboardService.pull_NHM_Data_CTI();
			logger.info(s);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		logger.info("Completed job for NHM dashboard data pull from cti " + arg0.getClass().getName());
	}
}
