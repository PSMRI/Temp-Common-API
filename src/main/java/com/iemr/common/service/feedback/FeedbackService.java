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
package com.iemr.common.service.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.feedback.FeedbackLog;
import com.iemr.common.model.feedback.FeedbackListRequestModel;

public interface FeedbackService {

	public List<FeedbackDetails> getFeedbackRequests(Long id);

	public List<FeedbackDetails> getFeedbackRequest(Long id);

	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails);
	
	public Integer updateFeedback(String feedbackDetails) throws Exception;

	public String saveFeedbackResponseFromAuthority(String feedbackDetails) throws Exception;

	public ArrayList<Object[]> getDateBetween(Timestamp startDate, Timestamp endDate);

	public ArrayList<Object[]> getFeedbackByID(Integer feedbackId);

	public String getAllData(String request) throws Exception;

	public String updateFeedbackStatus(String feedbackDetails) throws Exception;

	String searchFeedback(String feedbackDetails) throws Exception;

	public String searchFeedback1(String feedbackDetails) throws Exception;
	
	public String getFeedbackStatus(String feedbackStatus);
	
	public String getEmailStatus(String emailStatus);

	String saveFeedback(String feedbackDetails) throws Exception;
	
	String createFeedbackRequest(String feedbackRequestString) throws Exception;
	
	String updateResponse(String updateResponseString) throws Exception;

	String getFeedbacksList(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String getGrievancesByCreatedDate(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String getGrievancesByUpdatedDate(FeedbackListRequestModel feedbackDetails, String authKey) throws Exception;

	String saveFeedbackRequest(String feedbackRequestString) throws Exception;

	String getFeedbackLogs(FeedbackLog feedbackLogs) throws Exception;

}
