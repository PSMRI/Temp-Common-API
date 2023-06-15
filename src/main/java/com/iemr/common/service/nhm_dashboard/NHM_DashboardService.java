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
package com.iemr.common.service.nhm_dashboard;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iemr.common.data.nhm_dashboard.AbandonCallSummary;
import com.iemr.common.data.nhm_dashboard.AgentSummaryReport;
import com.iemr.common.data.nhm_dashboard.DetailedCallReport;
import com.iemr.common.notification.exception.IEMRException;

@Service
public interface NHM_DashboardService {

	public String pushAbandonCalls(AbandonCallSummary abandonCallSummary) throws Exception;

	public String getAbandonCalls() throws Exception;

	public String saveAgentSummaryReport(List<AgentSummaryReport> agentSummaryReportList) throws IEMRException;

	public String saveDetailedCallReport(List<DetailedCallReport> detailedCallReportList) throws IEMRException;

	public String pull_NHM_Data_CTI() throws IEMRException;

	public String getAgentSummaryReport() throws Exception;

	public String getDetailedCallReport() throws Exception;

}
