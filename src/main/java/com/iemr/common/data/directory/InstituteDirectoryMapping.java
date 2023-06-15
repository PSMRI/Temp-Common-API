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
package com.iemr.common.data.directory;

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
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.institute.Institute;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_institutedirectorymapping")
@Data
public class InstituteDirectoryMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstituteDirMapID")
	@Expose
	private Long instituteDirMapID;

	@Column(name = "InstitutionID")
	@Expose
	private Integer institutionID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstitutionID", insertable = false, updatable = false)
	@Expose
	private Institute institute;

	@Column(name = "InstituteDirectoryID")
	@Expose
	private Integer instituteDirectoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstituteDirectoryID", insertable = false, updatable = false)
	@Expose
	private Directory directory;
	@Column(name = "InstituteSubDirectoryID")
	@Expose
	private Integer instituteSubDirectoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instituteSubDirectoryID", insertable = false, updatable = false)
	@Expose
	private SubDirectory subDirectory;
	@Column(name = "InstituteRouteDirectoryID")
	@Expose
	private Integer instituteRouteDirectoryID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Transient
	private Integer blockID;

	@Transient
	private Integer districtID;

	@Transient
	private Integer stateID;

	protected InstituteDirectoryMapping() {
	}

	public InstituteDirectoryMapping(Long instituteDirMapID, Integer institutionID, String institutionName) {
		this.instituteDirMapID = instituteDirMapID;
		this.institute = new Institute(institutionID, institutionName);
	}

	public InstituteDirectoryMapping(Long instituteDirMapID, Integer institutionID, Institute institute,
			Boolean deleted, Integer instituteDirectoryID, Directory directory, Integer instituteSubDirectoryID,
			SubDirectory subDirectory) {
		this.instituteDirMapID = instituteDirMapID;
		this.institutionID = institutionID;
		this.institute = institute;
		this.deleted = deleted;
		this.instituteDirectoryID = instituteDirectoryID;
		this.directory = directory;
		this.instituteSubDirectoryID = instituteSubDirectoryID;
		this.subDirectory = subDirectory;
	}

	public Integer getBlockID() {
		return blockID;
	}

	public Integer getStateID() {
		return stateID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public Integer getInstituteDirectoryID() {
		return instituteDirectoryID;
	}

	public Integer getInstituteSubDirectoryID() {
		return instituteSubDirectoryID;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
