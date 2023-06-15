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

public @Data class StateModel
{
	@Expose
	private Integer stateID;
	// private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	@Expose
	private String stateName;
	@Expose
	private String stateCode;
	@Expose
	private Integer countryID;
	// private Boolean deleted;
	// private String createdBy;
	// private String modifiedBy;
	// private Timestamp createdDate;
	// private Timestamp lastModDate;
	// private Set<Districts> districts;
	// private Set<InstituteModel> institutes;

//	public static StateModel getState(Integer stateID, LocationStateRepository locationStateRepo,
//			StateMapper stateMapper2)
//	{
//		StateModel state = new StateModel();
//		state = stateMapper2.StateToModel(locationStateRepo.findByStateID(stateID));
//		return state;
//	}
}
