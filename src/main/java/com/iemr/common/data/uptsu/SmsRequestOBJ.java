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
package com.iemr.common.data.uptsu;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class SmsRequestOBJ {
	
	private String choName;
	private String facilityPhoneNo;
	private String benPhoneNo;
	private String employeeCode;
	private String facilityName;
	private String hfrId;
	private String beneficiaryName;
	private Long beneficiaryId;
//	private Timestamp appointmentDate;
//	private Timestamp appointmentTime;
	private Integer smsTemplateID;
	private String choSms;
	private String benSms;
	private Integer smsTemplateTypeID;
	private String appointmentTime;
	private String appointmentDate;
	private Long beneficiaryRegID;
	private String createdBy;
	

}
