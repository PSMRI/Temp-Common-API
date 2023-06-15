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
package com.iemr.common.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.dto.identity.BenIdentityDTO;
import com.iemr.common.model.userbeneficiary.BeneficiaryIdentityModel;
import com.iemr.common.model.userbeneficiary.GovtIdentityTypeModel;
import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;

public abstract class GovtIdentityTypeDecorator implements GovtIdentityTypeMapper
{
	@Autowired
	GovtIdentityTypeRepository govtIdentityTypeRepository;

	public GovtIdentityTypeModel govtIdentityTypeModelByIDToModel(Integer govtIdentityTypeModelID)
	{
		GovtIdentityTypeModel govtIdentityTypeModel = null;
		if (govtIdentityTypeModelID != null)
		{
			govtIdentityTypeModel = getGovtIdentity(govtIdentityTypeRepository.findOne(govtIdentityTypeModelID));
		}
		return govtIdentityTypeModel;
	}

	@Override
	public List<BeneficiaryIdentityModel> govtIdentityTypeModelsByIDToModel(List<BenIdentityDTO> identityDTOs)
	{
		List<BeneficiaryIdentityModel> identityModels = null;
		if (identityDTOs != null)
		{
			identityModels = new ArrayList<BeneficiaryIdentityModel>();
			for (BenIdentityDTO identityDTO : identityDTOs)
			{
				if (identityDTO.getIdentityNameId() != null)
				{
					BeneficiaryIdentityModel identityModel = new BeneficiaryIdentityModel();
					identityModel.setGovtIdentityNo(identityDTO.getIdentityNo());
					identityModel.setGovtIdentityTypeID(identityDTO.getIdentityNameId());
					identityModel.setBenIdentityId(identityDTO.getBenIdentityId());
					identityModel.setCreatedBy(identityDTO.getCreatedBy());
					identityModel.setDeleted(identityDTO.getDeleted());
					identityModel.setGovtIdentityType(
							getGovtIdentity(govtIdentityTypeRepository.findOne(identityDTO.getIdentityNameId())));
					identityModels.add(identityModel);
				}
			}
		}
		return identityModels;
	}
}
