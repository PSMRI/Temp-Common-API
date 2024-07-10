package com.iemr.common.repo.customization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.customization.SectionAndFieldsMapping;

@Repository
public interface SectionAndFieldsMappingRepo extends CrudRepository<SectionAndFieldsMapping, Integer> {

//	@Query("SELECT sfm FROM SectionAndFieldsMapping sfm WHERE sfm.sectionId = :sectionId AND sfm.serviceProviderId = :serviceProviderId AND sfm.deleted=false")
//	List<SectionAndFieldsMapping> findBySectionIdAndSectionNameAndServiceProviderId(
//			@Param("sectionId") Integer sectionId, @Param("serviceProviderId") Integer serviceProviderId);

	@Query("SELECT sfm FROM SectionAndFieldsMapping sfm WHERE sfm.sectionId = :sectionId AND (sfm.serviceProviderId = :serviceProviderId OR sfm.serviceProviderId= 0)")
	List<SectionAndFieldsMapping> findSectionIdAndSectionNameAndServiceProviderId(
			@Param("sectionId") Integer sectionId, @Param("serviceProviderId") Integer serviceProviderId);
	
	@Query("SELECT sfm FROM SectionAndFieldsMapping sfm WHERE sfm.id = :id")
	SectionAndFieldsMapping getById(@Param("id") Integer id);

	@Query("SELECT sfm FROM SectionAndFieldsMapping sfm WHERE sfm.fieldName = :fieldName")
	List<SectionAndFieldsMapping> getByFieldName(@Param("fieldName") String fieldName);
	
}
