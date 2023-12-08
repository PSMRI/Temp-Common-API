package com.iemr.common.repository.eausadha;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.eausadha.ItemStockEntry;

@Repository
@RestResource(exported = false)
public interface ItemStockEntryRepo extends CrudRepository<ItemStockEntry, Integer> {
	
	@Query("Select t from ItemStockEntry t Where t.itemID = :itemId And t.batchNo = :batchNo")
	ItemStockEntry getItemStocks(@Param("itemId")Integer itemId, @Param("batchNo")String batchNo);
	
	@Transactional
	@Modifying
	@Query("UPDATE ItemStockEntry SET vanSerialNo = :itemStockEntryID WHERE itemStockEntryID = :itemStockEntryID")
	int updateVanSerialNo(@Param("itemStockEntryID")Integer itemStockEntryID);

}
