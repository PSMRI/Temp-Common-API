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

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.Phone;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class BenPhoneMap
{

	@Expose
	private Long benPhMapID;

	@Expose
	private Long benificiaryRegID;

	@Transient
	private Beneficiary beneficiary;

	@Expose
	private Long parentBenRegID;

	@JsonIgnore
	private Beneficiary parentBeneficiary;

	@Expose
	private Integer benRelationshipID;

	@Expose
	private String benRelationshipName;

	@Expose
	// @Transient
	private BenRelationshipType benRelationshipType;

	@Expose
	private String phoneNo;

	@Expose
	private Integer phoneTypeID;

	@Expose
	private String phoneTypeName;

	// @Transient
	private PhoneType phoneType;

	@Expose
	private Boolean deleted;

	@Expose
	private String createdBy;

	private Timestamp createdDate;

	private String modifiedBy;

	private Timestamp lastModDate;
	// 'NuisanceCallCount', 'smallint(6)', 'YES', '', NULL, ''
	// @Expose
	private Integer nuisanceCallCount = 0;

	@Transient
	private Boolean is1097 = false;

	/**
	 * @return the benPhMapID
	 */
	public Long getBenPhMapID()
	{
		return benPhMapID;
	}

	/**
	 * @return the benificiaryRegID
	 */
	public Long getBenificiaryRegID()
	{
		return benificiaryRegID;
	}

	/**
	 * @return the benificiaryRegID
	 */
	public void setBenificiaryRegID(Long benificiaryRegID)
	{
		this.benificiaryRegID = benificiaryRegID;
	}

	/**
	 * @return the beneficiary
	 */
	public Beneficiary getBeneficiary()
	{
		return beneficiary;
	}

	/**
	 * @return the parentBenRegID
	 */
	public Long getParentBenRegID()
	{
		return parentBenRegID;
	}

	/**
	 * @return the parentBeneficiary
	 */
	public Beneficiary getParentBeneficiary()
	{
		return parentBeneficiary;
	}

	/**
	 * @return the benRelationshipID
	 */
	public Integer getBenRelationshipID()
	{
		return benRelationshipID;
	}

	/**
	 * @return the benRelationshipType
	 */
	public BenRelationshipType getBenRelationshipType()
	{
		return benRelationshipType;
	}

	/**
	 * @return the phoneTypeID
	 */
	public Integer getPhoneTypeID()
	{
		return phoneTypeID;
	}

	/**
	 * @return the phoneType
	 */
	public PhoneType getPhoneType()
	{
		return phoneType;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted()
	{
		return deleted;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy()
	{
		return modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	/**
	 * @return the outputMapper
	 */
	public OutputMapper getOutputMapper()
	{
		return outputMapper;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public String getPhoneNo()
	{
		return this.phoneNo;
	}

	public BenPhoneMap()
	{

	}

	public void setParentBenRegID(Long parentBenRegID)
	{
		this.parentBenRegID = parentBenRegID;
	}

	public BenPhoneMap(Long benPhMapID, Long benificiaryRegID, Long parentBenRegID, Integer benRelationshipID,
			String phoneNo, Integer phoneTypeID, Boolean deleted)
	{
		this.benPhMapID = benPhMapID;
		this.benificiaryRegID = benificiaryRegID;
		this.parentBenRegID = parentBenRegID;
		this.benRelationshipID = benRelationshipID;
		this.phoneNo = phoneNo;
		this.phoneTypeID = phoneTypeID;
		this.deleted = deleted;
	}

	public BenPhoneMap(Long benPhMapID, Long benificiaryRegID, Long parentBenRegID, Integer benRelationshipID,
			String phoneNo, Integer phoneTypeID, Boolean deleted, BenRelationshipType benRelationshipType,
			Integer nuisanceCallCount)
	{
		this.benPhMapID = benPhMapID;
		this.benificiaryRegID = benificiaryRegID;
		this.parentBenRegID = parentBenRegID;
		this.benRelationshipID = benRelationshipID;
		this.phoneNo = phoneNo;
		this.phoneTypeID = phoneTypeID;
		this.deleted = deleted;
		this.benRelationshipType = new BenRelationshipType(benRelationshipType.getBenRelationshipID(),
				benRelationshipType.getBenRelationshipType(), benRelationshipType.getDeleted());
		this.nuisanceCallCount = nuisanceCallCount;
	}
	
	//for everwell
	
	public BenPhoneMap(Integer benRelationshipID, String phoneNo, String createdBy,boolean deleted ) {
		this.benRelationshipID = benRelationshipID;
		this.phoneNo = phoneNo;
		this.createdBy = createdBy;
		this.deleted = deleted;
		this.is1097 = true;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;

	}

	public Integer getNuisanceCallCount()
	{
		return nuisanceCallCount;
	}

	public void setNuisanceCallCount(Integer nuisanceCallCount)
	{
		this.nuisanceCallCount = nuisanceCallCount;
	}

	public static List<BenPhoneMap> createBenPhoneMaps(List<BenFamilyDTO> familyMembers, List<Phone> phones,
			BigInteger benificiaryRegID)
	{
		List<BenPhoneMap> models = new ArrayList<BenPhoneMap>();
		for (BenFamilyDTO benFamilyDTO : familyMembers)
		{
			if (phones != null)
			{
				for (int phoneIdx = 0; phones.size() > phoneIdx; phoneIdx++)
				{
					BenPhoneMap model = new BenPhoneMap();
					Phone phone = phones.get(phoneIdx);
					model.benPhMapID = Long.parseLong(benFamilyDTO.getBenFamilyMapId().toString());
					model.benificiaryRegID = Long.parseLong(benificiaryRegID.toString());
					model.parentBenRegID = Long.parseLong(benFamilyDTO.getAssociatedBenRegId().toString());
					model.benRelationshipID = benFamilyDTO.getRelationshipID();
					model.phoneNo = phone.getPhoneNum();
				}
			}
		}
		return models;
	}

}
