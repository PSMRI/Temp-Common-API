package com.iemr.common.controller.users;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.common.net.HttpHeaders;
import com.iemr.common.data.users.EmployeeSignature;
import com.iemr.common.service.users.EmployeeSignatureServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeSignatureControllerTest {

	private MockMvc mockMvc;

	@Mock
	private EmployeeSignatureServiceImpl employeeSignatureServiceImpl;

	@InjectMocks
	private EmployeeSignatureController employeeSignatureController;

	@BeforeEach
	void setUp() {
		mockMvc = standaloneSetup(employeeSignatureController).build();
	}

	@Test
	void testFetchFile() throws Exception {
		Long userId = 1L;
		byte[] signature = new byte[] { 1, 2, 3 };
		EmployeeSignature employeeSignature = new EmployeeSignature();
		employeeSignature.setFileName("signature.pdf");
		employeeSignature.setFileType("application/pdf");
		employeeSignature.setSignature(signature);

		when(employeeSignatureServiceImpl.fetchSignature(userId)).thenReturn(employeeSignature);

		mockMvc.perform(get("/signature1/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.parseMediaType("application/pdf")))
				.andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"signature.pdf\""));

		verify(employeeSignatureServiceImpl, times(1)).fetchSignature(userId);
	}

	@Test
	void fetchFile_ExceptionThrown_ReturnsBadRequest() throws Exception {
		// Arrange
		Long userID = 1L;
		doThrow(RuntimeException.class).when(employeeSignatureServiceImpl).fetchSignature(anyLong());

		// Act & Assert
		MockHttpServletResponse response = mockMvc.perform(
				MockMvcRequestBuilders.get("/signature1/{userID}", userID).header("Authorization", "Bearer someToken"))
				.andExpect(status().isBadRequest()).andReturn().getResponse();

		// Optionally, you can check if the response body is empty as well, as your
		// method suggests it should be
		assert (response.getContentLength() == 0 || new String(response.getContentAsByteArray()).isEmpty());
	}

	@Test
	void testFetchFileFromCentral() throws Exception {
		Long userId = 1L;
		EmployeeSignature employeeSignature = new EmployeeSignature();
		employeeSignature.setUserID(1L);
		// Assuming you set more fields as needed here

		when(employeeSignatureServiceImpl.fetchSignature(userId)).thenReturn(employeeSignature);

		mockMvc.perform(get("/signature1/getSignClass/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk())
				// Adjust this to match expected response structure
				.andExpect(content().string(containsString("\"statusCode\":200")))
				.andExpect(content().string(containsString("\"status\":\"Success\"")));

		verify(employeeSignatureServiceImpl, times(1)).fetchSignature(userId);
	}

	@Test
	void testFetchFileFromCentral_NoRecordFound() throws Exception {
		Long userId = 1L;
		when(employeeSignatureServiceImpl.fetchSignature(userId)).thenReturn(null);

		mockMvc.perform(get("/signature1/getSignClass/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk()).andExpect(content().string(containsString("No record found")));

		verify(employeeSignatureServiceImpl).fetchSignature(userId);
	}

	@Test
	void testFetchFileFromCentral_ExceptionThrown() throws Exception {
		Long userId = 1L;
		when(employeeSignatureServiceImpl.fetchSignature(userId)).thenThrow(new RuntimeException("Test exception"));

		mockMvc.perform(get("/signature1/getSignClass/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk()) // Assuming your error handling still returns HTTP 200
				.andExpect(content().string(containsString("Test exception")));

		verify(employeeSignatureServiceImpl).fetchSignature(userId);
	}

	@Test
	void testExistFile() throws Exception {
		Long userId = 1L;
		Boolean exists = true;

		when(employeeSignatureServiceImpl.existSignature(userId)).thenReturn(exists);

		mockMvc.perform(get("/signature1/signexist/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk())
				// Adjust the assertion to match the JSON response structure
				.andExpect(content().string(containsString("\"response\":\"true\"")))
				.andExpect(content().string(containsString("\"statusCode\":200")))
				.andExpect(content().string(containsString("\"status\":\"Success\"")));

		verify(employeeSignatureServiceImpl, times(1)).existSignature(userId);
	}

	@Test
	void testExistFile_ExceptionThrown() throws Exception {
		// Arrange
		Long userId = 1L;
		String expectedErrorMessage = "An error occurred";
		doThrow(new RuntimeException(expectedErrorMessage)).when(employeeSignatureServiceImpl).existSignature(userId);

		// Act & Assert
		mockMvc.perform(get("/signature1/signexist/{userID}", userId).header("Authorization", "Bearer someToken"))
				.andExpect(status().isOk()) // Assuming your error handling logic results in HTTP 200
				.andExpect(content().string(org.hamcrest.Matchers.containsString(expectedErrorMessage)));

		// Verify that the service method was called
		verify(employeeSignatureServiceImpl).existSignature(userId);
	}

}
