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
package com.iemr.common.service.cti;

import org.json.JSONException;

import com.iemr.common.data.cti.CustomerLanguage;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.response.OutputResponse;

public interface CTIService
{
	String callUrl(String urlRequest);

	OutputResponse addUpdateAgentSkills(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getCampaignSkills(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse getAgentState(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getAgentCallStats(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse getCampaignNames(String request, String ipAddress) throws IEMRException, JSONException;

	OutputResponse doAgentLogin(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getLoginKey(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse agentLogout(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getOnlineAgents(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse callBeneficiary(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse addUpdateUserData(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getTransferCampaigns(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getCampaignRoles(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse setCallDisposition(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse createVoiceFile(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getVoiceFile(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse disconnectCall(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse switchToInbound(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse switchToOutbound(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse unblockNumber(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse blockNumber(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getAgentIPAddress(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse getAvailableAgentSkills(String request, String remoteAddr) throws IEMRException, JSONException;

	OutputResponse transferCall(String request, String remoteAddr) throws IEMRException, JSONException;

	String getAgentIP(String agentID);

	OutputResponse customerPreferredLanguage(CustomerLanguage custLang, String remoteAddress);

	OutputResponse addAutoDialNumbers(String request, String ipAddress) throws JSONException, IEMRException;

	String callPostUrl(String urlRequest, String Json);

	OutputResponse setAutoDialNumbers(String request, String ipAddress) throws JSONException, IEMRException;

	OutputResponse getIVRSPathDetails(String request, String remoteAddress)throws Exception;

	OutputResponse getVoiceFileNew(String request, String remoteAddr) throws IEMRException, JSONException;	
}
