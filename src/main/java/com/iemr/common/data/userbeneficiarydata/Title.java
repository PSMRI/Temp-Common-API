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
package com.iemr.common.data.userbeneficiarydata;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "m_title")
public class Title
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TitleID")
	@Expose
	private Integer titleID;
	@OneToMany(/* mappedBy = "m_title", fetch = FetchType.LAZY */)
	@JoinColumn(name = "titleID", referencedColumnName = "titleID", insertable = false, updatable = false)
	// @Expose
	@Transient
	private Set<User> m_user;

	// @Expose
	@Transient
	private Set<Beneficiary> i_beneficiary;

	@Column(name = "TitleName")
	@Expose
	private String titleName;
	@Column(name = "TitleDesc")
	@Expose
	private String titleDesc;
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

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Title getDefaultConstructor()
	{
		return this;
	}

	public Title getTitle(int titleID, String titleName)
	{
		this.titleID = Integer.valueOf(titleID);
		this.titleName = titleName;
		return this;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}