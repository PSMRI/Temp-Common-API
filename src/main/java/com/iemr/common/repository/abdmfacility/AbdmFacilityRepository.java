package com.iemr.common.repository.abdmfacility;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.users.ProviderServiceAddressMapping;

@Repository
public interface AbdmFacilityRepository extends CrudRepository<ProviderServiceAddressMapping, Integer> {
	
	@Query("SELECT v from ProviderServiceAddressMapping v where v.pSAddMapID = :pssmID")
	ProviderServiceAddressMapping getAbdmFacility(@Param("pssmID") int pssmID);

}
 