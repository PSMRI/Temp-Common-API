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

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.model.feedback.FeedbackListRequestModel;
import com.iemr.common.model.feedback.FeedbackListResponseModel;

@Mapper(componentModel = "spring")
public interface FeedbackListMapper
{
	FeedbackListMapper INSTANCE = Mappers.getMapper(FeedbackListMapper.class);

	@Mappings({ @Mapping(source = "feedbackDetailsObj.feedbackRequests", target = "feedbackRequests"),
			@Mapping(source = "feedbackDetailsObj.feedbackResponses", target = "feedbackResponses"),
			@Mapping(source = "feedbackDetailsObj.consolidatedRequests", target = "consolidatedRequests"),
			@Mapping(ignore = true, target = "beneficiary.sexualOrientation"), 
			@Mapping(source = "feedbackDetailsObj.requestID", target = "requestID"),
			@Mapping(source = "feedbackDetailsObj.feedbackNatureID", target = "feedbackNatureID"),})
	FeedbackListResponseModel feedbackDetailsToResponse(FeedbackDetails feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackListResponseModel.class)
	List<FeedbackListResponseModel> feedbackDetailsToResponse(List<FeedbackDetails> feedbackDetailsObj);

	FeedbackDetails requestToFeedbackDetails(FeedbackListRequestModel feedbackDetailsObj);

	@IterableMapping(elementTargetType = FeedbackDetails.class)
	List<FeedbackDetails> requestToFeedbackDetails(List<FeedbackListRequestModel> feedbackDetailsObj);
}