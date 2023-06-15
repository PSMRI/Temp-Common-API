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
package com.iemr.common.data.report;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_feedback", schema = "db_reporting")
@Data
public class FeedbackReport implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Fact_FeedbackID", insertable = false, updatable = false)
	private Long factFeedbackID;
	@Column(name = "FeedbackID")
	private Long feedbackID;
	@Column(name = "BenCallID")
	private Long benCallID;
	@Column(name = "RequestID")
	private String requestID;
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Column(name = "FeedbackAgainst")
	private String feedbackAgainst;
	@Column(name = "DesignationID")
	private Integer designationID;
	@Column(name = "DesignationName")
	private String designationName;
	@Column(name = "InstitutionID")
	private Integer institutionID;
	@Column(name = "InstitutionName")
	private String institutionName;
	@Column(name = "StateID")
	private Integer stateID;
	@Column(name = "StateName")
	private String stateName;
	@Column(name = "DistrictID")
	private Integer districtID;
	@Column(name = "DistrictName")
	private String districtName;
	@Column(name = "BlockID")
	private Integer blockID;
	@Column(name = "BlockName")
	private String blockName;
	@Column(name = "DistrictBranchID")
	private Integer districtBranchID;
	@Column(name = "DistrictBranchName")
	private String districtBranchName;
	@Column(name = "InstitutionTypeID")
	private Integer institutionTypeID;
	@Column(name = "InstituteTypeName")
	private String instituteTypeName;
	@Column(name = "SeverityID")
	private Integer severityID;
	@Column(name = "SeverityName")
	private String severityName;
	@Column(name = "FeedbackTypeID")
	private Integer feedbackTypeID;
	@Column(name = "FeedbackTypeName")
	private String feedbackTypeName;
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;
	@Column(name = "FeedbackNatureName")
	private String feedbackNatureName;
	@Column(name = "FeedbackStatusID")
	private Integer feedbackStatusID;
	@Column(name = "FeedbackStatusName")
	private String feedbackStatusName;
	@Column(name = "Feedback")
	private String feedback;
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Column(name = "UserID")
	private Integer userID;
	@Column(name = "SMSPhoneNo")
	private String smsPhoneNo;
	@Column(name = "ServiceAvailDate")
	private Timestamp serviceAvailDate;
	@Column(name = "EmailStatusID")
	private Integer emailStatusID;
	@Column(name = "LoadedBy")
	private String loadedBy;
	@Column(name = "LodadedDate")
	private Timestamp lodadedDate;
	
	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	public FeedbackReport()
	{

	}

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}