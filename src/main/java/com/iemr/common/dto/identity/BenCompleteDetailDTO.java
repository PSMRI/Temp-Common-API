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
package com.iemr.common.dto.identity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BenCompleteDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BeneficiaryFamilyTags[] beneficiaryFamilyTags;
	// private null beneficiaryServiceMap;
	// private BeneficiaryDetails beneficiaryDetails;
	private String emergencyContactTyp;
	private String preferredSMSPhoneTyp;
	private BigInteger benRegId;
	private String modifiedBy;
	private String emergencyContactNum;
	private String preferredEmailId;
	private String preferredSMSPhoneNum;
	private Boolean deleted;
	// private null contacts;
	private Timestamp lastModDate;
	private String preferredPhoneNum;
	private BigInteger benMapId;
	private String createdBy;
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;
	private String preferredPhoneTyp;
	private BigInteger benId;
	// private BeneficiaryIdentites[] beneficiaryIdentites;
	private Timestamp createdDate;
	

}
