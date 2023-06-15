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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.repository.directory.DirectoryRepository;

@Service
public class DirectoryServiceImpl implements DirectoryService
{
	private DirectoryRepository directoryRepository;

	@Autowired
	public void setDirectoryRepository(DirectoryRepository directoryRepository)
	{
		this.directoryRepository = directoryRepository;
	}

	@Override
	public List<Directory> getDirectories()
	{
		ArrayList<Directory> directories = new ArrayList<Directory>();
		Set<Objects[]> directoryResult = directoryRepository.findAciveDirectories();
		for (Object[] objects : directoryResult)
		{
			if (objects != null && objects.length >= 2)
			{
				directories.add(new Directory((Integer) objects[0], (String) objects[1]));
			}
		}
		return directories;
	}

	@Override
	public List<Directory> getDirectories(Integer providerServiceMapID)
	{
		List<Directory> directories = new ArrayList<Directory>();
		directories = directoryRepository.findAciveDirectories(providerServiceMapID);
		// for (Object[] objects : directoryResult) {
		// if (objects != null && objects.length == 2) {
		// directories.add(new Directory((Integer) objects[0], (String) objects[1]));
		// }
		// }
		return directories;
	}
}
