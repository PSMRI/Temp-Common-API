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
package com.iemr.common.config.prototype;

public class BeneficiaryOccupation {
	private Long occupationID;
	private String occupationType;
	private Boolean deleted;
	private String createdby;
	private String modifiedby;
	private String key;
	private String operation;

	public Long getOccupationID() {
		return occupationID;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getCreatedby() {
		return createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public String getKey() {
		return key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOccupationID(Long occupationID) {
		this.occupationID = occupationID;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
