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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smsparametermapping")
@Data
public class SMSParametersMap
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSParameterMapID")
	Integer smsParameterMapID;
	@Column(name = "SMSParameterID")
	Integer smsParameterID;
	@OneToOne
	@JoinColumn(name = "SMSParameterID", insertable = false, updatable = false)
	SMSParameters smsParameter;
	@Column(name = "SMSTypeID")
	Integer smsTypeID;
	@OneToOne
	@JoinColumn(name = "SMSTypeID", insertable = false, updatable = false)
	SMSType smsType;
	@Column(name = "SMSTemplateID")
	Integer smsTemplateID;
	@Column(name = "UserParameterName")
	String smsParameterName;
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
