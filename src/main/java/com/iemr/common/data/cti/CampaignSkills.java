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

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class CampaignSkills
{
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id= CTI_AGENT_SKILL_ADDUPDATE&agent_id=[value]&skill=[
	 * value]&weight=[value]&type=[type value 'add' or 'update' ]&resFormat=3
	 */
	/*
	 * { "response": { "transaction_id": "CTI_GET_CAMPAIGN_SKILLS" , "response_code": "1", "status": "SUCCESS",
	 * "campaign" : "UAT_1097_CO", "skills" :
	 * [{"skill_id":"1","skill_name":"English"},{"skill_id":"3","skill_name":"Hindi"},{"skill_id":"2","skill_name":
	 * "Kannada"}], "reason": ""} }
	 */
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	@Expose
	String campaign_name;
	@Expose
	String campaign;
	@Expose
	String weightage;
	@Expose
	JsonArray skills = new JsonArray();
	@Expose
	JsonArray campaignskills = new JsonArray();
	// @Expose
	// JSONObject skill = new JSONObject();
	@Expose
	CTIResponse response;

	public String getCampaignName()
	{
		return campaign_name;
	}

	public CTIResponse getResponse()
	{
		return response;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public void setResponse(CTIResponse ctiResponse)
	{
		this.response = ctiResponse;

	}
}
