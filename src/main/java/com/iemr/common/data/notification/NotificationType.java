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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_notificationtype")
@Data
public class NotificationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationTypeID")
	@Expose
	private Integer notificationTypeID;
	@OneToMany(mappedBy = "notificationType", fetch = FetchType.LAZY)
	@Transient
	private List<Notification> notifications;
	@OneToMany(mappedBy = "notificationType", fetch = FetchType.LAZY)
	@Transient
	private List<EmergencyContacts> emergencyContacts;

	@Column(name = "NotificationType")
	@Expose
	private String notificationType;

	@Column(name = "NotificationTypeDesc")
	@Expose
	private String notificationTypeDesc;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;

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

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public Integer getNotificationTypeID() {
		return notificationTypeID;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public String getNotificationTypeDesc() {
		return notificationTypeDesc;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public NotificationType() {
	}

	public static NotificationType initializeNotificationTypes(Integer notificationTypeID, String notificationTypeName,
			String notificationTypeDesc, Boolean deleted) {
		// notificationTypeID, notificationType, notificationTypeDesc, deleted
		NotificationType notificationType = new NotificationType();
		notificationType.notificationTypeID = notificationTypeID;
		notificationType.notificationType = notificationTypeName;
		notificationType.notificationTypeDesc = notificationTypeDesc;
		notificationType.deleted = deleted;
		return notificationType;
	}
}
