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
package com.iemr.common.notification;

import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.controller.notification.NotificationController;
import com.iemr.common.cti.Constants;
import com.iemr.common.service.notification.NotificationService;
import com.iemr.common.service.notification.NotificationServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationControllerTest
{
	@InjectMocks
	private NotificationController controllerSpy = spy(NotificationController.class);
	private NotificationService ctiServiceSpy = spy(new NotificationServiceImpl());

	MockHttpServletRequest request = new MockHttpServletRequest();
	MockHttpServletRequest requestNoIP = new MockHttpServletRequest();

	@Before
	public void initailize()
	{
		request.setRemoteAddr(Constants.REQUESTOR_IP);
		requestNoIP.setRemoteAddr("");
	}	
}
