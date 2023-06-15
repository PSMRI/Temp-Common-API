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

public interface ConstantAgentState extends Constants
{
	final static String successRequestURL1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String successResponseURL1 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"2003\", \"state\" : \"FREE\", \"dialer_type\" : \"PROGRESSIVE\", "
			+ "\"campaign_dialerType\" : \"PROGRESSIVE\", \"previewDialing\" : \"ENABLED\", \"manual_dial\" : \"1\", "
			+ "\"last_cust_ph_no\" : \"\", \"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	static final String successRequest1 = "{\"agent_id\":\"2003\"}";
	static final String successResponse1 = "{\"data\":{\"stateObj\":{\"stateName\":\"FREE\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"state\":\"FREE\",\"dialer_type\":\"PROGRESSIVE\","
			+ "\"campaign_dialerType\":\"PROGRESSIVE\",\"previewDialing\":\"ENABLED\",\"manual_dial\":\"1\","
			+ "\"last_cust_ph_no\":\"\"},\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2003\","
			+ "\"state\":\"FREE\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"dialer_type\":\"PROGRESSIVE\","
			+ "\"campaign_dialerType\":\"PROGRESSIVE\",\"previewDialing\":\"ENABLED\",\"manual_dial\":\"1\","
			+ "\"last_cust_ph_no\":\"\",\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"stateObj\":{\"stateName\":\"FREE\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"state\":\"FREE\",\"dialer_type\":\"PROGRESSIVE\","
			+ "\"campaign_dialerType\":\"PROGRESSIVE\",\"previewDialing\":\"ENABLED\",\"manual_dial\":\"1\","
			+ "\"last_cust_ph_no\":\"\"},\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2003\","
			+ "\"state\":\"FREE\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"dialer_type\":\"PROGRESSIVE\","
			+ "\"campaign_dialerType\":\"PROGRESSIVE\",\"previewDialing\":\"ENABLED\",\"manual_dial\":\"1\","
			+ "\"last_cust_ph_no\":\"\",\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	final static String successRequestURL2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=2005&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String successResponseURL2 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"2005\", \"state\" : \"INCALL\", \"session_id\" : \"1515038185.1230000000\", "
			+ "\"ivrs_path\" : \"\", \"call_duration\" : \"63\", \"skills\" : \"\", \"cust_ph_no\" : \"1234567899\", "
			+ "\"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	static final String successRequest2 = "{\"agent_id\":\"2005\"}";
	static final String successResponse2 = "{\"data\":{\"stateObj\":{\"stateName\":\"INCALL\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2005\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":\"\",\"state\":\"INCALL\",\"call_duration\":\"63\","
			+ "\"session_id\":\"1515038185.1230000000\",\"ivrs_path\":\"\",\"cust_ph_no\":\"1234567899\"},"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2005\",\"state\":\"INCALL\","
			+ "\"call_duration\":\"63\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"session_id\":\"1515038185.1230000000\",\"ivrs_path\":\"\",\"skills\":\"\","
			+ "\"cust_ph_no\":\"1234567899\",\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"stateObj\":{\"stateName\":\"INCALL\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2005\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"skills\":\"\",\"state\":\"INCALL\",\"call_duration\":\"63\","
			+ "\"session_id\":\"1515038185.1230000000\",\"ivrs_path\":\"\",\"cust_ph_no\":\"1234567899\"},"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2005\",\"state\":\"INCALL\","
			+ "\"call_duration\":\"63\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"session_id\":\"1515038185.1230000000\",\"ivrs_path\":\"\",\"skills\":\"\","
			+ "\"cust_ph_no\":\"1234567899\",\"reason\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	final static String successRequestURL3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=2006&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String successResponseURL3 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"2006\", \"state\" : \"CLOSURE\", \"session_id\" : \"1515038185.1230000000\", "
			+ "\"wrapTime\" : \"0\", \"wrpupDisconnectFlag\" : \"1\", \"cust_ph_no\" : \"1234567899\", "
			+ "\"status\": \"SUCCESS\", \"response_code\": \"1\", \"reason\" : \"\" } }";
	static final String successRequest3 = "{\"agent_id\":\"2006\"}";
	static final String successResponse3 = "{\"data\":{\"stateObj\":{\"stateName\":\"CLOSURE\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2006\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"state\":\"CLOSURE\",\"session_id\":\"1515038185.1230000000\","
			+ "\"cust_ph_no\":\"1234567899\",\"wrapTime\":\"0\",\"wrpupDisconnectFlag\":\"1\"},"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2006\",\"state\":\"CLOSURE\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"session_id\":\"1515038185.1230000000\","
			+ "\"cust_ph_no\":\"1234567899\",\"reason\":\"\",\"wrapTime\":\"0\",\"wrpupDisconnectFlag\":\"1\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse3 = "{\"data\":{\"stateObj\":{\"stateName\":\"CLOSURE\"},\"response\":{"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2006\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"state\":\"CLOSURE\",\"session_id\":\"1515038185.1230000000\","
			+ "\"cust_ph_no\":\"1234567899\",\"wrapTime\":\"0\",\"wrpupDisconnectFlag\":\"1\"},"
			+ "\"transaction_id\":\"CTI_CHECK_AGENT_STATE\",\"agentid\":\"2006\",\"state\":\"CLOSURE\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"session_id\":\"1515038185.1230000000\","
			+ "\"cust_ph_no\":\"1234567899\",\"reason\":\"\",\"wrapTime\":\"0\",\"wrpupDisconnectFlag\":\"1\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	final static String failureRequestURL1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=2004&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String failureResponseURL1 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"2004\", \"status\": \"FAILURE\", \"response_code\": \"0\", "
			+ "\"reason\" : \"NOT_LOGGED_IN\" } }";
	static final String failureRequest1 = "{\"agent_id\":\"2004\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"NOT_LOGGED_IN\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"NOT_LOGGED_IN\","
			+ "\"status\":\"FAILURE\"}";

	final static String failureRequestURL2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=&ip=&resFormat=3";
	static final String failureResponseURL2 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"\", \"status\": \"FAILURE\", \"response_code\": \"0\", \"reason\" : \"\" } }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"\",\"status\":\"FAILURE\"}";

	final static String failureRequestURL3 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_CHECK_AGENT_STATE&agent_id=&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String failureResponseURL3 = "{ \"response\": { \"transaction_id\": \"CTI_CHECK_AGENT_STATE\", "
			+ "\"agentid\": \"\", \"status\": \"FAILURE\", \"response_code\": \"0\", \"reason\" : \"\" } }";
	static final String failureRequest3 = "{}";
	static final String failureResponse3 = "{\"statusCode\":5000,\"errorMessage\":\"\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,\"errorMessage\":\"\",\"status\":\"FAILURE\"}";

}
