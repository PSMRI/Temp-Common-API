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
package com.iemr.common.service.everwell;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.data.everwell.EverwellAllocateMultiple;
import com.iemr.common.data.everwell.EverwellDetails;
import com.iemr.common.data.everwell.EverwellFeedback;
import com.iemr.common.repository.callhandling.OutboundCallRequestRepository;
import com.iemr.common.repository.everwell.EverwellCallHandlingRepository;
import com.iemr.common.repository.everwell.EverwellFeedbackRepo;
import com.iemr.common.service.callhandling.BeneficiaryCallServiceImpl;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

@Service
@PropertySource("classpath:application.properties")
public class EverwellCallHandlingServiceImpl implements EverwellCallHandlingService {
	private InputMapper inputMapper = new InputMapper();
	@Value("${everwellCalendarDuration}")
	private String everwellCalendarDuration;
	private Logger logger = LoggerFactory.getLogger(BeneficiaryCallServiceImpl.class);
	@Autowired
	private EverwellCallHandlingRepository everwellCallHandlingRepository;
	@Autowired
	private OutboundCallRequestRepository outboundCallHandlingRepository;
	@Autowired
	private EverwellFeedbackRepo everwellFeedbackRepo;

	@Value("${callRetryConfiguration}")
	private int callRetryConfiguration;

	@Override
	public String outboundCallCount(String request) throws IEMRException, JSONException {
		logger.debug("Request received for outboundCallCount: " + request);
		EverwellDetails outboundCallRequest = InputMapper.gson().fromJson(request, EverwellDetails.class);
		Calendar cal = Calendar.getInstance();
		Timestamp startDate = new Timestamp(cal.getTimeInMillis());
		cal.add(Calendar.DATE, 7);
		Timestamp lastDate = new Timestamp(cal.getTimeInMillis());
		Set<Objects[]> resultSet = null;
		startDate = (outboundCallRequest.getFilterStartDate() != null) ? outboundCallRequest.getFilterStartDate()
				: startDate;
		lastDate = (outboundCallRequest.getFilterEndDate() != null) ? outboundCallRequest.getFilterEndDate() : lastDate;
		String selectedLanguage = outboundCallRequest.getPreferredLanguageName();
		Integer agentid = outboundCallRequest.getAgentId();
		int c = 0;
		if (agentid != null) {
			resultSet = everwellCallHandlingRepository.outboundCallCount(outboundCallRequest.getProviderServiceMapId(),
					agentid);
		} else if (selectedLanguage != null) {
			resultSet = everwellCallHandlingRepository.outboundCallCount(outboundCallRequest.getProviderServiceMapId(),
					startDate, lastDate, selectedLanguage);
		} else
			resultSet = everwellCallHandlingRepository.outboundCallCount(outboundCallRequest.getProviderServiceMapId(),
					startDate, lastDate);
		JSONObject result = new JSONObject();
		if (selectedLanguage == null) {
			result.put("All", 0);
		} else {
			result.put(selectedLanguage, 0);
		}
		if (resultSet != null && resultSet.size() > 0) {
			for (Object[] objects : resultSet) {
				if (objects.length >= 2) {
					result.put(((String) objects[0]).trim(), objects[1]);
					if (selectedLanguage == null) {
						result.put("All", (result.getLong("All") + (Long) objects[1]));
					}
				}
			}
		}
		JSONArray resultArray = new JSONArray();
		Iterator<String> languages = result.keys();
		while (languages.hasNext()) {
			String language = languages.next();
			JSONObject temp = new JSONObject();
			temp.put("language", language);
			temp.put("count", result.getLong(language));
			resultArray.put(temp);
		}
		return resultArray.toString();
//			JSONArray resultArray = new JSONArray();		
//				JSONObject temp = new JSONObject();
//				temp.put("language", "All");
//				temp.put("count",c);
//				resultArray.put(temp);
//			return resultArray.toString();
		// return Integer.toString(c);
	}

	@Override
	public String outboundAllocation(String request) throws IEMRException {
		EverwellAllocateMultiple allocation = inputMapper.gson().fromJson(request, EverwellAllocateMultiple.class);
		EverwellDetails[] callRequests = allocation.getOutboundCallRequests();
		Integer count = 0;
		logger.debug("reading object: ", allocation.toString());
		int c = 0;
		for (int userIndex = 0; userIndex < allocation.getAgentId().size(); userIndex++) {
			Integer AgentID = allocation.getAgentId().get(userIndex);
			int outboundLastCall = userIndex * allocation.getAllocateNo() + allocation.getAllocateNo();
			List<Long> outboundCalls = new ArrayList<Long>();
			for (int outboundCallIndex = userIndex * allocation.getAllocateNo(); outboundCallIndex < outboundLastCall
					&& outboundCallIndex < callRequests.length; outboundCallIndex++) {
				outboundCalls.add(callRequests[outboundCallIndex].getEapiId());
			}
			logger.debug("Agentid and outbound call id: ",
					allocation.getAgentId().get(userIndex) + " : " + outboundCalls);

			everwellCallHandlingRepository.allocateCalls(AgentID, outboundCalls);
			count += outboundCalls.size();
		}
		// }
		return count.toString();

	}

	@Override
	public String outboundCallList(String request) throws IEMRException {
		EverwellDetails callRequest = inputMapper.gson().fromJson(request, EverwellDetails.class);
		List<EverwellDetails> outboundCallRequests = new ArrayList<EverwellDetails>();
		List<Objects[]> resultSet = null;
		Calendar cal = Calendar.getInstance();
		Timestamp startDate = new Timestamp(cal.getTimeInMillis());
		cal.add(Calendar.DATE, 7);
		Timestamp lastDate = new Timestamp(cal.getTimeInMillis());
		startDate = (callRequest.getFilterStartDate() != null) ? callRequest.getFilterStartDate() : startDate;
		lastDate = (callRequest.getFilterEndDate() != null) ? callRequest.getFilterEndDate() : lastDate;
		Integer agentid = callRequest.getAgentId();
		String selectedLanguage = callRequest.getPreferredLanguageName();

		if (agentid != null) {
			if (selectedLanguage != null)
				resultSet = everwellCallHandlingRepository.getAllOutboundCalls(callRequest.getProviderServiceMapId(),
						agentid, selectedLanguage);
			else
				resultSet = everwellCallHandlingRepository.getAllOutboundCalls(callRequest.getProviderServiceMapId(),
						agentid);
		} else if (selectedLanguage != null) {
			resultSet = everwellCallHandlingRepository.getAllOutboundCalls(callRequest.getProviderServiceMapId(),
					startDate, lastDate, selectedLanguage);
		} else
			resultSet = everwellCallHandlingRepository.getAllOutboundCalls(callRequest.getProviderServiceMapId(),
					startDate, lastDate);

		Map<Long, Long> responseMap = new HashMap<Long, Long>();

		for (Object[] object : resultSet) {

			if (object != null && object.length >= 22) {

				if (!responseMap.containsKey((Long) object[1])) {
					responseMap.put((Long) object[1], (Long) object[3]);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
					String lastCall = simpleDateFormat.format((Timestamp) object[8]);
//					System.out.println(str2);

					outboundCallRequests.add(new EverwellDetails().getOutboundCall((Long) object[0], (Long) object[1],
							(Integer) object[2], (Long) object[3], (Integer) object[4], (String) object[5],
							(String) object[6], (String) object[7], (Timestamp) object[8], (Integer) object[9],
							(String) object[10], (String) object[11], (Integer) object[12], (String) object[13],
							(String) object[14], (String) object[15], (Timestamp) object[16], (String) object[17],
							(String) object[18], (Timestamp) object[19], (String) object[20], (String) object[21],
							(Long) object[22], (Integer) object[23], (Boolean) object[24], (Integer) object[25],
							lastCall, (Integer) object[26], (String) object[27]));
				}

			}
		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(outboundCallRequests);

//		for (Object[] object : resultSet) {
//			if (object != null && object.length >= 22) {
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
//				String lastCall = simpleDateFormat.format((Timestamp) object[8]);
////				System.out.println(str2);
//				outboundCallRequests.add(new EverwellDetails().getOutboundCall((Long) object[0], (Long) object[1],
//						(Integer) object[2], (Long) object[3], (Integer) object[4], (String) object[5],
//						(String) object[6], (String) object[7], (Timestamp) object[8], (Integer) object[9],
//						(String) object[10], (String) object[11], (Integer) object[12], (String) object[13],
//						(String) object[14], (String) object[15], (Timestamp) object[16], (String) object[17],
//						(String) object[18], (Timestamp) object[19], (String) object[20], (String) object[21],
//						(Long) object[22], (Integer) object[23],(Boolean) object[24],(Integer) object[25],lastCall));
//
//			}
//		}

		// return OutputMapper.gsonWithoutExposeRestriction().toJson(resultSet);
		// return new Gson().toJson(resultSet);

	}

	@Override
	public String resetOutboundCall(String request) throws IEMRException {
		logger.debug("Request received for resetOutboundCall: " + request);
		EverwellDetails outboundCallRequest = inputMapper.gson().fromJson(request, EverwellDetails.class);
		Integer count = everwellCallHandlingRepository.resetOutboundCall(outboundCallRequest.getEAPIIDs());
		logger.debug("Respone from resetOutboundCall: " + count);
		return count.toString();
	}
//	@Override
//	public String saveDetails(String request) throws IEMRException {
//		logger.debug("Request received for resetOutboundCall: " + request);
//		EverwellFeedback outboundCallRequest = inputMapper.gson().fromJson(request, EverwellFeedback.class);
//		//(@Param("eapiId") Integer eapiId,@Param("missedDoses") Integer missedDoses,@Param("category") Integer category,@Param("subCategory") Integer subCategory,@Param("actionTaken") Integer actionTaken,@Param("adherencePercentage") Integer adherencePercentage,@Param("comments") Integer comments)
////		 Integer count = everwellCallHandlingRepository.saveDetails(outboundCallRequest.getEapiId(),outboundCallRequest.getMissedDoses(),outboundCallRequest.getCategory(),
////				 outboundCallRequest.getSubCategory(),outboundCallRequest.getActionTaken(),outboundCallRequest.getAdherencePercentage(),outboundCallRequest.getComments(),outboundCallRequest.getDateOfAction());
////		logger.debug("Respone from saveDetails: " + outboundCallRequest);
//		
//		EverwellFeedback saveResponse = everwellFeedbackRepo.save(outboundCallRequest);
//		if(saveResponse != null)
//			return "Data saved successfully";
//		else
//			return "Data not saved successfully";
//	}

	@Override
	public String saveDetails(String request) throws IEMRException, ParseException {
		logger.debug("Request received for resetOutboundCall: " + request);
		int c = 0;
		EverwellFeedback outboundCallRequest = InputMapper.gson().fromJson(request, EverwellFeedback.class);
		if (outboundCallRequest.getEfid() == null) {
			ArrayList<EverwellFeedback> result = everwellFeedbackRepo.getExistingRecords(outboundCallRequest.getId(),
					outboundCallRequest.getDateOfAction());
			if (result != null && result.size() > 0) {
				if (result.get(0) != null && result.get(0).getEfid() != null)
					outboundCallRequest.setEfid(result.get(0).getEfid());
			}
		}
		if (outboundCallRequest.getEfid() != null) {
			outboundCallRequest.setProcessed("U");
		}
		EverwellFeedback saveResponse = everwellFeedbackRepo.save(outboundCallRequest);

		if ((outboundCallRequest.getSubCategory().equalsIgnoreCase("Dose not taken")
				|| outboundCallRequest.getSubCategory().equalsIgnoreCase("Dose taken but not reported by technology")
				|| outboundCallRequest.getSubCategory().equalsIgnoreCase("Wrong phone number")
				|| outboundCallRequest.getSubCategory().equalsIgnoreCase("Do not disturb for today"))
				&& outboundCallRequest.getComments() != null) {
			Boolean retryNeeded = false;
			c = everwellCallHandlingRepository.updateRetryNeededAsFalseEverwellDetails(outboundCallRequest.getEapiId(),
					retryNeeded);
		}
//		else if((outboundCallRequest.getSubCategory().equalsIgnoreCase("Phone not reachable")
//				|| outboundCallRequest.getSubCategory().equalsIgnoreCase("Phone switched off")
//				|| outboundCallRequest.getSubCategory().equalsIgnoreCase("Did not receive the call"))
//						&& outboundCallRequest.getComments() != null) {
//			Boolean retryNeeded = true;
//			c = everwellCallHandlingRepository.updateRetryNeededAsTrueEverwellDetails(outboundCallRequest.getEapiId(),retryNeeded,
//					outboundCallRequest.getComments());
//		}
		else {

			Boolean retryNeeded = true;
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String text = sqlDate.toString();

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			// todayDate
			Calendar calendart = Calendar.getInstance();
			calendart.setTime(sqlDate);
			calendart.add(Calendar.DATE, -0);
			Date todayDate = calendart.getTime();
			String tDate = sdf2.format(todayDate.getTime());
			todayDate = sdf2.parse(tDate);

			String todayDateTime = sdf2.format(todayDate);
			Timestamp todayStart = Timestamp.valueOf(todayDateTime);

			// today end date
			Calendar calendarE = Calendar.getInstance();
			calendarE.setTime(sqlDate);
			calendarE.add(Calendar.DATE, -0);
			Date todayEDate = calendarE.getTime();
			String tEDate = sdf3.format(todayEDate.getTime());
			todayEDate = sdf3.parse(tEDate);

			String todayEDateTime = sdf3.format(todayEDate);
			Timestamp todayEnd = Timestamp.valueOf(todayEDateTime);

			ArrayList<EverwellFeedback> records = everwellFeedbackRepo
					.getEverwellDetailsForToday(outboundCallRequest.getEapiId(), todayStart, todayEnd);
			if (records.size() > 0) {
				for (EverwellFeedback details : records) {
					if (((details.getSubCategory().equalsIgnoreCase("Dose not taken")
							|| details.getSubCategory().equalsIgnoreCase("Dose taken but not reported by technology")
							|| details.getSubCategory().equalsIgnoreCase("Wrong phone number")
							|| details.getSubCategory().equalsIgnoreCase("Do not disturb for today"))
							&& details.getComments() != null)) {
						retryNeeded = false;
						break;
					}

				}
			}
			c = everwellCallHandlingRepository.updateRetryNeededAsTrueEverwellDetails(outboundCallRequest.getEapiId(),
					retryNeeded, outboundCallRequest.getComments());
		}

		Map<String, Object> responseMap = new HashMap<String, Object>();
		if (saveResponse != null) {
			responseMap.put("savedData", saveResponse);
			return new Gson().toJson(responseMap);
		} else
			return "Data not saved successfully";
	}

	@Override
	public String completeOutboundCall(String request) throws IEMRException {

//		EverwellDetails callRequest = inputMapper.gson().fromJson(request, EverwellDetails.class);

//		OutboundCallRequest outrequest=new OutboundCallRequest();
//		outrequest.setBeneficiaryRegID(callRequest.getBeneficiaryRegId());
//		outrequest.setCallTypeID(callRequest.getCallTypeID());
//		outrequest.setCreatedBy(callRequest.getCreatedBy());
//		outrequest.setAssignedUserID(callRequest.getAgentId());
//		outrequest.setBenCallID(callRequest.getBenCallID());
//		outrequest.setIs1097(true);
//		outrequest.setIsCompleted(callRequest.getIsCompleted());
//		outrequest.setPreferredLanguageName(callRequest.getPreferredLanguageName());
//		outrequest.setProviderServiceMapID(callRequest.getProviderServiceMapId());
//		outrequest.setRequestedServiceID(callRequest.getRequestedServiceID());

//		if (callRequest.getRequestedFor() != null) {
//			updateCount = outboundCallRequestRepository.updateCompleteStatusInCall(callRequest.getOutboundCallReqID(),
//					callRequest.getIsCompleted(), callRequest.getRequestedFor(), null);
//		} else {

//		ArrayList<EverwellDetails> everwellRequest=request;

		String response = "failure";
		try {
			EverwellDetails[] reqForEverwell = inputMapper.gson().fromJson(request, EverwellDetails[].class);
			Iterable<EverwellDetails> reqForEverwellDetails = Arrays.asList(reqForEverwell);

			for (EverwellDetails reqObj : reqForEverwellDetails) {
				int updateCount = 0;
				int updateCallCounter = 0;

				EverwellDetails everwellCallStatus = everwellCallHandlingRepository.findOne(reqObj.getEapiId());

				if (everwellCallStatus != null && everwellCallStatus.getEapiId() > 0) {
					if (everwellCallStatus.getRetryNeeded()) {
						int callCounter = 0;
						callCounter = everwellCallStatus.getCallCounter() + 1;
						if (callRetryConfiguration == callCounter) {
							updateCount = everwellCallHandlingRepository.updateCompleteStatusInCall(reqObj.getEapiId(),
									reqObj.getIsCompleted(), reqObj.getBenCallID(), reqObj.getCallId(),
									reqObj.getBeneficiaryRegId());
						} else {
							updateCallCounter = everwellCallHandlingRepository.updateCallCounter(reqObj.getEapiId(),
									callCounter, reqObj.getBenCallID(), reqObj.getCallId());
							if (updateCallCounter > 0)
								response = "success";
							else {
								response = "failure";
								break;
							}
						}
					} else {
						updateCount = everwellCallHandlingRepository.updateCompleteStatusInCall(reqObj.getEapiId(),
								reqObj.getIsCompleted(), reqObj.getBenCallID(), reqObj.getCallId(),
								reqObj.getBeneficiaryRegId());
					}
				}

//		updateCount = everwellCallHandlingRepository.updateCompleteStatusInCall(callRequest.getEapiId(),
//				callRequest.getIsCompleted(), callRequest.getBenCallID(), callRequest.getCallId());
				// }

				if (updateCount > 0) {
					// write a service to save data in outboundcallrequest
					// OutboundCallRequest o=outboundCallHandlingRepository.save(outrequest);
					// :beneficiaryRegId,:agentId,:callTypeID,:providerServiceMapId,:isCompleted,:benCallID,:createdBy,:preferredLanguageName
					int c = everwellCallHandlingRepository.insertEverwellDetails(reqObj.getBeneficiaryRegId(),
							reqObj.getAssignedUserID(), reqObj.getCallTypeID(), reqObj.getProviderServiceMapId(),
							reqObj.getIsCompleted(), reqObj.getBenCallID(), reqObj.getRequestedServiceID(),
							reqObj.getCreatedBy(), reqObj.getPreferredLanguageName());
					if (c > 0)
						response = "success";
					else {
						response = "failure";
						break;
					}

				}
			}

		} catch (Exception e) {
			throw new IEMRException("Error while updating call completion " + e.getMessage());
		}

		return response;
	}

	@Override
	public String updateIncompleteCallStatus(String request) throws IEMRException {
		String response = "failure";
		logger.debug("Request received for updateIncompleteCallStatus : " + request);
		EverwellFeedback incompleteCallStatus = InputMapper.gson().fromJson(request, EverwellFeedback.class);

		int updateIsCompleted = everwellCallHandlingRepository.updateIsCompleted(incompleteCallStatus.getEapiId(),
				incompleteCallStatus.getIsCompleted(), incompleteCallStatus.getModifiedBy());

		// saving the request
		EverwellFeedback saveResponse = everwellFeedbackRepo.save(incompleteCallStatus);

		if (updateIsCompleted > 0 && saveResponse != null)
			response = "success";

		return response;
	}

	@Override
	public String getEverwellFeedback(String request) throws IEMRException {
		logger.debug("Request received for resetOutboundCall: " + request);
		try {
			EverwellFeedback outboundCallRequest = inputMapper.gson().fromJson(request, EverwellFeedback.class);
			// (@Param("eapiId") Integer eapiId,@Param("missedDoses") Integer
			// missedDoses,@Param("category") Integer category,@Param("subCategory") Integer
			// subCategory,@Param("actionTaken") Integer
			// actionTaken,@Param("adherencePercentage") Integer
			// adherencePercentage,@Param("comments") Integer comments)
//		 Integer count = everwellCallHandlingRepository.saveDetails(outboundCallRequest.getEapiId(),outboundCallRequest.getMissedDoses(),outboundCallRequest.getCategory(),
//				 outboundCallRequest.getSubCategory(),outboundCallRequest.getActionTaken(),outboundCallRequest.getAdherencePercentage(),outboundCallRequest.getComments(),outboundCallRequest.getDateOfAction());
//		logger.debug("Respone from saveDetails: " + outboundCallRequest);
			Map<String, Object> responseMap = new HashMap<String, Object>();
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String text = sqlDate.toString();
			// Timestamp currentDate = new Timestamp(sqlDate.getTime());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sqlDate);
			calendar.add(Calendar.DATE, -Integer.parseInt(everwellCalendarDuration));
			Date beforeDate = calendar.getTime();

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

			String str2 = sdf2.format(beforeDate.getTime());

			beforeDate = sdf2.parse(str2);

			String endDateTime = sdf2.format(beforeDate);
			Timestamp lastDate = Timestamp.valueOf(endDateTime);

//		Timestamp lastDate = new Timestamp(beforeDate.getTime());
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(sqlDate);
			calendar1.add(Calendar.DATE, -1);
			Date yesterdayDate = calendar1.getTime();

			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			String str3 = sdf3.format(yesterdayDate.getTime());
			yesterdayDate = sdf3.parse(str3);
			String endDateTime2 = sdf3.format(yesterdayDate);
			Timestamp currentDate = Timestamp.valueOf(endDateTime2);

//		Timestamp currentDate = new Timestamp(yesterdayDate.getTime());
			// fetch the patient ID for which data needs to sync to everwell
			ArrayList<EverwellFeedback> records = everwellFeedbackRepo.getEverwellDetails(outboundCallRequest.getId(),
					currentDate, lastDate);
			responseMap.put("feedbackDetails", records);
			responseMap.put("everwellCalendarDuration", everwellCalendarDuration);
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new IEMRException("Error in fetching everwell details" + e.getMessage());
		}
	}

	@Override
	public String outboundCallListWithMobileNumber(String request) throws IEMRException {
		EverwellDetails callRequest = inputMapper.gson().fromJson(request, EverwellDetails.class);
		// List<EverwellDetails> outboundCallRequests = new
		// ArrayList<EverwellDetails>();
		List<EverwellDetails> resultSet = new ArrayList<EverwellDetails>();

		if (callRequest.getProviderServiceMapId() != null && callRequest.getPrimaryNumber() != null
				&& callRequest.getPrimaryNumber().length() > 0) {
			resultSet = everwellCallHandlingRepository.getAllOutboundCallsWithMobileNumber(
					callRequest.getProviderServiceMapId(), callRequest.getPrimaryNumber());
		}

		Map<Long, Long> responseMap = new HashMap<Long, Long>();
		Iterator<EverwellDetails> listIterator = resultSet.iterator();
		while (listIterator.hasNext()) {
			EverwellDetails obj = listIterator.next();
			if (obj != null) {
				if (!responseMap.containsKey(obj.getBeneficiaryRegId())) {
					responseMap.put(obj.getBeneficiaryRegId(), obj.getEapiId());
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
					obj.setLastCall(simpleDateFormat.format((Timestamp) obj.getLastModDate()));
				} else
					listIterator.remove();
			}
		}

//		if (resultSet != null && resultSet.size() > 0) {
//			for (EverwellDetails object : resultSet) {
//				if (object != null) {
//					if (!responseMap.containsKey(object.getBeneficiaryRegId())) {
//						responseMap.put(object.getBeneficiaryRegId(), object.getEapiId());
//						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
//						object.setLastCall(simpleDateFormat.format((Timestamp) object.getLastModDate()));
//					} else
//						resultSet.remove(object);
//
//					// outboundCallRequests.add(object);
//				}
//			}
//		}
		return OutputMapper.gsonWithoutExposeRestriction().toJson(resultSet);
	}

	public String checkAlreadyCalled(String request) throws IEMRException {
		Boolean isCompleted = false;
		try {
			EverwellDetails outboundCallRequest = InputMapper.gson().fromJson(request, EverwellDetails.class);
			isCompleted = everwellCallHandlingRepository.checkCallCompleted(outboundCallRequest.getEapiId());
		} catch (Exception e) {
			throw new IEMRException("Error while gettin call completed parameter" + e.getMessage());
		}
		Map<String, Boolean> responseMap = new HashMap<String, Boolean>();
		responseMap.put("isCompleted", isCompleted);
		return new Gson().toJson(responseMap);
	}
}
