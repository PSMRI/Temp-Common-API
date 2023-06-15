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

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.category.SubCategoryDetails;

@Repository
@RestResource(exported = false)
public interface SubCategoryRepository extends CrudRepository<SubCategoryDetails, Integer>
{
	@Query("select subCategoryID, subCategoryName, subCatFilePath from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false order by subCategoryName asc")
	public ArrayList<Objects[]> findByCategoryID(@Param("categoryId") Integer categoryId);

	@Query("select subCategoryID, subCategoryName from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false order by subCategoryName asc")
	public ArrayList<Objects[]> findBy(@Param("categoryId") Integer categoryId);

	@Query("select scd.subCatFilePath from SubCategoryDetails scd "
			+ "where scd.subCategoryID = :subCategoryID and deleted = false")
	public String findFilePathBySubCategoryId(@Param("subCategoryID") Integer subCategoryID);

	@Transactional
	@Modifying
	@Query("update SubCategoryDetails set subCatFilePath = :subCatFilePath where subCategoryID = :subCategoryID")
	public int updateFilePath(@Param("subCategoryID") Integer subCategoryID,
			@Param("subCatFilePath") String subCatFilePath);

	@Query("select new SubCategoryDetails(subCat.subCategoryID, subCat.subCategoryName, subCat.subCatFilePath, cat) "
			+ "from SubCategoryDetails subCat join subCat.categoryDetails cat "
			+ "where cat.providerServiceMapID = :providerServiceMapID and subCat.deleted = false and cat.deleted = false "
			+ "order by subCat.subCategoryName asc")
	public ArrayList<SubCategoryDetails> findByProviderServiceMapID(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select new SubCategoryDetails(subCat.subCategoryID, subCat.subCategoryName, subCat.subCatFilePath, cat) "
			+ "from SubCategoryDetails subCat join subCat.categoryDetails cat "
			+ "where cat.providerServiceMapID = :providerServiceMapID and "
			+ "cat.categoryID = :categoryID and subCat.deleted = false and cat.deleted = false "
			+ "order by subCat.subCategoryName asc")
	public ArrayList<SubCategoryDetails> findByProviderServiceMapCategoryID(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("categoryID") Integer categoryID);

	@Query("select new SubCategoryDetails(subCat.subCategoryID, subCat.subCategoryName, subCat.subCatFilePath, cat) "
			+ "from SubCategoryDetails subCat join subCat.categoryDetails cat "
			+ "where subCat.subCategoryID = :subCategoryID and subCat.deleted = false and cat.deleted = false "
			+ "order by subCat.subCategoryName asc")
	public ArrayList<SubCategoryDetails> findBySubCategoryID(@Param("subCategoryID") Integer subCategoryID);
}
