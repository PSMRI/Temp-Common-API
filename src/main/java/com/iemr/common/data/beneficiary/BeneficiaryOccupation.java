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
package com.iemr.common.data.beneficiary;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_Beneficiaryoccupation")
@Data
public class BeneficiaryOccupation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OccupationID")
	@Expose
	private Long occupationID;

	@Transient
	private Set<BenDemographics> i_BenDemographics;

	@Column(name = "OccupationType")
	@Expose
	private String occupationType;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdby;
	@Column(name = "ModifiedBy")
	private String modifiedby;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public BeneficiaryOccupation getOccupation(Long occupationid, String occupationtype)
	{
		this.occupationID = occupationid;
		this.occupationType = occupationtype;
		return this;
	}

	public BeneficiaryOccupation getOccupation(Long occupationID, String occupationType, Boolean deleted, String createdBy,
			String modifiedBy)
	{
		this.occupationID = occupationID;
		this.occupationType = occupationType;
		this.deleted = deleted;
		this.createdby = createdBy;
		this.modifiedby = modifiedBy;
		return this;
	}

	public Long getOccupationID()
	{
		return this.occupationID;
	}

	public String getOccupationType()
	{
		return this.occupationType;
	}

	public void setOccupationType(String occupationType)
	{
		this.occupationType = occupationType;
	}

	public Boolean getDeleted()
	{
		return this.deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return this.createdby;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdby = createdBy;
	}

	public String getModifiedBy()
	{
		return this.modifiedby;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedby = modifiedBy;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
