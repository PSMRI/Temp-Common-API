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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.repository.institute.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	DesignationRepository designationRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	public void setDesignationRepository(DesignationRepository designationRepository) {
		this.designationRepository = designationRepository;
	}

	@Override
	public List<Designation> getDesignations() {
		List<Designation> designations = new ArrayList<Designation>();
		designations = designationRepository.findAciveDesignations();
		logger.info("getDesignations returning " + designations);
		return designations;
	}
}
