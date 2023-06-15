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
package com.iemr.common.repository.callhandling;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.users.ProviderServiceMapping;

@Repository
@RestResource(exported = false)
public interface DialPreferenceManualRepository extends CrudRepository<ProviderServiceMapping, Long>{

	@Transactional
	@Modifying
	@Query("update ProviderServiceMapping set isDialPreferenceManual = :isDialPreferenceManual, previewWindowTime = :previewWindowTime "
			+ " where providerServiceMapID = :providerServiceMapID")
	public int updateautoPreviewDialFlag(@Param("providerServiceMapID") Integer providerServiceMapID,
			 @Param("isDialPreferenceManual") Boolean isDialPreferenceManual, @Param("previewWindowTime") Integer previewWindowTime);

	
	@Query("SELECT m_ProviderServiceMapping.isDialPreferenceManual, m_ProviderServiceMapping.previewWindowTime "
			+ "FROM ProviderServiceMapping m_ProviderServiceMapping "
			+ "where m_ProviderServiceMapping.providerServiceMapID = :providerServiceMapID ")
	ArrayList<Objects[]> checkAutoPreviewDialing(
			@Param("providerServiceMapID") Integer providerServiceMapID);

}
