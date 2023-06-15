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
package com.iemr.common.data.sms;

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

import com.iemr.common.data.users.ServiceMaster;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smstype")
@Data
public class SMSType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSTypeID")
	Integer smsTypeID;
	@Column(name = "SMSType")
	String smsType;
	@Column(name = "SMSTypeDesc")
	String description;
	@Column(name = "ServiceID")
	Integer serviceID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ServiceID", insertable = false, updatable = false)
	ServiceMaster service;
	@Column(name = "Deleted", insertable = false, updatable = true)
	Boolean deleted;
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	Timestamp lastModDate;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}
