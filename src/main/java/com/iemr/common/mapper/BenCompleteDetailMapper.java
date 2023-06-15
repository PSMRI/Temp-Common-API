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

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.dto.identity.BeneficiariesDTO;
import com.iemr.common.model.beneficiary.BenPhoneMapModel;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.common.model.beneficiary.BeneficiaryModel;
import com.iemr.common.model.user.TitleModel;
import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;
import com.iemr.common.model.userbeneficiary.GenderModel;
import com.iemr.common.model.userbeneficiary.GovtIdentityTypeModel;
import com.iemr.common.model.userbeneficiary.MaritalStatusModel;
import com.iemr.common.model.userbeneficiary.SexualOrientationModel;
import com.iemr.common.model.userbeneficiary.StateModel;

@Mapper(componentModel = "spring", imports = { BenPhoneMapModel.class, StateModel.class,
		BeneficiaryDemographicsModel.class, TitleModel.class, GenderModel.class, MaritalStatusModel.class,
		SexualOrientationModel.class, GovtIdentityTypeModel.class, BeneficiaryIdentityModel.class })
@DecoratedWith(BenCompleteDetailMapperDecorator.class)
public interface BenCompleteDetailMapper {
	BenCompleteDetailMapper INSTANCE = Mappers.getMapper(BenCompleteDetailMapper.class);

	@Mappings({ @Mapping(source = "beneficiariesDTO.benRegId", target = "beneficiaryRegID"),
			@Mapping(source = "beneficiariesDTO.benId", target = "beneficiaryID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.titleId", target = "titleId"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.firstName", target = "firstName"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.middleName", target = "middleName"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.lastName", target = "lastName"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.genderId", target = "genderID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.fatherName", target = "fatherName"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.maritalStatusId", target = "maritalStatusID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.dob", target = "DOB"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.spouseName", target = "spouseName"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.createdBy", target = "createdBy"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.createdDate", target = "createdDate"),

			@Mapping(expression = "java(beneficiariesDTO.getBeneficiaryDetails().getSexualOrientationID())", target = "sexualOrientationID"),
			@Mapping(expression = "java(GovtIdentityTypeModel.getIdentityTypeNo(beneficiariesDTO.getBeneficiaryIdentites()))", target = "govtIdentityTypeID"),
			@Mapping(expression = "java(GovtIdentityTypeModel.getIdentityNo(beneficiariesDTO.getBeneficiaryIdentites()))", target = "govtIdentityNo"),
			// Start MMU mappings
			@Mapping(source = "beneficiariesDTO.marriageDate", target = "marriageDate"),
			@Mapping(source = "beneficiariesDTO.ageAtMarriage", target = "ageAtMarriage"),
			@Mapping(source = "beneficiariesDTO.literacyStatus", target = "literacyStatus"),
			@Mapping(source = "beneficiariesDTO.motherName", target = "motherName"),
			@Mapping(source = "beneficiariesDTO.email", target = "email"),
			@Mapping(source = "beneficiariesDTO.bankName", target = "bankName"),
			@Mapping(source = "beneficiariesDTO.branchName", target = "branchName"),
			@Mapping(source = "beneficiariesDTO.ifscCode", target = "ifscCode"),
			@Mapping(source = "beneficiariesDTO.accountNo", target = "accountNo"),
			@Mapping(source = "beneficiariesDTO.benAccountID", target = "benAccountID"),
			@Mapping(source = "beneficiariesDTO.benImageID", target = "benImageId"),

			// D2D, 20-01-2021
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.houseHoldID", target = "houseHoldID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.guideLineID", target = "guideLineID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.rchID", target = "rchID"),

			@Mapping(expression = "java(BeneficiaryModel.setAge("
					+ "beneficiariesDTO.getBeneficiaryDetails().getBeneficiaryAge(), beneficiariesDTO.getBeneficiaryAge()))", target = "age"),
			@Mapping(expression = "java(beneficiariesDTO.getBeneficiaryDetails().getSourceOfInfo())", target = "sourceOfInformation"),
			@Mapping(expression = "java(beneficiariesDTO.getBeneficiaryDetails().getIsHIVPositive())", target = "isHIVPos"),
			@Mapping(expression = "java(beneficiariesDTO.getBeneficiaryDetails().getPlaceOfWork())", target = "placeOfWork"),
			@Mapping(expression = "java(beneficiariesDTO.getBeneficiaryDetails().getRemarks())", target = "remarks"),
			@Mapping(expression = "java(BeneficiaryModel.actualAge(beneficiariesDTO.getBeneficiaryDetails().getDob()))", target = "actualAge"),
			@Mapping(expression = "java(BeneficiaryModel.ageUnits(beneficiariesDTO.getBeneficiaryDetails().getDob()))", target = "ageUnits"),
			// End 1097
			
			
			// family tagging, HWC
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.familyId", target = "familyId"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.headOfFamily_RelationID", target = "headOfFamily_RelationID"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.headOfFamily_Relation", target = "headOfFamily_Relation"),
			@Mapping(source = "beneficiariesDTO.beneficiaryDetails.other", target = "other"),


	})
	BeneficiaryModel benDetailForOutboundDTOToIBeneficiary(BeneficiariesDTO beneficiariesDTO);

	// @IterableMapping(elementTargetType = BeneficiaryModel.class)
	// List<BeneficiaryModel>
	// BenDetailForOutboundDTOToI_Beneficiary(List<BeneficiariesDTO>
	// beneficiariesDTOList);

	SexualOrientationModel createSexualOrientationData(Short sexualOrientationID);

	BeneficiaryDemographicsModel createBenDemographicsModel(BeneficiariesDTO beneficiariesDTO);

}
