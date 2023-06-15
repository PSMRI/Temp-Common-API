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

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_loginsecurityquestions")
@Data
public class LoginSecurityQuestions
{
	@Id
	@Column(name = "QuestionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer QuestionID;
	@Expose
	private String Question;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp LastModDate;

	@OneToOne(mappedBy = "m_LoginSecurityQuestions")
	@PrimaryKeyJoinColumn
	private UserSecurityQMapping m_UserSecurityQMapping;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	// protected LoginSecurityQuestions() {
	//
	// }

	public LoginSecurityQuestions getLoginSecurityQuestions(Integer questionID, String question, Boolean deleted,
			String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		// this.super();
		QuestionID = questionID;
		Question = question;
		Deleted = deleted;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		ModifiedBy = modifiedBy;
		LastModDate = lastModDate;
		return this;
	}

	public Integer getQuestionID()
	{
		return QuestionID;
	}

	public String getQuestion()
	{
		return Question;
	}

	public Boolean getDeleted()
	{
		return Deleted;
	}

	public String getCreatedBy()
	{
		return CreatedBy;
	}

	public Timestamp getCreatedDate()
	{
		return CreatedDate;
	}

	public String getModifiedBy()
	{
		return ModifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return LastModDate;
	}

	// public UserSecurityQMapping getM_UserSecurityQMapping() {
	// return m_UserSecurityQMapping;
	// }

	public void setQuestionID(Integer questionID)
	{
		QuestionID = questionID;
	}

	public void setQuestion(String question)
	{
		Question = question;
	}

	public void setDeleted(Boolean deleted)
	{
		Deleted = deleted;
	}

	public void setCreatedBy(String createdBy)
	{
		CreatedBy = createdBy;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		CreatedDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy)
	{
		ModifiedBy = modifiedBy;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		LastModDate = lastModDate;
	}

	// public void setM_UserSecurityQMapping(UserSecurityQMapping m_UserSecurityQMapping) {
	// this.m_UserSecurityQMapping = m_UserSecurityQMapping;
	// }

	/**
	 * wasim constructor wit parameter
	 * 
	 * @param questionID
	 * @param question
	 */
	public LoginSecurityQuestions getSecurityQuestions(Integer questionID, String question)
	{

		QuestionID = questionID;
		Question = question;
		return this;
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
