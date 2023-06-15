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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.common.data.users.User;
import com.iemr.common.model.user.ChangePasswordModel;
import com.iemr.common.model.user.LoginRequestModel;
import com.iemr.common.model.user.LoginResponseModel;

@Mapper(componentModel = "spring")
public interface UserMapper
{
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({ @Mapping(source = "dto.userName", target = "userName"),
			@Mapping(source = "dto.password", target = "password") })
	User loginRequestToUser(LoginRequestModel dto);

	LoginResponseModel userDataToLoginResponse(User userData);
	
	User loginRequestToUser(ChangePasswordModel dto);
}
