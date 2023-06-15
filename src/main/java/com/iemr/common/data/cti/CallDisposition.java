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

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CallDisposition
{

	OutputMapper mapper = new OutputMapper();
	@Expose
	CTIResponse response;

	// @Expose
	// String response;
	@Expose
	String agent_id;
	@Expose
	String agent_ip;
	@Expose
	String cust_disp;
	@Expose
	String category;
	@Expose
	String session_id;
	@Expose
	String transaction_id;
	@Expose
	String agentid;
	@Expose
	String status;
	@Expose
	String reason;
	@Expose
	String response_code;

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	// public String getAgent_id()
	// {
	// return agent_id;
	// }
	//
	// public String getAgent_ip()
	// {
	// return agent_ip;
	// }
	//
	// public String getCust_disp()
	// {
	// return cust_disp;
	// }
	//
	// public String getCategory()
	// {
	// return category;
	// }
	//
	// public String getSession_id()
	// {
	// return session_id;
	// }
	//
	// public CTIResponse getResponse()
	// {
	// return response;
	// }
	//
	public void setResponse(CTIResponse ctiResponse)
	{
		response = ctiResponse;
		transaction_id = ctiResponse.getTransaction_id();
		agentid = ctiResponse.getAgentid();
		status = ctiResponse.getStatus();
		reason = ctiResponse.getReason();
		response_code = ctiResponse.getResponse_code();
	}
}
