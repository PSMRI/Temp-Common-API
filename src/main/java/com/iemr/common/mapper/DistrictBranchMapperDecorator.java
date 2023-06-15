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
package com.iemr.common.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.model.userbeneficiary.DistrictBranchModel;
import com.iemr.common.repository.location.LocationDistrilctBranchRepository;


public abstract class DistrictBranchMapperDecorator implements DistrictBranchMapper
{
	@Autowired
	LocationDistrilctBranchRepository districtBranchRepository;
	
	public DistrictBranchModel districtBranchToModelByID(Integer villageId){
		DistrictBranchModel model = new DistrictBranchModel();
		model = districtBranchToModel(districtBranchRepository.findOne(villageId));
		return model;
	}
}
