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
package com.iemr.common.repository.directory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.directory.InstituteDirectoryMapping;

@Repository
@RestResource(exported = false)
public interface DirectoryMappingRepository extends CrudRepository<InstituteDirectoryMapping, Long>
{
	// @Query("select new InstituteDirectoryMapping(m.instituteDirMapID, m.institutionID, m.institute, m.deleted, "
	// + "m.instituteDirectoryID, m.directory, m.instituteSubDirectoryID, m.subDirectory) "
	// + "from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
	// + "where m.instituteDirectoryID = :instituteDirectoryID and "
	// + "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
	// + "m.institutionID = i.institutionID order by i.institutionName asc")
	@Query("select m from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
			+ "where m.instituteDirectoryID = :instituteDirectoryID and "
			+ "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
			+ "m.institutionID = i.institutionID order by i.institutionName asc")
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(
			@Param("instituteDirectoryID") Integer instituteDirectoryID,
			@Param("instituteSubDirectoryID") Integer instituteSubDirectoryID);

	// @Query("select new InstituteDirectoryMapping(m.instituteDirMapID, m.institutionID, m.institute, m.deleted, "
	// + "m.instituteDirectoryID, m.directory, m.instituteSubDirectoryID, m.subDirectory) "
	// + "from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
	// + "where m.instituteDirectoryID = :instituteDirectoryID and "
	// + "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
	// + "m.institutionID = i.institutionID and i.stateID = :stateID and i.districtID = :districtID "
	// + "order by i.institutionName asc")
	@Query("select m from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
			+ "where m.instituteDirectoryID = :instituteDirectoryID and "
			+ "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
			+ "m.institutionID = i.institutionID and i.stateID = :stateID and i.districtID = :districtID "
			+ "order by i.institutionName asc")
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(
			@Param("instituteDirectoryID") Integer instituteDirectoryID,
			@Param("instituteSubDirectoryID") Integer instituteSubDirectoryID, @Param("stateID") Integer stateID,
			@Param("districtID") Integer districtID);

	// @Query("select new InstituteDirectoryMapping(m.instituteDirMapID, m.institutionID, m.institute, m.deleted, "
	// + "m.instituteDirectoryID, m.directory, m.instituteSubDirectoryID, m.subDirectory) "
	// + "from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
	// + "where m.instituteDirectoryID = :instituteDirectoryID and "
	// + "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
	// + "m.institutionID = i.institutionID and i.stateID = :stateID and "
	// + "i.districtID = :districtID and i.blockID = :blockID order by i.institutionName asc")
	@Query("select m from InstituteDirectoryMapping m join m.institute i join m.directory join m.subDirectory "
			+ "where m.instituteDirectoryID = :instituteDirectoryID and "
			+ "m.instituteSubDirectoryID = :instituteSubDirectoryID and "
			+ "m.institutionID = i.institutionID and i.stateID = :stateID and "
			+ "i.districtID = :districtID and i.blockID = :blockID order by i.institutionName asc")
	public List<InstituteDirectoryMapping> findAciveInstituteDirectories(
			@Param("instituteDirectoryID") Integer instituteDirectoryID,
			@Param("instituteSubDirectoryID") Integer instituteSubDirectoryID, @Param("stateID") Integer stateID,
			@Param("districtID") Integer districtID, @Param("blockID") Integer blockID);
}
