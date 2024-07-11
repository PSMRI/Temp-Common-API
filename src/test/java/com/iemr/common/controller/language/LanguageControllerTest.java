package com.iemr.common.controller.language;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.service.userbeneficiarydata.LanguageService;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class LanguageControllerTest {

	@InjectMocks
	private LanguageController languageController;

	@Mock
	private LanguageService languageService;

	@Test
	void testGetLanguageListSuccess() {
		// Prepare mocked data

		Language language1 = new Language(1, "English", "ENG", "a", "b");
		Language language2 = new Language(2, "Spanish", "SPA", "a", "b");
		List<Language> mockLanguageList = Arrays.asList(language1, language2);

		// Mock the service's response
		when(languageService.getActiveLanguages()).thenReturn(mockLanguageList);

		// Execute the controller method
		String response = languageController.getLanguageList();

		// Assertions
		assertNotNull(response);
		assertTrue(response.contains("English"));
		assertTrue(response.contains("Spanish"));

		// Verify the service was called once
		verify(languageService).getActiveLanguages();
	}

	@Test
	void getCategoriesTest_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(languageService.getActiveLanguages().toString()).thenThrow(NotFoundException.class);

		String response = languageController.getLanguageList();

		assertTrue(response.contains("Failed with null"));
	}

}
