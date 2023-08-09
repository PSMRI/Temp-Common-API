/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.service.ctiCall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.cti.CTIVoiceFile;
import com.iemr.common.data.report.CTIData;
import com.iemr.common.data.report.CTIResponse;
import com.iemr.common.data.report.CallReport;
import com.iemr.common.data.report.QaReportModel;
import com.iemr.common.repository.report.CallReportRepo;
import com.iemr.common.service.cti.CTIService;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@Service
@PropertySource("classpath:application.properties")
public class CallCentreDataSyncImpl implements CallCentreDataSync {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private CallReportRepo callReportRepo;
	@Value("${cti-server-ip}")
	private String ctiServerIP;

	@Value("${call-info-api-URL}")
	private String callinfoapiURL;

	@Value("${cz-duration}")
	private String CZduration;
	private static HttpUtils httpUtils;
	@Autowired
	private CTIService ctiService;
	private static String ctiLoggerURL = ConfigProperties.getPropertyByName("cti-logger_base_url");

	public CallCentreDataSyncImpl() {
		if (httpUtils == null) {
			httpUtils = new HttpUtils();
		}
	}

	@Override
	public String callUrl(String urlRequest) {
		httpUtils = new HttpUtils();
		String result = httpUtils.get(urlRequest);
		return result;
	}

	@Override
	public void ctiDataSync() {
		List<Objects[]> resultSet = null;
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String text = sqlDate.toString();
		Timestamp endDate = new Timestamp(sqlDate.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sqlDate);
		logger.info("CZduration: " + CZduration);
		calendar.add(Calendar.DATE, -(Integer.parseInt(CZduration)));
		Date beforeDate = calendar.getTime();
		Timestamp startDate = new Timestamp(beforeDate.getTime());
		// application properties will have a config date variable.
		logger.info("startDate: " + startDate);
		logger.info("endDate: " + endDate);
		List<BeneficiaryCall> list = callReportRepo.getAllBenCallIDetails(startDate, endDate);

		if (!list.isEmpty()) {
			
			// List<Long> benList = new ArrayList<>();
			String callDuartion = null;
			String filePath = null;
			String URL = null;
			String callinfoapiURL = null;
			String ctiResponse = null;
			String callEndTime = null;
			String callStartTime = null;
			String recordingPath = "";
			for (BeneficiaryCall call : list) {
				if (call.getCallID() != null) {
					recordingPath = null;
					try {
						JSONObject requestFile = new JSONObject();
						requestFile.put("agent_id", call.getAgentID());
						requestFile.put("session_id", call.getCallID());
//						OutputResponse response1 = ctiService.getVoiceFile(requestFile.toString(), "extra parameter");
//						if (response1.getStatusCode() == OutputResponse.SUCCESS) {
//							CTIVoiceFile getVoiceFile = InputMapper.gson().fromJson(response1.getData(),
//									CTIVoiceFile.class);
//							String recordingFilePath = getVoiceFile.getPath() + "/" + getVoiceFile.getFilename();
////						beneficiaryCallRepository.updateVoiceFilePathNew(benificiaryCall.getAgentID(),
////								benificiaryCall.getCallID(), recordingFilePath, null);
//							recordingPath = ctiLoggerURL + "/" + recordingFilePath;
						OutputResponse response1 = ctiService.getVoiceFileNew(requestFile.toString(), "extra parameter");
						if(response1 != null && response1.getStatusCode() == 200) {
							
							CTIResponse ctiResponsePath = InputMapper.gson().fromJson(response1.getData(),
									CTIResponse.class);
							String recordingFilePath = ctiResponsePath.getResponse().toString();
//							beneficiaryCallRepository.updateVoiceFilePathNew(call.getAgentID(),
//									call.getCallID(), recordingFilePath.substring(20), null);
							if(recordingFilePath.length() > 20)
								recordingPath = recordingFilePath.substring(20);
							logger.info("recordingPath: " + recordingPath);
						}

						callDuartion = null;
						callinfoapiURL = this.callinfoapiURL;
						URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP).replace("AGENT_ID", call.getAgentID())
								.replace("SESSION_ID", call.getCallID()).replace("PHONE_NO", call.getPhoneNo());

						logger.info("calling CTI API url: " + URL);
						ctiResponse = this.callUrl(URL);
//						logger.info("calling CTI API returned " + ctiResponse);

						CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
						CTIResponse model = data.getResponse();

						if (model.getResponse_code().equals("1")) {
							callDuartion = model.getCall_duration();
							callEndTime = model.getCall_end_date_time();
							callStartTime = model.getCall_start_date_time();
						}

						// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
						if (callDuartion != null)
							call.setCZcallDuration(Integer.parseInt(callDuartion));
						call.setRecordingPath(recordingPath);
						call.setCZcallEndTime(callEndTime);
						call.setCZcallStartTime(callStartTime);
						callReportRepo.save(call);
					} catch (Exception e) {
						logger.error("VoiceFile failed with error " + e.getMessage(), e);
					}

				}

			}
		}
	}
}