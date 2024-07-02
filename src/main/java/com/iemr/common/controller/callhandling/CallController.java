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
package com.iemr.common.controller.callhandling;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.model.beneficiary.BeneficiaryCallModel;
import com.iemr.common.model.beneficiary.CallRequestByIDModel;
import com.iemr.common.service.callhandling.BeneficiaryCallService;
import com.iemr.common.service.callhandling.CalltypeServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.utils.response.OutputResponse;
import com.iemr.common.utils.sessionobject.SessionObject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/call")
@RestController
public class CallController {
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final String XFORWARDEDFOR = "X-FORWARDED-FOR";
	private static final String AUTHORIZATION = "authorization";
	private CalltypeServiceImpl calltypeServiceImpl;

	@Autowired
	public void setCalltypeServiceImpl(CalltypeServiceImpl calltypeServiceImpl) {
		this.calltypeServiceImpl = calltypeServiceImpl;
	}

	private BeneficiaryCallService beneficiaryCallService;

	@Autowired
	public void setBeneficiaryCallService(BeneficiaryCallService beneficiaryCallService) {
		this.beneficiaryCallService = beneficiaryCallService;
	}

	@CrossOrigin()
	@ApiOperation(value = "Get call types")
	@RequestMapping(value = "/getCallTypes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAllCallTypes(
			@ApiParam("{\"providerServiceMapID\":\"Integer - provider service ID\", \"isInbound\": Optional boolean,"
					+ "\"isOutbound\": Optional boolean}") @RequestBody String providerDetails) {

		OutputResponse response = new OutputResponse();
		try {
			List<CallType> mCalltypes = calltypeServiceImpl.getAllCalltypes(providerDetails);
			response.setResponse(mCalltypes.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get call types V1")
	@RequestMapping(value = "/getCallTypesV1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallTypesV1(
			@ApiParam("{\"providerServiceMapID\":\"Integer - provider service ID\", \"isInbound\": Optional boolean,"
					+ "\"isOutbound\": Optional boolean}") @RequestBody String providerDetails) {
		OutputResponse response = new OutputResponse();
		try {
			String mCalltypes = calltypeServiceImpl.getAllCalltypesV1(providerDetails);
			response.setResponse(mCalltypes);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Start call")
	@RequestMapping(value = "/startCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String startCall(
			@ApiParam(value = "{\"calledServiceID\":\"Integer - provider service ID\", "
					+ "\"callID\":\"String - Unique ID associated with CTI for every call\""
					+ "\"is1097\":\"Boolean - to indicate call is from 1097\", "
					+ "\"createdBy\":\"String - Call received agen username\","
					+ "\"agentID\":\"String - call received agent ID \","
					+ "\"isOutbound\":\"Boolean - true if call is outbound\"," + "\"isCalledEarlier\":\"Boolean\","
					+ "\"receivedRoleName\":\"String - Optional. User role name\"}") @RequestBody String request,
			HttpServletRequest fromRequest) {
		OutputResponse response = new OutputResponse();
		try {
			String remoteAddress = fromRequest.getHeader(XFORWARDEDFOR);
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = fromRequest.getRemoteAddr();
			}
			logger.info("Start Call req Obj - " + request);
			BeneficiaryCall startedCall = beneficiaryCallService.createCall(request, remoteAddress);
			response.setResponse(startedCall.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Update beneficiary in call")
	@RequestMapping(value = "/updatebeneficiaryincall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String updateBeneficiaryIDInCall(@ApiParam(value = "{\"benCallID\":\"Integer - callID as in CRM\", "
			+ "\"isCalledEarlier\":\"Boolean - to be set as true or false if called earlier is yes or no\","
			+ "\"beneficiaryRegID\":\"Integer - benefiicary registration id\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("updatebeneficiaryincallObj " + request);
			JSONObject requestObject = new JSONObject(request);
			requestObject.put("updatedCount", beneficiaryCallService.updateBeneficiaryIDInCall(request));
			response.setResponse(requestObject.toString());
		} catch (JSONException e) {
			logger.error("", e);
			response.setError(e);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Close call")
	@RequestMapping(value = "/closeCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String closeCall(
			@ApiParam(value = "{\"benCallID\":\"Integer - callID as in CRM\", \"remarks\":\"String - call remarks\", "
					+ "\"callClosureType\":\"String - closure type\", \"callTypeID\":\"Integer - call type ID\", "
					+ "\"endCall\":\"Optional Boolean - true to disconnect call from CTI\", "
					+ "\"isFollowupRequired\":\"Optional Boolean - for requesting followup\", "
					+ "\"fitToBlock\":\"Optional Boolean - set means phone no is fit to block\", "
					+ "\"beneficiaryRegID\":\"Optional Integer - beneficiary ID requessting for followup\", "
					+ "\"requestedFor\":\"Optional String - followup requested for\", "
					+ "\"preferredLanguageName\":\"Optional String - name of language preferred by user\", "
					+ "\"emergencyType\":\"Optional Short - emergency type of call\", "
					+ "\"agentIPAddress\":\"Optional String - agent IP address\", "
					+ "\"agentID\":\"Optional String - agentID\", \"isSelf\":\"Optional boolean\", "
					+ "\"isFeedback\":\"optional Boolean true if IVRS feedback to be taken\", "
					+ "\"IsOutbound\":\"Optional Boolean - for checking outboundcall status\", "
					+ "\"isTransfered\":\"Boolean - transfer call or not\"" + "}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("closeCallReqObj " + request);
			JSONObject requestObject = new JSONObject(request);
			String remoteAddress = serverRequest.getHeader(XFORWARDEDFOR);
			if (remoteAddress == null || remoteAddress.trim().length() == 0) {
				remoteAddress = serverRequest.getRemoteAddr();
			}
			Integer updateCount = beneficiaryCallService.closeCall(request, remoteAddress);
			requestObject.put("updateCount", updateCount);
			response.setResponse(requestObject.toString());
		} catch (JSONException e) {
			logger.error("close call failed with error:", e);
			response.setError(e);
		} catch (Exception e) {
			logger.error("close call failed with error:", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Outbound call list")
	@RequestMapping(value = "/outboundCallList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String outboundCallList(@ApiParam(value = "{\"providerServiceMapID\":\" called service ID integer\", "
			+ "\"assignedUserID\":\"Optional - Integer ID of user that is assigned to\", "
			+ "\"subServiceID\":\"Optional - Integer ID of subservice that needs to be filtered\", "
			+ "\"preferredLanguageName\":\"Optional - String name of the language selected by user\""
			+ "\"filterStartDate\":\"JSON date\", " + "\"filterEndDate\":\"JSON Date\"}") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		try {
			response.setResponse(beneficiaryCallService.outboundCallList(request, auth));
		} catch (Exception e) {
			logger.error("outboundCallList failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Outbound call count")
	@RequestMapping(value = "/outboundCallCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String outboundCallCount(@ApiParam(value = "{\"providerServiceMapID\":\"called service ID integer\", "
			+ "\"preferredLanguageName\":\"Optional - String name of the language selected by user\", "
			+ "\"assignedUserID\":\"Optional - Integer user id to whom calls are assigned\", "
			+ "\"filterStartDate\":\"JSON date\", " + "\"filterEndDate\":\"JSON Date\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.outboundCallCount(request));
		} catch (Exception e) {
			logger.error("outboundCallList failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Filter call list")
	@RequestMapping(value = "/filterCallList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String filterCallList(
			@ApiParam(value = "{\"calledServiceID\":\" called service ID integer\", "
					+ "\"callTypeID\":\"optional call type ID from dropdown\", " + "\"filterStartDate\":\"JSON date\", "
					+ "\"filterEndDate\":\"JSON Date\""
					+ "\"receivedRoleName\":\"Optional: role name\", \"phoneNo\":\"optional phone number\", "
					+ "\"agentID\":\"optional agent ID\", " + "\"inboundOutbound\":\"optional inbound/outbound\", "
					+ "\"is1097\" : \"boolean true for 1097\"}") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		try {
			response.setResponse(beneficiaryCallService.filterCallList(request, auth));
		} catch (Exception e) {
			logger.error("filterCallList failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Filter call list page")
	@RequestMapping(value = "/filterCallListPage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String filterCallListPaginated(@ApiParam(value = "{\"calledServiceID\":\" called service ID integer\", "
			+ "\"callTypeID\":\"optional call type ID from dropdown\", " + "\"filterStartDate\":\"JSON date\", "
			+ "\"filterEndDate\":\"JSON Date\""
			+ "\"receivedRoleName\":\"Optional: role name\", \"phoneNo\":\"optional phone number\", "
			+ "\"agentID\":\"optional agent ID\", " + "\"inboundOutbound\":\"optional inbound/outbound\", "
			+ "\"is1097\" : \"boolean true for 1097\", \"pageNo\\\":\"optional page no\", , \"pageSize\":\"optional page size\" }") @RequestBody String request,
			HttpServletRequest httpRequest) {
		OutputResponse response = new OutputResponse();
		String auth = httpRequest.getHeader(AUTHORIZATION);
		try {
			response.setResponse(beneficiaryCallService.filterCallListWithPagination(request, auth));
		} catch (Exception e) {
			logger.error("filterCallList with pagination failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Outbound allocation")
	@RequestMapping(value = "/outboundAllocation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String outboundAllocation(@ApiParam(value = "{\"userID\":[Integer Array list of user IDs], "
			+ "\"allocateNo\":\"Integer - number of calls to be allocated for user\", "
			+ "\"outboundCallRequests\":\"Array list of outbound calls\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.outboundAllocation(request));
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Complete outbound call")
	@RequestMapping(value = "/completeOutboundCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String completeOutboundCall(@ApiParam(value = "{\"outboundCallReqID\":\"Integer - Outbound call id\", "
			+ "\"isCompleted\":\"Boolean - Value indicating call is completed/pending\", "
			+ "\"requestedFor\":\"String - Optional - Requested for\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.completeOutboundCall(request));
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Update outbound call")
	@RequestMapping(value = "/updateOutboundCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String updateOutboundCall(@ApiParam(value = "{\"outboundCallReqID\":\"Integer - Outbound call id\", "
			+ "\"isCompleted\":\"Boolean - Value indicating call is completed/pending\", "
			+ "\"callTypeID\":\"Call type ID selected during closure\", "
			+ "\"requestedFor\":\"String - Optional - Requested for\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.updateOutboundCall(request));
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Reset outbound call")
	@RequestMapping(value = "/resetOutboundCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String resetOutboundCall(
			@ApiParam(value = "{\"outboundCallReqIDs\":\"[Long - Array of Outbound call ids]\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.resetOutboundCall(request));
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get blacklist numbers")
	@RequestMapping(value = "/getBlacklistNumbers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getBlacklistNumbers(
			@ApiParam(value = "{\"providerServiceMapID\":\"Integer - provider service map id\", "
					+ "\"phoneNo\":\"String - Optional - phone number\", "
					+ "\"isBlocked\":\"Boolean - Optional - Status of the request "
					+ "if blocked or not or any\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.getBlacklistNumbers(request));
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Unblock blocked numbers")
	@RequestMapping(value = "/unblockBlockedNumbers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String unblockBlockedNumbers() {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.unblockBlockedNumbers());
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Block phone number")
	@RequestMapping(value = "/blockPhoneNumber", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String blockPhoneNumber(
			@ApiParam(value = "{\"phoneBlockID\":\"Integer - ID of the number to be blocked\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response = beneficiaryCallService.blockPhoneNumber(request);
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Unblock phone number")
	@RequestMapping(value = "/unblockPhoneNumber", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String unblockPhoneNumber(
			@ApiParam(value = "{\"phoneBlockID\":\"Integer - ID of the number to be unblocked\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response = beneficiaryCallService.unblockPhoneNumber(request);
		} catch (Exception e) {
			logger.error("outboundAllocation failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Update beneficiary call CDI status")
	@RequestMapping(value = "/updateBeneficiaryCallCDIStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String updateBeneficiaryCallCDIStatus(@ApiParam(value = "{\"benCallID\":\"Integer - callID as in CRM\", "
			+ "\"cDICallStatus\":\"String - cdi outbound call status\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject requestObject = new JSONObject(request);
			requestObject.put("updatedCount", beneficiaryCallService.updateBeneficiaryCallCDIStatus(request));
			response.setResponse(requestObject.toString());
		} catch (JSONException e) {
			logger.error("", e);
			response.setError(e);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get call history by call id")
	@RequestMapping(value = "/getCallHistoryByCallID", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallHistoryByCallID(
			@ApiParam(value = "{\"callID\":\"String - call ID from CTI\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.getCallHistoryByCallID(request).toString());
		} catch (Exception e) {
			logger.error("getCallHistoryByCallID failed wih error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Outbound call list by call id")
	@RequestMapping(value = "/outboundCallListByCallID", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String outboundCallListByCallID(@ApiParam(value = "{\"providerServiceMapID\":\"called service ID integer\", "
			+ "\"callID\":\"call ID as by CTI\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(beneficiaryCallService.outboundCallListByCallID(request).toString());
		} catch (Exception e) {
			logger.error("outboundCallList failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Nuisance call history")
	@RequestMapping(value = "/nueisanceCallHistory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String nueisanceCallHistory(
			@ApiParam(value = "{\"calledServiceID\":\"called service ID integer\", "
					+ "\"phoneNo\":\"phone number of the beneficiary whose number is marked nuiesance\", "
					+ "\"count\":\"Call counts that has been marked nuiesance\"}") @RequestBody String request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		try {
			String auth = serverRequest.getHeader(AUTHORIZATION);
			response.setResponse(beneficiaryCallService.nueisanceCallHistory(request, auth).toString());
		} catch (Exception e) {
			logger.error("outboundCallList failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Beneficiary by call id")
	@RequestMapping(value = "/beneficiaryByCallID", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String beneficiaryByCallID(@ApiParam("{\"callID\":\"String\"}") @RequestBody CallRequestByIDModel request,
			HttpServletRequest serverRequest) {
		OutputResponse response = new OutputResponse();
		try {
			BeneficiaryCallModel callData = beneficiaryCallService.beneficiaryByCallID(request,
					serverRequest.getHeader("Authorization"));
			response.setResponse(OutputMapper.gsonWithoutExposeRestriction().toJson(callData));
		} catch (Exception e) {
			logger.error("getCallHistoryByCallID failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get calls by beneficiary regitration id and received role name")
	@RequestMapping(value = "/isAvailed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String isAvailed(@ApiParam(value = "{\"beneficiaryRegID\":\"beneficiary reg id\", "
			+ "\"receivedRoleName\":\"availed service role\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(beneficiaryCallService
					.isAvailed(inputMapper.gson().fromJson(request, BeneficiaryCallModel.class)).toString());
		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get beneficiary requested outbound call")
	@RequestMapping(value = "/getBenRequestedOutboundCall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getBenRequestedOutboundCall(@ApiParam(value = "{\"beneficiaryRegID\":\"beneficiary reg id\", "
			+ "\"calledServiceID\":\"providerServiceMapID\", is1097: boolean}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(beneficiaryCallService
					.getBenRequestedOutboundCall(inputMapper.gson().fromJson(request, BeneficiaryCallModel.class))
					.toString());
		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Auto preview dialing")
	@RequestMapping(value = "/isAutoPreviewDialing", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String isAutoPreviewDialing(@ApiParam(value = "{\"providerServiceMapID\":\"called service ID integer\", "
			+ "\"isDialPreferenceManual\":\"flag to be marked yes based on providerServiceMapID\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(beneficiaryCallService
					.isAutoPreviewDialing(inputMapper.gson().fromJson(request, ProviderServiceMapping.class))
					.toString());
		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Check auto preview dialing")
	@RequestMapping(value = "/checkAutoPreviewDialing", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String checkAutoPreviewDialing(
			@ApiParam(value = "{\"providerServiceMapID\":\"called service ID integer\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(beneficiaryCallService
					.checkAutoPreviewDialing(inputMapper.gson().fromJson(request, ProviderServiceMapping.class))
					.toString());
		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get file path CTI")
	@RequestMapping(value = "/getFilePathCTI", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getFilePathCTI(
			@ApiParam("{\"agentID\":\"String\",\"callID\":\"String\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			String pathResponse = beneficiaryCallService.cTIFilePathNew(request);
			if (pathResponse != null)
				response.setResponse(pathResponse);
			else
				response.setError(5000, "File path not available");

		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();

	}

	@Autowired
	private SessionObject s;

	@CrossOrigin()
	@ApiOperation(value = "Redis insert")
	@RequestMapping(value = "/redisInsert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String redisInsert(@RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			String key = s.setSessionObject("1277.1000", "12345");
			response.setResponse(key);
		} catch (Exception e) {
			logger.error("isAvailed failed wih error " + e.getMessage(), e);
			response.setError(e);
		}
		return response.toString();

	}

	@CrossOrigin()
	@ApiOperation(value = "Redis fetch")
	@RequestMapping(value = "/redisFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String redisFetch(@ApiParam("{\"sessionID\":\"sessionID/callID String\"}") @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject obj = new JSONObject(request);
			if (obj.has("sessionID")) {
				String value = s.getSessionObject(obj.getString("sessionID"));
				response.setResponse(value);
			}
		} catch (Exception e) {
			response.setError(5000, e.getMessage());
		}
		return response.toString();

	}

}
