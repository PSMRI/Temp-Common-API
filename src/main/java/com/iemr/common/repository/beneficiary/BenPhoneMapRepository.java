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
package com.iemr.common.repository.beneficiary;

//@Repository
public interface BenPhoneMapRepository //extends CrudRepository<BenPhoneMap, Long>
{
	//	@Query("select b.benPhMapID, b.benificiaryRegID, b.parentBenRegID, "
	//			+ "b.benRelationshipID, b.phoneNo, b.phoneTypeID, b.deleted, b.benRelationshipType, b.nuisanceCallCount from BenPhoneMap b "
	//			+ "left join b.benRelationshipType where b.deleted = false and b.benificiaryRegID = :benificiaryRegID "
	//			+ "order by b.benPhMapID asc")
	//	public abstract Set<Objects[]> findAciveBeneficiaryPhones(@Param("benificiaryRegID") Long benificiaryRegID);
	//
	//	@Query("select b.benPhMapID, b.benificiaryRegID, b.parentBenRegID, "
	//			+ "b.benRelationshipID, b.phoneNo, b.phoneTypeID, b.deleted, "
	//			+ "b.benRelationshipType, b.nuisanceCallCount from BenPhoneMap b "
	//			+ "left join b.benRelationshipType where b.deleted = false and "
	//			+ "b.benificiaryRegID = :benificiaryRegID and b.phoneNo = :phoneNo "
	//			+ "order by b.benPhMapID asc")
	//	public abstract Set<Objects[]> findBeneficiaryPhones(@Param("benificiaryRegID") Long benificiaryRegID,
	//			@Param("phoneNo") String phoneNo);
	//
	//	@Transactional
	//	@Modifying
	//	@Query("update BenPhoneMap set benificiaryRegID = :benificiaryRegID, parentBenRegID = :parentBenRegID, "
	//			+ "benRelationshipID = :benRelationshipID, phoneNo = :phoneNo, phoneTypeID = :phoneTypeID, "
	//			+ "deleted = :deleted where benPhMapID = :benPhMapID ")
	//	public abstract void update(@Param("benPhMapID") Long benPhMapID, @Param("benificiaryRegID") Long benificiaryRegID,
	//			@Param("parentBenRegID") Long parentBenRegID, @Param("benRelationshipID") Integer benRelationshipID,
	//			@Param("phoneNo") String phoneNo, @Param("phoneTypeID") Integer phoneTypeID,
	//			@Param("deleted") Boolean deleted);
	//
	//	@Query("select b.benPhMapID, b.benificiaryRegID, b.parentBenRegID, "
	//			+ "b.benRelationshipID, b.phoneNo, b.phoneTypeID, b.deleted, "
	//			+ "b.benRelationshipType, b.nuisanceCallCount from BenPhoneMap b "
	//			+ "left join b.benRelationshipType where b.deleted = false and b.phoneNo = :phoneNo "
	//			+ "order by b.benPhMapID asc")
	//	public abstract Set<Objects[]> findBeneficiaryByPhone(@Param("phoneNo") String phoneNo);
	//
	//	@Transactional
	//	@Modifying
	//	@Query("update BenPhoneMap set nuisanceCallCount = :nuisanceCallCount where phoneNo = :phoneNo ")
	//	public abstract void updateNuisanceCallCount(@Param("nuisanceCallCount") Integer nuisanceCallCount,
	//			@Param("phoneNo") String phoneNo);
	//
	//	// @Query(
	//	// value = "select phoneMap from BenPhoneMap phoneMap where phoneMap.phoneNo = :phoneNo and phoneMap.deleted = false
	//	// "
	//	// + "order by phoneMap.benPhMapID asc limit 1",
	//	// nativeQuery = true)
	//	// public BenPhoneMap findByPhoneNo(@Param("phoneNo") String phoneNo);
	//	@Query("select phoneMap from BenPhoneMap phoneMap where phoneMap.phoneNo = :phoneNo and phoneMap.deleted = false "
	//			+ "order by phoneMap.benPhMapID asc")
	//	public List<BenPhoneMap> findByPhoneNo(@Param("phoneNo") String phoneNo);

	// @Query("insert into BenPhoneMap (benificiaryRegID, parentBenRegID,
	// benRelationshipID, phoneNo, phoneTypeID, createdBy ) "
	// + "values (:benificiaryRegID, :parentBenRegID, :benRelationshipID,
	// :phoneNo, :phoneTypeID, :createdBy )")
	// public abstract void addNewEntry(@Param("benificiaryRegID") Long
	// benificiaryRegID, @Param("parentBenRegID") Long parentBenRegID,
	// @Param("benRelationshipID") Integer benRelationshipID, @Param("phoneNo")
	// String phoneNo,
	// @Param("phoneTypeID") Integer phoneTypeID, @Param("createdBy") String
	// createdBy);
}
