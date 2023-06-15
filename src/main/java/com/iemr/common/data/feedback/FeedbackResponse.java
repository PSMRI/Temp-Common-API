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
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_feedbackresponse")
@Data
public class FeedbackResponse
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackResponseID")
	@Expose
	private Long feedbackResponseID;
	@Column(name = "FeedbackRequestID")
	@Expose
	private Long feedbackRequestID;
	@Column(name = "ResponseSummary")
	@Expose
	private String responseSummary;
	@Column(name = "AuthUserID")
	@Expose
	private Integer authUserID;
	@Column(name = "Comments")
	@Expose
	private String comments;
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
	@Expose
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	@Column(name = "AuthName")
	@Expose
	private String authName;
	@Column(name = "AuthDesignation")
	@Expose
	private String authDesignation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackRequestID", insertable = false, updatable = false)
	@Expose
	private FeedbackRequest feedbackRequest;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackID", insertable = false, updatable = false)
	@Expose
	private FeedbackDetails feedbackDetails;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Transient
	@Expose
	private Integer feedbackStatusID;

	@Transient
	@Expose
	private Integer emailStatusID;

	@Column(name = "KmFileManagerID")
	@Expose
	private Integer kmFileManagerID;
	@JoinColumn(name = "KmFileManagerID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	@Expose
	private KMFileManager kmFileManager;

	@Expose
	@Transient
	private String attachmentPath;

	public Long getFeedbackID()
	{
		return feedbackID;
	}

	public Long getFeedbackResponseID()
	{
		return feedbackResponseID;
	}

	public Long getFeedbackRequestID()
	{
		return feedbackRequestID;
	}

	public Integer getEmailStatusID()
	{
		return emailStatusID;
	}

	public Integer getFeedbackStatusID()
	{
		return feedbackStatusID;
	}

	public String getComments()
	{
		return comments;
	}

	public String getResponseSummary()
	{
		return responseSummary;
	}

	public Integer getAuthUserID()
	{
		return authUserID;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public static FeedbackResponse initializeFeedbackResponse(String responseSummary, Long feedbackRequestID,
			String comments, String authName, String authDesignation, Long feedbackID, Long feedbackResponseID,
			Timestamp createdDate, String createdBy, Integer kmFileManagerID, KMFileManager kmFileManager)
	{
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		feedbackResponse.authName = authName;
		feedbackResponse.responseSummary = responseSummary;
		feedbackResponse.feedbackRequestID = feedbackRequestID;
		feedbackResponse.comments = comments;
		feedbackResponse.authDesignation = authDesignation;
		feedbackResponse.feedbackID = feedbackID;
		feedbackResponse.feedbackResponseID = feedbackResponseID;
		feedbackResponse.createdBy = createdBy;
		feedbackResponse.createdDate = createdDate;
		feedbackResponse.kmFileManagerID = kmFileManagerID;
		// if (kmFileManager != null)
		// {
		// kmFileManager.setFileUID(feedbackResponse.getFilePath(kmFileManager));
		// }
		feedbackResponse.kmFileManager = kmFileManager;
		return feedbackResponse;
	}
	
	public Timestamp getCreatedDate()
	{
		return this.createdDate;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public KMFileManager getKmFileManager()
	{
		return kmFileManager;
	}

	public void setKmFileManager(KMFileManager kmFileManager)
	{
		this.kmFileManager = kmFileManager;
	}

	public Integer getKmFileManagerID()
	{
		return kmFileManagerID;
	}

	public void setKmFileManagerID(Integer kmFileManagerID)
	{
		this.kmFileManagerID = kmFileManagerID;
	}

	public String getAttachmentPath()
	{
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath)
	{
		this.attachmentPath = attachmentPath;
	}
}
