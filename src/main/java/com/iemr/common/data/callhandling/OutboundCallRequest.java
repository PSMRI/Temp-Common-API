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
package com.iemr.common.data.callhandling;

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
import com.iemr.common.data.service.SubService;
import com.iemr.common.data.users.User;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_outboundcallrequest")
@Data
public class OutboundCallRequest
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OutboundCallReqID")
	@Expose
	private Long outboundCallReqID;
	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Transient
	@Expose
	// private Beneficiary beneficiary;
	private BeneficiaryModel beneficiary;

	@Column(name = "AssignedUserID")
	@Expose
	private Integer assignedUserID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "UserID", insertable = false, updatable = false, name = "AssignedUserID")
	// @Transient
	@Expose
	private User user;

	@Column(name = "CallTypeID")
	@Expose
	private Integer callTypeID;
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	@Column(name = "PrefferedDateTime")
	@Expose
	private Timestamp prefferedDateTime;
	@Column(name = "RequestedFor")
	@Expose
	private String requestedFor;
	@Column(name = "RequestedFeature")
	@Expose
	private String requestedFeature;
	@Column(name = "IsCompleted", insertable = false, updatable = true)
	@Expose
	private Boolean isCompleted;

	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;
	// @JoinColumn(insertable = false, updatable = false, name = "BenCallID")
	// @OneToOne
	// @Expose
	// private BeneficiaryCall beneficiaryCall;

	@Column(name = "SubServiceID")
	@Expose
	private Integer requestedServiceID;
	@JoinColumn(name = "SubServiceID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	@Expose
	private SubService requestedService;

	@Column(name = "RequestNo")
	@Expose
	private String requestNo;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private Boolean modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;

	@Expose
	@Column(name = "NoOfTrials")
	private Integer noOfTrials;

	@Transient
	@Expose
	private String receivedRoleName;

	// @Transient
	@Expose
	@Column(name = "PrefferedLanguage")
	private String preferredLanguageName;

	@Transient
	@Expose
	private Timestamp filterStartDate;

	@Transient
	@Expose
	private Timestamp filterEndDate;

	@Transient
	private List<Long> outboundCallReqIDs;

	@Transient
	private Boolean is1097 = false;

	@Column(name = "IsSelf")
	@Expose
	private Boolean isSelf;

	public OutboundCallRequest getOutboundCall(Long outboundCallReqID, BeneficiaryModel beneficiary,
			Timestamp prefferedDateTime, Integer providerServiceMapID, String requestedFor, User user,
			Integer requestedServiceID, SubService requestedService, String requestNo, String preferredLanguage,
			String requestedFeature, Integer noOfTrials, Boolean isSelf, Timestamp lastModDate)
	{
		this.outboundCallReqID = outboundCallReqID;
		this.beneficiary = beneficiary;
		this.prefferedDateTime = prefferedDateTime;
		this.providerServiceMapID = providerServiceMapID;
		this.requestedFor = requestedFor;
		this.user = user;
		this.requestedServiceID = requestedServiceID;
		this.requestedService = requestedService;
		this.requestNo = requestNo;
		this.preferredLanguageName = preferredLanguage;
		this.requestedFeature = requestedFeature;
		this.noOfTrials = noOfTrials;
		this.isSelf = isSelf;
		this.lastModDate = lastModDate;
		return this;

	}

	public OutboundCallRequest getOutboundCall(Long outboundCallReqID, Long userID)
	{
		this.outboundCallReqID = outboundCallReqID;
		this.user.setUserID(userID);
		return this;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public Integer getAssignedUserID()
	{
		return assignedUserID;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	/**
	 * @param user
	 *            the user to set to set user for call allocation -- wasim
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * @return the outboundCallReqID * to set user for call allocation -- wasim
	 */
	public Long getOutboundCallReqID()
	{
		return outboundCallReqID;
	}

	public Boolean getIsCompleted()
	{
		return isCompleted;
	}

	public String getRequestedFor()
	{
		return requestedFor;
	}

	public Integer getRequestedServiceID()
	{
		return requestedServiceID;
	}

	public String getPreferredLanguageName()
	{
		return preferredLanguageName;
	}

	public Timestamp getStartDate()
	{
		return filterStartDate;
	}

	public Timestamp getEndDate()
	{
		return filterEndDate;
	}

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public static OutboundCallRequest initializeOutboundCallListByCallID(Long outboundCallReqID,
			Timestamp prefferedDateTime, Integer providerServiceMapID, String requestedFor, Integer requestedServiceID,
			SubService requestedService, String requestNo, String receivedRoleName, String preferredLanguage,
			Integer noOfTrials, Boolean isSelf, Timestamp lastModDate)
	{
		OutboundCallRequest request = new OutboundCallRequest();
		request.outboundCallReqID = outboundCallReqID;
		request.prefferedDateTime = prefferedDateTime;
		request.providerServiceMapID = providerServiceMapID;
		request.requestedFor = requestedFor;
		request.requestedServiceID = requestedServiceID;
		request.requestedService = requestedService;
		request.requestNo = requestNo;
		request.receivedRoleName = receivedRoleName;
		request.preferredLanguageName = preferredLanguage;
		request.noOfTrials = noOfTrials;
		request.isSelf = isSelf;
		request.lastModDate = lastModDate;
		return request;
	}

	public List<Long> getOutboundCallReqIDs()
	{
		return outboundCallReqIDs;
	}
}
