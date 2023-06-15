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
package com.iemr.common.service.reports;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.report.BenDetails;
import com.iemr.common.data.report.BeneficiaryDetailsReport;
import com.iemr.common.data.report.CTIData;
import com.iemr.common.data.report.CTIResponse;
import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.CallQualityReport;
import com.iemr.common.data.report.CallReport;
import com.iemr.common.data.report.DimUserReport;
import com.iemr.common.data.report.FeedbackReport;
import com.iemr.common.data.report.MedHistory;
import com.iemr.common.data.report.QaReportModel;
import com.iemr.common.data.report.QaReportModel2;
import com.iemr.common.data.report.ReportType;
import com.iemr.common.data.report.UnBlockedPhoneReport;
import com.iemr.common.data.report.UserReport;
import com.iemr.common.data.report.UserServiceRoleReport;
import com.iemr.common.data.users.WorkLocation;
import com.iemr.common.mapper.Report1097Mapper;
import com.iemr.common.model.reports.AgentWiseReport;
import com.iemr.common.model.reports.CallSummaryReport;
import com.iemr.common.model.reports.CallTypeWiseReport;
import com.iemr.common.model.reports.ComplaintDetailReport;
import com.iemr.common.model.reports.DateWiseReport;
import com.iemr.common.model.reports.LocationWiseReport;
import com.iemr.common.model.reports.QualityReportModel;
import com.iemr.common.model.reports.SkillSetWiseReport;
import com.iemr.common.model.reports.UnBlockedUserReport;
import com.iemr.common.repository.report.CRMCallReportRepo;
import com.iemr.common.repository.report.CallReportRepo;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

@Service
public class CallReportsServiceImpl implements CallReportsService {
	private InputMapper inputMapper = new InputMapper();

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private CRMCallReportRepo crmCallReportRepository;

	DecimalFormat format = new DecimalFormat("#.##");

	@Autowired
	private CallReportRepo callReportRepo;

	@Autowired
	public void setCrmCallReportRepository(CRMCallReportRepo crmCallReportRepository) {
		this.crmCallReportRepository = crmCallReportRepository;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	Report1097Mapper mapper;

	@Value("${cti-server-ip}")
	private String ctiServerIP;

	@Value("${call-info-api-URL}")
	private String callinfoapiURL;

	@Override
	public List<CallDetailsReport> getAllReportsByDate(CallDetailsReport callDetailsReportRequest)
			throws IEMRException {
		logger.debug("getAllReportsByDate request: " + OutputMapper.gson().toJson(callDetailsReportRequest));
		List<CallDetailsReport> callDetailsReports = null;
		CallDetailsReport request = new CallDetailsReport();
		request.getBenReport().setGender(callDetailsReportRequest.getBenReport().getGender());
		request.getBenReport().setState(callDetailsReportRequest.getBenReport().getState());
		request.getBenReport().setDistrict(callDetailsReportRequest.getBenReport().getDistrict());
		request.getBenReport().setPreferredLanguage(callDetailsReportRequest.getBenReport().getPreferredLanguage());
		request.getBenReport().setSexualOrientation(callDetailsReportRequest.getBenReport().getSexualOrientation());
		request.setCallType(callDetailsReportRequest.getBeneficiaryCallType());
		request.setCallSubType(callDetailsReportRequest.getBeneficiaryCallSubType());
		request.setStartTimestamp(callDetailsReportRequest.getStartTimestamp());
		request.setEndTimestamp(callDetailsReportRequest.getEndTimestamp());
		request.setProviderServiceMapID(callDetailsReportRequest.getProviderServiceMapID());
		callDetailsReports = prepareTypedQuery(request);
		return callDetailsReports;
	}

	@Override
	public String getReportTypes(Integer psmid) throws IEMRException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<ReportType> reportTypes = crmCallReportRepository.getReportType();
		if (reportTypes != null) {
			resMap.put("qaReportTypes", reportTypes);
			return new Gson().toJson(resMap);
		} else
			throw new IEMRException("Error in fetching report type master");
	}

	private List<CallDetailsReport> prepareTypedQuery(CallDetailsReport callDetailsReportRequest) {
		Calendar today = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DAY_OF_YEAR, -7);
		Timestamp filterStartDate = (callDetailsReportRequest.getStartTimestamp() != null)
				? callDetailsReportRequest.getStartTimestamp()
				: (new Timestamp(startDate.getTimeInMillis()));
		Timestamp filterEndDate = (callDetailsReportRequest.getEndTimestamp() != null)
				? callDetailsReportRequest.getEndTimestamp()
				: (new Timestamp(today.getTimeInMillis()));
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CallDetailsReport> criteriaQuery = criteriaBuilder.createQuery(CallDetailsReport.class);
		Root<CallDetailsReport> root = criteriaQuery.from(CallDetailsReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (callDetailsReportRequest.getCallType() != null) {
			predicates.add(criteriaBuilder.equal(root.get("callType"), callDetailsReportRequest.getCallType()));
		}
		if (callDetailsReportRequest.getCallSubType() != null) {
			predicates.add(criteriaBuilder.equal(root.get("callSubType"), callDetailsReportRequest.getCallType()));
		}
		predicates.add(criteriaBuilder.between(root.get("callStartTime"), filterStartDate, filterEndDate));
		predicates.add(criteriaBuilder.equal(root.get("providerServiceMapID"),
				callDetailsReportRequest.getProviderServiceMapID()));

		Join<CallDetailsReport, BeneficiaryDetailsReport> benReport = root.join("benReport", JoinType.INNER);

		if ((callDetailsReportRequest.getBenReport() != null)
				&& (callDetailsReportRequest.getBenReport().getGender() != null
						|| callDetailsReportRequest.getBenReport().getState() != null
						|| callDetailsReportRequest.getBenReport().getDistrict() != null
						|| callDetailsReportRequest.getBenReport().getPreferredLanguage() != null
						|| callDetailsReportRequest.getBenReport().getSexualOrientation() != null
						|| callDetailsReportRequest.getMinDOB() != null
						|| callDetailsReportRequest.getMaxDOB() != null)) {
			predicates.add(criteriaBuilder.isNotNull(root.get("beneficiaryRegID")));
			if (callDetailsReportRequest.getBenReport().getGender() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("gender")));
				predicates.add(criteriaBuilder.equal(benReport.get("gender"),
						callDetailsReportRequest.getBenReport().getGender()));
			}
			if (callDetailsReportRequest.getBenReport().getState() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("state")));
				predicates.add(criteriaBuilder.equal(benReport.get("state"),
						callDetailsReportRequest.getBenReport().getState()));
			}
			if (callDetailsReportRequest.getBenReport().getDistrict() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("district")));
				predicates.add(criteriaBuilder.equal(benReport.get("district"),
						callDetailsReportRequest.getBenReport().getDistrict()));
			}
			if (callDetailsReportRequest.getBenReport().getPreferredLanguage() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("preferredLanguage")));
				predicates.add(criteriaBuilder.equal(benReport.get("preferredLanguage"),
						callDetailsReportRequest.getBenReport().getPreferredLanguage()));
			}
			if (callDetailsReportRequest.getBenReport().getSexualOrientation() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("sexualOrientation")));
				predicates.add(criteriaBuilder.equal(benReport.get("sexualOrientation"),
						callDetailsReportRequest.getBenReport().getSexualOrientation()));
			}
			if (callDetailsReportRequest.getMinDOB() != null && callDetailsReportRequest.getMaxDOB() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("dob")));
				predicates.add(criteriaBuilder.between(benReport.get("dob"), callDetailsReportRequest.getMinDOB(),
						callDetailsReportRequest.getMaxDOB()));
			}
		}
		// add predicates to see more parameters
		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.desc(root.get("benCallID")));
		TypedQuery<CallDetailsReport> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public String getAllByAgeGroup(List<CallDetailsReport> callDetailsReportRequest) throws Exception {
		logger.debug("getAllByAgeGroup request: " + OutputMapper.gson().toJson(callDetailsReportRequest));
		JSONArray responseArray = new JSONArray();
		JSONObject result;
		Long totalCalls = 0L;
		int slNo = 1;
		for (CallDetailsReport callDetailsReport : callDetailsReportRequest) {
			result = new JSONObject();
			Timestamp maxDOB = CallDetailsReport.getDOB(callDetailsReport.getMinAge());
			Timestamp minDOB = CallDetailsReport.getDOB(callDetailsReport.getMaxAge());

			CallDetailsReport request = new CallDetailsReport();
			request.getBenReport().setState(callDetailsReport.getBenReport().getState());
			request.getBenReport().setDistrict(callDetailsReport.getBenReport().getDistrict());
			request.setStartTimestamp(callDetailsReport.getStartTimestamp());
			request.setEndTimestamp(callDetailsReport.getEndTimestamp());
			request.setProviderServiceMapID(callDetailsReport.getProviderServiceMapID());
			request.setMaxDOB(maxDOB);
			request.setMinDOB(minDOB);
			int resultSet = prepareTypedQuery(request).size();
			result.put("SlNo", slNo++);
			result.put("groupName", callDetailsReport.getMinAge() + " - " + callDetailsReport.getMaxAge());
			result.put("maxAge", callDetailsReport.getMaxAge());
			result.put("minAge", callDetailsReport.getMinAge());
			result.put("count", resultSet);
			responseArray.put(result);
			totalCalls += resultSet;
		}
		result = new JSONObject();
		result.put("SlNo", slNo++);
		result.put("groupName", "all");
		result.put("maxAge", 150);
		result.put("minAge", 0);
		result.put("count", totalCalls);
		responseArray.put(result);
		for (int index = 0; index < responseArray.length(); index++) {
			result = responseArray.getJSONObject(index);
			result.put("serviceProvidedRatio",
					(totalCalls > 0) ? format.format(result.getInt("count") * 100.00 / totalCalls) : 0);
		}
		logger.debug("getAllByAgeGroup response: " + responseArray);
		return responseArray.toString();
	}

	@Override
	public String getAllByGender(List<CallDetailsReport> callDetailsReportRequest) throws Exception {
		logger.debug("getAllByGender request: " + OutputMapper.gson().toJson(callDetailsReportRequest));
		JSONArray responseArray = new JSONArray();
		Long totalCalls = 0L;
		int slNo = 1;
		JSONObject result;
		for (CallDetailsReport callDetailsReport : callDetailsReportRequest) {
			result = new JSONObject();
			String gender = callDetailsReport.getBenReport().getGender();
			CallDetailsReport request = new CallDetailsReport();
			request.getBenReport().setState(callDetailsReport.getBenReport().getState());
			request.getBenReport().setDistrict(callDetailsReport.getBenReport().getDistrict());
			request.getBenReport().setGender(callDetailsReport.getBenReport().getGender());
			request.setStartTimestamp(callDetailsReport.getStartTimestamp());
			request.setEndTimestamp(callDetailsReport.getEndTimestamp());
			request.setProviderServiceMapID(callDetailsReport.getProviderServiceMapID());
			int resultSet = prepareTypedQuery(request).size();
			result = new JSONObject();
			result.put("SlNo", slNo++);
			result.put("gender", gender);
			result.put("count", resultSet);
			totalCalls += resultSet;
			responseArray.put(result);
		}
		result = new JSONObject();
		result.put("SlNo", slNo++);
		result.put("gender", "all");
		result.put("count", totalCalls);
		responseArray.put(result);
		for (int index = 0; index < responseArray.length(); index++) {
			result = responseArray.getJSONObject(index);
			result.put("serviceProvidedRatio",
					(totalCalls > 0) ? format.format(result.getInt("count") * 100.00 / totalCalls) : 0);
		}
		logger.debug("getAllByGender response: " + responseArray);
		return responseArray.toString();

	}

	@Override
	public String getAllBySexualOrientation(List<CallDetailsReport> callDetailsReportRequest) throws Exception {
		logger.debug("getAllBySexualOrientation request: " + OutputMapper.gson().toJson(callDetailsReportRequest));
		JSONArray responseArray = new JSONArray();
		Long totalCalls = 0L;
		int slNo = 1;
		JSONObject result;
		for (CallDetailsReport callDetailsReport : callDetailsReportRequest) {
			result = new JSONObject();
			String sexualOrientation = callDetailsReport.getBenReport().getSexualOrientation();

			CallDetailsReport request = new CallDetailsReport();
			request.getBenReport().setState(callDetailsReport.getBenReport().getState());
			request.getBenReport().setDistrict(callDetailsReport.getBenReport().getDistrict());
			request.setStartTimestamp(callDetailsReport.getStartTimestamp());
			request.setEndTimestamp(callDetailsReport.getEndTimestamp());
			request.setProviderServiceMapID(callDetailsReport.getProviderServiceMapID());
			request.getBenReport().setSexualOrientation(callDetailsReport.getBenReport().getSexualOrientation());
			int resultSet = prepareTypedQuery(request).size();
			result = new JSONObject();
			result.put("SlNo", slNo++);
			result.put("sexualOrientation", sexualOrientation);
			result.put("count", resultSet);
			totalCalls += resultSet;
			responseArray.put(result);
		}
		result = new JSONObject();
		result.put("SlNo", slNo++);
		result.put("sexualOrientation", "all");
		result.put("count", totalCalls);
		responseArray.put(result);
		for (int index = 0; index < responseArray.length(); index++) {
			result = responseArray.getJSONObject(index);
			result.put("serviceProvidedRatio",
					(totalCalls > 0) ? format.format(result.getInt("count") * 100.00 / totalCalls) : 0);
		}
		logger.debug("getAllBySexualOrientation response: " + responseArray);
		return responseArray.toString();
	}

	@Override
	public String getCountsByPreferredLanguage(List<CallDetailsReport> callDetailsReportRequest) throws Exception {
		logger.debug("getCountsByPreferredLanguage request: " + OutputMapper.gson().toJson(callDetailsReportRequest));
		JSONArray responseArray = new JSONArray();
		Long totalCalls = 0L;
		int slNo = 1;
		JSONObject result;
		for (CallDetailsReport callDetailsReport : callDetailsReportRequest) {
			result = new JSONObject();
			String preferredLanguage = callDetailsReport.getBenReport().getPreferredLanguage();
			CallDetailsReport request = new CallDetailsReport();
			request.getBenReport().setState(callDetailsReport.getBenReport().getState());
			request.getBenReport().setDistrict(callDetailsReport.getBenReport().getDistrict());
			request.setStartTimestamp(callDetailsReport.getStartTimestamp());
			request.setEndTimestamp(callDetailsReport.getEndTimestamp());
			request.setProviderServiceMapID(callDetailsReport.getProviderServiceMapID());
			request.getBenReport().setPreferredLanguage(callDetailsReport.getBenReport().getPreferredLanguage());
			int resultSet = prepareTypedQuery(request).size();
			result = new JSONObject();
			result.put("SlNo", slNo++);
			result.put("preferredLanguage", preferredLanguage);
			result.put("count", resultSet);
			totalCalls += resultSet;
			responseArray.put(result);
		}
		result = new JSONObject();
		result.put("SlNo", slNo++);
		result.put("preferredLanguage", "all");
		result.put("count", totalCalls);
		responseArray.put(result);
		for (int index = 0; index < responseArray.length(); index++) {
			result = responseArray.getJSONObject(index);
			result.put("serviceProvidedRatio",
					(totalCalls > 0) ? format.format(result.getInt("count") * 100.0 / totalCalls) : 0);
		}
		logger.debug("getCountsByPreferredLanguage response: " + responseArray);
		return responseArray.toString();
	}

	@Override
	public String getComplaintDetailReport(String request) throws Exception {
		logger.info("CallReportsServiceImpl.getComplaintDetailReport - start");

		FeedbackReport[] feedbackDetails = inputMapper.gson().fromJson(request, FeedbackReport[].class);
		List<FeedbackReport> requestList = Arrays.asList(feedbackDetails);
		ComplaintDetailReport report = null;
		List<ComplaintDetailReport> list = new ArrayList<ComplaintDetailReport>();

		Long genericGrievance = 0L;

		for (FeedbackReport feedback : requestList) {
			report = new ComplaintDetailReport();

			report.setTypeOfRequest(feedback.getFeedbackTypeName());

			if (feedback.getFeedbackNatureID() != null) {
				genericGrievance = crmCallReportRepository.getFeedbackByFeedbackNatureID(feedback.getStartDate(),
						feedback.getEndDate(), feedback.getProviderServiceMapID(), feedback.getFeedbackNatureID());
				report.setCountOfGrievance(genericGrievance);
			} else {
				genericGrievance = crmCallReportRepository.getFeedbackByFeedbackTypeID(feedback.getStartDate(),
						feedback.getEndDate(), feedback.getProviderServiceMapID(), feedback.getFeedbackTypeID());
				report.setCountOfGrievance(genericGrievance);
			}
			list.add(report);
		}
		logger.info("CallReportsServiceImpl.getComplaintDetailReport - end");
		return list.toString();
	}

	@Override
	public String getUnblockedUserReport(String request) throws Exception {
		logger.info("CallReportsServiceImpl.getUnblockedUserReport - start");
		logger.debug("getUnblockedUserReport request: " + OutputMapper.gson().toJson(request));
		UnBlockedPhoneReport phoneBlock = inputMapper.gson().fromJson(request, UnBlockedPhoneReport.class);
		List<UnBlockedPhoneReport> phoneBlockList = new ArrayList<UnBlockedPhoneReport>();
		List<UnBlockedUserReport> reportList = new ArrayList<UnBlockedUserReport>();

		phoneBlockList = crmCallReportRepository.getUnBlockedUser(phoneBlock.getBlockStartDate(),
				phoneBlock.getBlockEndDate(), phoneBlock.getProviderServiceMapID());
		Long slNo = 1L;

		for (UnBlockedPhoneReport phoneBlockUser : phoneBlockList) {
			UnBlockedUserReport report = mapper.mapUnblockedUserReport(phoneBlockUser);
			report.setSlNo(slNo++);
			reportList.add(report);
		}
		logger.debug("getUnblockedUserReport response: " + OutputMapper.gson().toJson(reportList));
		logger.info("CallReportsServiceImpl.getUnblockedUserReport - end");
		return reportList.toString();
	}

	@Override
	public String getCallQualityReport(String request) throws Exception {
		logger.info("CallReportsServiceImpl.getCallQualityReport - start");
		logger.debug("getCallQualityReport request: " + OutputMapper.gson().toJson(request));

		CallQualityReport callQualityReport = inputMapper.gson().fromJson(request, CallQualityReport.class);
		List<Objects[]> callQuality = null;

		if (callQualityReport.getSearchCriteria().equalsIgnoreCase("callTypeWise")) {
			List<CallTypeWiseReport> reportList = new ArrayList<CallTypeWiseReport>();

			CallTypeWiseReport callTypeWiseReport = null;

			if (callQualityReport.getCallTypeID() != null) {
				callQuality = crmCallReportRepository.getCallTypeWiseReportByCallTypeID(
						callQualityReport.getStartDate(), callQualityReport.getEndDate(),
						callQualityReport.getProviderServiceMapID(), callQualityReport.getCallTypeID());
			} else {
				callQuality = crmCallReportRepository.getCallTypeWiseReport(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID());
			}

			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 0) {

					Long count = (Long) objects[0];
					String type = (String) objects[1];

					if (type != null) {
						callTypeWiseReport = new CallTypeWiseReport();
						callTypeWiseReport.setCountOfCalls(count);
						callTypeWiseReport.setCallType(type);
						reportList.add(callTypeWiseReport);
					}
				}
			}

			return reportList.toString();
		} else if (callQualityReport.getSearchCriteria().equalsIgnoreCase("AgentWiseReport")) {
			List<AgentWiseReport> reportList = new ArrayList<AgentWiseReport>();

			AgentWiseReport agentWiseReport = null;

			if (callQualityReport.getUserID() != null) {
				callQuality = crmCallReportRepository.getAgentWiseReportByUserID(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID(),
						callQualityReport.getUserID());
			} else {
				callQuality = crmCallReportRepository.getAgentWiseReport(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID());
			}

			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 0) {

					Long count = (Long) objects[0];
					String empID = (String) objects[1];
					String first = (String) objects[2];
					String middle = (String) objects[3];
					String last = (String) objects[4];

					if (empID != null) {
						agentWiseReport = new AgentWiseReport();
						agentWiseReport.setCountOfCalls(count);
						agentWiseReport.setEmpID(empID);
						first = first + middle != null ? middle + " " : "" + last != null ? last + " " : "";
						agentWiseReport.setAgentName(first);
						reportList.add(agentWiseReport);
					}
				}
			}

			return reportList.toString();
		} else if (callQualityReport.getSearchCriteria().equalsIgnoreCase("SkillsetWiseReport")) {
			List<SkillSetWiseReport> reportList = new ArrayList<SkillSetWiseReport>();

			SkillSetWiseReport skillSetWiseReport = null;

			if (callQualityReport.getRoleID() != null) {
				callQuality = crmCallReportRepository.getSkillSetWiseReportByRoleID(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID(),
						callQualityReport.getRoleID());
			} else {
				callQuality = crmCallReportRepository.getSkillSetWiseReport(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID());
			}

			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 0) {

					Long count = (Long) objects[0];
					String skill = (String) objects[1];

					if (skill != null) {
						skillSetWiseReport = new SkillSetWiseReport();
						skillSetWiseReport.setCountOfSkillSet(count);
						skillSetWiseReport.setSkillSet(skill);
						reportList.add(skillSetWiseReport);
					}

				}
			}

			return reportList.toString();
		} else if (callQualityReport.getSearchCriteria().equalsIgnoreCase("DateWiseReport")) {
			List<DateWiseReport> reportList = new ArrayList<DateWiseReport>();

			DateWiseReport dateWiseReport = null;

			callQuality = crmCallReportRepository.getDateWiseReport(callQualityReport.getStartDate(),
					callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID());

			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 0) {
					dateWiseReport = new DateWiseReport();
					Long count = (Long) objects[0];
					Timestamp date = (Timestamp) objects[1];

					dateWiseReport.setCountOfCalls(count);
					dateWiseReport.setDate(date);

					reportList.add(dateWiseReport);
				}
			}

			return reportList.toString();
		} else if (callQualityReport.getSearchCriteria().equalsIgnoreCase("LocationWiseReport")) {
			List<LocationWiseReport> reportList = new ArrayList<LocationWiseReport>();

			LocationWiseReport locationWiseReport = null;

			if (callQualityReport.getWorkingLocationID() != null) {
				callQuality = crmCallReportRepository.getLocationWiseReportByLocationID(
						callQualityReport.getStartDate(), callQualityReport.getEndDate(),
						callQualityReport.getProviderServiceMapID(), callQualityReport.getWorkingLocationID());
			} else {
				callQuality = crmCallReportRepository.getLocationWiseReport(callQualityReport.getStartDate(),
						callQualityReport.getEndDate(), callQualityReport.getProviderServiceMapID());
			}

			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 0) {

					Long count = (Long) objects[0];
					String center = (String) objects[1];

					if (center != null) {
						locationWiseReport = new LocationWiseReport();
						locationWiseReport.setCountOfCalls(count);
						locationWiseReport.setCenter(center);
						reportList.add(locationWiseReport);
					}
				}
			}

			return reportList.toString();
		}

		return request;
	}

	@Override
	public String getDistrictWiseCallReport(String request) throws Exception {
		logger.info("CallReportsServiceImpl.getDistrictWiseCallReport - start");

		ArrayList<Map<String, Object>> responseList = new ArrayList<>();
		Map<String, Object> responseMap = null;


		CallQualityReport call = InputMapper.gson().fromJson(request, CallQualityReport.class);
		// System.out.println("hello");

		List<CallType> callTypes = crmCallReportRepository.getCallType(call.getProviderServiceMapID());

		List<Object[]> resultSet = crmCallReportRepository.districtWiseCallVolumeReport(call.getStartDate(),
				call.getEndDate(), call.getProviderServiceMapID(), call.getDistrictID());

		if (resultSet != null && resultSet.size() > 0) {
			Integer totalCount = 0;
			Integer maleCount = 0;
			Integer femaleCount = 0;
			for (Object[] objARR : resultSet) {
				if (responseMap == null || (responseMap.containsKey("District")
						&& !((String) responseMap.get("District")).equalsIgnoreCase((String) objARR[1]))) {

					totalCount = 0;
					maleCount = 0;
					femaleCount = 0;

					totalCount = ((BigInteger) objARR[5]).intValue();
					if (((String) objARR[4]).equalsIgnoreCase("Female"))
						femaleCount = ((BigInteger) objARR[5]).intValue();
					else if (((String) objARR[4]).equalsIgnoreCase("Male"))
						maleCount = ((BigInteger) objARR[5]).intValue();

					responseMap = new HashMap<>();
					responseMap.put("District", (String) objARR[1]);

					for (CallType callType : callTypes) {
						responseMap.put(callType.getCallType(), 0);
					}

					responseMap.put((String) objARR[3], ((BigInteger) objARR[5]).intValue());

					responseMap.put("Total Calls", totalCount);
					responseMap.put("Male", maleCount);
					responseMap.put("Female", femaleCount);

					responseList.add(responseMap);
				} else {

					totalCount += ((BigInteger) objARR[5]).intValue();
					if (((String) objARR[4]).equalsIgnoreCase("Female"))
						femaleCount += (((BigInteger) objARR[5]).intValue());
					else {
						if (((String) objARR[4]).equalsIgnoreCase("Male"))
							maleCount += ((BigInteger) objARR[5]).intValue();

					}

					if (responseMap.containsKey((String) objARR[3])) {

						Integer c1 = (Integer) responseMap.get((String) objARR[3]);
						c1 += ((BigInteger) objARR[5]).intValue();
						responseMap.put((String) objARR[3], c1);
					} else
						responseMap.put((String) objARR[3], ((BigInteger) objARR[5]).intValue());

					responseMap.put("Total Calls", totalCount);
					responseMap.put("Male", maleCount);
					responseMap.put("Female", femaleCount);

				}

			}
		}
		// System.out.println(new Gson().toJson(responseList));
		// System.out.println("hello end");
// -------------old code--------------------------
		/**
		 * List<CallType> callTypes =
		 * crmCallReportRepository.getCallType(call.getProviderServiceMapID());
		 * JSONArray responseArray = new JSONArray(); if (call.getDistrictID() != null)
		 * { Long size = prepareTypedQuerydistrictWise(call);
		 * 
		 * Long maleCallsize = prepareTypedQueryForMale(call); Long femaleCallsize =
		 * prepareTypedQueryForFemale(call);
		 * 
		 * JSONObject result = new JSONObject(); ;
		 * 
		 * result.put("District", call.getDistrict()); result.put("Total Calls", size);
		 * 
		 * for (CallType calltype : callTypes) { String callType =
		 * calltype.getCallType(); call.setCallTypeID(calltype.getCallTypeID()); Long
		 * sizeofCallType = prepareTypedQueryCallTypeWise(call);
		 * 
		 * result.put(callType, sizeofCallType); }
		 * 
		 * result.put("Male", maleCallsize); result.put("Female", femaleCallsize);
		 * 
		 * responseArray.put(result);
		 * 
		 * } else { Integer stateID =
		 * crmCallReportRepository.getStateByProvider(call.getProviderServiceMapID());
		 * List<Districts> list = crmCallReportRepository.getDistrictByStateID(stateID);
		 * JSONObject result; for (Districts district : list) {
		 * call.setDistrictID(Long.valueOf(district.getDistrictID())); Long size =
		 * prepareTypedQuerydistrictWise(call);
		 * 
		 * Long maleCallsize = prepareTypedQueryForMale(call); Long femaleCallsize =
		 * prepareTypedQueryForFemale(call);
		 * 
		 * result = new JSONObject();
		 * 
		 * result.put("District", district.getDistrictName()); result.put("Total Calls",
		 * size);
		 * 
		 * for (CallType calltype : callTypes) { String callType =
		 * calltype.getCallType(); call.setCallTypeID(calltype.getCallTypeID()); Long
		 * sizeofCallType = prepareTypedQueryCallTypeWise(call);
		 * 
		 * result.put(callType, sizeofCallType); }
		 * 
		 * result.put("Male", maleCallsize); result.put("Female", femaleCallsize);
		 * 
		 * responseArray.put(result); }
		 * 
		 * }
		 **/
		// ---------end old code -----------------------------------------

		logger.info("CallReportsServiceImpl.getDistrictWiseCallReport - end");
		return new Gson().toJson(responseList);
	}

	private Long prepareTypedQuerydistrictWise(CallQualityReport callQualityReport) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<CallQualityReport> root = criteriaQuery.from(CallQualityReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), callQualityReport.getStartDate(),
				callQualityReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), callQualityReport.getProviderServiceMapID()));

		Join<CallQualityReport, BenDetails> benReport = root.join("benReport", JoinType.INNER);

		Join<CallQualityReport, UserReport> userReport = root.join("userReportObj", JoinType.INNER);
		Join<UserReport, UserServiceRoleReport> userServiceRoleReport = userReport.join("userServiceRoleReport",
				JoinType.INNER);
		Join<UserServiceRoleReport, WorkLocation> workLocation = userServiceRoleReport.join("workLocation",
				JoinType.INNER);

		if (callQualityReport.getRoleID() != null || callQualityReport.getLocationID() != null
				|| callQualityReport.getDistrictID() != null || callQualityReport.getSubdistrictID() != null
				|| callQualityReport.getVillageID() != null) {

			predicates.add(criteriaBuilder.isNotNull(root.get("beneficiaryRegID")));

			if (callQualityReport.getDistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("districtID")));
				predicates.add(criteriaBuilder.equal(benReport.get("districtID"), callQualityReport.getDistrictID()));
			}
			if (callQualityReport.getSubdistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("subDistrictID")));
				predicates.add(
						criteriaBuilder.equal(benReport.get("subDistrictID"), callQualityReport.getSubdistrictID()));
			}
			if (callQualityReport.getVillageID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("permVillageId")));
				predicates.add(criteriaBuilder.equal(benReport.get("permVillageId"), callQualityReport.getVillageID()));
			}
			if (callQualityReport.getRoleID() != null) {
				predicates.add(criteriaBuilder.isNotNull(userServiceRoleReport.get("roleID")));
				predicates
						.add(criteriaBuilder.equal(userServiceRoleReport.get("roleID"), callQualityReport.getRoleID()));
			}
			if (callQualityReport.getLocationID() != null) {
				predicates.add(criteriaBuilder.isNotNull(workLocation.get("psAddMapID")));
				predicates
						.add(criteriaBuilder.equal(workLocation.get("psAddMapID"), callQualityReport.getLocationID()));
			}

		}
		criteriaQuery.multiselect(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.desc(root.get("factBenCallID")));
		TypedQuery<Long> count = entityManager.createQuery(criteriaQuery);
		return count.getSingleResult();
	}

	private Long prepareTypedQueryForMale(CallQualityReport callQualityReport) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<CallQualityReport> root = criteriaQuery.from(CallQualityReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), callQualityReport.getStartDate(),
				callQualityReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), callQualityReport.getProviderServiceMapID()));

		Join<CallQualityReport, BenDetails> benReport = root.join("benReport", JoinType.INNER);

		Join<CallQualityReport, UserReport> userReport = root.join("userReportObj", JoinType.INNER);
		Join<UserReport, UserServiceRoleReport> userServiceRoleReport = userReport.join("userServiceRoleReport",
				JoinType.INNER);
		Join<UserServiceRoleReport, WorkLocation> workLocation = userServiceRoleReport.join("workLocation",
				JoinType.INNER);

		if (callQualityReport.getRoleID() != null || callQualityReport.getLocationID() != null
				|| callQualityReport.getDistrictID() != null || callQualityReport.getSubdistrictID() != null
				|| callQualityReport.getVillageID() != null) {

			predicates.add(criteriaBuilder.isNotNull(root.get("beneficiaryRegID")));

			if (callQualityReport.getDistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("districtID")));
				predicates.add(criteriaBuilder.equal(benReport.get("districtID"), callQualityReport.getDistrictID()));
			}
			if (callQualityReport.getSubdistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("subDistrictID")));
				predicates.add(
						criteriaBuilder.equal(benReport.get("subDistrictID"), callQualityReport.getSubdistrictID()));
			}
			if (callQualityReport.getVillageID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("permVillageId")));
				predicates.add(criteriaBuilder.equal(benReport.get("permVillageId"), callQualityReport.getVillageID()));
			}
			if (callQualityReport.getRoleID() != null) {
				predicates.add(criteriaBuilder.isNotNull(userServiceRoleReport.get("roleID")));
				predicates
						.add(criteriaBuilder.equal(userServiceRoleReport.get("roleID"), callQualityReport.getRoleID()));
			}
			if (callQualityReport.getLocationID() != null) {
				predicates.add(criteriaBuilder.isNotNull(workLocation.get("psAddMapID")));
				predicates
						.add(criteriaBuilder.equal(workLocation.get("psAddMapID"), callQualityReport.getLocationID()));
			}

		}

		predicates.add(criteriaBuilder.equal(benReport.get("genderID"), 1));

		criteriaQuery.multiselect(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.desc(root.get("factBenCallID")));
		TypedQuery<Long> count = entityManager.createQuery(criteriaQuery);
		return count.getSingleResult();
	}

	private Long prepareTypedQueryForFemale(CallQualityReport callQualityReport) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<CallQualityReport> root = criteriaQuery.from(CallQualityReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), callQualityReport.getStartDate(),
				callQualityReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), callQualityReport.getProviderServiceMapID()));

		Join<CallQualityReport, BenDetails> benReport = root.join("benReport", JoinType.INNER);

		Join<CallQualityReport, UserReport> userReport = root.join("userReportObj", JoinType.INNER);
		Join<UserReport, UserServiceRoleReport> userServiceRoleReport = userReport.join("userServiceRoleReport",
				JoinType.INNER);
		Join<UserServiceRoleReport, WorkLocation> workLocation = userServiceRoleReport.join("workLocation",
				JoinType.INNER);

		if (callQualityReport.getRoleID() != null || callQualityReport.getLocationID() != null
				|| callQualityReport.getDistrictID() != null || callQualityReport.getSubdistrictID() != null
				|| callQualityReport.getVillageID() != null) {

			predicates.add(criteriaBuilder.isNotNull(root.get("beneficiaryRegID")));

			if (callQualityReport.getDistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("districtID")));
				predicates.add(criteriaBuilder.equal(benReport.get("districtID"), callQualityReport.getDistrictID()));
			}
			if (callQualityReport.getSubdistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("subDistrictID")));
				predicates.add(
						criteriaBuilder.equal(benReport.get("subDistrictID"), callQualityReport.getSubdistrictID()));
			}
			if (callQualityReport.getVillageID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("permVillageId")));
				predicates.add(criteriaBuilder.equal(benReport.get("permVillageId"), callQualityReport.getVillageID()));
			}
			if (callQualityReport.getRoleID() != null) {
				predicates.add(criteriaBuilder.isNotNull(userServiceRoleReport.get("roleID")));
				predicates
						.add(criteriaBuilder.equal(userServiceRoleReport.get("roleID"), callQualityReport.getRoleID()));
			}
			if (callQualityReport.getLocationID() != null) {
				predicates.add(criteriaBuilder.isNotNull(workLocation.get("psAddMapID")));
				predicates
						.add(criteriaBuilder.equal(workLocation.get("psAddMapID"), callQualityReport.getLocationID()));
			}

		}

		predicates.add(criteriaBuilder.equal(benReport.get("genderID"), 2));

		criteriaQuery.multiselect(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.desc(root.get("factBenCallID")));
		TypedQuery<Long> count = entityManager.createQuery(criteriaQuery);
		return count.getSingleResult();
	}

	private Long prepareTypedQueryCallTypeWise(CallQualityReport callQualityReport) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<CallQualityReport> root = criteriaQuery.from(CallQualityReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), callQualityReport.getStartDate(),
				callQualityReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), callQualityReport.getProviderServiceMapID()));
		predicates.add(criteriaBuilder.equal(root.get("callTypeID"), callQualityReport.getCallTypeID()));

		Join<CallQualityReport, BenDetails> benReport = root.join("benReport", JoinType.INNER);

		Join<CallQualityReport, UserReport> userReport = root.join("userReportObj", JoinType.INNER);
		Join<UserReport, UserServiceRoleReport> userServiceRoleReport = userReport.join("userServiceRoleReport",
				JoinType.INNER);
		Join<UserServiceRoleReport, WorkLocation> workLocation = userServiceRoleReport.join("workLocation",
				JoinType.INNER);

		if (callQualityReport.getRoleID() != null || callQualityReport.getLocationID() != null
				|| callQualityReport.getDistrictID() != null || callQualityReport.getSubdistrictID() != null
				|| callQualityReport.getVillageID() != null) {

			predicates.add(criteriaBuilder.isNotNull(root.get("beneficiaryRegID")));

			if (callQualityReport.getDistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("districtID")));
				predicates.add(criteriaBuilder.equal(benReport.get("districtID"), callQualityReport.getDistrictID()));
			}
			if (callQualityReport.getSubdistrictID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("subDistrictID")));
				predicates.add(
						criteriaBuilder.equal(benReport.get("subDistrictID"), callQualityReport.getSubdistrictID()));
			}
			if (callQualityReport.getVillageID() != null) {
				predicates.add(criteriaBuilder.isNotNull(benReport.get("permVillageId")));
				predicates.add(criteriaBuilder.equal(benReport.get("permVillageId"), callQualityReport.getVillageID()));
			}
			if (callQualityReport.getRoleID() != null) {
				predicates.add(criteriaBuilder.isNotNull(userServiceRoleReport.get("roleID")));
				predicates
						.add(criteriaBuilder.equal(userServiceRoleReport.get("roleID"), callQualityReport.getRoleID()));
			}
			if (callQualityReport.getLocationID() != null) {
				predicates.add(criteriaBuilder.isNotNull(workLocation.get("psAddMapID")));
				predicates
						.add(criteriaBuilder.equal(workLocation.get("psAddMapID"), callQualityReport.getLocationID()));
			}

		}
		criteriaQuery.multiselect(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.desc(root.get("factBenCallID")));
		TypedQuery<Long> count = entityManager.createQuery(criteriaQuery);
		return count.getSingleResult();
	}

	@Override
	public String getQualityReport(String request) throws Exception {
		logger.debug("getQualityReport request: " + request);
		MedHistory benmedhistoryReport = inputMapper.gson().fromJson(request, MedHistory.class);
		String output = "";
		switch (benmedhistoryReport.getReportTypeID()) {
		case 1:
			return getDSusedValidCallAtHAO(benmedhistoryReport);// compare with ID

		case 2:
			return getHAHTDisconnectedCalls(benmedhistoryReport);

		case 3:
			return getHAHTValidClosedCalls(benmedhistoryReport);

		case 4:
			return getLAHTAlgorithmCalls(benmedhistoryReport);

		case 5:
			return getLAHTTransferCallsAtMO(benmedhistoryReport);

		case 6:
			return getOtherAdviceCalls(benmedhistoryReport);

		case 7:
			return getRandomPickup(benmedhistoryReport);

		case 8:
			return getPreviousQualityReport(benmedhistoryReport);

		default:
			throw new IEMRException("Invalid Report type");
		}
	}

	private String getHAHTDisconnectedCalls(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "Incomplete",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
		// List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
		// if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getHAHTDisconnectedCalls("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "Incomplete", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
		// }
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getRandomPickup(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getRandomPickup("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
//		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getOtherAdviceCalls(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel2> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getOtherAdviceCalls("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel2().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9],
						(String) object[10]));

			}
		}
//		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getLAHTTransferCallsAtMO(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getLAHTTransferCallsMO("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
//		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getLAHTAlgorithmCalls(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getLAHTAlgorithmCalls("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
//		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getDSusedValidCallAtHAO(MedHistory benmedhistoryReport) {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					///callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getDSusedValidCallAtHAO("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		logger.info("resultset" + resultSet);
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
		// }
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);

	}

	public String getPreviousQualityReport(MedHistory benmedhistoryReport) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CallReport> criteriaQuery = criteriaBuilder.createQuery(CallReport.class);
		Root<CallReport> root = criteriaQuery.from(CallReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), benmedhistoryReport.getProviderServiceMapID()));

		// Join<CallReport, DimUserReport> userReport = root.join("userReportObj",
		// JoinType.INNER);
		// Join<DimUserReport, UserServiceRoleReport> userServiceRoleReport =
		// userReport.join("userServiceRoleReport", JoinType.INNER);
		// predicates.add(criteriaBuilder.equal(userServiceRoleReport.get("deleted"),false));

		if (benmedhistoryReport.getRoleName() != null || benmedhistoryReport.getAgentID() != null) {
			if (benmedhistoryReport.getAgentID() != null) {
				predicates.add(criteriaBuilder.equal(root.get("agentID"), benmedhistoryReport.getAgentID()));
			}

			if (benmedhistoryReport.getRoleName() != null) {
				// predicates.add(criteriaBuilder.isNotNull(userServiceRoleReport.get("roleID")));
				predicates.add(criteriaBuilder.equal(root.get("receivedRoleName"), benmedhistoryReport.getRoleName()));
			}
		}

		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}));
		TypedQuery<CallReport> typedQuery = entityManager.createQuery(criteriaQuery);
		List<CallReport> list = typedQuery.getResultList();
		List<QualityReportModel> modelList = new ArrayList<>();

		if (!list.isEmpty()) {
			List<Long> benList = new ArrayList<>();

			for (CallReport call : list) {
				benList.add(call.getBenCallID());
			}
			List<MedHistory> medHistoryLists = crmCallReportRepository.getMedicalHistoryByBenIDs(benList);

			Map<Long, StringJoiner> mapSummary = new HashMap<>();
			Map<Long, StringJoiner> mapDigonosis = new HashMap<>();

			StringJoiner symptom = null;
			StringJoiner digonosis = null;

			for (MedHistory history : medHistoryLists) {
				if (mapSummary.get(history.getBenCallID()) == null) {
					symptom = new StringJoiner(", ");
					symptom.add(history.getDiseaseSummary());
					mapSummary.put(history.getBenCallID(), symptom);

					digonosis = new StringJoiner(", ");
					digonosis.add(history.getSelecteDiagnosis());
					mapDigonosis.put(history.getBenCallID(), digonosis);
				} else {
					StringJoiner symptom1 = mapSummary.get(history.getBenCallID());
					symptom1.add(history.getDiseaseSummary());

					StringJoiner digonosis1 = mapDigonosis.get(history.getBenCallID());
					digonosis1.add(history.getSelecteDiagnosis());
				}

			}

			Long sNo = 1l;
			list.parallelStream().forEach(call -> {

				if (call.getCallID() != null) {
					String callDuartion = null;

					String callinfoapiURL = this.callinfoapiURL;
					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
							.replace("PHONE_NO", call.getPhoneNo());

					logger.info("calling CTI API url: " + URL);
					String ctiResponse = this.callUrl(URL);
					logger.info("calling CTI API returned " + ctiResponse);

					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
					CTIResponse model = data.getResponse();

					if (model.getResponse_code().equals("1")) {
						callDuartion = model.getCall_duration();
					}

					call.setCallDuartion(callDuartion);
				}
			});

			for (CallReport call : list) {
				DimUserReport user = call.getUserReportObj();
				symptom = mapSummary.get(call.getBenCallID());
				digonosis = mapDigonosis.get(call.getBenCallID());

				String symp = null;
				if (symptom != null) {
					symp = symptom.toString();
				}
				String dia = null;
				if (digonosis != null) {
					dia = digonosis.toString();
				}
				modelList.add(new QualityReportModel(sNo++, call.getCreatedDate(), call.getPhoneNo(), call.getAgentID(),
						user.getFirstName(), call.getReceivedRoleName(), symp, dia, call.getRemarks(),
						call.getCallTypeName(), call.getCallSubTypeName(), call.getCallDuartion() + " " + "sec",
						call.getRecordingFilePath()));
			}

		}

		return modelList.toString();

	}

	public int getTimeInSeconds(String st) {
//		String st="03 hours 2 mins 9 secs";
		String[] units = st.split(" ");
		int hourtosec = 0, mintosec = 0, sec = 0;
		if (units.length > 1) {
			for (int i = 0; i < units.length; i++) {
				if (Character.isLetter(units[i].charAt(0))) {
					if (units[i].equalsIgnoreCase("hours"))
						hourtosec = Integer.parseInt(units[i - 1]) * 3600;
					else if (units[i].equalsIgnoreCase("mins"))
						mintosec = Integer.parseInt(units[i - 1]) * 60;
					else if (units[i].equalsIgnoreCase("secs"))
						sec = Integer.parseInt(units[i - 1]);
				}

			}
			return (hourtosec + mintosec + sec);
		} else
			return Integer.parseInt(st);

	}

	public String getHAHTValidClosedCalls(MedHistory benmedhistoryReport) throws Exception {
		List<Objects[]> resultSet = null;
//		List<CallReport> list = crmCallReportRepository.getAllBenCallIDs("HYBRID HAO", "valid",
//				benmedhistoryReport.getStartDate(), benmedhistoryReport.getEndDate());
//		List<QaReportModel> modelList = new ArrayList<>();
		List<QaReportModel> requestObj = new ArrayList<>();
//		if (!list.isEmpty()) {
//			List<Long> benList = new ArrayList<>();
//
//			for (CallReport call : list) {
//				if (call.getCallID() != null) {
//					String callDuartion = null;
//
//					String callinfoapiURL = this.callinfoapiURL;
//					String URL = callinfoapiURL.replace("CTI_SERVER", ctiServerIP)
//							.replace("AGENT_ID", call.getAgentID()).replace("SESSION_ID", call.getCallID())
//							.replace("PHONE_NO", call.getPhoneNo());
//
//					logger.info("calling CTI API url: " + URL);
//					String ctiResponse = this.callUrl(URL);
//					logger.info("calling CTI API returned " + ctiResponse);
//
//					CTIData data = InputMapper.gson().fromJson(ctiResponse, CTIData.class);
//					CTIResponse model = data.getResponse();
//
//					if (model.getResponse_code().equals("1")) {
//						callDuartion = model.getCall_duration();
//					}
//
//					// call.setCallDuration(Integer.toString(getTimeInSeconds(callDuartion)));
//					call.setCallDuration(callDuartion);
//					//callReportRepo.save(call);
//				}
//
//			}
		Long sNo = 1l;
		resultSet = crmCallReportRepository.getHAHTValidCalls("HYBRID HAO", benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate(), "valid", benmedhistoryReport.getProviderServiceMapID());
		for (Object[] object : resultSet) {
			if (object != null && object.length >= 8) {
				requestObj.add(new QaReportModel().getModel(sNo++, (Timestamp) object[0], (String) object[1],
						(String) object[2], (String) object[3], (String) object[4], (String) object[5],
						(String) object[6], (String) object[7], (Integer) object[8], (String) object[9]));

			}
		}
		// }
		return OutputMapper.gsonWithoutExposeRestriction().toJson(requestObj);
	}

	private static HttpUtils httpUtils;

	public CallReportsServiceImpl() {
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
	public String getCallSummaryReport(String request) throws Exception {
		logger.debug("getCallSummaryReport request: " + request);
		MedHistory benmedhistoryReport = inputMapper.gson().fromJson(request, MedHistory.class);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CallReport> criteriaQuery = criteriaBuilder.createQuery(CallReport.class);
		Root<CallReport> root = criteriaQuery.from(CallReport.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(criteriaBuilder.between(root.get("createdDate"), benmedhistoryReport.getStartDate(),
				benmedhistoryReport.getEndDate()));
		predicates.add(
				criteriaBuilder.equal(root.get("providerServiceMapID"), benmedhistoryReport.getProviderServiceMapID()));
		predicates.add(criteriaBuilder.isNotNull(root.get("callTypeID")));

		// Join<CallReport, DimUserReport> userReport = root.join("userReportObj",
		// JoinType.INNER);
		// Join<DimUserReport, UserServiceRoleReport> userServiceRoleReport =
		// userReport.join("userServiceRoleReport", JoinType.INNER);
		// predicates.add(criteriaBuilder.equal(userServiceRoleReport.get("deleted"),false));

		if (benmedhistoryReport.getRoleName() != null || benmedhistoryReport.getAgentID() != null
				|| benmedhistoryReport.getCallTypeID() != null || benmedhistoryReport.getCallTypeName() != null) {
			if (benmedhistoryReport.getAgentID() != null) {
				predicates.add(criteriaBuilder.equal(root.get("agentID"), benmedhistoryReport.getAgentID()));
			}

			if (benmedhistoryReport.getRoleName() != null && benmedhistoryReport.getRoleName() != "") {
				predicates.add(criteriaBuilder.equal(root.get("receivedRoleName"), benmedhistoryReport.getRoleName()));
			}
			if (benmedhistoryReport.getCallTypeID() != null) {
				predicates.add(criteriaBuilder.equal(root.get("callTypeID"), benmedhistoryReport.getCallTypeID()));
			} else if (benmedhistoryReport.getCallTypeName() != null) {
				predicates.add(criteriaBuilder.equal(root.get("callTypeName"), benmedhistoryReport.getCallTypeName()));
			}
		}

		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}));
		TypedQuery<CallReport> typedQuery = entityManager.createQuery(criteriaQuery);
		List<CallReport> list = typedQuery.getResultList();
		Long sNo = 1l;
		List<CallSummaryReport> modelList = new ArrayList<>();
		for (CallReport call : list) {
			DimUserReport user = call.getUserReportObj();

			modelList.add(new CallSummaryReport(sNo++, call.getCreatedDate(), call.getPhoneNo(), call.getAgentID(),
					user.getFirstName(), call.getReceivedRoleName(), call.getCallTypeName(), call.getCallSubTypeName(),
					call.getProviderServiceMapID(), call.getRemarks()));
		}

		return modelList.toString();
	}
}
