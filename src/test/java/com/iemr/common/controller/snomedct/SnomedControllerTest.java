package com.iemr.common.controller.snomedct;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.gson.Gson;
import com.iemr.common.data.snomedct.SCTDescription;
import com.iemr.common.service.snomedct.SnomedService;

class SnomedControllerTest {

	@Mock
	private SnomedService snomedService;

	@InjectMocks
	private SnomedController snomedController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getSnomedCTRecord_Success() throws Exception {
		SCTDescription inputDesc = new SCTDescription();
		inputDesc.setTerm("Diabetes");
		SCTDescription outputDesc = new SCTDescription();
		outputDesc.setConceptID("123456");
		outputDesc.setTerm("Diabetes");

		when(snomedService.findSnomedCTRecordFromTerm("Diabetes")).thenReturn(outputDesc);

		String requestJson = new Gson().toJson(inputDesc);
		String response = snomedController.getSnomedCTRecord(requestJson);

		assertTrue(response.contains("123456"));
		verify(snomedService, times(1)).findSnomedCTRecordFromTerm("Diabetes");
	}

	@Test
	void getSnomedCTRecord_NoRecordsFound() throws Exception {
		SCTDescription inputDesc = new SCTDescription();
		inputDesc.setTerm("Unknown");

		when(snomedService.findSnomedCTRecordFromTerm("Unknown")).thenReturn(null);

		String requestJson = new Gson().toJson(inputDesc);
		String response = snomedController.getSnomedCTRecord(requestJson);

		assertTrue(response.contains("No Records Found"));
		verify(snomedService, times(1)).findSnomedCTRecordFromTerm("Unknown");
	}

	@Test
	void getSnomedCTRecordExceptionTest() {
		// Prepare test data
		String requestJson = "{\"term\":\"throwException\"}";

		// Mock behavior to throw an exception
		when(snomedService.findSnomedCTRecordFromTerm(anyString())).thenThrow( RuntimeException.class);

		// Execute the test method
		String actualResponse = snomedController.getSnomedCTRecord(requestJson);
		
		//System.out.println("actr" + actualResponse);

		// Assertions
		assertNotNull(actualResponse);
		// Assuming OutputResponse.toString() properly serializes error info
		assertTrue(actualResponse.contains("Failed with null")); // Adjust based on your actual error handling output

		// Verify the interaction with the mocked service
		verify(snomedService).findSnomedCTRecordFromTerm(anyString());
	}

	@Test
	void getSnomedCTRecordListTest() throws Exception {
		// Prepare test data
		String requestJson = "{\"term\":\"exampleTerm\"}";
		String expectedResponse = "Mocked Response";
		SCTDescription sctDescription = new SCTDescription();
		sctDescription.setTerm("exampleTerm");

		// Define behavior of mocks
		given(snomedService.findSnomedCTRecordList(any(SCTDescription.class))).willReturn(expectedResponse);

		// Call the method to test
		String actualResponse = snomedController.getSnomedCTRecordList(requestJson);

		// Verify the results
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains(expectedResponse));

		// Verify interactions
		verify(snomedService).findSnomedCTRecordList(any(SCTDescription.class));
	}

	@Test
	void getSnomedCTRecordListNoRecordsFoundTest() throws Exception {
		// Prepare test data
		String requestJson = "{\"term\":\"exampleTerm\"}";
		String expectedServiceResponse = "No Records Found"; // Adjust based on actual no records message

		// Mock behavior
		given(snomedService.findSnomedCTRecordList(any(SCTDescription.class))).willReturn(expectedServiceResponse);

		// Execute the test method
		String actualResponse = snomedController.getSnomedCTRecordList(requestJson);

		// Assertions
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("No Records Found"));

		// Verify the interaction with the mocked service
		verify(snomedService).findSnomedCTRecordList(any(SCTDescription.class));
	}

	@Test
	void getSnomedCTRecordListExceptionTest() throws Exception {
		// Prepare test data
		String requestJson = "{\"term\":\"errorTerm\"}";
		String expectedErrorMessage = "Error"; // Simplified, adjust based on your error handling

		// Mock behavior to throw an exception
		willThrow(new RuntimeException("Unexpected Error")).given(snomedService)
				.findSnomedCTRecordList(any(SCTDescription.class));

		// Execute the test method
		String actualResponse = snomedController.getSnomedCTRecordList(requestJson);

		// Assertions
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains(expectedErrorMessage)); // Verify that error message or handling is as
																	// expected

		// Verify the interaction with the mocked service
		verify(snomedService).findSnomedCTRecordList(any(SCTDescription.class));
	}

}
