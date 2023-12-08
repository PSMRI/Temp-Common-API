package com.iemr.common.repository.eausadha;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.eausadha.ItemMaster;

@Repository
@RestResource(exported = false)
public interface ItemMasterRepo extends CrudRepository<ItemMaster, Integer> {
	
	ItemMaster findByItemCode(String drugId);

}
