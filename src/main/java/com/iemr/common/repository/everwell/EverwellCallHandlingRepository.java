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
package com.iemr.common.repository.everwell;

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
import org.springframework.transaction.annotation.Transactional;
import com.iemr.common.data.everwell.EverwellDetails;

@Repository
@RestResource(exported = false)
public interface EverwellCallHandlingRepository extends CrudRepository<EverwellDetails, Long> {

	@Query("select request.preferredLanguageName, count(distinct request.beneficiaryRegId) "
			+ "from EverwellDetails request where request.providerServiceMapId = :providerServiceMapID "
			+ "and request.agentId is null and request.isCompleted <> true AND request.isAllocated <> true "
			+ "and request.deleted <> true and request.createdDate >= :startDate "
			+ "and request.createdDate <= :endDate and request.beneficiaryRegId is not null "
			+ "group by request.preferredLanguageName ")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

//	@Query("select count(request) "
//			+ "from EverwellDetails request where request.providerServiceMapId = :providerServiceMapId AND request.agentId = :agentId AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true")
//	public Integer outboundCallCount(@Param("providerServiceMapId") Integer providerServiceMapId,@Param("agentId") Integer agentId);
	@Query("select request.preferredLanguageName, count(distinct request.beneficiaryRegId) "
			+ "from EverwellDetails request where request.providerServiceMapId = :providerServiceMapID "
			+ "and request.agentId  = :assignedUserID and request.isCompleted <> true AND request.isAllocated <> false "
			+ "and request.deleted <> true and request.beneficiaryRegId is not null "
			+ "group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("assignedUserID") Integer assignedUserID);

	@Query("select request.preferredLanguageName, count(distinct request.beneficiaryRegId) "
			+ "from EverwellDetails request where request.providerServiceMapId = :providerServiceMapID "
			+ "and request.agentId is null and request.isCompleted <> true "
			+ "and request.deleted <> true and request.createdDate >= :startDate  "
			+ "and request.createdDate <= :endDate and request.preferredLanguageName = :preferredLanguageName AND request.isAllocated <> true "
			+ "and request.beneficiaryRegId is not null group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("preferredLanguageName") String preferredLanguageName);

	@Query("SELECT request.eapiId,request.beneficiaryRegId," + "request.providerServiceMapId,request.Id,"
			+ "request.agentId,request.FirstName,request.LastName," + "request.PrimaryNumber,request.lastModDate,"
			+ "request.MissedDoses,request.FacilityName,request.State,request.AdherencePercentage,request.actionTaken,"
			+ "request.category,request.subCategory,request.dateOfAction,request.comments,request.createdBy,request.createdDate,"
			+ "request.Gender,request.District,request.beneficiaryID,request.CurrentMonthMissedDoses,request.retryNeeded,request.callCounter,request.NoInfoDoseCount,request.noInfoDosesDates "
			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId and request.createdDate >= :startDate and request.createdDate <= :endDate "
			+ "AND request.isAllocated <> true AND request.isCompleted <> true AND request.deleted <> true AND request.beneficiaryRegId is not null "
			+ " order by request.eapiId desc")
//	@Query("SELECT request "
//			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId and request.createdDate >= :startDate and request.createdDate <= :endDate "
//			+ "AND request.isAllocated <> true AND request.isCompleted <> true AND request.deleted <> true AND request.beneficiaryRegId is not null "
//			+ " order by request.eapiId desc")
	public List<Objects[]> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	@Query("SELECT request.eapiId,request.beneficiaryRegId," + "request.providerServiceMapId,request.Id,"
			+ "request.agentId,request.FirstName,request.LastName," + "request.PrimaryNumber,request.lastModDate,"
			+ "request.MissedDoses,request.FacilityName,request.State,request.AdherencePercentage,request.actionTaken,"
			+ "request.category,request.subCategory,request.dateOfAction,request.comments,request.createdBy,request.createdDate,"
			+ "request.Gender,request.District,request.beneficiaryID,request.CurrentMonthMissedDoses,request.retryNeeded,request.callCounter,request.NoInfoDoseCount,request.noInfoDosesDates  "
			+ "FROM EverwellDetails request WHERE request.providerServiceMapId =:providerServiceMapId and request.createdDate >= :startDate and request.createdDate <= :endDate and request.preferredLanguageName = :preferredLanguageName "
			+ "AND request.isAllocated <> true AND request.isCompleted <> true AND request.deleted <> true AND request.beneficiaryRegId is not null "
			+ " order by request.eapiId desc")
//	@Query("SELECT request "
//			+ "FROM EverwellDetails request WHERE request.providerServiceMapId =:providerServiceMapId and request.createdDate >= :startDate and request.createdDate <= :endDate and request.preferredLanguageName = :preferredLanguageName "
//			+ "AND request.isAllocated <> true AND request.isCompleted <> true AND request.deleted <> true AND request.beneficiaryRegId is not null "
//			+ " order by request.eapiId desc")
	public List<Objects[]> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("preferredLanguageName") String preferredLanguageName);

	@Query("SELECT request.eapiId,request.beneficiaryRegId," + "request.providerServiceMapId,request.Id,"
			+ "request.agentId,request.FirstName,request.LastName," + "request.PrimaryNumber,request.lastModDate,"
			+ "request.MissedDoses,request.FacilityName,request.State,request.AdherencePercentage,request.actionTaken,"
			+ "request.category,request.subCategory,request.dateOfAction,request.comments,request.createdBy,request.createdDate,"
			+ "request.Gender,request.District,request.beneficiaryID,request.CurrentMonthMissedDoses,request.retryNeeded,request.callCounter,request.NoInfoDoseCount,request.noInfoDosesDates  "
			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId "
			+ "AND request.agentId = :agentId AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true "
			+ "AND request.beneficiaryRegId is not null" + " order by request.eapiId desc")
	public List<Objects[]> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("agentId") Integer agentId);

//	@Query("SELECT request "
//			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId "
//			+ "AND request.agentId = :agentId AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true "
//			+ "AND request.beneficiaryRegId is not null" + " order by request.eapiId desc")
//	public List<EverwellDetails> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
//			@Param("agentId") Integer agentId);

	@Query("SELECT request.eapiId,request.beneficiaryRegId," + "request.providerServiceMapId,request.Id,"
			+ "request.agentId,request.FirstName,request.LastName," + "request.PrimaryNumber,request.lastModDate,"
			+ "request.MissedDoses,request.FacilityName,request.State,request.AdherencePercentage,request.actionTaken,"
			+ "request.category,request.subCategory,request.dateOfAction,request.comments,request.createdBy,request.createdDate,"
			+ "request.Gender,request.District,request.beneficiaryID,request.CurrentMonthMissedDoses,request.retryNeeded,request.callCounter,request.NoInfoDoseCount,request.noInfoDosesDates  "
			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId "
			+ "AND request.agentId = :agentId AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true and request.preferredLanguageName = :preferredLanguageName "
			+ "AND request.beneficiaryRegId is not null" + " order by request.eapiId desc")
	public List<Objects[]> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("agentId") Integer agentId, @Param("preferredLanguageName") String preferredLanguageName);
//	@Query("SELECT request "
//			+ "FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId "
//			+ "AND request.agentId = :agentId AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true and request.preferredLanguageName = :preferredLanguageName "
//			+ "AND request.beneficiaryRegId is not null" + " order by request.eapiId desc")
//	public List<EverwellDetails> getAllOutboundCalls(@Param("providerServiceMapId") Integer providerServiceMapId,
//			@Param("agentId") Integer agentId, @Param("preferredLanguageName") String preferredLanguageName);

//	@Modifying
//	@Query("update EverwellCallAllocation set isAllocated = true where Callid = :Callid")
//	@Transactional
//	public int allocateCalls(@Param("AgentID") Integer AgentID);

	@Modifying
	@Query("update EverwellDetails set agentId = :agentId,isAllocated = true where eapiId in :ids")
	@Transactional
	public int allocateCalls(@Param("agentId") Integer agentId, @Param("ids") List<Long> ids);

	@Modifying
	@Query("update EverwellDetails set agentId = null,isAllocated = false where eapiId in :eapiIds")
	@Transactional
	public int resetOutboundCall(@Param("eapiIds") List<Long> eapiIds);

	@Modifying
	@Query("update EverwellDetails set MissedDoses = :missedDoses,Category = :category,SubCategory = :subCategory,ActionTaken = :actionTaken,AdherencePercentage = :adherencePercentage,Comments = :comments,dateOfAction = :dateOfAction where eapiId = :eapiId")
	@Transactional
	public int saveDetails(@Param("eapiId") Long eapiId, @Param("missedDoses") Integer missedDoses,
			@Param("category") String category, @Param("subCategory") String subCategory,
			@Param("actionTaken") String actionTaken, @Param("adherencePercentage") Integer adherencePercentage,
			@Param("comments") String comments, @Param("dateOfAction") Timestamp dateOfAction);

	@Modifying
	@Query("UPDATE EverwellDetails set isCompleted = :isCompleted,benCallID = :benCallID,callId = :callId "
			+ " WHERE beneficiaryRegId = :benRegID AND eapiId <= :eapiId AND deleted <> true AND isCompleted <> true ")
	@Transactional
	public int updateCompleteStatusInCall(@Param("eapiId") Long eapiId, @Param("isCompleted") Boolean isCompleted,
			@Param("benCallID") Long benCallID, @Param("callId") String callId, @Param("benRegID") Long benRegID);

	@Modifying
	@Query(value = "insert into t_outboundcallrequest (BeneficiaryRegID,AssignedUserID,CallTypeID,ProviderServiceMapID,isCompleted,BenCallID,SubServiceID,CreatedBy,PrefferedLanguage) VALUES (:beneficiaryRegId,:assignedUserID,:callTypeID,:providerServiceMapId,:isCompleted,:benCallID,:requestedServiceID,:createdBy,:preferredLanguageName)", nativeQuery = true)
	@Transactional
	public int insertEverwellDetails(@Param("beneficiaryRegId") Long beneficiaryRegId,
			@Param("assignedUserID") Integer assignedUserID, @Param("callTypeID") Integer callTypeID,
			@Param("providerServiceMapId") Integer providerServiceMapId, @Param("isCompleted") Boolean isCompleted,
			@Param("benCallID") Long benCallID, @Param("requestedServiceID") Integer requestedServiceID,
			@Param("createdBy") String createdBy, @Param("preferredLanguageName") String preferredLanguageName);
//	@Modifying
//	 @Query("insert into OutboundCallRequest request (request.beneficiaryRegID,request.assignedUserID,request.callTypeID,request.providerServiceMapID,request.isCompleted,request.benCallID,request.createdBy,request.preferredLanguageName) VALUES (:beneficiaryRegId,:assignedUserID,:callTypeID,:providerServiceMapId,:isCompleted,:benCallID,:createdBy,:preferredLanguageName)")
//	@Transactional
//	public int insertEverwellDetails(@Param("beneficiaryRegId") Long beneficiaryRegId,@Param("assignedUserID") Integer assignedUserID,@Param("callTypeID") Integer callTypeID,@Param("providerServiceMapId") Integer providerServiceMapId,@Param("isCompleted") Boolean isCompleted,@Param("benCallID") Long benCallID,@Param("createdBy") String createdBy, @Param("preferredLanguageName") String preferredLanguageName);
	// @Query(value = "select req from t_everwellapi req where req.dateOfAction>=
	// :date and req.isRegistered=true and req.processed = 'P')", nativeQuery =
	// true)

//	@Modifying
//    @Query(value = "insert into t_everwellapi (Processed) VALUES ('P') where EAPIID= :eapiId", nativeQuery = true)
//    @Transactional
//    public int insertProcessed(@Param("eapiId") Long eapiId);

	@Modifying
	@Query("update EverwellDetails set isCompleted =:isCompleted,modifiedBy =:modifiedBy" + " where eapiId = :eapiId")
	@Transactional
	public int updateIsCompleted(@Param("eapiId") Long eapiId, @Param("isCompleted") Boolean isCompleted,
			@Param("modifiedBy") String modifiedBy);

	/***
	 * @author DU20091017
	 * @param eapiId
	 * @param callCounter
	 * @param benCallID
	 * @param callId
	 * @return updating call counter
	 */
	@Modifying
	@Query("update EverwellDetails set callCounter = :callCounter,benCallID = :benCallID,callId = :callId "
			+ " where eapiId = :eapiId")
	@Transactional
	public int updateCallCounter(@Param("eapiId") Long eapiId, @Param("callCounter") Integer callCounter,
			@Param("benCallID") Long benCallID, @Param("callId") String callId);

	@Modifying
	@Query("update EverwellDetails set retryNeeded=:retryNeeded, comments=:comments where eapiId=:eapiId ")
	@Transactional
	public int updateRetryNeededAsTrueEverwellDetails(@Param("eapiId") Long eapiId,
			@Param("retryNeeded") Boolean retryNeeded, @Param("comments") String comments);

	@Modifying
	@Query("update EverwellDetails set retryNeeded=:retryNeeded where eapiId=:eapiId ")
	@Transactional
	public int updateRetryNeededAsFalseEverwellDetails(@Param("eapiId") Long eapiId,
			@Param("retryNeeded") Boolean retryNeeded);

	@Query("SELECT request.isCompleted " + "FROM EverwellDetails request WHERE request.eapiId = :eapiId AND "
			+ " request.deleted <> true ")
	public Boolean checkCallCompleted(@Param("eapiId") Long eapiId);

	@Query("SELECT request FROM EverwellDetails request WHERE request.providerServiceMapId = :providerServiceMapId "
			+ "AND request.PrimaryNumber = :PrimaryNumber "
			+ "AND request.isAllocated <> false AND request.isCompleted <> true AND request.deleted <> true "
			+ "AND request.beneficiaryRegId is not null ORDER BY request.eapiId DESC ")
	public List<EverwellDetails> getAllOutboundCallsWithMobileNumber(
			@Param("providerServiceMapId") Integer providerServiceMapId, @Param("PrimaryNumber") String PrimaryNumber);
}
