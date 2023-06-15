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
package com.iemr.common.data.users;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.userbeneficiarydata.Status;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_ServiceProvider")
public class ServiceProvider
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ServiceProviderID")
	private Integer serviceProviderID;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceProvider")
	@Expose
	@Transient
	private List<ProviderServiceMapping> providerServiceMappings;
	@Expose
	@Column(name = "ServiceProviderName")
	private String serviceProviderName;
	@Expose
	@Column(name = "JoiningDate")
	private Date joiningDate;
	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@Column(name = "LogoFileName")
	private String logoFileName;
	@Expose
	@Column(name = "LogoFilePath")
	private String logoFilePath;
	@Expose
	@Column(name = "PrimaryContactName")
	private String primaryContactName;
	@Expose
	@Column(name = "PrimaryContactNo")
	private String primaryContactNo;
	@Expose
	@Column(name = "PrimaryContactEmailID")
	private String primaryContactEmailID;
	@Expose
	@Column(name = "PrimaryContactAddress")
	private String primaryContactAddress;
	@Expose
	@Column(name = "PrimaryContactValidityTillDate")
	private Date primaryContactValidityTillDate;
	@Expose
	@Column(name = "SecondaryContactName")
	private String secondaryContactName;
	@Expose
	@Column(name = "SecondaryContactNo")
	private String secondaryContactNo;
	@Expose
	@Column(name = "SecondaryContactEmailID")
	private String secondaryContactEmailID;
	@Expose
	@Column(name = "SecondaryContactAddress")
	private String secondaryContactAddress;
	@Expose
	@Column(name = "SecondaryContactValidityTillDate")
	private Date secondaryContactValidityTillDate;
	@Expose
	@Column(name = "StatusID")
	private Integer statusID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StatusID", insertable = false, updatable = false)
	private Status status;
	@Expose
	@Column(name = "ValidFrom")
	private Date validFrom;
	@Expose
	@Column(name = "ValidTill")
	private Date validTill;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	/*
	 * @OneToOne(mappedBy="m_ServiceProvider") private M_UserServiceRoleMapping2 m_UserServiceRoleMapping;
	 */

	public ServiceProvider()
	{
		// TODO Auto-generated constructor stub
	}

	public Integer getServiceProviderID()
	{
		return serviceProviderID;
	}

	public void setServiceProviderID(Integer serviceProviderID)
	{
		this.serviceProviderID = serviceProviderID;
	}

	public String getServiceProviderName()
	{
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName)
	{
		this.serviceProviderName = serviceProviderName;
	}

	public Date getJoiningDate()
	{
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate)
	{
		this.joiningDate = joiningDate;
	}

	public Integer getStateID()
	{
		return stateID;
	}

	public void setStateID(Integer stateID)
	{
		this.stateID = stateID;
	}

	public String getLogoFileName()
	{
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName)
	{
		this.logoFileName = logoFileName;
	}

	public String getLogoFilePath()
	{
		return logoFilePath;
	}

	public void setLogoFilePath(String logoFilePath)
	{
		this.logoFilePath = logoFilePath;
	}

	public String getPrimaryContactName()
	{
		return primaryContactName;
	}

	public void setPrimaryContactName(String primaryContactName)
	{
		this.primaryContactName = primaryContactName;
	}

	public String getPrimaryContactNo()
	{
		return primaryContactNo;
	}

	public void setPrimaryContactNo(String primaryContactNo)
	{
		this.primaryContactNo = primaryContactNo;
	}

	public String getPrimaryContactEmailID()
	{
		return primaryContactEmailID;
	}

	public void setPrimaryContactEmailID(String primaryContactEmailID)
	{
		this.primaryContactEmailID = primaryContactEmailID;
	}

	public String getPrimaryContactAddress()
	{
		return primaryContactAddress;
	}

	public void setPrimaryContactAddress(String primaryContactAddress)
	{
		this.primaryContactAddress = primaryContactAddress;
	}

	public Date getPrimaryContactValidityTillDate()
	{
		return primaryContactValidityTillDate;
	}

	public void setPrimaryContactValidityTillDate(Date primaryContactValidityTillDate)
	{
		this.primaryContactValidityTillDate = primaryContactValidityTillDate;
	}

	public String getSecondaryContactName()
	{
		return secondaryContactName;
	}

	public void setSecondaryContactName(String secondaryContactName)
	{
		this.secondaryContactName = secondaryContactName;
	}

	public String getSecondaryContactNo()
	{
		return secondaryContactNo;
	}

	public void setSecondaryContactNo(String secondaryContactNo)
	{
		this.secondaryContactNo = secondaryContactNo;
	}

	public String getSecondaryContactEmailID()
	{
		return secondaryContactEmailID;
	}

	public void setSecondaryContactEmailID(String secondaryContactEmailID)
	{
		this.secondaryContactEmailID = secondaryContactEmailID;
	}

	public String getSecondaryContactAddress()
	{
		return secondaryContactAddress;
	}

	public void setSecondaryContactAddress(String secondaryContactAddress)
	{
		this.secondaryContactAddress = secondaryContactAddress;
	}

	public Date getSecondaryContactValidityTillDate()
	{
		return secondaryContactValidityTillDate;
	}

	public void setSecondaryContactValidityTillDate(Date secondaryContactValidityTillDate)
	{
		this.secondaryContactValidityTillDate = secondaryContactValidityTillDate;
	}

	public Integer getStatusID()
	{
		return statusID;
	}

	public void setStatusID(Integer statusID)
	{
		this.statusID = statusID;
	}

	public Date getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom(Date validFrom)
	{
		this.validFrom = validFrom;
	}

	public Date getValidTill()
	{
		return validTill;
	}

	public void setValidTill(Date validTill)
	{
		this.validTill = validTill;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	/*
	 * public M_UserServiceRoleMapping2 getM_UserServiceRoleMapping() { return m_UserServiceRoleMapping; }
	 * 
	 * 
	 * public void setM_UserServiceRoleMapping(M_UserServiceRoleMapping2 m_UserServiceRoleMapping) {
	 * this.m_UserServiceRoleMapping = m_UserServiceRoleMapping; }
	 */

}
