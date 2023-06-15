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
package com.iemr.common.data.beneficiary;

import java.util.List;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.Community;
import com.iemr.common.data.userbeneficiarydata.Gender;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.data.userbeneficiarydata.MaritalStatus;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.data.userbeneficiarydata.Title;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class BeneficiaryRegistrationData
{
	@Expose
	private List<Title> m_Title;
	@Expose
	private List<Status> m_Status;
	@Expose
	private List<BeneficiaryEducation> i_BeneficiaryEducation;
	@Expose
	private List<States> states;
	@Expose
	private List<Gender> m_genders;
	@Expose
	private List<MaritalStatus> m_maritalStatuses;
	@Expose
	private List<Community> m_communities;
	@Expose
	private List<Language> m_language;
	@Expose
	private List<Directory> directory;
	@Expose
	private List<SexualOrientation> sexualOrientations;
	@Expose
	private List<CallType> callTypes;
	@Expose
	private List<BenRelationshipType> benRelationshipTypes;
	@Expose
	private List<BeneficiaryOccupation> beneficiaryOccupations;
	@Expose
	private List<GovtIdentityType> govtIdentityTypes;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

	// public List<BeneficiaryEducation> getI_BeneficiaryEducation()
	// {
	// return i_BeneficiaryEducation;
	// }
	//
	// public void setI_BeneficiaryEducation(List<BeneficiaryEducation> i_BeneficiaryEducation)
	// {
	// this.i_BeneficiaryEducation = i_BeneficiaryEducation;
	// }
	//
	// public List<Gender> getM_genders()
	// {
	// return m_genders;
	// }
	//
	// public void setM_genders(List<Gender> m_genders)
	// {
	// this.m_genders = m_genders;
	// }
	//
	// public List<MaritalStatus> getM_maritalStatuses()
	// {
	// return m_maritalStatuses;
	// }
	//
	// public void setM_maritalStatuses(List<MaritalStatus> m_maritalStatuses)
	// {
	// this.m_maritalStatuses = m_maritalStatuses;
	// }
	//
	// public List<Title> getM_Title()
	// {
	// return this.m_Title;
	// }
	//
	// public void setM_Title(List<Title> m_Title)
	// {
	// this.m_Title = m_Title;
	// }
	//
	// public List<Status> getM_Status()
	// {
	// return this.m_Status;
	// }
	//
	// public void setM_Status(List<Status> m_Status)
	// {
	// this.m_Status = m_Status;
	// }
	//
	// public List<BeneficiaryEducation> getM_UserQualification()
	// {
	// return this.i_BeneficiaryEducation;
	// }
	//
	// public void setM_UserQualification(List<BeneficiaryEducation> m_UserQualification)
	// {
	// this.i_BeneficiaryEducation = m_UserQualification;
	// }
	//
	// public List<States> getStates()
	// {
	// return this.states;
	// }
	//
	// public void setStates(List<States> states)
	// {
	// this.states = states;
	// }
	//
	// public List<Gender> getM_Genders()
	// {
	// return this.m_genders;
	// }
	//
	// public void setM_Genders(List<Gender> m_genders)
	// {
	// this.m_genders = m_genders;
	// }
	//
	// public List<MaritalStatus> getMaritalStatus()
	// {
	// return this.m_maritalStatuses;
	// }
	//
	// public void setMaritalStatus(List<MaritalStatus> m_maritalStatuses)
	// {
	// this.m_maritalStatuses = m_maritalStatuses;
	// }
	//
	// public List<Language> getM_language()
	// {
	// return m_language;
	// }
	//
	// public void setM_language(List<Language> m_language)
	// {
	// this.m_language = m_language;
	// }
	//
	// public List<Directory> getDirectory()
	// {
	// return directory;
	// }
	//
	// public void setDirectory(List<Directory> directory)
	// {
	// this.directory = directory;
	// }
	//
	// /**
	// * @return the m_communities
	// */
	// public List<Community> getM_communities()
	// {
	// return m_communities;
	// }
	//
	// /**
	// * @param m_communities
	// * the m_communities to set
	// */
	// public void setM_communities(List<Community> m_communities)
	// {
	// this.m_communities = m_communities;
	// }
	//
	// /**
	// * @return the sexualOrientations
	// */
	// public List<SexualOrientation> getSexualOrientations()
	// {
	// return sexualOrientations;
	// }
	//
	// /**
	// * @param sexualOrientations
	// * the sexualOrientations to set
	// */
	// public void setSexualOrientations(List<SexualOrientation> sexualOrientations)
	// {
	// this.sexualOrientations = sexualOrientations;
	// }
	//
	// public void setCallTypes(List<CallType> callTypes)
	// {
	// this.callTypes = callTypes;
	// }
	//
	// public List<CallType> getCallTypes()
	// {
	// return callTypes;
	// }
	//
	// public void setBenRelationshipTypes(List<BenRelationshipType> benRelationshipTypes)
	// {
	// this.benRelationshipTypes = benRelationshipTypes;
	// }
	//
	// public void setBeneficiaryOccupation(List<BeneficiaryOccupation> beneficiaryOccupations)
	// {
	// this.beneficiaryOccupations = beneficiaryOccupations;
	// }
	//
	// public void setGovtIdentityTypes(List<GovtIdentityType> activeIDTypes)
	// {
	// this.govtIdentityTypes = activeIDTypes;
	// }
}
