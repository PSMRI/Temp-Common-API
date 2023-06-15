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
package com.iemr.common.model.beneficiary;

import java.sql.Timestamp;

import com.iemr.common.data.callhandling.CallType;

import lombok.Data;

public @Data class BeneficiaryCallModel
{
	private Long benCallID;
	// private OutboundCallRequestModel outboundCallRequest;
	private Long beneficiaryRegID;
	private BeneficiaryModel i_beneficiary;
	private String callID;
	private Integer calledServiceID;
	private Boolean is1097;
	private Timestamp callTime;
	private String remarks;
	private String servicesProvided;
	private Integer callTypeID;
	private CallType callTypeObj;
	private String callClosureType;
	private Integer dispositionStatusID;
	private Integer callReceivedUserID;
	private Integer callEndUserID;
	private String category;
	private String subCategory;
	private String cDICallStatus;
	private String agentID;
	private Boolean isOutbound;
	private Boolean isCalledEarlier = false;
	private Long informationServices;
	private Long feedbackServices;
	private Long referralServices;
	private Long counsellingServices;
	private Timestamp filterStartDate;
	private Timestamp filterEndDate;
	private Boolean fitToBlock = false;
	private String phoneNo;
	private String receivedRoleName;
	private Boolean endCall = false;
	private String agentIPAddress;
	private Long maxCount = 0l;
	private String recordingPath;
	private String archivePath;
	private Short emergencyType;
	private Integer count;

	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;

}
