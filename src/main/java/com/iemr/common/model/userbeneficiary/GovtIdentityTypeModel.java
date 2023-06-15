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
package com.iemr.common.model.userbeneficiary;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.common.dto.identity.BenIdentityDTO;

import lombok.Data;

public @Data class GovtIdentityTypeModel
{
	@Expose
	private Integer govtIdentityTypeID;
	// private List<BeneficiaryModel> beneficiaryModels;
	@Expose
	private String identityType;
	@Expose
	private Boolean isGovtID;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;

	public static GovtIdentityTypeModel createGovtIdentity(BenIdentityDTO benIdentityDTO)
	{
		GovtIdentityTypeModel govtIdentityType = new GovtIdentityTypeModel();
		if (benIdentityDTO != null)
		{
			govtIdentityType.govtIdentityTypeID = benIdentityDTO.getIdentityNameId();
			govtIdentityType.identityType = benIdentityDTO.getIdentityName();
			govtIdentityType.isGovtID = benIdentityDTO.getIsVerified();
		}
		return govtIdentityType;
	}

	public static GovtIdentityTypeModel createGovtIdentity(List<BenIdentityDTO> benIdentityDTOList)
	{
		GovtIdentityTypeModel govtIdentityType = new GovtIdentityTypeModel();
		if (benIdentityDTOList != null && benIdentityDTOList.size() > 0)
		{
			BenIdentityDTO benIdentityDTO = benIdentityDTOList.get(0);
			govtIdentityType.govtIdentityTypeID = benIdentityDTO.getIdentityNameId();
			govtIdentityType.identityType = benIdentityDTO.getIdentityName();

		}
		return govtIdentityType;
	}

	public static String getIdentityNo(List<BenIdentityDTO> benIdentityDTOList)
	{

		return benIdentityDTOList != null && benIdentityDTOList.size() > 0 ? benIdentityDTOList.get(0).getIdentityNo()
				: null;

	}

	public static Integer getIdentityTypeNo(List<BenIdentityDTO> benIdentityDTOList)
	{

		return benIdentityDTOList != null && benIdentityDTOList.size() > 0
				? benIdentityDTOList.get(0).getIdentityNameId() : null;

	}
}
