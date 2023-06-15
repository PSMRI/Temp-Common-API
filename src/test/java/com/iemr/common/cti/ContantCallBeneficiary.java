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
package com.iemr.common.cti;

public interface ContantCallBeneficiary extends Constants
{
	static final String dialRequestURLSuccess1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_DIAL&agent_id=2003&ip=" + REQUESTOR_IP + "&phone_num=1234567899&resFormat=3";
	static final String dialRequestSuccess1 = "{agent_id:2003, phone_num:1234567899}";
	static final String dialURLResponseSuccess1 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"1234567899\", \"status\": \"SUCCESS\", \"response_code\": \"1\"}}";
	static final String dialResposneSuccess1 = "{\"agent_id\":null,\"phone_num\":null,\"transaction_id\":\"CTI_DIAL\","
			+ "\"agentid\":\"2003\",\"requestparam\":\"1234567899\",\"status\":\"SUCCESS\",\"response_code\":\"1\"}";
	static final String controllerDialResposneSuccess1 = "{\"agent_id\":null,\"phone_num\":null,"
			+ "\"transaction_id\":\"CTI_DIAL\",\"agentid\":\"2003\",\"requestparam\":\"1234567899\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\"}";

	static final String dialBeneficiaryRequestFailure1 = "http://" + CTI_SERVER_IP + "/apps/appsHandler.php?"
			+ "transaction_id=CTI_DIAL&agent_id=2003&ip=" + REQUESTOR_IP + "&phone_num=1234567899&resFormat=3";

}