/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.cti;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.controller.cti.ComputerTelephonyIntegrationController;
import com.iemr.common.service.cti.CTIService;
import com.iemr.common.service.cti.CTIServiceImpl;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CTIControllerTest {
	@InjectMocks
	private ComputerTelephonyIntegrationController controllerMock = spy(ComputerTelephonyIntegrationController.class);

	private CTIService ctiServiceSpy = spy(new CTIServiceImpl());

	MockHttpServletRequest request = new MockHttpServletRequest();
	MockHttpServletRequest requestNoIP = new MockHttpServletRequest();

	@Before
	public void initailize() {
		request.setRemoteAddr(Constants.REQUESTOR_IP);
		requestNoIP.setRemoteAddr("");
	}

	@Test
	public void getCampaignSkillsSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignSkills.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignSkills(ConstantCampaignSkills.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getCampaignSkills(ConstantCampaignSkills.successRequest1, request).toString();
			assertTrue("getCampaignSkills success 1 ",
					response.equals(ConstantCampaignSkills.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignSkills success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignSkillsFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignSkills.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignSkills(ConstantCampaignSkills.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getCampaignSkills(ConstantCampaignSkills.failureRequest1, request).toString();
			assertTrue("getCampaignSkills failure 1 ",
					response.equals(ConstantCampaignSkills.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignSkills failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignSkillsFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignSkills.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignSkills(ConstantCampaignSkills.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getCampaignSkills(ConstantCampaignSkills.failureRequest2, request).toString();
			assertTrue("getCampaignSkills failure 2 ",
					response.equals(ConstantCampaignSkills.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignSkills failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.successRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.successRequest1, request).toString();
			assertTrue("getAgentState success 1 ", response.equals(ConstantAgentState.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.successRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.successRequest2, request).toString();
			assertTrue("getAgentState success 2 ", response.equals(ConstantAgentState.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.successResponse3, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.successRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.successRequest3, request).toString();
			assertTrue("getAgentState success 3 ", response.equals(ConstantAgentState.controllerSuccessResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState success 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.failureRequest1, request).toString();
			assertTrue("getAgentState failure 1 ", response.equals(ConstantAgentState.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.failureRequest2, "");

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.failureRequest2, requestNoIP).toString();
			assertTrue("getAgentState failure 2 ", response.equals(ConstantAgentState.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentState.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).getAgentState(ConstantAgentState.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentState(ConstantAgentState.failureRequest3, request).toString();
			assertTrue("getAgentState failure 3 ", response.equals(ConstantAgentState.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentState failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.successRequest1, request).toString();
			assertTrue("getAgentCallStats success 1 ", response.equals(ConstantAgentStatus.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.successRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.successRequest2, request).toString();
			assertTrue("getAgentCallStats success 2 ", response.equals(ConstantAgentStatus.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.failureRequest1, request).toString();
			assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantAgentStatus.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.failureRequest2, "");

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.failureRequest2, requestNoIP).toString();
			assertTrue("getAgentCallStats failure 2 ", response.equals(ConstantAgentStatus.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.successRequest1, "");
			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.successRequest1, requestNoIP).toString();
			assertTrue("getCampaignNames success 1 ", response.equals(ConstantCampaignName.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.successRequest2, "");
			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.successRequest2, requestNoIP).toString();
			assertTrue("getCampaignNames success 2 ", response.equals(ConstantCampaignName.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.successResponse3, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.successRequest3, "");
			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.successRequest3, requestNoIP).toString();
			assertTrue("getCampaignNames success 3 ", response.equals(ConstantCampaignName.controllerSuccessResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames success 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.successResponse4, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.successRequest4, "");
			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.successRequest4, requestNoIP).toString();
			assertTrue("getCampaignNames success 4 ", response.equals(ConstantCampaignName.controllerSuccessResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames success 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.failureRequest1, "");

			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.failureRequest1, requestNoIP).toString();
			assertTrue("getCampaignNames failure 1 ", response.equals(ConstantCampaignName.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.failureRequest2, "");

			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.failureRequest2, requestNoIP).toString();
			assertTrue("getCampaignNames failure 2 ", response.equals(ConstantCampaignName.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignName.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).getCampaignNames(ConstantCampaignName.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getCampaignNames(ConstantCampaignName.failureRequest3, request).toString();
			assertTrue("getCampaignNames failure 3 ", response.equals(ConstantCampaignName.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignNames failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getLoginKeySuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantUserLogin.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getLoginKey(ConstantUserLogin.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getLoginKey(ConstantUserLogin.successRequest1, request).toString();
			assertTrue("getLoginKey success 1 ", response.equals(ConstantUserLogin.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getLoginKey success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getLoginKeyFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantUserLogin.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getLoginKey(ConstantUserLogin.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getLoginKey(ConstantUserLogin.failureRequest1, request).toString();
			assertTrue("getLoginKey failure 1 ", response.equals(ConstantUserLogin.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getLoginKey failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentLogout.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).agentLogout(ConstantAgentLogout.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.doAgentLogout(ConstantAgentLogout.successRequest1, request).toString();
			assertTrue("doAgentLogout success 1 ", response.equals(ConstantAgentLogout.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("doAgentLogout success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentLogout.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).agentLogout(ConstantAgentLogout.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.doAgentLogout(ConstantAgentLogout.failureRequest1, request).toString();
			assertTrue("doAgentLogout failure 1 ", response.equals(ConstantAgentLogout.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("doAgentLogout failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentLogout.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).agentLogout(ConstantAgentLogout.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.doAgentLogout(ConstantAgentLogout.failureRequest2, request).toString();
			assertTrue("doAgentLogout failure 2 ", response.equals(ConstantAgentLogout.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("doAgentLogout failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentLogout.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).agentLogout(ConstantAgentLogout.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.doAgentLogout(ConstantAgentLogout.failureRequest3, request).toString();
			assertTrue("doAgentLogout failure 3 ", response.equals(ConstantAgentLogout.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("doAgentLogout failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantFreeAgents.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantFreeAgents.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantFreeAgents.failureRequest1, request).toString();
			assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantFreeAgents.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantFreeAgents.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantFreeAgents.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantFreeAgents.failureRequest2, request).toString();
			assertTrue("getAgentCallStats failure 2 ", response.equals(ConstantFreeAgents.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantFreeAgents.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantFreeAgents.failureRequest3, "");

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantFreeAgents.failureRequest3, requestNoIP).toString();
			assertTrue("getAgentCallStats failure 3 ", response.equals(ConstantFreeAgents.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiarySuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.callBeneficiary(ConstantCallBeneficiary.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.successRequest1, request).toString();
			assertTrue("callBeneficiary success 1 ",
					response.equals(ConstantCallBeneficiary.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.callBeneficiary(ConstantCallBeneficiary.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest1, request).toString();
			assertTrue("callBeneficiary failure 1 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.callBeneficiary(ConstantCallBeneficiary.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest2, request).toString();
			assertTrue("callBeneficiary failure 2 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).callBeneficiary(ConstantCallBeneficiary.failureRequest3, "");

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest3, requestNoIP).toString();
			assertTrue("callBeneficiary failure 3 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse4, OutputResponse.class))
					.when(ctiServiceSpy)
					.callBeneficiary(ConstantCallBeneficiary.failureRequest4, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest4, request).toString();
			assertTrue("callBeneficiary failure 4 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure05() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse5, OutputResponse.class))
					.when(ctiServiceSpy).callBeneficiary(ConstantCallBeneficiary.failureRequest5, "");

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest5, requestNoIP).toString();
			assertTrue("callBeneficiary failure 5 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse5));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 5 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure06() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse6, OutputResponse.class))
					.when(ctiServiceSpy).callBeneficiary(ConstantCallBeneficiary.failureRequest6, "");

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest6, requestNoIP).toString();
			assertTrue("callBeneficiary failure 6 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse6));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 6 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure07() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallBeneficiary.failureResponse7, OutputResponse.class))
					.when(ctiServiceSpy).callBeneficiary(ConstantCallBeneficiary.failureRequest7, "");

			String response = "";
			response = controllerMock.callBeneficiary(ConstantCallBeneficiary.failureRequest7, requestNoIP).toString();
			assertTrue("callBeneficiary failure 7 ",
					response.equals(ConstantCallBeneficiary.controllerFailureResponse7));
		} catch (Exception e) {
			e.printStackTrace();
			fail("callBeneficiary failure 7 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.successRequest1, request).toString();
			assertTrue("addUpdateUserData success 1 ",
					response.equals(ConstantAddUpdateUser.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.successRequest2, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.successRequest2, request).toString();
			assertTrue("addUpdateUserData success 2 ",
					response.equals(ConstantAddUpdateUser.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.successResponse3, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.successRequest3, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.successRequest3, request).toString();
			assertTrue("addUpdateUserData success 3 ",
					response.equals(ConstantAddUpdateUser.controllerSuccessResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData success 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest1, request).toString();
			assertTrue("addUpdateUserData failure 1 ",
					response.equals(ConstantAddUpdateUser.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest2, request).toString();
			assertTrue("addUpdateUserData failure 2 ",
					response.equals(ConstantAddUpdateUser.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAddUpdateUser.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy)
					.addUpdateUserData(ConstantAddUpdateUser.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest3, request).toString();
			assertTrue("addUpdateUserData failure 3 ",
					response.equals(ConstantAddUpdateUser.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("addUpdateUserData failure 3 failed with error " + e.getMessage(), e);
		}
	}

	public void getTransferCampaignsSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetTransferCampaigns.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest1, request)
					.toString();
			assertTrue("getTransferCampaigns success 1 ",
					response.equals(ConstantGetTransferCampaigns.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getTransferCampaigns success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetTransferCampaigns.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest2, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest2, request)
					.toString();
			assertTrue("getTransferCampaigns success 2 ",
					response.equals(ConstantGetTransferCampaigns.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getTransferCampaigns success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetTransferCampaigns.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest1, request)
					.toString();
			assertTrue("getTransferCampaigns failure 1 ",
					response.equals(ConstantGetTransferCampaigns.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getTransferCampaigns failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetTransferCampaigns.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest2, request)
					.toString();
			assertTrue("getTransferCampaigns failure 2 ",
					response.equals(ConstantGetTransferCampaigns.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getTransferCampaigns failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignRoles.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignRoles(ConstantCampaignRoles.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getCampaignRoles(ConstantCampaignRoles.successRequest1, request).toString();
			assertTrue("getCampaignRoles success 1 ",
					response.equals(ConstantCampaignRoles.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignRoles success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignRoles.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignRoles(ConstantCampaignRoles.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getCampaignRoles(ConstantCampaignRoles.failureRequest1, request).toString();
			assertTrue("getCampaignRoles failure 1 ",
					response.equals(ConstantCampaignRoles.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignRoles failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCampaignRoles.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.getCampaignRoles(ConstantCampaignRoles.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getCampaignRoles(ConstantCampaignRoles.failureRequest2, request).toString();
			assertTrue("getCampaignRoles failure 2 ",
					response.equals(ConstantCampaignRoles.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getCampaignRoles failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.successRequest1, request)
					.toString();
			assertTrue("setCallDisposition success 1 ",
					response.equals(ConstantSetCallDisposition.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.successRequest2, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.successRequest2, request)
					.toString();
			assertTrue("setCallDisposition success 2 ",
					response.equals(ConstantSetCallDisposition.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.successResponse3, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.successRequest3, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.successRequest3, request)
					.toString();
			assertTrue("setCallDisposition success 3 ",
					response.equals(ConstantSetCallDisposition.controllerSuccessResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition success 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.successResponse4, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.successRequest4, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.successRequest4, request)
					.toString();
			assertTrue("setCallDisposition success 4 ",
					response.equals(ConstantSetCallDisposition.controllerSuccessResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition success 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.failureRequest1, request)
					.toString();
			assertTrue("setCallDisposition failure 1 ",
					response.equals(ConstantSetCallDisposition.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSetCallDisposition.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.setCallDisposition(ConstantSetCallDisposition.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.setCallDisposition(ConstantSetCallDisposition.failureRequest2, request)
					.toString();
			assertTrue("setCallDisposition failure 2 ",
					response.equals(ConstantSetCallDisposition.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("setCallDisposition failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCreateVoiceFile.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.createVoiceFile(ConstantCreateVoiceFile.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.createVoiceFile(ConstantCreateVoiceFile.successRequest1, request).toString();
			assertTrue("createVoiceFile success 1 ",
					response.equals(ConstantCreateVoiceFile.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("createVoiceFile success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCreateVoiceFile.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy)
					.createVoiceFile(ConstantCreateVoiceFile.successRequest2, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.createVoiceFile(ConstantCreateVoiceFile.successRequest2, request).toString();
			assertTrue("createVoiceFile success 2 ",
					response.equals(ConstantCreateVoiceFile.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("createVoiceFile success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCreateVoiceFile.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.createVoiceFile(ConstantCreateVoiceFile.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.createVoiceFile(ConstantCreateVoiceFile.failureRequest1, request).toString();
			assertTrue("createVoiceFile failure 1 ",
					response.equals(ConstantCreateVoiceFile.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("createVoiceFile failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetVoiceFile.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getVoiceFile(ConstantGetVoiceFile.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getVoiceFile(ConstantGetVoiceFile.successRequest1, request).toString();
			assertTrue("getVoiceFile success 1 ", response.equals(ConstantGetVoiceFile.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getVoiceFile success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetVoiceFile.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getVoiceFile(ConstantGetVoiceFile.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getVoiceFile(ConstantGetVoiceFile.failureRequest1, request).toString();
			assertTrue("getVoiceFile failure 1 ", response.equals(ConstantGetVoiceFile.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getVoiceFile failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantGetVoiceFile.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).getVoiceFile(ConstantGetVoiceFile.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getVoiceFile(ConstantGetVoiceFile.failureRequest2, request).toString();
			assertTrue("getVoiceFile failure 2 ", response.equals(ConstantGetVoiceFile.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getVoiceFile failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallDisconnect.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).disconnectCall(ConstantCallDisconnect.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.disconnectCall(ConstantCallDisconnect.successRequest1, request).toString();
			assertTrue("disconnectCall success 1 ", response.equals(ConstantCallDisconnect.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("disconnectCall success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallDisconnect.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).disconnectCall(ConstantCallDisconnect.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.disconnectCall(ConstantCallDisconnect.failureRequest1, request).toString();
			assertTrue("disconnectCall failure 1 ", response.equals(ConstantCallDisconnect.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("disconnectCall failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallDisconnect.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).disconnectCall(ConstantCallDisconnect.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.disconnectCall(ConstantCallDisconnect.failureRequest2, request).toString();
			assertTrue("disconnectCall failure 2 ", response.equals(ConstantCallDisconnect.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("disconnectCall failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantCallDisconnect.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).disconnectCall(ConstantCallDisconnect.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.disconnectCall(ConstantCallDisconnect.failureRequest3, request).toString();
			assertTrue("disconnectCall failure 3 ", response.equals(ConstantCallDisconnect.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("disconnectCall failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.successRequest1, request).toString();
			assertTrue("switchToInbound success 1 ", response.equals(ConstantSwitchInbound.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.successRequest2, "");
			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.successRequest2, requestNoIP).toString();
			assertTrue("switchToInbound success 2 ", response.equals(ConstantSwitchInbound.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.failureRequest1, request).toString();
			assertTrue("switchToInbound failure 1 ", response.equals(ConstantSwitchInbound.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.failureRequest2, "");

			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.failureRequest2, requestNoIP).toString();
			assertTrue("switchToInbound failure 2 ", response.equals(ConstantSwitchInbound.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.failureRequest3, request).toString();
			assertTrue("switchToInbound failure 3 ", response.equals(ConstantSwitchInbound.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchInbound.failureResponse4, OutputResponse.class))
					.when(ctiServiceSpy).switchToInbound(ConstantSwitchInbound.failureRequest4, "");

			String response = "";
			response = controllerMock.switchToInbound(ConstantSwitchInbound.failureRequest4, requestNoIP).toString();
			assertTrue("switchToInbound failure 4 ", response.equals(ConstantSwitchInbound.controllerFailureResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToInbound failure 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.switchToOutbound(ConstantSwitchOutbound.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.successRequest1, request).toString();
			assertTrue("switchToOutbound success 1 ",
					response.equals(ConstantSwitchOutbound.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).switchToOutbound(ConstantSwitchOutbound.successRequest2, "");
			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.successRequest2, requestNoIP).toString();
			assertTrue("switchToOutbound success 2 ",
					response.equals(ConstantSwitchOutbound.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.switchToOutbound(ConstantSwitchOutbound.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.failureRequest1, request).toString();
			assertTrue("switchToOutbound failure 1 ",
					response.equals(ConstantSwitchOutbound.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).switchToOutbound(ConstantSwitchOutbound.failureRequest2, "");

			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.failureRequest2, requestNoIP).toString();
			assertTrue("switchToOutbound failure 2 ",
					response.equals(ConstantSwitchOutbound.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy)
					.switchToOutbound(ConstantSwitchOutbound.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.failureRequest3, request).toString();
			assertTrue("switchToOutbound failure 3 ",
					response.equals(ConstantSwitchOutbound.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantSwitchOutbound.failureResponse4, OutputResponse.class))
					.when(ctiServiceSpy).switchToOutbound(ConstantSwitchOutbound.failureRequest4, "");

			String response = "";
			response = controllerMock.switchToOutbound(ConstantSwitchOutbound.failureRequest4, requestNoIP).toString();
			assertTrue("switchToOutbound failure 4 ",
					response.equals(ConstantSwitchOutbound.controllerFailureResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("switchToOutbound failure 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentIPAddressSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentIPAddress.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getAgentIPAddress(ConstantAgentIPAddress.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getAgentIPAddress(ConstantAgentIPAddress.successRequest1, request).toString();
			assertTrue("getAgentIPAddress success 1 ",
					response.equals(ConstantAgentIPAddress.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentIPAddress success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentIPAddressFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentIPAddress.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy)
					.getAgentIPAddress(ConstantAgentIPAddress.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentIPAddress(ConstantAgentIPAddress.failureRequest1, request).toString();
			assertTrue("getAgentIPAddress failure 1 ",
					response.equals(ConstantAgentIPAddress.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentIPAddress failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.successRequest1, request).toString();
			assertTrue("transferCall success 1 ", response.equals(ConstantTransferCall.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.successResponse2, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.successRequest2, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.successRequest2, request).toString();
			assertTrue("transferCall success 2 ", response.equals(ConstantTransferCall.controllerSuccessResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall success 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.successResponse3, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.successRequest3, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.successRequest3, request).toString();
			assertTrue("transferCall success 3 ", response.equals(ConstantTransferCall.controllerSuccessResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall success 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess04() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.successResponse4, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.successRequest4, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.successRequest4, request).toString();
			assertTrue("transferCall success 4 ", response.equals(ConstantTransferCall.controllerSuccessResponse4));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall success 4 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess05() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.successResponse5, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.successRequest5, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.successRequest5, request).toString();
			assertTrue("transferCall success 5 ", response.equals(ConstantTransferCall.controllerSuccessResponse5));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure01() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.failureRequest1, request).toString();
			assertTrue("transferCall failure 1 ", response.equals(ConstantTransferCall.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall failure 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure02() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.failureResponse2, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.failureRequest2, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.failureRequest2, request).toString();
			assertTrue("transferCall failure 2 ", response.equals(ConstantTransferCall.controllerFailureResponse2));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall failure 2 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure03() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantTransferCall.failureResponse3, OutputResponse.class))
					.when(ctiServiceSpy).transferCall(ConstantTransferCall.failureRequest3, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.transferCall(ConstantTransferCall.failureRequest3, request).toString();
			assertTrue("transferCall failure 3 ", response.equals(ConstantTransferCall.controllerFailureResponse3));
		} catch (Exception e) {
			e.printStackTrace();
			fail("transferCall failure 3 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess1() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.successResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.successRequest1, Constants.REQUESTOR_IP);
			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.successRequest1, request).toString();
			assertTrue("getAgentCallStats success 1 ", response.equals(ConstantAgentStatus.controllerSuccessResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats success 1 failed with error " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure1() {
		try {
			doReturn(InputMapper.gson().fromJson(ConstantAgentStatus.failureResponse1, OutputResponse.class))
					.when(ctiServiceSpy).getAgentCallStats(ConstantAgentStatus.failureRequest1, Constants.REQUESTOR_IP);

			String response = "";
			response = controllerMock.getAgentCallStats(ConstantAgentStatus.failureRequest1, request).toString();
			assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantAgentStatus.controllerFailureResponse1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("getAgentCallStats failure 1 failed with error " + e.getMessage(), e);
		}
	}

}
