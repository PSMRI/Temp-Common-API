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
package com.iemr.common.utils.config;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigProperties.class)
public class ConfigPropertiesTest {

	private String redisUrl = "localhost";
	private int redisPort = 6379;
	private int sessionExpiryTime = 180;
	private boolean extendExpiryTime = true;
	// @Autowired
	private ConfigProperties props = new ConfigProperties();

	@BeforeClass
	public static void setProperties() {
	}

	@Test
	public void testGetRedisUrl() {
		try {
			assertEquals(redisUrl, props.getRedisUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRedisPort() {
		try {
			assertEquals(redisPort, props.getRedisPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetExtendExpiryTime() {
		try {
			assertEquals(extendExpiryTime, props.getExtendExpiryTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetSessionExpiryTime() {
		try {
			assertEquals(sessionExpiryTime, props.getSessionExpiryTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
