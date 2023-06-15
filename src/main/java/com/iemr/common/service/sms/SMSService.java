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
package com.iemr.common.service.sms;

import java.util.List;

import com.iemr.common.model.sms.CreateSMSRequest;
import com.iemr.common.model.sms.SMSParameterModel;
import com.iemr.common.model.sms.SMSRequest;
import com.iemr.common.model.sms.SMSTypeModel;
import com.iemr.common.model.sms.UpdateSMSRequest;

public interface SMSService
{
	public String getSMSTemplates(SMSRequest smsRequest) throws Exception;

	public String updateSMSTemplate(UpdateSMSRequest smsRequest) throws Exception;

	public String saveSMSTemplate(CreateSMSRequest smsRequest) throws Exception;

	public String getSMSTypes(SMSTypeModel request) throws Exception;

	public String getSMSParameters(SMSParameterModel request) throws Exception;

	public String sendSMS(List<SMSRequest> requests, String authToken) throws Exception;

	public String getFullSMSTemplate(SMSRequest smsRequest) throws Exception;

	public void publishSMS();
}
