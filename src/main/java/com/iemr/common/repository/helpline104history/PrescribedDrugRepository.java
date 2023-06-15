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
package com.iemr.common.repository.helpline104history;


import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.helpline104history.COVIDHistory;
import com.iemr.common.data.helpline104history.Directoryservice;
import com.iemr.common.data.helpline104history.PrescribedDrug;
import com.iemr.common.data.helpline104history.RequestedInstitution;
import com.iemr.common.data.helpline104history.T_BloodRequest;
import com.iemr.common.data.helpline104history.T_EpidemicOutbreak;
import com.iemr.common.data.helpline104history.T_FoodSafetyCopmlaint;
import com.iemr.common.data.helpline104history.T_OrganDonation;
import com.iemr.common.data.helpline104history.T_RequestedBloodBank;


@Repository
@RestResource(exported = false)
public interface PrescribedDrugRepository extends CrudRepository<PrescribedDrug, Long>{
	
	@Query("select p.drugMapID,d.drugName,p.drugForm,p.drugRoute,p.frequency,p.dosage,p.noOfDays, "
			+ "p.timeToConsume,p.sideEffects,p.validTill "
			+ " from PrescribedDrug p "
			+ " RIGHT JOIN p.m_104drugmapping d "
			+ "where d.deleted = false and p.prescriptionID=:prescriptionID") 	
	public List<Objects[]> getPrescribedDrugs(@Param("prescriptionID") Long prescriptionID);
	
	@Query("select bloodRequest "
			+ " from T_BloodRequest bloodRequest "
			+ "where bloodRequest.deleted = false and bloodRequest.bloodReqID = :bloodReqID") 	
	public T_BloodRequest getBloodRequest(@Param("bloodReqID") Long bloodReqID);
	
	@Query("select directoryservice "
			+ " from Directoryservice directoryservice "
			+ "where directoryservice.deleted = false and directoryservice.directoryServiceID = :directoryServiceID") 	
	public Directoryservice getDirectoryservice(@Param("directoryServiceID") Long directoryServiceID);
	
	@Query("select foodSafetyCopmlaint "
			+ " from T_FoodSafetyCopmlaint foodSafetyCopmlaint "
			+ "where foodSafetyCopmlaint.deleted = false and foodSafetyCopmlaint.fSComplaintID = :fSComplaintID") 	
	public T_FoodSafetyCopmlaint getFoodSafetyCopmlaint(@Param("fSComplaintID") Long fSComplaintID);
	
	@Query("select epidemicOutbreak "
			+ " from T_EpidemicOutbreak epidemicOutbreak "
			+ "where epidemicOutbreak.deleted = false and epidemicOutbreak.outbreakComplaintID = :outbreakComplaintID") 	
	public T_EpidemicOutbreak getEpidemicOutbreak(@Param("outbreakComplaintID") Long outbreakComplaintID);
	
	@Query("select organDonation "
			+ " from T_OrganDonation organDonation "
			+ "where organDonation.deleted = false and organDonation.organDonationID = :organDonationID") 	
	public T_OrganDonation getOrganDonation(@Param("organDonationID") Long organDonationID);
	
	@Query("select requestedBloodBank "
			+ " from T_RequestedBloodBank requestedBloodBank "
			+ "where requestedBloodBank.requestedBloodBankID = :requestedBloodBankID") 	
	public T_RequestedBloodBank getBloodBankAddress(@Param("requestedBloodBankID") Long requestedBloodBankID);
	
	@Query("select requestedInstitution "
			+ " from RequestedInstitution requestedInstitution "
			+ "where requestedInstitution.requestedInstitutionID = :requestedInstitutionID") 	
	public RequestedInstitution getAcceptorHospitalAddress(@Param("requestedInstitutionID") Long requestedInstitutionID);
	
	@Query("select history "
			+ " from COVIDHistory history "
			+ "where history.beneficiaryRegID = :beneficiaryRegID order by history.createdDate desc") 	
	public List<COVIDHistory> getCOVIDData(@Param("beneficiaryRegID") Long beneficiaryRegID);
}
