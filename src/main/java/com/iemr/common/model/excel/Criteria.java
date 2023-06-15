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
package com.iemr.common.model.excel;

public class Criteria {
	String Start_Date;
	String End_Date;
	String Service;
	String AgentID;
	String RoleID;
	String CallTypeID;
	String CallTypeName;
	String State;
	String District;
	String Language;
	String CallerAgeGroup;
	String Call_Type;
	String Call_Sub_Type;
	String Gender;
	String Sexual_Orientation;


	public String getStart_Date() {
		return Start_Date;
	}

	public String getCallTypeID() {
		return CallTypeID;
	}

	public void setCallTypeID(String callTypeID) {
		CallTypeID = callTypeID;
	}

	public String getCallTypeName() {
		return CallTypeName;
	}

	public void setCallTypeName(String callTypeName) {
		CallTypeName = callTypeName;
	}

	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

	public String getRoleID() {
		return RoleID;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCall_Type() {
		return Call_Type;
	}

	public void setCall_Type(String call_Type) {
		Call_Type = call_Type;
	}

	public String getCall_Sub_Type() {
		return Call_Sub_Type;
	}

	public void setCall_Sub_Type(String call_Sub_Type) {
		Call_Sub_Type = call_Sub_Type;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSexual_Orientation() {
		return Sexual_Orientation;
	}

	public void setSexual_Orientation(String sexual_Orientation) {
		Sexual_Orientation = sexual_Orientation;
	}

	public void setRoleID(String roleID) {
		RoleID = roleID;
	}


	public String getCallerAgeGroup() {
		return CallerAgeGroup;
	}

	public void setCallerAgeGroup(String callerAgeGroup) {
		CallerAgeGroup = callerAgeGroup;
	}

}
