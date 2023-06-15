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

import java.io.Serializable;
import java.sql.Date;

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
import com.iemr.common.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_MCTSOutboundCalls")

public class MctsOutboundCall implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "OBCallID")
	private Long obCallID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "OutboundCallType")
	private String outboundCallType;

	@Expose
	@Column(name = "DisplayOBCallType")
	private String displayOBCallType;
	
	@Expose
	@Column(name = "CallDateFrom")
	private Date callDateFrom;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motherID", referencedColumnName = "MCTSID_no", insertable = false, updatable = false)
	@Expose
	private MctsDataReaderDetail mctsDataReaderDetail;
	
	@Expose
	@Column(name = "AllocationStatus")
	private String allocationStatus;

	/**
	 * OutputMapper
	 */
	private static OutputMapper outputMapper = new OutputMapper();

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
	 * @return the beneficiaryRegID
	 */
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	/**
	 * @param beneficiaryRegID
	 *            the beneficiaryRegID to set
	 */
	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
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
	 * @return the outboundCallType
	 */
	public String getOutboundCallType() {
		return outboundCallType;
	}

	/**
	 * @param outboundCallType
	 *            the outboundCallType to set
	 */
	public void setOutboundCallType(String outboundCallType) {
		this.outboundCallType = outboundCallType;
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
	 * @return the callDateFrom
	 */
	public Date getCallDateFrom() {
		return callDateFrom;
	}

	/**
	 * @param callDateFrom the callDateFrom to set
	 */
	public void setCallDateFrom(Date callDateFrom) {
		this.callDateFrom = callDateFrom;
	}

	/**
	 * @return the mctsDataReaderDetail
	 */
	public MctsDataReaderDetail getMctsDataReaderDetail() {
		return mctsDataReaderDetail;
	}

	/**
	 * @param mctsDataReaderDetail the mctsDataReaderDetail to set
	 */
	public void setMctsDataReaderDetail(MctsDataReaderDetail mctsDataReaderDetail) {
		this.mctsDataReaderDetail = mctsDataReaderDetail;
	}

	/**
	 * @return the allocationStatus
	 */
	public String getAllocationStatus() {
		return allocationStatus;
	}

	/**
	 * @param allocationStatus the allocationStatus to set
	 */
	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

}
