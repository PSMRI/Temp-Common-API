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
package com.iemr.common.model.feedback;

import java.sql.Timestamp;
import java.util.Calendar;

import lombok.Data;

@Data
public class FeedbackListRequestModel
{
	private Integer serviceID;
	private Long beneficiaryRegID;
	private Long feedbackID;
	private String requestID;
	private Timestamp startDate = new Timestamp(0);
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	private Integer feedbackTypeID;
	private Boolean is1097 = false;
	private Long benCallID;
	private String phoneNum;
}
