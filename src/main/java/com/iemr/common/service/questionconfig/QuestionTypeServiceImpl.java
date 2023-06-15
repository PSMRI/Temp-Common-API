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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.questionconfig.QuestionTypeDetail;
import com.iemr.common.repository.questionconfig.QuestionTypeRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	InputMapper inputMapper = new InputMapper();
	
	/**
	 * Question Type Repository
	 */
	@Autowired
	private QuestionTypeRepository questionTypeRepository;
	
	/**
	 * Inject Question Type Repository
	 */
	public void setQuestionTypeRepository(QuestionTypeRepository questionTypeRepository){
		
		this.questionTypeRepository = questionTypeRepository;
	}
	
	/**
	 * method to save question type array
	 * @param string request
	 * @throws IEMRException 
	 */
	@Override
	public String createQuestionType(String request) throws IEMRException {
		
		QuestionTypeDetail[] questionTypeDetails = inputMapper.gson().fromJson(request, QuestionTypeDetail[].class);
		
		for(QuestionTypeDetail questionTypeDetail :questionTypeDetails){
			
			questionTypeDetail = questionTypeRepository.save(questionTypeDetail);
		}
		
		return Arrays.toString(questionTypeDetails);
	}

	@Override
	public String getQuestionTypeList() {
		
		return questionTypeRepository.getQuestionTypeList().toString();
	}

}
