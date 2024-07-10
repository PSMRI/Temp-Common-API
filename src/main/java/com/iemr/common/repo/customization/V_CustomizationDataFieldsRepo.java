package com.iemr.common.repo.customization;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.customization.V_CustomizationDataFields;

@Repository
public interface V_CustomizationDataFieldsRepo extends CrudRepository<V_CustomizationDataFields, String> {

	@Query("SELECT sp FROM V_CustomizationDataFields sp WHERE sp.serviceLine = :serviceLine AND sp.serviceLineId = :serviceLineId AND sp.stateId = :stateId AND sp.districtId = :districtId AND sp.blockId = :blockId AND (sp.serviceProviderId = :serviceProviderId OR sp.serviceProviderId = 0) AND sp.projectId=:projectId")
	List<V_CustomizationDataFields> getAllData(@Param("serviceLine") String serviceLine,
			@Param("serviceLineId") Integer serviceLineId, @Param("stateId") Integer stateId,
			@Param("districtId") Integer districtId, @Param("blockId") Integer blockId,
			@Param("serviceProviderId") Integer serviceProviderId, @Param("projectId") Integer projectId);

}
