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
package com.iemr.common.service.reports;

import java.util.List;

import com.iemr.common.data.report.CallDetailsReport;

public interface CallReportsService
{
	List<CallDetailsReport> getAllReportsByDate(CallDetailsReport request) throws Exception;

	String getAllByAgeGroup(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getAllByGender(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getAllBySexualOrientation(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getCountsByPreferredLanguage(List<CallDetailsReport> callDetailsReportRequest) throws Exception;

	String getComplaintDetailReport(String request) throws Exception;

	String getUnblockedUserReport(String request) throws Exception;

	String getCallQualityReport(String request) throws Exception;

	String getDistrictWiseCallReport(String request) throws Exception;

	String callUrl(String urlRequest);

	String getQualityReport(String request) throws Exception;

	String getCallSummaryReport(String request) throws Exception;
	
	String getReportTypes(Integer providerServiceMapID) throws Exception;
}
