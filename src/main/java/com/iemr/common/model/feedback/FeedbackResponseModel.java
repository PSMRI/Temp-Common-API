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
package com.iemr.common.model.feedback;

import java.sql.Timestamp;

import com.iemr.common.model.user.KMFileManagerModel;

import lombok.Data;

public @Data class FeedbackResponseModel
{
	private Long feedbackResponseID;
	private Long feedbackRequestID;
	private String responseSummary;
	private Integer authUserID;
	private String comments;
	private Long feedbackID;
	private String authName;
	private String authDesignation;
	// private FeedbackRequestModel feedbackRequestModel;
	// private FeedbackDetailsModel feedbackDetailsModel;
	private Integer feedbackStatusID;
	private Integer emailStatusID;
	private Integer kmFileManagerID;
	private KMFileManagerModel kmFileManager;
	private String attachmentPath;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Boolean beneficiaryConsent;
}
