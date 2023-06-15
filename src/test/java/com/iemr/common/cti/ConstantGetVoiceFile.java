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

public interface ConstantGetVoiceFile extends Constants
{
	static final String urlSuccessRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&agent_id=2003&"
			+ "session_id=1511338154.2409000000&resFormat=3";
	static final String urlSuccessResponse1 = "{ \"response\": { \"transaction_id\": \"GET_VOICE_FILENAME\", "
			+ "\"agentid\": \"2003\", \"status\": \"SUCCESS\", \"response_code\": \"1\", "
			+ "\"path\": \"monitor_0/preview_UAT_1097_CO/2017_11_22/\", "
			+ "\"filename\": \"agent-2003-1511338154-2411-preview_UAT_1097_CO-2017_11_22_13_39_14-4003.mp3\", "
			+ "\"disconnect_by\": \"Agent\", \"call_duration\": \"22\" } }";
	static final String successRequest1 = "{agent_id:2003, \"session_id\": \"1511338154.2409000000\"}";
	static final String successResponse1 = "{\"data\":{\"response\":{\"transaction_id\":\"GET_VOICE_FILENAME\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"call_duration\":\"22\","
			+ "\"path\":\"monitor_0/preview_UAT_1097_CO/2017_11_22/\","
			+ "\"filename\":\"agent-2003-1511338154-2411-preview_UAT_1097_CO-2017_11_22_13_39_14-4003.mp3\","
			+ "\"disconnect_by\":\"Agent\"},\"agent_id\":\"2003\",\"session_id\":\"1511338154.2409000000\","
			+ "\"transaction_id\":\"GET_VOICE_FILENAME\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"path\":\"monitor_0/preview_UAT_1097_CO/2017_11_22/\","
			+ "\"filename\":\"agent-2003-1511338154-2411-preview_UAT_1097_CO-2017_11_22_13_39_14-4003.mp3\","
			+ "\"disconnect_by\":\"Agent\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
	static final String controllerSuccessResponse1 = "{\"data\":{\"response\":{\"transaction_id\":\"GET_VOICE_FILENAME\","
			+ "\"agentid\":\"2003\",\"status\":\"SUCCESS\",\"response_code\":\"1\",\"call_duration\":\"22\","
			+ "\"path\":\"monitor_0/preview_UAT_1097_CO/2017_11_22/\","
			+ "\"filename\":\"agent-2003-1511338154-2411-preview_UAT_1097_CO-2017_11_22_13_39_14-4003.mp3\","
			+ "\"disconnect_by\":\"Agent\"},\"agent_id\":\"2003\",\"session_id\":\"1511338154.2409000000\","
			+ "\"transaction_id\":\"GET_VOICE_FILENAME\",\"agentid\":\"2003\",\"status\":\"SUCCESS\","
			+ "\"response_code\":\"1\",\"path\":\"monitor_0/preview_UAT_1097_CO/2017_11_22/\","
			+ "\"filename\":\"agent-2003-1511338154-2411-preview_UAT_1097_CO-2017_11_22_13_39_14-4003.mp3\","
			+ "\"disconnect_by\":\"Agent\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";

	static final String urlFailureRequest1 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&agent_id=2003&"
			+ "session_id=15113381541.2409000000&resFormat=3";
	static final String urlFailureResponse1 = "{ \"response\": { \"transaction_id\": \"GET_VOICE_FILENAME\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAILURE\", \"response_code\": \"0\", \"path\": \"\", "
			+ "\"filename\": \"\", \"disconnect_by\": \"\", \"call_duration\": \"0\", "
			+ "\"reason\": \"For Agent-2003 Session-15113381541.2409000000 information not available.\" } }";
	static final String failureRequest1 = "{agent_id:2003, \"session_id\": \"15113381541.2409000000\"}";
	static final String failureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"For Agent-2003 Session-15113381541.2409000000 information not available.\","
			+ "\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse1 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"For Agent-2003 Session-15113381541.2409000000 information not available.\","
			+ "\"status\":\"FAILURE\"}";

	static final String urlFailureRequest2 = "http://" + CTI_SERVER_IP
			+ "/apps/appsHandler.php?transaction_id=GET_VOICE_FILENAME&agent_id=2003&session_id=&resFormat=3";
	static final String urlFailureResponse2 = "{ \"response\": { \"transaction_id\": \"GET_VOICE_FILENAME\", "
			+ "\"agentid\": \"2003\", \"status\": \"FAILURE\", \"response_code\": \"0\", \"path\": \"\", "
			+ "\"filename\": \"\", \"disconnect_by\": \"\", \"call_duration\": \"0\", "
			+ "\"reason\": \"For Agent-2003 Session- information not available.\" } }";
	static final String failureRequest2 = "{agent_id:2003}";
	static final String failureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"For Agent-2003 Session- information not available.\",\"status\":\"FAILURE\"}";
	static final String controllerFailureResponse2 = "{\"statusCode\":5000,"
			+ "\"errorMessage\":\"For Agent-2003 Session- information not available.\",\"status\":\"FAILURE\"}";

}
