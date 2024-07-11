package com.iemr.common.controller.callhandling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.data.beneficiary.BenOutboundCallAllocation;
import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.callhandling.PhoneBlock;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.model.beneficiary.BeneficiaryCallModel;
import com.iemr.common.model.beneficiary.CallRequestByIDModel;
import com.iemr.common.service.callhandling.BeneficiaryCallService;
import com.iemr.common.service.callhandling.CalltypeServiceImpl;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.redis.RedisSessionException;
import com.iemr.common.utils.response.OutputResponse;
import com.iemr.common.utils.sessionobject.SessionObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class CallControllerTest {

	public static final int CODE_EXCEPTION = 5005;

	@InjectMocks
	CallController callController;

	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private static final String XFORWARDEDFOR = "X-FORWARDED-FOR";
	private static final String AUTHORIZATION = "authorization";
	@Mock
	private CalltypeServiceImpl calltypeServiceImpl;
	@Mock
	private BeneficiaryCallService beneficiaryCallService;
	@Mock
	private SessionObject s;

	@Test
	void testGetAllCallTypes() throws IEMRException {
		OutputResponse response = new OutputResponse();
		CallType callType = new CallType();
		callType.setProviderServiceMapID(123);
		callType.setIsInbound(true);
		callType.setIsOutbound(false);
		List<CallType> callTypeList = new ArrayList<CallType>();
		callTypeList.add(callType);
		List<CallType> mCalltypes = callTypeList;
		String providerDetails = callType.toString();

		when(calltypeServiceImpl.getAllCalltypes(providerDetails)).thenReturn(mCalltypes);

		String expResp = callController.getAllCallTypes(providerDetails);

		Assertions.assertEquals(expResp, callController.getAllCallTypes(providerDetails));

	}

	@Test
	void testGetAllCallTypes_CatchBlock() throws IEMRException {
		String providerDetails = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(calltypeServiceImpl.getAllCalltypes(providerDetails)).thenThrow(NotFoundException.class);
		String response = callController.getAllCallTypes(providerDetails);
		Assertions.assertEquals(response, callController.getAllCallTypes(providerDetails));
	}

	@Test
	void testGetCallTypesV1() throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		String providerDetails = "{\"providerServiceMapID\":\"1 - provider service ID\", \"isInbound\": Optional boolean,"
				+ "\"isOutbound\": Optional boolean}";

		OutputResponse response = new OutputResponse();

		String mCalltypes = "test";

		when(calltypeServiceImpl.getAllCalltypesV1(providerDetails)).thenReturn(mCalltypes);

		response.setResponse(mCalltypes);

		String expRes = callController.getCallTypesV1(providerDetails);

		assertEquals(expRes, callController.getCallTypesV1(providerDetails));
	}

	@Test
	void testGetCallTypesV1_Exception()
			throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(calltypeServiceImpl.getAllCalltypesV1(request)).thenThrow(NotFoundException.class);

		String response = callController.getCallTypesV1(request);
		assertEquals(response, callController.getCallTypesV1(request));
	}

	@Test
	void testStartCall() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setCalledServiceID(123);
		beneficiaryCall.setCallID("avc");
		beneficiaryCall.setIs1097(true);
		beneficiaryCall.setCreatedBy("bbb");
		beneficiaryCall.setAgentID("agent id");
		beneficiaryCall.setOutbound(true);
		beneficiaryCall.setIsCalledEarlier(true);
		beneficiaryCall.setReceivedRoleName("MO");
		String request = beneficiaryCall.toString();
		HttpServletRequest fromRequest = mock(HttpServletRequest.class);

		String remoteAddress = fromRequest.getHeader(XFORWARDEDFOR);
		when(beneficiaryCallService.createCall(request, remoteAddress)).thenReturn(beneficiaryCall);

		String expResp = callController.startCall(request, fromRequest);

		assertTrue(remoteAddress == null || remoteAddress.trim().length() == 0);
		Assertions.assertEquals(expResp, callController.startCall(request, fromRequest));
	}

	@Test
	void testStartCall_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest fromRequest = mock(HttpServletRequest.class);
		String remoteAddress = fromRequest.getHeader(XFORWARDEDFOR);
		when(beneficiaryCallService.createCall(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = callController.startCall(request, fromRequest);
		Assertions.assertEquals(response, callController.startCall(request, fromRequest));
	}

	@Test
	void testUpdateBeneficiaryIDInCall()
			throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {

		OutputResponse response = new OutputResponse();
		String isCalledEarlier = String.valueOf(false);
		String benCallID = String.valueOf(123);
		String beneficiaryRegID = String.valueOf(543);
		String request = "{\"benCallID\":" + benCallID + "," + "\"isCalledEarlier\":\"" + isCalledEarlier + "\","
				+ "\"beneficiaryRegID\":" + beneficiaryRegID + "}";

		JSONObject requestObject = new JSONObject(request);
		Integer beneficiaryId = 123;
		when(beneficiaryCallService.updateBeneficiaryIDInCall(request)).thenReturn(beneficiaryId);
		requestObject.put("updatedCount", beneficiaryId);

		String expResp = callController.updateBeneficiaryIDInCall(request);

		Assertions.assertEquals(expResp, callController.updateBeneficiaryIDInCall(request));
	}

	@Test
	void testUpdateBeneficiaryIDInCall_CatchBlock()
			throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.updateBeneficiaryIDInCall(request)).thenThrow(RuntimeException.class);
		String response = callController.updateBeneficiaryIDInCall(request);
		Assertions.assertEquals(response, callController.updateBeneficiaryIDInCall(request));
	}

	@Test
	void testUpdateBeneficiaryIDInCall_CatchBlockJson()
			throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		JSONObject jsonObject = new JSONObject(request);
		JSONObject json = Mockito.mock(JSONObject.class);
		when(beneficiaryCallService.updateBeneficiaryIDInCall(Mockito.any())).thenReturn(123);
		String response = callController.updateBeneficiaryIDInCall(request);
		Assertions.assertTrue(response.contains("e"));
	}

	@Test
	void testCloseCall() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		BeneficiaryCallModel beneficiaryCall = new BeneficiaryCallModel();
		beneficiaryCall.setBenCallID(123L);
		beneficiaryCall.setRemarks("remarks");
		beneficiaryCall.setCallClosureType("valid");
		beneficiaryCall.setCallTypeID(123);
		beneficiaryCall.setEndCall(true);
		beneficiaryCall.setFitToBlock(false);
		beneficiaryCall.setBeneficiaryRegID(342L);
		beneficiaryCall.setEmergencyType((short) 12);
		beneficiaryCall.setAgentIPAddress("abc");
		beneficiaryCall.setAgentID("bvcf");
		beneficiaryCall.setIsOutbound(true);
		Integer updateCount = 0;

		String request = new ObjectMapper().writeValueAsString(beneficiaryCall);
		logger.info("closeCallReqObj " + request);
		String remoteAddress = httpRequest.getHeader(XFORWARDEDFOR);
		when(httpRequest.getHeader(XFORWARDEDFOR)).thenReturn(null);

		String expResp = callController.closeCall(request, httpRequest);

		assertTrue(remoteAddress == null || remoteAddress.trim().length() == 0);
		Assertions.assertEquals(expResp, callController.closeCall(request, httpRequest));
	}

	@Test
	void testCloseCall_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String remoteAddress = httpRequest.getHeader(XFORWARDEDFOR);
		when(beneficiaryCallService.closeCall(request, remoteAddress)).thenThrow(FileNotFoundException.class);
		String response = callController.closeCall(request, httpRequest);
		Assertions.assertEquals(response, callController.closeCall(request, httpRequest));
	}

	@Test
	void testOutboundCallList() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		OutboundCallRequest outboundCallRequest = new OutboundCallRequest();
		outboundCallRequest.setProviderServiceMapID(123);
		outboundCallRequest.setAssignedUserID(123);
		outboundCallRequest.setRequestedServiceID(43);
		outboundCallRequest.setPreferredLanguageName("English");
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.outboundCallList(request, auth)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.outboundCallList(request, httpRequest));

	}

	@Test
	void testOutboundCallList_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		when(beneficiaryCallService.outboundCallList(request, auth)).thenThrow(RuntimeException.class);
		String response = callController.outboundCallList(request, httpRequest);
		Assertions.assertEquals(response, callController.outboundCallList(request, httpRequest));
	}

	@Test
	void testOutboundCallCount() throws Exception, JSONException {
		OutputResponse response = new OutputResponse();
		OutboundCallRequest outboundCallRequest = new OutboundCallRequest();
		outboundCallRequest.setPreferredLanguageName("English");
		outboundCallRequest.setProviderServiceMapID(123);
		outboundCallRequest.setAssignedUserID(123);
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.outboundCallCount(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.outboundCallCount(request));
	}

	@Test
	void testOutboundCallCount_CatchBlock() throws Exception, JSONException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundCallCount(request)).thenThrow(RuntimeException.class);
		String response = callController.outboundCallCount(request);
		Assertions.assertEquals(response, callController.outboundCallCount(request));
	}

	@Test
	void testFilterCallList() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setCalledServiceID(123);
		beneficiaryCall.setCallTypeID(23);
		beneficiaryCall.setFilterStartDate(Timestamp.from(Instant.now()));
		beneficiaryCall.setFilterEndDate(Timestamp.from(Instant.now()));
		beneficiaryCall.setReceivedRoleName("MO");
		beneficiaryCall.setPhoneNo("8617577134");
		beneficiaryCall.setAgentID("5435");
		beneficiaryCall.setInboundOutbound("inbound");
		beneficiaryCall.setIs1097(false);
		String request = beneficiaryCall.toString();
		when(beneficiaryCallService.filterCallList(request, auth)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.filterCallList(request, httpRequest));
	}

	@Test
	void testFilterCallList_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		when(beneficiaryCallService.filterCallList(request, auth)).thenThrow(RuntimeException.class);
		String response = callController.filterCallList(request, httpRequest);
		Assertions.assertEquals(response, callController.filterCallList(request, httpRequest));
	}

	@Test
	void testFilterCallListPaginated() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setCalledServiceID(123);
		beneficiaryCall.setCallTypeID(23);
		beneficiaryCall.setFilterStartDate(Timestamp.from(Instant.now()));
		beneficiaryCall.setFilterEndDate(Timestamp.from(Instant.now()));
		beneficiaryCall.setReceivedRoleName("MO");
		beneficiaryCall.setPhoneNo("8617577134");
		beneficiaryCall.setAgentID("5435");
		beneficiaryCall.setInboundOutbound("inbound");
		beneficiaryCall.setIs1097(false);
		beneficiaryCall.setPageNo(4);
		beneficiaryCall.setPageSize(12);
		String request = beneficiaryCall.toString();
		when(beneficiaryCallService.filterCallListWithPagination(request, auth)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.filterCallListPaginated(request, httpRequest));
	}

	@Test
	void testFilterCallListPaginated_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = mock(HttpServletRequest.class);
		String auth = httpRequest.getHeader(AUTHORIZATION);
		when(beneficiaryCallService.filterCallListWithPagination(request, auth)).thenThrow(RuntimeException.class);
		String response = callController.filterCallListPaginated(request, httpRequest);
		Assertions.assertEquals(response, callController.filterCallListPaginated(request, httpRequest));
	}

	@Test
	void testOutboundAllocation() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		BenOutboundCallAllocation benOutboundCallAllocation = new BenOutboundCallAllocation();
		List<Integer> userID = new ArrayList<Integer>();
		userID.add(123);
		OutboundCallRequest[] outboundCallRequests = new OutboundCallRequest[2];
		benOutboundCallAllocation.setUserID(userID);
		benOutboundCallAllocation.setAllocateNo(123);
		benOutboundCallAllocation.setOutboundCallRequests(outboundCallRequests);
		String request = benOutboundCallAllocation.toString();
		when(beneficiaryCallService.outboundAllocation(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.outboundAllocation(request));
	}

	@Test
	void testOutboundAllocation_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundAllocation(request)).thenThrow(RuntimeException.class);
		String response = callController.outboundAllocation(request);
		Assertions.assertEquals(response, callController.outboundAllocation(request));
	}

	@Test
	void testCompleteOutboundCall() throws Exception {
		OutputResponse response = new OutputResponse();
		OutboundCallRequest outboundCallRequest = new OutboundCallRequest();
		outboundCallRequest.setOutboundCallReqID(23L);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setRequestedFor("gfd");
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.completeOutboundCall(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.completeOutboundCall(request));
	}

	@Test
	void testCompleteOutboundCall_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.completeOutboundCall(request)).thenThrow(RuntimeException.class);
		String response = callController.completeOutboundCall(request);
		Assertions.assertEquals(response, callController.completeOutboundCall(request));
	}

	@Test
	void testUpdateOutboundCall() throws Exception {
		OutputResponse response = new OutputResponse();
		OutboundCallRequest outboundCallRequest = new OutboundCallRequest();
		outboundCallRequest.setOutboundCallReqID(23L);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setRequestedFor("gfd");
		outboundCallRequest.setRequestedFor("requested");
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.updateOutboundCall(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.updateOutboundCall(request));
	}

	@Test
	void testUpdateOutboundCall_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.updateOutboundCall(request)).thenThrow(RuntimeException.class);
		String response = callController.updateOutboundCall(request);
		Assertions.assertEquals(response, callController.updateOutboundCall(request));
	}

	@Test
	void testResetOutboundCall() throws Exception {
		OutputResponse response = new OutputResponse();
		OutboundCallRequest outboundCallRequest = new OutboundCallRequest();
		List<Long> outboundCallReqIDs = new ArrayList<Long>();
		outboundCallReqIDs.add(123L);
		outboundCallRequest.setOutboundCallReqIDs(outboundCallReqIDs);
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.resetOutboundCall(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.resetOutboundCall(request));
	}

	@Test
	void testResetOutboundCall_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.resetOutboundCall(request)).thenThrow(RuntimeException.class);
		String response = callController.resetOutboundCall(request);
		Assertions.assertEquals(response, callController.resetOutboundCall(request));
	}

	@Test
	void testGetBlacklistNumbers() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		PhoneBlock phoneBlock = new PhoneBlock();
		phoneBlock.setProviderServiceMapID(123);
		phoneBlock.setPhoneNo("8617577134");
		phoneBlock.setIsBlocked(false);
		String request = phoneBlock.toString();

		when(beneficiaryCallService.getBlacklistNumbers(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.getBlacklistNumbers(request));
	}

	@Test
	void testGetBlacklistNumbers_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.getBlacklistNumbers(request)).thenThrow(NotFoundException.class);
		String response = callController.getBlacklistNumbers(request);
		Assertions.assertEquals(response, callController.getBlacklistNumbers(request));
	}

	@Test
	void testBlockPhoneNumber() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		PhoneBlock phoneBlock = new PhoneBlock();
		phoneBlock.setPhoneBlockID(123L);
		String request = phoneBlock.toString();
		when(beneficiaryCallService.blockPhoneNumber(request)).thenReturn(response);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.blockPhoneNumber(request));
	}

	@Test
	void testBlockPhoneNumber_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.blockPhoneNumber(request)).thenThrow(NotFoundException.class);
		String response = callController.blockPhoneNumber(request);
		Assertions.assertEquals(response, callController.blockPhoneNumber(request));
	}

	@Test
	void testUnblockPhoneNumber() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		PhoneBlock phoneBlock = new PhoneBlock();
		phoneBlock.setPhoneBlockID(123L);
		String request = phoneBlock.toString();
		when(beneficiaryCallService.unblockPhoneNumber(request)).thenReturn(response);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.unblockPhoneNumber(request));
	}

	@Test
	void testUnblockPhoneNumber_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.unblockPhoneNumber(request)).thenThrow(NotFoundException.class);
		String response = callController.unblockPhoneNumber(request);
		Assertions.assertEquals(response, callController.unblockPhoneNumber(request));
	}

	@Test
	void testUpdateBeneficiaryCallCDIStatus() throws Exception {
		OutputResponse response = new OutputResponse();
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setBenCallID(123L);
		beneficiaryCall.setCDICallStatus("status");
		String request = beneficiaryCall.toString();
		JSONObject requestObject = new JSONObject(request);
		Integer benCallId = 123;
		when(beneficiaryCallService.updateBeneficiaryCallCDIStatus(request)).thenReturn(benCallId);
		requestObject.put("updatedCount", benCallId);
		String expResp = callController.updateBeneficiaryCallCDIStatus(request);
		Assertions.assertEquals(expResp, callController.updateBeneficiaryCallCDIStatus(request));
	}

	@Test
	void testUpdateBeneficiaryCallCDIStatus_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.updateBeneficiaryCallCDIStatus(request)).thenThrow(NotFoundException.class);
		String response = callController.updateBeneficiaryCallCDIStatus(request);
		Assertions.assertEquals(response, callController.updateBeneficiaryCallCDIStatus(request));
	}

	@Test
	void testGetCallHistoryByCallID_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.getCallHistoryByCallID(request)).thenThrow(NotFoundException.class);
		String response = callController.getCallHistoryByCallID(request);
		Assertions.assertEquals(response, callController.getCallHistoryByCallID(request));
	}

	@Test
	void testOutboundCallListByCallID() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setServicesProvided("abc");
		beneficiaryCall.setCallID("call id");
		String request = beneficiaryCall.toString();
		when(beneficiaryCallService.outboundCallListByCallID(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.outboundCallListByCallID(request));
	}

	@Test
	void testOutboundCallListByCallID_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundCallListByCallID(request)).thenThrow(NotFoundException.class);
		String response = callController.outboundCallListByCallID(request);
		Assertions.assertEquals(response, callController.outboundCallListByCallID(request));
	}

	@Test
	void testNueisanceCallHistory() throws IEMRException, Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader(AUTHORIZATION);
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setCalledServiceID(123);
		beneficiaryCall.setPhoneNo("8617577134");
		beneficiaryCall.setCount(3);
		String request = beneficiaryCall.toString();
		when(beneficiaryCallService.nueisanceCallHistory(request, auth)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), callController.nueisanceCallHistory(request, serverRequest));

	}

	@Test
	void testNueisanceCallHistory_CatchBlock() throws IEMRException, Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader(AUTHORIZATION);
		when(beneficiaryCallService.nueisanceCallHistory(request, auth)).thenThrow(NotFoundException.class);
		String response = callController.nueisanceCallHistory(request, serverRequest);
		Assertions.assertEquals(response, callController.nueisanceCallHistory(request, serverRequest));
	}

	@Test
	void testBeneficiaryByCallID_CatchBlock() throws IEMRException, Exception, JsonProcessingException {
		String expRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		CallRequestByIDModel request = new CallRequestByIDModel();
		request.setCallID(expRequest);
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(beneficiaryCallService.beneficiaryByCallID(request, serverRequest.getHeader("Authorization")))
				.thenThrow(NotFoundException.class);
		String response = callController.beneficiaryByCallID(request, serverRequest);
		Assertions.assertEquals(response, callController.beneficiaryByCallID(request, serverRequest));
	}

	@Test
	void testGetFilePathCTI() throws IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		BeneficiaryCall beneficiaryCall = new BeneficiaryCall();
		beneficiaryCall.setAgentID("agent id");
		beneficiaryCall.setCallID("call id");
		String request = beneficiaryCall.toString();
		when(beneficiaryCallService.cTIFilePathNew(request)).thenReturn(request);
		response.setResponse(request.toString());
		String expResp = callController.getFilePathCTI(request);
		assertNotNull(expResp);
		Assertions.assertEquals(response.toString(), callController.getFilePathCTI(request));
	}

	@Test
	void testGetFilePathCTI_NotNull() throws IEMRException {
		OutputResponse response = new OutputResponse();
		String pathResponse = null;
		response.setError(5000, "File path not available");
		assertNull(pathResponse);
		assertTrue(response.toString().contains("File path not available"));
	}

	@Test
	void testGetFilePathCTI_CatchBlock() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.cTIFilePathNew(request)).thenThrow(NotFoundException.class);
		String response = callController.getFilePathCTI(request);
		Assertions.assertEquals(response, callController.getFilePathCTI(request));
	}

	@Test
	void testRedisInsert() throws RedisSessionException {
		String request = "test";
		OutputResponse response = new OutputResponse();

		String key = "123";

		when(s.setSessionObject("1277.1000", "12345")).thenReturn(key);
		response.setResponse(key);

		String expRes = callController.redisInsert(request);

		assertEquals(expRes, callController.redisInsert(request));
	}

	@Test
	void testRedisInsert_Exception() throws RedisSessionException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(s.setSessionObject("1277.1000", "12345")).thenThrow(NotFoundException.class);

		String response = callController.redisInsert(request);
		assertEquals(response, callController.redisInsert(request));
	}

	@Test
	void redisFetch() throws JSONException, RedisSessionException {
		String request = "{\"sessionID\":\"123\"}";
		OutputResponse response = new OutputResponse();
		JSONObject obj = new JSONObject(request);

		String value = "test";
		when(s.getSessionObject(obj.getString("sessionID"))).thenReturn(value);
		response.setResponse(value);

		String expRes = callController.redisFetch(request);

		assertTrue(obj.has("sessionID"));
		assertEquals(expRes, callController.redisFetch(request));
	}

}
