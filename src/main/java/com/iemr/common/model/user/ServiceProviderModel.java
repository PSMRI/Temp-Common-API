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
package com.iemr.common.model.user;

import java.sql.Date;

import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class ServiceProviderModel
{

	private Integer serviceProviderID;
	// private List<ProviderServiceMappingModel> providerServiceMappingModels;
	private String serviceProviderName;
	private Date joiningDate;
	private Integer stateID;
	private String logoFileName;
	private String logoFilePath;
	private String primaryContactName;
	private String primaryContactNo;
	private String primaryContactEmailID;
	private String primaryContactAddress;
	private Date primaryContactValidityTillDate;
	private String secondaryContactName;
	private String secondaryContactNo;
	private String secondaryContactEmailID;
	private String secondaryContactAddress;
	private Date secondaryContactValidityTillDate;
	private Integer statusID;
	private StatusModel status;
	private Date validFrom;
	private Date validTill;
	private Boolean deleted;
	// private String createdBy;
	// private Date createdDate;
	// private String modifiedBy;
	// private Date lastModDate;
}
