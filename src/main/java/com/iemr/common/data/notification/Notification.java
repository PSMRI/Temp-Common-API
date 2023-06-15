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
package com.iemr.common.data.notification;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.Role;
import com.iemr.common.data.users.User;
import com.iemr.common.data.users.WorkLocation;
import com.iemr.common.notification.agent.UserNotificationMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_notification")
@Data
public class Notification
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationID")
	@Expose
	private Integer notificationID;

	@Column(name = "Notification")
	@Expose
	private String notification;

	@Column(name = "NotificationDesc")
	@Expose
	private String notificationDesc;

	@Column(name = "NotificationTypeID")
	@Expose
	private Integer notificationTypeID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NotificationTypeID", insertable = false, updatable = false)
	@Expose
	private NotificationType notificationType;

	@Column(name = "RoleID")
	@Expose
	private Integer roleID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleID", insertable = false, updatable = false)
	@Expose
	private Role role;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	@Expose
	private ProviderServiceMapping providerServiceMapping;

	@OneToMany(mappedBy = "notification")
	@Transient
	@Expose
	private List<UserNotificationMapping> userNotificationMappings;

	@Column(name = "ValidTill")
	@Expose
	private Timestamp validTill;

	@Column(name = "ValidFrom")
	@Expose
	private Timestamp validFrom;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "LastModDate", insertable = false, updatable = true)
	private Timestamp lastModDate;

	@Column(name = "KmFileManagerID")
	@Expose
	private Integer kmFileManagerID;
	@JoinColumn(name = "KmFileManagerID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	@Expose
	private KMFileManager kmFileManager;

	@Column(name = "WorkingLocationID")
	@Expose
	private Integer workingLocationID;
	@JoinColumn(name = "WorkingLocationID", insertable = false, updatable = false, referencedColumnName = "psAddMapID")
	@OneToOne(fetch = FetchType.LAZY)
	@Expose
	private WorkLocation workingLocation;
	@Transient
	@Expose
	private List<Integer> workingLocationIDs;

	@Column(name = "LanguageID")
	@Expose
	private Integer languageID;
	@JoinColumn(name = "LanguageID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	@Expose
	private Language language;
	@Transient
	@Expose
	private List<Integer> languageIDs;

	@Column(name = "UserID")
	@Expose
	private Integer userID;
	@JoinColumn(name = "UserID", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	@Expose
	private User user;
	@Transient
	@Expose
	private List<Integer> userIDs;

	@Transient
	private Timestamp validStartDate;

	@Transient
	private Timestamp validEndDate;

	@Transient
	@Expose
	private String kmFilePath;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Transient
	private List<Integer> roleIDs;

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public Integer getRoleID()
	{
		return roleID;
	}

	public Integer getNotificationID()
	{
		return notificationID;
	}

	public String getNotification()
	{
		return notification;
	}

	public String getNotificationDesc()
	{
		return notificationDesc;
	}

	public Integer getNotificationTypeID()
	{
		return notificationTypeID;
	}

	public Timestamp getValidTill()
	{
		return validTill;
	}

	public Timestamp getValidFrom()
	{
		return validFrom;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public List<Integer> getRoleIDs()
	{
		return roleIDs;
	}

	public Integer getKmFileManagerID()
	{
		return kmFileManagerID;
	}

	public Notification()
	{

	}

	public void setNotificationDesc(String notificationDesc)
	{
		this.notificationDesc = notificationDesc;
	}

	public void setKmFileManagerID(Integer kmFileManagerID)
	{
		this.kmFileManagerID = kmFileManagerID;
	}

	public KMFileManager getKmFileManager()
	{
		return kmFileManager;
	}

	public void setKmFileManager(KMFileManager kmFileManager)
	{
		this.kmFileManager = kmFileManager;
	}

	public Timestamp getValidStartDate()
	{
		return validStartDate;
	}

	public Timestamp getValidEndDate()
	{
		return validEndDate;
	}

	public static Notification initializeNotification(Integer notificationID, String notification,
			String notificationDesc, Integer notificationTypeID, NotificationType notificationType, Integer roleID,
			Role role, Integer providerServiceMapID, Timestamp validFrom, Timestamp validTill, Boolean deleted,
			Integer kmFileManagerID, KMFileManager kmFileManager, Integer workingLocationID,
			WorkLocation workingLocation, Integer languageID, Language language, Integer userID, User user)
	{
		Notification notificationObj = new Notification();
		notificationObj.notificationID = notificationID;
		notificationObj.notification = notification;
		notificationObj.notificationDesc = notificationDesc;
		notificationObj.notificationTypeID = notificationTypeID;
		notificationObj.notificationType = notificationType;
		notificationObj.roleID = roleID;
		notificationObj.role = role;
		notificationObj.providerServiceMapID = providerServiceMapID;
		notificationObj.validFrom = validFrom;
		notificationObj.validTill = validTill;
		notificationObj.deleted = deleted;
		notificationObj.kmFileManagerID = kmFileManagerID;
		notificationObj.kmFileManager = kmFileManager;
		notificationObj.workingLocationID = workingLocationID;
		notificationObj.workingLocation = workingLocation;
		notificationObj.languageID = languageID;
		notificationObj.language = language;
		notificationObj.userID = userID;
		notificationObj.user = user;
		return notificationObj;
	}

	public void setKMFilePath(String kmFilePath)
	{
		this.kmFilePath = kmFilePath;
	}

	public Integer getLanguageID()
	{
		return languageID;
	}

	public List<Integer> getLanguageIDs()
	{
		return languageIDs;
	}

	public Integer getUserID()
	{
		return userID;
	}

	public Integer getWorkingLocationID()
	{
		return workingLocationID;
	}

	public List<Integer> getWorkingLocationIDs()
	{
		return workingLocationIDs;
	}

	public List<Integer> getUserIDs()
	{
		return userIDs;
	}
}
