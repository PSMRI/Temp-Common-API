package com.iemr.common.controller.nhmdashboard;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.xml.security.stax.config.ConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.nhm_dashboard.DetailedCallReport;
import com.iemr.common.repository.nhm_dashboard.DetailedCallReportRepo;
import com.iemr.common.repository.report.CallReportRepo;
import com.iemr.common.utils.config.ConfigProperties;

@EnableScheduling
@Configuration
public class NHMDetailCallReportScheduler {

	@Autowired
	private DetailedCallReportRepo detailedCallReportRepo;

	@Autowired
	private CallReportRepo callReportRepo;

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${start-ctidatacheck-scheduler}")
	private boolean startCtiDataCheckFlag;


	@Scheduled(cron = "${cron-scheduler-ctidatacheck}")
	public void detailedCallReport() {
		if (startCtiDataCheckFlag) {
			try {
				String endDate = null;
				String fromDate = null;
				LocalDateTime date = null;
				date = LocalDateTime.now().minusDays(1);
				String[] dateArr = date.toString().split("T");
				endDate = dateArr[0].concat(" 23:59:59");
				fromDate = dateArr[0].concat(" 00:00:01");

				Timestamp fromTime = Timestamp.valueOf(fromDate);
				Timestamp endTime = Timestamp.valueOf(endDate);
				logger.info("Call detailed report check request - FromTime -" + fromTime + "Endtime - " + endTime);
				List<DetailedCallReport> findByCallStartTimeBetween = detailedCallReportRepo
						.findByCallStartTimeBetween(fromTime, endTime);
				for (DetailedCallReport detailedCallReport : findByCallStartTimeBetween) {
					String phoneNo = detailedCallReport.getPHONE();
					String sessionID = detailedCallReport.getSession_ID();
					int existRecord = callReportRepo.getBenCallDetailsBySessionIDAndPhone(sessionID, phoneNo);
					if (existRecord != 0) {
						logger.info("Record already present in t_bencall table with sessionID : " + sessionID
								+ " phoneNo : " + phoneNo);
						if (null != detailedCallReport.getOrientation_Type()
								&& detailedCallReport.getOrientation_Type().equalsIgnoreCase("OUTBOUND")) {
							callReportRepo.updateIsOutboundForCall(true, sessionID, phoneNo );
						} else {
							callReportRepo.updateIsOutboundForCall(false, sessionID, phoneNo );
						}
					} else {
						logger.info("Record missed in t_bencall table with sessionID : " + sessionID + " phoneNo : "
								+ phoneNo);
						BeneficiaryCall callDetail = getCallDetail(detailedCallReport);
						callReportRepo.save(callDetail);
					}
				}
			} catch (Exception e) {
				logger.error("Error while fetching call detailed report " + e.getMessage());
			}

		}

	}

	private BeneficiaryCall getCallDetail(DetailedCallReport detailedCallReport) {
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setCallID(detailedCallReport.getSession_ID());
		beneficiaryCall.setPhoneNo(detailedCallReport.getPHONE());
		beneficiaryCall.setCalledServiceID(null);
		beneficiaryCall.setRemarks("missed records - Failure");
		beneficiaryCall.setReceivedRoleName(detailedCallReport.getCampaign_Name());
		beneficiaryCall.setAgentID(String.valueOf(detailedCallReport.getAgent_ID()));

		beneficiaryCall.setCallEndTime(detailedCallReport.getCallEndTime());
		beneficiaryCall.setCallDuration(String.valueOf(detailedCallReport.getCall_Duration()));
		if (null != detailedCallReport.getOrientation_Type()
				&& detailedCallReport.getOrientation_Type().equalsIgnoreCase("OUTBOUND")) {
			beneficiaryCall.setIsOutbound(true);
		} else {
			beneficiaryCall.setIsOutbound(false);
		}
		beneficiaryCall.setCallTime(detailedCallReport.getCallStartTime());
		beneficiaryCall.setCallEndTime(detailedCallReport.getCallEndTime());
		beneficiaryCall.setCreatedBy("Admin");

		beneficiaryCall.setCallDuration(String.valueOf(detailedCallReport.getCall_Duration()));

		return beneficiaryCall;

	}
}
