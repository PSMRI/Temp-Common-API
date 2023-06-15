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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@ValidateOnExecution
@Entity
@Table(name = "m_EmergencyContacts")
@Data
public class EmergencyContacts
{
	@Transient
	OutputMapper mapper = new OutputMapper();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmergContactID")
	@Expose
	private Integer emergContactID;
	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	private Designation designation;

	@Size(max = 15)
	@Column(name = "EmergContactName")
	@Expose
	private String emergContactName;
	@Size(max = 15)
	@Column(name = "EmergContactNo")
	@Expose
	private String emergContactNo;
	@Size(max = 50)
	@Column(name = "EmergContactDesc")
	@Expose
	private String emergContactDesc;
	@Size(max = 100)
	@Column(name = "Location")
	@Expose
	private String location;
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	@Expose
	private ProviderServiceMapping providerServiceMapping;

	@Column(name = "NotificationTypeID")
	@Expose
	private Integer notificationTypeID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NotificationTypeID", insertable = false, updatable = false)
	@Expose
	private NotificationType notificationType;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "Processed", insertable = false, updatable = false)
	@Expose
	private String processed;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	@Expose
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;

	@Override
	public String toString()
	{
		return mapper.gson().toJson(this, EmergencyContacts.class);
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public Integer getNotificationTypeID()
	{
		return notificationTypeID;
	}

	public EmergencyContacts()
	{
	}

	public Integer getEmergContactID()
	{
		return emergContactID;
	}

	public Integer getDesignationID()
	{
		return designationID;
	}

	public String getEmergContactNo()
	{
		return emergContactNo;
	}

	public String getEmergContactDesc()
	{
		return emergContactDesc;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public String getEmergContactName()
	{
		return emergContactName;
	}

	public String getLocation()
	{
		return location;
	}

	public EmergencyContacts(Integer emergContactID, Integer designationID, String emergContactName,
			String emergContactNo, String emergContactDesc, Integer providerServiceMapID,
			ProviderServiceMapping providerServiceMapping, Integer notificationTypeID,
			NotificationType notificationType, String location, Boolean deleted, Timestamp createdDate,
			Designation designation)
	{
		this.emergContactID = emergContactID;
		this.designationID = designationID;
		this.emergContactName = emergContactName;
		this.emergContactNo = emergContactNo;
		this.emergContactDesc = emergContactDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.providerServiceMapping = providerServiceMapping;
		this.notificationTypeID = notificationTypeID;
		this.notificationType = notificationType;
		this.location = location;
		this.deleted = deleted;
		this.createdDate = createdDate;
		this.designation = designation;
	}

	public static EmergencyContacts initializeEmergencyContacts(Integer emergContactID, Integer designationID,
			String emergContactName, String emergContactNo, String emergContactDesc, Integer providerServiceMapID,
			ProviderServiceMapping providerServiceMapping, Integer notificationTypeID,
			NotificationType notificationType, String location, Boolean deleted, Timestamp createdDate,
			Designation designation)
	{
		EmergencyContacts emergencyContacts = new EmergencyContacts();
		emergencyContacts.emergContactID = emergContactID;
		emergencyContacts.designationID = designationID;
		emergencyContacts.emergContactName = emergContactName;
		emergencyContacts.emergContactNo = emergContactNo;
		emergencyContacts.emergContactDesc = emergContactDesc;
		emergencyContacts.providerServiceMapID = providerServiceMapID;
		emergencyContacts.providerServiceMapping = providerServiceMapping;
		emergencyContacts.notificationTypeID = notificationTypeID;
		emergencyContacts.notificationType = notificationType;
		emergencyContacts.location = location;
		emergencyContacts.deleted = deleted;
		emergencyContacts.createdDate = createdDate;
		emergencyContacts.designation = designation;
		return emergencyContacts;
	}

	@Override
	public boolean equals(Object obj)
	{
		String thisStr = this.toString();
		String objStr = null;
		if(obj != null) {
		objStr = obj.toString();
		}
		if (thisStr.equalsIgnoreCase(objStr))
		{
			return true;
		}
		return false;
		
	}
	
	@Override
	  public int hashCode() {
		return 0;
	    /* ... */
	  }

}
