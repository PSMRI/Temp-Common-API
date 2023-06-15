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
package com.iemr.common.data.callhandling;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_phoneblock")
@Data
public class PhoneBlock
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ID")
	private Long phoneBlockID;
	@Expose
	@Column(name = "phoneNo")
	private String phoneNo;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	private ProviderServiceMapping providerServiceMapping;
	@Expose
	@Column(name = "NoOfNuisanceCall")
	private Integer noOfNuisanceCall;
	@Expose
	@Column(name = "IsBlocked")
	private Boolean isBlocked;
	@Expose
	@Column(name = "CTI_CampaignName")
	private String ctiCampaignName;
	@Expose
	@Column(name = "BlockStartDate")
	private Timestamp blockStartDate;
	@Expose
	@Column(name = "BlockEndDate")
	private Timestamp blockEndDate;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Column(name = "benCallIDs")
	private String callIDs;

	@Transient
	@Expose
	private List<String> benCallIDs;

	public Integer getNoOfNuisanceCall()
	{
		return noOfNuisanceCall;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public String getCtiCampaignName()
	{
		return ctiCampaignName;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public Long getPhoneBlockID()
	{
		return phoneBlockID;
	}

	public Boolean getIsBlocked()
	{
		return isBlocked;
	}

	public Timestamp getBlockStartDate()
	{
		return blockStartDate;
	}

	public Timestamp getBlockEndDate()
	{
		return blockEndDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public PhoneBlock()
	{
	}

	public static PhoneBlock initializePhoneBlockForCreate(Long phoneBlockID, String phoneNo,
			Integer providerServiceMapID, Integer noOfNuisanceCall, Boolean isBlocked, String ctiCampaignName,
			Timestamp blockStartDate, Timestamp blockEndDate, String callIDs)
	{
		PhoneBlock phoneBlock = new PhoneBlock();
		phoneBlock.phoneBlockID = phoneBlockID;
		phoneBlock.phoneNo = phoneNo;
		phoneBlock.providerServiceMapID = providerServiceMapID;
		phoneBlock.noOfNuisanceCall = noOfNuisanceCall;
		phoneBlock.isBlocked = isBlocked;
		phoneBlock.ctiCampaignName = ctiCampaignName;
		phoneBlock.blockStartDate = blockStartDate;
		phoneBlock.blockEndDate = blockEndDate;
		phoneBlock.callIDs = callIDs;
		phoneBlock.benCallIDs = ((callIDs != null) ? Arrays.asList(callIDs.split(",")) : null);
		return phoneBlock;
	}

	public static PhoneBlock initializePhoneBlock(Long phoneBlockID, String phoneNo, Integer providerServiceMapID,
			Integer noOfNuisanceCall, Boolean isBlocked, String ctiCampaignName, Timestamp blockStartDate,
			Timestamp blockEndDate, ProviderServiceMapping providerServiceMapping, String callIDs)
	{
		PhoneBlock phoneBlock = new PhoneBlock();
		phoneBlock.phoneBlockID = phoneBlockID;
		phoneBlock.phoneNo = phoneNo;
		phoneBlock.providerServiceMapID = providerServiceMapID;
		phoneBlock.noOfNuisanceCall = noOfNuisanceCall;
		phoneBlock.isBlocked = isBlocked;
		phoneBlock.ctiCampaignName = ctiCampaignName;
		phoneBlock.blockStartDate = blockStartDate;
		phoneBlock.blockEndDate = blockEndDate;
		phoneBlock.providerServiceMapping = providerServiceMapping;
		phoneBlock.callIDs = callIDs;
		phoneBlock.benCallIDs = ((callIDs != null) ? Arrays.asList(callIDs.split(",")) : null);
		return phoneBlock;
	}

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public ProviderServiceMapping getProviderServiceMapping()
	{
		return providerServiceMapping;
	}
}
