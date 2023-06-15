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
package com.iemr.common.model.userbeneficiary;

import com.google.gson.annotations.Expose;

import lombok.Data;

public @Data class DistrictModel
{
	// @Autowired
	// LocationDistrictRepository locationDistrictRepository;
	//
	// @Autowired
	// DistrictMapper districtMapper;

	@Expose
	private Integer districtID;
	// private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	// private List<InstituteModel> institutes;
	@Expose
	private Integer stateID;
	@Expose
	private String districtName;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
	@Expose
	private StateModel stateModel;

	// public static DistrictModel createDistrict(Integer districtID,
	// LocationDistrictRepository locationDistrictRepository, DistrictMapper districtMapper)
	// {
	// DistrictModel district = new DistrictModel();
	// district = districtMapper.DistrictToModel(locationDistrictRepository.findOne(districtID));
	// return district;
	// }
}
