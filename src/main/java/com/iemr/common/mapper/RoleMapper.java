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
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.Role;
import com.iemr.common.data.users.Screen;
import com.iemr.common.model.user.RoleModel;
import com.iemr.common.model.user.RoleFeatureOutputModel;
import com.iemr.common.model.user.ScreenModel;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	RoleModel roleMappingToLoginRole(Role roleObj);

	@IterableMapping(elementTargetType = RoleModel.class)
	List<RoleModel> roleMappingToLoginRole(List<Role> roleObj);

	@Mappings({ @Mapping(source = "roleObj.serviceRoleScreenMappings", target = "featureName"),
			// @Mapping(source = "roleObj.serviceRoleScreenMappings.screen", target = "featureName.screen"),
	})
	RoleFeatureOutputModel roleFeatureMapping(Role roleObj);

	@IterableMapping(elementTargetType = RoleFeatureOutputModel.class)
	List<RoleFeatureOutputModel> roleFeatureMapping(List<Role> roleObj);

//	ScreenModel getScreenModel(Screen screen);
}
