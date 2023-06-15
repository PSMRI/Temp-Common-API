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
package com.iemr.common.data.mctshistory;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="t_childvaliddata")
public class ChildValidDataHandler implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long RowID;
	
	@Expose
	@Column(name = "BeneficiaryRegID", insertable = true, updatable = false)
	private Long BeneficiaryRegID;
	
	@Expose
	private Long MCTSID_no_Child_ID;
	 
	@Expose
	private String Child_Name;
	 
	@Expose
	private String Father_Name;
	 
	@Expose
	private String Mother_Name;
	 
	@Expose
	private Long Mother_ID;
	 
	@Expose
	private Date DOB;
	 
	@Expose
	private String Gender;
	 
	@Expose
	private String Caste;
	 
	@Expose
	private String Phone_No;
	 
	@Expose
	private Long State_ID;
	 
	@Expose
	private String State_Name;
	 
	@Expose
	private Long District_ID;
	 
	@Expose
	private String District_Name;
	 
	@Expose
	private String Taluka_Name;
	 
	@Expose
	private Long Taluka_ID;
	 
	@Expose
	private Long Block_ID;
	 
	@Expose
	private String Block_Name;
	 
	@Expose
	private Long Village_ID;
	 
	@Expose
	private String Village_Name;
	 
	@Expose
	private String GP_Village;
	 
	@Expose
	private String Address;
	 
	@Expose
	private String Created_By;
	 
	@Expose
	private String Updated_By;
	 
	@Expose
	@Column(name = "CreatedBy", insertable = true, updatable = false)
	private String CreatedBy;
	 
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date CreatedDate;
	 
	@Expose
	private String ModifiedBy;
	 
	@Expose
	private Date LastModDate;
	
}