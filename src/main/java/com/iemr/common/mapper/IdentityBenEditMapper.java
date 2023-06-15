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

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.dto.identity.Address;
import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.Contact;
import com.iemr.common.dto.identity.Identity;
import com.iemr.common.dto.identity.IdentityEditDTO;
import com.iemr.common.dto.identity.IdentitySearchDTO;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

@Mapper(componentModel = "spring", imports = { Address.class, BenFamilyDTO.class, Contact.class, Identity.class })
@DecoratedWith(IdentityBenEditMapperDecorator.class)
public interface IdentityBenEditMapper
{

	IdentityBenEditMapper INSTANCE = Mappers.getMapper(IdentityBenEditMapper.class);

	@Mappings({ @Mapping(expression = "java(beneficiary.getStatus().getStatus())", target = "status"),
			@Mapping(expression = "java(beneficiary.getMaritalStatus().getStatus())", target = "maritalStatus"), })
	IdentityEditDTO BenToIdentityEditMapper(BeneficiaryModel beneficiary);

	@IterableMapping(elementTargetType = IdentityEditDTO.class)
	List<IdentityEditDTO> benToIdentityEditMapperList(List<BeneficiaryModel> beneficiaryModelList);

	@Mappings({
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "currentAddress"),
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "permanentAddress"),
			@Mapping(expression = "java(Address.bendemographicsAddressMapper(beneficiary.getI_bendemographics()))",
					target = "emergencyAddress"),
			@Mapping(source = "beneficiary.firstName", target = "firstName"),
			@Mapping(source = "beneficiary.lastName", target = "lastName"),
			@Mapping(source = "beneficiary.genderID", target = "genderId"),})
	IdentitySearchDTO getidentitysearchModel(BeneficiaryModel beneficiary);
}
