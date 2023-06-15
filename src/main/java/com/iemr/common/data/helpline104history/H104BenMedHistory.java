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
package com.iemr.common.data.helpline104history;

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
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_104benmedhistory")
public class H104BenMedHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "BenHistoryID")
	private Long benHistoryID;
	@Expose
	@Column(name = "RequestID")
	private String requestID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	@Expose
	@Transient
	private String callID;
	@Expose
	@Column(name = "PatientName")
	private String patientName;
	@Expose
	@Column(name = "PatientAge")
	private Integer patientAge;
	@Expose
	@Column(name = "PatientGenderID")
	private Short patientGenderID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "patientGenderID")
	private Gender m_gender;
	@Expose
	@Column(name = "Algorithm")
	private String algorithm;
	@Expose
	@Column(name = "SymptomID")
	private String symptomID;
	@Expose
	@Column(name = "DiseaseSummary")
	private String diseaseSummary;
	@Expose
	@Column(name = "DiseaseSummaryID")
	private String diseaseSummaryID;
	@Expose
	@Column(name = "Allergies")
	private String allergies;
	@Expose
	@Column(name = "SelecteDiagnosis")
	private String selecteDiagnosis;
	@Expose
	@Column(name = "SelecteDiagnosisID")
	private String selecteDiagnosisID;
	@Expose
	@Column(name = "AddedAdvice")
	private String addedAdvice;
	@Expose
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
	@Expose
	@Column(name = "ActionByHAO")
	private String actionByHAO;
	@Expose
	@Column(name = "ActionByCO")
	private String actionByCO;
	@Expose
	@Column(name = "ActionByPD")
	private String actionByPD;
	@Expose
	@Column(name = "ActionByMO")
	private String actionByMO;
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	@Expose
	@Column(name = "IsSelf")
	private Boolean isSelf;
	@Expose
	@Transient
	private Integer districtID;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "IsChiefComplaint")
	private Boolean isChiefComplaint;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	@Expose
	@Column(name = "RiskLevel")
	private String riskLevel;
	@Expose
	@Column(name = "TreatmentRecommendation")
	private String treatmentRecommendation;

	public H104BenMedHistory(Long beneficiaryRegID, String patientName, Integer patientAge, Integer patientGenderID,
			String genderName, String algorithm, String symptomID, String diseaseSummary, String diseaseSummaryID,
			String allergies, String selecteDiagnosis, String selecteDiagnosisID, String addedAdvice, Long prescription,
			String actionByHAO, String actionByCO, String actionByMO, String remarks, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Date lastModDate) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.m_gender = new Gender().getGender(patientGenderID, genderName);
		this.algorithm = algorithm;
		this.symptomID = symptomID;
		this.diseaseSummary = diseaseSummary;
		this.diseaseSummaryID = diseaseSummaryID;
		this.allergies = allergies;
		this.selecteDiagnosis = selecteDiagnosis;
		this.selecteDiagnosisID = selecteDiagnosisID;
		this.addedAdvice = addedAdvice;
		this.prescriptionID = prescription;
		this.actionByHAO = actionByHAO;
		this.actionByCO = actionByCO;
		this.actionByMO = actionByMO;
		this.remarks = remarks;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public String getActionByCO() {
		return actionByCO;
	}

	public String getActionByPD() {
		return actionByPD;
	}

	public H104BenMedHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public Long getBenHistoryID() {
		return benHistoryID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public String getCallID() {
		return callID;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

}
