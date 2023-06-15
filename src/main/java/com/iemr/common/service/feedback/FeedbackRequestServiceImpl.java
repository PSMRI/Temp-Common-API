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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.feedback.FeedbackRequest;
import com.iemr.common.data.users.EmailStatus;
import com.iemr.common.repository.feedback.FeedbackRequestRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class FeedbackRequestServiceImpl implements FeedbackRequestService
{

	private InputMapper inputMapper = new InputMapper();

	@Autowired
	FeedbackRequestRepository feedbackRequestRepository;

	@Override
	public FeedbackRequest getFeedbackReuest(Long feedbackRequestID)
	{
		return feedbackRequestRepository.findOne(feedbackRequestID);
	}

	@Override
	public String createFeedbackRequest(String feedbackRequestString) throws IEMRException
	{
		FeedbackRequest feedbackRequest = inputMapper.gson().fromJson(feedbackRequestString, FeedbackRequest.class);
		feedbackRequest = feedbackRequestRepository.save(feedbackRequest);
		// if (feedbackRequest.) {
		//
		// }
		return feedbackRequest.toString();
	}

	@Override
	public String getAllFeedback(String feedbackRequestString) throws IEMRException
	{
		FeedbackRequest feedbackRequest = inputMapper.gson().fromJson(feedbackRequestString, FeedbackRequest.class);
		// Map<String, Object> resMap = null;
		// List<Map<String, Object>> resList = new ArrayList<>();
		// // feedbackRequestRepository.all
		ArrayList<Object[]> allfeedback = feedbackRequestRepository.getAllFeedback(feedbackRequest.getFeedbackID());
		List<FeedbackRequest> requests = new ArrayList<FeedbackRequest>();
		// feedbackRequestID, feedbackID, feedbackSupSummary, supUserID,
		// comments, emailStatusID, emailStatus
		for (Object[] object : allfeedback)
		{
			if (object != null && object.length >= 7)
			{
				requests.add(new FeedbackRequest((Long) object[0], (Long) object[1], (String) object[2],
						(Integer) object[3], (String) object[4], (Integer) object[5], (EmailStatus) object[6]));
			}
		}
		return requests.toString();
	}
}
