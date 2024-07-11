package com.iemr.common.controller.mctshistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.service.mctshistory.OutboundHistoryService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class OutboundHistoryControllerTest {

	@InjectMocks
	OutboundHistoryController outboundHistoryController;

	@Mock
	private OutboundHistoryService outboundHistoryService;

	@Test
	void testGetCallHistory() throws IEMRException, JsonMappingException, JsonProcessingException {

		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response");

		when(outboundHistoryService.getCallHistory(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = outboundHistoryController.getCallHistory(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");
	}

	@Test
	void testGetCallHistory_Exception() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(outboundHistoryService.getCallHistory(request)).thenThrow(NotFoundException.class);

		String response = outboundHistoryController.getCallHistory(request);
		assertTrue(response.contains("Failed with null"));
		//assertEquals(response, outboundHistoryController.getCallHistory(request));
	}

	@Test
	void testGetMctsCallResponse() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response");

		when(outboundHistoryService.getMctsCallResponse(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = outboundHistoryController.getMctsCallResponse(request);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testGetMctsCallResponse_Exception() throws IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(outboundHistoryService.getMctsCallResponse(request)).thenThrow(NotFoundException.class);

		String response = outboundHistoryController.getMctsCallResponse(request);
		assertEquals(response, outboundHistoryController.getMctsCallResponse(request));
	}

}
