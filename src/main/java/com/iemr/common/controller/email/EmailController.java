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
package com.iemr.common.controller.email;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.email.EmailService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/emailController")
@RestController
public class EmailController {

	InputMapper inputMapper = new InputMapper();
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private EmailService emailService;

	/**
	 * @param emailService the emailService to set
	 */
	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/SendEmail", method = RequestMethod.POST, headers = "Authorization")
	public String SendEmail(@ApiParam("{\"FeedbackID\":\"Long\",\"emailID\":\"String\",\"is1097\":\"Boolean\"}") @RequestBody String request, HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("SendEmail request " + request);
		try
		{
			response.setResponse(emailService.SendEmail(request, serverRequest.getHeader("Authorization")));
		} catch (Exception e)
		{
			logger.error("SendEmail failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.debug("SendEmail response " + response.toString());
		logger.info("SendEmail response " + response.getStatusCode());
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getAuthorityEmailID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getAuthorityEmailID(@ApiParam(value = "{districtID : Integer}") @RequestBody String severityRequest)
	{

		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(emailService.getAuthorityEmailID(severityRequest));
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/sendEmailGeneral", method = RequestMethod.POST, headers = "Authorization")
	public String sendEmailGeneral(@ApiParam("{\"requestID\":\"String\",\"emailType\":\"String\",\"emailID\":\"String\"}") @RequestBody String requestID, HttpServletRequest serverRequest)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(emailService.sendEmailGeneral(requestID,serverRequest.getHeader("Authorization")));
		} catch (Exception e)
		{
			logger.error("SendEmail failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.debug("SendEmail response " + response.toString());
		logger.info("SendEmail response " + response.getStatusCode());
		return response.toString();
	}
}
