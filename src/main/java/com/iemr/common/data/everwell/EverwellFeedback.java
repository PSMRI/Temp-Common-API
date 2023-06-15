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
package com.iemr.common.data.everwell;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Table(name = "t_everwellfeedback")
@Data
public class EverwellFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "EFID")
	private Long efid;
	
	@Expose
	@Column(name = "EAPIID")
	private Long eapiId;
	
	@Expose
	@Column(name = "EverWellID")
	private Long Id;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapId;
	
	@Expose
	@Column(name = "ActionTaken")
	private String actionTaken;
	
	@Expose
	@Column(name = "Category")
	private String category;
	
	@Expose
	@Column(name = "SubCategory")
	private String subCategory;
	
	@Expose
	@Column(name = "DateOfAction")
	private Timestamp dateOfAction;
	
	@Expose
	@Column(name = "Comments")
	private String comments;
	
	@Expose
	@Column(name = "secondaryPhoneNo")
	private String secondaryPhoneNo;
	
	@Expose
	@Column(name = "isManualDoseProcessed")
	private Boolean isManualDoseProcessed = false;
	
	@Expose
	@Column(name = "isMissedDoseProcessed")
	private Boolean isMissedDoseProcessed = false;
	
	@Expose
	@Column(name = "isSupportactionProcessed")
	private Boolean isSupportActionProcessed = false;
	
	@Expose
	@Column(name = "isMobileNumberProcessed")
	private Boolean isMobileNumberProcessed = false;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted = false;
	
	@Expose
	@Column(name = "Processed")
	private String processed = "N";
	
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	@Transient
	private Boolean isCompleted;
}
