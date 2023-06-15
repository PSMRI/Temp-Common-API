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
package com.iemr.common.repository.feedback;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.feedback.FeedbackResponse;

@Repository
@RestResource(exported = false)
public interface FeedbackResponseRepository extends CrudRepository<FeedbackResponse, Long> {
	@Query("SELECT response.responseSummary, response.feedbackRequestID, "
			+ "response.comments, response.authName, response.authDesignation, "
			+ "request.feedbackID as FeedbackID, request.feedbackSupSummary as FeedbackSupSummary, "
			+ "request.comments as Comments, details.feedback as Feedback " + "FROM FeedbackResponse response "
			+ "JOIN response.feedbackRequest request " + "JOIN response.feedbackDetails details "
			+ "WHERE response.feedbackID =:feedbackID order by response.feedbackRequestID desc")
	ArrayList<Object[]> getdatabyId(@Param("feedbackID") Long feedbackID);

	@Query("SELECT r.responseSummary, r.feedbackRequestID, r.comments, r.authName, r.authDesignation, "
			+ "r.feedbackID, r.feedbackResponseID, r.createdDate, r.createdBy, r.kmFileManagerID, r.kmFileManager "
			+ "FROM FeedbackResponse r left join r.kmFileManager WHERE feedbackID =:feedbackID order by feedbackResponseID desc")
	ArrayList<Object[]> getDataByFeedbackID(@Param("feedbackID") Long feedbackID);

	@Transactional
	@Modifying
	@Query("update FeedbackResponse set kmFileManagerID = :kmFileManagerID where feedbackResponseID=:feedbackResponseID")
	Integer updateFileID(@Param("kmFileManagerID") Integer kmFileManagerID,
			@Param("feedbackResponseID") Long feedbackResponseID);
}
