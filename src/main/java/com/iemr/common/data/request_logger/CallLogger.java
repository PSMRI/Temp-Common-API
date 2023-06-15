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
package com.iemr.common.data.request_logger;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "tbencalllog")
public class CallLogger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "tbencalllogid", insertable = false, updatable = false)
	private Long tBenCallLogID;
	
	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;

	@Column(name = "CallID")
	@Expose
	private String callID;
	
	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;
	
	@Column(name = "callEndTime")
	@Expose
	private Timestamp callEndTime;
	
	@Column(name = "remarks")
	@Expose
	private String remarks;
	
	@Column(name = "callClosureType")
	@Expose
	private String callClosureType;
	
	@Column(name = "dispositionStatusID")
	@Expose
	private Integer dispositionStatusID;
	
	@Column(name = "callTypeID")
	@Expose
	private Integer callTypeID;
	
	@Column(name = "emergencyType")
	@Expose
	private Short emergencyType;
	
	@Column(name = "APIName")
	@Expose
	private String APIName;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	
//	@Column(name = "CreatedDate", insertable = false, updatable = false)
//	private Timestamp createdDate;
	
	@Column(name = "ModifiedBy")
	@Expose
	private String modifiedBy;
	
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp LastModDate;
	
	@Column(name = "RequestOBJ")
	@Expose
	private String requestOBJ;
	

}
