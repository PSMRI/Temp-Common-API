package com.iemr.common.controller.brd;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.service.brd.BRDIntegrationService;

@ExtendWith(MockitoExtension.class)
class BRDIntegrationControllerTest {

	@Mock
	private BRDIntegrationService integrationService;

	@InjectMocks
	private BRDIntegrationController controller;

	@Test
	void getDetailsSuccess() throws Exception {
		// Arrange
		String request = new JSONObject().put("startDate", "2021-01-01").put("endDate", "2021-01-31").toString();
		String expectedResponse = "Expected BRD Data";
		when(integrationService.getData(anyString(), anyString())).thenReturn(expectedResponse);

		// Act
		String actualResponse = controller.getDetails(request);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains(expectedResponse));

		// Verify that the integration service is called once with any strings
		verify(integrationService).getData(anyString(), anyString());
	}

	@Test
	void getDetailsFailure() {
		// Arrange
		String request = "invalid JSON";

		// Act
		String actualResponse = controller.getDetails(request);

		// Assert
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Unable to get BRD data"));

	}

}
