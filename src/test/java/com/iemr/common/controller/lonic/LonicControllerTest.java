package com.iemr.common.controller.lonic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.lonic.LonicDescription;
import com.iemr.common.service.lonic.LonicService;

@ExtendWith(MockitoExtension.class)
class LonicControllerTest {

	@InjectMocks
	LonicController lonicController;

	@Mock
	private LonicService lonicService;

	@Test
	void getLonicRecordListSuccess() throws Exception {
		// Arrange
		String requestJson = "{\"term\":\"testTerm\",\"pageNo\":1}";
		String expectedResponse = "[{\"id\":\"1\",\"description\":\"Test Description\"}]";
		when(lonicService.findLonicRecordList(any(LonicDescription.class))).thenReturn(expectedResponse);

		// Act
		String result = lonicController.getLonicRecordList(requestJson);

		// Assert
		assertNotNull(result, "The result should not be null.");
		assertTrue(result.contains(expectedResponse), "The result should contain the expected response.");
	}

	@Test
	void getLonicRecordListNoRecordsFound() throws Exception {
		// Arrange
		String requestJson = "{\"term\":\"unknownTerm\",\"pageNo\":1}";
		when(lonicService.findLonicRecordList(any(LonicDescription.class))).thenReturn(null); // Simulating no records
																								// found

		// Act
		String result = lonicController.getLonicRecordList(requestJson);

		// Assert
		assertNotNull(result, "The result should not be null.");
		assertTrue(result.contains("No Records Found"), "The result should indicate no records were found.");
	}

	@Test
	void getLonicRecordListException() throws Exception {
		// Arrange
		String requestJson = "{\"term\":\"testTerm\",\"pageNo\":1}";
		when(lonicService.findLonicRecordList(any(LonicDescription.class)))
				.thenThrow(new RuntimeException("Test exception"));

		// Act
		String result = lonicController.getLonicRecordList(requestJson);

		// Assert
		assertNotNull(result, "The result should not be null.");
		assertTrue(result.contains("error"), "The result should contain error information.");
	}

}
