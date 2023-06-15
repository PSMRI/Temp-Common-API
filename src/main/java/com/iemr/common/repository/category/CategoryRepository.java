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
package com.iemr.common.repository.category;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.category.CategoryDetails;

@Repository
@RestResource(exported = false)
public interface CategoryRepository extends CrudRepository<CategoryDetails, Integer>
{

	// @Query("select categoryID, categoryName from CategoryDetails where deleted=false " + "order by categoryName asc")
	// public ArrayList<Objects[]> findBy();
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false order by categoryName asc")
	public ArrayList<CategoryDetails> findBy();

	// @Query("select categoryID, categoryName from CategoryDetails "
	// + "where deleted=false and subServiceID=:subServiceID "
	// + "order by categoryName asc")
	// public ArrayList<Objects[]> getAllCategories(@Param("subServiceID") Integer subServiceID);
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID);

	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and isWellBeing = :isWellBeing "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("isWellBeing") Boolean isWellBeing);
	
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and feedbackNatureID=:feedbackNatureID and providerServiceMapID = :providerServiceMapID "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getCategoriesByNatureID(@Param("feedbackNatureID") Integer feedbackNatureID,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	// @Query("select categoryID, categoryName from CategoryDetails "
	// + "where deleted=false and subServiceID=:subServiceID " + "and providerServiceMapID=:providerServiceMapID "
	// + "order by categoryName asc")
	// public ArrayList<Objects[]> getAllCategories(@Param("subServiceID") Integer subServiceID,
	// @Param("providerServiceMapID") Integer providerServiceMapID);
	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and providerServiceMapID=:providerServiceMapID "
			+ "order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select categoryDetails from CategoryDetails categoryDetails "
			+ "where deleted=false and subServiceID=:subServiceID and providerServiceMapID=:providerServiceMapID "
			+ "and isWellBeing = :isWellBeing order by categoryName asc")
	public ArrayList<CategoryDetails> getAllCategories(@Param("subServiceID") Integer subServiceID,
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("isWellBeing") Boolean isWellBeing);
}
