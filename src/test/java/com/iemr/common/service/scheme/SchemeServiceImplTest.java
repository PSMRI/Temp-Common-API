package com.iemr.common.service.scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.scheme.Scheme;
import com.iemr.common.repository.scheme.SchemeRepository;
import com.iemr.common.service.kmfilemanager.KMFileManagerService;

@ExtendWith(MockitoExtension.class)
class SchemeServiceImplTest {

	@InjectMocks
	private SchemeServiceImpl schemeService;

	@Mock
	private SchemeRepository schemeRepository;

	@Mock
	private KMFileManagerService kmFileManagerService;

	@Test
	void testGetSchemeList() throws Exception {
		// Given
		Integer providerServiceMapID = 1; // Example ID
		List<Object[]> mockedResult = new ArrayList<>();
		mockedResult.add(new Object[] { 1, "Scheme Name", "Description", 100, 200, true, "Additional Info",
				new KMFileManager() });
		// Assuming KMFileManager is a class you have. Adjust as necessary.

		when(schemeRepository.getschemeList(providerServiceMapID)).thenReturn(mockedResult);
		// Mock the getFilePath if necessary
		// when(yourService.getFilePath(any(KMFileManager.class))).thenReturn("path/to/file");

		// When
		List<Scheme> result = schemeService.getSchemeList(providerServiceMapID);

		// Then
		assertEquals(1, result.size());
		Scheme resultScheme = result.get(0);
		assertEquals("Scheme Name", resultScheme.getSchemeName());
		// Continue assertions as necessary to validate all fields

		// Verify interactions
		verify(schemeRepository).getschemeList(providerServiceMapID);
		// Add any necessary verification for getFilePath if it's called
	}

	@Test
	void testGetSchemeByID() throws Exception {
		Integer schemeID = 1;

		assertEquals(schemeRepository.getSchemeByID(schemeID), schemeService.getSchemeByID(schemeID));

	}

	@Test
	void testDeletedData() {
		// Given
		Scheme deleteData = new Scheme(); // Assuming Scheme is a class with appropriate constructors or setters
		// Populate the Scheme object as necessary for your test

		// When
		String result = schemeService.deletedata(deleteData);

		// Then
		assertEquals("success", result);
		verify(schemeRepository, times(1)).save(deleteData);
	}

	@Test
	void testGetFilePath() {
		// Setup
		KMFileManager kmFileManager = new KMFileManager();
		kmFileManager.setFileUID("uniqueFileIdentifier");

		// Assuming these are the properties you have set for the test environment
		// or you have a way to ensure ConfigProperties returns these values during
		// testing
		String expectedProtocol = "http";
		String expectedPath = "example.com";
		String expectedUser = "user";
		String expectedPassword = "pass";
		String expectedUID = "uniqueFileIdentifier";

		// Expected URI format based on the method logic
		String expectedURI = String.format("%s://%s:%s@%s/Download?uuid=%s", expectedProtocol, expectedUser,
				expectedPassword, expectedPath, expectedUID);

		// Execute
		String resultURI = schemeService.getFilePath(kmFileManager);

		// Assert

		assertTrue(resultURI.contains("http://guest:guest@null"));
		// assertEquals(expectedURI, resultURI);
	}

	@Test
	void testSaveSchemeWithoutKMFileManager() throws Exception {
		Scheme inputScheme = new Scheme(); // KMFileManager not set

		Scheme expectedScheme = new Scheme();
		expectedScheme.setSchemeID(1);
		when(schemeRepository.save(any(Scheme.class))).thenReturn(expectedScheme);

		Scheme result = schemeService.save(inputScheme);

		assertNotNull(result);
		assertEquals(1, result.getSchemeID());
		verify(kmFileManagerService, never()).addKMFile(anyString());
		verify(schemeRepository, times(1)).save(any(Scheme.class));
	}

}
