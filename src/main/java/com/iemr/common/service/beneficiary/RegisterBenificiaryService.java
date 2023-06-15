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
/**
 * 
 */
package com.iemr.common.service.beneficiary;

import javax.servlet.http.HttpServletRequest;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.model.beneficiary.BeneficiaryModel;

import com.iemr.common.utils.exception.IEMRException;

/**
 * @author WA875423
 *
 */
public interface RegisterBenificiaryService
{

	public Beneficiary save(Beneficiary m_user);

	// public Integer updateBenificiary(Beneficiary m_user);

	public Integer updateBenificiary(BeneficiaryModel m_user, String auth) throws IEMRException;

	String save(BeneficiaryModel beneficiaryModel, HttpServletRequest servletRequest) throws Exception;
	
	public Integer updateCommunityorEducation(BeneficiaryModel m_user, String auth) throws IEMRException;
	//
	// List<Beneficiary> findByBeneficiaryRegID(Beneficiary benificiaryDetails);
	//
	// List<Beneficiary> findByBeneficiaryPhoneNo(Beneficiary beneficiary);

	String generateBeneficiaryIDs(String request, HttpServletRequest servletRequest) throws Exception;

	// Beneficiary updateBenificiary(Beneficiary benificiaryDetails);
}
