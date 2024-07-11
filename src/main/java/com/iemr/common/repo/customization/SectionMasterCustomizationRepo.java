package com.iemr.common.repo.customization;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.common.data.customization.SectionMasterCustomization;

public interface SectionMasterCustomizationRepo extends CrudRepository<SectionMasterCustomization, Integer> {
	@Query("Select s from SectionMasterCustomization s")
	ArrayList<SectionMasterCustomization> findSections();
	
	@Query("Select s.sectionName from SectionMasterCustomization s where s.sectionId = :sectionId and s.deleted=false")
	String findSectionName(@Param("sectionId") Integer sectionId);

}
