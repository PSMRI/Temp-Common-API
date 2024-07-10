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
package com.iemr.common.dto.identity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class IdentityEditDTO {

	private String eventTypeName; // created, reserved, registered, modified, deleted
	private Timestamp eventTypeDate;
	private Integer agentId;
	private String agentName;
	private Integer agentPSMapId; // ProviderServiceMapId
	private String agentComment;
	private Integer serviceId;
	private String serviceName;
	private Integer serviceProviderId;
	private String serviceProviderName;
	private Integer stateId;
	private String stateName;
	private Integer providerServiceMapId;
	private BigInteger beneficiaryId;
	private BigInteger beneficiaryRegId;

	// self details
	private Boolean changeInSelfDetails = false;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String spouseName;
	private Integer maritalStatusId;
	private Timestamp dob;
	private Integer genderId;
	private String gender;
	private String title;
	private Integer titleId;

	// self address
	private Boolean changeInAddress = false;
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;
	private Boolean isPermAddrSameAsCurrAddr;
	private Boolean isPermAddrSameAsEmerAddr;
	private Boolean isEmerAddrSameAsCurrAddr;
	private Boolean isEmerAddrSameAsPermAddr;
	private String addressType;

	// self contacts
	private Boolean changeInContacts = false;
	private String preferredPhoneNum;
	private String preferredPhoneTyp;
	private String preferredSMSPhoneNum;
	private String preferredSMSPhoneTyp;
	private String emergencyContactNum;
	private String emergencyContactTyp;
	private String preferredEmailId;
	private Contact contact;

	// self identities
	private Boolean changeInIdentities = false;
	private List<Identity> identities;

	// self details
	private Boolean changeInOtherDetails = false;
	private String preferredLanguage;
	private Integer preferredLanguageId;
	private String community;
	private Integer communityId;
	private String education;
	private Integer educationId;
	private String incomeStatus;
	private Integer incomeStatusId;
	private String occupation;
	private Integer occupationId;
	private String religion;
	private Integer religionId;
	private String placeOfWork;
	private String monthlyFamilyIncome;

	// family details
	private Boolean changeInFamilyDetails = false;
	private Boolean isEmergencyContact;
	private String relationshipToSelf;
	private Integer relationshipID;
	private BigInteger associatedBenRegId; // Family mapping must be a list
	Set<BenFamilyDTO> benFamilyDTOs;

	// MMU/TM details
	private Boolean changeInAssociations = false;
	private Integer zoneId;
	private Integer areaId;
	private BigInteger servicePointId;
	private Integer phcId;
	private String remarks;
	private String sourceOfInfo;
	private String status;
	private Integer statusId;

	private String healthCareWorkerType;
	private Integer healthCareWorkerId;

	// Start Outreach
	// New columns added for MMU integration 11-04-2018

	private Boolean changeInBankDetails = false;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String accountNo;
	private BigInteger benAccountID;

	private Boolean changeInBenImage = false;
	private String benImage;
	private Long benImageId;

	private String motherName;
	private String maritalStatus;
	private Timestamp marriageDate;
	private Integer ageAtMarriage;
	private String literacyStatus;
	// End Outreach

	// Start 1097
	private String isHIVPositive;
	private String sourceOfInformation;
	private Integer sexualOrientationID;
	private String sexualOrientationType;
	// End 1097

	// new column added for data sync
	// 17-06-2018
	@Expose
	private Integer vanID;
	@Expose
	private Integer parkingPlaceId;
	

	// END OF new column added for data sync
	private boolean emergencyRegistration;
	private String otherFields;
//	private Object otherFields;
}
