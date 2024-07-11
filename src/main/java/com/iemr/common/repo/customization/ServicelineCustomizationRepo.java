package com.iemr.common.repo.customization;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.common.data.customization.ServicelineCustomization;

import jakarta.transaction.Transactional;

public interface ServicelineCustomizationRepo extends CrudRepository<ServicelineCustomization, Integer> {

	@Query("Select t from ServicelineCustomization t where t.serviceLineId = :serviceLineId and t.serviceLine=:serviceLine and t.stateId=:stateId and t.stateName=:stateName and t.districtId=:districtId and t.districtName=:districtName and t.serviceProviderId=:serviceProviderId and t.deleted=false")
	List<ServicelineCustomization> getServicelineProject(@Param("serviceLineId") Integer serviceLineId,
			@Param("serviceLine") String serviceLine, @Param("stateId") Integer stateId,
			@Param("stateName") String stateName, @Param("districtId") Integer districtId,
			@Param("districtName") String districtName, @Param("serviceProviderId") Integer serviceProviderId);

	/*
	 * @Query("SELECT p.serviceProviderId FROM ServicelineCustomization p WHERE p.serviceProviderId = :serviceProviderId"
	 * ) public Integer findServiceProviderId(@Param("serviceProviderId") Integer
	 * serviceProviderId);
	 */
	
	@Query("SELECT p.id FROM ServicelineCustomization p WHERE p.serviceProviderId = :serviceProviderId and p.serviceLineId = :serviceLineId and p.stateId = :stateId and "
			+ "p.districtId = :districtId and p.blockId = :blockId AND p.deleted=false")
	public Integer findServiceProviderId(@Param("serviceProviderId") Integer serviceProviderId,@Param("serviceLineId") Integer serviceLineId,
			@Param("stateId") Integer stateId,@Param("districtId") Integer districtId,
			@Param("blockId") Integer blockId);

	@Query("SELECT p FROM ServicelineCustomization p WHERE p.serviceLineId = :serviceLineId and p.serviceProviderId= :serviceProviderId and p.stateId = :stateId and p.districtId= :districtId and p.blockId= :blockId and p.deleted=false")
	Set<ServicelineCustomization> findByProjectName(@Param("serviceLineId") Integer serviceLineId,
			@Param("serviceProviderId") Integer serviceProviderId, @Param("stateId") Integer stateId,
			@Param("districtId") Integer districtId, @Param("blockId") Integer blockId);

	@Transactional
	@Modifying
	@Query("Update ServicelineCustomization s Set s.deleted=:deleted where s.projectId=:projectId And s.projectName=:projectName")
	int updateDeletedFlag(@Param("projectId") Integer projectId,
			@Param("projectName") String projectName, @Param("deleted") Boolean deleted);
	
	@Query("Select t from ServicelineCustomization t where t.serviceLineId = :serviceLineId and t.serviceLine=:serviceLine and t.stateId=:stateId and t.districtId=:districtId and t.blockId=:blockId and t.serviceProviderId=:serviceProviderId and t.deleted=false")
	ServicelineCustomization checkExistingData(@Param("serviceLineId") Integer serviceLineId,
			@Param("serviceLine") String serviceLine, @Param("stateId") Integer stateId,
			@Param("districtId") Integer districtId,
			@Param("blockId") Integer blockId, @Param("serviceProviderId") Integer serviceProviderId);

}
