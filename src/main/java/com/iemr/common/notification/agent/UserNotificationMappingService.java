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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.notification.agent.DTO.AlertAndNotificationChangeStatusDTO;
import com.iemr.common.notification.agent.DTO.AlertAndNotificationCount;
import com.iemr.common.notification.agent.DTO.AlertAndNotificationCountDTO;
import com.iemr.common.notification.agent.DTO.UserNotificationDisplayMaxDTO;
import com.iemr.common.notification.agent.DTO.UserNotificationDisplayMinDTO;

/**
 * 
 * 
 * @author SUNIL K SUNDARAM
 *
 */

@Service
public class UserNotificationMappingService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	UserNotificationMappingRepo repo;

	public AlertAndNotificationCountDTO getAlertAndNotificationCount(UserNotificationDisplayMinDTO dto)
	{
		logger.info("UserNotificationMappingService -> getAlertAndNotificationCount start");

		List<AlertAndNotificationCount> list = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (dto.getWorkingLocationID() != null)
		{
			list = repo.getShortDisplayFormatWithWorkLocation(dto.getUserID(), dto.getRoleID(),
					dto.getProviderServiceMapID(), dto.getWorkingLocationID(), "unread", false, timestamp);
		} else
		{
			list = repo.getShortDisplayFormat(dto.getUserID(), dto.getRoleID(), dto.getProviderServiceMapID(), "unread",
					false, timestamp);
		}
		AlertAndNotificationCountDTO result = new AlertAndNotificationCountDTO();
		result.setUserId(dto.getUserID());
		result.setUserNotificationTypeList(list);
		logger.info("UserNotificationMappingService -> getAlertAndNotificationCount start");
		return result;
	}

	public List<UserNotificationMapping> getAlertAndNotificationDetail(UserNotificationDisplayMaxDTO dto)
	{
		logger.info("UserNotificationMappingService -> getAlertAndNotificationDetail start");
		List<UserNotificationMapping> list = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (dto.getWorkingLocationID() != null)
		{
			list = repo.findByUserIDAndRoleIDAndProviderServiceMapIDAndNotificationTypeIDAndWorkingLocationIDAndDeleted(
					dto.getUserID(), dto.getRoleID(), dto.getProviderServiceMapID(), dto.getNotificationTypeID(),
					dto.getWorkingLocationID(), false, timestamp);
		} else
		{
			list = repo.findByUserIDAndRoleIDAndProviderServiceMapIDAndNotificationTypeIDAndDeleted(dto.getUserID(),
					dto.getRoleID(), dto.getProviderServiceMapID(), dto.getNotificationTypeID(), false, timestamp);
		}

		// AlertAndNotificationDetailDTO result = new AlertAndNotificationDetailDTO();
		// result.setUserId(dto.getUserID());
		// result.setUserNotificationMappingList(list);
		logger.info("UserNotificationMappingService -> getAlertAndNotificationDetail finish");
		return list;
		// return result;
	}

	@Transactional
	public String markNotificationSingle(String status, Integer userNotificationMapID)
	{
		repo.updateUserNotificationMappingSingle(status, userNotificationMapID);
		return "success";
	}

	@Transactional
	public String markNotificationList(String status, List<Integer> userNotificationMapIDList)
	{
		repo.updateUserNotificationMappingList(status, userNotificationMapIDList);
		return "success";
	}

	@Transactional
	public String deleteNotificationSingle(Boolean isDeleted, Integer userNotificationMapID)
	{
		repo.setDeletedUserNotificationMappingSingle(isDeleted, userNotificationMapID);
		return "success";
	}

	@Transactional
	public String deleteNotificationList(Boolean isDeleted, List<Integer> userNotificationMapIDList)
	{
		repo.setDeleteUserNotificationMappingList(isDeleted, userNotificationMapIDList);
		return "success";
	}

	public Boolean createUserNotificationMapping(List<Integer> userIds)
	{

		userIds.forEach(userId ->
		{

		});

		return true;
	}

	public void getJsonAsString(String name, Object obj)
	{
		logger.info("UserNotificationMappingController -> getJsonAsString start");
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder sb = new StringBuilder();
		try
		{
			sb.append(mapper.writeValueAsString(obj));
			logger.info("Object: " + name + " :toJSON: " + sb.toString());
		} catch (JsonProcessingException e)
		{
			logger.error(e.getMessage());
		}

		logger.info("UserNotificationMappingController -> getJsonAsString finish");
		// return sb.toString();
	}

	public String querySelector(AlertAndNotificationChangeStatusDTO dto)
	{
		switch (dto.getNotficationStatus().toLowerCase())
		{
			case "mark":
				return getMarkQuery(dto);
			case "unmark":
				return getUnmarkQuery(dto);
			case "delete":
				return getDeleteQuery(dto);
		}

		return "";
	}

	/*
	 * change for given: - role - location - role & location
	 */

	public String getUnmarkQuery(AlertAndNotificationChangeStatusDTO dto)
	{
		/*
		 * private List<Integer> userIDList; private List<Integer> notificationIDList; private List<Integer>
		 * userNotificationMapIDList; private List<Integer> roleIdList; private List<Integer> providerServiceMapIdList;
		 * private String notficationStatus;
		 */
		return "";
	}

	public String getMarkQuery(AlertAndNotificationChangeStatusDTO dto)
	{
		return "";
	}

	public String getDeleteQuery(AlertAndNotificationChangeStatusDTO dto)
	{
		return "";
	}
}
