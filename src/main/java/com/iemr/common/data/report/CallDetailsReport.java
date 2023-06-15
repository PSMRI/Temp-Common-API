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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_1097callsummary", schema = "db_reporting")

public class CallDetailsReport implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Fact_1097CallSummaryID", insertable = false, updatable = false)
	private Long callSummaryID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "beneficiaryRegID", insertable = false, updatable = false,
			referencedColumnName = "beneficiaryRegID")
	private BeneficiaryDetailsReport benReport;
	@Expose
	@Column(name = "FeedbackID")
	private Long feedbackID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "feedbackID", insertable = false, updatable = false, referencedColumnName = "feedbackID")
	private FeedbackReport feedback;
	@Column(name = "LodadedDate")
	private Timestamp loadDate;
	@Expose
	@Column(name = "UserID")
	private Integer userID;
	@Expose
	@Column(name = "CallStartTime")
	private Timestamp callStartTime;
	@Expose
	@Column(name = "CallEndTime")
	private Timestamp callEndTime;
	@Expose
	@Column(name = "Info_Category")
	private String categoryName;
	@Expose
	@Column(name = "Info_SubCategory")
	private String subCategoryName;
	@Expose
	@Column(name = "Info_DocumentName")
	private String documentName;
	@Expose
	@Column(name = "CO_Category")
	private String counselingCategoryName;
	@Expose
	@Column(name = "CO_SubCategory")
	private String counselingSubCategoryName;
	@Expose
	@Column(name = "CO_DocumentName")
	private String counsellingDocumentName;
	@Expose
	@Column(name = "AgentID")
	private String agentID;
	@Expose
	@Column(name = "CZCallID")
	private String callID;
	@Expose
	@Column(name = "Rec_UserName")
	private String username;
	@Expose
	@Column(name = "BenOutboundPreferedLang")
	private String outboundRequestedLanguage;
	@Expose
	@Column(name = "CallTransferRemarks")
	private String callTransferRemarks;
	@Expose
	@Column(name = "CallType")
	private String callType;
	
	@Column(name = "CallSubType")
	private String callSubType;
	@Expose
	@Column(name = "Rec_UserRole")
	private String userRole;
	@Expose
	@Column(name = "LoadedBy")
	private String loadedBy;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Transient
	private Timestamp startTimestamp;
	@Transient
	private Timestamp endTimestamp;
	
	@Transient
	private Timestamp startDateTime;
	@Transient
	private Timestamp endDateTime;
	
	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Transient
	private String beneficiaryCallType;
	
	@Transient
	private String beneficiaryCallSubType;
	
	@Transient
	private Integer minAge = 0;
	@Transient
	private Integer maxAge = 150;
	@Transient
	private Timestamp maxDOB;
	@Transient
	private Timestamp minDOB;

	@Expose
	@Column(name = "IsCalledEarlier")
	private Boolean isCalledEarlier;

	@Expose
	@Column(name = "PhoneNo")
	private String phoneNo;

	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Expose
	@Column(name = "IsOutbound")
	private Boolean isOutbound;

	public static Timestamp getDOB(Integer minAge)
	{
		Calendar cal = Calendar.getInstance();
		Integer currYear = cal.get(Calendar.YEAR);
		cal.set(Calendar.YEAR, currYear - minAge);
		Timestamp timeStamp = new Timestamp(cal.getTime().getTime());
		return timeStamp;
	}

	public CallDetailsReport()
	{
		benReport = new BeneficiaryDetailsReport();
	}

	public String checkOutbound()
	{
		String callMode = "Outbound";
		if (isOutbound != null)
		{
			callMode = isOutbound ? "Outbound" : "Inbound";
		}
		return callMode;
	}

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}

	public Long getCallSummaryID() {
		return callSummaryID;
	}

	public void setCallSummaryID(Long callSummaryID) {
		this.callSummaryID = callSummaryID;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public BeneficiaryDetailsReport getBenReport() {
		return benReport;
	}

	public void setBenReport(BeneficiaryDetailsReport benReport) {
		this.benReport = benReport;
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public FeedbackReport getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedbackReport feedback) {
		this.feedback = feedback;
	}

	public Timestamp getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Timestamp loadDate) {
		this.loadDate = loadDate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Timestamp getCallStartTime() {
		return callStartTime;
	}

	public void setCallStartTime(Timestamp callStartTime) {
		this.callStartTime = callStartTime;
	}

	public Timestamp getCallEndTime() {
		return callEndTime;
	}

	public void setCallEndTime(Timestamp callEndTime) {
		this.callEndTime = callEndTime;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getCounselingCategoryName() {
		return counselingCategoryName;
	}

	public void setCounselingCategoryName(String counselingCategoryName) {
		this.counselingCategoryName = counselingCategoryName;
	}

	public String getCounselingSubCategoryName() {
		return counselingSubCategoryName;
	}

	public void setCounselingSubCategoryName(String counselingSubCategoryName) {
		this.counselingSubCategoryName = counselingSubCategoryName;
	}

	public String getCounsellingDocumentName() {
		return counsellingDocumentName;
	}

	public void setCounsellingDocumentName(String counsellingDocumentName) {
		this.counsellingDocumentName = counsellingDocumentName;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public String getCallID() {
		return callID;
	}

	public void setCallID(String callID) {
		this.callID = callID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOutboundRequestedLanguage() {
		return outboundRequestedLanguage;
	}

	public void setOutboundRequestedLanguage(String outboundRequestedLanguage) {
		this.outboundRequestedLanguage = outboundRequestedLanguage;
	}

	public String getCallTransferRemarks() {
		return callTransferRemarks;
	}

	public void setCallTransferRemarks(String callTransferRemarks) {
		this.callTransferRemarks = callTransferRemarks;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallSubType() {
		return callSubType;
	}

	public void setCallSubType(String callSubType) {
		this.callSubType = callSubType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getLoadedBy() {
		return loadedBy;
	}

	public void setLoadedBy(String loadedBy) {
		this.loadedBy = loadedBy;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Timestamp getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Timestamp getMaxDOB() {
		return maxDOB;
	}

	public void setMaxDOB(Timestamp maxDOB) {
		this.maxDOB = maxDOB;
	}

	public Timestamp getMinDOB() {
		return minDOB;
	}

	public void setMinDOB(Timestamp minDOB) {
		this.minDOB = minDOB;
	}

	public Boolean getIsCalledEarlier() {
		return isCalledEarlier;
	}

	public void setIsCalledEarlier(Boolean isCalledEarlier) {
		this.isCalledEarlier = isCalledEarlier;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getIsOutbound() {
		return isOutbound;
	}

	public void setIsOutbound(Boolean isOutbound) {
		this.isOutbound = isOutbound;
	}

	public String getBeneficiaryCallType() {
		return beneficiaryCallType;
	}

	public void setBeneficiaryCallType(String beneficiaryCallType) {
		this.beneficiaryCallType = beneficiaryCallType;
	}

	public String getBeneficiaryCallSubType() {
		return beneficiaryCallSubType;
	}

	public void setBeneficiaryCallSubType(String beneficiaryCallSubType) {
		this.beneficiaryCallSubType = beneficiaryCallSubType;
	}
	
	
	
	
}
