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
package com.iemr.common.service.questionconfig;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.iemr.common.data.questionconfig.QuestionnaireDetail;
import com.iemr.common.repository.questionconfig.QuestionnaireRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	private InputMapper inputMapper = new InputMapper();
	
	/**
	 * Question Type Repository
	 */
	private QuestionnaireRepository questionnaireRepository;
	
	/**
	 * Inject Question Type Repository
	 */
	public void setQuestionnaireRepository(QuestionnaireRepository questionnaireRepository){
		
		this.questionnaireRepository = questionnaireRepository;
	}
	
	@Override
	public String createQuestionnaire(String request) throws IEMRException {
		
		QuestionnaireDetail[] questionnaireDetails = inputMapper.gson().fromJson(request, QuestionnaireDetail[].class);
		
		for(QuestionnaireDetail detail :questionnaireDetails){
			
			detail = questionnaireRepository.save(detail);
		}
		
		return Arrays.toString(questionnaireDetails);
	}

	@Override
	public String getQuestionnaireList() {
		
		return questionnaireRepository.getQuestionnaireList().toString();
	}

}
