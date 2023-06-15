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

import java.util.List;
import java.util.Set;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.CommonIdentityDTO;
import com.iemr.common.dto.identity.Contact;
import com.iemr.common.dto.identity.Identity;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

@Mapper(componentModel = "spring", imports = { Contact.class, Identity.class })
@DecoratedWith(CommonIdentityMapperDecorator.class)
public interface CommonIdentityMapper
{

	CommonIdentityMapper INSTANCE = Mappers.getMapper(CommonIdentityMapper.class);

	@Mappings({ @Mapping(expression = "java(beneficiary.getStatus().getStatus())", target = "status"),
			@Mapping(expression = "java(beneficiary.getMaritalStatus().getStatus())", target = "maritalStatus"), })
	CommonIdentityDTO beneficiaryModelCommonIdentityDTO(BeneficiaryModel beneficiary);

	@Mappings({

			@Mapping(source = "benPhoneMap.benRelationshipID", target = "relationshipID"),
			// @Mapping(source = "benPhoneMap.phoneTypeName", target =
			// "relationshipToSelf"),
			@Mapping(source = "benPhoneMap.parentBenRegID", target = "associatedBenRegId")
			// @Mapping(source = "beneficiary.modifiedBy", target =
			// "modifiedBy"),
			// @Mapping(source = "beneficiary.lastModDate",
			// target="lastModDate")
	})
	BenFamilyDTO benPhoneMapModelToBenFamilyDTO(BenPhoneMapModel benPhoneMap);

	Set<BenFamilyDTO> benPhoneMapListToBenFamilyDTOList(List<BenPhoneMapModel> benPhoneMaps);
}
