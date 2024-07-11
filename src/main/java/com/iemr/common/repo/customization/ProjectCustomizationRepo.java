package com.iemr.common.repo.customization;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.customization.ProjectCustomization;

@Repository
public interface ProjectCustomizationRepo extends CrudRepository<ProjectCustomization, Integer> {


	@Query("SELECT p FROM ProjectCustomization p WHERE p.projectName = :projectName and p.serviceProviderId= :serviceProviderId and p.deleted=false")
	Set<ProjectCustomization> findByProjectName(@Param("projectName") String projectName,
			@Param("serviceProviderId") Integer serviceProviderId);

	@Query("SELECT p FROM ProjectCustomization p WHERE p.serviceProviderId = :serviceProviderId")
	ArrayList<ProjectCustomization> findByServiceProviderId(@Param("serviceProviderId") Integer serviceProviderId);

	@Query("SELECT p.serviceProviderId FROM ProjectCustomization p WHERE p.serviceProviderId = :serviceProviderId")
	public Integer findServiceProviderId(@Param("serviceProviderId") Integer serviceProviderId);


}
