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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class Report1097ResponseModel
{
	private Long slNo;
	// private Long callSummaryID;
	// private Long benCallID;
	private Long beneficiaryID;
	// private Integer titleID;
	private String title;
	// private Integer genderID;
	private String gender;
	// private Integer maritalStatusID;
	private String maritalStatus;
	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String dob;
	private Integer age;
	// private Integer sexualOrientationID;
	private String sexualOrientation;
	// private String isHIVPositive;
	// private String isHIVPos;
	// private Integer educationID;
	private String education;
	// private Integer occupationID;
	private String occupation;
	// private Integer healthcareWorkerID;
	// private String healthcareWorker;
	// private String incomeStatus;
	// private Integer communityID;
	// private String community;
	private String preferredLanguage;
	// private Integer religionID;
	// private String religion;
	private String placeOfWork;
	// private Integer districtID;
	private String district;
	// private Integer stateID;
	private String state;
	// private Integer subDistrictID;
	private String subDistrict;
	private Integer benCreatedDate;
	// private Integer providerServiceMapID;
	private String beneficiaryCreatedBy;
	private Long feedbackID;
	private String feedback;
	// private Integer userID;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp callStartTime;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp callEndTime;
	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String callDate;
	// @JsonFormat(pattern = "HH")
	private String callHour;
	private String categoryName;
	private String subCategoryName;
	private String documentName;
	private String counselingCategoryName;
	private String counselingSubCategoryName;
	private String counsellingDocumentName;
	private String agentID;
	private String callID;
	private String username;
	private String outboundRequestedLanguage;
	private String remarks;
	private String callType;
	private String callSubType;
	private String userRole;
	@JsonFormat(pattern = "yyyy-MM-dd'T'00:00:00.000'Z'")
	private Timestamp startTimestamp;
	@JsonFormat(pattern = "yyyy-MM-dd'T'23:59:59.999'Z'")
	private Timestamp endTimestamp;
	private Boolean isCalledEarlier;
	private String phoneNo;
	private String callTransferRemarks;
	private String isOutbound;
	private String beneficiaryCallType;
	private String beneficiaryCallSubType;

	// private Integer minAge = 0;
	// private Integer maxAge = 150;

	public static Timestamp getDOB(Integer minAge)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, -1 * minAge);
		Timestamp timeStamp = new Timestamp(cal.getTime().getTime());
		return timeStamp;
	}

	@Override
	public String toString()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(callStartTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		this.callDate = dateFormat.format(callStartTime);
		this.callHour = hourFormat.format(callStartTime);
		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);
	}
}
