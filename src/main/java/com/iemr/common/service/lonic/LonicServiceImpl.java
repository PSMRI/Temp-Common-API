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
package com.iemr.common.service.lonic;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.iemr.common.utils.mapper.OutputMapper;
import com.iemr.common.data.lonic.LonicDescription;
import com.iemr.common.repository.lonic.LonicRepository;


@Service
@PropertySource("classpath:application.properties")
public class LonicServiceImpl implements LonicService {
	
	@Value("${lonicPageSize}")
	private Integer lonicPageSize;
	private LonicRepository lonicRepository;
	
	@Autowired
	public void setLonicRepository(LonicRepository lonicRepository) {
		this.lonicRepository = lonicRepository;
	}

	
	@Override
	public String findLonicRecordList(LonicDescription lonicDescription) throws Exception {
		
		Map<String, Object> dataMap = new HashMap<>();
		Page<LonicDescription> lonicList;
		if (lonicDescription != null && lonicDescription.getTerm() != null  && lonicDescription.getPageNo() != null) {
			
			PageRequest pr = new PageRequest(lonicDescription.getPageNo(), lonicPageSize);
			lonicList = lonicRepository.findLonicRecordList(lonicDescription.getTerm(),pr);

			dataMap.put("lonicMaster", lonicList.getContent());
			dataMap.put("pageCount", lonicList.getTotalPages());
			return OutputMapper.gson().toJson(dataMap);
		} else
			throw new Exception("invalid request");

	}

}
