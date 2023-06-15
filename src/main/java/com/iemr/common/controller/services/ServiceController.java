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
package com.iemr.common.controller.services;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.services.Services;
import com.iemr.common.service.services.ServicesImpl;
import com.iemr.common.utils.response.OutputResponse;

@RequestMapping({ "/service" })
@RestController
public class ServiceController
{
	final private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private Services services;

	@Autowired
	public void setServices(ServicesImpl services)
	{
		this.services = services;
	}

	@CrossOrigin()
	@RequestMapping(value = "/serviceList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String serviceList(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		logger.info("serviceList request: " + request);
		try
		{
			response.setResponse(services.servicesList().toString());
		} catch (Exception e)
		{
			logger.error("serviceList failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("serviceList response: " + response.toString());
		return response.toString();
	}
}
