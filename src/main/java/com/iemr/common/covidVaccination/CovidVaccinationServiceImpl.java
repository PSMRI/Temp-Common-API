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
package com.iemr.common.covidVaccination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class CovidVaccinationServiceImpl implements CovidVaccinationService {

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private CovidDoseTypeRepo covidDoseTypeRepo;

	@Autowired
	private CovidVaccineTypeRepo covidVaccineTypeRepo;

	@Autowired
	private CovidVaccinationRepo covidVaccinationRepo;

	@Override
	public String getVaccinationTypeAndDoseTaken() {
		Map<String, Object> responseMap = new HashMap<String, Object>();

		Iterable<CovidVaccineType> vaccineTypeList = new ArrayList<CovidVaccineType>();
		vaccineTypeList = covidVaccineTypeRepo.findAll();

		Iterable<CovidDoseType> doseTypeList = new ArrayList<CovidDoseType>();
		doseTypeList = covidDoseTypeRepo.findAll();

		responseMap.put("vaccineType", vaccineTypeList);
		responseMap.put("doseType", doseTypeList);

		return new Gson().toJson(responseMap);

	}

	@Override

	public String getCovidVaccinationDetails(Long benRegId) throws IEMRException {
		CovidVaccinationStatus benVaccinationDetails = new CovidVaccinationStatus();
		try {
			benVaccinationDetails = covidVaccinationRepo.findByBeneficiaryRegID(benRegId);
            if(benVaccinationDetails == null || benVaccinationDetails.getCovidVSID() == null)
            	return "No data found";
		} catch (Exception e) {
			logger.error(e.toString());

			throw new IEMRException(e.toString());
		}

		return new Gson().toJson(benVaccinationDetails);

	}

	/***
	 * 
	 */
	@Override
	public String saveBenCovidVaccinationDetails(String request) throws IEMRException {
		CovidVaccinationStatus covidVaccinationStatus = null;
		try {
			covidVaccinationStatus = InputMapper.gson().fromJson(request, CovidVaccinationStatus.class);
			if(covidVaccinationStatus != null && covidVaccinationStatus.getCovidVSID() != null) {
				covidVaccinationStatus.setProcessed("U");
			}
			covidVaccinationStatus = covidVaccinationRepo.save(covidVaccinationStatus);
			if (covidVaccinationStatus == null || covidVaccinationStatus.getCovidVSID() == null) {
				throw new IEMRException("Failed to save covid vaccination details");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			throw new IEMRException(e.toString());
		}
		return new Gson().toJson(covidVaccinationStatus);
	}
}
