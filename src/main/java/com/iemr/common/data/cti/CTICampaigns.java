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

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CTICampaigns
{
	/*
	 * http://10.208.122.99/apps/appsHandler.php?transaction_id=
	 * CTI_TRANSFERABLE_CAMPAIGNS&agent_id=2003&ip=10.208.18.85& resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_TRANSFERABLE_CAMPAIGNS", "agentid": "2003", "campaign":
	 * [{"campaign_id":"1","campaign_name":"UAT_1097_CO"},{"campaign_id":"4", "campaign_name":"UAT_1097_MO"}] } }
	 */
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	private String agent_id;
	@Expose
	private String transaction_id;
	@Expose
	private String agentid;
	@Expose
	private JsonArray campaign;
	@Expose
	private CTIResponseTemp response;
	@Expose
	private String response_code;
	@Expose
	private String reason;
	@Expose
	private String status;

	// public String getAgent_id() {
	// return agent_id;
	// }

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	public CTIResponseTemp getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponseTemp response)
	{
		this.response = response;
		this.transaction_id = response.getTransaction_id();
		this.agentid = response.getAgentid();
		this.campaign = response.getCampaign();
		this.response_code = response.getResponse_code();
		this.reason = response.getReason();
		this.status = response.getStatus();
	}
}
