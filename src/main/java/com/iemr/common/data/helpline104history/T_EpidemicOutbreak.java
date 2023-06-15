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
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name = "T_EpidemicOutbreak")
public class T_EpidemicOutbreak {
	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outbreakComplaintID;
	@Expose
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	/*
	 * @Expose
	 * 
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(updatable = false, insertable = false, name = "benCallID")
	 * private BenCall benCall;
	 */
	@Expose
	private Long beneficiaryRegID;
	@Expose
	private String natureOfComplaint;
	@Expose
	private Integer totalPeopleAffected;
	@Expose
	private Integer affectedDistrictID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "affectedDistrictID")
	private Districts m_district;
	@Expose
	private Integer affectedDistrictBlockID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "affectedDistrictBlockID")
	private DistrictBlock m_districtblock;
	@Expose
	private Integer affectedVillageID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "affectedVillageID")
	private DistrictBranchMapping districtBranchMapping;
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

	public T_EpidemicOutbreak() {
		super();
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
