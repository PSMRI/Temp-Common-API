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

public interface ConstantCampaignSkills extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=UAT_1097_CO&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : \"UAT_1097_CO\", \"skills\" : ["
			+ "{\"skill_id\":\"1\",\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},"
			+ "{\"skill_id\":\"2\",\"skill_name\":\"Kannada\"}], \"reason\": \"\"} }";
	static final String successRequest1 = "{\"campaign_name\":\"UAT_1097_CO\"}";
	static final String successResponse1 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":[],"
			+ "\"campaignskills\":[],\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGN_SKILLS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"skill_id\":\"1\","
			+ "\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},{\"skill_id\":\"2\","
			+ "\"skill_name\":\"Kannada\"}],\"campaign\":\"UAT_1097_CO\"}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final Object controllerSuccessResponse1 = "{\"data\":{\"campaign_name\":\"UAT_1097_CO\",\"skills\":[],"
			+ "\"campaignskills\":[],\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGN_SKILLS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"skills\":[{\"skill_id\":\"1\","
			+ "\"skill_name\":\"English\"},{\"skill_id\":\"3\",\"skill_name\":\"Hindi\"},{\"skill_id\":\"2\","
			+ "\"skill_name\":\"Kannada\"}],\"campaign\":\"UAT_1097_CO\"}},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=1097_CO&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : \"1097_CO\", "
			+ "\"skills\" : [], \"reason\": \"No active skill found.\"} }";
	static final String failureRequest1 = "{\"campaign_name\":\"1097_CO\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No active skill found.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No active skill found.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_GET_CAMPAIGN_SKILLS&campaign_name=&ip=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGN_SKILLS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : \"\", \"skills\" : [], "
			+ "\"reason\": \"Campaign Name is missing.\"} }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Campaign Name is missing.\","
			+ "\"status\":\"FAILURE\"}";
	static final Object controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Campaign Name is missing.\","
			+ "\"status\":\"FAILURE\"}";

}
