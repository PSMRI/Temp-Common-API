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
package com.iemr.common.data.feedback;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
@Table(name = "T_EpidemicOutbreak")
public class EpidemicOutbreak {

	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outbreakComplaintID;
	@Expose
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@Expose
	private Long beneficiaryRegID;
	@Expose
	private String natureOfComplaint;
	@Expose
	private Integer totalPeopleAffected;
	@Expose
	private Integer affectedDistrictID;

	@Expose
	private Integer affectedDistrictBlockID;

	@Expose
	private Integer affectedVillageID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer serviceID;
	@Expose
	private String remarks;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Expose
	private String modifiedBy;
	@Expose
	@Column(name = "createdDate", insertable = false, updatable = false)
	private Timestamp createdDate;

}
