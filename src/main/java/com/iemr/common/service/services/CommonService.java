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

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.data.service.SubService;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.data.common.DocFileManager;


public interface CommonService
{
	public Iterable<CategoryDetails> getCategories();

	public Iterable<CategoryDetails> getCategories(String request) throws IEMRException, JsonMappingException, JsonProcessingException;

	public Iterable<SubCategoryDetails> getSubCategories(String request) throws IEMRException, JsonMappingException, JsonProcessingException;

	public Iterable<SubService> getActiveServiceTypes(String request) throws IEMRException, JsonMappingException, JsonProcessingException;
	
//	public List<SubCategoryDetails> getSubCategoriesOfProvider(Integer providerServiceMapID);

	public List<SubCategoryDetails> getSubCategoryFiles(String request) throws IEMRException, JsonMappingException, JsonProcessingException;
	
	public List<SubCategoryDetails> getSubCategoryFilesWithURL(String request) throws IEMRException, JsonMappingException, JsonProcessingException;

	public String saveFiles(List<DocFileManager> docFileManagerList) throws IOException, Exception;

}
