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
package com.iemr.common.service.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.repository.category.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService
{

	@Override
	public List<SubCategoryDetails> getSubCategories(Integer id)
	{

		List<SubCategoryDetails> subCategoryList = new ArrayList<SubCategoryDetails>();
		ArrayList<Objects[]> lists = subCategoryRepository.findBy(id);
		for (Object[] objects : lists)
		{
			if (objects != null && objects.length > 0)
			{
				subCategoryList.add(new SubCategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}

		return subCategoryList;
	}

	/**
	 * sub category repository
	 */
	private SubCategoryRepository subCategoryRepository;

	/**
	 * inject sub category
	 */
	@Autowired
	public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository)
	{

		this.subCategoryRepository = subCategoryRepository;
	}

}
