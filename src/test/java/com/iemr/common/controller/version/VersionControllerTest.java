package com.iemr.common.controller.version;

//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.Method;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(MockitoExtension.class)
//class VersionControllerTest {
//	private static final String EXPECTED_RESPONSE = "version=1.0\n";
//
//	@InjectMocks
//	private VersionController versionController;
//
//	@Test
//	void testVersionInformation() throws Exception {
//		String inputData = "version=1.0";
//		InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//		Method readFromInputStreamMethod = VersionController.class.getDeclaredMethod("readFromInputStream",
//				InputStream.class);
//		readFromInputStreamMethod.setAccessible(true);
//
//		// Act
//		String actualResponse = (String) readFromInputStreamMethod.invoke(versionController, inputStream);
//
//		// Assert
//		assertNotNull(actualResponse);
//		assertEquals(EXPECTED_RESPONSE, actualResponse);
//	}
//}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class VersionControllerTest {
	private static final String EXPECTED_RESPONSE = "version=1.0\n";

	@InjectMocks
	private VersionController versionController;
	private MockMvc mockMvc;

	@Test
	void testReadFromInputStream() throws Exception {
		String inputData = "version=1.0";
		InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		Method readFromInputStreamMethod = VersionController.class.getDeclaredMethod("readFromInputStream",
				InputStream.class);
		readFromInputStreamMethod.setAccessible(true);

		// Act
		String actualResponse = (String) readFromInputStreamMethod.invoke(versionController, inputStream);

		// Assert
		assertNotNull(actualResponse);
		assertEquals(EXPECTED_RESPONSE, actualResponse);
	}
}
