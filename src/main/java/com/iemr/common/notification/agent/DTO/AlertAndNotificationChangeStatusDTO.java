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
 * UserNotficationStatusChangeDTO: Contract Incoming
 * 		DTO to handle INCOMING request to change Notification Status for a particular User.
 * 		Following operations are allowed:
 * 			1. Mark single Notification or a list of Notifications (notficationStatus = "read")
 * 			2. Unmark single Notification or a list of Notifications (notficationStatus = "unread")
 * 			3. Delete single Notification or a list of Notifications (notficationStatus = "delete")
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
public class AlertAndNotificationChangeStatusDTO
{
	private String notficationStatus;
	private List<Integer> userNotificationMapIDList;

}
