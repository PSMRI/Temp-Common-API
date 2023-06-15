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
package com.iemr.common.repository.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.email.MDSR_CDREmail;

@Repository
@RestResource(exported = false)
public interface MDSR_CDREmailRepository extends CrudRepository<MDSR_CDREmail, Long>{

	@Query("SELECT mdsr_cdr FROM MDSR_CDREmail mdsr_cdr where mdsr_cdr.requestID = :requestID")
	MDSR_CDREmail getMSDR_CDRBenDetails(@Param("requestID") String requestID );
	
	@Query(value="call Pr_Benimrmmr_Demographicdetails(:VDistrict,:VBlock,:VVillage,:IDistrict,:IBlock,:IVIllage,:baseCommunityID,:transitTypeID)", nativeQuery=true)
	public ArrayList<Object[]> getDemographicDetails(@Param("VDistrict") Integer VDistrict,
			@Param("VBlock") Integer VBlock,@Param("VVillage") Integer VVillage,
			@Param("IDistrict") Integer IDistrict,@Param("IBlock") Integer IBlock,
			@Param("IVIllage") Integer IVIllage,@Param("transitTypeID") Integer transitTypeID,
			@Param("baseCommunityID") Integer baseCommunityID);
}
