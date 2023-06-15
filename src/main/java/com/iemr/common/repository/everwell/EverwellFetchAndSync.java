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
package com.iemr.common.repository.everwell;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.everwell.EverwellDetails;

@Repository
@RestResource(exported = false)
public interface EverwellFetchAndSync  extends CrudRepository<EverwellDetails, Long> {
	
	@Query("select  req from EverwellDetails req  where req.dateOfAction >= :previous and req.dateOfAction <= :current "
			+ "and req.dateOfAction is not null and req.actionTaken is not null and req.category is not null "
			+ "and req.subCategory is not null and req.comments is not null and req.isRegistered=true and req.isCompleted =true and req.processed= 'N' ")
	ArrayList<EverwellDetails> findRecords(@Param("current") Timestamp current,@Param("previous") Timestamp previous);
	
	@Query("select count(Id),isRegistered,beneficiaryRegId,providerServiceMapId,vanId,beneficiaryID from EverwellDetails t where t.Id= :userID and t.isRegistered = true")
	ArrayList<Object[]> registrationStatus(@Param("userID") Long userID);
	
	@Query("select req from EverwellDetails req where req.createdDate >= :previous and req.createdDate <= :current and "
			+ "req.isRegistered=true and req.isCompleted =true and req.processed= 'N'")
	ArrayList<EverwellDetails> getPatientID(@Param("current") Timestamp current,@Param("previous") Timestamp previous);
	

}
