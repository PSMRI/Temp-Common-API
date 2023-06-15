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
package com.iemr.common.repository.lonic;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.iemr.common.data.lonic.LonicDescription;


@Repository
@RestResource(exported = false)
public interface LonicRepository extends JpaRepository<LonicDescription, Long> {
	
	@Query("SELECT DISTINCT s FROM LonicDescription s WHERE "
			+ "(s.component LIKE %:term% OR "
			+ "s.system LIKE %:term% OR "
			+ "s.loinc_Num LIKE %:term% OR "
			+ "s.class1 LIKE %:term% OR "
			+ "s.long_common_name LIKE %:term%) "
			+ "AND s.status = 'ACTIVE'")
	public Page<LonicDescription> findLonicRecordList(@Param("term") String term, Pageable pageable);

}
