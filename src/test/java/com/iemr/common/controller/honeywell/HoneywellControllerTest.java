package com.iemr.common.controller.honeywell;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.service.honeywell.HoneywellService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class HoneywellControllerTest {

	@InjectMocks
	HoneywellController honeywellController;

	@Mock
	private HoneywellService honeywellService;

	@Test
	void testGetRealtimeDistrictWiseCallReport() throws Exception {
		// String request = "{}";
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(honeywellService.getRealtimeDistrictWiseCallReport()).thenReturn("any response");

		// Execute the test
		String actualResponse = honeywellController.getRealtimeDistrictWiseCallReport();

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testGetRealtimeDistrictWiseCallReport_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(honeywellService.getRealtimeDistrictWiseCallReport()).thenThrow(NotFoundException.class);
		String response = honeywellController.getRealtimeDistrictWiseCallReport();
		assertEquals(response, honeywellController.getRealtimeDistrictWiseCallReport());
	}

	@Test
	void testGetDistrictWiseCallReport() throws Exception {
		String request = "";
		HttpServletRequest httpRequest = null;
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(honeywellService.getDistrictWiseCallReport(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = honeywellController.getDistrictWiseCallReport(request, httpRequest);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testGetDistrictWiseCallReport_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = null;
		when(honeywellService.getDistrictWiseCallReport(request)).thenThrow(NotFoundException.class);
		String response = honeywellController.getDistrictWiseCallReport(request, httpRequest);
		assertEquals(response, honeywellController.getDistrictWiseCallReport(request, httpRequest));
	}

	@Test
	void testGetUrbanRuralCallReport() throws Exception {
		String request = "";
		HttpServletRequest httpRequest = null;
		String expectedResponse = "{\"data\":{\"response\":\"any response\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

		OutputResponse mockResponse = new OutputResponse();
		mockResponse.setResponse("any response"); // Set this to whatever you expect from the real operation

		when(honeywellService.getUrbanRuralCallReport(request)).thenReturn("any response");

		// Execute the test
		String actualResponse = honeywellController.getUrbanRuralCallReport(request, httpRequest);

		// Assert the response
		assertEquals(expectedResponse, actualResponse, "The expected and actual responses do not match");

	}

	@Test
	void testGetUrbanRuralCallReport_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest httpRequest = null;
		when(honeywellService.getUrbanRuralCallReport(request)).thenThrow(NotFoundException.class);
		String response = honeywellController.getUrbanRuralCallReport(request, httpRequest);
		assertEquals(response, honeywellController.getUrbanRuralCallReport(request, httpRequest));

	}
}
