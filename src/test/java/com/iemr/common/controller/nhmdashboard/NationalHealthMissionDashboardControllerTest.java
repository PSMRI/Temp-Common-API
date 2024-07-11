package com.iemr.common.controller.nhmdashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.nhm_dashboard.AbandonCallSummary;
import com.iemr.common.service.nhm_dashboard.NHM_DashboardService;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class NationalHealthMissionDashboardControllerTest {

	@InjectMocks
	NationalHealthMissionDashboardController nationalHealthMissionDashboardController;

	@Mock
	private NHM_DashboardService nHM_DashboardService;

	@Test
	void testPushAbandonCallsSuccess() throws Exception {
		// Arrange
		AbandonCallSummary abandonCallSummary = new AbandonCallSummary(); // mock or create instance as required
		when(nHM_DashboardService.pushAbandonCalls(abandonCallSummary)).thenReturn("Success response");

		// Act
		String result = nationalHealthMissionDashboardController.pushAbandonCallsFromC_Zentrix(abandonCallSummary);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("Success response"));
	}


	@Test
	void testGetAbandonCallsSuccess() throws Exception {
		// Arrange
		String expectedResponse = "Mocked abandon calls response";
		when(nHM_DashboardService.getAbandonCalls()).thenReturn(expectedResponse);

		// Act
		String result = nationalHealthMissionDashboardController.getAbandonCalls();

		// Assert
		assertNotNull(result);
		assertTrue(result.contains(expectedResponse));
	}


	@Test
	void testGetAgentSummaryReport_Success() throws Exception {
		// Arrange
		String expectedResponse = "Mocked Agent Summary Report";
		when(nHM_DashboardService.getAgentSummaryReport()).thenReturn(expectedResponse);

		// Act
		String result = nationalHealthMissionDashboardController.getAgentSummaryReport();

		// Assert
		assertNotNull(result);
		assertTrue(result.contains(expectedResponse));
	}

	@Test
	void testGetDetailedCallReport_Success() throws Exception {
		// Arrange
		String expectedResponse = "Mocked Detailed Call Report";
		when(nHM_DashboardService.getDetailedCallReport()).thenReturn(expectedResponse);

		// Act
		String result = nationalHealthMissionDashboardController.getDetailedCallReport();

		// Assert
		assertNotNull(result);
		assertTrue(result.contains(expectedResponse));
	}

	@Test
	void pushAbandonCallsFromC_Zentrix_exp() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(nHM_DashboardService.pushAbandonCalls(any())).thenThrow(NotFoundException.class);

		String response = nationalHealthMissionDashboardController.pushAbandonCallsFromC_Zentrix(any());
		assertEquals(response, nationalHealthMissionDashboardController.pushAbandonCallsFromC_Zentrix(any()));
	}

	@Test
	void getAbandonCalls_exp() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(nHM_DashboardService.getAbandonCalls()).thenThrow(NotFoundException.class);

		String response = nationalHealthMissionDashboardController.getAbandonCalls();
		assertEquals(response, nationalHealthMissionDashboardController.getAbandonCalls());
	}

	@Test
	void getAgentSummaryReport_exp() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(nHM_DashboardService.getAgentSummaryReport()).thenThrow(NotFoundException.class);

		String response = nationalHealthMissionDashboardController.getAgentSummaryReport();
		assertEquals(response, nationalHealthMissionDashboardController.getAgentSummaryReport());
	}

	@Test
	void getDetailedCallReport_exp() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(nHM_DashboardService.getDetailedCallReport()).thenThrow(NotFoundException.class);

		String response = nationalHealthMissionDashboardController.getDetailedCallReport();
		assertEquals(response, nationalHealthMissionDashboardController.getDetailedCallReport());
	}

}
