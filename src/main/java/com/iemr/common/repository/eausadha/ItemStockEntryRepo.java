package com.iemr.common.repository.eausadha;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.eausadha.ItemStockEntry;

import jakarta.transaction.Transactional;

@Repository
public interface ItemStockEntryRepo extends CrudRepository<ItemStockEntry, Integer> {
	
	@Query(nativeQuery = true, value = " SELECT * FROM db_iemr.t_itemstockentry "
			+ " WHERE ItemID =:itemId and BatchNo =:batchNo LIMIT 1" )
	ItemStockEntry getItemStocks(@Param("itemId")Integer itemId, @Param("batchNo")String batchNo);
	
	@Transactional
	@Modifying
	@Query("UPDATE ItemStockEntry SET vanSerialNo = :itemStockEntryID WHERE itemStockEntryID = :itemStockEntryID")
	int updateVanSerialNo(@Param("itemStockEntryID")Integer itemStockEntryID);

}
