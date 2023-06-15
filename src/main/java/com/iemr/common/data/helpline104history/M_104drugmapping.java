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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import lombok.Data;


@Entity
@Data
@Table(name="m_104drugmapping")
public class M_104drugmapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "DrugMapID")
	private Integer drugMapID;
	
	@Expose
	@Column(name = "DrugId")
	private Integer drugId;
	
	@Expose
	@Column(name = "DrugName")
	private String drugName;
	
	@Expose
	@Column(name = "DrugGroupID")
	private Integer drugGroupID;
	
	@Expose
	@Column(name = "DrugGroupName")
	private String drugGroupName;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
