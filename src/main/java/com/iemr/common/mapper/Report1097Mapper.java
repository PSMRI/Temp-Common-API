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

import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.UnBlockedPhoneReport;
import com.iemr.common.model.reports.Report1097RequestModel;
import com.iemr.common.model.reports.Report1097ResponseModel;
import com.iemr.common.model.reports.UnBlockedUserReport;

@Mapper(componentModel = "spring")
public interface Report1097Mapper
{
	Report1097Mapper INSTANCE = Mappers.getMapper(Report1097Mapper.class);

	@Mappings({ @Mapping(target = "title", expression = "java(report.getBenReport().getTitle())"),
			@Mapping(target = "beneficiaryID", expression = "java(report.getBenReport().getBeneficiaryID())"),
			@Mapping(target = "gender", expression = "java(report.getBenReport().getGender())"),
			@Mapping(target = "maritalStatus", expression = "java(report.getBenReport().getMaritalStatus())"),
			@Mapping(target = "dob", expression = "java(report.getBenReport().getDobAsString())"),
			@Mapping(target = "age", expression = "java(report.getBenReport().getAge())"),
			@Mapping(target = "sexualOrientation", expression = "java(report.getBenReport().getSexualOrientation())"),
			@Mapping(target = "education", expression = "java(report.getBenReport().getEducation())"),
			@Mapping(target = "occupation", expression = "java(report.getBenReport().getOccupation())"),
			@Mapping(target = "preferredLanguage", expression = "java(report.getBenReport().getPreferredLanguage())"),
			@Mapping(target = "placeOfWork", expression = "java(report.getBenReport().getPlaceOfWork())"),
			@Mapping(target = "district", expression = "java(report.getBenReport().getDistrict())"),
//			@Mapping(target = "callType", expression = "java(report.getCallType())"),
//			@Mapping(target = "callSubType", expression = "java(report.getCallSubType())"),
			@Mapping(target = "state", expression = "java(report.getBenReport().getState())"),
			@Mapping(target = "subDistrict", expression = "java(report.getBenReport().getSubDistrict())"),
			@Mapping(target = "benCreatedDate", expression = "java(report.getBenReport().getBenCreatedDate())"),
			@Mapping(target = "beneficiaryCreatedBy",
					expression = "java(report.getBenReport().getBeneficiaryCreatedBy())"),
			// @Mapping(target = "isHIVPositive", expression =
			// "java(report.getBenReport().getIsHIVPositive(report.getBenReport().getIsHIVPos()))"),
			// @Mapping(target = "isHIVPos", expression =
			// "java(report.getBenReport().getIsHIVPositive(report.getBenReport().getIsHIVPos()))"),
			@Mapping(target = "feedback",
					expression = "java((report.getFeedback() != null) ? report.getFeedback().getFeedback() : null)"),
			@Mapping(target = "isCalledEarlier", expression = "java(report.getIsCalledEarlier())"),
			@Mapping(target = "isOutbound", expression = "java(report.checkOutbound())"), })
	Report1097ResponseModel crmReportsToResponse(CallDetailsReport report);

	@IterableMapping(elementTargetType = Report1097ResponseModel.class)
	List<Report1097ResponseModel> crmReportsToResponse(List<CallDetailsReport> reports);

	@Mappings({ @Mapping(target = "benReport.title", source = "title"),
			@Mapping(target = "benReport.gender", source = "gender"),
			@Mapping(target = "benReport.maritalStatus", source = "maritalStatus"),
			@Mapping(target = "benReport.sexualOrientation", source = "beneficiarySexualOrientation"),
			@Mapping(target = "benReport.education", source = "education"),
			@Mapping(target = "benReport.occupation", source = "occupation"),
			@Mapping(target = "benReport.preferredLanguage", source = "beneficiaryPreferredLanguage"),
			@Mapping(target = "benReport.placeOfWork", source = "placeOfWork"),
			@Mapping(target = "benReport.district", source = "district"),
//			@Mapping(target = "callType", source = "beneficiaryCallType"),
//			@Mapping(target = "callSubType", source = "beneficiaryCallSubType"),
			@Mapping(target = "benReport.state", source = "state"),
			@Mapping(target = "benReport.subDistrict", source = "subDistrict"), })
	CallDetailsReport requestToCRMReports(Report1097RequestModel report);

	@IterableMapping(elementTargetType = CallDetailsReport.class)
	List<CallDetailsReport> requestToCRMReports(List<Report1097RequestModel> reports);
	
	@Mappings({ @Mapping(target = "phoneNumber", source = "report.phoneNo"),
		@Mapping(target = "entryDate", source = "report.lastModDate"), })
	UnBlockedUserReport mapUnblockedUserReport(UnBlockedPhoneReport report);
}