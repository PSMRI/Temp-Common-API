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

import java.sql.Timestamp;
import java.util.List;

import com.iemr.common.model.userbeneficiary.LanguageModel;

import lombok.Data;

public @Data class NotificationModel
{
	private Integer notificationID;
	private String notification;
	private String notificationDesc;
	private Integer notificationTypeID;
	private NotificationTypeModel notificationType;
	private Integer roleID;
	private RoleModel role;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Timestamp validTill;
	private Timestamp validFrom;
	private Integer kmFileManagerID;
	private KMFileManagerModel kmFileManager;
	private Integer workingLocationID;
	private WorkLocationModel workingLocation;
	private List<Integer> workingLocationIDs;
	private Integer languageID;
	private LanguageModel language;
	private List<Integer> languageIDs;
	private Integer userID;
	private UserModel user;
	private List<Integer> userIDs;
	private Timestamp validStartDate;
	private Timestamp validEndDate;
	private String kmFilePath;

	private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
