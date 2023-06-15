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
package com.iemr.common.data.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name="m_emailtemplate")
public class EmailTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmailTemplateID")
	private Integer emailTemplateID;
	
	@Column(name = "EmailTemplateName")
	@Expose
	private String emailTemplateName;
	
	@Column(name = "EmailTemplate")
	@Expose
	private String emailTemplate;
	
	@Column(name = "Deleted")
	private Boolean deleted;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	
}
