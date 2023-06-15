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
public class CTIUser {
	/*
	 * http://10.208.122.99/apps/cust_appsHandler.php?transaction_id=
	 * CTI_SYSTEM_USER&username=vinays1097&password=
	 * vinays123&firstname=vinay&lastname=sompur&phone=1234567899&email=
	 * vinays@wipro.com&role=supervisor&
	 * sessiontimeout=60000&designation=supervisor&resFormat=3
	 */
	/*
	 * Output: { "response": { "transaction_id": "CTI_SYSTEM_USER" ,
	 * "user_name": "vinays1097" , "response_code": "1", "status": "SUCCESS",
	 * "reason": ""} }
	 */
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	OutputMapper outputMapper = new OutputMapper();
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String role;
	private String designation;
	@Expose
	private String transaction_id;
	@Expose
	private String user_name;
	@Expose
	private String reason;
	@Expose
	private String response_code;
	@Expose
	private String status;
	@Expose
	private CTIResponse response;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getDesignation() {
		return designation;
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
		this.user_name = response.getUser_name();
		this.reason = response.getReason();
		this.response_code = response.getResponse_code();
		this.status = response.getStatus();

	}
}
