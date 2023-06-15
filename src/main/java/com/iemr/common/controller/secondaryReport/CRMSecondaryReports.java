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
package com.iemr.common.controller.secondaryReport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.CallQualityReport;
import com.iemr.common.model.reports.Report1097RequestModel;
import com.iemr.common.service.reportSecondary.SecondaryReportService;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;
@CrossOrigin
@RequestMapping({ "/crmReports" })
@RestController
public class CRMSecondaryReports {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private SecondaryReportService secondaryReportService;
	@CrossOrigin()
	@RequestMapping(value = "/getQualityReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getQualityReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"agentID\\\":\\\"Integer\\\","
					+ "\\\"roleName\\\":\\\"String\\\",\\\"reportTypeID\\\":\\\"Integer\\\",\\\"reportType\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest)

	{
		String filename = getFileName(jsonRequest,"104QAReport");
		    InputStreamResource file=null;
		    try
		    {
		      file = new InputStreamResource(secondaryReportService.getQualityReport(jsonRequest,filename));
		      return ResponseEntity.ok()
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))
				        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				        .body(file);
		    }
		    catch(Exception e)
		    {
		    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
		    	if(e.getMessage().equalsIgnoreCase("No data found"))
		    	return ResponseEntity.status(500).body(e.getMessage());
		    	else
		    		return ResponseEntity.status(5000).body(e.getMessage());
		    }
	}
	@CrossOrigin()
	@RequestMapping(value = "/getComplaintDetailReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getComplaintDetailReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"agentID\\\":\\\"Integer\\\","
					+ "\\\"roleName\\\":\\\"String\\\",\\\"reportTypeID\\\":\\\"Integer\\\",\\\"reportType\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest)

	{
		String filename ="Grievance_Details.xlsx";

		    InputStreamResource file=null;
		    try
		    {
		    	file = new InputStreamResource(secondaryReportService.getComplaintDetailReport(jsonRequest,"Grievance_Details"));
		      return ResponseEntity.ok()
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				        .body(file);
		    }
		    catch(Exception e)
		    {
		    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
		    	if(e.getMessage().equalsIgnoreCase("No data found"))
		    	return ResponseEntity.status(500).body(e.getMessage());
		    	else
		    	return ResponseEntity.status(5000).body(e.getMessage());
		    }
	}@CrossOrigin()
	@RequestMapping(value = "/getCallSummaryReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getCallSummaryReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"agentID\\\":\\\"Integer\\\",\\\"roleName\\\":\\\"String\\\","
					+ "\\\"callTypeID\\\":\\\"Integer\\\","
					+ "\\\"callTypeName\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest)

	{
		String filename = getFileName(jsonRequest,"Call_Summary_Report");
	    InputStreamResource file=null;
	    
	    try
	    {
	      file = new InputStreamResource(secondaryReportService.getCallSummaryReport(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getAllBySexualOrientation", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object>  getAllBySexualOrientation(
			@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
					+"\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\","
					+"\\\"beneficiarySexualOrientation\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\" }\"") @RequestBody String jsonRequest) {
		String filename = getFileName(jsonRequest,"Sexual_Orientation_Report");
	    InputStreamResource file=null;
	    try
	    {
	      file = new InputStreamResource(secondaryReportService.getAllBySexualOrientationReport(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getDistrictWiseCallReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getDistrictWiseCallReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"districtID\\\":\\\"Integer\\\",\\\"district\\\":\\\"String\\\",\\\"subdistrictID\\\":\\\"Integer\\\",\\\"villageID\\\":\\\"Integer\\\","
					+ "\\\"locationID\\\":\\\"Integer\\\",\\\"roleID\\\":\\\"Integer\\\"}\"") @RequestBody String jsonRequest) 
	{
		String filename = getFileName(jsonRequest,"District_Wise_Call_Volume_Report");
	    InputStreamResource file=null;
	    
	    try
	    {
	      file = new InputStreamResource(secondaryReportService.getDistrictWiseCallReport(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getUnblockedUserReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getUnblockedUserReport(
			@ApiParam(value = "\"{\\\"blockStartDate\\\":\\\"Timestamp\\\",\\\"blockEndDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\"}\"") @RequestBody String jsonRequest,
			HttpServletRequest httpRequest) {
		String filename = getFileName(jsonRequest,"Unblock_User_Report");
	    InputStreamResource file=null;
		try
	    {
	      file = new InputStreamResource(secondaryReportService.getUnblockedUserReport(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCallQualityReport", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getCallQualityReport(
			@ApiParam(value = "\"{\\\"startDate\\\":\\\"Timestamp\\\",\\\"endDate\\\":\\\"Timestamp\\\","
					+ "\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"searchCriteria\\\":\\\"String\\\","
					+"\\\"workingLocationID\\\":\\\"Integer\\\",\\\"filename\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest,
			HttpServletRequest httpRequest) {
		String filename = null;
	    InputStreamResource file=null;
		try
	    {
			CallQualityReport callQualityReport = InputMapper.gson().fromJson(jsonRequest,
					CallQualityReport.class);
		  filename = getFileName(jsonRequest,callQualityReport.getFileName());
	      file = new InputStreamResource(secondaryReportService.getCallQualityReport(callQualityReport,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	
	@CrossOrigin()
	@RequestMapping(value = "/getCountsByPreferredLanguage", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getCountsByPreferredLanguage(
			@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"beneficiaryPreferredLanguage\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\","
					+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest,HttpServletRequest httpRequest) {
		String filename = null;
	    InputStreamResource file=null;
		try {
			
		  filename = getFileName(jsonRequest,"Language_Distribution_Report");
		  file = new InputStreamResource(secondaryReportService.getCountsByPrefferedLanguage(jsonRequest,filename));
		  return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}

	@CrossOrigin
	@RequestMapping(value = "/getAllByAgeGroup", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getAllByAgeGroup(
			@ApiParam(value = "\"{\\\"providerServiceMapID\\\":\\\"Integer\\\",\\\"maxAge\\\":\\\"Integer\\\",\\\"minAge\\\":\\\"Integer\\\",\\\"startTimestamp\\\":\\\"Timestamp\\\","
					+ "\\\"endTimestamp\\\":\\\"Timestamp\\\",\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") @RequestBody String jsonRequest, HttpServletRequest httpRequest) {

			String filename = getFileName(jsonRequest,"Caller_Age_Group_Report");
		    InputStreamResource file=null;
			try
		    {
		      file = new InputStreamResource(secondaryReportService.getAllByAgeGroup(jsonRequest,filename));
		      return ResponseEntity.ok()
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
				        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				        .body(file);
		    }
		    catch(Exception e)
		    {
		    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
		    	if(e.getMessage().equalsIgnoreCase("No data found"))
		    	return ResponseEntity.status(500).body(e.getMessage());
		    	else
		    	return ResponseEntity.status(5000).body(e.getMessage());
		    }
		}

	@CrossOrigin()
	@RequestMapping(value = "/getAllReportsByDate", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getAllReportsByDate(@ApiParam(value = "\"{\\\"providerServiceMapID\\\":\\\"Integer\\\","
			+ "\\\"beneficiaryCallType\\\":\\\"String\\\",\\\"beneficiaryCallSubType\\\":\\\"String\\\","
			+ "\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
			+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\",\\\"gender\\\":\\\"String\\\","
			+ "\\\"beneficiaryPreferredLanguage\\\":\\\"String\\\",\\\"beneficiarySexualOrientation\\\":\\\"String\\\"}\"") 
			@RequestBody String jsonRequest) {
		String filename = getFileName(jsonRequest,"Call_Type_Report");
	    InputStreamResource file=null;
	    
	    try
	    {
	      file = new InputStreamResource(secondaryReportService.getAllReportsByDate(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);
	    }
	    catch(Exception e)
	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getAllByGender", method = RequestMethod.POST, headers = "Authorization")
	public ResponseEntity<Object> getAllByGender(@ApiParam(value = "\"{\\\"startTimestamp\\\":\\\"Timestamp\\\",\\\"endTimestamp\\\":\\\"Timestamp\\\","
			+ "\\\"gender\\\":\\\"String\\\",\\\"providerServiceMapID\\\":\\\"Integer\\\","
			+ "\\\"state\\\":\\\"String\\\",\\\"district\\\":\\\"String\\\"}\"") 
			@RequestBody String jsonRequest) {
		String filename = getFileName(jsonRequest,"Gender_Distribution_Report");
	    InputStreamResource file=null;
	    
	    try
	    {
	      file = new InputStreamResource(secondaryReportService.getAllByGender(jsonRequest,filename));
	      return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + (filename+".xlsx"))//add generic function
			        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			        .body(file);

	    }
	    catch(Exception e)

	    {
	    	logger.error("Report Name:"+filename+" Timestamp:"+System.currentTimeMillis()+" Error: "+e.getMessage());
	    	if(e.getMessage().equalsIgnoreCase("No data found"))
	    	return ResponseEntity.status(500).body(e.getMessage());
	    	else
	    	return ResponseEntity.status(5000).body(e.getMessage());
	    }
	}
	
	public String getFileName(String jsonRequest,String name)
	{
		String fileName=null;
		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(jsonRequest);
		jsnOBJ = jsnElmnt.getAsJsonObject();
		if (jsnOBJ != null && jsnOBJ.has("fileName"))
		{
		 fileName=jsnOBJ.get("fileName").getAsString();
		}
		if(fileName !=null)
		return fileName;
		else
			return name;
	}
}
