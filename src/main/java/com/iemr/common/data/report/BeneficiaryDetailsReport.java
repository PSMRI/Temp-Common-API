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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
@Table(name = "db_reporting.dim_1097beneficiary", schema = "db_reporting")
@Data
public class BeneficiaryDetailsReport implements Serializable
{
	@Transient
	private static final String POSITIVE = "Yes";
	@Transient
	private static final String NEGETIVE = "No";
	@Transient
	private static final String ND = "Not Disclosed";
	@Transient
	private static final int POSITIVE_INT = 1;
	@Transient
	private static final int NEGETIVE_INT = 2;
	@Transient
	private static final int ND_INT = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Dim_1097BeneficiaryID", insertable = false, updatable = false)
	private Long beneficiaryID1097;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BeneficiaryID")
	private Long beneficiaryID;

	@Expose
	@Column(name = "TitleID")
	private Integer titleID;
	@Expose
	@Column(name = "Title")
	private String title;

	@Expose
	@Column(name = "GenderId")
	private Integer genderID;
	@Expose
	@Column(name = "Gender")
	private String gender;

	@Expose
	@Column(name = "MaritalStatusId")
	private Integer maritalStatusID;
	@Expose
	@Column(name = "MaritalStatus")
	private String maritalStatus;

	@Expose
	@Column(name = "DOB")
	private Timestamp dob;
	@Expose
	@Column(name = "SexualOrientationId")
	private Integer sexualOrientationID;
	@Expose
	@Column(name = "SexualOrientationType")
	private String sexualOrientation;
	@Expose
	@Column(name = "HIVStatus")
	private Integer isHIVPos;

	@Expose
	@Column(name = "educationId")
	private Integer educationID;
	@Expose
	@Column(name = "education")
	private String education;

	@Expose
	@Column(name = "occupationID")
	private Integer occupationID;
	@Expose
	@Column(name = "occupation")
	private String occupation;

	@Expose
	@Column(name = "HealthCareWorkerId")
	private Integer healthcareWorkerID;
	@Expose
	@Column(name = "HealthCareWorker")
	private String healthcareWorker;

	@Expose
	@Column(name = "incomeStatus")
	private String incomeStatus;
	@Expose
	@Column(name = "communityId")
	private Integer communityID;
	@Expose
	@Column(name = "community")
	private String community;

	@Expose
	@Column(name = "preferredLanguage")
	private String preferredLanguage;

	@Expose
	@Column(name = "religionId")
	private Integer religionID;
	@Expose
	@Column(name = "religion")
	private String religion;

	@Expose
	@Column(name = "PlaceOfWork")
	private String placeOfWork;

	@Expose
	@Column(name = "PermDistrictId")
	private Integer districtID;
	@Expose
	@Column(name = "PermDistrict")
	private String district;
	@Expose
	@Column(name = "PermStateID")
	private Integer stateID;
	@Expose
	@Column(name = "PermState")
	private String state;

	@Expose
	@Column(name = "PermSubDistrictId")
	private Integer subDistrictID;
	@Expose
	@Column(name = "PermSubDistrict")
	private String subDistrict;

	@Expose
	@Column(name = "CreatedDate")
	private Integer benCreatedDate;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CreatedBy")
	private String beneficiaryCreatedBy;
	@Expose
	@Column(name = "LoadedBy")
	private String loadedBy;
	@Column(name = "LodadedDate")
	private Timestamp loadDate;

	@Transient
	private final Integer START_YEAR_1970 = 1970;

	@Transient
	private final SimpleDateFormat DOB_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	public BeneficiaryDetailsReport()
	{
	}

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}

	public Integer getAge()
	{
		Integer age = null;
		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
		if (dob != null)
		{
			age = Integer
					.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - dob.getTime())))
					- START_YEAR_1970;
		}
		return age;
	}

	public static String getIsHIVPositive(Integer status)
	{
		String isHIVPositive = ND;
		if (status != null)
		{
			switch (status)
			{
				case POSITIVE_INT:
					isHIVPositive = POSITIVE;
					break;
				case NEGETIVE_INT:
					isHIVPositive = NEGETIVE;
					break;
			}
		}
		return isHIVPositive;
	}

	public String getDobAsString()
	{
		String dobAsString = null;
		if (dob != null)
		{
			dobAsString = DOB_FORMAT.format(dob);
		}
		return dobAsString;
	}

}
