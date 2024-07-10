package com.iemr.common.repo.customization;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.customization.SectionProjectMapping;

@Repository
public interface SectionProjectMappingRepo extends CrudRepository<SectionProjectMapping, Integer> {

	@Query("SELECT sp FROM SectionProjectMapping sp WHERE sp.projectId = :projectId AND sp.projectName = :projectName AND sp.serviceProviderId = :serviceProviderId AND sp.deleted = false")
	List<SectionProjectMapping> findMappedSectionsInProject(@Param("projectId") Integer projectId,
			@Param("projectName") String projectName, @Param("serviceProviderId") Integer serviceProviderId);


}
