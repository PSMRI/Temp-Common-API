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

import lombok.Data;

/**
 * UserNotificationStatusShortDisplayDTO: Contract Outgoing Outgoing DTO that will have information necessary to display
 * details of all alert types and counts against each. This DTO will be sent every time the user reaches the Dashboard -
 * either via a login, re-login and/or closing a call.
 * 
 * Details available in this are: 1. User ID 2. User Name 3. List of: a. Notification Type b. Count of Unread for that
 * Notification Type
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationCountDTO
{
	private Integer userId;
	private String userName;
	private List<AlertAndNotificationCount> userNotificationTypeList;
}
