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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Table(name = "db_reporting.dim_user", schema = "db_reporting")
@Data
public class UserReport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "Dim_USERID", insertable = false, updatable = false)
	private Long dim_USERID;
	
	@Expose
	@Column(name = "UserID")
	private Long userID;
	
	@Expose
	@Column(name = "FirstName")
	private String firstName;
	
	@Expose
	@Column(name = "MiddleName")
	private String middleName;
	
	@Expose
	@Column(name = "LastName")
	private String lastName;
	
	@Expose
	@Column(name = "EmployeeID")
	private String empID;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", referencedColumnName = "UserID", updatable = false, insertable = false)
	@Expose
	private UserServiceRoleReport userServiceRoleReport;
	
}
