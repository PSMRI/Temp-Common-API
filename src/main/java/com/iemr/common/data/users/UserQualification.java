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

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_userqualification")
public class UserQualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer QualificationID;
	@Expose
	private String Name;
	@Expose
	private String UserQualificationDesc;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	private Timestamp CreatedDate;
	private String ModifiedBy;
	private Timestamp LastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public UserQualification() {
	}

	public UserQualification(int QualificationID, String Name) {
		this.QualificationID = Integer.valueOf(QualificationID);
		this.Name = Name;
	}

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
