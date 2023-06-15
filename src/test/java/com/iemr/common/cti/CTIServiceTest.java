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

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.service.cti.CTIServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CTIServiceTest
{
	private CTIServiceImpl serviceMock;

	@Before
	public void initialize()
	{
		serviceMock = spy(CTIServiceImpl.class);
	}

	@Test
	public void addUpdateAgentSkillsSuccess01()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseSuccess1).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestSuccess1);
			String response = "";

			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestSuccess1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills success 1 ",
					response.equals(ContantAddUpdateAgentSkills.responseSuccess1));

		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateAgentSkillsSuccess02()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseSuccess2).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestSuccess2);
			String response = "";

			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestSuccess2, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills success 2 ",
					response.equals(ContantAddUpdateAgentSkills.responseSuccess2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateAgentSkillsFailure01()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseFailure1).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestFailure1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestFailure1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills failure 1 ",
					response.equals(ContantAddUpdateAgentSkills.responseFailure1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateAgentSkillsFailure02()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseFailure2).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestFailure2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestFailure2, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills failure 2 ",
					response.equals(ContantAddUpdateAgentSkills.responseFailure2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateAgentSkillsFailure03()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseFailure3).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestFailure3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestFailure3, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills failure 3 ",
					response.equals(ContantAddUpdateAgentSkills.responseFailure3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateAgentSkillsFailure04()
	{
		try
		{
			doReturn(ContantAddUpdateAgentSkills.urlResponseFailure4).when(serviceMock)
					.callUrl(ContantAddUpdateAgentSkills.urlRequestFailure4);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock
					.addUpdateAgentSkills(ContantAddUpdateAgentSkills.requestFailure4, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("addUpdateAgentSkills failure 4 ",
					response.equals(ContantAddUpdateAgentSkills.responseFailure4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateAgentSkills failure 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignSkillsSuccess01()
	{
		try
		{
			doReturn(ConstantCampaignSkills.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCampaignSkills.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock.getCampaignSkills(ConstantCampaignSkills.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getCampaignSkills success 1 ", response.equals(ConstantCampaignSkills.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignSkills success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignSkillsFailure01()
	{
		try
		{
			doReturn(ConstantCampaignSkills.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCampaignSkills.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = "";
			response = serviceMock.getCampaignSkills(ConstantCampaignSkills.failureRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getCampaignSkills failulre 1 ", response.equals(ConstantCampaignSkills.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignSkills failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignSkillsFailure02()
	{
		try
		{
			doReturn(ConstantCampaignSkills.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantCampaignSkills.urlFailureRequest2);
			String response = "";
			response = serviceMock.getCampaignSkills(ConstantCampaignSkills.failureRequest2, "").toString();
			assertTrue("getCampaignSkills ", response.equals(ConstantCampaignSkills.failureResponse2));

		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignSkills failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess01()
	{
		try
		{
			doReturn(ConstantAgentState.successResponseURL1).when(serviceMock)
					.callUrl(ConstantAgentState.successRequestURL1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAgentState(ConstantAgentState.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentState success 1 ", response.equals(ConstantAgentState.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess02()
	{
		try
		{
			doReturn(ConstantAgentState.successResponseURL2).when(serviceMock)
					.callUrl(ConstantAgentState.successRequestURL2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAgentState(ConstantAgentState.successRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentState success 2 ", response.equals(ConstantAgentState.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateSuccess03()
	{
		try
		{
			doReturn(ConstantAgentState.successResponseURL3).when(serviceMock)
					.callUrl(ConstantAgentState.successRequestURL3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAgentState(ConstantAgentState.successRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentState success 3 ", response.equals(ConstantAgentState.successResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState success 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure01()
	{
		try
		{
			doReturn(ConstantAgentState.failureResponseURL1).when(serviceMock)
					.callUrl(ConstantAgentState.failureRequestURL1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAgentState(ConstantAgentState.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentState failure 1 ", response.equals(ConstantAgentState.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure02()
	{
		try
		{
			doReturn(ConstantAgentState.failureResponseURL2).when(serviceMock)
					.callUrl(ConstantAgentState.failureRequestURL2);
			String response = serviceMock.getAgentState(ConstantAgentState.failureRequest2, "").toString();
			assertTrue("getAgentState failure 2 ", response.equals(ConstantAgentState.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentStateFailure03()
	{
		try
		{
			doReturn(ConstantAgentState.failureResponseURL3).when(serviceMock)
					.callUrl(ConstantAgentState.failureRequestURL3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAgentState(ConstantAgentState.failureRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentState failure 3 ", response.equals(ConstantAgentState.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentState failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess01()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getAgentCallStats success 1 ", response.equals(ConstantAgentStatus.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess02()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlSuccessRequest2);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.successRequest2, "").toString();
			assertTrue("getAgentCallStats success 2 ", response.equals(ConstantAgentStatus.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure01()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.failureRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantAgentStatus.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure02()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlFailureRequest2);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.failureRequest2, "").toString();
			assertTrue("getAgentCallStats failure 2 ", response.equals(ConstantAgentStatus.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess01()
	{
		try
		{
			doReturn(ConstantCampaignName.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCampaignName.urlSuccessRequest1);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.successRequest1, "").toString();
			assertTrue("getCampaignNames success 1 ", response.equals(ConstantCampaignName.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess02()
	{
		try
		{
			doReturn(ConstantCampaignName.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantCampaignName.urlSuccessRequest2);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.successRequest2, "").toString();
			assertTrue("getCampaignNames success 2 ", response.equals(ConstantCampaignName.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess03()
	{
		try
		{
			doReturn(ConstantCampaignName.urlSuccessResponse3).when(serviceMock)
					.callUrl(ConstantCampaignName.urlSuccessRequest3);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.successRequest3, "").toString();
			assertTrue("getCampaignNames success 3 ", response.equals(ConstantCampaignName.successResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames success 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesSuccess04()
	{
		try
		{
			doReturn(ConstantCampaignName.urlSuccessResponse4).when(serviceMock)
					.callUrl(ConstantCampaignName.urlSuccessRequest4);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.successRequest4, "").toString();
			assertTrue("getCampaignNames success 4 ", response.equals(ConstantCampaignName.successResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames success 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure01()
	{
		try
		{
			doReturn(ConstantCampaignName.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCampaignName.urlFailureRequest1);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.failureRequest1, "").toString();
			assertTrue("getCampaignNames failure 1 ", response.equals(ConstantCampaignName.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure02()
	{
		try
		{
			doReturn(ConstantCampaignName.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantCampaignName.urlFailureRequest2);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.failureRequest2, "").toString();
			assertTrue("getCampaignNames failure 2 ", response.equals(ConstantCampaignName.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignNamesFailure03()
	{
		try
		{
			doReturn(ConstantCampaignName.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantCampaignName.urlFailureRequest3);
			String response = serviceMock.getCampaignNames(ConstantCampaignName.failureRequest3, "").toString();
			assertTrue("getCampaignNames failure 3 ", response.equals(ConstantCampaignName.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignNames failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLoginSuccess01()
	{
		try
		{
			doReturn(ConstantAgentLogin.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentLogin.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.doAgentLogin(ConstantAgentLogin.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("doAgentLogin success 1 ", response.equals(ConstantAgentLogin.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogin success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLoginFailure01()
	{
		try
		{
			doReturn(ConstantAgentLogin.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAgentLogin.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccess2004AgentResponse).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccess2004AgentRequest);
			String response =
					serviceMock.doAgentLogin(ConstantAgentLogin.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("doAgentLogin failure 1 ", response.equals(ConstantAgentLogin.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogin failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLoginFailure02()
	{
		try
		{
			doReturn(ConstantAgentLogin.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantAgentLogin.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyAgentResponse).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response =
					serviceMock.doAgentLogin(ConstantAgentLogin.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("doAgentLogin failure 2 ", response.equals(ConstantAgentLogin.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogin failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLoginFailure03()
	{
		try
		{
			doReturn(ConstantAgentLogin.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantAgentLogin.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest1);
			String response = serviceMock.doAgentLogin(ConstantAgentLogin.failureRequest3, "").toString();
			assertTrue("doAgentLogin failure 3 ", response.equals(ConstantAgentLogin.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogin failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getLoginKeySuccess01()
	{
		try
		{
			doReturn(ConstantUserLogin.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantUserLogin.urlSuccessRequest1);
			String response = serviceMock.getLoginKey(ConstantUserLogin.successRequest1, "").toString();
			assertTrue("getLoginKey success 1 ", response.equals(ConstantUserLogin.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getLoginKey success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getLoginKeyFailure01()
	{
		try
		{
			doReturn(ConstantUserLogin.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantUserLogin.urlFailureRequest1);
			String response = serviceMock.getLoginKey(ConstantUserLogin.failureRequest1, "").toString();
			assertTrue("getLoginKey failure 1 ", response.equals(ConstantUserLogin.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getLoginKey failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutSuccess01()
	{
		try
		{
			doReturn(ConstantAgentLogout.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentLogout.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.agentLogout(ConstantAgentLogout.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("doAgentLogout success 1 ", response.equals(ConstantAgentLogout.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogout success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure01()
	{
		try
		{
			doReturn(ConstantAgentLogout.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAgentLogout.urlFailureRequest1);

			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse3).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest3);
			String response = serviceMock.agentLogout(ConstantAgentLogout.failureRequest1, "").toString();
			assertTrue("doAgentLogout failure 1 ", response.equals(ConstantAgentLogout.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogout failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure02()
	{
		try
		{
			doReturn(ConstantAgentLogout.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantAgentLogout.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyAgentResponse).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response =
					serviceMock.agentLogout(ConstantAgentLogout.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("doAgentLogout failure 2 ", response.equals(ConstantAgentLogout.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogout failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void doAgentLogoutFailure03()
	{
		try
		{
			doReturn(ConstantAgentLogout.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantAgentLogout.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest1);
			String response = serviceMock.agentLogout(ConstantAgentLogout.failureRequest3, "").toString();
			assertTrue("doAgentLogout failure 3 ", response.equals(ConstantAgentLogout.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("doAgentLogout failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure01()
	{
		try
		{
			doReturn(ConstantFreeAgents.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantFreeAgents.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getOnlineAgents(ConstantFreeAgents.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("getOnlineAgents failure 1 ", response.equals(ConstantFreeAgents.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getOnlineAgents failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure02()
	{
		try
		{
			doReturn(ConstantFreeAgents.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantFreeAgents.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyAgentResponse).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response =
					serviceMock.getOnlineAgents(ConstantFreeAgents.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("getOnlineAgents failure 2 ", response.equals(ConstantFreeAgents.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getOnlineAgents failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getOnlineAgentsFailure03()
	{
		try
		{
			doReturn(ConstantFreeAgents.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantFreeAgents.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest1);
			String response = serviceMock.getOnlineAgents(ConstantFreeAgents.failureRequest3, "").toString();
			assertTrue("getOnlineAgents failure 3 ", response.equals(ConstantFreeAgents.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getOnlineAgents failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiarySuccess01()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.callBeneficiary(ConstantCallBeneficiary.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("callBeneficiary success 1 ", response.equals(ConstantCallBeneficiary.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure01()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccess2004AgentRequest);
			String response = serviceMock
					.callBeneficiary(ConstantCallBeneficiary.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("callBeneficiary failure 1 ", response.equals(ConstantCallBeneficiary.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure02()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response = serviceMock
					.callBeneficiary(ConstantCallBeneficiary.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("callBeneficiary failure 2 ", response.equals(ConstantCallBeneficiary.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure03()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse2).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest2);
			String response = serviceMock.callBeneficiary(ConstantCallBeneficiary.failureRequest3, "").toString();
			assertTrue("callBeneficiary failure 3 ", response.equals(ConstantCallBeneficiary.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure04()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse4).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest4);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccess2004AgentRequest);
			String response = serviceMock
					.callBeneficiary(ConstantCallBeneficiary.failureRequest4, Constants.REQUESTOR_IP).toString();
			assertTrue("callBeneficiary failure 4 ", response.equals(ConstantCallBeneficiary.failureResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure05()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse5).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest5);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse3).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest3);
			String response = serviceMock.callBeneficiary(ConstantCallBeneficiary.failureRequest5, "").toString();
			assertTrue("callBeneficiary failure 5 ", response.equals(ConstantCallBeneficiary.failureResponse5));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 5 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure06()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse6).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest6);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response = serviceMock
					.callBeneficiary(ConstantCallBeneficiary.failureRequest6, Constants.REQUESTOR_IP).toString();
			assertTrue("callBeneficiary failure 6 ", response.equals(ConstantCallBeneficiary.failureResponse6));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 6 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void callBeneficiaryFailure07()
	{
		try
		{
			doReturn(ConstantCallBeneficiary.urlFailureResponse7).when(serviceMock)
					.callUrl(ConstantCallBeneficiary.urlFailureRequest7);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest1);
			String response = serviceMock.callBeneficiary(ConstantCallBeneficiary.failureRequest7, "").toString();
			assertTrue("callBeneficiary failure 7 ", response.equals(ConstantCallBeneficiary.failureResponse7));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("callBeneficiary failure 7 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess01()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlSuccessRequest1);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.successRequest1, "").toString();
			assertTrue("updateUserData success 1 ", response.equals(ConstantAddUpdateUser.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess02()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlSuccessRequest2);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.successRequest2, "").toString();
			assertTrue("updateUserData success 2 ", response.equals(ConstantAddUpdateUser.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess03()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlSuccessResponse3).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlSuccessRequest3);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.successRequest3, "").toString();
			assertTrue("addUpdateUserData success 3 ", response.equals(ConstantAddUpdateUser.successResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData success 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataSuccess04()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlSuccessResponse4).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlSuccessRequest4);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.successRequest4, "").toString();
			assertTrue("addUpdateUserData success 4 ", response.equals(ConstantAddUpdateUser.successResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData success 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure01()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlFailureRequest1);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest1, "").toString();
			assertTrue("addUpdateUserData failure 1 ", response.equals(ConstantAddUpdateUser.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure02()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlFailureRequest2);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest2, "").toString();
			assertTrue("addUpdateUserData failure 2 ", response.equals(ConstantAddUpdateUser.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void addUpdateUserDataFailure03()
	{
		try
		{
			doReturn(ConstantAddUpdateUser.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantAddUpdateUser.urlFailureRequest3);
			String response = serviceMock.addUpdateUserData(ConstantAddUpdateUser.failureRequest3, "").toString();
			assertTrue("addUpdateUserData failure 3 ", response.equals(ConstantAddUpdateUser.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("addUpdateUserData failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsSuccess01()
	{
		try
		{
			doReturn(ConstantGetTransferCampaigns.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantGetTransferCampaigns.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getTransferCampaigns success 1 ",
					response.equals(ConstantGetTransferCampaigns.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getTransferCampaigns success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsSuccess02()
	{
		try
		{
			doReturn(ConstantGetTransferCampaigns.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantGetTransferCampaigns.urlSuccessRequest2);
			String response =
					serviceMock.getTransferCampaigns(ConstantGetTransferCampaigns.successRequest2, "").toString();
			assertTrue("getTransferCampaigns success 2 ",
					response.equals(ConstantGetTransferCampaigns.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getTransferCampaigns success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsFailure01()
	{
		try
		{
			doReturn(ConstantGetTransferCampaigns.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantGetTransferCampaigns.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getTransferCampaigns failure 1 ",
					response.equals(ConstantGetTransferCampaigns.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getTransferCampaigns failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getTransferCampaignsFailure02()
	{
		try
		{
			doReturn(ConstantGetTransferCampaigns.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantGetTransferCampaigns.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.getTransferCampaigns(ConstantGetTransferCampaigns.failureRequest2, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getTransferCampaigns failure 2 ",
					response.equals(ConstantGetTransferCampaigns.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getTransferCampaigns failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesSuccess01()
	{
		try
		{
			doReturn(ConstantCampaignRoles.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCampaignRoles.urlSuccessRequest1);
			String response = serviceMock.getCampaignRoles(ConstantCampaignRoles.successRequest1, "").toString();
			assertTrue("getCampaignRoles success 1 ", response.equals(ConstantCampaignRoles.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignRoles success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesFailure01()
	{
		try
		{
			doReturn(ConstantCampaignRoles.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCampaignRoles.urlFailureRequest1);
			String response = serviceMock.getCampaignRoles(ConstantCampaignRoles.failureRequest1, "").toString();
			assertTrue("getCampaignRoles failure 1 ", response.equals(ConstantCampaignRoles.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignRoles failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getCampaignRolesFailure02()
	{
		try
		{
			doReturn(ConstantCampaignRoles.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantCampaignRoles.urlFailureRequest2);
			String response = serviceMock.getCampaignRoles(ConstantCampaignRoles.failureRequest2, "").toString();
			assertTrue("getCampaignRoles failure 2 ", response.equals(ConstantCampaignRoles.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getCampaignRoles failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess01()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.setCallDisposition(ConstantSetCallDisposition.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("setCallDisposition success 1 ", response.equals(ConstantSetCallDisposition.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess02()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlSuccessRequest2);
			String response = serviceMock.setCallDisposition(ConstantSetCallDisposition.successRequest2, "").toString();
			assertTrue("setCallDisposition success 2 ", response.equals(ConstantSetCallDisposition.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess03()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlSuccessResponse3).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlSuccessRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.setCallDisposition(ConstantSetCallDisposition.successRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("setCallDisposition success 3 ", response.equals(ConstantSetCallDisposition.successResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition success 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionSuccess04()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlSuccessResponse4).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlSuccessRequest4);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.setCallDisposition(ConstantSetCallDisposition.successRequest4, Constants.REQUESTOR_IP).toString();
			assertTrue("setCallDisposition success 4 ", response.equals(ConstantSetCallDisposition.successResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition success 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionFailure01()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.setCallDisposition(ConstantSetCallDisposition.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("setCallDisposition failure 1 ", response.equals(ConstantSetCallDisposition.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void setCallDispositionFailure02()
	{
		try
		{
			doReturn(ConstantSetCallDisposition.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantSetCallDisposition.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.setCallDisposition(ConstantSetCallDisposition.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("setCallDisposition failure 2 ", response.equals(ConstantSetCallDisposition.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("setCallDisposition failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileSuccess01()
	{
		try
		{
			doReturn(ConstantCreateVoiceFile.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCreateVoiceFile.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.createVoiceFile(ConstantCreateVoiceFile.successRequest1, "").toString();
			assertTrue("createVoiceFile success 1 ", response.equals(ConstantCreateVoiceFile.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("createVoiceFile success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileSuccess02()
	{
		try
		{
			doReturn(ConstantCreateVoiceFile.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantCreateVoiceFile.urlSuccessRequest2);
			String response = serviceMock.createVoiceFile(ConstantCreateVoiceFile.successRequest2, "").toString();
			assertTrue("createVoiceFile success 2 ", response.equals(ConstantCreateVoiceFile.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("createVoiceFile success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void createVoiceFileFailure01()
	{
		try
		{
			doReturn(ConstantCreateVoiceFile.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCreateVoiceFile.urlFailureRequest1);
			String response = serviceMock.createVoiceFile(ConstantCreateVoiceFile.failureRequest1, "").toString();
			assertTrue("createVoiceFile failure 1 ", response.equals(ConstantCreateVoiceFile.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("createVoiceFile failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileSuccess01()
	{
		try
		{
			doReturn(ConstantGetVoiceFile.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantGetVoiceFile.urlSuccessRequest1);
			String response = serviceMock.getVoiceFile(ConstantGetVoiceFile.successRequest1, "").toString();
			assertTrue("getVoiceFile success 1 ", response.equals(ConstantGetVoiceFile.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getVoiceFile success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileFailure01()
	{
		try
		{
			doReturn(ConstantGetVoiceFile.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantGetVoiceFile.urlFailureRequest1);
			String response = serviceMock.getVoiceFile(ConstantGetVoiceFile.failureRequest1, "").toString();
			assertTrue("getVoiceFile failure 1 ", response.equals(ConstantGetVoiceFile.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getVoiceFile failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getVoiceFileFailure02()
	{
		try
		{
			doReturn(ConstantGetVoiceFile.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantGetVoiceFile.urlFailureRequest2);
			String response = serviceMock.getVoiceFile(ConstantGetVoiceFile.failureRequest2, "").toString();
			assertTrue("getVoiceFile failure 2 ", response.equals(ConstantGetVoiceFile.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getVoiceFile failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallSuccess01()
	{
		try
		{
			doReturn(ConstantCallDisconnect.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantCallDisconnect.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.disconnectCall(ConstantCallDisconnect.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("disconnectCall success 1 ", response.equals(ConstantCallDisconnect.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("disconnectCall success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure01()
	{
		try
		{
			doReturn(ConstantCallDisconnect.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantCallDisconnect.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse2).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest2);
			String response = serviceMock.disconnectCall(ConstantCallDisconnect.failureRequest1, "").toString();
			assertTrue("disconnectCall failure 1 ", response.equals(ConstantCallDisconnect.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("disconnectCall failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure02()
	{
		try
		{
			doReturn(ConstantCallDisconnect.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantCallDisconnect.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyAgentResponse).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyAgentRequest);
			String response = serviceMock.disconnectCall(ConstantCallDisconnect.failureRequest2, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("disconnectCall failure 2 ", response.equals(ConstantCallDisconnect.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("disconnectCall failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void disconnectCallFailure03()
	{
		try
		{
			doReturn(ConstantCallDisconnect.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantCallDisconnect.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessEmptyIPResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessEmptyIPRequest1);
			String response = serviceMock.disconnectCall(ConstantCallDisconnect.failureRequest3, "").toString();
			assertTrue("disconnectCall failure 3 ", response.equals(ConstantCallDisconnect.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("disconnectCall failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundSuccess01()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("switchToInbound success 1 ", response.equals(ConstantSwitchInbound.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundSuccess02()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlSuccessRequest2);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.successRequest2, "").toString();
			assertTrue("switchToInbound success 2 ", response.equals(ConstantSwitchInbound.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure01()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.failureRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("switchToInbound failure 1 ", response.equals(ConstantSwitchInbound.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure02()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlFailureRequest2);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.failureRequest2, "").toString();
			assertTrue("switchToInbound failure 2 ", response.equals(ConstantSwitchInbound.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure03()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.failureRequest3, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("switchToInbound failure 3 ", response.equals(ConstantSwitchInbound.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToInboundFailure04()
	{
		try
		{
			doReturn(ConstantSwitchInbound.urlFailureResponse4).when(serviceMock)
					.callUrl(ConstantSwitchInbound.urlFailureRequest4);
			String response = serviceMock.switchToInbound(ConstantSwitchInbound.failureRequest4, "").toString();
			assertTrue("switchToInbound failure 4 ", response.equals(ConstantSwitchInbound.failureResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToInbound failure 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundSuccess01()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.switchToOutbound(ConstantSwitchOutbound.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("switchToOutbound success 1 ", response.equals(ConstantSwitchOutbound.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundSuccess02()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlSuccessRequest2);
			String response = serviceMock.switchToOutbound(ConstantSwitchOutbound.successRequest2, "").toString();
			assertTrue("switchToOutbound success 2 ", response.equals(ConstantSwitchOutbound.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure01()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.switchToOutbound(ConstantSwitchOutbound.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("switchToOutbound failure 1 ", response.equals(ConstantSwitchOutbound.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure02()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlFailureRequest2);
			String response = serviceMock.switchToOutbound(ConstantSwitchOutbound.failureRequest2, "").toString();
			assertTrue("switchToOutbound failure 2 ", response.equals(ConstantSwitchOutbound.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure03()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.switchToOutbound(ConstantSwitchOutbound.failureRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("switchToOutbound failure 3 ", response.equals(ConstantSwitchOutbound.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void switchToOutboundFailure04()
	{
		try
		{
			doReturn(ConstantSwitchOutbound.urlFailureResponse4).when(serviceMock)
					.callUrl(ConstantSwitchOutbound.urlFailureRequest4);
			String response = serviceMock.switchToOutbound(ConstantSwitchOutbound.failureRequest4, "").toString();
			assertTrue("switchToOutbound failure 4 ", response.equals(ConstantSwitchOutbound.failureResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("switchToOutbound failure 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentIPAddressSuccess01()
	{
		try
		{
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock
					.getAgentIPAddress(ConstantAgentIPAddress.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentIPAddress success 1 ", response.equals(ConstantAgentIPAddress.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentIPAddress success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentIPAddressFailure01()
	{
		try
		{
			doReturn(ConstantAgentIPAddress.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlFailureRequest1);
			String response = serviceMock
					.getAgentIPAddress(ConstantAgentIPAddress.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("getAgentIPAddress failure 1 ", response.equals(ConstantAgentIPAddress.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentIPAddress failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void blockNumberSuccess01()
	{
		try
		{
			doReturn(ConstantBlockNumber.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantBlockNumber.urlSuccessRequest1);
			String response =
					serviceMock.blockNumber(ConstantBlockNumber.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("blockNumber success 1 ", response.equals(ConstantBlockNumber.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("blockNumber success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void blockNumberFailure01()
	{
		try
		{
			doReturn(ConstantBlockNumber.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantBlockNumber.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.blockNumber(ConstantBlockNumber.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("blockNumber failure 1 ", response.equals(ConstantBlockNumber.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("blockNumber failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void unblockNumberSuccess01()
	{
		try
		{
			doReturn(ConstantUnblockNumber.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantUnblockNumber.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.unblockNumber(ConstantUnblockNumber.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("unblockNumber success 1 ", response.equals(ConstantUnblockNumber.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("unblockNumber success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void unblockNumberFailure01()
	{
		try
		{
			doReturn(ConstantUnblockNumber.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantUnblockNumber.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.unblockNumber(ConstantUnblockNumber.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("unblockNumber failure 1 ", response.equals(ConstantUnblockNumber.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("unblockNumber failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAvailableAgentSkillsSuccess01()
	{
		try
		{
			doReturn(ConstantAvailableAgents.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAvailableAgents.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAvailableAgentSkills(ConstantAvailableAgents.successRequest1, Constants.REQUESTOR_IP)
							.toString();
			assertTrue("getAvailableAgentSkills success 1 ", response.equals(ConstantAvailableAgents.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAvailableAgentSkills success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAvailableAgentSkillsSuccess02()
	{
		try
		{
			doReturn(ConstantAvailableAgents.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantAvailableAgents.urlSuccessRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.getAvailableAgentSkills(ConstantAvailableAgents.successRequest2, Constants.REQUESTOR_IP)
							.toString();
			assertTrue("getAvailableAgentSkills success 2 ", response.equals(ConstantAvailableAgents.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAvailableAgentSkills success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess01()
	{
		try
		{
			doReturn(ConstantTransferCall.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantTransferCall.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.successRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall success 1 ", response.equals(ConstantTransferCall.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess02()
	{
		try
		{
			doReturn(ConstantTransferCall.urlSuccessResponse2).when(serviceMock)
					.callUrl(ConstantTransferCall.urlSuccessRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.successRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall success 2 ", response.equals(ConstantTransferCall.successResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall success 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess03()
	{
		try
		{
			doReturn(ConstantTransferCall.urlSuccessResponse3).when(serviceMock)
					.callUrl(ConstantTransferCall.urlSuccessRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.successRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall success 3 ", response.equals(ConstantTransferCall.successResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall success 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess04()
	{
		try
		{
			doReturn(ConstantTransferCall.urlSuccessResponse4).when(serviceMock)
					.callUrl(ConstantTransferCall.urlSuccessRequest4);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.successRequest4, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall success 4 ", response.equals(ConstantTransferCall.successResponse4));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall success 4 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallSuccess05()
	{
		try
		{
			doReturn(ConstantTransferCall.urlSuccessResponse5).when(serviceMock)
					.callUrl(ConstantTransferCall.urlSuccessRequest5);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.successRequest5, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall success 5 ", response.equals(ConstantTransferCall.successResponse5));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall success 5 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure01()
	{
		try
		{
			doReturn(ConstantTransferCall.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantTransferCall.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.failureRequest1, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall failure 1 ", response.equals(ConstantTransferCall.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall failure 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure02()
	{
		try
		{
			doReturn(ConstantTransferCall.urlFailureResponse2).when(serviceMock)
					.callUrl(ConstantTransferCall.urlFailureRequest2);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.failureRequest2, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall failure 2 ", response.equals(ConstantTransferCall.failureResponse2));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall failure 2 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void transferCallFailure03()
	{
		try
		{
			doReturn(ConstantTransferCall.urlFailureResponse3).when(serviceMock)
					.callUrl(ConstantTransferCall.urlFailureRequest3);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response =
					serviceMock.transferCall(ConstantTransferCall.failureRequest3, Constants.REQUESTOR_IP).toString();
			assertTrue("transferCall failure 3 ", response.equals(ConstantTransferCall.failureResponse3));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("transferCall failure 3 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsSuccess1()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlSuccessRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.successRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getAgentCallStats success 1 ", response.equals(ConstantAgentStatus.successResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats success 1 failed with " + e.getMessage(), e);
		}
	}

	@Test
	public void getAgentCallStatsFailure1()
	{
		try
		{
			doReturn(ConstantAgentStatus.urlFailureResponse1).when(serviceMock)
					.callUrl(ConstantAgentStatus.urlFailureRequest1);
			doReturn(ConstantAgentIPAddress.urlSuccessResponse1).when(serviceMock)
					.callUrl(ConstantAgentIPAddress.urlSuccessRequest1);
			String response = serviceMock.getAgentCallStats(ConstantAgentStatus.failureRequest1, Constants.REQUESTOR_IP)
					.toString();
			assertTrue("getAgentCallStats failure 1 ", response.equals(ConstantAgentStatus.failureResponse1));
		} catch (Exception e)
		{
			e.printStackTrace();
			fail("getAgentCallStats failure 1 failed with " + e.getMessage(), e);
		}
	}
}
