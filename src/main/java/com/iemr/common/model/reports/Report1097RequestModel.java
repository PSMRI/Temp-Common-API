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
package com.iemr.common.model.reports;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Report1097RequestModel
{
	private Integer providerServiceMapID;
	private String callType /* = "%%" */;
	private String callSubType /* = "%%" */;
	private String beneficiaryCallType /* = "%%" */;
	private String beneficiaryCallSubType /* = "%%" */;
	@JsonFormat(pattern = "yyyy-MM-dd'T'00:00:00.000'Z'")
	private Timestamp startTimestamp;
	@JsonFormat(pattern = "yyyy-MM-dd'T'23:59:59.999'Z'")
	private Timestamp endTimestamp;
	private Integer minAge = 0;
	private Integer maxAge = 150;
	private String state /* = "%%" */;
	private String district /* = "%%" */;
	private String gender /* = "%%" */;
	private String beneficiaryPreferredLanguage /* = "%%" */;
	private String title /* = "%%" */;
	private String maritalStatus /* = "%%" */;
	private String beneficiarySexualOrientation /* = "%%" */;
	private String education /* = "%%" */;
	private String occupation /* = "%%" */;
	private String healthcareWorker /* = "%%" */;
	private String incomeStatus /* = "%%" */;
	private String community /* = "%%" */;
	private String religion /* = "%%" */;
	private String placeOfWork /* = "%%" */;
	private String subDistrict /* = "%%" */;
	private String callerAgeGroup;
	

}
