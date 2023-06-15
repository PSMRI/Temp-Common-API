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
package com.iemr.common.service.directory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.repository.directory.DirectoryMappingRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class DirectoryMappingServiceImpl implements DirectoryMappingService
{
	private DirectoryMappingRepository directoryMappingRepository;

	@Autowired
	public void setDirectoryRepository(DirectoryMappingRepository directoryMappingRepository)
	{
		this.directoryMappingRepository = directoryMappingRepository;
	}

	@Override
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(String request) throws IEMRException
	{
		InstituteDirectoryMapping requestObj = InputMapper.gson().fromJson(request, InstituteDirectoryMapping.class);
		List<InstituteDirectoryMapping> instituteDirectoryMappings = null;
		if (requestObj.getBlockID() != null)
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID(),
					requestObj.getStateID(), requestObj.getDistrictID(), requestObj.getBlockID());
		} else if (requestObj.getStateID() != null && requestObj.getDistrictID() != null)
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID(),
					requestObj.getStateID(), requestObj.getDistrictID());
		} else
		{
			instituteDirectoryMappings = directoryMappingRepository.findAciveInstituteDirectories(
					requestObj.getInstituteDirectoryID(), requestObj.getInstituteSubDirectoryID());
		}
		return instituteDirectoryMappings;
	}
}
