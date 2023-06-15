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
package com.iemr.common.service.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.location.CityDetails;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.repository.location.LocationCityRepository;
import com.iemr.common.repository.location.LocationCountryRepository;
import com.iemr.common.repository.location.LocationDistrictBlockRepository;
import com.iemr.common.repository.location.LocationDistrictRepository;
import com.iemr.common.repository.location.LocationDistrilctBranchRepository;
import com.iemr.common.repository.location.LocationStateRepository;

@Service
public class LocationServiceImpl implements LocationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public List<States> getStates(int id) {
		List<States> stateList = new ArrayList<States>();
		ArrayList<Objects[]> lists = locationStateRepository.findBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length > 0) {
				States state = new States();
				stateList.add(state.getStates((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getStates response " + (stateList.size() > 0 ? stateList.size() : null));
		return stateList;
	}

	@Override
	public List<Districts> getDistricts(int id) {

		List<Districts> districtList = new ArrayList<Districts>();
		ArrayList<Objects[]> lists = locationDistrictRepository.findBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length > 0) {
				districtList.add(new Districts((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getDistricts response " + (districtList.size() > 0 ? districtList.size() : null));
		return districtList;
	}

	@Override
	public List<DistrictBlock> getDistrictBlocks(int id) {

		List<DistrictBlock> districtBlockList = new ArrayList<DistrictBlock>();
		Set<Objects[]> lists = locationDistrictBlockRepository.findBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length > 0) {
				districtBlockList.add(new DistrictBlock((Integer) objects[0], (String) objects[1]));
			}
		}
		logger.info("getDistrictBlocks response " + (districtBlockList.size() > 0 ? districtBlockList.size() : null));
		return districtBlockList;
	}

	/**
	 * Stete repository
	 */
	private LocationStateRepository locationStateRepository;

	/**
	 * 
	 * @param LocationStateRepository
	 */
	@Autowired
	public void setLocationStateRepository(LocationStateRepository locationStateRepository) {

		this.locationStateRepository = locationStateRepository;
	}

	/**
	 * Districts Repository
	 */
	private LocationDistrictRepository locationDistrictRepository;

	@Autowired
	public void setLocationDistrictRepository(LocationDistrictRepository locationDistrictRepository) {

		this.locationDistrictRepository = locationDistrictRepository;
	}

	/**
	 * DistrictModel block repository
	 */
	private LocationDistrictBlockRepository locationDistrictBlockRepository;

	@Autowired
	public void setLocationDistrictBlockRepository(LocationDistrictBlockRepository locationDistrictBlockRepository) {

		this.locationDistrictBlockRepository = locationDistrictBlockRepository;
	}

	@Override
	public List<Districts> findStateDistrictBy(int id) {
		List<Districts> stateDistrictList = new ArrayList<Districts>();
		ArrayList<Objects[]> lists = locationDistrictRepository.findStateDistrictBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 3) {
				System.out.println(objects);
				stateDistrictList.add(new Districts((Integer) objects[0], (String) objects[1], (Integer) objects[3],
						(String) objects[2]));
			}
		}

		return stateDistrictList;
	}

	@Override
	public List<CityDetails> getCities(int id) {

		List<CityDetails> cityList = new ArrayList<CityDetails>();
		Set<Objects[]> lists = locationDistrictBlockRepository.findBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 2) {
				cityList.add(new CityDetails((Integer) objects[0], (String) objects[1]));
			}
		}

		return cityList;
	}

	@Override
	public List<DistrictBranchMapping> getDistrilctBranchs(int id) {

		List<DistrictBranchMapping> distrilctBranchsList = new ArrayList<DistrictBranchMapping>();
		ArrayList<Objects[]> lists = locationDistrilctBranchRepository.findAllBy(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 5) {
				distrilctBranchsList.add(new DistrictBranchMapping((Integer) objects[0], (String) objects[1],
						(String) objects[2], (String) objects[3], (String) objects[4]));
			}
		}
		logger.info("getVillages response " + (distrilctBranchsList.size() > 0 ? distrilctBranchsList.size() : null));
		return distrilctBranchsList;
	}

	private LocationCityRepository locationCityRepository;

	@Autowired
	public void setLocationCityRepository(LocationCityRepository locationCityRepository) {

		this.locationCityRepository = locationCityRepository;
	}

	private LocationDistrilctBranchRepository locationDistrilctBranchRepository;

	@Autowired
	public void setLocationDistrilctBranchRepository(
			LocationDistrilctBranchRepository locationDistrilctBranchRepository) {

		this.locationDistrilctBranchRepository = locationDistrilctBranchRepository;
	}
	
	@Autowired
	private LocationCountryRepository locationCountryRepository;

	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return (List<Country>) locationCountryRepository.findAll();
	}
}
