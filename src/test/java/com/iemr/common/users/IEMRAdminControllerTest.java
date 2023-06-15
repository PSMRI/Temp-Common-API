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
package com.iemr.common.users;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.service.users.IEMRAdminUserService;
import com.iemr.common.service.users.IEMRAdminUserServiceImpl;
import com.iemr.common.utils.exception.IEMRException;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IEMRAdminControllerTest
{

	private static IEMRAdminUserService testService;

	// Success Inputs
	private static final String INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1 = "";
	private static final String INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2 = "";

	// Failure Inputs
	private static final String INPUT_ROLES_BY_PROVIDER_ID_FAILURE_1 = "";

	// Success Outputs
	private static final String OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1 = "";
	private static final String OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2 = "";

	// Failure Outputs
	private static final String OUTPUT_ROLES_BY_PROVIDER_ID_FAILURE_1 = "";

	@Before
	public void initializeTest()
	{
		testService = mock(IEMRAdminUserServiceImpl.class);
		try
		{
			/* Success mocks */
			when(testService.getRolesByProviderID(INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1))
					.thenReturn(OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1);

			when(testService.getRolesByProviderID(INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2))
					.thenReturn(OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2);
			/* Failure mocks */
			when(testService.getRolesByProviderID(INPUT_ROLES_BY_PROVIDER_ID_FAILURE_1))
					.thenReturn(OUTPUT_ROLES_BY_PROVIDER_ID_FAILURE_1);
		} catch (IEMRException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void test001GetRolesByProviderIDSuccess()
	{
		try
		{
			assertTrue(testService.getRolesByProviderID(INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1)
					.equals(OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_1));
			assertTrue(testService.getRolesByProviderID(INPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2)
					.equals(OUTPUT_ROLES_BY_PROVIDER_ID_SUCCESS_2));
		} catch (IEMRException e)
		{
			e.printStackTrace();
		}
	}

}
