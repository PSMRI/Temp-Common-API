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
package com.iemr.common.notification.agent;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.notification.agent.DTO.AlertAndNotificationCount;

/**
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Repository
@RestResource(exported = false)
public interface UserNotificationMappingRepo extends CrudRepository<UserNotificationMapping, Integer>
{
	List<UserNotificationMapping> findByUserIDAndDeleted(Integer userId, Boolean deleted);

	List<UserNotificationMapping> findByUserIDAndRoleIDAndDeleted(Integer userId, Integer roleId, Boolean deleted);

	List<UserNotificationMapping>
			findByUserIDAndRoleIDAndProviderServiceMapIDAndDeleted(Integer userId, Integer roleId, Integer providerServiceMapId, Boolean deleted);

	@Query("select unm from UserNotificationMapping unm join unm.notification noti where unm.userID= :userId and unm.roleID= :roleId and unm.providerServiceMapID= :providerServiceMapId"
			+ " and unm.notificationTypeID= :notificationTypeID and unm.deleted= :deleted and  noti.validFrom<=:now and noti.validTill>=:now")
	List<UserNotificationMapping> findByUserIDAndRoleIDAndProviderServiceMapIDAndNotificationTypeIDAndDeleted(
			@Param("userId") Integer userId, @Param("roleId") Integer roleId, @Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("deleted") Boolean deleted, @Param("now") Timestamp now);

	@Query("select unm from UserNotificationMapping unm join unm.notification noti where unm.userID= :userId and unm.roleID= :roleId and unm.providerServiceMapID= :providerServiceMapId"
			+ " and unm.notificationTypeID= :notificationTypeID and unm.workingLocationID= :workingLocationID and unm.deleted= :deleted and  noti.validFrom<=:now and noti.validTill>=:now")
	List<UserNotificationMapping> findByUserIDAndRoleIDAndProviderServiceMapIDAndNotificationTypeIDAndWorkingLocationIDAndDeleted(
			@Param("userId") Integer userId, @Param("roleId") Integer roleId, @Param("providerServiceMapId") Integer providerServiceMapId,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("workingLocationID") Integer workingLocationID,
			@Param("deleted") Boolean deleted, @Param("now") Timestamp now);

	List<UserNotificationMapping> findByNotificationIDAndDeleted(Integer notificationId, Boolean deleted);

	Integer countByUserIDAndDeleted(Integer userId, Boolean deleted);

	Integer countByUserIDAndRoleIDAndDeleted(Integer userId, Integer roleId, Boolean deleted);

	Integer countByUserIDAndRoleIDAndProviderServiceMapIDAndDeleted(Integer userId, Integer roleId, Integer providerServiceMapId, Boolean deleted);

	Integer countByNotificationIDAndDeleted(Integer notificationId, Boolean deleted);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState where u.userNotificationMapID = :userNotificationMapID ")
	int updateUserNotificationMappingSingle(
			@Param("notificationState") String notificationState, @Param("userNotificationMapID") Integer userNotificationMapID);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState where u.userNotificationMapID IN :userNotificationMapIDList ")
	int updateUserNotificationMappingList(
			@Param("notificationState") String notificationState, @Param("userNotificationMapIDList") List<Integer> userNotificationMapIDList);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.deleted = :deleted where u.userNotificationMapID = :userNotificationMapID ")
	int setDeletedUserNotificationMappingSingle(@Param("deleted") Boolean isDeleted, @Param("userNotificationMapID") Integer userNotificationMapID);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.deleted = :deleted where u.userNotificationMapID IN :userNotificationMapIDList ")
	int setDeleteUserNotificationMappingList(
			@Param("deleted") Boolean isDeleted, @Param("userNotificationMapIDList") List<Integer> userNotificationMapIDList);

	@Modifying(clearAutomatically = true)
	@Query("SELECT new com.iemr.common.notification.agent.DTO.AlertAndNotificationCount(u.notificationID, "
			+ "u.notificationType, u.notificationTypeID, COUNT(u.notificationType)) FROM UserNotificationMapping u join u.notification noti "
			+ "WHERE u.userID = :userID AND u.roleID = :roleID AND u.providerServiceMapID = :providerServiceMapID "
			+ "AND u.notificationState = :notificationState and u.deleted=:deleted  and  noti.validFrom<=:now and noti.validTill>=:now GROUP BY u.notificationType ")
	List<AlertAndNotificationCount> getShortDisplayFormat(
			@Param("userID") Integer userID, @Param("roleID") Integer roleID, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationState") String notificationState, @Param("deleted") Boolean deleted, @Param("now") Timestamp now);

	@Modifying(clearAutomatically = true)
	@Query("SELECT new com.iemr.common.notification.agent.DTO.AlertAndNotificationCount(u.notificationID, "
			+ "u.notificationType, u.notificationTypeID, COUNT(u.notificationType)) FROM UserNotificationMapping u join u.notification noti "
			+ "WHERE u.userID = :userID AND u.roleID = :roleID AND u.providerServiceMapID = :providerServiceMapID "
			+ "AND u.workingLocationID = :workingLocationID AND u.notificationState = :notificationState  and u.deleted=:deleted  and  noti.validFrom<=:now and noti.validTill>=:now GROUP BY u.notificationType")
	List<AlertAndNotificationCount> getShortDisplayFormatWithWorkLocation(
			@Param("userID") Integer userID, @Param("roleID") Integer roleId, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("workingLocationID") Integer workingLocationID, @Param("notificationState") String notificationState,
			@Param("deleted") Boolean deleted, @Param("now") Timestamp now);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState "
			+ "where u.userNotificationMapID IN :userNotificationMapIDList")
	int updateUserNotificationMappingUsingUserNotificationMapIDList(
			@Param("notificationState") String notificationState, @Param("userNotificationMapIDList") List<Integer> userNotificationMapIDList);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState " + "where u.notificationID IN :notificationIDList")
	int updateUserNotificationMappingUsingNotificationIDList(
			@Param("notificationState") String notificationState, @Param("notificationIDList") List<Integer> notificationIDList);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState " + "where u.roleID IN :roleIDList")
	int updateUserNotificationMappingUsingRoleIDList(
			@Param("notificationState") String notificationState, @Param("roleIDList") List<Integer> roleIDList);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState " + "where u.userID IN :userIDList")
	int updateUserNotificationMappingUsingUserIDList(
			@Param("notificationState") String notificationState, @Param("userIDList") List<Integer> userIDList);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserNotificationMapping u SET u.notificationState = :notificationState "
			+ "where u.providerServiceMapID IN :providerServiceMapIDList")
	int updateUserNotificationMappingUsingProviderServiceMapIDList(
			@Param("notificationState") String notificationState, @Param("providerServiceMapIDList") List<Integer> providerServiceMapIDList);
}
