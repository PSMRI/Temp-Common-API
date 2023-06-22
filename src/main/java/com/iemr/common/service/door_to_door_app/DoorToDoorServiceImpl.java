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
package com.iemr.common.service.door_to_door_app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.common.data.door_to_door_app.RequestParser;
import com.iemr.common.data.door_to_door_app.V_doortodooruserdetails;
import com.iemr.common.model.user.LoginRequestModel;
import com.iemr.common.repo.door_to_door_app.V_doortodooruserdetailsRepo;
import com.iemr.common.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class DoorToDoorServiceImpl implements DoorToDoorService {

	@Value("${avniRegistrationLimit}")
	private String avniRegistrationLimit;
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${amritUserName}")
	private String amritUserName;

	@Value("${amritPassword}")
	private String amritPassword;

	@Value("${everwell1097userAuthenticate}")
	private String everwell1097userAuthenticate;

	@Value("${everwellRegisterBenficiary}")
	private String everwellRegisterBenficiary;

	@Autowired
	private V_doortodooruserdetailsRepo v_doortodooruserdetailsRepo;

//	@Autowired
//	private RestTemplate restTemplate;
	@Override
	public String getUserDetails(String request) throws Exception {
		Map<String, Object> responseMap = new HashMap<String, Object>();

		Map<String, Object> userMap = new HashMap<>();
		Map<String, Object> stateMap = new HashMap<>();

		ArrayList<Map<String, Object>> distList = new ArrayList<>();
		Map<String, Object> distMap = new HashMap<>();

		ArrayList<Map<String, Object>> blocList = new ArrayList<>();
		Map<String, Object> blocMap = new HashMap<>();

		ArrayList<Map<String, Object>> villageList = new ArrayList<>();
		Map<String, Object> villageMap = new HashMap<>();

		ArrayList<Map<String, Object>> roleList = new ArrayList<>();
		Map<String, Object> roleMap = new HashMap<>();

		Map<Integer, String> blocMapTemp = new HashMap<>();
		Map<Integer, String> villageMapTemp = new HashMap<>();
		Map<Integer, String> roleMapTemp = new HashMap<>();
		Map<Integer, String> distMapTemp = new HashMap<>();

		RequestParser rp = InputMapper.gson().fromJson(request, RequestParser.class);
		if (rp != null && rp.getUserID() != null) {
			ArrayList<V_doortodooruserdetails> resultSet = v_doortodooruserdetailsRepo.findByUserID(rp.getUserID());

			if (resultSet != null && resultSet.size() > 0) {
				userMap.put("userID", resultSet.get(0).getUserID());
				userMap.put("userName", resultSet.get(0).getUserName());
				userMap.put("emergencyContactNo", resultSet.get(0).getEmergencyContactNo());

				stateMap.put("stateID", resultSet.get(0).getStateID());
				stateMap.put("stateName", resultSet.get(0).getStateName());
				stateMap.put("countryID", 1);

				distMap.put("districtID", resultSet.get(0).getDistrictID());
				distMap.put("districtName", resultSet.get(0).getDistrictName());

				// new map for designation
				HashMap<Integer, String> designationMap = new HashMap<>();
				HashMap<String, HashMap<Integer, String>> roleesignationMap = new HashMap<>();

				for (V_doortodooruserdetails obj : resultSet) {
					blocMapTemp.put(obj.getDistrictBlockID(), obj.getBlockName());
					villageMapTemp.put(obj.getDistrictBranchID(), obj.getVillageName());
					roleMapTemp.put(obj.getRoleID(), obj.getRoleName());
					distMapTemp.put(obj.getDistrictID(), obj.getDistrictName());

					designationMap.put(obj.getDesignationId(), obj.getDesignationName());
					roleesignationMap.put(obj.getRoleName(), designationMap);
				}

				if (distMapTemp != null && distMapTemp.size() > 0) {
					for (Map.Entry<Integer, String> entry : distMapTemp.entrySet()) {
						distMap = new HashMap<>();
						distMap.put("districtID", entry.getKey());
						distMap.put("districtName", entry.getValue());

						distList.add(distMap);
					}
				}

				if (blocMapTemp != null && blocMapTemp.size() > 0) {
					for (Map.Entry<Integer, String> entry : blocMapTemp.entrySet()) {
						blocMap = new HashMap<>();
						blocMap.put("blockID", entry.getKey());
						blocMap.put("blockName", entry.getValue());

						blocList.add(blocMap);
					}
				}
				if (villageMapTemp != null && villageMapTemp.size() > 0) {
					for (Map.Entry<Integer, String> entry : villageMapTemp.entrySet()) {
						villageMap = new HashMap<>();
						villageMap.put("districtBranchID", entry.getKey());
						villageMap.put("villageName", entry.getValue());

						villageList.add(villageMap);
					}
				}
				if (roleMapTemp != null && roleMapTemp.size() > 0) {

					String dName = null;
					Integer dID = null;
					for (Map.Entry<Integer, String> entry : roleMapTemp.entrySet()) {
						roleMap = new HashMap<>();
						roleMap.put("roleID", entry.getKey());
						roleMap.put("roleName", entry.getValue());

						if (roleesignationMap.containsKey(entry.getValue())) {
							HashMap<Integer, String> designationMapTemp = roleesignationMap.get(entry.getValue());
							if (designationMapTemp != null && designationMapTemp.size() > 0) {
								int pointer1 = 0;
								for (Map.Entry<Integer, String> entry1 : designationMapTemp.entrySet()) {
									if (pointer1 > 0)
										break;
									else {
										dID = entry1.getKey();
										dName = entry1.getValue();
									}
									pointer1++;
								}
							}
						}

						if (dName != null && dID != null) {
							roleMap.put("designationID", dID);
							roleMap.put("designationName", dName);
						}

						roleList.add(roleMap);
					}
				}

			}

			Map<String, Object> healthInstitutionMap = new HashMap<>();
			healthInstitutionMap.put("state", stateMap);
			healthInstitutionMap.put("districts", distList);
			healthInstitutionMap.put("blockids", blocList);
			healthInstitutionMap.put("districtbranchids", villageList);

			responseMap.put("user", userMap);
			responseMap.put("roleids", roleList);
			responseMap.put("healthInstitution", healthInstitutionMap);

			// System.out.println("hello");
		} else
			throw new Exception("User ID is null or not valid");
		return new Gson().toJson(responseMap);
	}

	public String get_NCD_TB_HRP_Suspected_Status(RequestParser rp) throws Exception {
		ArrayList<Object[]> resultList = v_doortodooruserdetailsRepo.ncd_tb_hrp_Status(rp.getBenRegID());
		if (resultList != null && resultList.size() > 0) {

			rp.setSuspectedHRP((String) resultList.get(0)[0]);
			rp.setSuspectedTB((String) resultList.get(0)[1]);
			rp.setSuspectedNCD((String) resultList.get(0)[2]);
			rp.setSuspectedNCDDiseases((String) resultList.get(0)[3]);

		}

		return new Gson().toJson(rp);
	}

	@Override
	public void scheduleJobForRegisterAvniBeneficiary() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		Integer updateCount = 0;
		Long id = null;
		String json = null;
		String extId = null;
		Long benId = null;
		Integer count = 0;
		try {
			ArrayList<Object[]> list = v_doortodooruserdetailsRepo
					.getAvniBeneficiary(avniRegistrationLimit != null ? Integer.parseInt(avniRegistrationLimit) : 10);

			if (list != null && list.size() > 0) {

				for (Object[] obj : list) {
					id = obj[0] != null ? ((BigInteger) obj[0]).longValue() : null;
					json = obj[1] != null ? obj[1].toString() : null;
					extId = obj[2] != null ? obj[2].toString() : null;
					benId = obj[3] != null ? ((BigInteger) obj[3]).longValue() : null;
					count = v_doortodooruserdetailsRepo.checkIfAvniIdExists(extId);
					if (count > 0)
						logger.info("Beneficiary with Avni Id " + extId + " already exists");
					else {
						MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
						headers.add("Content-Type", "application/json");
						headers.add("AUTHORIZATION", amritUserAuthenticate());
						HttpEntity<Object> requestReg = new HttpEntity<Object>(json, headers);
						ResponseEntity<String> response = restTemplate.exchange(everwellRegisterBenficiary,
								HttpMethod.POST, requestReg, String.class);

						if (response.getStatusCodeValue() == 200 & response.hasBody()) {
							logger.info("registration api response " + response.getBody());
							String responseStr = response.getBody();
							JsonObject jsnOBJ = new JsonObject();
							JsonParser jsnParser = new JsonParser();
							JsonElement jsnElmnt = jsnParser.parse(responseStr);
							jsnOBJ = jsnElmnt.getAsJsonObject();
							JsonObject jsonData = jsnOBJ.getAsJsonObject("data");
							benId = Long.parseLong(jsonData.get("beneficiaryID").getAsString());
							updateCount = v_doortodooruserdetailsRepo.updateAvniBenId(id, benId);
							logger.info("Beneficiary Id " + benId + " registered successfully");
						}
					}
				}
			} else
				logger.info("No new records found");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}

	}

	public String amritUserAuthenticate() {
		String authorization = "";
		String amritUser = amritUserName;
		String amritPass = amritPassword;
		LoginRequestModel loginCredentials = new LoginRequestModel(amritUser, amritPass);
		loginCredentials.setDoLogout(true);
		MultiValueMap<String, String> headersLogin = new LinkedMultiValueMap<String, String>();
		headersLogin.add("Content-Type", "application/json");
		headersLogin.add("AUTHORIZATION", "");
		logger.info("AMRIT login request OBj " + loginCredentials.toString());
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> requestLogin = new HttpEntity<Object>(loginCredentials, headersLogin);
		ResponseEntity<String> responseLogin = restTemplate.exchange(everwell1097userAuthenticate, HttpMethod.POST,
				requestLogin, String.class);
		if (responseLogin.getStatusCodeValue() == 200 & responseLogin.hasBody()) {
			String responseStrLogin = responseLogin.getBody();
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(responseStrLogin);
			jsnOBJ = jsnElmnt.getAsJsonObject();
			JsonObject everwellLoginJsonData = jsnOBJ.getAsJsonObject("data");
			authorization = everwellLoginJsonData.get("key").getAsString();

		}
		return authorization;
	}
}
