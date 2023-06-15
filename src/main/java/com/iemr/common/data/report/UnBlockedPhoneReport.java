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
package com.iemr.common.data.report;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "db_reporting.fact_phoneblock", schema = "db_reporting")
@Data
public class UnBlockedPhoneReport implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Fact_PhoneBlockID")
	private Long fact_phoneBlockID;
	
	@Column(name = "ID")
	private Long phoneBlockID;
	
	@Expose
	@Column(name = "phoneNo")
	private String phoneNo;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "NoOfNuisanceCall")
	private Integer noOfNuisanceCall;
	
	@Expose
	@Column(name = "IsBlocked")
	private Boolean isBlocked;
	
	@Expose
	@Transient
	private Timestamp blockStartDate;
	
	@Expose
	@Transient
	private Timestamp blockEndDate;
	
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
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
