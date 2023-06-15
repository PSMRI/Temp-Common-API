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
package com.iemr.common.utils.km.openkm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.km.KMService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { OpenKMServiceImpl.class, ConfigProperties.class, HttpUtils.class })
public class OpenKMServicesTest
{

	private KMService serv;

	@Autowired
	public void setServ(OpenKMServiceImpl openKMServiceImpl)
	{
		this.serv = openKMServiceImpl;
	}
	private String filepath = "e:/FAQ  for Onsite.docx";
	private String destPath = "1/2/3/FAQ.docx";

	@Test
	public void testGetRoot()
	{
		assertTrue(serv.getDocumentRoot().equals(""));
	}

	@Test
	public void testCreateDocument()
	{
		assertTrue(serv.createDocument(destPath, filepath).equals(destPath));
	}

}
