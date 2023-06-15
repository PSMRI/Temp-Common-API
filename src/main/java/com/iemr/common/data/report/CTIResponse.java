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
package com.iemr.common.data.report;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;


public class CTIResponse
{
	private static final String SUCCESS = "success";
	
	OutputMapper mapper = new OutputMapper();
	
	@Expose
	String transaction_id;
	
	@Expose
	String response_code;
	
	@Expose
	String agentid;

	@Expose
	String last_cust_ph_no;
	
	@Expose
	String call_duration;

	@Expose
	String status;
	
	@Expose
	String call_start_date_time;
	@Expose
	String call_end_date_time;	
	@Expose
	private String response;
	
	public String getCall_start_date_time() {
		return call_start_date_time;
	}

	public void setCall_start_date_time(String call_start_date_time) {
		this.call_start_date_time = call_start_date_time;
	}

	public String getCall_end_date_time() {
		return call_end_date_time;
	}

	public void setCall_end_date_time(String call_end_date_time) {
		this.call_end_date_time = call_end_date_time;
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	public Boolean isSuccessResponse()
	{
		return status.equalsIgnoreCase(SUCCESS);
	}

	public OutputMapper getMapper() {
		return mapper;
	}

	public void setMapper(OutputMapper mapper) {
		this.mapper = mapper;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getLast_cust_ph_no() {
		return last_cust_ph_no;
	}

	public void setLast_cust_ph_no(String last_cust_ph_no) {
		this.last_cust_ph_no = last_cust_ph_no;
	}

	public String getCall_duration() {
		return call_duration;
	}

	public void setCall_duration(String call_duration) {
		this.call_duration = call_duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static String getSuccess() {
		return SUCCESS;
	}
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


}
