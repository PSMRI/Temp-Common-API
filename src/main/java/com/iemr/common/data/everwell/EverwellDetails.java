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
package com.iemr.common.data.everwell;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.OutboundCallRequest;
import com.iemr.common.data.everwell.Note;
import com.iemr.common.data.service.SubService;
import com.iemr.common.data.users.User;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

import lombok.Data;

@Entity
@Table(name = "t_everwellapi")
@Data
public class EverwellDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "EAPIID")
	private Long eapiId;
	@Expose
	@Column(name = "EverWellID")
	private Long Id;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegId;
	@Expose
	@Column(name = "Callid")
	private String callId;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapId;
	@Expose
	@Column(name = "firstName")
	private String FirstName;
	@Expose
	@Column(name = "lastName")
	private String LastName;
	@Expose
	@Column(name = "primaryNumber")
	private String PrimaryNumber;
	@Expose
	@Column(name = "missedDoses")
	private Integer MissedDoses;
	@Expose
	@Column(name = "facilityName")
	private String FacilityName;
	@Expose
	@Column(name = "state")
	private String State;
	@Expose
	@Column(name = "adherencePercentage")
	private Integer AdherencePercentage;
	@Expose
	@Column(name = "isRegistered")
	private Boolean isRegistered = false;
	@Expose
	@Column(name = "userid")
	private Integer agentId;
	@Expose
	@Column(name = "isAllocated")
	private Boolean isAllocated;
	@Expose
	@Column(name = "ActionTaken")
	private String actionTaken;
	@Expose
	@Column(name = "Category")
	private String category;
	@Expose
	@Column(name = "SubCategory")
	private String subCategory;
	@Expose
	@Column(name = "DateOfAction", insertable = false, updatable = false)
	private Timestamp dateOfAction;
	@Expose
	@Column(name = "Comments")
	private String comments;
	@Expose
	@Column(name = "statusUpdatedEverwell")
	private Boolean statusUpdatedEverwell;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted = false;
	@Expose
	@Column(name = "Processed")
	private String processed;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@Expose
	@Column(name = "VanSerialNo")
	private Integer vanSerialNo;
	@Expose
	@Column(name = "VanID")
	private Integer vanId;
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceId;
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;
	@Transient
	private List<Long> eapiIds;
	@Transient
	private Integer callTypeID;
//	@Transient
//	private String preferredLanguageName;
	@Transient
	private Integer requestedServiceID;
	@Transient
	private Integer assignedUserID;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	@Expose
	@Column(name = "Bencallid")
	private Long benCallID;
	@Expose
	@Column(name = "isCompleted")
	private Boolean isCompleted = false;
	@Expose
	@Column(name = "GenderName")
	private String Gender;
	@Expose
	@Column(name = "district")
	private String District;
	@Expose
	@Column(name = "BeneficiaryID")
	private Long beneficiaryID;
	@Expose
	@Column(name = "CurrentMonthMissedDoses")
	private Integer CurrentMonthMissedDoses;
	@Transient
	private Long PatientId;
	@Transient
	private Note note;
	@Transient
	private String AdherenceString;

	@Expose
	@Column(name = "Language")
	private String preferredLanguageName;
	@Transient
	@Expose
	private Timestamp filterStartDate;
	
	@Expose
    @Column(name = "retryNeeded")
    private Boolean retryNeeded;
   
    @Expose
    @Column(name = "callCounter")
    private Integer callCounter;

	@Transient
	@Expose
	private Timestamp filterEndDate;
	
	@Transient
	private String lastCall;
	
	@Expose
    @Column(name = "NoInfoDoseCount")
    private Integer NoInfoDoseCount;
	
	@Expose
    @Column(name = "NoInfoDoseDates ")
    private String noInfoDosesDates ;
	 
	@Transient
	private String NoInfoDoseDates[];
	
	public EverwellDetails getOutboundCall(Long EAPIID, Long BeneficiaryRegID, Integer ProviderServiceMapID,
			Long EverWellID, Integer AgentID, String firstName, String lastName, String primaryNumber,
			Timestamp LastModDate, Integer missedDoses, String facilityName, String state, Integer adherencePercentage,
			String actionTaken, String category, String subCategory, Timestamp dateOfAction, String comments,
			String createdBy, Timestamp createdDate, String gender, String district, Long BeneficiaryID,Integer currentMonthMissedDoses,
			Boolean retryNeeded, Integer callCounter,String lastCall,Integer noInfoDosesCount,String noInfoDosesDates) {
		this.eapiId = EAPIID;
		this.beneficiaryRegId = BeneficiaryRegID;
		this.beneficiaryID = BeneficiaryID;
		this.providerServiceMapId = ProviderServiceMapID;
		this.Id = EverWellID;
		this.agentId = AgentID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.PrimaryNumber = primaryNumber;
		this.lastModDate = LastModDate;
		// this.callId=callId;
		this.MissedDoses = missedDoses;
		this.CurrentMonthMissedDoses = currentMonthMissedDoses;
		this.FacilityName = facilityName;
		this.State = state;
		this.AdherencePercentage = adherencePercentage;
		this.actionTaken = actionTaken;
		this.category = category;
		this.subCategory = subCategory;
		this.dateOfAction = dateOfAction;
		this.comments = comments;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.Gender = gender;
		this.District = district;
		this.retryNeeded = retryNeeded;
		this.callCounter = callCounter;
		this.lastCall = lastCall;
		this.NoInfoDoseCount=noInfoDosesCount;
		this.noInfoDosesDates=noInfoDosesDates;
		return this;

	}

	public List<Long> getEAPIIDs() {
		return eapiIds;
	}

}
