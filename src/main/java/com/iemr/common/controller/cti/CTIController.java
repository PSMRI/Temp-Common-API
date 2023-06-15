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
package com.iemr.common.controller.cti;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.cti.CustomerLanguage;
import com.iemr.common.service.cti.CTIService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/cti")
public class CTIController
{
	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	CTIService ctiService;

	@Autowired
	public void setCtiService(CTIService ctiService)
	{
		this.ctiService = ctiService;
	}

	/*
	 * API for agent skill add and update:
	 */
	/*
	 * Input: http://10.208.122.99/apps/cust_appsHandler.php?transaction_id=
	 * CTI_AGENT_SKILL_ADDUPDATE&agent_id=2003&skill= English&weight=20&type=add&resFormat=3
	 */
	/* Output: */
	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/addUpdateAgentSkills", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String addUpdateAgentSkills(
			@ApiParam("{\"agent_id\":\"Integer\", \"skill\":\"String skill name\", "
					+ "\"weight\":\"Integer agent proficiency/weight\", "
					+ "\"type\":\"String: Operation Type add/update\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("addUpdateAgentSkills received a request " + request);
		try
		{

			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.addUpdateAgentSkills(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("addUpdateAgentSkills failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("addUpdateAgentSkills sending response " + response);
		return response.toString();
	}

	/*
	 * API for get campaign wise skill details:
	 */
	/*
	 * Input: http://10.208.122.99/apps/cust_appsHandler.php?transaction_id=
	 * CTI_GET_CAMPAIGN_SKILLS&campaign_name=[value]& resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_GET_CAMPAIGN_SKILLS" , "response_code": "1", "status": "SUCCESS",
	 * "campaign" : UAT_1097_CO, "skills" : {"English":"1","Hindi":"3","Kannada":"2"}, "reason": ""} }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getCampaignSkills", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getCampaignSkills(
			@ApiParam("{\"campaign_name\":\"String: Name of the campaign\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignSkills received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignSkills(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getCampaignSkills failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignSkills sending response " + response);
		return response.toString();
	}

	/*
	 * API for get agent status: http://10.208.122.99/apps/appsHandler.php?transaction_id=
	 * CTI_CHECK_AGENT_STATE&agent_id=AGENT_ID&ip=&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getAgentState", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getAgentState(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getAgentState received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentState(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getAgentState failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentState sending response " + response);
		return response.toString();
	}

	/*
	 * API for get agent call statistics: http://10.208.122.99/apps/appsHandler.php?transaction_id=
	 * CTI_AGENT_CALL_RECORD&agent_id=AGENT_ID&ip=&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getAgentCallStats", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getAgentCallStats(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getAgentCallStats received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentCallStats(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getAgentCallStats failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentCallStats sending response " + response);
		return response.toString();
	}

	/*
	 * API for get campaign names/*
	 */
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_GET_CAMPAIGNS&campaign_type=&searchkey=104&
	 * resFormat=3
	 */
	/*
	 * Output:{ "response": { "transaction_id": "CTI_GET_CAMPAIGNS" , "response_code": "1", "status": "SUCCESS",
	 * "campaign" : [{"campaign_id":"7","campaign_name":"UAT_104_CO"},{"campaign_id":"5",
	 * "campaign_name":"UAT_104_HAO"},{ "campaign_id":"3","campaign_name":"UAT_104_MO"},{"campaign_id":"10",
	 * "campaign_name":"UAT_104_PD"},{"campaign_id":
	 * "2","campaign_name":"UAT_104_RO"},{"campaign_id":"6","campaign_name": "UAT_104_SIO"},{"campaign_id":"11",
	 * "campaign_name":"UAT_104_Surveyor"}], "reason": ""} }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getCampaignNames", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getCampaignNames(
			@ApiParam("{\"serviceName\":\"String: service name\", "
					+ "\"type\":\"String - inbound, outbound\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignNames received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignNames(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getCampaignNames failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignNames sending response " + response);
		return response.toString();
	}

	/*
	 * API set agent status as ready
	 */
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=CTI_LOGIN& agent_id=2003&resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_LOGIN", "agentid": "2003", "requestparam": "login", "status":
	 * "SUCCESS", "response_code": "1" } }
	 */
	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/doAgentLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String doAgentLogin(@ApiParam("{\"agent_id\":\"String: agent_id\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("doAgentLogin received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.doAgentLogin(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("doAgentLogin failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("doAgentLogin sending response " + response);
		return response.toString();
	}

	/*
	 * API for get user key:
	 */
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_LOGIN_KEY&username=vinays&password=123456&
	 * resFormat=3
	 */
	/*
	 * output: { "response": { "transaction_id": "CTI_LOGIN_KEY" , "response_code": "1", "status": "SUCCESS", "username"
	 * : "adminrw", "login_key" : "83977518258616", "reason": ""} }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getLoginKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getLoginKey(
			@ApiParam("{\"username\":\"String: user name\", \"password\":\"String: password\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getLoginKey received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getLoginKey(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getLoginKey failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getLoginKey sending response " + response);
		return response.toString();
	}

	/*
	 * API for agent logout
	 */
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=CTI_LOGOUT& agent_id=2003&ip=10.208.24.185&resFormat= 3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_LOGOUT", "agentid": "2003", "requestparam": "logoff", "status":
	 * "FAIL", "response_code": "-1" } }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/doAgentLogout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String doAgentLogout(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("agentLogout received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.agentLogout(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("agentLogout failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("agentLogout sending response " + response);
		return response.toString();
	}

	/*
	 * API for get online agent names
	 */
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=CTI_ONLINE_AGENTS &agent_id=2003&ip=10.208.24.185&
	 * resFormat=3
	 */
	/* Output: */
	@CrossOrigin()
	@RequestMapping(value = "/getOnlineAgents", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getOnlineAgents(@ApiParam("{\"agent_id\":\"String: agent id\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getOnlineAgents received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getOnlineAgents(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getOnlineAgents failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getOnlineAgents sending response " + response);
		return response.toString();
	}

	/*
	 * API for get campaign names:
	 */
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id =2003&ip=10.208.24.185&phone_num=
	 * 1234567899&resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_DIAL", "agentid": "2003", "requestparam": "1234567899", "status":
	 * "SUCCESS", "response_code": "1" } }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/callBeneficiary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String callBeneficiary(
			@ApiParam("{\"agent_id\":\"String: agent_id\", \"phone_num\":\"String - phone number\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("callBeneficiary received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.callBeneficiary(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("callBeneficiary failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("callBeneficiary sending response " + response);
		return response.toString();
	}

	/*
	 * API for add/update user data in CTI
	 */
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_SYSTEM_USER&username=vinays1097&password=
	 * vinays123&firstname=vinay&lastname=sompur&phone=1234567899&email= vinays@wipro.com&role=supervisor_104&
	 * sessiontimeout=60000&designation=supervisor&resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_SYSTEM_USER" , "user_name": "vinays1097" , "response_code": "1",
	 * "status": "SUCCESS", "reason": ""} }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/addUpdateUserData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String addUpdateUserData(
			@ApiParam("{\"username\":\"String: username\", \"password\":\"String - password\", "
					+ "\"firstname\":\"String - firstname\", \"lastname\":\"String - lastname\", "
					+ "\"phone\":\"String - phone\", \"email\":\"String - email\", \"role\":\"String - role\""
					+ ", \"designation\":\"String - designation\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("updateUserData received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.addUpdateUserData(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("updateUserData failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("updateUserData sending response " + response);
		return response.toString();
	}

	/*
	 * API to get transferable campaigns
	 */
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=
	 * CTI_TRANSFERABLE_CAMPAIGNS&agent_id=2003&ip=10.208.18.85& resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_TRANSFERABLE_CAMPAIGNS", "agentid": "2003", "campaign":
	 * [{"campaign_id":"1","campaign_name":"UAT_1097_CO"},{"campaign_id":"4", "campaign_name":"UAT_1097_MO"}] } }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getTransferCampaigns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getTransferCampaigns(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getTransferCampaigns received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getTransferCampaigns(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getTransferCampaigns failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getTransferCampaigns sending response " + response);
		return response.toString();
	}

	/*
	 * API to get campaign roles
	 */
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_GET_CAMP_ROLE&campaign=UAT_1097_CO&resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_GET_CAMP_ROLE" , "campaign": "UAT_1097_CO" , "roles": "Supervisor_1097" ,
	 * "response_code": "1", "status": "SUCCESS", "reason": ""} }
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getCampaignRoles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getCampaignRoles(@ApiParam("{\"campaign\":\"String: campaign name\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCampaignRoles received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getCampaignRoles(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getCampaignRoles failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCampaignRoles sending response " + response);
		return response.toString();
	}

	/*
	 * API to set Call Disposition
	 */
	@CrossOrigin()
	@RequestMapping(value = "/setCallDisposition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String setCallDisposition(
			@ApiParam("{\"agent_id\":\"String: agentID\", \"cust_disp\":\"String - call subtype\", "
					+ "\"category\":\"String: call type\", \"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("setCallDisposition received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.setCallDisposition(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("setCallDisposition failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("setCallDisposition sending response " + response);
		return response.toString();
	}

	/*
	 * API to create voice recordings http://CTI_SERVER/apps/appsHandler.php?transaction_id=CTI_MIX_VOICE_FILE&
	 * agent_id=AGENT_ID&session_id=SESSION_ID&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/createVoiceFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String createVoiceFile(
			@ApiParam("{\"agent_id\":\"String: agentID\", "
					+ "\"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("createVoiceFile received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.createVoiceFile(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("createVoiceFile failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("createVoiceFile sending response " + response);
		return response.toString();
	}

	/*
	 * API to create voice recordings http://CTI_SERVER/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&
	 * agent_id=AGENT_ID&session_id=SESSION_ID&ip=IP_ADDRESS&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getVoiceFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getVoiceFile(
			@ApiParam("{\"agent_id\":\"String: agentID\", "
					+ "\"session_id\":\"String: unique call id from c-zentrix\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getVoiceFile received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getVoiceFile(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getVoiceFile failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getVoiceFile sending response " + response);
		return response.toString();
	}

	/*
	 * API to create voice recordings http://CTI_SERVER/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&
	 * agent_id=AGENT_ID&session_id=SESSION_ID&ip=IP_ADDRESS&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/disconnectCall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String disconnectCall(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.disconnectCall(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	/*
	 * API to create voice recordings http://CTI_SERVER/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&
	 * agent_id=AGENT_ID&session_id=SESSION_ID&ip=IP_ADDRESS&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/switchToInbound", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String switchToInbound(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.switchToInbound(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	/*
	 * API to create voice recordings http://CTI_SERVER/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&
	 * agent_id=AGENT_ID&session_id=SESSION_ID&ip=IP_ADDRESS&resFormat=3
	 */
	@CrossOrigin()
	@RequestMapping(value = "/switchToOutbound", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String switchToOutbound(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("disconnectCall received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.switchToOutbound(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("disconnectCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("disconnectCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getAgentIPAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getAgentIPAddress(@ApiParam("{\"agent_id\":\"String: agentID\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getAgentIPAddress received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAgentIPAddress(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getAgentIPAddress failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAgentIPAddress sending response " + response);
		return response.toString();
	}

	/*
	 * Below block and unblock functionality is not allowed to be called directly. It is internally called from
	 * beneficiary call API
	 */
	// @CrossOrigin()
	// @RequestMapping(value = "/blockNumber", method = RequestMethod.POST,
	// produces = MediaType.APPLICATION_JSON)
	// public String blockNumber(@ApiParam("{\"phoneNo\":\"String: phone
	// number\", campaignName:\"Name of campaign\"}")
	// @RequestBody String request,
	// HttpServletRequest serverRequest)
	// {
	// OutputResponse response = new OutputResponse();
	// logger.info("blockNumber received a request " + request);
	// try
	// {
	// response = ctiService.blockNumber(request,
	// serverRequest.getRemoteAddr());
	// } catch (Exception e)
	// {
	// logger.error("blockNumber failed with error " + e.getMessage(), e);
	// response.setError(e);
	// }
	// logger.info("blockNumber sending response " + response);
	// return response.toString();
	// }
	//
	// @CrossOrigin()
	// @RequestMapping(value = "/unblockNumber", method = RequestMethod.POST,
	// produces = MediaType.APPLICATION_JSON)
	// public String unblockNumber(@ApiParam("{\"phoneNo\":\"String: phone
	// number\", campaignName:\"Name of
	// campaign\"}") @RequestBody String request,
	// HttpServletRequest serverRequest)
	// {
	// OutputResponse response = new OutputResponse();
	// logger.info("unblockNumber received a request " + request);
	// try
	// {
	// response = ctiService.unblockNumber(request,
	// serverRequest.getRemoteAddr());
	// } catch (Exception e)
	// {
	// logger.error("unblockNumber failed with error " + e.getMessage(), e);
	// response.setError(e);
	// }
	// logger.info("unblockNumber sending response " + response);
	// return response.toString();
	// }

	@CrossOrigin()
	@RequestMapping(value = "/getAvailableAgentSkills", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getAvailableAgentSkills(
			@ApiParam("{\"campaignName\":\"String: campaign name\", "
					+ "\"skill\":\"String: skill name\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getAvailableAgentSkills received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getAvailableAgentSkills(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getAvailableAgentSkills failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getAvailableAgentSkills sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/transferCall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String
			transferCall(@ApiParam("{\"transfer_from\":\"String - agent id who is transferring call\", "
					+ "\"transfer_to\":\"String - agent ID who would be receiving call\", "
					+ "\"transfer_campaign_info\": \"String - name of the campaign to which call will be transferred\", "
					+ "\"skill_transfer_flag\":\"Integer - 0 for no skill or 1 for skill based\", "
					+ "\"skill\":\"String - skill name\",\"benCallID\":\"Integer - callID as in CRM\", \"agentIPAddress\":\"Optional String - agent IP address\","
					+ "\"callTypeID\" : \"Integer\"}. transfer_to will be having higher precedence to all "
					+ "3 remaining inputs") @RequestBody String request, HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("transferCall received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.transferCall(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("transferCall failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("transferCall sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/customerPreferredLanguage", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String customerPreferredLanguage(
			@ApiParam("{\"cust_ph_no\":\"phone number of customer\", "
					+ "\"campaign_name\":\"campaign name for provider from provider service mapping\", "
					+ "\"language\": \"String - language name selected by user\", "
					+ "\"action\":\"String - select or update\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("customerPreferredLanguage received a request " + request);
		try
		{
			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			CustomerLanguage custLang = InputMapper.gson().fromJson(request, CustomerLanguage.class);
			response = ctiService.customerPreferredLanguage(custLang, remoteAddress);
		} catch (Exception e)
		{
			logger.error("customerPreferredLanguage failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("customerPreferredLanguage sending response " + response);
		return response.toString();
	}

	/*
	 * API to add Numbers for auto dailing
	 */
	/*
	 * http://helplines.piramalswasthya.org/apps/addlead.php?mobile=88548585&camp_name=H_MCTS_MO&Agent_id=200001&
	 * paramter1=123
	 */
	/* Output: */
	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/addAutoDialNumbers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String addAutoDialNumbers(
			@ApiParam("{\"agent_id\":\"Integer\", \"mobile\":\"String mobile number\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("addAutoDialNumbers received a request " + request);
		try
		{

			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.addAutoDialNumbers(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("addAutoDialNumbers failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("addAutoDialNumbers sending response " + response);
		return response.toString();
	}

	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/setAutoDialNumbers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String setAutoDialNumbers(
			@ApiParam("{\"agent_id\":\"Integer\", \"mobile\":\"String mobile number\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("setAutoDialNumbers received a request " + request);
		try
		{

			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.setAutoDialNumbers(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("setAutoDialNumbers failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("setAutoDialNumbers sending response " + response);
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getIVRSPathDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getIVRSPathDetails(@ApiParam("{\"agent_id\":\"Integer\"}") @RequestBody String request,
			HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getIVRSPathDetails received a request " + request);
		try
		{

			String remoteAddress = serverRequest.getHeader("X-FORWARDED-FOR");
			if (remoteAddress == null || remoteAddress.trim().length() == 0)
			{
				remoteAddress = serverRequest.getRemoteAddr();
			}
			response = ctiService.getIVRSPathDetails(request, remoteAddress);
		} catch (Exception e)
		{
			logger.error("getIVRSPathDetails failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getIVRSPathDetails sending response " + response);
		return response.toString();
	}
}
