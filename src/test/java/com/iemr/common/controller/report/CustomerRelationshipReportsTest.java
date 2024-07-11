package com.iemr.common.controller.report;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.mapper.Report1097Mapper;
import com.iemr.common.service.reports.CallReportsService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class CustomerRelationshipReportsTest {

	@InjectMocks
	CustomerRelationshipReports customerRelationshipReports;

	@Mock
	private CallReportsService callReportsService;

	@Mock
	Report1097Mapper mapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InputMapper inputMapper = new InputMapper();


	@Test
	void testPatientAppChiefComplaintsMasterData1() throws Exception {
		Integer providerServiceMapID = 1;
		String expectedResponse = "expected response";

		// String for simplicity
		when(callReportsService.getReportTypes(providerServiceMapID)).thenReturn(expectedResponse);

		// The actual call to the method under test
		String actualResponse = customerRelationshipReports.patientAppChiefComplaintsMasterData(providerServiceMapID);

		// Verify the interaction with the mock
		verify(callReportsService).getReportTypes(providerServiceMapID);

		// Assert that the actualResponse matches what you expect
		assertNotNull(actualResponse, "The response should not be null");
		assertTrue(actualResponse.contains(expectedResponse), "The response should contain the expected response");
	}
}
