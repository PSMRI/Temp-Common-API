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

import java.math.BigInteger;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class IdentitySearchDTO {

	private BigInteger beneficiaryId;
	private BigInteger beneficiaryRegId;

	private String firstName;
	private String middleName;
	private String lastName;

	private Integer ageId;
	private Integer age;
	private Integer genderId;
	private String genderName;

	private String spouseName;
	private String fatherName;

	private String pinCode;
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;

	private String contactNumber;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp dob;

	// new column added for D2D, 21-01-2021
	private Long houseHoldID;
	private Boolean isD2D;
}
