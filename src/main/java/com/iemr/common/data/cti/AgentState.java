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
package com.iemr.common.data.cti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AgentState
{
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id= CTI_CHECK_AGENT_STATE&agent_id=2003&ip=&resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_CHECK_AGENT_STATE", "agentid": "2003", "requestparam": "login", "state":
	 * "BREAK###Lunch", "call_duration": "0", "status": "BREAK###Vinay###Lunch###00:00:00###272", "response_code": "0",
	 * "CLI": "", "session_id": "" } }
	 */

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();

	@Expose
	JsonObject stateObj = new JsonObject();
	@Expose
	CTIResponseTemp response;
	@Expose
	String transaction_id;
	@Expose
	String agent_id;
	@Expose
	String agentid;
	@Expose
	String requestparam;
	@Expose
	String state;
	@Expose
	String call_duration;
	@Expose
	String status;
	@Expose
	String response_code;
	@Expose
	String CLI;
	@Expose
	String session_id;
	@Expose
	String dialer_type;
	@Expose
	String campaign_dialerType;
	@Expose
	String previewDialing;
	@Expose
	String manual_dial;
	@Expose
	String last_cust_ph_no;
	@Expose
	String ivrs_path;
	@Expose
	String ivrs_language;
	@Expose
	String zoneName;
	@Expose
	String skills;
	@Expose
	String cust_ph_no;
	@Expose
	String reason;
	@Expose
	String wrapTime;
	@Expose
	String wrpupDisconnectFlag;
	@Expose
	String agent_ip;

	// public String getAgent_id()
	// {
	// return agent_id;
	// }

	@Override
	public String toString()
	{
		if (state != null)
		{
			this.setStateObj();
		}
		return OutputMapper.gson().toJson(this);
	}

	private void setStateObj()
	{
		String[] states = state.split("###");
		stateObj.addProperty("stateName", states[0]);
		if (states.length > 1)
		{
			stateObj.addProperty("stateType", states[1]);
		}
	}

	public void setResponse(CTIResponseTemp ctiResponse)
	{
		this.response = ctiResponse;
		this.transaction_id = ctiResponse.getTransaction_id();
		this.agent_id = ctiResponse.getAgent_id();
		this.agentid = ctiResponse.getAgentid();
		this.requestparam = ctiResponse.getRequestparam();
		this.state = ctiResponse.getState();
		this.call_duration = ctiResponse.getCall_duration();
		this.status = ctiResponse.getStatus();
		this.response_code = ctiResponse.getResponse_code().toString();
		this.CLI = ctiResponse.getCLI();
		this.session_id = ctiResponse.getSession_id();
		this.dialer_type = ctiResponse.getDialer_type();
		this.campaign_dialerType = ctiResponse.getCampaign_dialerType();
		this.previewDialing = ctiResponse.getPreviewDialing();
		this.manual_dial = ctiResponse.getManual_dial();
		this.last_cust_ph_no = ctiResponse.getLast_cust_ph_no();
		this.ivrs_path = ctiResponse.getIvrs_path();
		this.skills = ctiResponse.getSkills();
		this.cust_ph_no = ctiResponse.getCust_ph_no();
		this.reason = ctiResponse.getReason();
		this.wrapTime = ctiResponse.getWrapTime();
		this.wrpupDisconnectFlag = ctiResponse.getWrpupDisconnectFlag();
		this.agent_ip = ctiResponse.getAgent_ip();
	}

	public CTIResponseTemp getResponse()
	{
		return this.response;
	}
}
