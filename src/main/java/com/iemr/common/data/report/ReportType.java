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

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_qareporttype")
	
public class ReportType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "QAreportTypeID")
	private Integer QAreportTypeID;
	@Expose
	@Column(name = "ReportType")
	private String ReportType;
	@Expose
	@Column(name = "ReportTypeDesc")
	private String ReportTypeDesc;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer ProviderServiceMapID;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "ModifiedBy")
	private String ModifiedBy;
	public Integer getQAreportTypeID() {
		return QAreportTypeID;
	}
	public void setQAreportTypeID(Integer qAreportTypeID) {
		QAreportTypeID = qAreportTypeID;
	}
	public String getReportType() {
		return ReportType;
	}
	public void setReportType(String reportType) {
		ReportType = reportType;
	}
	public String getReportTypeDesc() {
		return ReportTypeDesc;
	}
	public void setReportTypeDesc(String reportTypeDesc) {
		ReportTypeDesc = reportTypeDesc;
	}
	public Integer getProviderServiceMapID() {
		return ProviderServiceMapID;
	}
	public void setProviderServiceMapID(Integer providerServiceMapID) {
		ProviderServiceMapID = providerServiceMapID;
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
		return CreatedDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public Timestamp getLastModDate() {
		return LastModDate;
	}
	public void setLastModDate(Timestamp lastModDate) {
		LastModDate = lastModDate;
	}
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp LastModDate;
}
	