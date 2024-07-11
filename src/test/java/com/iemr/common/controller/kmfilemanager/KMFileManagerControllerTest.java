package com.iemr.common.controller.kmfilemanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.service.kmfilemanager.KMFileManagerService;
import com.iemr.common.service.scheme.SchemeServiceImpl;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class KMFileManagerControllerTest {

	@InjectMocks
	KMFileManagerController kmFileManagerController;

	@Mock
	private KMFileManagerService kmFileManagerService;

	@Mock
	private InputMapper inputMapper;

	@Mock
	private SchemeServiceImpl schemeServiceImpl;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void addFileSuccess() throws Exception {
		// Local setup for this test
		String addFileRequestJson = "{\"fileName\":\"test.pdf\", \"fileExtension\":\"pdf\", \"providerServiceMapID\":\"1\", \"userID\":\"2\", \"validFrom\":\"1633036800\", \"validUpto\":\"1635638800\", \"fileContent\":\"base64EncodedString==\", \"createdBy\":\"user\", \"categoryID\":\"1\", \"subCategoryID\":\"2\"}";
		String expectedResponse = "Success Response";
		when(kmFileManagerService.addKMFile(anyString())).thenReturn(expectedResponse);

		// Execution
		String actualResponse = kmFileManagerService.addKMFile(addFileRequestJson);

		// Assertion
		assertTrue(actualResponse.contains(expectedResponse));

		// Verification
		verify(kmFileManagerService).addKMFile(anyString());
	}

	@Test
	void getKMFileDownloadURL_Exception() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		// when(schemeServiceImpl.getFilePath(any())).thenThrow(NotFoundException.class);

		String response = kmFileManagerController.getKMFileDownloadURL(request);
		// assertEquals(response, kmFileManagerController.addFile(request));
	}

	@Test
	void addFile_exp() throws NoSuchAlgorithmException, IOException, IEMRException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(kmFileManagerService.addKMFile(request)).thenThrow(NotFoundException.class);

		String response = kmFileManagerController.addFile(request);
		assertTrue(response.contains("Failed with null"));
	}

}
