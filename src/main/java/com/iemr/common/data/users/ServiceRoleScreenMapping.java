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
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_servicerolescreenmapping")
@Data
public class ServiceRoleScreenMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "SRSMappingID")
	private Integer srsMappingID;// int(11) NO PRI auto_increment
	@Expose
	@Column(name = "ScreenID")
	private Integer screenID;// int(11) YES MUL
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ScreenID", insertable = false, updatable = false)
	@Expose
	private Screen screen;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	private ProviderServiceMapping providerServiceMapping;

	@Expose
	@Column(name = "RoleID")
	private Integer roleID;
	@Expose
	// @Transient
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleID", insertable = false, updatable = false)
	private Role role;

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

	// public ServiceRoleScreenMapping() {
	// }

	public static ServiceRoleScreenMapping initializeRoleScreenMapping(Integer srsMappingID, Integer screenID,
			Screen screen, Integer providerServiceMapID, ProviderServiceMapping providerServiceMapping,
			Integer roleID, /* Role role, */ Boolean deleted, String createdBy)
	{
		ServiceRoleScreenMapping serviceRoleScreenMapping = new ServiceRoleScreenMapping();
		serviceRoleScreenMapping.srsMappingID = srsMappingID;
		serviceRoleScreenMapping.screenID = screenID;
		serviceRoleScreenMapping.screen = screen;
		serviceRoleScreenMapping.providerServiceMapID = providerServiceMapID;
		serviceRoleScreenMapping.providerServiceMapping = providerServiceMapping;
		serviceRoleScreenMapping.roleID = roleID;
		// serviceRoleScreenMapping.role = role;
		serviceRoleScreenMapping.deleted = deleted;
		serviceRoleScreenMapping.createdBy = createdBy;
		return serviceRoleScreenMapping;
	}

	public ServiceRoleScreenMapping createServiceRoleScreenMapping(Integer srsMappingID, Integer screenID,
			Screen screen, Integer providerServiceMapID, ProviderServiceMapping providerServiceMapping,
			Integer roleID, /* Role role, */Boolean deleted, String createdBy)
	{
		this.srsMappingID = srsMappingID;
		this.screenID = screenID;
		this.screen = screen;
		this.providerServiceMapID = providerServiceMapID;
		this.providerServiceMapping = providerServiceMapping;
		this.roleID = roleID;
		// this.role = role;
		this.deleted = deleted;
		this.createdBy = createdBy;
		return this;
	}

	public ServiceRoleScreenMapping createServiceRoleScreenMapping(Integer srsMappingID, Integer screenID,
			Screen screen, Boolean deleted, String createdBy)
	{
		this.srsMappingID = srsMappingID;
		this.screenID = screenID;
		this.screen = screen;
		this.deleted = deleted;
		this.createdBy = createdBy;
		return this;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
