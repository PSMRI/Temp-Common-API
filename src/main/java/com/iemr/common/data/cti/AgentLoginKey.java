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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class AgentLoginKey {
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id=
	 * CTI_LOGIN_KEY&username=vinays&password=123456& resFormat=3
	 */
	/*
	 * output: { "response": { "transaction_id": "CTI_LOGIN_KEY" ,
	 * "response_code": "1", "status": "SUCCESS", "username" : "vinays",
	 * "login_key" : "83977518258616", "reason": ""} }
	 */

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	private String username;
	@Expose
	private String password;
	@Expose
	private String transaction_id;
	@Expose
	private String login_key;
	@Expose
	private String reason;
	@Expose
	private String status;
	@Expose
	private String response_code;
	@Expose
	private CTIResponse response;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public CTIResponse getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponse response)
	{
		this.response = response;
		this.transaction_id = response.getTransaction_id();
		this.response_code = response.getResponse_code();
		this.status = response.getStatus();
		this.login_key = response.getLogin_key();
		this.reason = response.getReason();

	}
}
