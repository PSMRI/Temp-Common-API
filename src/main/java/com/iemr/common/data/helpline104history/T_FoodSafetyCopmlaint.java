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

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;

import lombok.Data;


@Entity
@Data
@Table(name = "T_FoodSafetyCopmlaint")
public class T_FoodSafetyCopmlaint
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fSComplaintID;
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	/*@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "benCallID")
	private BenCall benCall; */
	private Long beneficiaryRegID;	
	private String typeOfRequest;
	private Byte isDiarrhea;
	private Byte isVomiting;
	private Byte isAbdominalPain;
	private Byte isChillsOrRigors;
	private Byte isGiddiness;
	private Byte isDehydration;
	private Byte isRashes;
	private Timestamp fromWhen;
	private String historyOfDiet;
	private Byte isFoodConsumed;
	private String typeOfFood;
	private String foodConsumedFrom;
	private String associatedSymptoms;
	@Expose
	private Integer districtID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "districtID")
	private Districts district;
	private Integer districtBlockID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "districtBlockID")
	private DistrictBlock districtBlock;
	private Integer villageID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "villageID")
	private DistrictBranchMapping districtBranchMapping;
	private Short feedbackTypeID;
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "feedbackTypeID")
	private M_FeedbackType m_feedbackType;*/

	private String remarks;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer serviceID;

	@Expose
	@Column(name = "IsSelf")
	private Boolean isSelf;

	@Expose
	private String patientName;
	@Expose
	private Integer patientAge;
	@Expose
	private Short patientGenderID;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	/*
	 * @Expose
	 * 
	 * @Column(name = "Processed",insertable = false, updatable = true) private String processed;
	 */
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public String toString()
	{
		return new Gson().toJson(this);
	}

}
