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
package com.iemr.common.data.healthCareWorkerType;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "M_HealthCareWorker")
@Data
public class HealthCareWorker
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "HealthCareWorkerID")
	@Expose
	private Short healthCareWorkerID;

	@Column(name = "HealthCareWorkerType")
	@Expose
	private String healthCareWorkerType;

	@Column(name = "HealthCareWorkerDesc")
	@Expose
	private String healthCareWorkerDesc;

	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;

	public HealthCareWorker(Short healthCareWorkerID, String healthCareWorkerType, String healthCareWorkerDesc,
			Boolean deleted, String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		super();
		this.healthCareWorkerID = healthCareWorkerID;
		this.healthCareWorkerType = healthCareWorkerType;
		this.healthCareWorkerDesc = healthCareWorkerDesc;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public HealthCareWorker(Short healthCareWorkerID, String healthCareWorkerType)
	{

		this.healthCareWorkerID = healthCareWorkerID;
		this.healthCareWorkerType = healthCareWorkerType;
	}

	public HealthCareWorker()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Short getHealthCareWorkerID()
	{
		return healthCareWorkerID;
	}

	public String getHealthCareWorkerType()
	{
		return healthCareWorkerType;
	}

	public void setHealthCareWorkerType(String healthCareWorkerType)
	{
		this.healthCareWorkerType = healthCareWorkerType;
	}

	public String getHealthCareWorkerDesc()
	{
		return healthCareWorkerDesc;
	}

	public void setHealthCareWorkerDesc(String healthCareWorkerDesc)
	{
		this.healthCareWorkerDesc = healthCareWorkerDesc;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}

}
