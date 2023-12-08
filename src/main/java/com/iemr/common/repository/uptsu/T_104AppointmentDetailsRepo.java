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
package com.iemr.common.repository.uptsu;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.uptsu.T_104AppointmentDetails;

@Repository
@RestResource(exported = false)
public interface T_104AppointmentDetailsRepo extends CrudRepository<T_104AppointmentDetails, Integer>{
	
	@Query(value = " SELECT SMSTypeID FROM db_iemr.m_smstype " + " WHERE SMSType = :choSms ", nativeQuery = true)
	public Integer getSMSTypeIDCho(@Param("choSms") String choSms);
	
	@Query(value = " SELECT SMSTypeID FROM db_iemr.m_smstype " + " WHERE SMSType = :benSms ", nativeQuery = true)
	public Integer getSMSTypeIDBen(@Param("benSms") String benSms);
	
	@Query(value = " SELECT SMSTemplateID FROM db_iemr.m_smstemplate "
			+ " WHERE SMSTypeID = :smsTypeIDForCho ", nativeQuery = true)
	public Integer getSMSTemplateIDCho(@Param("smsTypeIDForCho") Integer smsTypeIDForCho);
	
	@Query(value = " SELECT SMSTemplateID FROM db_iemr.m_smstemplate "
			+ " WHERE SMSTypeID = :smsTypeIDForBeneficiary AND deleted = false", nativeQuery = true)
	public Integer getSMSTemplateIDBen(@Param("smsTypeIDForBeneficiary") Integer smsTypeIDForBeneficiary);
	
	
	@Query(value = "call Pr_BeneficiaryDetails(:benRegId)", nativeQuery = true)
	Object[] findBeneficiaryNameAndBeneficiaryIdByBenRegId(@Param("benRegId") Long benRegId);


}
