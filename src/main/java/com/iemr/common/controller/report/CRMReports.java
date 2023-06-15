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
package com.iemr.common.controller.report;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.mapper.Report1097Mapper;
import com.iemr.common.model.reports.Report1097RequestModel;
import com.iemr.common.model.reports.Report1097ResponseModel;
import com.iemr.common.service.reports.CallReportsService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RequestMapping({ "/crmReports" })
@RestController
public class CRMReports {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InputMapper inputMapper = new InputMapper();

	private CallReportsService callReportsService;

	@Autowired
	public void setCallReportsService(CallReportsService callReportsService) {
		this.callReportsService = callReportsService;
	}

	@Autowired
	Report1097Mapper mapper;

	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getAllReportsByDateDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllReportsByDate(@ApiParam(value = "\"{\\\"providerServiceMapID\\\":\\\"Integer\\\","
			+ "\\\"beneficiaryCallType\\\":\\\"String\\\",\\\"beneficiaryCallSubType\\\":\\\"String\\\","
			+ "\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
			+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\",\\\"gender\\\":\\\"String\\\","
			+ "\\\"beneficiaryPreferredLanguage\\\":\\\"String\\\",\\\"beneficiarySexualOrientation\\\":\\\"String\\\"}\"") @RequestBody Report1097RequestModel jsonRequest) {
		OutputResponse response = new OutputResponse();
		try {
			List<CallDetailsReport> callDetailsReports = callReportsService
					.getAllReportsByDate(mapper.requestToCRMReports(jsonRequest));
			
			java.util.Date startDate = jsonRequest.getStartTimestamp();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			String str1 = sdf1.format(startDate.getTime());
			startDate = sdf1.parse(str1);
			String startDateTime = sdf1.format(startDate);
			Timestamp startOfDate = Timestamp.valueOf(startDateTime);
			jsonRequest.setStartTimestamp(startOfDate);

			java.util.Date endDate = jsonRequest.getEndTimestamp();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			String str2 = sdf2.format(endDate.getTime());
			endDate = sdf2.parse(str2);
			String endDateTime = sdf2.format(endDate);
			Timestamp endOfDate = Timestamp.valueOf(endDateTime);
			jsonRequest.setEndTimestamp(endOfDate);
			
			List<Report1097ResponseModel> reportList = new ArrayList<Report1097ResponseModel>();
			Long slNo = 1l;
			for (CallDetailsReport callDetailsReport : callDetailsReports) {
				Report1097ResponseModel report = mapper.crmReportsToResponse(callDetailsReport);
				report.setSlNo(slNo++);
				reportList.add(report);
			}
			response.setResponse(reportList.toString());
		} catch (Exception e) {
			response.setError(e);
		}
		logger.info("response is " + response.toStringWithSerialization());
		return response.toStringWithSerialization();
	}

	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getAllReportsByDateV1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllReportsByDateV1(@RequestBody Report1097RequestModel jsonRequest) {
		OutputResponse response = new OutputResponse();
		// try
		// {
		// List<CallDetailsReport> callDetailsReports =
		// callReportsService.getAllReportsByDate(mapper.requestToCRMReports(jsonRequest));
		// JSONArray reportList = new JSONArray();
		// Long slNo = 1l;
		// HashMap<Long, JSONObject> reportMap = new HashMap<Long, JSONObject>();
		// int information = 0;
		// int counselling = 0;
		// int referral = 0;
		// int feedback = 0;
		// for (CallDetailsReport callDetailsReport : callDetailsReports)
		// {
		// Report1097ResponseModel report =
		// mapper.crmReportsToResponse(callDetailsReport);
		// JSONObject reportObj = null;
		// if (!reportMap.containsKey(report.getBenCallID()))
		// {
		// report.setSlNo(slNo++);
		// reportObj = new JSONObject(report.toString());
		// reportObj.remove("categoryName");
		// reportObj.remove("subCategoryName");
		// reportObj.remove("documentName");
		// reportObj.remove("counselingSubCategoryName");
		// reportObj.remove("counselingCategoryName");
		// reportObj.remove("counselingDocumentName");
		// reportObj.remove("feedbackID");
		// reportObj.remove("feedback");
		// information = counselling = referral = feedback = 0;
		// } else
		// {
		// reportObj = reportMap.get(report.getBenCallID());
		// }
		// if (report.getSubCategoryName() != null)
		// {
		// information++;
		// reportObj.put("categoryName" + information, report.getCategoryName());
		// reportObj.put("subCategoryName" + information, report.getSubCategoryName());
		// reportObj.put("documentName" + information, report.getDocumentName());
		// }
		// if (report.getCounselingSubCategoryName() != null)
		// {
		// counselling++;
		// reportObj.put("counselingCategoryName" + counselling,
		// report.getCategoryName());
		// reportObj.put("counselingSubCategoryName" + counselling,
		// report.getSubCategoryName());
		// reportObj.put("counselingSubCategoryName" + counselling,
		// report.getCounsellingDocumentName());
		// }
		// if (callDetailsReport.getFeedbackID() != null)
		// {
		// feedback++;
		// reportObj.put("feedbackID" + feedback, report.getFeedbackID());
		// reportObj.put("feedback" + feedback, report.getFeedback());
		// }
		// reportMap.put(report.getBenCallID(), reportObj);
		// }
		// Set<Long> bencallIDs = reportMap.keySet();
		// for (Long long1 : bencallIDs)
		// {
		// reportList.put(reportMap.get(long1));
		// }
		// response.setResponse(reportList.toString());
		// } catch (Exception e)
		// {
		// response.setError(e);
		// }
		// logger.info("response is " + response.toStringWithSerialization());
		return response.toStringWithSerialization();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(value = "/getAllByAgeGroupDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllByAgeGroup(
			@ApiParam(value = "\"{\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"maxAge\\\":\\\"Integer\\\",\\\"minAge\\\":\\\"Integer\\\",\\\"startTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"endTimestamp\\\":\\\"Timestamp\\\",\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody Report1097RequestModel[] jsonRequest) {
		OutputResponse response = new OutputResponse();
		try {
			ArrayList<Report1097RequestModel> requests = new ArrayList<Report1097RequestModel>();
			for (Report1097RequestModel request : jsonRequest) {
				
				java.util.Date startDate = request.getStartTimestamp();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				String str1 = sdf1.format(startDate.getTime());
				startDate = sdf1.parse(str1);
				String startDateTime = sdf1.format(startDate);
				Timestamp startOfDate = Timestamp.valueOf(startDateTime);
				request.setStartTimestamp(startOfDate);

				java.util.Date endDate = request.getEndTimestamp();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
				String str2 = sdf2.format(endDate.getTime());
				endDate = sdf2.parse(str2);
				String endDateTime = sdf2.format(endDate);
				Timestamp endOfDate = Timestamp.valueOf(endDateTime);
				request.setEndTimestamp(endOfDate);
				
				requests.add(request);
			}
			String callDetailsReportsByAge = callReportsService.getAllByAgeGroup(mapper.requestToCRMReports(requests));
			response.setResponse(callDetailsReportsByAge);
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getAllByGenderDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllByGender(
			@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"gender\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\","
					+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody Report1097RequestModel[] jsonRequest) {
		OutputResponse response = new OutputResponse();
		try {
			ArrayList<Report1097RequestModel> requests = new ArrayList<Report1097RequestModel>();
			for (Report1097RequestModel request : jsonRequest) {
				
				java.util.Date startDate = request.getStartTimestamp();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				String str1 = sdf1.format(startDate.getTime());
				startDate = sdf1.parse(str1);
				String startDateTime = sdf1.format(startDate);
				Timestamp startOfDate = Timestamp.valueOf(startDateTime);
				request.setStartTimestamp(startOfDate);

				java.util.Date endDate = request.getEndTimestamp();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
				String str2 = sdf2.format(endDate.getTime());
				endDate = sdf2.parse(str2);
				String endDateTime = sdf2.format(endDate);
				Timestamp endOfDate = Timestamp.valueOf(endDateTime);
				request.setEndTimestamp(endOfDate);
				
				requests.add(request);
			}
			String callDetailsReportsByGender = callReportsService.getAllByGender(mapper.requestToCRMReports(requests));
			response.setResponse(callDetailsReportsByGender);
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getAllBySexualOrientationDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllBySexualOrientation(
			@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"beneficiarySexualOrientation\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\","
					+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody Report1097RequestModel[] jsonRequest) {
		OutputResponse response = new OutputResponse();
		try {
			ArrayList<Report1097RequestModel> requests = new ArrayList<Report1097RequestModel>();
			for (Report1097RequestModel request : jsonRequest) {
				
				java.util.Date startDate = request.getStartTimestamp();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				String str1 = sdf1.format(startDate.getTime());
				startDate = sdf1.parse(str1);
				String startDateTime = sdf1.format(startDate);
				Timestamp startOfDate = Timestamp.valueOf(startDateTime);
				request.setStartTimestamp(startOfDate);

				java.util.Date endDate = request.getEndTimestamp();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
				String str2 = sdf2.format(endDate.getTime());
				endDate = sdf2.parse(str2);
				String endDateTime = sdf2.format(endDate);
				Timestamp endOfDate = Timestamp.valueOf(endDateTime);
				request.setEndTimestamp(endOfDate);
				
				requests.add(request);
			}
			String callDetailsReportsBySexualOrientation = callReportsService
					.getAllBySexualOrientation(mapper.requestToCRMReports(requests));
			response.setResponse(callDetailsReportsBySexualOrientation);
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getCountsByPreferredLanguageDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCountsByPreferredLanguage(
			@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"beneficiaryPreferredLanguage\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\","
					+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody Report1097RequestModel[] jsonRequest) {
		OutputResponse response = new OutputResponse();
		try {
			ArrayList<Report1097RequestModel> requests = new ArrayList<Report1097RequestModel>();
			for (Report1097RequestModel request : jsonRequest) {
				
				java.util.Date startDate = request.getStartTimestamp();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				String str1 = sdf1.format(startDate.getTime());
				startDate = sdf1.parse(str1);
				String startDateTime = sdf1.format(startDate);
				Timestamp startOfDate = Timestamp.valueOf(startDateTime);
				request.setStartTimestamp(startOfDate);

				java.util.Date endDate = request.getEndTimestamp();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
				String str2 = sdf2.format(endDate.getTime());
				endDate = sdf2.parse(str2);
				String endDateTime = sdf2.format(endDate);
				Timestamp endOfDate = Timestamp.valueOf(endDateTime);
				request.setEndTimestamp(endOfDate);
				
				requests.add(request);
			}
			String countsByPreferredLanguage = callReportsService
					.getCountsByPreferredLanguage(mapper.requestToCRMReports(requests));
			response.setResponse(countsByPreferredLanguage);
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
    @Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getComplaintDetailReports", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getComplaintDetailReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\","
					+ "\\\"feedbackTypeID\\\":\\\"Integer\\\",\\\"feedbackNatureID\\\":\\\"Integer\\\",\\\"feedbackTypeName\\\":\\\"String\\\"}\"") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getComplaintDetailReport request " + request);
		try {
			response.setResponse(callReportsService.getComplaintDetailReport(request));
		} catch (Exception e) {
			logger.error("getComplaintDetailReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}

    @Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getUnblockedUserReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getUnblockedUserReport(
			@ApiParam(value = "\"{\\\"blockStartDate\\\":\\\"Timestamp\\\",\\\"blockEndDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\"}\"") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getUnblockedUserReport request " + request);
		try {
			response.setResponse(callReportsService.getUnblockedUserReport(request));
		} catch (Exception e) {
			logger.error("getUnblockedUserReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}

	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getDistrictWiseCallReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getDistrictWiseCallReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"districtID\\\":\\\"Integer\\\",\\\"district\\\":\\\"String\\\",\\\"subdistrictID\\\":\\\"Integer\\\",\\\"villageID\\\":\\\"Integer\\\","
					+ "\\\"locationID\\\":\\\"Integer\\\",\\\"roleID\\\":\\\"Integer\\\"}\"") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getDistrictWiseCallReport request " + request);
		try {
			response.setResponse(callReportsService.getDistrictWiseCallReport(request));
		} catch (Exception e) {
			logger.error("getDistrictWiseCallReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}

	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getCallQualityReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallQualityReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"searchCriteria\\\":\\\"String\\\",\\\"workingLocationID\\\":\\\"Integer\\\"}\"") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getCallQualityReport request " + request);
		try {
			response.setResponse(callReportsService.getCallQualityReport(request));
		} catch (Exception e) {
			logger.error("getCallQualityReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}
    @Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getQualityReports", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getQualityReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"agentID\\\":\\\"Integer\\\","
					+ "\\\"roleName\\\":\\\"String\\\",\\\"reportTypeID\\\":\\\"Integer\\\",\\\"reportType\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest)

	{
		OutputResponse response = new OutputResponse();
		try {
			String requestReports = callReportsService.getQualityReport(jsonRequest);
			response.setResponse(requestReports.toString());
		} catch (Exception e) {
			logger.error("getDistrictWiseCallReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}
    @Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/getCallSummaryReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallSummaryReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"agentID\\\":\\\"Integer\\\",\\\"roleName\\\":\\\"String\\\","
					+ "\\\"callTypeID\\\":\\\"Integer\\\","
					+ "\\\"callTypeName\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest)

	{
		OutputResponse response = new OutputResponse();
		try {
			String requestReports = callReportsService.getCallSummaryReport(jsonRequest);
			response.setResponse(requestReports.toString());
		} catch (Exception e) {
			logger.error("getCallSummaryReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toStringWithSerialization();
	}

	@CrossOrigin()
	@ApiOperation(value = "QA report type master Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/getReportTypes/{providerServiceMapID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String patientAppChiefComplaintsMasterData(
			@PathVariable("providerServiceMapID") Integer providerServiceMapID) throws Exception {
		logger.info("QA report type master Data for " + " providerServiceMapID:" + providerServiceMapID);
		;
		OutputResponse response = new OutputResponse();
		response.setResponse(callReportsService.getReportTypes(providerServiceMapID));
		logger.info("Nurse master Data for categoryID:" + response.toString());
		return response.toString();
	}
}
