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
package com.iemr.common.data.users;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class LoginReqResp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "UserID")
	private Long userID;
	@OneToMany(mappedBy = "m_user", fetch = FetchType.LAZY)
	@Expose
	@Transient
	private List<UserServiceRoleMapping> m_UserServiceRoleMapping;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Transient
	@Expose
	private Set<OutboundCallRequest> outboundCallRequests;

	@Expose
	@OneToMany(mappedBy = "m_user", fetch = FetchType.LAZY)
	private Set<UserLangMapping> m_UserLangMappings;

	@OneToMany(mappedBy = "mUser", fetch = FetchType.LAZY)
	@Transient
	@Expose
	private Set<FeedbackDetails> feedbackDetails;

	@Expose
	@Column(name = "TitleID")
	private Integer titleID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TitleID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private Title m_title;
	@Expose
	@Column(name = "FirstName")
	private String firstName;
	@Expose
	@Column(name = "MiddleName")
	private String middleName;
	@Expose
	@Column(name = "LastName")
	private String lastName;

	@Expose
	@Column(name = "GenderID")
	private Integer genderID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GenderID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private Gender m_gender;

	@Expose
	@Column(name = "MaritalStatusID")
	private Integer maritalStatusID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maritalStatusID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private MaritalStatus m_maritalstatus;

	@Expose
	@Column(name = "StatusID")
	private Integer statusID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StatusID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private Status m_status;

	@Expose
	@Column(name = "AadhaarNo")
	private String aadhaarNo;
	@Expose
	@Column(name = "PAN")
	private String pAN;
	@Expose
	@Column(name = "DOB")
	private Timestamp dOB;
	@Expose
	@Column(name = "DOJ")
	private Timestamp dOJ;
	@Expose
	@Column(name = "QualificationID")
	private Integer qualificationID;
	@Expose
	@Column(name = "userName")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Expose
	@Column(name = "EmailID")
	private String emailID;

	@Expose
	@Column(name = "EmergencyContactPerson")
	private String emergencyContactPerson;
	@Expose
	@Column(name = "EmergencyContactNo")
	private String emergencyContactNo;
	@Expose
	@Column(name = "IsSupervisor")
	private Boolean isSupervisor;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@Expose
	@Column(name = "AgentID")
	private String agentID;

	@Expose
	@Column(name = "DesignationID")
	private Integer designationID;
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	private Designation designation;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Expose
	private String hostName;

	@Expose
	private String ipAddress;

	@Expose
	private String loginKey;

	protected LoginReqResp() {
	}

	@Expose
	@Column(name = "AgentPassword")
	private String agentPassword;

	// public LoginReqResp(Long userID, Integer titleID, String firstName,
	// String middleName, String lastName,
	// Integer genderID, Integer maritalStatusID, String aadhaarNo, String pAN,
	// Timestamp dOB, Timestamp dOJ,
	// Integer qualificationID, String userName, String password, String
	// emailID, Status m_Status,
	// List<UserServiceRoleMapping> m_UserServiceRoleMapping, String
	// emergencyContactPerson,
	// String emergencyContactNo, Boolean isSupervisor, Boolean deleted, String
	// createdBy, Timestamp createdDate,
	// String modifiedBy, Timestamp lastModDate, String newPassword) {
	// this.userID = userID;
	// this.titleID = titleID;
	// this.firstName = firstName;
	// this.middleName = middleName;
	// this.lastName = lastName;
	// this.genderID = genderID;
	// this.maritalStatusID = maritalStatusID;
	// this.aadhaarNo = aadhaarNo;
	// this.pAN = pAN;
	// this.dOB = dOB;
	// this.dOJ = dOJ;
	// this.qualificationID = qualificationID;
	// this.userName = userName;
	// this.password = password;
	// this.emailID = emailID;
	// this.m_UserServiceRoleMapping = m_UserServiceRoleMapping;
	// this.emergencyContactPerson = emergencyContactPerson;
	// this.emergencyContactNo = emergencyContactNo;
	// this.isSupervisor = isSupervisor;
	// this.deleted = deleted;
	// this.createdBy = createdBy;
	// this.createdDate = createdDate;
	// this.modifiedBy = modifiedBy;
	// this.lastModDate = lastModDate;
	// }

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}
}
