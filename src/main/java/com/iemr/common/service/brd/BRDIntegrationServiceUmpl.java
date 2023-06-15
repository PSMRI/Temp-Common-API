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
package com.iemr.common.service.brd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.common.data.brd.BRDIntegrationData;
import com.iemr.common.repository.brd.BRDIntegrationRepository;


@Service
public class BRDIntegrationServiceUmpl implements BRDIntegrationService {

	@Autowired
	private BRDIntegrationRepository repo;

	@Override
	public String getData(String startDate, String endDate) {
		List<BRDIntegrationData> response = new ArrayList<BRDIntegrationData>();
		List<BRDIntegrationData> list = new ArrayList<BRDIntegrationData>();
		ArrayList<Object[]> data = repo.getData(startDate, endDate);
		Map<BigInteger, BRDIntegrationData> map = new HashMap<BigInteger, BRDIntegrationData>();
		List<BRDIntegrationData> brdDetails = BRDIntegrationData.getBRDDetails(data);
		if (null != brdDetails && !ObjectUtils.isEmpty(brdDetails)) {
			for (BRDIntegrationData brdIntegrationData : brdDetails) {
				if (map.containsKey(brdIntegrationData.getPrescriptionId())) {
					BRDIntegrationData brdIntegrationData2 = map.get(brdIntegrationData.getPrescriptionId());
					if (brdIntegrationData2.getPrescriptionId().equals(brdIntegrationData.getPrescriptionId())) {
						String existdrugName = brdIntegrationData2.getDrugName();
						String drugName = brdIntegrationData.getDrugName();
						String concat = existdrugName.concat(",").concat(drugName);
						brdIntegrationData2.setDrugName(concat);
					} else {
						if (null != brdIntegrationData.getPrescriptionId()) {
							map.put(brdIntegrationData.getPrescriptionId(), brdIntegrationData);
						} else {
							list.add(brdIntegrationData);
						}
					}
				} else {
					if (null != brdIntegrationData.getPrescriptionId()) {
						map.put(brdIntegrationData.getPrescriptionId(), brdIntegrationData);
					} else {
						list.add(brdIntegrationData);
					}
				}
			}
		}
		if (!ObjectUtils.isEmpty(list)) {
			response.addAll(list);
		}
		if (map.size() > 0) {
			response.addAll(map.values());
		}
		  GsonBuilder builder = new GsonBuilder();
		  builder.serializeNulls();
		  builder.setPrettyPrinting();
		  Gson gson = builder.create();
		  return gson.toJson(response);
		
	}

}
