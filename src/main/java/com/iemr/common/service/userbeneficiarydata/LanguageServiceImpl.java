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
package com.iemr.common.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.repository.userbeneficiarydata.GenderRepository;
import com.iemr.common.repository.userbeneficiarydata.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public void setGenderServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> getActiveLanguages() {
		List<Language> genderList = new ArrayList<Language>();
		Set<Objects[]> queryResult =  languageRepository.findAciveLanguages();
		for (Object[] objects : queryResult) {
			if (objects!=null && objects.length == 2) {
				genderList.add(new Language((Integer)objects[0], (String)objects[1]));
			}
		}
		return genderList;
	}
}
