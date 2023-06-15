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

public interface ConstantCallDisconnect extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DISCONNECT&agent_id=2003&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_DISCONNECT\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"\" } }";
	static final String successRequest1 = "{\"agent_id\":\"2003\"}";
	static final String successResponse1 = "{\"data\":{\"agent_id\":\"2003\","
			+ "\"transaction_id\":\"CTI_DISCONNECT\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_DISCONNECT\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"agent_id\":\"2003\","
			+ "\"transaction_id\":\"CTI_DISCONNECT\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_DISCONNECT\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"}},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DISCONNECT&agent_id=2004&ip=&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_DISCONNECT\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAIL\", \"response_code\": \"-1\", "
			+ "\"reason\": \"Unable to open socket connection.\" } }";
	static final String failureRequest1 = "{\"agent_id\":\"2004\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Unable to open socket connection.\",\"status\":\"FAIL\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Unable to open socket connection.\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DISCONNECT&agent_id=&ip=" + REQUESTOR_IP + "&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_DISCONNECT\", "
			+ "\"agentid\": \"\", \"status\": \"FAIL\", \"response_code\": \"-1\", " + "\"reason\": \"Agent- ip-"
			+ REQUESTOR_IP + " not complete as per the request.\" } }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent- ip-10.208.24.185 not complete as per the request.\",\"status\":\"FAIL\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent- ip-10.208.24.185 not complete as per the request.\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DISCONNECT&agent_id=&ip=&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_DISCONNECT\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAIL\", \"response_code\": \"-1\", "
			+ "\"reason\": \"Unable to open socket connection.\" } }";
	static final String failureRequest3 = "{}";
	static final String failureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Unable to open socket connection.\",\"status\":\"FAIL\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Unable to open socket connection.\",\"status\":\"FAIL\"}";
}
