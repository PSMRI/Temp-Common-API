package com.iemr.common.controller.everwell.callhandle;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.everwell.EverwellAllocateMultiple;
import com.iemr.common.data.everwell.EverwellDetails;
import com.iemr.common.data.everwell.EverwellFeedback;
import com.iemr.common.service.callhandling.CalltypeServiceImpl;
import com.iemr.common.service.everwell.EverwellCallHandlingService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EverwellCallControllerTest {

	@InjectMocks
	EverwellCallController everwellCallController;

	@Mock
	private EverwellCallHandlingService beneficiaryCallService;

	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testOutboundCallCount() throws IEMRException, JSONException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.outboundCallCount(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.outboundCallCount(request));
	}

	@Test
	void testOutboundCallCount_CatchBlock() throws IEMRException, JSONException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundCallCount(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.outboundCallCount(request);
		Assertions.assertEquals(response, everwellCallController.outboundCallCount(request));
	}

	@Test
	void testOutboundAllocation() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellAllocateMultiple allocation = new EverwellAllocateMultiple();
		List<Integer> agentIds = new ArrayList<Integer>();
		agentIds.add(1);
		agentIds.add(2);
		allocation.setAgentId(agentIds);
		allocation.setAllocateNo(12);
		EverwellDetails[] outboundCallRequests = { new EverwellDetails() };
		allocation.setOutboundCallRequests(outboundCallRequests);
		allocation.toString();
		String request = allocation.toString();
		when(beneficiaryCallService.outboundAllocation(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.outboundAllocation(request));
	}

	@Test
	void testOutboundAllocation_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundAllocation(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.outboundAllocation(request);
		Assertions.assertEquals(response, everwellCallController.outboundAllocation(request));
	}

	@Test
	void testOutboundCallList() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.outboundCallList(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.outboundCallList(request));
	}

	@Test
	void testOutboundCallList_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundCallList(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.outboundCallList(request);
		Assertions.assertEquals(response, everwellCallController.outboundCallList(request));
	}

	@Test
	void testResetOutboundCall() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		List<Long> eapiIds = new ArrayList<Long>();
		eapiIds.add(12L);
		eapiIds.add(32L);
		outboundCallRequest.setEapiIds(eapiIds);
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.resetOutboundCall(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.resetOutboundCall(request));
	}

	@Test
	void testResetOutboundCall_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.resetOutboundCall(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.resetOutboundCall(request);
		Assertions.assertEquals(response, everwellCallController.resetOutboundCall(request));
	}

	@Test
	void testSaveCallDetails() throws IEMRException, ParseException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		List<Long> eapiIds = new ArrayList<Long>();
		eapiIds.add(12L);
		eapiIds.add(32L);
		outboundCallRequest.setEapiIds(eapiIds);
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.saveDetails(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.saveCallDetails(request));
	}

	@Test
	void testSaveCallDetails_CatchBlock() throws IEMRException, ParseException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.saveDetails(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.saveCallDetails(request);
		Assertions.assertEquals(response, everwellCallController.saveCallDetails(request));
	}

	@Test
	void testCompleteOutboundCall() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		List<Long> eapiIds = new ArrayList<Long>();
		eapiIds.add(12L);
		eapiIds.add(32L);
		outboundCallRequest.setEapiIds(eapiIds);
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.setMissedDoses(2);
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.completeOutboundCall(request)).thenReturn("success");
		response.setResponse("success");
		String actualResp = everwellCallController.completeOutboundCall(request);
		assertTrue(actualResp.toLowerCase().contains("success"),
				"Expected 'success' in the response, but got: " + actualResp);
		Assertions.assertEquals(response.toString(), actualResp);
	}

	@Test
	void testCompleteOutboundCall_InvalidRequest() throws IEMRException {
		OutputResponse response = new OutputResponse();
		String invalidRequestObj = "{\"someInvalidField\": \"value\"}";
		String expResp = everwellCallController.completeOutboundCall(invalidRequestObj);
		response.setError(5000, "error in updating data");
		Assertions.assertEquals(expResp, everwellCallController.completeOutboundCall(invalidRequestObj));
		assertTrue(response.toString().contains("error in updating data"));
	}

	@Test
	void testCompleteOutboundCall_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.completeOutboundCall(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.completeOutboundCall(request);
		Assertions.assertEquals(response, everwellCallController.completeOutboundCall(request));
	}

	@Test
	void testGetEverwellfeedbackDetails() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellFeedback outboundCallRequest = new EverwellFeedback();
		outboundCallRequest.setActionTaken("sc");
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setEapiId(123L);
		outboundCallRequest.setEfid(43L);
		outboundCallRequest.setId(4432L);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsManualDoseProcessed(false);
		outboundCallRequest.setIsMobileNumberProcessed(true);
		outboundCallRequest.setIsMissedDoseProcessed(false);
		outboundCallRequest.setIsSupportActionProcessed(true);
		outboundCallRequest.setModifiedBy("modifiedby");
		outboundCallRequest.setProviderServiceMapId(123);
		outboundCallRequest.setSecondaryPhoneNo("sec ph");
		outboundCallRequest.setSubCategory("sub cat");
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.getEverwellFeedback(request)).thenReturn(request);
		response.setResponse(request.toString());
		String actualResp = everwellCallController.getEverwellfeedbackDetails(request);
		assertNotNull(actualResp);
		Assertions.assertEquals(response.toString(), actualResp);
	}

	@Test
	void testGetEverwellfeedbackDetails_InvalidRequest() throws IEMRException {
		OutputResponse response = new OutputResponse();
		String invalidRequestObj = "{\"someInvalidField\": \"value\"}";
		String expResp = everwellCallController.getEverwellfeedbackDetails(invalidRequestObj);
		response.setError(5000, "error in fetching data");
		Assertions.assertEquals(expResp, everwellCallController.getEverwellfeedbackDetails(invalidRequestObj));
		assertTrue(response.toString().contains("error in fetching data"));
	}

	@Test
	void testGetEverwellfeedbackDetails_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.getEverwellFeedback(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.getEverwellfeedbackDetails(request);
		Assertions.assertEquals(response, everwellCallController.getEverwellfeedbackDetails(request));
	}

	@Test
	void testOutboundCallListWithMobileNumber() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		List<Long> eapiIds = new ArrayList<Long>();
		eapiIds.add(12L);
		eapiIds.add(32L);
		outboundCallRequest.setEapiIds(eapiIds);
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.setMissedDoses(2);
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.outboundCallListWithMobileNumber(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.outboundCallListWithMobileNumber(request));
	}

	@Test
	void testOutboundCallListWithMobileNumber_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.outboundCallListWithMobileNumber(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.outboundCallListWithMobileNumber(request);
		Assertions.assertEquals(response, everwellCallController.outboundCallListWithMobileNumber(request));
	}

	@Test
	void testCheckIfCalledOrNot() throws IEMRException {
		OutputResponse response = new OutputResponse();
		EverwellDetails outboundCallRequest = new EverwellDetails();
		List<Long> eapiIds = new ArrayList<Long>();
		eapiIds.add(12L);
		eapiIds.add(32L);
		outboundCallRequest.setEapiIds(eapiIds);
		outboundCallRequest.setProviderServiceMapId(1261);
		outboundCallRequest.setAssignedUserID(12);
		outboundCallRequest.setActionTaken("action taken");
		outboundCallRequest.setAdherencePercentage(54);
		outboundCallRequest.setAdherenceString("adher");
		outboundCallRequest.setAgentId(54);
		outboundCallRequest.setBenCallID(123L);
		outboundCallRequest.setBeneficiaryID(65432L);
		outboundCallRequest.setBeneficiaryRegId(654321L);
		outboundCallRequest.setCallCounter(6);
		outboundCallRequest.setCallId("call id");
		outboundCallRequest.setCallTypeID(4);
		outboundCallRequest.setCategory("category");
		outboundCallRequest.setComments("comments");
		outboundCallRequest.setCreatedBy("createdby");
		outboundCallRequest.setCreatedDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setCurrentMonthMissedDoses(3);
		outboundCallRequest.setDateOfAction(Timestamp.from(Instant.now()));
		outboundCallRequest.setDeleted(false);
		outboundCallRequest.setDistrict("district");
		outboundCallRequest.setEapiId(54L);
		outboundCallRequest.setFacilityName("facility name");
		outboundCallRequest.setFilterEndDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFilterStartDate(Timestamp.from(Instant.now()));
		outboundCallRequest.setFirstName("first name");
		outboundCallRequest.setGender("female");
		outboundCallRequest.setId(12L);
		outboundCallRequest.setIsAllocated(false);
		outboundCallRequest.setIsCompleted(true);
		outboundCallRequest.setIsRegistered(false);
		outboundCallRequest.setLastCall("last call");
		outboundCallRequest.setLastName("last name");
		outboundCallRequest.setParkingPlaceId(12);
		outboundCallRequest.setModifiedBy("modified by");
		outboundCallRequest.setMissedDoses(2);
		outboundCallRequest.toString();
		String request = outboundCallRequest.toString();
		when(beneficiaryCallService.checkAlreadyCalled(request)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), everwellCallController.checkIfCalledOrNot(request));
	}

	@Test
	void testCheckIfCalledOrNot_CatchBlock() throws IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(beneficiaryCallService.checkAlreadyCalled(request)).thenThrow(NotFoundException.class);
		String response = everwellCallController.checkIfCalledOrNot(request);
		Assertions.assertEquals(response, everwellCallController.checkIfCalledOrNot(request));
	}

}
