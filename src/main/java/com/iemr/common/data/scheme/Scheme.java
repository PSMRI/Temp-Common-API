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
package com.iemr.common.data.scheme;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "M_Scheme")
@Data
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "SchemeID")
	private Integer schemeID;
	@Expose
	@Column(name = "SchemeName")
	private String schemeName;
	@Expose
	@Column(name = "SchemeDesc")
	private String schemeDesc;
	@Expose
	@Column(name = "KmFileManagerID")
	private Integer kmFileManagerID;
	@JoinColumn(name = "KmFileManagerID", insertable = false, updatable = false)
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@Expose
	private KMFileManager kmFileManager;

	@Transient
	@Expose
	private String kmFilePath;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheme(Integer schemeID, String schemeName, String schemeDesc, Integer kmFileManagerID,
			Integer providerServiceMapID, Boolean deleted, String createdBy, KMFileManager kmFileManager) {
		super();
		this.schemeID = schemeID;
		this.schemeName = schemeName;
		this.schemeDesc = schemeDesc;
		this.kmFileManagerID = kmFileManagerID;
		this.providerServiceMapID = providerServiceMapID;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.kmFileManager = kmFileManager;
	}

	public Integer getSchemeID() {
		return schemeID;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDesc() {
		return schemeDesc;
	}

	public void setSchemeDesc(String schemeDesc) {
		this.schemeDesc = schemeDesc;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getKmFileManagerID() {
		return kmFileManagerID;
	}

	public void setKmFileManagerID(Integer kmFileManagerID) {
		this.kmFileManagerID = kmFileManagerID;
	}

	public KMFileManager getKmFileManager() {
		return kmFileManager;
	}

	public void setKmFileManager(KMFileManager kmFileManager) {
		this.kmFileManager = kmFileManager;
	}

	public String getKmFilePath() {
		return kmFilePath;
	}

	public void setKmFilePath(String kmFilePath) {
		this.kmFilePath = kmFilePath;
	}

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
