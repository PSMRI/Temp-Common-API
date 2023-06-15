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
package com.iemr.common.repository.scheme;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.scheme.Scheme;

@Repository
@RestResource(exported = false)
public interface SchemeRepository extends CrudRepository<Scheme, Long>
{

	@Query("select s.schemeID, s.schemeName, s.schemeDesc, s.kmFileManagerID, s.providerServiceMapID, s.deleted, s.createdBy, "
			+ "s.kmFileManager  from Scheme s Left JOIN s.kmFileManager k "
			+ "where s.providerServiceMapID=:providerServiceMapID " + "order by s.schemeName asc")
	public List<Objects[]> getschemeList(@Param("providerServiceMapID") Integer providerServiceMapID) throws Exception;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update Scheme set kmFileManagerID = :kmFileManagerID where schemeID = :schemeID")
	Integer updateScheme(@Param("schemeID") Integer schemeID, @Param("kmFileManagerID") Integer kmFileManagerID);

	@Query("SELECT u FROM Scheme u where u.schemeID = :schemeID")
	Scheme getSchemeByID(@Param("schemeID") Integer schemeID);

}
