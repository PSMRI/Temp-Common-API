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


@Entity
@Table(name = "db_reporting.fact_104benmedhistory", schema = "db_reporting")

public class MedHistory implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fact_104BenMedHistoryID")
	private Long fact_104BenMedHistoryID;

	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@Expose
	@Column(name = "SymptomID")
	private String symptomID;

	@Column(name = "Algorithm")
	private String algorithm;

	@Expose
	@Column(name = "DiseaseSummaryID")
	private String diseaseSummaryID;

	@Expose
	@Column(name = "DiseaseSummary")
	private String diseaseSummary;

	@Expose
	@Column(name = "SelecteDiagnosisID")
	private String selecteDiagnosisID;

	@Expose
	@Column(name = "SelecteDiagnosis")
	private String selecteDiagnosis;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "BeneficiaryRegID")
	private BenDetails beneficiaryData;
	// search params
	@Transient
	private Timestamp startDate;

	@Transient
	private Timestamp endDate;
	
	public BenDetails getBeneficiaryData() {
		return beneficiaryData;
	}


	public void setBeneficiaryData(BenDetails beneficiaryData) {
		this.beneficiaryData = beneficiaryData;
	}


	@Transient
	private String agentID;
	
	@Transient
	private Integer providerServiceMapID;
	
	@Transient
	private Long roleID;
	
	@Transient
	private Integer callTypeID;
	
	@Transient
	private String callTypeName;
	
	@Transient
	private String roleName;
	
	@Transient
	private String reportType;
	@Transient
	private Integer reportTypeID;
	
	public Integer getReportTypeID() {
		return reportTypeID;
	}


	public void setReportTypeID(Integer reportTypeID) {
		this.reportTypeID = reportTypeID;
	}


	public String getReportType() {
		return reportType;
	}


	public void setReportType(String reportType) {
		this.reportType = reportType;
	}


	public MedHistory()
	{
		super();
	}


	public Long getFact_104BenMedHistoryID() {
		return fact_104BenMedHistoryID;
	}


	public void setFact_104BenMedHistoryID(Long fact_104BenMedHistoryID) {
		this.fact_104BenMedHistoryID = fact_104BenMedHistoryID;
	}


	public Long getBenCallID() {
		return benCallID;
	}


	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}


	public String getSymptomID() {
		return symptomID;
	}


	public void setSymptomID(String symptomID) {
		this.symptomID = symptomID;
	}


	public String getAlgorithm() {
		return algorithm;
	}


	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}


	public String getDiseaseSummaryID() {
		return diseaseSummaryID;
	}


	public void setDiseaseSummaryID(String diseaseSummaryID) {
		this.diseaseSummaryID = diseaseSummaryID;
	}


	public String getDiseaseSummary() {
		return diseaseSummary;
	}


	public void setDiseaseSummary(String diseaseSummary) {
		this.diseaseSummary = diseaseSummary;
	}


	public String getSelecteDiagnosisID() {
		return selecteDiagnosisID;
	}


	public void setSelecteDiagnosisID(String selecteDiagnosisID) {
		this.selecteDiagnosisID = selecteDiagnosisID;
	}


	public String getSelecteDiagnosis() {
		return selecteDiagnosis;
	}


	public void setSelecteDiagnosis(String selecteDiagnosis) {
		this.selecteDiagnosis = selecteDiagnosis;
	}

	public String getAgentID() {
		return agentID;
	}


	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}


	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}


	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}


	public Long getRoleID() {
		return roleID;
	}


	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	public Integer getCallTypeID() {
		return callTypeID;
	}


	public void setCallTypeID(Integer callTypeID) {
		this.callTypeID = callTypeID;
	}


	public String getCallTypeName() {
		return callTypeName;
	}


	public void setCallTypeName(String callTypeName) {
		this.callTypeName = callTypeName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
