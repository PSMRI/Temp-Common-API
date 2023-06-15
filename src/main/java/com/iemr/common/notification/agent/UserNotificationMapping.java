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
package com.iemr.common.notification.agent;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.notification.Notification;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

/**
 * 
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Data
@Entity
@Table(name = "m_usernotificationmap")
public class UserNotificationMapping
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserNotificationMapID")
	@Expose
	private Integer userNotificationMapID;

	@Column(name = "NotificationID")
	@Expose
	private Integer notificationID;

	@Column(name = "UserID")
	@Expose
	private Integer userID;

	@Column(name = "RoleID")
	@Expose
	private Integer roleID;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;

	@Column(name = "WorkingLocationID")
	@Expose
	private Integer workingLocationID;

	@Column(name = "NotificationState")
	@Expose
	private String notificationState;

	@Column(name = "NotificationTypeID")
	@Expose
	private Integer notificationTypeID;

	@Column(name = "NotificationType")
	@Expose
	private String notificationType;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	// @Transient
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NotificationID", insertable = false, updatable = false)
	@Expose
	private Notification notification;

	@Override
	public String toString()
	{
		// OutputMapper mapper = new OutputMapper();
		// System.out.println(OutputMapper.gson().toJson(this));
		// return new Gson().toJson(this);
		return OutputMapper.gson().toJson(this);
	}

}