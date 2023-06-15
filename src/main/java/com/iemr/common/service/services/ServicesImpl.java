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
package com.iemr.common.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.users.ServiceMaster;
import com.iemr.common.repository.services.ServiesRepository;

@Service
public class ServicesImpl implements Services {

	private ServiesRepository serviesRepository;
	@Autowired
	public void setServiesRepository(ServiesRepository serviesRepository) {
		this.serviesRepository = serviesRepository;
	}

	@Override
	public List<ServiceMaster> servicesList() {
		List<ServiceMaster> servicesList = new ArrayList<ServiceMaster>();
		Set<Objects[]> servicesResult = serviesRepository.getActiveServicesList();
		for (Object[] object : servicesResult) {
			if (object != null && object.length >= 4) {
				servicesList.add(new ServiceMaster((Integer) object[0], (String) object[1], (String) object[2],
						(Boolean) object[3]));
			}
		}
		return servicesList;
	}

}
