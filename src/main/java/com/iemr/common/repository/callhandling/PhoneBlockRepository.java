/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.repository.callhandling;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.callhandling.PhoneBlock;

@Repository
@RestResource(exported = false)
public interface PhoneBlockRepository extends CrudRepository<PhoneBlock, Long> {
	@Query("select phoneBlock.phoneBlockID, phoneBlock.phoneNo, phoneBlock.providerServiceMapID, "
			+ "phoneBlock.noOfNuisanceCall, phoneBlock.isBlocked, phoneBlock.ctiCampaignName, "
			+ "phoneBlock.blockStartDate, phoneBlock.blockEndDate, phoneBlock.callIDs from PhoneBlock phoneBlock "
			+ "where phoneBlock.providerServiceMapID = :providerServiceMapID "
			+ "and ((phoneBlock.blockStartDate >= :startDate and phoneBlock.blockStartDate <= :endDate ) "
			+ "or (phoneBlock.blockEndDate >= :startDate and phoneBlock.blockEndDate <= :endDate )) "
			+ "and phoneBlock.isBlocked in :blockedList and phoneBlock.phoneNo like :phoneNo "
			+ "and phoneBlock.noOfNuisanceCall > 0 order by phoneBlock.noOfNuisanceCall desc")
	Set<Objects[]> getPhoneBlockListByServiceProviderMapID(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("phoneNo") String phoneNo, @Param("blockedList") List<Boolean> blockedList);

	@Query("select phoneBlock.phoneBlockID, phoneBlock.phoneNo, phoneBlock.providerServiceMapID, "
			+ "phoneBlock.noOfNuisanceCall, phoneBlock.isBlocked, phoneBlock.ctiCampaignName, "
			+ "phoneBlock.blockStartDate, phoneBlock.blockEndDate, phoneBlock.providerServiceMapping,"
			+ "phoneBlock.callIDs from PhoneBlock phoneBlock join phoneBlock.providerServiceMapping "
			+ "where phoneBlock.providerServiceMapID = :providerServiceMapID "
			+ "and phoneBlock.isBlocked in :blockedList and phoneBlock.phoneNo like :phoneNo "
			+ "and phoneBlock.noOfNuisanceCall > 0 order by phoneBlock.noOfNuisanceCall desc")
	Set<Objects[]> getPhoneBlockListByServiceProviderMapID(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("phoneNo") String phoneNo, @Param("blockedList") List<Boolean> blockedList);

	@Query("select phoneBlock from PhoneBlock phoneBlock "
			+ "where phoneBlock.providerServiceMapID = :providerServiceMapID and phoneBlock.phoneNo = :phoneNo")
	List<PhoneBlock> getPhoneBlockListByServiceProviderMapID(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("phoneNo") String phoneNo);

	@Query("select phoneBlock.phoneBlockID, phoneBlock.phoneNo, phoneBlock.providerServiceMapID, "
			+ "phoneBlock.noOfNuisanceCall, phoneBlock.isBlocked, phoneBlock.ctiCampaignName, "
			+ "phoneBlock.blockStartDate, phoneBlock.blockEndDate, phoneBlock.providerServiceMapping,"
			+ "phoneBlock.callIDs from PhoneBlock phoneBlock join phoneBlock.providerServiceMapping "
			+ "where  phoneBlock.blockEndDate <= :endDate and phoneBlock.isBlocked=true ")
	// + "and phoneBlock.noOfNuisanceCall > 0 order by phoneBlock.noOfNuisanceCall
	// desc")
	Set<Objects[]> getPhoneBlockList(@Param("endDate") Timestamp endDate);

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update PhoneBlock set noOfNuisanceCall = noOfNuisanceCall+1, callIDs = :benCallIDs "
			+ "where providerServiceMapID = :providerServiceMapID and phoneNo = :phoneNo")
	Integer updateNuisanceCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("phoneNo") String phoneNo, @Param("benCallIDs") String benCallIDs);

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update PhoneBlock set isBlocked = :isBlocked, "
			+ "ctiCampaignName = :ctiCampaignName, blockStartDate = :blockStartDate, blockEndDate = :blockEndDate,"
			+ "modifiedBy = :modifiedBy, noOfNuisanceCall = :noOfNuisanceCall, callIDs = :benCallIDs where "
			+ "providerServiceMapID = :providerServiceMapID and phoneNo = :phoneNo")
	Integer phoneNoBlockUnblock(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("phoneNo") String phoneNo, @Param("isBlocked") Boolean isBlocked,
			@Param("ctiCampaignName") String ctiCampaignName, @Param("noOfNuisanceCall") Integer noOfNuisanceCall,
			@Param("blockStartDate") Timestamp blockStartDate, @Param("blockEndDate") Timestamp blockEndDate,
			@Param("modifiedBy") String modifiedBy, @Param("benCallIDs") String benCallIDs);

	@Query("select phoneBlock from PhoneBlock phoneBlock "
			+ "where phoneBlock.providerServiceMapID = :providerServiceMapID and phoneBlock.phoneNo = :phoneNo "
			+ "order by phoneBlock.noOfNuisanceCall desc")
	Set<PhoneBlock> getPhoneBlockStatus(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("phoneNo") String phoneNo);

	@Query("select phoneBlock from PhoneBlock phoneBlock join phoneBlock.providerServiceMapping "
			+ "where phoneBlock.callIDs is null and phoneBlock.noOfNuisanceCall > 0 "
			+ "order by phoneBlock.noOfNuisanceCall desc")
	List<PhoneBlock> getPhoneBlocks();

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update PhoneBlock set callIDs = :benCallIDs where phoneBlockID = :phoneBlockID")
	Integer updateCallIDs(@Param("phoneBlockID") Long phoneBlockID, @Param("benCallIDs") String benCallIDs);

}
