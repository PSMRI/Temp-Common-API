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
package com.iemr.common.controller.everwellTest;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.model.user.LoginRequestModelEverwell;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@RestController
@RequestMapping(value = "/everwell")
public class EverwellController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin()
	@RequestMapping(value = "/getjson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getdata() {
		OutputResponse response = new OutputResponse();
		try {
			// BenCallServicesMappingHistory service1097HistoryDetails =
			// inputMapper.gson().fromJson(beneficiaryRequest,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> serviceHistoryList =
			// servicesHistoryService
			// .getServiceHistory(service1097HistoryDetails.getBeneficiaryRegID());
			String str = null;
			str = "{   \"Success\": true,\"TotalRecords\": 3,\"currentPage\": 1,\"Data\": [{ \r\n"
					+ "					        \"Id\": 1232, \r\n"
					+ "							\"FirstName\": \"Test\", \r\n"
					+ "					        \"LastName\": \"tester\", \r\n"
					+ "							\"Gender\":\"Female\",\r\n"
					+ "					        \"PrimaryNumber\": \"1111111111\", \r\n"
					+ "					        \"MissedDoses\":2, \r\n"
					+ "					        \"FacilityName\": \"Facility X\", \r\n"
					+ "					        \"State\": \"Uttar Pradesh\", \r\n"
					+ "							\"District\": \"Varanasi\", \r\n"
					+ "					        \"AdherencePercentage\": 50 \r\n" + "					      }]\r\n"
					+ "						  }";

//			if(Authorization.equals("Bearer XwvQ8FWJgL1r1coDA9hI9Zfn0BnzSe0MsI5ECb6UhhSFz96ASoh")) {
//					   str = "{   \"Success\": true,\"TotalRecords\": 3,\"currentPage\": 1,\"Data\": [{ \r\n" + 
//					   		"					        \"Id\": 1232, \r\n" + 
//					   		"							\"FirstName\": \"Test\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Female\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1233, \r\n" + 
//					   		"							\"FirstName\": \"TestA\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1234, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1235, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1236, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1237, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1238, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1239, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1240, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1241, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1242, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1243, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1244, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1245, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1246, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1247, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1248, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1249, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1250, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1251, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1252, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1253, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1254, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1255, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1256, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1257, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1258, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1259, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1260, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1261, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1262, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1263, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1264, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1265, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1266, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1267, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1268, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1269, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1270, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1271, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1272, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1273, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1274, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1275, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1276, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1277, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1278, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1279, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1280, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      },{ \r\n" + 
//					   		"					        \"Id\": 1281, \r\n" + 
//					   		"							\"FirstName\": \"TestB\", \r\n" + 
//					   		"					        \"LastName\": \"tester\", \r\n" + 
//					   		"							\"Gender\":\"Male\",\r\n" + 
//					   		"					        \"PrimaryNumber\": \"1111111111\", \r\n" + 
//					   		"					        \"MissedDoses\":2, \r\n" + 
//					   		"					        \"FacilityName\": \"Facility X\", \r\n" + 
//					   		"					        \"State\": \"Uttar Pradesh\", \r\n" + 
//					   		"							\"District\": \"Varanasi\", \r\n" + 
//					   		"					        \"AdherencePercentage\": 50 \r\n" + 
//					   		"					      }] }";
//			}

			String str1 = "\"Success\":true";
			response.setResponse(str);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = {
			"/addSupportAction/{id}" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String addSupportAction(@PathVariable("id") Long id, @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			// BenCallServicesMappingHistory service1097HistoryDetails =
			// inputMapper.gson().fromJson(beneficiaryRequest,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> serviceHistoryList =
			// servicesHistoryService
			// .getServiceHistory(service1097HistoryDetails.getBeneficiaryRegID());

			String str = "{   \"Id\": 123456789," + "\"UserId\": 123," + "\"UserDescription\": \"Demo Login\",\r\n"
					+ "\"ActionTaken\": \"Call\",\r\n" + " \"Comments\": \"Well, This is a Sample Comment\",\r\n"
					+ "\"Category\": \"Support_Action_Call\",\r\n" + "\"SubCategory\": \"Dose not taken\",\r\n"
					+ "\"Timestamp\": \"2020-04-02T04:18:43.4373395\",\r\n"
					+ "\"DateOfAction\": \"2020-03-02T00:00:00\" } ";
			response.setResponse(str);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = {
			"/editManualDoses/{id}" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String editManualDoses(@PathVariable("id") Long id, @RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			// BenCallServicesMappingHistory service1097HistoryDetails =
			// inputMapper.gson().fromJson(beneficiaryRequest,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> serviceHistoryList =
			// servicesHistoryService
			// .getServiceHistory(service1097HistoryDetails.getBeneficiaryRegID());

			String str = "{     \"PatientId\": 123456789,     \"Note\": {         \"Id\": 0,         \"UserId\": 123,         \"UserDescription\": \"Demo Login\",         \"ActionTaken\": \"Manual doses marked for 2/3/2020, 3/3/2020, 7/3/2020\",         \"Comments\": null,         \"Category\": null,         \"SubCategory\": null,         \"Timestamp\": \"2020-03-20T04:13:17.6245221\",         \"DateOfAction\": null     },     \"AdherenceString\": \"8999999999966666666666666666666\" } \r\n";
			response.setResponse(str);
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String everwellLogin(@RequestBody LoginRequestModelEverwell login) {

		OutputResponse response = new OutputResponse();
		logger.info("It reaches here ");
//		System.out.println("It reaches here");
		try {
			String responseData = null;
//			String remoteAddress = request.getHeader("X-FORWARDED-FOR");
			if (login.getEverwellUserName().equalsIgnoreCase("everwellUser")
					&& login.getEverwellPassword().equals("everwellpass")) {

				responseData = "{\r\n"
						+ " \"access_token\": \"Bearer XwvQ8FWJgL1r1coDA9hI9Zfn0BnzSe0MsI5ECb6UhhSFz96ASoh\",\r\n"
						+ " \"token_type\": \"bearer\",\r\n" + " \"expires_in\": 2591999,\r\n"
						+ " \"userName\": \"<username-used-in-login>\",\r\n"
						+ " \".issued\": \"Mon, 23 Nov 2019 16:18:08 GMT\",\r\n"
						+ " \".expires\": \"Wed, 22 Dec 2020 16:18:08 GMT\"\r\n" + "}\r\n" + "";

			}
			response.setResponse(responseData);
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}
}