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
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;

@Mapper(componentModel = "spring")
@DecoratedWith(BenPhoneMapperDecorator.class)
public interface BenPhoneMapper
{
	BenPhoneMapper INSTANCE = Mappers.getMapper(BenPhoneMapper.class);

	// @Mappings({
	// @Mapping(target="")
	// })
	BenPhoneMapModel benPhoneMapToResponse(BenPhoneMap benPhoneMap);

	@IterableMapping(elementTargetType = BenPhoneMapModel.class)
	List<BenPhoneMapModel> benPhoneMapToResponse(List<BenPhoneMap> benPhoneMap);
	
//	BenPhoneMapModel benPhoneMapToResponseByDTO(BeneficiariesDTO beneficiariesDTO);
//	
//	List<BenPhoneMapModel> benPhoneMapToResponseByID(BeneficiariesDTO beneficiariesDTO);

//	@IterableMapping(elementTargetType = BenPhoneMapModel.class)
//	List<List<BenPhoneMapModel>> benPhoneMapToResponseByID(List<BeneficiariesDTO> beneficiariesDTO);

	// @Mappings({ @Mapping(source = "benFamilyDTO.benFamilyMapId", target = "benPhMapID"),
	// @Mapping(source = "benFamilyDTO.associatedBenRegId", target = "parentBenRegID"),
	// @Mapping(source = "benFamilyDTO.relationshipID", target = "benRelationshipID"),
	// @Mapping(source = "phone.phoneType", target = "benRelationshipID"),
	// @Mapping(source = "phone.relationshipID", target = "benRelationshipID"),
	// // @Mapping(source="benFamilyDTO.benFamilyMapId", target=""),
	// })
	// BenPhoneMapModel benPhoneMapToResponse(BenFamilyDTO benFamilyDTO, Phone phone, Long benRegID);

	// @IterableMapping(elementTargetType=BenPhoneMapModel.class)

	// @Mappings({ @Mapping(target=) })
	// List<BenPhoneMapModel> benPhoneMapToResponse(List<BenFamilyDTO> benFamilyDTO, List<Phone> phone, Long benRegID);

}
