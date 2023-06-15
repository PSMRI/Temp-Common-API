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
package com.iemr.common.data.everwell;

import java.util.ArrayList;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;

public class EverwellRegistration1097Identity {
	
	private Integer vanID;
	private Integer providerServiceMapID;
	private String firstName;
	private String lastName;
	private Integer genderID;
	private Integer titleId;
	private Integer maritalStatusID;
	private ArrayList<BenPhoneMap> benPhoneMaps;
	private Integer govtIdentityNo;
	private Integer govtIdentityTypeID;
	private boolean deleted;
	private String createdBy;
	private Integer statusID;
	private BeneficiaryDemographicsModel i_bendemographics;
	private boolean is1097;
	
	public EverwellRegistration1097Identity() {
		
	}
	
	public EverwellRegistration1097Identity(Integer vanID, Integer providerServiceMapID, String firstName, String lastName,
			Integer genderID, Integer titleId, Integer maritalStatusID, ArrayList<BenPhoneMap> benPhoneMaps, Integer govtIdentityNo,
			 Integer govtIdentityTypeID, boolean deleted, String createdBy, Integer statusID, BeneficiaryDemographicsModel bendemographics,
			 boolean is1097) {
		
		this.vanID = vanID;
		this.providerServiceMapID = providerServiceMapID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.genderID = genderID;
		this.titleId = titleId;
		this.maritalStatusID = maritalStatusID;
		this.benPhoneMaps = benPhoneMaps;
		this.govtIdentityNo = govtIdentityNo;
		this.govtIdentityTypeID = govtIdentityTypeID;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.statusID = statusID;
		this.i_bendemographics = bendemographics;
		this.is1097 = is1097;
	}
	
		

}
