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
package com.iemr.common.data.location;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.institute.Institute;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_district")
@Data
public class Districts
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_district")
	@Transient
	private Set<BenDemographics> i_bendemographics;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	@Transient
	private Set<Institute> institutes;
	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	@Column(name = "DistrictName")
	@Expose
	private String districtName;
	// @Column(name = "Zone")
	// @Expose
	// private String zone;
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, name = "StateID", updatable = false)
	@JsonIgnore
	private States states;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Districts()
	{
	}

	public Districts(Integer DistrictID, String DistrictName)
	{
		this.districtID = DistrictID;
		this.districtName = DistrictName;
	}

	public Districts(Integer DistrictID, String DistrictName, Integer stateId, String stateName)
	{
		this.states = new States();
		this.states = this.states.getStates(stateId.intValue(), stateName);
		this.districtID = DistrictID;
		this.districtName = DistrictName;
	}

	public int getDistrictID()
	{
		return this.districtID.intValue();
	}

	public void setDistrictID(int districtID)
	{
		this.districtID = Integer.valueOf(districtID);
	}

	public String getDistrictName()
	{
		return this.districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

	// public String getZone() {
	// return this.zone;
	// }
	//
	// public void setZone(String zone) {
	// this.zone = zone;
	// }

	public boolean isDeleted()
	{
		return this.deleted.booleanValue();
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public States getStates()
	{
		return this.states;
	}

	public void setStates(States states)
	{
		this.states = states;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
