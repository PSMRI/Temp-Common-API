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
package com.iemr.common.data.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_van")
public class MasterVan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "VanID")
	private Integer vanID;
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@ManyToOne
	@JoinColumn(name = "ParkingPlaceID", insertable = false, updatable = false)
	private UserParkingplaceMapping userParkingplaceMapping;

	public MasterVan() {
	}

	public MasterVan(Integer vanID, String vehicalNo, Integer providerServiceMapID, Integer parkingPlaceID,
			Boolean deleted, UserParkingplaceMapping userParkingplaceMapping) {
		super();
		this.vanID = vanID;
		this.vehicalNo = vehicalNo;
		this.providerServiceMapID = providerServiceMapID;
		this.parkingPlaceID = parkingPlaceID;
		this.deleted = deleted;
		this.userParkingplaceMapping = userParkingplaceMapping;
	}

	public Integer getVanID() {
		return vanID;
	}

	public void setVanID(Integer vanID) {
		this.vanID = vanID;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public UserParkingplaceMapping getUserParkingplaceMapping() {
		return userParkingplaceMapping;
	}

	public void setUserParkingplaceMapping(UserParkingplaceMapping userParkingplaceMapping) {
		this.userParkingplaceMapping = userParkingplaceMapping;
	}

}
