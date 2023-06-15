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

// import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.callhandling.OutboundCallRequest;

@Repository
@RestResource(exported = false)
public interface OutboundCallRequestRepository extends CrudRepository<OutboundCallRequest, Long>
{
	@Transactional
	@Modifying
	@Query("update OutboundCallRequest set isCompleted = :isCompleted, noOfTrials = :noOfTrials "
			+ "where outboundCallReqID = :outboundCallReqID")
	public int updateCompleteStatusInCall(@Param("outboundCallReqID") Long outboundCallReqID,
			@Param("isCompleted") Boolean isCompleted, @Param("noOfTrials") Integer noOfTrials);

	@Transactional
	@Modifying
	@Query("update OutboundCallRequest set isCompleted = :isCompleted, requestedFor = :requestedFor, "
			+ "noOfTrials = :noOfTrials where outboundCallReqID = :outboundCallReqID")
	public int updateCompleteStatusInCall(@Param("outboundCallReqID") Long outboundCallReqID,
			@Param("isCompleted") Boolean isCompleted, @Param("requestedFor") String requestedFor,
			@Param("noOfTrials") Integer noOfTrials);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.prefferedDateTime > :prefferedStartDateTime "
			+ "and request.prefferedDateTime < :prefferedEndDateTime and request.assignedUserID is null "
			+ "and request.deleted <> true and request.isCompleted <> true and request.beneficiaryRegID is not null "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCalls(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("prefferedStartDateTime") Timestamp prefferedStartDateTime,
			@Param("prefferedEndDateTime") Timestamp prefferedEndDateTime);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user "
			+ "left join request.requestedService where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID is null and request.deleted <> true and request.beneficiaryRegID is not null "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCalls(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID = :assignedUserID and request.isCompleted <> true "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCalls(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("assignedUserID") Integer assignedUserID);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.requestedServiceID = :requestedServiceID and request.isCompleted <> true "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCallsWithServID(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("requestedServiceID") Integer requestedServiceID);

	@Modifying
	@Query("update OutboundCallRequest set assignedUserID = :userID where outboundCallReqID = :id")
	@Transactional
	public int allocateCalls(@Param("userID") Integer userID, @Param("id") Long id);

	@Query("select outbound.outboundCallReqID, outbound.prefferedDateTime, outbound.providerServiceMapID, "
			+ "outbound.requestedFor, outbound.requestedServiceID, outbound.requestedService, outbound.requestNo, "
			+ "outbound.preferredLanguageName, outbound.noOfTrials, outbound.isSelf, outbound.lastModDate "
			+ "from OutboundCallRequest outbound left join outbound.requestedService "
			+ "where outbound.providerServiceMapID = :providerServiceMapID and "
			+ "outbound.benCallID = :benCallID and outbound.deleted <> true and outbound.beneficiaryRegID is not null "
			+ "order by outbound.outboundCallReqID desc")
	public Set<Objects[]> getOutboundCallListByCallID(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("benCallID") Long benCallID);

	@Query("select outbound.outboundCallReqID, outbound.prefferedDateTime, outbound.providerServiceMapID, "
			+ "outbound.requestedFor, outbound.requestedServiceID, outbound.requestedService, outbound.requestNo, "
			+ "outbound.preferredLanguageName, outbound.noOfTrials, outbound.isSelf, outbound.lastModDate "
			+ "from OutboundCallRequest outbound left join outbound.requestedService "
			+ "where outbound.benCallID = :benCallID and outbound.deleted <> true and "
			+ "outbound.beneficiaryRegID is not null order by outbound.outboundCallReqID desc")
	public Set<Objects[]> getOutboundCallListByCallID(@Param("benCallID") Long benCallID);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.prefferedDateTime > :prefferedStartDateTime "
			+ "and request.prefferedDateTime < :prefferedEndDateTime and request.assignedUserID is null "
			+ "and request.preferredLanguageName = :preferredLanguageName "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null and request.isCompleted <> true "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCallsByLanguage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("prefferedStartDateTime") Timestamp prefferedStartDateTime,
			@Param("prefferedEndDateTime") Timestamp prefferedEndDateTime,
			@Param("preferredLanguageName") String preferredLanguageName);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID is null and request.deleted <> true and request.isCompleted <> true "
			+ "and request.preferredLanguageName = :preferredLanguageName and request.beneficiaryRegID is not null "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCallsByLanguage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("preferredLanguageName") String preferredLanguageName);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID = :assignedUserID and request.preferredLanguageName = :preferredLanguageName "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null and request.isCompleted <> true "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCallsByLanguage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("preferredLanguageName") String preferredLanguageName,
			@Param("assignedUserID") Integer assignedUserID);

	@Query("select request.outboundCallReqID, request.beneficiaryRegID, "
			+ "request.prefferedDateTime, request.providerServiceMapID, request.requestedFor, request.user, "
			+ "request.requestedServiceID, request.requestedService, request.requestNo, request.preferredLanguageName, "
			+ "request.requestedFeature, request.noOfTrials, request.isSelf, request.lastModDate "
			+ "from OutboundCallRequest request left join request.user left join request.requestedService "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.prefferedDateTime > :prefferedStartDateTime "
			+ "and request.prefferedDateTime < :prefferedEndDateTime and request.assignedUserID = :assignedUserID "
			+ "and request.preferredLanguageName = :preferredLanguageName "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null and request.isCompleted <> true "
			+ "order by request.outboundCallReqID desc")
	public Set<Objects[]> getAllOutboundCallsByLanguage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("prefferedStartDateTime") Timestamp prefferedStartDateTime,
			@Param("prefferedEndDateTime") Timestamp prefferedEndDateTime,
			@Param("preferredLanguageName") String preferredLanguageName,
			@Param("assignedUserID") Integer assignedUserID);

	@Modifying
	@Query("update OutboundCallRequest set assignedUserID = null where outboundCallReqID in :outboundCallReqIDs")
	@Transactional
	public int resetOutboundCall(@Param("outboundCallReqIDs") List<Long> outboundCallReqIDs);

	@Query("select request.preferredLanguageName, count(request) "
			+ "from OutboundCallRequest request where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID is null and request.isCompleted <> true "
			+ "and request.deleted <> true and request.prefferedDateTime >= :startDate "
			+ "and request.prefferedDateTime <= :endDate and request.beneficiaryRegID is not null "
			+ "group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	@Query("select request.preferredLanguageName, count(request) "
			+ "from OutboundCallRequest request where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID is null and request.isCompleted <> true "
			+ "and request.deleted <> true and request.prefferedDateTime >= :startDate "
			+ "and request.prefferedDateTime <= :endDate and request.preferredLanguageName = :preferredLanguageName "
			+ "and request.beneficiaryRegID is not null group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("preferredLanguageName") String preferredLanguageName);

	@Query("select request.preferredLanguageName, count(request) "
			+ "from OutboundCallRequest request where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID  = :assignedUserID and request.isCompleted <> true "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null "
			+ "group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("assignedUserID") Integer assignedUserID);

	@Query("select request.preferredLanguageName, count(request) "
			+ "from OutboundCallRequest request where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.assignedUserID  = :assignedUserID and request.prefferedDateTime >= :startDate "
			+ "and request.prefferedDateTime <= :endDate and request.isCompleted <> true "
			+ "and request.deleted <> true and request.beneficiaryRegID is not null "
			+ "group by request.preferredLanguageName")
	public Set<Objects[]> outboundCallCount(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("assignedUserID") Integer assignedUserID);

	@Modifying
	@Query("update OutboundCallRequest set assignedUserID = :userID where outboundCallReqID in :ids")
	@Transactional
	public int allocateCallsInBulk(@Param("userID") Integer userID, @Param("ids") List<Long> id);

	@Query("select request from OutboundCallRequest request "
			+ "where request.providerServiceMapID = :providerServiceMapID "
			+ "and request.beneficiaryRegID  = :beneficiaryRegID and request.isCompleted <> true "
			+ "and request.deleted <> true")
	public List<OutboundCallRequest> getBenRequestedOutboundCall(
			@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("beneficiaryRegID") Long beneficiaryRegID);

	// @Query("select request from OutboundCallRequest request where "
	// + "request.outboundCallReqID = :outboundCallReqID")
	// public OutboundCallRequest findByOutboundCallReqID(@Param("outboundCallReqID") Long outboundCallReqID);
}