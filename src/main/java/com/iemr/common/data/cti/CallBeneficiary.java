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

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CallBeneficiary
{
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id=CTI_DIAL& agent_id=2003&ip=10.208.24.185&phone_num=
	 * 1234567899&resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_DIAL", "agentid": "2003", "requestparam": "1234567899", "status":
	 * "SUCCESS", "response_code": "1" } }
	 */

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	private String agent_id;
	@Expose
	private String phone_num;
	@Expose
	private String transaction_id;
	@Expose
	private String agentid;
	@Expose
	private String requestparam;
	@Expose
	private String status;
	@Expose
	private String response_code;
	@Expose
	private String reason;
	@Expose
	private CTIResponse response;

	// public String getAgent_id() {
	// return agent_id;
	// }
	//
	// public String getPhone_num() {
	// return phone_num;
	// }

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	public CTIResponse getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponse ctiResponse)
	{
		this.response = ctiResponse;
		this.agentid = ctiResponse.getAgentid();
		this.status = ctiResponse.getStatus();
		this.response_code = ctiResponse.getResponse_code();
		this.reason = ctiResponse.getReason();
	}
}
