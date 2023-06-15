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
package com.iemr.common.service.institute;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.institute.Institute;
import com.iemr.common.repository.institute.InstituteRepository;

@Service
public class InstituteServiceImpl implements InstituteService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InstituteRepository instituteRepository;

	@Autowired
	public void setInstituteRepository(InstituteRepository instituteRepository) {
		this.instituteRepository = instituteRepository;
	}

	@Override
	public List<Institute> getInstitutesByStateDistrictBranch(Integer stateID, Integer districtID, Integer districtBranchID) {
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		Set<Objects[]> instituteResult = instituteRepository.findAciveInstitutesByStateDistBlockID(stateID, districtID,
				districtBranchID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getInstitutesByLocation response size" +  (institutes.size() > 0 ? institutes.size() : "No Beneficiary Found") );
		return institutes;
	}

	@Override
	public List<Institute> getInstitutesByBranch(Integer districtBranchID) {
		ArrayList<Institute> institutes = new ArrayList<Institute>();
		Set<Objects[]> instituteResult = instituteRepository.findAciveInstitutesByBranchID(districtBranchID);
		for (Object[] objects : instituteResult) {
			if (objects != null && objects.length == 2) {
				institutes.add(new Institute((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getInstituteByBranch response size" + (institutes.size() > 0 ? institutes.size() : "No Beneficiary Found"));
		return institutes;
	}
}
