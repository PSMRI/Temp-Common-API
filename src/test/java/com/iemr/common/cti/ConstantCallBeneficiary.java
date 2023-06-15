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

public interface ConstantCallBeneficiary extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&phone_num=1234567899&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"1234567899\", \"status\": \"SUCCESS\", "
			+ "\"response_code\": \"1\" } }";
	static final String successRequest1 = "{agent_id:2003, phone_num:1234567899}";
	static final String successResponse1 = "{\"data\":{\"agent_id\":\"2003\",\"phone_num\":\"1234567899\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"response\":{"
			+ "\"transaction_id\":\"CTI_DIAL\",\"agentid\":\"2003\",\"requestparam\":\"1234567899\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"agent_id\":\"2003\",\"phone_num\":\"1234567899\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"response\":{"
			+ "\"transaction_id\":\"CTI_DIAL\",\"agentid\":\"2003\",\"requestparam\":\"1234567899\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=2004&ip=" + REQUESTOR_IP
			+ "&phone_num=1234567899&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2004\", \"requestparam\": \"1234567899\", \"status\": \"FAIL\", "
			+ "\"response_code\": \"0\" } }";
	static final String failureRequest1 = "{agent_id:2004, phone_num:1234567899}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=&ip=" + REQUESTOR_IP
			+ "&phone_num=1234567899&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"\", \"requestparam\": \"1234567899\", \"status\": \"FAIL\", "
			+ "\"response_code\": \"0\" } }";
	static final String failureRequest2 = "{phone_num:1234567899}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=2004&ip=&phone_num=1234567899&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2004\", \"requestparam\": \"1234567899\", \"status\": \"FAIL\", "
			+ "\"response_code\": \"0\" } }";
	static final String failureRequest3 = "{agent_id:2004, phone_num:1234567899}";
	static final String failureResponse3 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest4 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=2004&ip=" + REQUESTOR_IP
			+ "&phone_num=&resFormat=3";
	static final String urlFailureResponse4 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2004\", \"requestparam\": \"\", \"status\": \"FAIL\", \"response_code\": \"0\" } }";
	static final String failureRequest4 = "{agent_id:2004}";
	static final String failureResponse4 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse4 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest5 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=2003&ip=&phone_num=&resFormat=3";
	static final String urlFailureResponse5 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"2003\", \"requestparam\": \"\", \"status\": \"FAIL\", \"response_code\": \"0\" } }";
	static final String failureRequest5 = "{agent_id:2003}";
	static final String failureResponse5 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse5 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest6 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=&ip=" + REQUESTOR_IP
			+ "&phone_num=1234567899&resFormat=3";
	static final String urlFailureResponse6 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"\", \"requestparam\": \"1234567899\", \"status\": \"FAIL\", \"response_code\": \"0\" } }";
	static final String failureRequest6 = "{phone_num:1234567899}";
	static final String failureResponse6 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse6 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";

	static final String urlFailureRequest7 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_DIAL&agent_id=&ip=&phone_num=&resFormat=3";
	static final String urlFailureResponse7 = "{ \"response\": { \"transaction_id\": \"CTI_DIAL\", "
			+ "\"agentid\": \"\", \"requestparam\": \"\", \"status\": \"FAIL\", \"response_code\": \"0\" } }";
	static final String failureRequest7 = "{}";
	static final String failureResponse7 = "{\"statusCode\":5000,\"status\":\"FAIL\"}";
	static final String controllerFailureResponse7 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Failed with generic error\",\"status\":\"FAIL\"}";
}
