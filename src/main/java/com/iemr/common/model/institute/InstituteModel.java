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
package com.iemr.common.model.institute;

import com.iemr.common.model.userbeneficiary.DistrictBlockModel;
import com.iemr.common.model.userbeneficiary.DistrictBranchModel;
import com.iemr.common.model.userbeneficiary.DistrictModel;
import com.iemr.common.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class InstituteModel
{
	private Integer institutionID;
	// private List<InstituteDirectoryMapping> instituteDirectory;
	// private List<FeedbackDetailsModel> feedbackDetailsModel;
	private String institutionName;
	private Integer stateID;
	private StateModel stateModels;
	private Integer districtID;
	private DistrictModel district;
	private Integer blockID;
	private DistrictBlockModel districtBlock;
	private Integer districtBranchMappingID;
	private DistrictBranchModel m_districtbranchmapping;
	private String govtInstituteID;
	private String address;
	private String contactPerson1;
	private String contactPerson1_Email;
	private String contactNo1;
	private String contactPerson2;
	private String contactPerson2_Email;
	private String contactNo2;
	private String contactPerson3;
	private String contactPerson3_Email;
	private String contactNo3;
	private String website;
	private Integer providerServiceMapID;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
