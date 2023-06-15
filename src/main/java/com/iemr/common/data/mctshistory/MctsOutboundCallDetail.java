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
package com.iemr.common.data.mctshistory;

import java.sql.Date;
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

import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_bencall")
public class MctsOutboundCallDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "BenCallID") // CallDetailID
	private Long callDetailID;

	@Expose
	@Column(name = "OBCallID", insertable = false, updatable = false) 
	private Long obCallID;

	@Expose
	@Column(name = "CallReceivedUserID", insertable = false, updatable = false)  //AllocatedUserID
	private Integer allocatedUserID;
	
	@Expose
	@Column(name = "ReceivedAgentID")
	private String agentID;
	
	@Expose
	@Column(name = "PhoneNo")
	private String phoneNo;

	@Expose
	@Column(name = "CalledServiceID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "CallTypeID")
	private Integer callTypeID;

	@Expose
	@Column(name = "Remarks")
	private String remark;

	@Expose
	@Column(name = "SMS_Advice")
	private String smsAdvice;

	@Expose
	@Column(name = "CallTime")
	private Timestamp callTime;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Expose
	@Column(name = "ChangeLog")
	private String changeLog;
	
	@Column(name = "IsMother")
	private Boolean isMother;
	
	/**
	 * 
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "callTypeID", insertable = false, updatable = false)
	@Expose
	private CallType callType;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "obCallID", insertable = false, updatable = false)
	@Expose
	private MctsOutboundCall mctsOutboundCall;

	private static OutputMapper outputMapper = new OutputMapper();

	/**
	 * Default Constructor
	 */
	public MctsOutboundCallDetail() {

	}

	/**
	 * @return the obCallID
	 */
	public Long getObCallID() {
		return obCallID;
	}

	/**
	 * @param obCallID
	 *            the obCallID to set
	 */
	public void setObCallID(Long obCallID) {
		this.obCallID = obCallID;
	}

	/**
	 * @return the callDetailID
	 */
	public Long getCallDetailID() {
		return callDetailID;
	}

	/**
	 * @param callDetailID
	 *            the callDetailID to set
	 */
	public void setCallDetailID(Long callDetailID) {
		this.callDetailID = callDetailID;
	}

	/**
	 * @return the allocatedUserID
	 */
	public Integer getAllocatedUserID() {
		return allocatedUserID;
	}

	/**
	 * @param allocatedUserID
	 *            the allocatedUserID to set
	 */
	public void setAllocatedUserID(Integer allocatedUserID) {
		this.allocatedUserID = allocatedUserID;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the providerServiceMapID
	 */
	public Long getProviderServiceMapID() {
		return providerServiceMapID;
	}

	/**
	 * @param providerServiceMapID
	 *            the providerServiceMapID to set
	 */
	public void setProviderServiceMapID(Long providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	/**
	 * @return the smsAdvice
	 */
	public String getSmsAdvice() {
		return smsAdvice;
	}

	/**
	 * @param smsAdvice
	 *            the smsAdvice to set
	 */
	public void setSmsAdvice(String smsAdvice) {
		this.smsAdvice = smsAdvice;
	}

	
	/**
	 * @return the callTypeID
	 */
	public Integer getCallTypeID() {
		return callTypeID;
	}

	/**
	 * @param callTypeID the callTypeID to set
	 */
	public void setCallTypeID(Integer callTypeID) {
		this.callTypeID = callTypeID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return outputMapper.gson().toJson(this);
	}

	/**
	 * @return the callTime
	 */
	public Timestamp getCallTime() {
		return callTime;
	}

	/**
	 * @param callTime the callTime to set
	 */
	public void setCallTime(Timestamp callTime) {
		this.callTime = callTime;
	}

	/**
	 * @return the beneficiaryRegID
	 */
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	/**
	 * @param beneficiaryRegID the beneficiaryRegID to set
	 */
	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	/**
	 * @return the isMother
	 */
	public Boolean getIsMother() {
		return isMother;
	}

	/**
	 * @param isMother the isMother to set
	 */
	public void setIsMother(Boolean isMother) {
		this.isMother = isMother;
	}

}