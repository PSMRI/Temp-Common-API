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
package com.iemr.common.controller.directory;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.data.directory.SubDirectory;
import com.iemr.common.service.directory.DirectoryMappingService;
import com.iemr.common.service.directory.DirectoryService;
import com.iemr.common.service.directory.SubDirectoryService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/directory")
@RestController
public class DirectoryController
{
	private DirectoryService directoryService;

	@Autowired
	public void setDirectoryService(DirectoryService directoryService)
	{
		this.directoryService = directoryService;
	}

	private InputMapper inputMapper = new InputMapper();
	private SubDirectoryService subDirectoryService;

	@Autowired
	public void setSubDirectoryService(SubDirectoryService subDirectoryService)
	{
		this.subDirectoryService = subDirectoryService;
	}

	private DirectoryMappingService directoryMappingService;

	@Autowired
	public void setDirectoryMappingService(DirectoryMappingService directoryMappingService)
	{
		this.directoryMappingService = directoryMappingService;
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin()
	@RequestMapping(value = "/getDirectory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getDirectory()
	{
		OutputResponse response = new OutputResponse();
		// logger.info("getDirectory request " + directoryRequest);
		try
		{
			// Directory directory =
			// inputMapper.gson().fromJson(directoryRequest, Directory.class);
			JSONObject responseObj = new JSONObject();
			responseObj.put("directory", directoryService.getDirectories());
			response.setResponse(responseObj.toString());
		} catch (Exception e)
		{
			logger.error("getDirectory failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getDirectory response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getDirectoryV1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getDirectoryV1(
			@ApiParam(value = "{\"providerServiceMapID\":\"Integer\"}") @RequestBody String directoryRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getDirectory request " + directoryRequest);
		try
		{
			Directory directory = inputMapper.gson().fromJson(directoryRequest, Directory.class);
			JSONObject responseObj = new JSONObject();
			// responseObj.put("directory",
			// directoryService.getDirectories(directory.getProviderServiceMapID()));
			response.setResponse("{\"directory\":"
					+ directoryService.getDirectories(directory.getProviderServiceMapID()).toString() + "}");
		} catch (Exception e)
		{
			logger.error("getDirectory failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getDirectory response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "This API is used for getting subdirectories for a given institute directory")
	@RequestMapping(value = "/getSubDirectory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getSubDirectory(@ApiParam("{\"instituteDirectoryID\":\"Integer\"}") @RequestBody String subDirectoryRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getSubDirectory request " + subDirectoryRequest);
		try
		{
			JSONObject responseObj = new JSONObject();
			SubDirectory subDirectoryQuery = inputMapper.gson().fromJson(subDirectoryRequest, SubDirectory.class);
			// responseObj.put("subDirectory",
			// subDirectoryService.getSubDirectories(subDirectoryQuery.getInstituteDirectoryID()).toString());
			response.setResponse("{subDirectory:"
					+ subDirectoryService.getSubDirectories(subDirectoryQuery.getInstituteDirectoryID()) + "}");
		} catch (Exception e)
		{
			logger.error("getSubDirectory failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getSubDirectory response " + response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "This API is used for getting institutes for a given directory, subdirectory and location")
	@RequestMapping(value = "/getInstitutesDirectories", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String
			getInstitutesDirectories(@ApiParam(value = "{\"instituteDirectoryID\":\"Integer - directory ID\", "
					+ "\"instituteSubDirectoryID\":\"Integer - sub directory ID\", "
					+ "\"stateID\":\"Integer - State ID\", \"districtID\":\"Integer - district ID\", "
					+ "\"blockID\":\"Optional - Integer - Block ID\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getInstitutesDirectories request " + request);
		try
		{
			List<InstituteDirectoryMapping> instituteDirectoryMappings =
					directoryMappingService.findAciveInstituteDirectories(request);
			response.setResponse(instituteDirectoryMappings.toString());
		} catch (Exception e)
		{
			logger.error("getInstitutesDirectories failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getInstitutesDirectories response " + response.toString());
		return response.toString();
	}
}
