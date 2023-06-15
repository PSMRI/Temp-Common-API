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
package com.iemr.common.data.beneficiary;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.BeneficiaryCall;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.utils.mapper.InputMapper;

import lombok.Data;

@Data
public class Beneficiary
{
	private static final int START_YEAR_1970 = 1970;

	private Long beneficiaryRegID;

	@Expose
	private BenDemographics i_bendemographics;

	private List<BenMedHistory> t_benmedhistory;

	private List<BenPhoneMap> benPhoneMaps;

	private List<BenPhoneMap> parentBenPhoneMaps;

	//
	private List<OutboundCallRequest> outboundCallRequests;

	//
	private List<BeneficiaryCall> beneficiaryCalls;

	private List<FeedbackDetails> feedbacks;

	private String beneficiaryID;

	private Integer titleId;

	private String titleName;

	@JsonIgnore

	private Title m_title;

	private String firstName = "";

	private String middleName = "";

	private String lastName = "";

	private Integer statusID;

	@JsonIgnore

	private Status m_status;

	private Integer genderID;

	private String genderName;

	@JsonIgnore

	private Gender m_gender;

	private Integer maritalStatusID;

	private String maritalStatusName;

	@JsonIgnore

	private MaritalStatus m_maritalstatus;

	private Integer sexualOrientationId;

	@JsonIgnore

	private SexualOrientation sexualOrientation;

	private Timestamp dOB;

	@Transient

	private Integer age;

	private String fatherName = "";

	private String spouseName = "";

	@Transient
	SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");

	// @Column(name = "PhoneNo")
	//
	// private String phoneNo;
	// @Column(name = "PhoneTypeID")
	//
	// private Short phoneTypeID;
	// @Column(name = "AltPhoneNo")
	//
	// private String altPhoneNo;
	// @Column(name = "AltPhoneTypeID")
	//
	// private Short altPhoneTypeID;
	// @Column(name = "ParentBenRegID")
	//
	// private Long parentBenRegID;
	// @Column(name = "BeneficiaryTypeID")
	//
	// private Short beneficiaryTypeID;

	private String govtIdentityNo;

	private Integer govtIdentityTypeID;

	@Transient
	private GovtIdentityType govtIdentityType;

	private Integer registeredServiceID;

	private String sourceOfInformation;

	private Boolean deleted;

	private String createdBy;

	private Timestamp createdDate;

	private String modifiedBy;

	private Timestamp lastModDate;

	private String isHIVPos;

	private String placeOfWork;

	private String remarks;

	/**
	 * @return the beneficiaryRegID
	 */
	// public Long getBeneficiaryRegID()
	// {
	// return beneficiaryRegID;
	// }

	/**
	 * @param beneficiaryRegID
	 *            the beneficiaryRegID to set
	 */
	// public void setBeneficiaryRegID(Long beneficiaryRegID)
	// {
	// this.beneficiaryRegID = beneficiaryRegID;
	// }

	/**
	 * @return the i_bendemographics
	 */
	// public BenDemographics getI_bendemographics()
	// {
	// return i_bendemographics;
	// }

	/**
	 * @param i_bendemographics
	 *            the i_bendemographics to set
	 */
	// public void setI_bendemographics(BenDemographics i_bendemographics)
	// {
	// this.i_bendemographics = i_bendemographics;
	// }

	/**
	 * @return the t_benmedhistory
	 */
	// public List<BenMedHistory> getT_benmedhistory()
	// {
	// return t_benmedhistory;
	// }

	/**
	 * @param t_benmedhistory
	 *            the t_benmedhistory to set
	 */
	// public void setT_benmedhistory(List<BenMedHistory> t_benmedhistory)
	// {
	// this.t_benmedhistory = t_benmedhistory;
	// }

	/**
	 * @return the beneficiaryID
	 */
	// public String getBeneficiaryID()
	// {
	// return beneficiaryID;
	// }

	/**
	 * @param beneficiaryID
	 *            the beneficiaryID to set
	 */
	// public void setBeneficiaryID(String beneficiaryID)
	// {
	// this.beneficiaryID = beneficiaryID;
	// }

	/**
	 * @return the titleId
	 */
	// public Integer getTitleId()
	// {
	// return titleId;
	// }

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	// public void setTitleId(Integer titleId)
	// {
	// this.titleId = titleId;
	// }

	/**
	 * @return the m_title
	 */
	// public Title getM_title()
	// {
	// return m_title;
	// }

	/**
	 * @param m_title
	 *            the m_title to set
	 */
	// public void setM_title(Title m_title)
	// {
	// this.m_title = m_title;
	// }

	/**
	 * @return the firstName
	 */
	// public String getFirstName()
	// {
	// return firstName;
	// }

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	// public void setFirstName(String firstName)
	// {
	// this.firstName = firstName;
	// }

	/**
	 * @return the middleName
	 */
	// public String getMiddleName()
	// {
	// return middleName;
	// }

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	// public void setMiddleName(String middleName)
	// {
	// this.middleName = middleName;
	// }

	/**
	 * @return the lastName
	 */
	// public String getLastName()
	// {
	// return lastName;
	// }

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	// public void setLastName(String lastName)
	// {
	// this.lastName = lastName;
	// }

	/**
	 * @return the statusID
	 */
	// public Integer getStatusID()
	// {
	// return statusID;
	// }

	/**
	 * @param statusID
	 *            the statusID to set
	 */
	// public void setStatusID(Integer statusID)
	// {
	// this.statusID = statusID;
	// }

	/**
	 * @return the m_status
	 */
	// public Status getM_status()
	// {
	// return m_status;
	// }
	//
	// /**
	// * @param m_status
	// * the m_status to set
	// */
	// public void setM_status(Status m_status)
	// {
	// this.m_status = m_status;
	// }
	//
	// /**
	// * @return the genderID
	// */
	// public Integer getGenderID()
	// {
	// return genderID;
	// }
	//
	// /**
	// * @param genderID
	// * the genderID to set
	// */
	// public void setGenderID(Integer genderID)
	// {
	// this.genderID = genderID;
	// }
	//
	// /**
	// * @return the m_gender
	// */
	// public Gender getM_gender()
	// {
	// return m_gender;
	// }
	//
	// /**
	// * @param m_gender
	// * the m_gender to set
	// */
	// public void setM_gender(Gender m_gender)
	// {
	// this.m_gender = m_gender;
	// }
	//
	// /**
	// * @return the m_maritalstatus
	// */
	// public MaritalStatus getM_maritalstatus()
	// {
	// return m_maritalstatus;
	// }
	//
	// /**
	// * @param m_maritalstatus
	// * the m_maritalstatus to set
	// */
	// public void setM_maritalstatus(MaritalStatus m_maritalstatus)
	// {
	// this.m_maritalstatus = m_maritalstatus;
	// }
	//
	// /**
	// * @return the dOB
	// */
	// public Timestamp getdOB()
	// {
	// return dOB;
	// }
	//
	// /**
	// * @param dOB
	// * the dOB to set
	// */
	// public void setdOB(Timestamp dOB)
	// {
	// this.dOB = dOB;
	// }
	//
	// /**
	// * @return the fatherName
	// */
	// public String getFatherName()
	// {
	// return fatherName;
	// }
	//
	// /**
	// * @param fatherName
	// * the fatherName to set
	// */
	// public void setFatherName(String fatherName)
	// {
	// this.fatherName = fatherName;
	// }
	//
	// /**
	// * @return the spouseName
	// */
	// public String getSpouseName()
	// {
	// return spouseName;
	// }
	//
	// /**
	// * @param spouseName
	// * the spouseName to set
	// */
	// public void setSpouseName(String spouseName)
	// {
	// this.spouseName = spouseName;
	// }
	//
	// public String getRemarks()
	// {
	// return remarks;
	// }
	//
	// /**
	// * @return the phoneNo
	// */
	// // public String getPhoneNo() {
	// // return phoneNo;
	// // }
	//
	// /**
	// * @param phoneNo
	// * the phoneNo to set
	// */
	// // public void setPhoneNo(String phoneNo) {
	// // this.phoneNo = phoneNo;
	// // }
	//
	// /**
	// * @return the phoneTypeID
	// */
	// // public Short getPhoneTypeID() {
	// // return phoneTypeID;
	// // }
	//
	// /**
	// * @param phoneTypeID
	// * the phoneTypeID to set
	// */
	// // public void setPhoneTypeID(Short phoneTypeID) {
	// // this.phoneTypeID = phoneTypeID;
	// // }
	//
	// /**
	// * @return the altPhoneNo
	// */
	// // public String getAltPhoneNo() {
	// // return altPhoneNo;
	// // }
	//
	// /**
	// * @param altPhoneNo
	// * the altPhoneNo to set
	// */
	// // public void setAltPhoneNo(String altPhoneNo) {
	// // this.altPhoneNo = altPhoneNo;
	// // }
	//
	// /**
	// * @return the altPhoneTypeID
	// */
	// // public Short getAltPhoneTypeID() {
	// // return altPhoneTypeID;
	// // }
	//
	// /**
	// * @param altPhoneTypeID
	// * the altPhoneTypeID to set
	// */
	// // public void setAltPhoneTypeID(Short altPhoneTypeID) {
	// // this.altPhoneTypeID = altPhoneTypeID;
	// // }
	//
	// /**
	// * @return the parentBenRegID
	// */
	// // public Long getParentBenRegID() {
	// // return parentBenRegID;
	// // }
	//
	// /**
	// * @param parentBenRegID
	// * the parentBenRegID to set
	// */
	// // public void setParentBenRegID(Long parentBenRegID) {
	// // this.parentBenRegID = parentBenRegID;
	// // }
	//
	// /**
	// * @return the beneficiaryTypeID
	// */
	// // public Short getBeneficiaryTypeID() {
	// // return beneficiaryTypeID;
	// // }
	//
	// /**
	// * @param beneficiaryTypeID
	// * the beneficiaryTypeID to set
	// */
	// // public void setBeneficiaryTypeID(Short beneficiaryTypeID) {
	// // this.beneficiaryTypeID = beneficiaryTypeID;
	// // }
	//
	// /**
	// * @return the govtIdentityNo
	// */
	// public String getGovtIdentityNo()
	// {
	// return govtIdentityNo;
	// }
	//
	// /**
	// * @param govtIdentityNo
	// * the govtIdentityNo to set
	// */
	// public void setGovtIdentityNo(String govtIdentityNo)
	// {
	// this.govtIdentityNo = govtIdentityNo;
	// }
	//
	// /**
	// * @return the govtIdentityTypeID
	// */
	// public Integer getGovtIdentityTypeID()
	// {
	// return govtIdentityTypeID;
	// }
	//
	// /**
	// * @param govtIdentityTypeID
	// * the govtIdentityTypeID to set
	// */
	// public void setGovtIdentityTypeID(Integer govtIdentityTypeID)
	// {
	// this.govtIdentityTypeID = govtIdentityTypeID;
	// }
	//
	// /**
	// * @return the registeredServiceID
	// */
	// public Integer getRegisteredServiceID()
	// {
	// return registeredServiceID;
	// }
	//
	// /**
	// * @param registeredServiceID
	// * the registeredServiceID to set
	// */
	// public void setRegisteredServiceID(Integer registeredServiceID)
	// {
	// this.registeredServiceID = registeredServiceID;
	// }
	//
	// /**
	// * @return the deleted
	// */
	// public Boolean isDeleted()
	// {
	// return deleted;
	// }
	//
	// /**
	// * @param deleted
	// * the deleted to set
	// */
	// public void setDeleted(Boolean deleted)
	// {
	// this.deleted = deleted;
	// }
	//
	// /**
	// * @return the createdBy
	// */
	// public String getCreatedBy()
	// {
	// return createdBy;
	// }
	//
	// /**
	// * @param createdBy
	// * the createdBy to set
	// */
	// public void setCreatedBy(String createdBy)
	// {
	// this.createdBy = createdBy;
	// }
	//
	// /**
	// * @return the createdDate
	// */
	// public Timestamp getCreatedDate()
	// {
	// return createdDate;
	// }
	//
	// /**
	// * @param createdDate
	// * the createdDate to set
	// */
	// public void setCreatedDate(Timestamp createdDate)
	// {
	// this.createdDate = createdDate;
	// }
	//
	// /**
	// * @return the modifiedBy
	// */
	// public String getModifiedBy()
	// {
	// return modifiedBy;
	// }
	//
	// /**
	// * @param modifiedBy
	// * the modifiedBy to set
	// */
	// public void setModifiedBy(String modifiedBy)
	// {
	// this.modifiedBy = modifiedBy;
	// }
	//
	// /**
	// * @return the lastModDate
	// */
	// public Timestamp getLastModDate()
	// {
	// return lastModDate;
	// }
	//
	// /**
	// * @param lastModDate
	// * the lastModDate to set
	// */
	// public void setLastModDate(Timestamp lastModDate)
	// {
	// this.lastModDate = lastModDate;
	// }
	//
	// /**
	// * @return the sexualOrientation
	// */
	// public SexualOrientation getSexualOrientation()
	// {
	// return sexualOrientation;
	// }
	//
	// /**
	// * @param sexualOrientation
	// * the sexualOrientation to set
	// */
	// public void setSexualOrientation(SexualOrientation sexualOrientation)
	// {
	// this.sexualOrientation = sexualOrientation;
	// }
	//
	// /**
	// * @return the deleted
	// */
	// public Boolean getDeleted()
	// {
	// return deleted;
	// }

	public Beneficiary(Long BeneficiaryRegID, String BeneficiaryID, String FirstName, String MiddleName,
			String LastName, Integer GenderID, String GenderName, Timestamp DOB)
	{
		this.beneficiaryRegID = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.firstName = FirstName;
		this.middleName = MiddleName;
		this.lastName = LastName;
		this.m_gender = new Gender().getGender(GenderID, GenderName);
		this.dOB = DOB;
		this.age = Integer
				.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - DOB.getTime())))
				- START_YEAR_1970;
	}

	public Beneficiary(Long BeneficiaryRegID, String BeneficiaryID, String FirstName, String MiddleName,
			String LastName, Integer GenderID, String GenderName, Timestamp DOB, BenDemographics demographics)
	{
		this.beneficiaryRegID = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.firstName = FirstName;
		this.middleName = MiddleName;
		this.lastName = LastName;
		this.m_gender = new Gender().getGender(GenderID, GenderName);
		this.dOB = DOB;
		if (DOB != null)
		{
			this.age = Integer
					.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - DOB.getTime())))
					- START_YEAR_1970;
		}
		this.i_bendemographics = demographics;
	}

	public Beneficiary(Long BeneficiaryRegID, String BeneficiaryID, String FirstName, String MiddleName,
			String LastName, Integer GenderID, String GenderName, Timestamp DOB, BenDemographics demographics,
			List<BenPhoneMap> phoneMap)
	{
		this.beneficiaryRegID = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.firstName = FirstName;
		this.middleName = MiddleName;
		this.lastName = LastName;
		this.m_gender = new Gender().getGender(GenderID, GenderName);
		this.dOB = DOB;
		if (DOB != null)
		{
			this.age = Integer
					.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - DOB.getTime())))
					- START_YEAR_1970;
		}
		this.i_bendemographics = demographics;
		this.benPhoneMaps = phoneMap;
	}

	public Beneficiary(Long BeneficiaryRegID, String BeneficiaryID, String FirstName, String MiddleName,
			String LastName, Gender m_gender, Timestamp DOB)
	{
		this.beneficiaryRegID = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.firstName = FirstName;
		this.middleName = MiddleName;
		this.lastName = LastName;
		this.m_gender = InputMapper.gson().fromJson(m_gender.toString(), Gender.class);
		this.genderID = m_gender.getGenderID();
		this.dOB = DOB;

		if (DOB != null)
		{
			this.age = Integer
					.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - DOB.getTime())))
					- START_YEAR_1970;
		}
	}

	public Beneficiary(Long BeneficiaryRegID, String BeneficiaryID, String FirstName, String MiddleName,
			String LastName, Gender m_gender, Timestamp DOB,
			/* BenDemographics i_bendemographics, */Title m_title, Status m_status,
			MaritalStatus m_maritalstatus, SexualOrientation sexualOrientation, String fatherName, String spouseName,
			/*
			 * String phoneNo, Short phoneTypeID, String altPhoneNo, Short altPhoneTypeID, Long parentBenRegID, Short
			 * beneficiaryTypeID,
			 */
			List<BenPhoneMap> benphonemaps, String govtIdentityNo, Integer govtIdentityTypeID,
			Integer registeredServiceID, Boolean deleted, Integer titleId, Integer statusID, Integer genderID,
			Integer maritalStatusID, Integer sexualOrientationId, String isHIVPos, String placeOfWork, String remarks,
			String sourceOfInformation)
	{
		this.beneficiaryRegID = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.firstName = FirstName;
		this.middleName = MiddleName;
		this.lastName = LastName;
		this.m_gender = m_gender;
		// new Gson().fromJson(m_gender.toString(), Gender.class);
		// this.genderID = m_gender.getGenderID();
		this.dOB = DOB;

		if (DOB != null)
		{
			this.age = Integer
					.parseInt(formatYear.format(new Date(Calendar.getInstance().getTime().getTime() - DOB.getTime())))
					- START_YEAR_1970;
		}
		// this.i_bendemographics = i_bendemographics;
		// new Gson().fromJson(i_bendemographics.toString(),
		// BenDemographics.class);
		this.m_title = m_title;
		// new Gson().fromJson(m_title.toString(), Title.class);
		this.m_status = m_status;
		// new Gson().fromJson(m_status.toString(),Status.class);
		this.m_maritalstatus = m_maritalstatus;
		// new Gson().fromJson(m_maritalstatus.toString(),
		// MaritalStatus.class);
		this.sexualOrientation = sexualOrientation;
		// new Gson().fromJson(sexualOrientation.toString(),
		// SexualOrientation.class);
		this.fatherName = fatherName;
		this.spouseName = spouseName;
		this.benPhoneMaps = benphonemaps;
		// this.phoneNo = phoneNo;
		// this.phoneTypeID = phoneTypeID;
		// this.altPhoneNo = altPhoneNo;
		// this.altPhoneTypeID = altPhoneTypeID;
		// this.parentBenRegID = parentBenRegID;
		// this.beneficiaryTypeID = beneficiaryTypeID;
		this.govtIdentityNo = govtIdentityNo;
		this.govtIdentityTypeID = govtIdentityTypeID;
		this.registeredServiceID = registeredServiceID;
		this.deleted = deleted;
		this.titleId = titleId;
		this.statusID = statusID;
		this.genderID = genderID;
		this.maritalStatusID = maritalStatusID;
		this.sexualOrientationId = sexualOrientationId;
		this.isHIVPos = isHIVPos;
		this.placeOfWork = placeOfWork;
		this.remarks = remarks;
		this.sourceOfInformation = sourceOfInformation;
	}

	public Beneficiary()
	{

	}

	/**
	 * @return the benPhoneMaps
	 */
	// public List<BenPhoneMap> getBenPhoneMaps()
	// {
	// return benPhoneMaps;
	// }
	//
	// public void setBenPhoneMaps(List<BenPhoneMap> maps)
	// {
	// this.benPhoneMaps = maps;
	// }
	//
	// /**
	// * @return the parentBenPhoneMaps
	// */
	// public List<BenPhoneMap> getParentBenPhoneMaps()
	// {
	// return parentBenPhoneMaps;
	// }
	//
	// public String getIsHIVPos()
	// {
	// return isHIVPos;
	// }
	//
	// public String getPlaceOfWork()
	// {
	// return this.placeOfWork;
	// }
	//
	// public String getSourceOfInformation()
	// {
	// return sourceOfInformation;
	// }

	// @Override
	// public String toString()
	// {
	// return this.toString();
	// }

}
