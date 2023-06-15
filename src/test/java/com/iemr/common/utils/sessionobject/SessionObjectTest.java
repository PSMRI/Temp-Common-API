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
package com.iemr.common.utils.sessionobject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.utils.IEMRApplBeans;
import com.iemr.common.utils.redis.RedisSessionException;
import com.iemr.common.utils.redis.RedisStorage;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = { RedisStorage.class, LettuceConnectionFactory.class, SessionObject.class })
public class SessionObjectTest {

	// public static SessionObject object;
	static String key = "test1234";

	// @Bean
	// public RedisStorage sessionObject() {
	// return new RedisStorage();
	// }

	@Autowired
	public SessionObject object;
	IEMRApplBeans beans = new IEMRApplBeans();
	// public static SessionObject object;
	//
	// @Bean
	// public LettuceConnectionFactory createConnection() {
	// return new LettuceConnectionFactory();
	// }

	// @Bean
	// public ConfigProperties createConfigProperties()
	// {
	// return new ConfigProperties();
	// }

	@BeforeClass
	public static void initSessionObject() {
		// object = new SessionObject();
	}

	@Test
	public void test001GetObject() {
		String output = "";
		try {
			output = object.getSessionObject(key);
		} catch (RedisSessionException e) {
			assertEquals("", output);
		}
	}

	@Test
	public void test002SetObject() {
		String output = "";
		String input = "{value:\"this is a test\"}";
		try {
			output = object.setSessionObject(key, input);
			assertEquals(key, output);
			output = object.getSessionObject(key);
			assertEquals(input, output);
		} catch (RedisSessionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test003UpdateObject() {
		String output = "";
		String input = "{value:\"value of the object updated\"}";
		try {
			output = object.updateSessionObject(key, input);
			assertEquals(key, output);
			output = object.getSessionObject(key);
			assertEquals(input, output);
		} catch (RedisSessionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test004DeleteObject() {
		String output = "";
		try {
			object.deleteSessionObject(key);
			assertEquals("", output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void checkdeleteObject() {
		String output = "";
		try {
			output = object.getSessionObject(key);
		} catch (RedisSessionException e) {
			e.printStackTrace();
			assertEquals("", output);
		}
	}

	@AfterClass
	public static void clearSessionObject() {

	}

}
