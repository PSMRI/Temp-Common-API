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

public interface ConstantAddUpdateUser extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=Test@123&"
			+ "firstname=&lastname=&phone=&email=&role=&sessiontimeout=60000&designation=&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_2\" , \"response_code\": \"1\", \"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest1 = "{username:\"test1097_2\",password:\"Test@123\"}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=Test@123&"
			+ "firstname=test2&lastname=user&phone=&email=&role=&sessiontimeout=60000&designation=&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_2\" , \"response_code\": \"1\", \"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest2 = "{username:\"test1097_2\",password:\"Test@123\",firstname:test2,lastname:user}";
	static final String successResponse2 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=&"
			+ "firstname=&lastname=&phone=&email=&role=Supervisor_1097&sessiontimeout=60000&designation=CO&resFormat=3";
	static final String urlSuccessResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_2\" , \"response_code\": \"1\", \"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest3 = "{username:\"test1097_2\",role:\"Supervisor_1097\",designation:CO}";
	static final String successResponse3 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse3 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest4 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=Test@123&firstname=Test2&"
			+ "lastname=user&phone=1234567890&email=testuser2@wipro.com&role=Supervisor_1097&"
			+ "sessiontimeout=60000&designation=CO&resFormat=3";
	static final String urlSuccessResponse4 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_2\" , \"response_code\": \"1\", \"status\": \"SUCCESS\", \"reason\": \"\"} }";
	static final String successRequest4 = "{username:\"test1097_2\",password:\"Test@123\",firstname:Test2,"
			+ "lastname:user,role:\"Supervisor_1097\",designation:CO,phone:1234567890,email:\"testuser2@wipro.com\"}";
	static final String successResponse4 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse4 = "{\"data\":{\"transaction_id\":\"CTI_SYSTEM_USER\","
			+ "\"user_name\":\"test1097_2\",\"reason\":\"\",\"response_code\":\"1\",\"status\":\"SUCCESS\","
			+ "\"response\":{\"transaction_id\":\"CTI_SYSTEM_USER\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"user_name\":\"test1097_2\"}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=&firstname=&"
			+ "lastname=&phone=&email=&role=&sessiontimeout=60000&designation=&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_2\" , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"No data to update.\"} }";
	static final String failureRequest1 = "{username:\"test1097_2\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No data to update.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"No data to update.\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_SYSTEM_USER&username=&password=Test@123&firstname=&"
			+ "lastname=&phone=&email=&role=&sessiontimeout=60000&designation=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"\" , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"username is missing\"} }";
	static final String failureRequest2 = "{password:\"Test@123\"}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"username is missing\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"username is missing\",\"status\":\"FAILURE\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP + "/apps/cust_appsHandler.php?"
			+ "transaction_id=CTI_SYSTEM_USER&username=test1097_2&password=&firstname=Test2&lastname=user&"
			+ "phone=1234567890&email=testuser2@wipro.com&role=Supervisor_1097&sessiontimeout=60000&"
			+ "designation=CO&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_SYSTEM_USER\" , "
			+ "\"user_name\": \"test1097_6\" , \"response_code\": \"0\", \"status\": \"FAILURE\", "
			+ "\"reason\": \"password is missing\"} }";
	static final String failureRequest3 = "{username:\"test1097_2\",firstname:Test2,lastname:user,"
			+ "role:\"Supervisor_1097\",designation:CO,phone:1234567890,email:\"testuser2@wipro.com\"}";
	static final String failureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"password is missing\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"password is missing\",\"status\":\"FAILURE\"}";
}
