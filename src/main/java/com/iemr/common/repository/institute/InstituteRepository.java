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
package com.iemr.common.repository.institute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.institute.Institute;

@Repository
@RestResource(exported = false)
public abstract interface InstituteRepository extends CrudRepository<Institute, Integer>
{
	@Query("select institutionID, institutionName from Institute where "
			+ "Deleted = false and districtBranchMappingID = :districtBranchMappingID "
			+ "order by institutionName asc")
	public abstract Set<Objects[]>
			findAciveInstitutesByBranchID(@Param("districtBranchMappingID") int districtBranchMappingID);

	@Query("select institutionID, institutionName from Institute where "
			+ "Deleted = false and districtBranchMappingID = :districtBranchMappingID and "
			+ "districtID = :districtID and stateID = :stateID order by institutionName asc")
	public abstract Set<Objects[]> findAciveInstitutesByStateDistBlockID(@Param("stateID") int stateID,
			@Param("districtID") int districtID, @Param("districtBranchMappingID") int districtBranchMappingID);
	
	@Query("select institutionID, institutionName from Institute where instituteTypeId =:institutionTypeId")
	public ArrayList<Object[]> getInstitutionNameByType(@Param("institutionTypeId") int institutionTypeId);
	
	@Query("select institutionID, institutionName from Institute where instituteTypeId =:institutionTypeId and districtID =:districtID  ")
	public ArrayList<Object[]> getInstitutionNameByTypeAndDistrict(@Param("institutionTypeId") int institutionTypeId,@Param("districtID") int districtID);
}
