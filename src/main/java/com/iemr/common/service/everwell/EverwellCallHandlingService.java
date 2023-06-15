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
package com.iemr.common.service.everwell;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.iemr.common.data.everwell.EverwellDetails;
import com.iemr.common.utils.exception.IEMRException;
@Service
public interface EverwellCallHandlingService {
	String outboundCallCount(String request) throws IEMRException, JSONException;
	String outboundAllocation(String request) throws IEMRException;
	String outboundCallList(String request) throws IEMRException;
	String resetOutboundCall(String request) throws IEMRException;
	String saveDetails(String request) throws IEMRException, ParseException;
	String completeOutboundCall(String request) throws IEMRException;
	String updateIncompleteCallStatus(String request) throws IEMRException;
	String getEverwellFeedback(String request) throws IEMRException;
	String outboundCallListWithMobileNumber(String request) throws IEMRException;
    String checkAlreadyCalled(String request) throws IEMRException;
}
