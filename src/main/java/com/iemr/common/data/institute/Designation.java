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
package com.iemr.common.data.institute;

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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_designation")
@Data
public class Designation
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@Column(name = "DesignationName")
	@Expose
	private String designationName;
	@Column(name = "DesignationDesc")
	@Expose
	private String designationDesc;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@OneToMany(mappedBy = "designation", fetch = FetchType.LAZY)
	@Transient
	@Expose
	private Set<FeedbackDetails> feedbackDetails;

	@OneToMany()
	@Transient
	@JoinColumn(referencedColumnName = "DesignationID", name = "DesignationID", insertable = false, updatable = false)
	private Set<User> users;

	public Designation()
	{

	}

	public Integer getDesignationID()
	{
		return designationID;
	}

	public void setDesignationID(int designationID)
	{
		this.designationID = designationID;
	}

	public String getDesignationName()
	{
		return designationName;
	}

	public void setDesignationName(String designationName)
	{
		this.designationName = designationName;
	}

	public String getDesignationDesc()
	{
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc)
	{
		this.designationDesc = designationDesc;
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

	public Designation(Integer designationId, String designationName)
	{
		this.designationID = designationId;
		this.designationName = designationName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
