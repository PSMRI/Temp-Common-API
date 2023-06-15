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
package com.iemr.common.data.telemedicine;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.google.gson.annotations.Expose;

public class PrescribedDrugDetail {
	//private Long id;
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private Long visitCode;
	private Long prescriptionID;
	private String formName;
	private String drugTradeOrBrandName;
	private Integer drugID;
	private String drugName;
	private String drugStrength;
	private String dose;
	private String route;
	private String frequency;
	private String duration;
	private String unit;
	private String relationToFood;
	private String instructions;
	private Integer qtyPrescribed;

//	@Expose
//	@Column(name = "Deleted", insertable = false, updatable = true)
//	private Boolean deleted;
//
//	@Expose
//	@Column(name = "Processed", insertable = false, updatable = true)
//	private String processed;
	private String createdBy;

//	@Expose
//	@Column(name = "CreatedDate", insertable = false, updatable = false)
//	private Timestamp createdDate;
	private String modifiedBy;

//	@Expose
//	@Column(name = "LastModDate", insertable = false, updatable = false)
//	private Timestamp lastModDate;

	private Long vanSerialNo;
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

	public Long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(Long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getDrugTradeOrBrandName() {
		return drugTradeOrBrandName;
	}

	public void setDrugTradeOrBrandName(String drugTradeOrBrandName) {
		this.drugTradeOrBrandName = drugTradeOrBrandName;
	}

	public Integer getDrugID() {
		return drugID;
	}

	public void setDrugID(Integer drugID) {
		this.drugID = drugID;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugStrength() {
		return drugStrength;
	}

	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRelationToFood() {
		return relationToFood;
	}

	public void setRelationToFood(String relationToFood) {
		this.relationToFood = relationToFood;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Integer getQtyPrescribed() {
		return qtyPrescribed;
	}

	public void setQtyPrescribed(Integer qtyPrescribed) {
		this.qtyPrescribed = qtyPrescribed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getVanID() {
		return vanID;
	}

	public void setVanID(Integer vanID) {
		this.vanID = vanID;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Timestamp getSyncedDate() {
		return syncedDate;
	}

	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}

	public String getReservedForChange() {
		return reservedForChange;
	}

	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
	}

	public Boolean getIsEDL() {
		return isEDL;
	}

	public void setIsEDL(Boolean isEDL) {
		this.isEDL = isEDL;
	}

	private String vehicalNo;

	private Integer vanID;
	private Integer parkingPlaceID;
	private String syncedBy;
	private Timestamp syncedDate;
	private String reservedForChange;
	
	private Boolean isEDL;
	

}
