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

public interface ConstantGetTransferCampaigns extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_TRANSFERABLE_CAMPAIGNS&agent_id=2003&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFERABLE_CAMPAIGNS\", "
			+ "\"agentid\": \"2003\", \"campaign\": [{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}] } }";
	static final String successRequest1 = "{agent_id:2003}";
	static final String successResponse1 = "{\"data\":{\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\","
			+ "\"agentid\":\"2003\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}],\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\",\"agentid\":\"2003\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\"}]}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\","
			+ "\"agentid\":\"2003\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}],\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\",\"agentid\":\"2003\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\"}]}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlSuccessRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_TRANSFERABLE_CAMPAIGNS&agent_id=2003&ip=&resFormat=3";
	static final String urlSuccessResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFERABLE_CAMPAIGNS\", "
			+ "\"agentid\": \"2003\", \"campaign\": [{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}] } }";
	static final String successRequest2 = "{agent_id:2003}";
	static final String successResponse2 = "{\"data\":{\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\","
			+ "\"agentid\":\"2003\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}],\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\",\"agentid\":\"2003\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\"}]}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";
	static final String controllerSuccessResponse2 = "{\"data\":{\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\","
			+ "\"agentid\":\"2003\",\"campaign\":[{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},"
			+ "{\"campaign_id\":\"4\",\"campaign_name\":\"UAT_1097_MO\"}],\"response\":{"
			+ "\"transaction_id\":\"CTI_TRANSFERABLE_CAMPAIGNS\",\"agentid\":\"2003\",\"campaign\":["
			+ "{\"campaign_id\":\"1\",\"campaign_name\":\"UAT_1097_CO\"},{\"campaign_id\":\"4\","
			+ "\"campaign_name\":\"UAT_1097_MO\"}]}},\"statusCode\":200,\"errorMessage\":\"Success\","
			+ "\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_TRANSFERABLE_CAMPAIGNS&agent_id=3003&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFERABLE_CAMPAIGNS\", "
			+ "\"agentid\": \"3003\", \"campaign\": []} }";
	static final String failureRequest1 = "{agent_id:3003}";
	static final String failureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaigns Available\","
			+ "\"status\":\"Failure\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaigns Available\","
			+ "\"status\":\"Failure\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=CTI_TRANSFERABLE_CAMPAIGNS&agent_id=&ip=" + REQUESTOR_IP
			+ "&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"CTI_TRANSFERABLE_CAMPAIGNS\", "
			+ "\"agentid\": \"\", \"campaign\": [], \"reason\": \"No Campaign Available\" } }";
	static final String failureRequest2 = "{}";
	static final String failureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaigns Available\","
			+ "\"status\":\"Failure\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,\"errorMessage\":\"No Campaigns Available\","
			+ "\"status\":\"Failure\"}";

}
