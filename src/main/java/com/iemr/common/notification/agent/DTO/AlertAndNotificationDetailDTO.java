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
package com.iemr.common.notification.agent.DTO;

import java.util.List;

import com.iemr.common.notification.agent.UserNotificationMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

/**
 * AlertAndNotificationDetailDTO: Contract Outgoing Outgoing DTO that will have information necessary to display details
 * of all alert types for a given user after the initial click on the "Alerts & Notifications" widget. Where the user
 * wants to look at individual alert types and may want to interact with them via actions such as Unmark, Delete, Mark.
 * 
 * Details available are: 1. User Id 2. User Name 3. List of: a. Notification Id b. Notification Message c. Notification
 * Type d. Notification Type Count e. Notification Status f. Notification Start Date g. Notification End Date h.
 * Notification Create Date i. Notification Created By
 * 
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationDetailDTO
{
	private Integer userId;
	private String userName;
	private List<UserNotificationMapping> userNotificationMappingList;

//	public void setUserNotificationMappingList (List<UserNotificationMapping> userNotificationMappingList) {
//		this.userNotificationMappingList = userNotificationMappingList;
//	}
//	
//	@Override
//	public String toString()
//	{
//		
//		return /*new Gson().toJson(this);*/ OutputMapper.gsonWithoutExposeRestriction().toJson(this);
//	}
}
