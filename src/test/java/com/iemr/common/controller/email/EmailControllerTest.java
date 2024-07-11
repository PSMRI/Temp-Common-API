package com.iemr.common.controller.email;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.data.email.EmailNotification;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.model.email.EmailRequest;
import com.iemr.common.model.feedback.AuthorityEmailID;
import com.iemr.common.service.email.EmailService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest {
	
	@InjectMocks
	EmailController emailController;
	
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Mock
	private EmailService emailService;


	@Test
	void testSendEmail() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader("Authorization");
		EmailNotification notification = new EmailNotification();
		notification.setFeedbackID(123L);
		notification.setEmailID("email id");
		notification.setIs1097(true);
		notification.setBenCallID(23L);
		notification.setBeneficiaryRegID(1234L);
		notification.setCreatedBy("createdBy");
		notification.setCreatedDate(Timestamp.from(Instant.now()));
		notification.setDeleted(false);
		notification.setEmail("email");
		notification.setEmailNotificationID(234);
		notification.setEmailSentDate(Timestamp.from(Instant.now()));
		notification.setEmailStatus(123);
		notification.setEmailTemplateID(5432);
		notification.setIsTransactionError(false);
		notification.setPhoneNo("ph no");
		notification.setProviderServiceMapID(3478);
		notification.setReceivingUserID(7654);
		notification.setSenderID(765);
		notification.setTransactionError("trans error");
		notification.setTransactionID("trans id");
		notification.toString();
		String request = notification.toString();
		when(emailService.SendEmail(request, auth)).thenReturn(request);
		response.setResponse(request.toString());
		Assertions.assertEquals(response.toString(), emailController.SendEmail(request, serverRequest));
	}
	
	@Test
	void testSendEmail_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader("Authorization");
		when(emailService.SendEmail(request, auth)).thenThrow(NotFoundException.class);
		String response = emailController.SendEmail(request, serverRequest);
		Assertions.assertEquals(response, emailController.SendEmail(request, serverRequest));
	}

	@Test
	void testGetAuthorityEmailID() throws Exception {
		OutputResponse response = new OutputResponse();
		AuthorityEmailID authorityEmailID = new AuthorityEmailID();
		authorityEmailID.setDistrictID(123);
		authorityEmailID.setAuthorityEmailID(12345);
		authorityEmailID.setDeleted(false);
		authorityEmailID.setEmailID("email id");
		authorityEmailID.toString();
		String severityRequest = authorityEmailID.toString();
		when(emailService.getAuthorityEmailID(severityRequest)).thenReturn(severityRequest);
		response.setResponse(severityRequest.toString());
		Assertions.assertEquals(response.toString(), emailController.getAuthorityEmailID(severityRequest));
	}
	
	@Test
	void testGetAuthorityEmailID_CatchBlock() throws Exception {
		String severityRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		when(emailService.getAuthorityEmailID(severityRequest)).thenThrow(NotFoundException.class);
		String response = emailController.getAuthorityEmailID(severityRequest);
		Assertions.assertEquals(response, emailController.getAuthorityEmailID(severityRequest));
	}

	@Test
	void testSendEmailGeneral() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader("Authorization");
		EmailRequest emailReq = new EmailRequest();
		emailReq.setRequestID("req id");
		emailReq.setEmailType("email type");
		emailReq.setEmailID("email id");
		emailReq.toString();
		String requestID = emailReq.toString();
        when(emailService.sendEmailGeneral(requestID, auth)).thenReturn(requestID);
        response.setResponse(requestID.toString());
        Assertions.assertEquals(response.toString(), emailController.sendEmailGeneral(requestID, serverRequest));
	}
	
	@Test
	void testSendEmailGeneral_CatchBlock() throws Exception {
		String requestID = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String auth = serverRequest.getHeader("Authorization");
		when(emailService.sendEmailGeneral(requestID, auth)).thenThrow(NotFoundException.class);
		String response = emailController.sendEmailGeneral(requestID, serverRequest);
		Assertions.assertEquals(response, emailController.sendEmailGeneral(requestID, serverRequest));
	}

}
