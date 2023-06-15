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
package com.iemr.common.data.users;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.service.SubService;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_servicemaster")
public class ServiceMaster
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ServiceID")
	private Integer serviceID;
	@Expose
	@Column(name = "ServiceName")
	private String serviceName;
	@Expose
	@Column(name = "ServiceDesc")
	private String serviceDesc;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;
	@OneToMany(mappedBy = "m_ServiceMaster")
	@Transient
	@Expose
	private Set<UserServiceRoleMapping> m_UserServiceRoleMapping;

	@OneToMany(mappedBy = "service")
	@Transient
	@Expose
	private Set<SubService> subServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mservicemaster")
	@Transient
	private List<FeedbackDetails> feedbacks;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public ServiceMaster()
	{
	}

	public ServiceMaster(Integer serviceID, String serviceName, String serviceDesc, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate,
			Set<UserServiceRoleMapping> m_UserServiceRoleMapping)
	{
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.m_UserServiceRoleMapping = m_UserServiceRoleMapping;
	}

	public Integer getServiceID()
	{
		return this.serviceID;
	}

	public void setServiceID(int serviceID)
	{
		this.serviceID = Integer.valueOf(serviceID);
	}

	public String getServiceName()
	{
		return this.serviceName;
	}

	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}

	public String getServiceDesc()
	{
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc)
	{
		this.serviceDesc = serviceDesc;
	}

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

	// public Set<UserServiceRoleMapping> getM_UserServiceRoleMapping() {
	// return this.m_UserServiceRoleMapping;
	// }

	// public void setM_UserServiceRoleMapping(Set<UserServiceRoleMapping> m_UserServiceRoleMapping) {
	// this.m_UserServiceRoleMapping = m_UserServiceRoleMapping;
	// }

	public ServiceMaster(Integer serviceID, String serviceName, String serviceDesc, Boolean deleted)
	{
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.deleted = deleted;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
