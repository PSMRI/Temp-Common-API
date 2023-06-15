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
package com.iemr.common.data.door_to_door_app;

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
@Table(name = "v_doortodooruserdetails")
public class V_doortodooruserdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Expose
	@Column(name = "UserID")
	private Integer userID;

	@Expose
	@Column(name = "UserName")
	private String userName;

	@Expose
	@Column(name = "ContactNo")
	private String contactNo;

	@Expose
	@Column(name = "EmergencyContactNo")
	private String emergencyContactNo;

	@Expose
	@Column(name = "EmergencyContactPerson")
	private String emergencyContactPerson;

	@Expose
	@Column(name = "RoleID")
	private Integer roleID;

	@Expose
	@Column(name = "RoleName")
	private String roleName;

	@Expose
	@Column(name = "StateID")
	private Integer stateID;

	@Expose
	@Column(name = "StateName")
	private String stateName;

	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;

	@Expose
	@Column(name = "DistrictName")
	private String districtName;

	@Expose
	@Column(name = "DistrictBlockID")
	private Integer districtBlockID;

	@Expose
	@Column(name = "BlockName")
	private String blockName;

	@Expose
	@Column(name = "DistrictBranchID")
	private Integer districtBranchID;

	@Expose
	@Column(name = "VillageName")
	private String villageName;

	@Expose
	@Column(name = "designationid")
	private Integer designationId;

	@Expose
	@Column(name = "designationname")
	private String designationName;
}
