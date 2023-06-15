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
package com.iemr.common.service.callhandling;

import java.util.List;

import org.json.JSONException;

import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.utils.exception.IEMRException;

public interface CalltypeService {

	// CallType addCalltype(String callType, String remarks, String
	// invalidType);
	//
	// CallType addCalltype(CallType callType);

	List<CallType> getAllCalltypes(String id) throws IEMRException;

	String getAllCalltypesV1(String request) throws JSONException, IEMRException;

	// String updateCalltype(CallType callType);
}
