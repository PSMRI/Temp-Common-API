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
package com.iemr.common.data.userbeneficiarydata;

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
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.ServiceProvider;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_status")
@Data
public class Status
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StatusID")
	@Expose
	private Integer statusID;

	@OneToMany(/* mappedBy = "m_status", fetch = FetchType.LAZY */)
	@JoinColumn(name = "StatusID", referencedColumnName = "StatusID", insertable = false, updatable = false)
	@Transient
	private Set<User> m_Users;

	// @Column(name = "BeneficiaryRegID")
	// @Expose
	// private Long beneficiaryRegID;

	@OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	@Expose
	@Transient
	private Set<Beneficiary> i_Beneficiaries;

	@OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	@Transient
	private Set<ServiceProvider> serviceProviders;

	@OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	@Transient
	private Set<ProviderServiceMapping> providerServiceMappings;

	// @OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	// @Transient
	// private Set<UserServiceRoleMapping> userServiceRoleMappings;

	@Column(name = "Status")
	@Expose
	private String status;
	@Column(name = "StatusDesc")
	@Expose
	private String statusDesc;
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

	public Status()
	{
	}

	public Status(int statusID, String status)
	{
		this.statusID = Integer.valueOf(statusID);
		this.status = status;
	}

	public Status(int statusID, String status, String statusDesc, boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, Set<User> m_User)
	{
		this.statusID = Integer.valueOf(statusID);
		this.status = status;
		this.statusDesc = statusDesc;
		this.deleted = Boolean.valueOf(deleted);
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.m_Users = m_User;
	}

	public int getStatusID()
	{
		return this.statusID.intValue();
	}

	public void setStatusID(int statusID)
	{
		this.statusID = Integer.valueOf(statusID);
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getStatusDesc()
	{
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
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

	// public Set<User> getM_User()
	// {
	// return this.m_Users;
	// }

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
