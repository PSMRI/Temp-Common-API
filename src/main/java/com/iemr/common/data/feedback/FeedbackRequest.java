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
package com.iemr.common.data.feedback;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.users.EmailStatus;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_feedbackrequest")
@Data
public class FeedbackRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackRequestID")
	@Expose
	private Long feedbackRequestID;
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackID", insertable = false, updatable = false)
	@Expose
	// @Transient
	private FeedbackDetails feedbackDetails;
	@Column(name = "FeedbackSupSummary")
	@Expose
	private String feedbackSupSummary;
	@Column(name = "SupUserID")
	@Expose
	private Integer supUserID;
	@Column(name = "Comments")
	@Expose
	private String comments;
	@Column(name = "EmailStatusID")
	@Expose
	private Integer emailStatusID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmailStatusID", insertable = false, updatable = false)
	@Expose
	// @Transient
	private EmailStatus emailStatus;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	@Expose
	private Integer feedbackStatusID;

	@Transient
	@Expose
	private String responseSummary;
	@Transient
	@Expose
	private String responseComments;
	@Transient
	@Expose
	private String responseUpdatedBy;
	@Transient
	@Expose
	private Timestamp responseDate;
	@Transient
	@Expose
	private KMFileManager kmFileManager;

	@Transient
	@Expose
	private String attachmentPath;

	/**
	 * @return the feedbackRequestID
	 */
	public Long getFeedbackRequestID() {
		return feedbackRequestID;
	}

	/**
	 * @return the feedbackID
	 */
	public Long getFeedbackID() {
		return feedbackID;
	}

	/**
	 * @return the feedbackSupSummary
	 */
	public String getFeedbackSupSummary() {
		return feedbackSupSummary;
	}

	/**
	 * @return the supUserID
	 */
	public Integer getSupUserID() {
		return supUserID;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Timestamp getLastModDate() {
		return lastModDate;
	}

	/**
	 * @return the emailStatusID
	 */
	public Integer getEmailStatusID() {
		return emailStatusID;
	}

	public FeedbackRequest() {
	}

	public Integer getFeedbackStatusID() {
		return feedbackStatusID;
	}

	public FeedbackRequest(Long feedbackRequestID, Long feedbackID, String feedbackSupSummary, Integer supUserID,
			String comments, Integer emailStatusID, EmailStatus emailStatus) {
		this.feedbackRequestID = feedbackRequestID;
		this.feedbackID = feedbackID;
		this.feedbackSupSummary = feedbackSupSummary;
		this.supUserID = supUserID;
		this.comments = comments;
		this.emailStatusID = emailStatusID;
		this.emailStatus = emailStatus;
	}

	public FeedbackRequest(Long feedbackRequestID, Long feedbackID, String feedbackSupSummary, Integer supUserID,
			String comments, Integer emailStatusID, EmailStatus emailStatus, Timestamp createdDate, String createdBy) {
		this.feedbackRequestID = feedbackRequestID;
		this.feedbackID = feedbackID;
		this.feedbackSupSummary = feedbackSupSummary;
		this.supUserID = supUserID;
		this.comments = comments;
		this.emailStatusID = emailStatusID;
		this.emailStatus = emailStatus;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void updateResponses(String response, String respnseComments, Timestamp responseDate,
			String responseUpdatedBy, KMFileManager kmFileManager, String attachmentPath) {
		this.responseSummary = response;
		this.responseComments = respnseComments;
		this.responseDate = responseDate;
		this.responseUpdatedBy = responseUpdatedBy;
		this.kmFileManager = kmFileManager;
		this.attachmentPath = attachmentPath;
	}

	public String getResponseUpdatedBy() {
		return responseUpdatedBy;
	}
}
