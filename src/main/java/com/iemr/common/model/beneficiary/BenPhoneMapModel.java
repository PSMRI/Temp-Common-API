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
package com.iemr.common.model.beneficiary;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.dto.identity.Phone;
import com.iemr.common.mapper.RelationshipMapper;
import com.iemr.common.model.userbeneficiary.PhoneTypeModel;

import lombok.Data;

public @Data class BenPhoneMapModel {
	@Expose
	private Long benPhMapID;
	@Expose
	private Long benificiaryRegID;
	// private BeneficiaryModel beneficiaryModel;
	@Expose
	private Long parentBenRegID;
	// private BeneficiaryModel parentBeneficiary;
	@Expose
	private Integer benRelationshipID;
	@Expose
	private BenRelationshipTypeModel benRelationshipType;
	@Expose
	private String phoneNo;
	@Expose
	private Integer phoneTypeID;
	@Expose
	private String phoneTypeName;
	@Expose
	private PhoneTypeModel phoneType;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	@Expose
	private Timestamp createdDate;
	@Expose
	private String modifiedBy;
	@Expose
	private Timestamp lastModDate;
	// private Integer nuisanceCallCount = 0;

	// new column added for data sync
	// 17-06-2018
	@Expose
	private Integer vanID;
	@Expose
	private Integer parkingPlaceID;
	// END OF new column added for data sync

	@Expose
	private String alternateContactNumber;

	public static BenPhoneMapModel createBenPhoneMap(Long benPhMapID, Long benificiaryRegID, Long parentBenRegID,
			Integer benRelationshipID, String phoneNo) {
		BenPhoneMapModel model = new BenPhoneMapModel();
		model.benPhMapID = benPhMapID;
		model.benificiaryRegID = benificiaryRegID;
		model.parentBenRegID = parentBenRegID;
		model.benRelationshipID = benRelationshipID;
		model.phoneNo = phoneNo;
		return model;
	}

	public static List<BenPhoneMapModel> createBenPhoneMaps(BeneficiariesDTO beneficiariesDTO,
			RelationshipMapper relationshipMapper) {
		List<BenFamilyDTO> familyMembers = beneficiariesDTO.getBeneficiaryFamilyTags();
		List<Phone> phones = beneficiariesDTO.getContacts();
		BigInteger benificiaryRegID = beneficiariesDTO.getBenRegId();
		List<BenPhoneMapModel> models = new ArrayList<BenPhoneMapModel>();
		if (phones != null) {
			for (BenFamilyDTO benFamilyDTO : familyMembers) {
				for (int phoneIdx = 0; phones.size() > phoneIdx; phoneIdx++) {
					BenPhoneMapModel model = new BenPhoneMapModel();
					Phone phone = phones.get(phoneIdx);
					model.benPhMapID = Long.parseLong(benFamilyDTO.getBenFamilyMapId().toString());
					model.benificiaryRegID = Long.parseLong(benificiaryRegID.toString());
					if (benFamilyDTO.getAssociatedBenRegId() != null) {
						model.parentBenRegID = Long.parseLong(benFamilyDTO.getAssociatedBenRegId().toString());
					} else {
						model.parentBenRegID = Long.parseLong(benificiaryRegID.toString());
					}
					model.benRelationshipID = benFamilyDTO.getRelationshipID();
					if (benFamilyDTO.getRelationshipID() != null) {
						model.setBenRelationshipType(
								relationshipMapper.createRelationshipTypesByID(benFamilyDTO.getRelationshipID()));
					}
					model.phoneNo = phone.getPhoneNum();
					models.add(model);
				}
			}
		}

		return models;
	}
}
