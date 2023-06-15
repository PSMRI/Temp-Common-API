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

import com.iemr.common.model.userbeneficiary.StatusModel;

import lombok.Data;

public @Data class ProviderServiceMappingModel
{
	private Integer providerServiceMapID;
	// private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	// private List<NotificationModel> notificationModels;
	// private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModel;
	// private List<ScreenModel> screens;
	// private List<DirectoryModel> directories;
	// private List<FeedbackTypeModel> feedbacks;
	// private List<FeedbackSeverityModel> feedbackSeverities;
	// private List<EmergencyContactsModel> emergencyContacts;
	// private List<PhoneBlockModel> blockNumbers;
	private Short serviceProviderID;
	private ServiceProviderModel serviceProvider;
	private Short serviceID;
	private ServiceMasterModel ServiceMaster;
	private Integer countryID;
	private Integer stateID;
	private Integer districtID;
	private Integer cityID;
	private Integer districtBlockID;
	private String address;
	private String ctiCampaignName;
	private Integer statusID;
	private StatusModel status;
	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
