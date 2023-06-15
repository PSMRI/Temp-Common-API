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
package com.iemr.common.repository.notification;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.notification.Notification;

@Repository
@RestResource(exported = false)
public interface NotificationRepository extends CrudRepository<Notification, Long>
{
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update Notification " + "set notification = :notification, notificationDesc = :notificationDesc, "
			+ "notificationTypeID = :notificationTypeID, roleID = :roleID, "
			+ "validFrom = :validFrom, validTill = :validTill, deleted = :deleted, modifiedBy = :modifiedBy "
			+ "where notificationID = :notificationID")
	Integer updateNotification(@Param("notificationID") Integer notificationID,
			@Param("notification") String notification, @Param("notificationDesc") String notificationDesc,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("roleID") Integer roleID,
			@Param("validFrom") Timestamp validFrom, @Param("validTill") Timestamp validTill,
			@Param("deleted") Boolean deleted, @Param("modifiedBy") String modifiedBy);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID=:providerServiceMapID and "
			+ "(notification.roleID IN :roleIDs or notification.roleID is null) and "
			+ "notification.validFrom <= :validFrom and notification.validTill >= :validTill and "
			+ "notification.deleted <> true and notification.notificationTypeID = :notificationTypeID and "
			+ "notification.languageID is null and notification.userID is null and "
			+ "(notification.workingLocationID is null or notification.workingLocationID in :workLocationIDs) "
			+ "order by notification.validTill desc")
	Set<Objects[]> getRoleNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("roleIDs") List<Integer> roleIDs,
			@Param("workLocationIDs") List<Integer> workLocationIDs, @Param("validFrom") Timestamp validFrom,
			@Param("validTill") Timestamp validTill);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID=:providerServiceMapID and "
			+ "(notification.roleID IN :roleIDs or notification.roleID is null) and "
			+ "notification.validFrom <= :validFrom and notification.validTill >= :validTill and "
			+ "notification.deleted <> true and notification.notificationTypeID = :notificationTypeID and "
			+ "notification.languageID is null and notification.userID is null and "
			+ "notification.workingLocationID is null order by notification.validTill desc")
	Set<Objects[]> getRoleNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("roleIDs") List<Integer> roleIDs,
			@Param("validFrom") Timestamp validFrom, @Param("validTill") Timestamp validTill);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID=:providerServiceMapID and notification.userID in :userIDs and "
			+ "notification.deleted <> true and notification.validFrom <= :validFrom and "
			+ "notification.validTill >= :validTill and notification.notificationTypeID = :notificationTypeID "
			+ "order by notification.validTill desc")
	Set<Objects[]> getUserNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("validFrom") Timestamp validFrom,
			@Param("validTill") Timestamp validTill, @Param("userIDs") List<Integer> userIDs);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID=:providerServiceMapID and "
			+ "notification.languageID in :languageIDs and notification.deleted <> true and "
			+ "notification.validFrom <= :validFrom and notification.validTill >= :validTill "
			+ "and notification.notificationTypeID = :notificationTypeID order by notification.validTill desc")
	Set<Objects[]> getLanguageNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("validFrom") Timestamp validFrom,
			@Param("validTill") Timestamp validTill, @Param("languageIDs") List<Integer> languageIDs);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID=:providerServiceMapID and "
			+ "notification.workingLocationID in :workingLocationIDs and "
			+ "notification.deleted <> true and notification.validFrom <= :validFrom and "
			+ "notification.validTill >= :validTill and notification.notificationTypeID = :notificationTypeID "
			+ "order by notification.validTill desc")
	Set<Objects[]> getLocationNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("notificationTypeID") Integer notificationTypeID, @Param("validFrom") Timestamp validFrom,
			@Param("validTill") Timestamp validTill, @Param("workingLocationIDs") List<Integer> workingLocationIDs);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.languageID is null and "
			+ "notification.userID is null and notification.workingLocationID is null "
			+ "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotifications(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("notificationTypeID") Integer notificationTypeID);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "(notification.roleID IN :roleIDs or notification.roleID is null) and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.languageID is null and "
			+ "notification.userID is null and "
			+ "(notification.workingLocationID is null or notification.workingLocationID in :locationIDs)"
			+ "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotificationsByRole(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("roleIDs") List<Integer> roleIDs, @Param("notificationTypeID") Integer notificationTypeID,
			@Param("locationIDs") List<Integer> locationIDs);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "(notification.roleID IN :roleIDs or notification.roleID is null) and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.languageID is null and "
			+ "notification.userID is null " + "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotificationsByRole(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("roleIDs") List<Integer> roleIDs, @Param("notificationTypeID") Integer notificationTypeID);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "notification.userID IN :userIDs and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.roleID is null "
			+ "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotificationsByUser(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("userIDs") List<Integer> userIDs, @Param("notificationTypeID") Integer notificationTypeID);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "notification.workingLocationID IN :workingLocationIDs and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.roleID is null "
			+ "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotificationsByLocation(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("workingLocationIDs") List<Integer> workingLocationIDs,
			@Param("notificationTypeID") Integer notificationTypeID);

	@Query("select notification.notificationID, notification.notification, notification.notificationDesc, "
			+ "notification.notificationTypeID, notification.notificationType, notification.roleID, notification.role, "
			+ "notification.providerServiceMapID, notification.validFrom, notification.validTill, notification.deleted, "
			+ "notification.kmFileManagerID, notification.kmFileManager, notification.workingLocationID, "
			+ "notification.workingLocation, notification.languageID, notification.language, notification.userID, "
			+ "notification.user "
			+ "from Notification notification left join notification.notificationType left join notification.role "
			+ "left join notification.kmFileManager left join notification.workingLocation "
			+ "left join notification.language left join notification.user "
			+ "where notification.providerServiceMapID = :providerServiceMapID and "
			+ "notification.languageID in :languageIDs and "
			+ "((notification.validFrom >= :validStartDate or notification.validTill >= :validStartDate) and "
			+ "(notification.validFrom <= :validEndDate or notification.validTill <= :validEndDate)) and "
			+ "notification.notificationTypeID = :notificationTypeID and notification.roleID is null "
			+ "order by notification.notificationID desc")
	Set<Objects[]> getSupervisorNotificationsByLanguage(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("validStartDate") Timestamp validStartDate, @Param("validEndDate") Timestamp validEndDate,
			@Param("languageIDs") List<Integer> languageIDs, @Param("notificationTypeID") Integer notificationTypeID);

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query("update Notification set kmFileManagerID = :kmFileManagerID, deleted = :deleted "
			+ "where notificationID = :notificationID")
	Integer updateNotification(@Param("notificationID") Integer notificationID,
			@Param("kmFileManagerID") Integer kmFileManagerID, @Param("deleted") Boolean deleted);

}
