package com.iemr.common.controller.door_to_door_app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.door_to_door_app.RequestParser;
import com.iemr.common.service.door_to_door_app.DoorToDoorService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class DoorToDoorAppControllerTest {
	
	@InjectMocks
	DoorToDoorAppController doorToDoorAppController;
	
	@Mock
	private DoorToDoorService doorToDoorService;
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testGetUserDetails() throws Exception {
		OutputResponse response = new OutputResponse();
		RequestParser rp = new RequestParser();
		rp.setUserID(123);
		rp.setBenRegID(12L);
		rp.setSuspectedHRP("hrp");
		rp.setSuspectedNCD("ncd");
		rp.setSuspectedTB("tb");
		rp.setVisitCode(523L);
		rp.toString();
		String requestObj = rp.toString();
		when(doorToDoorService.getUserDetails(requestObj)).thenReturn(requestObj);
		response.setResponse(requestObj.toString());
		String expResp = "Exp Resp";
		String actualResp = doorToDoorAppController.getUserDetails(requestObj);
		assertNotNull(actualResp);
		Assertions.assertEquals(response.toString(), doorToDoorAppController.getUserDetails(requestObj));
	}
	
	@Test
	void testGetUserDetails_InvalidRequest() throws Exception {
		String invalidRequestObj = "{\"someInvalidField\": \"value\"}"; // An example of an invalid request object
		String response = doorToDoorAppController.getUserDetails(invalidRequestObj);
		assertTrue(response.contains("user details not found"), "Expected error message not found in the response.");
	}
	
	@Test
	void testGetUserDetails_CatchBlock() throws Exception {
		String requestObj = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(doorToDoorService.getUserDetails(requestObj)).thenThrow(NotFoundException.class);
		String response = doorToDoorAppController.getUserDetails(requestObj);
		Assertions.assertEquals(response, doorToDoorAppController.getUserDetails(requestObj));
	}

	@Test
	void testGetSuspectedData_HRP_TB_NCD() throws Exception {
		OutputResponse response = new OutputResponse();
		RequestParser rp = new RequestParser();
		rp.setUserID(123);
		rp.setBenRegID(12L);
		rp.setSuspectedHRP("hrp");
		rp.setSuspectedNCD("ncd");
		rp.setSuspectedTB("tb");
		rp.setVisitCode(523L);
		rp.toString();
		String s = rp.toString();
		String requestObj = s;
		response.setResponse(requestObj.toString());
		String actualResp = doorToDoorAppController.getSuspectedData_HRP_TB_NCD(requestObj);
		assertNotNull(actualResp);
		Assertions.assertEquals(actualResp, doorToDoorAppController.getSuspectedData_HRP_TB_NCD(requestObj));
	}
	
	@Test
	void testGetSuspectedData_HRP_TB_NCD_InvalidRequest() throws Exception {
		String invalidRequestObj = "{\"someInvalidField\": \"value\"}";
		String response = doorToDoorAppController.getSuspectedData_HRP_TB_NCD(invalidRequestObj);
		assertTrue(response.contains("Error in getting suspected information"), "Expected error message not found in the response.");
	}
	
	@Test
	void testGetSuspectedData_HRP_TB_NCD_CatchBlock() throws Exception {
		String requestObj = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		RequestParser rp = new RequestParser();
		rp.setUserID(123);
		when(doorToDoorService.get_NCD_TB_HRP_Suspected_Status(rp)).thenThrow(NotFoundException.class);
		String response = doorToDoorAppController.getSuspectedData_HRP_TB_NCD(requestObj);
		Assertions.assertEquals(response, doorToDoorAppController.getSuspectedData_HRP_TB_NCD(requestObj));
	}

}
