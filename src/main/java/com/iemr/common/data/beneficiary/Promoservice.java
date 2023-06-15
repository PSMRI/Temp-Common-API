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
package com.iemr.common.data.beneficiary;

import java.util.List;

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
@Table(name = "M_Promoservice")
@Data
public class Promoservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long id;
	@Expose
	private String pamphlet;
	@Expose
	private String radio;
	@Expose
	private String television;
	@Expose
	private String familyFriends;
	@Expose
	private String healthcareWorker;
	@Expose
	private String others;
	@Expose
	private String notDisclosed;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Promoservice() {
	}

	public Promoservice(String pamphlet, String radio, String television, String familyFriends,
			String healthcareWorker, String others, String notDisclosed) {
		this.pamphlet = pamphlet;
		this.radio = radio;
		this.television = television;
		this.familyFriends = familyFriends;
		this.healthcareWorker = healthcareWorker;
		this.others = others;
		this.notDisclosed = notDisclosed;
	}

	public Long getId() {
		return this.id;
	}

	public String getPamphlet() {
		return this.pamphlet;
	}

	public void setPamphlet(String pamphlet) {
		this.pamphlet = pamphlet;
	}

	public String getRadio() {
		return this.radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getTelevision() {
		return this.television;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public String getFamilyFriends() {
		return this.familyFriends;
	}

	public void setFamilyFriends(String familyFriends) {
		this.familyFriends = familyFriends;
	}

	public String getHealthcareWorker() {
		return this.healthcareWorker;
	}

	public void setHealthcareWorker(String healthcareWorker) {
		this.healthcareWorker = healthcareWorker;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getNotDisclosed() {
		return this.notDisclosed;
	}

	public void setNotDisclosed(String notDisclosed) {
		this.notDisclosed = notDisclosed;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
