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

public interface ConstantAgentLogout extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGOUT&agent_id=2003&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGOUT\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"logoff\", \"status\": \"SUCCESS\", \"response_code\": \"1\" } }";
	static final String successRequest1 = "{agent_id:2003}";
	static final String successResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{\"transaction_id\":\"CTI_LOGOUT\","
			+ "\"agentid\":\"2003\",\"requestparam\":\"logoff\",\"status\":\"SUCCESS\",\"response_code\":\"1\"},"
			+ "\"transaction_id\":\"CTI_LOGOUT\",\"agentid\":\"2003\",\"requestparam\":\"logoff\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"stateObj\":{},\"response\":{"
			+ "\"transaction_id\":\"CTI_LOGOUT\",\"agentid\":\"2003\",\"requestparam\":\"logoff\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\"},\"transaction_id\":\"CTI_LOGOUT\",\"agentid\":\"2003\","
			+ "\"requestparam\":\"logoff\",\"status\":\"SUCCESS\",\"response_code\":\"1\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGOUT&agent_id=2003&ip=&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_LOGOUT\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"logoff\", \"status\": \"FAIL\", \"response_code\": \"-1\" } }";
	static final String failureRequest1 = "{agent_id:2003}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGOUT&agent_id=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_LOGOUT\", "
			+ "\"agentid\": \"\", \"requestparam\": \"logoff\", \"status\": \"FAIL\", \"response_code\": \"-1\" } }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\","
			+ "\"status\":\"FAIL\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_LOGOUT&agent_id=&ip=&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_LOGOUT\","
			+ " \"agentid\": \"\", \"requestparam\": \"logoff\", \"status\": \"FAIL\", \"response_code\": \"-1\" } }";
	static final String failureRequest3 = "{}";
	static final String failureResponse3 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";
}
