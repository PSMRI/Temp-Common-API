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
package com.iemr.common.data.lungassessment;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "t_swaasa")
public class LungAssessment {

	@Id
	@GeneratedValue
	@Column(name = "Id", insertable = false)
	private Long id;

	@Column(name = "Beneficiaryregid")
	private Long patientId;
	@Column(name = "AssessmentId")
	private String assessmentId;
	@Column(name = "Age")
	private Integer age;
	@Column(name = "Gender")
	private String gender;

	@Column(name = "frequent_cough")
	private Integer frequent_cough;
	@Column(name = "sputum")
	private Integer sputum;
	@Column(name = "cough_at_night")
	private Integer cough_at_night;
	@Column(name = "wheezing")
	private Integer wheezing;
	@Column(name = "pain_in_chest")
	private Integer pain_in_chest;
	@Column(name = "shortness_of_breath")
	private Integer shortness_of_breath;

	@Column(name = "record_duration")
	private Double record_duration;
	@Column(name = "status")
	private String status;
	@Column(name = "risk")
	private String risk;
	@Column(name = "cough_severity_score")
	private Integer cough_severity_score;
	@Column(name = "cough_pattern")
	private String cough_pattern;
	@Column(name = "dry_cough_count")
	private Integer dry_cough_count;
	@Column(name = "wet_cough_count")
	private Integer wet_cough_count;
	@Column(name = "severity")
	private String severity;

	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean deleted;
	@Column(name = "CreatedBy", updatable = false)
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	private SymptomsDTO symptoms;
	@Transient
	private MultipartFile coughsoundfile;
	@Transient
	private String message;
	@Transient
	private String timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getFrequent_cough() {
		return frequent_cough;
	}

	public void setFrequent_cough(Integer frequent_cough) {
		this.frequent_cough = frequent_cough;
	}

	public Integer getSputum() {
		return sputum;
	}

	public void setSputum(Integer sputum) {
		this.sputum = sputum;
	}

	public Integer getCough_at_night() {
		return cough_at_night;
	}

	public void setCough_at_night(Integer cough_at_night) {
		this.cough_at_night = cough_at_night;
	}

	public Integer getWheezing() {
		return wheezing;
	}

	public void setWheezing(Integer wheezing) {
		this.wheezing = wheezing;
	}

	public Integer getPain_in_chest() {
		return pain_in_chest;
	}

	public void setPain_in_chest(Integer pain_in_chest) {
		this.pain_in_chest = pain_in_chest;
	}

	public Integer getShortness_of_breath() {
		return shortness_of_breath;
	}

	public void setShortness_of_breath(Integer shortness_of_breath) {
		this.shortness_of_breath = shortness_of_breath;
	}

	public Double getRecord_duration() {
		return record_duration;
	}

	public void setRecord_duration(Double record_duration) {
		this.record_duration = record_duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public Integer getCough_severity_score() {
		return cough_severity_score;
	}

	public void setCough_severity_score(Integer cough_severity_score) {
		this.cough_severity_score = cough_severity_score;
	}

	public String getCough_pattern() {
		return cough_pattern;
	}

	public void setCough_pattern(String cough_pattern) {
		this.cough_pattern = cough_pattern;
	}

	public Integer getDry_cough_count() {
		return dry_cough_count;
	}

	public void setDry_cough_count(Integer dry_cough_count) {
		this.dry_cough_count = dry_cough_count;
	}

	public Integer getWet_cough_count() {
		return wet_cough_count;
	}

	public void setWet_cough_count(Integer wet_cough_count) {
		this.wet_cough_count = wet_cough_count;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
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
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public SymptomsDTO getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(SymptomsDTO symptoms) {
		this.symptoms = symptoms;
	}

	public MultipartFile getCoughsoundfile() {
		return coughsoundfile;
	}

	public void setCoughsoundfile(MultipartFile coughsoundfile) {
		this.coughsoundfile = coughsoundfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
