package com.iemr.common.controller.otp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.otp.OTPRequestParsor;
import com.iemr.common.service.otp.OTPHandler;

@ExtendWith(MockitoExtension.class)
class OTPGatewayTest {

	@Mock
	private OTPHandler otpHandler;
	@InjectMocks
	private OTPGateway otpGatewayservice;

	@Test
	void testSendOTPSuccess() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\"}";
		when(otpHandler.sendOTP(any(OTPRequestParsor.class))).thenReturn("success");

		// Act
		String result = otpGatewayservice.sendOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("success"));
	}

	@Test
	void testSendOTPFailure() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\"}";
		when(otpHandler.sendOTP(any(OTPRequestParsor.class))).thenReturn("failure");

		// Act
		String result = otpGatewayservice.sendOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("failure"));
	}

	@Test
	void testValidateOTPSuccess() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\",\"otp\":\"1234\"}";
		JSONObject mockResponse = new JSONObject().put("status", "success");
		when(otpHandler.validateOTP(any(OTPRequestParsor.class))).thenReturn(mockResponse);

		// Act
		String result = otpGatewayservice.validateOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("success"));
	}

	@Test
	void testValidateOTPFailure() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\",\"otp\":\"1234\"}";
		when(otpHandler.validateOTP(any(OTPRequestParsor.class))).thenReturn(null);

		// Act
		String result = otpGatewayservice.validateOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("failure"));
	}

	@Test
	void testResendOTPSuccess() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\"}";
		when(otpHandler.resendOTP(any(OTPRequestParsor.class))).thenReturn("success");

		// Act
		String result = otpGatewayservice.resendOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("success"));
	}

	@Test
	void testResendOTPFailure() throws Exception {
		// Arrange
		String requestJson = "{\"mobNo\":\"1234567890\"}";
		when(otpHandler.resendOTP(any(OTPRequestParsor.class))).thenReturn("failure");

		// Act
		String result = otpGatewayservice.resendOTP(requestJson);

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("failure"));
	}

}
