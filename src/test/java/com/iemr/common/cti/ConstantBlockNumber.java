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

public interface ConstantBlockNumber extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_ADD_LEAD_RESTRICTION&mobile=1234567890&campaign_name=UAT_1097_CO&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": {\"transaction_id\":\"CTI_ADD_LEAD_RESTRICTION\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"} }";
	static final String successRequest1 = "{phoneNo:1234567890, campaignName:UAT_1097_CO}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_ADD_LEAD_RESTRICTION\",\"reason\":\"\","
			+ "\"response\":{\"transaction_id\":\"CTI_ADD_LEAD_RESTRICTION\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_ADD_LEAD_RESTRICTION\",\"reason\":\"\","
			+ "\"response\":{\"transaction_id\":\"CTI_ADD_LEAD_RESTRICTION\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\"},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_ADD_LEAD_RESTRICTION&mobile=1234567890&campaign_name=UAT_1097&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_ADD_LEAD_RESTRICTION\" , "
			+ "\"phone\": \"1234567890\" , \"campaign\": \"UAT_1097\", \"response_code\": \"0\", "
			+ "\"status\": \"FAILURE\", \"reason\": \"Caller ID Based Routing disabled for campaign UAT_1097.\"} }";
	static final String failureRequest1 = "{phoneNo:1234567890, campaignName:UAT_1097}";
	static final String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Caller ID Based Routing disabled for campaign UAT_1097.\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Caller ID Based Routing disabled for campaign UAT_1097.\",\"status\":\"FAILURE\"}";

}
