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
package com.iemr.common.data.helpline104history;

import java.sql.Date;
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

import lombok.Data;


@Entity
@Data
@Table(name = "t_104prescribeddrug")
public class PrescribedDrug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "PrescribedDrugID")
	private Long prescribedDrugID;
	@Expose
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
    
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "prescriptionID")
	private Prescription t_prescription;

	@Expose
	@Column(name = "DrugMapID")
	private Integer drugMapID;
	
	@Expose
	@Transient
	private String drugName;
    
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "drugMapID")
	private M_104drugmapping m_104drugmapping;

	@Expose
	@Column(name = "DrugForm")
	private String drugForm;
	// for usage
	@Expose
	@Column(name = "DrugRoute")
	private String drugRoute;
	@Expose
	@Column(name = "Frequency")
	private String frequency;
	@Expose
	@Column(name = "dosage")
	private String dosage;
	@Expose
	@Column(name = "noOfDays")
	private Integer noOfDays;
	@Expose
	@Column(name = "timeToConsume")
	private String timeToConsume;
	@Expose
	@Column(name = "sideEffects")
	private String sideEffects;
	@Expose
	@Column(name = "ValidTill")
	private Timestamp validTill;
	
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

}
