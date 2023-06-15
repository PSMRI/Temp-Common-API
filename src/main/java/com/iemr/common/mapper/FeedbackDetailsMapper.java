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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.model.feedback.FeedbackDetailsModel;
import com.iemr.common.model.userbeneficiary.SexualOrientationModel;
import com.iemr.common.repository.userbeneficiarydata.SexualOrientationRepository;

@Mapper(componentModel = "spring", imports = { SexualOrientationModel.class })
public interface FeedbackDetailsMapper
{
	FeedbackDetailsMapper INSTANCE = Mappers.getMapper(FeedbackDetailsMapper.class);

	@Mappings({ @Mapping(target = "beneficiary.sexualOrientation", ignore = true
			// , source = "feedbackDetailsObj.beneficiary.sexualOrientation"
			), })
	FeedbackDetailsModel feedbackDetailsToLoginRole(FeedbackDetails feedbackDetailsObj,
			SexualOrientationRepository sexualOrientationRepository, SexualOrientationMapper sexualOrientationMapper);

	// @IterableMapping(elementTargetType = FeedbackDetailsModel.class)
	// List<FeedbackDetailsModel> feedbackDetailsToLoginRole(List<FeedbackDetails> feedbackDetailsObj);
}