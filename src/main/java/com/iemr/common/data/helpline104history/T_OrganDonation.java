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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;


@Entity
@Data
@Table(name="T_OrganDonation")

public class T_OrganDonation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long organDonationID;
	@Expose
	private String requestID;	
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	/*@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "benCallID")
	private BenCall benCall; */
	@Expose
	private Long beneficiaryRegID;	
		
	@Expose
	@Column(name = "DonarName")
	private String donarName;
	@Expose
	private Integer donarAge;
	@Expose
	private Short donarGenderID;
	/*@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "donarGenderID")
	private M_Gender m_gender;*/
	@Expose
	private Integer donationTypeID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "donationTypeID")
	private M_DonationType m_donationType;
	@Expose
	private Integer donatableOrganID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "donatableOrganID")
	private M_DonatableOrgan m_donatableOrgan;
	@Expose
	private Integer acceptorHospitalID;
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	@Expose
	@Transient
	private Integer districtID;
	
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "IsSelf")
	private Boolean isSelf;	
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	@Expose
	private Date createdDate;
	private String modifiedBy;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
