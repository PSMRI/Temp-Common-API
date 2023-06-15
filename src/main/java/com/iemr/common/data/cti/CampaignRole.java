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

import javax.persistence.Transient;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CampaignRole
{
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
	@Transient
	private OutputMapper mapper = new OutputMapper();
	@Expose
	private String transaction_id;
	@Expose
	private String campaign;
	@Expose
	private JsonArray roles;
	@Expose
	private String response_code;
	@Expose
	private String status;
	@Expose
	private String reason;
	@Expose
	private CTIResponse response;

	public CampaignRole()
	{
	}

	public String getCampaign()
	{
		return campaign;
	}

	public JsonArray getRoles()
	{
		return roles;
	}

	@Override
	public String toString()
	{
		return mapper.gson().toJson(this);
	}

	public CTIResponse getResponse()
	{
		return response;
	}

	public void setResponse(CTIResponse response)
	{
		this.response = response;
		this.transaction_id = response.getTransaction_id();
		this.campaign = response.getCampaign();
		this.roles = response.getRoles();
		this.response_code = response.getResponse_code();
		this.status = response.getStatus();
		this.reason = response.getReason();
	}
}
