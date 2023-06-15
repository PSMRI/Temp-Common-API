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
package com.iemr.common.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.dto.identity.Phone;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;

public abstract class BenPhoneMapperDecorator implements BenPhoneMapper {
	@Autowired
	RelationshipMapper relationshipMapper;

	public List<BenPhoneMapModel> benPhoneMapToResponseByID(BeneficiariesDTO beneficiariesDTO) {
		List<BenFamilyDTO> familyMembers = beneficiariesDTO.getBeneficiaryFamilyTags();
		List<Phone> phones = beneficiariesDTO.getContacts();
		BigInteger benificiaryRegID = beneficiariesDTO.getBenRegId();
		List<BenPhoneMapModel> models = new ArrayList<BenPhoneMapModel>();
		StringBuffer phoneNo;
		if (phones != null) {
			for (BenFamilyDTO benFamilyDTO : familyMembers) {
				for (int phoneIdx = 0; phones.size() > phoneIdx; phoneIdx++) {
					phoneNo = new StringBuffer();
					BenPhoneMapModel model = new BenPhoneMapModel();
					// alter contact no / emergency contact no
					if (beneficiariesDTO.getEmergencyContactNum() != null)
						model.setAlternateContactNumber(beneficiariesDTO.getEmergencyContactNum());

					Phone phone = phones.get(phoneIdx);
					model.setBenPhMapID(Long.parseLong(benFamilyDTO.getBenFamilyMapId().toString()));
					model.setBenificiaryRegID(Long.parseLong(benificiaryRegID.toString()));
					if (benFamilyDTO.getAssociatedBenRegId() != null) {
						model.setParentBenRegID(Long.parseLong(benFamilyDTO.getAssociatedBenRegId().toString()));
					} else {
						model.setParentBenRegID(Long.parseLong(benificiaryRegID.toString()));
					}
					model.setBenRelationshipID(benFamilyDTO.getRelationshipID());
					if (benFamilyDTO.getRelationshipID() != null) {
						model.setBenRelationshipType(
								relationshipMapper.createRelationshipTypesByID(benFamilyDTO.getRelationshipID()));
					}

					if (phone.getPhoneNum() != null && phone.getPhoneNum().length() > 10)
						phoneNo = new StringBuffer(phone.getPhoneNum().substring(phone.getPhoneNum().length() - 10));
					else if (phone.getPhoneNum() != null)
						phoneNo = new StringBuffer(phone.getPhoneNum());

//					model.setPhoneNo(phone.getPhoneNum());
					model.setPhoneNo(phoneNo.toString());

					models.add(model);
				}
			}
		}

		return models;
	}

}
