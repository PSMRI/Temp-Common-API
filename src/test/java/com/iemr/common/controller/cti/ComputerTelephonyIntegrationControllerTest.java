package com.iemr.common.controller.cti;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.data.cti.AgentLoginKey;
import com.iemr.common.data.cti.AgentSkills;
import com.iemr.common.data.cti.AgentState;
import com.iemr.common.data.cti.CTICampaigns;
import com.iemr.common.data.cti.CTIUser;
import com.iemr.common.data.cti.CTIVoiceFile;
import com.iemr.common.data.cti.CallBeneficiary;
import com.iemr.common.data.cti.CallDisposition;
import com.iemr.common.data.cti.CampaignNames;
import com.iemr.common.data.cti.CampaignRole;
import com.iemr.common.data.cti.CampaignSkills;
import com.iemr.common.data.cti.CustomerLanguage;
import com.iemr.common.data.cti.TransferCall;
import com.iemr.common.service.cti.CTIService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;
@ExtendWith(MockitoExtension.class)
class ComputerTelephonyIntegrationControllerTest {
	
	@InjectMocks
	ComputerTelephonyIntegrationController computerTelephonyIntegrationController;
	
	@Mock
	CTIService ctiService;
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	

	@Test
	void testGetCampaignSkills() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		CampaignSkills campaign = new CampaignSkills();
		campaign.setCampaign_name("name");
		String request = campaign.toString();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		when(ctiService.getCampaignSkills(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getCampaignSkills(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getCampaignSkills(request, serverRequest));
	}
	
	@Test
	void testGetCampaignSkills_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getCampaignSkills(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getCampaignSkills(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getCampaignSkills(request, serverRequest));
	}

	@Test
	void testGetAgentState() throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		AgentState agentState = new AgentState();
		agentState.setAgent_id("agent id");
		String request = agentState.toString();
		when(ctiService.getAgentState(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAgentState(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAgentState(request, serverRequest));
	}
	
	@Test
	void testGetAgentState_CatchBlock() throws JSONException, IEMRException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getAgentState(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getAgentState(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getAgentState(request, serverRequest));
	}

	@Test
	void testGetAgentCallStats() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		AgentState agentState = new AgentState();
		agentState.setAgent_id("agent id");
		String request = agentState.toString();
		when(ctiService.getAgentCallStats(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAgentCallStats(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAgentCallStats(request, serverRequest));
	}
	
	@Test
	void testGetAgentCallStats_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getAgentCallStats(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getAgentCallStats(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getAgentCallStats(request, serverRequest));
	}

	@Test
	void testGetCampaignNames() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		CampaignNames names = new CampaignNames();
		names.setServiceName("service name");
		names.setType("type");
		String request = names.toString();
		when(ctiService.getCampaignNames(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getCampaignNames(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getCampaignNames(request, serverRequest));
	}
	
	@Test
	void testGetCampaignNames_CatchBlock()  throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException{
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getCampaignNames(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getCampaignNames(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getCampaignNames(request, serverRequest));
	}

	@Test
	void testGetLoginKey()  throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		AgentLoginKey agentState = new AgentLoginKey();
		agentState.setUsername("username");
		agentState.setPassword("password");
		String request = agentState.toString();
		when(ctiService.getLoginKey(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getLoginKey(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getLoginKey(request, serverRequest));
	}
	
	@Test
	void testGetLoginKey_CatchBlock()  throws IEMRException, JSONException, JsonMappingException, JsonProcessingException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getLoginKey(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getLoginKey(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getLoginKey(request, serverRequest));
	}

	@Test
	void testDoAgentLogout() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		AgentState agentState = new AgentState();
		agentState.setAgent_id("agent id");
		String request = agentState.toString();
		when(ctiService.agentLogout(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.doAgentLogout(request, serverRequest));
	}
	
	@Test
	void testDoAgentLogout_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.agentLogout(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.doAgentLogout(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.doAgentLogout(request, serverRequest));
	}

	@Test
	void testGetOnlineAgents() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		AgentState agentState = new AgentState();
		agentState.setAgent_id("agent id");
		String request = agentState.toString();
		when(ctiService.getOnlineAgents(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getOnlineAgents(request, serverRequest));
	}
	
	@Test
	void testGetOnlineAgents_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getOnlineAgents(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getOnlineAgents(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getOnlineAgents(request, serverRequest));
	}

	@Test
	void testCallBeneficiary() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn(null);
		CallBeneficiary agentState = new CallBeneficiary();
		agentState.setAgent_id("agent id");
		agentState.setPhone_num("ph no");
		String request = agentState.toString();
		when(ctiService.callBeneficiary(request, null)).thenReturn(response);
		response.setResponse(request.toString());
		reset(serverRequest);
		when(serverRequest.getHeader("X-FORWARDED-FOR")).thenReturn("");
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.callBeneficiary(request, serverRequest));
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.callBeneficiary(request, serverRequest));
	}
	
	@Test
	void testCallBeneficiary_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.callBeneficiary(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.callBeneficiary(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.callBeneficiary(request, serverRequest));
	}

	@Test
	void testAddUpdateUserData() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CTIUser state = new CTIUser();
		state.setUsername("username");
		state.setPassword("password");
		state.setFirstname("firstname");
		state.setLastname("last name");
		state.setPhone("phone");
		state.setEmail("email");
		state.setRole("role");
		state.setDesignation("designation");
		String request = state.toString();
		when(ctiService.addUpdateUserData(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.addUpdateUserData(request, serverRequest));
	}
	
	@Test
	void testAddUpdateUserData_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.addUpdateUserData(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.addUpdateUserData(request, serverRequest);
		assertTrue(response.contains("Failed with null"));
	}

	@Test
	void testGetTransferCampaigns() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CTICampaigns agentState = new CTICampaigns();
		agentState.setAgent_id("agent id");
		String request = agentState.toString();
		when(ctiService.getTransferCampaigns(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getTransferCampaigns(request, serverRequest));
	}
	
	@Test
	void testGetTransferCampaigns_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getTransferCampaigns(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getTransferCampaigns(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getTransferCampaigns(request, serverRequest));
	}

	@Test
	void testGetCampaignRoles() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CampaignRole campaign = new CampaignRole();
		campaign.setCampaign("campaign name");
		String request = campaign.toString();
		when(ctiService.getCampaignRoles(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getCampaignRoles(request, serverRequest));
	}
	
	@Test
	void testGetCampaignRoles_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getCampaignRoles(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getCampaignRoles(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getCampaignRoles(request, serverRequest));
	}

	@Test
	void testSetCallDisposition() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CallDisposition disposition = new CallDisposition();
		disposition.setAgent_id("agent id");
		disposition.setCust_disp("cust");
		disposition.setCategory("category");
		disposition.setSession_id("session id");
		String request = disposition.toString();
		when(ctiService.setCallDisposition(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.setCallDisposition(request, serverRequest));
	}
	
	@Test
	void testSetCallDisposition_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.setCallDisposition(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.setCallDisposition(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.setCallDisposition(request, serverRequest));
	}

	@Test
	void testCreateVoiceFile() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CTIVoiceFile disposition = new CTIVoiceFile();
		disposition.setAgent_id("agent id");
		disposition.setSession_id("session id");
		String request = disposition.toString();
		when(ctiService.createVoiceFile(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.createVoiceFile(request, serverRequest));
	}
	
	@Test
	void testCreateVoiceFile_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.createVoiceFile(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.createVoiceFile(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.createVoiceFile(request, serverRequest));
	}

	@Test
	void testGetVoiceFile() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CTIVoiceFile disposition = new CTIVoiceFile();
		disposition.setAgent_id("agent id");
		disposition.setSession_id("session id");
		String request = disposition.toString();
		when(ctiService.getVoiceFile(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getVoiceFile(request, serverRequest));
	}
	
	@Test
	void testGetVoiceFile_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getVoiceFile(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getVoiceFile(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getVoiceFile(request, serverRequest));
	}

	@Test
	void testDisconnectCall() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		AgentSkills agent = new AgentSkills();
		agent.setAgent_id("agent id");
		String request = agent.toString();
		when(ctiService.disconnectCall(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.disconnectCall(request, serverRequest));
	}
	
	@Test
	void testDisconnectCall_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.disconnectCall(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.disconnectCall(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.disconnectCall(request, serverRequest));
	}

	@Test
	void testSwitchToInbound() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CallBeneficiary agent = new CallBeneficiary();
		agent.setAgent_id("agent id");
		String request = agent.toString();
		when(ctiService.switchToInbound(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.switchToInbound(request, serverRequest));
	}
	
	@Test
	void testSwitchToInbound_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.switchToInbound(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.switchToInbound(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.switchToInbound(request, serverRequest));
	}

	@Test
	void testSwitchToOutbound() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CallBeneficiary agent = new CallBeneficiary();
		agent.setAgent_id("agent id");
		String request = agent.toString();
		when(ctiService.switchToOutbound(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.switchToOutbound(request, serverRequest));
	}
	
	@Test
	void testSwitchToOutbound_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.switchToOutbound(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.switchToOutbound(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.switchToOutbound(request, serverRequest));
	}

	@Test
	void testGetAgentIPAddress() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		AgentState agent = new AgentState();
		agent.setAgent_id("agent id");
		String request = agent.toString();
		when(ctiService.getAgentIPAddress(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAgentIPAddress(request, serverRequest));
	}
	
	@Test
	void testGetAgentIPAddress_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getAgentIPAddress(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getAgentIPAddress(request, serverRequest);
		assertTrue(response.contains("Failed with null"));
	}

	@Test
	void testGetAvailableAgentSkills() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		AgentSkills agent  = new AgentSkills();
		agent.setCampaign_name("name");
		agent.setSkill("skill");
		String request = agent.toString();
		when(ctiService.getAvailableAgentSkills(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getAvailableAgentSkills(request, serverRequest));
	}
	
	@Test
	void testGetAvailableAgentSkills_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getAvailableAgentSkills(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getAvailableAgentSkills(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getAvailableAgentSkills(request, serverRequest));
	}

	@Test
	void testTransferCall() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		TransferCall transferCall = new TransferCall();
		transferCall.setTransfer_from("transfer from");
		transferCall.setTransfer_to("transfer to");
		transferCall.setTransfer_campaign_info("info");
		transferCall.setSkill_transfer_flag("transfer flag");
		transferCall.setSkill("skill");
		transferCall.setBenCallID(123L);
		transferCall.setAgentIPAddress("ip address");
		transferCall.setCallTypeID(123);
		String request = transferCall.toString();
		when(ctiService.transferCall(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.transferCall(request, serverRequest));
	}
	
	@Test
	void testTransferCall_CatchBlock() throws IEMRException, JSONException, JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.transferCall(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.transferCall(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.transferCall(request, serverRequest));
	}

	@Test
	void testCustomerPreferredLanguage() throws JsonMappingException, JsonProcessingException {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CustomerLanguage custLang = new CustomerLanguage();
		custLang.setCust_ph_no("ph no");
		custLang.setCampaign_name("name");
		custLang.setLanguage("language");
		custLang.setAction("action");
		String request = custLang.toString();
		when(ctiService.customerPreferredLanguage(custLang, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.customerPreferredLanguage(request, serverRequest));
	}
	
	@Test
	void testCustomerPreferredLanguage_CatchBlock() throws JsonMappingException, JsonProcessingException {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		CustomerLanguage custLang = new CustomerLanguage();
		custLang.setCust_ph_no("ph no");
		custLang.setCampaign_name("name");
		custLang.setLanguage("language");
		custLang.setAction("action");
		when(ctiService.customerPreferredLanguage(custLang, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.customerPreferredLanguage(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.customerPreferredLanguage(request, serverRequest));
	}

	@Test
	void testGetIVRSPathDetails() throws Exception {
		OutputResponse response = new OutputResponse();
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		AgentState zoneData = new AgentState();
		zoneData.setAgent_id("agent id");
		String request = zoneData.toString();
		when(ctiService.getIVRSPathDetails(request, remoteAddress)).thenReturn(response);
		response.setResponse(request.toString());
		assertNull(remoteAddress);
		Assertions.assertEquals(response.toString(), computerTelephonyIntegrationController.getIVRSPathDetails(request, serverRequest));
	}
	
	@Test
	void testGetIVRSPathDetails_CatchBlock() throws Exception {
		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";
		HttpServletRequest serverRequest = mock(HttpServletRequest.class);
		String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
		when(ctiService.getIVRSPathDetails(request, remoteAddress)).thenThrow(NotFoundException.class);
		String response = computerTelephonyIntegrationController.getIVRSPathDetails(request, serverRequest);
		Assertions.assertEquals(response, computerTelephonyIntegrationController.getIVRSPathDetails(request, serverRequest));
	}

}
