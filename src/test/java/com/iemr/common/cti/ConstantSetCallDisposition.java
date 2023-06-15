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

public interface ConstantSetCallDisposition extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&cust_disp=test&category=valid&session_id=1515149676.2690000000&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"\" } }";
	static final String successRequest1 = "{\"agent_id\":\"2003\", \"cust_disp\":\"test\", "
			+ "\"category\":\"valid\", \"session_id\":\"1515149676.2690000000\"}";
	static final String successResponse1 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"},"
			+ "\"agent_id\":\"2003\",\"cust_disp\":\"test\",\"category\":\"valid\","
			+ "\"session_id\":\"1515149676.2690000000\",\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"reason\":\"\",\"response_code\":\"1\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"response\":{"
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"},\"agent_id\":\"2003\",\"cust_disp\":\"test\","
			+ "\"category\":\"valid\",\"session_id\":\"1515149676.2690000000\","
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"reason\":\"\",\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=2003&ip=&cust_disp=test"
			+ "&category=valid&session_id=1515149676.2690000000&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"\" } }";
	static final String successRequest2 = "{\"agent_id\":\"2003\", \"cust_disp\":\"test\", "
			+ "\"category\":\"valid\", \"session_id\":\"1515149676.2690000000\"}";
	static final String successResponse2 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"},"
			+ "\"agent_id\":\"2003\",\"cust_disp\":\"test\",\"category\":\"valid\","
			+ "\"session_id\":\"1515149676.2690000000\",\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"reason\":\"\",\"response_code\":\"1\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"response\":{"
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"},\"agent_id\":\"2003\",\"cust_disp\":\"test\","
			+ "\"category\":\"valid\",\"session_id\":\"1515149676.2690000000\","
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"reason\":\"\",\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&cust_disp=test&category=&session_id=1515149676.2690000000&resFormat=3";
	static final String urlSuccessResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"\" } }";
	static final String successRequest3 = "{\"agent_id\":\"2003\", \"cust_disp\":\"test\", "
			+ "\"session_id\":\"1515149676.2690000000\"}";
	static final String successResponse3 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"},"
			+ "\"agent_id\":\"2003\",\"cust_disp\":\"test\",\"session_id\":\"1515149676.2690000000\","
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"reason\":\"\",\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse3 = "{\"data\":{\"response\":{"
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"},\"agent_id\":\"2003\",\"cust_disp\":\"test\","
			+ "\"session_id\":\"1515149676.2690000000\",\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"reason\":\"\",\"response_code\":\"1\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest4 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&cust_disp=test&category=valid&session_id=&resFormat=3";
	static final String urlSuccessResponse4 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\": \"\" } }";
	static final String successRequest4 = "{\"agent_id\":\"2003\", \"cust_disp\":\"test\", "
			+ "\"category\":\"valid\"}";
	static final String successResponse4 = "{\"data\":{\"response\":{\"transaction_id\":\"CTI_SET_DISPOSITION\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\"},"
			+ "\"agent_id\":\"2003\",\"cust_disp\":\"test\",\"category\":\"valid\","
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"reason\":\"\",\"response_code\":\"1\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse4 = "{\"data\":{\"response\":{"
			+ "\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\"},\"agent_id\":\"2003\",\"cust_disp\":\"test\","
			+ "\"category\":\"valid\",\"transaction_id\":\"CTI_SET_DISPOSITION\",\"agentid\":\"2003\","
			+ "\"status\":\"SUCCESS\",\"reason\":\"\",\"response_code\":\"1\"},\"statusCode\":200,"
			+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=&ip=" + REQUESTOR_IP
			+ "&cust_disp=test&category=valid&session_id=1515149676.2690000000&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"\", \"status\": \"FAILURE\", \"response_code\": \"-1\", "
			+ "\"reason\": \"Agent- disposition- not available.\" } }";
	static final String failureRequest1 = "{\"cust_disp\":\"test\", "
			+ "\"category\":\"valid\", \"session_id\":\"1515149676.2690000000\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent- disposition- not available.\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent- disposition- not available.\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_SET_DISPOSITION&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&cust_disp=&category=valid&session_id=1515149676.2690000000&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_SET_DISPOSITION\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAILURE\", \"response_code\": \"-1\", "
			+ "\"reason\": \"Agent-2003 disposition- not available.\" } }";
	static final String failureRequest2 = "{\"agent_id\":\"2003\", "
			+ "\"category\":\"valid\", \"session_id\":\"1515149676.2690000000\"}";
	static final String failureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent-2003 disposition- not available.\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"Agent-2003 disposition- not available.\",\"status\":\"FAILURE\"}";

}
