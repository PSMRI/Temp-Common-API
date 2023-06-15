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

public interface ConstantCampaignRoles extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMP_ROLE&campaign=UAT_1097_CO&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMP_ROLE\" , "
			+ "\"campaign\": \"UAT_1097_CO\" , \"roles\": [\"Supervisor_1097\", \"CO_1097\"] , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest1 = "{campaign:UAT_1097_CO}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMP_ROLE\","
			+ "\"campaign\":\"UAT_1097_CO\",\"roles\":[\"Supervisor_1097\",\"CO_1097\"],"
			+ "\"response_code\":\"1\",\"status\":\"SUCCESS\",\"reason\":\"\",\"response\":"
			+ "{\"transaction_id\":\"CTI_GET_CAMP_ROLE\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"campaign\":\"UAT_1097_CO\",\"roles\":[\"Supervisor_1097\",\"CO_1097\"]}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMP_ROLE\","
			+ "\"campaign\":\"UAT_1097_CO\",\"roles\":[\"Supervisor_1097\",\"CO_1097\"],\"response_code\":\"1\","
			+ "\"status\":\"SUCCESS\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_CAMP_ROLE\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"campaign\":\"UAT_1097_CO\","
			+ "\"roles\":[\"Supervisor_1097\",\"CO_1097\"]}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMP_ROLE&campaign=1097&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMP_ROLE\" , "
			+ "\"campaign\": \"1097\" , \"roles\": [] , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"campaign name is incorrect\"} }";
	static final String failureRequest1 = "{campaign:1097}";
	static final String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"campaign name is incorrect\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"campaign name is incorrect\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMP_ROLE&campaign=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMP_ROLE\" , "
			+ "\"campaign\": \"\" , \"roles\": [] , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"campaign name is missing\"} }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"campaign name is missing\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"campaign name is missing\",\"status\":\"FAILURE\"}";
}
