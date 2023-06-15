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

import lombok.Data;

/**
 * UserNotificationCreateDTO: Contract Incoming All data that is necessary for creating User Notification. This table
 * required to maintain state per user, regarding alerts and/or notifications that have been read, unread, deleted.
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class UserNotificationCreateDTO
{
	private Integer notificationID;
	private Integer userID;
	private Integer roleID;
	private Integer providerServiceMapID;
	private String notificationState;
	private String createdBy;
	private String modifiedBy;
	private Boolean deleted;
}