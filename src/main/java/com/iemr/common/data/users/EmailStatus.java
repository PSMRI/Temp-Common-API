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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_EmailStatus")
@Data
public class EmailStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmailStatusID")
	@Expose
	private Integer emailStatusID;
	@Column(name = "EmailStatus")
	@Expose
	private String emailStatus;
	@Column(name = "EmailStatusDesc")
	@Expose
	private String emailStatusDesc;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@OneToMany(mappedBy = "emailStatus", fetch = FetchType.LAZY)
	@Transient
	private List<FeedbackDetails> feedbackDetails;
	@OneToMany(mappedBy = "emailStatus", fetch = FetchType.LAZY)
	@Transient
	private List<FeedbackRequest> feedbackRequests;

//	public EmailStatus() {
//	}

	public int getEmailStatusID() {
		return emailStatusID;
	}

	public void setEmailStatusID(int emailStatusID) {
		this.emailStatusID = emailStatusID;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getEmailStatusDesc() {
		return emailStatusDesc;
	}

	public void setEmailStatusDesc(String emailStatusDesc) {
		this.emailStatusDesc = emailStatusDesc;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public List<FeedbackDetails> getFeedback() {
		return feedbackDetails;
	}

	public void setFeedback(List<FeedbackDetails> feedback) {
		feedbackDetails = feedback;
	}

	public EmailStatus getEmailStatus(Integer emailStatusID, String emailStatus, String emailStatusDesc) {
		this.emailStatusID = emailStatusID;
		this.emailStatus = emailStatus;
		this.emailStatusDesc = emailStatusDesc;
		return this;
	}

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
