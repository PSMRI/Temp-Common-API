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

public interface ConstantCampaignName extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=INBOUND&searchkey=1097"
			+ "&ip=&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : [{\"campaign_id\":\"1\","
			+ "\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"}], \"reason\": \"\"} }";
	static final String successRequest1 = "{serviceName:1097,type:INBOUND}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"type\":\"INBOUND\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\","
			+ "\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\","
			+ "\"campaign_type\":\"INBOUND\"}],\"serviceName\":\"1097\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\","
			+ "\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\","
			+ "\"campaign_type\":\"INBOUND\"}]},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"type\":\"INBOUND\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\","
			+ "\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\","
			+ "\"campaign_type\":\"INBOUND\"}],\"serviceName\":\"1097\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\","
			+ "\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\","
			+ "\"campaign_type\":\"INBOUND\"}]},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=OUTBOUND&searchkey=mcts"
			+ "&ip=&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : [{\"campaign_id\":\"2\","
			+ "\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\","
			+ "\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"}], \"reason\": \"\"} }";
	static final String successRequest2 = "{serviceName:mcts,type:OUTBOUND}";
	static final String successResponse2 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"type\":\"OUTBOUND\",\"campaign\":[{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\","
			+ "\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\","
			+ "\"campaign_type\":\"OUTBOUND\"}],\"serviceName\":\"mcts\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"campaign\":[{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\","
			+ "\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\","
			+ "\"campaign_type\":\"OUTBOUND\"}]},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"type\":\"OUTBOUND\",\"campaign\":[{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\","
			+ "\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\","
			+ "\"campaign_type\":\"OUTBOUND\"}],\"serviceName\":\"mcts\",\"reason\":\"\",\"response\":{"
			+ "\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\",\"response_code\":\"1\","
			+ "\"reason\":\"\",\"campaign\":[{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\","
			+ "\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\","
			+ "\"campaign_type\":\"OUTBOUND\"}]},\"response_code\":\"1\",\"status\":\"SUCCESS\"},"
			+ "\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlSuccessRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=&searchkey=10&ip=&resFormat=3";
	static final String urlSuccessResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : [{\"campaign_id\":\"1\","
			+ "\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"5\","
			+ "\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"6\","
			+ "\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}], \"reason\": \"\"} }";
	static final String successRequest3 = "{serviceName:10}";
	static final String successResponse3 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}],"
			+ "\"serviceName\":\"10\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}]},"
			+ "\"response_code\":\"1\",\"status\":\"SUCCESS\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse3 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}],"
			+ "\"serviceName\":\"10\",\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\","
			+ "\"status\":\"SUCCESS\",\"response_code\":\"1\",\"reason\":\"\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}]},"
			+ "\"response_code\":\"1\",\"status\":\"SUCCESS\"},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest4 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=&searchkey="
			+ "&ip=&resFormat=3";
	static final String urlSuccessResponse4 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"1\", \"status\": \"SUCCESS\", \"campaign\" : [{\"campaign_id\":\"1\","
			+ "\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"2\","
			+ "\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"3\","
			+ "\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"5\","
			+ "\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},{\"campaign_id\":\"6\","
			+ "\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}], \"reason\": \"\"} }";
	static final String successRequest4 = "{}";
	static final String successResponse4 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}],"
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}]},"
			+ "\"response_code\":\"1\",\"status\":\"SUCCESS\"},\"statusCode\":200,\"errorMessage\":"
			+ "\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse4 = "{\"data\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}],"
			+ "\"reason\":\"\",\"response\":{\"transaction_id\":\"CTI_GET_CAMPAIGNS\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"reason\":\"\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"2\",\"campaign_name\":\"UAT_MCTS_ANM\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"3\",\"campaign_name\":\"UAT_MCTS_MO\",\"campaign_type\":\"OUTBOUND\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"5\",\"campaign_name\":\"UAT_104_RO\",\"campaign_type\":\"INBOUND\"},"
			+ "{\"campaign_id\":\"6\",\"campaign_name\":\"UAT_104_CO\",\"campaign_type\":\"OUTBOUND\"}]},"
			+ "\"response_code\":\"1\",\"status\":\"SUCCESS\"},\"statusCode\":200,\"errorMessage\":"
			+ "\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=OUTBOUND&searchkey=1097"
			+ "&ip=&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : [], \"reason\": "
			+ "\"No Campaign Created.\"} }";
	static final String failureRequest1 = "{serviceName:1097, type:OUTBOUND}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=BLENDED&searchkey="
			+ "&ip=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : [], \"reason\": "
			+ "\"No Campaign Created.\"} }";
	static final String failureRequest2 = "{type:BLENDED}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest3 = "http://" + CTI_SERVER_IP
			+ "/apps/cust_appsHandler.php?transaction_id=CTI_GET_CAMPAIGNS&campaign_type=&searchkey=hello&ip=&resFormat=3";
	static final String urlFailureResponse3 = "{ \"response\": { \"transaction_id\": \"CTI_GET_CAMPAIGNS\" , "
			+ "\"response_code\": \"0\", \"status\": \"FAILURE\", \"campaign\" : [], \"reason\": "
			+ "\"No Campaign Created.\"} }";
	static final String failureRequest3 = "{serviceName:hello}";
	static final String failureResponse3 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse3 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaign Created.\","
			+ "\"status\":\"FAILURE\"}";

}
