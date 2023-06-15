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
package com.iemr.common.data.mctshistory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.questionconfig.QuestionnaireDetail;
import com.iemr.common.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_mctscallresponse")
public class MctsCallResponseDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "MctsCallResponseID")
	private Long mctsCallResponseID;

	@Expose
	@Column(name = "MotherID")
	private Long motherID;

	@Expose
	@Column(name = "ChildID")
	private Long childID;
	
	@Expose
	@Column(name = "BenCallID", insertable = true, updatable = false)
	private Long callDetailID;

	@Expose
	@Column(name = "QuestionID", insertable = true, updatable = false)
	private Integer questionID;

	@Expose
	@Column(name = "Answer")
	private String answer;

	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private Boolean modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Date lastModDate;

	 /**
	 * mcts questioner map
	 */
	 @Expose
	 @OneToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "questionID", insertable = false, updatable = false)
	 private QuestionnaireDetail questionnaireDetail;
	
	 /**
	 * mcts outbound call
	 */
	 @Expose
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="BenCallID", insertable = false, updatable = false)
	 private MctsOutboundCallDetail mctsOutboundCallDetail;

	private static OutputMapper outputMapper = new OutputMapper();

	/**
	 * @return the mctsCallResponseID
	 */
	public Long getMctsCallResponseID() {
		return mctsCallResponseID;
	}

	/**
	 * @param mctsCallResponseID the mctsCallResponseID to set
	 */
	public void setMctsCallResponseID(Long mctsCallResponseID) {
		this.mctsCallResponseID = mctsCallResponseID;
	}

	/**
	 * @return the motherID
	 */
	public Long getMotherID() {
		return motherID;
	}

	/**
	 * @param motherID the motherID to set
	 */
	public void setMotherID(Long motherID) {
		this.motherID = motherID;
	}

	/**
	 * @return the childID
	 */
	public Long getChildID() {
		return childID;
	}

	/**
	 * @param childID the childID to set
	 */
	public void setChildID(Long childID) {
		this.childID = childID;
	}

	/**
	 * @return the callDetailID
	 */
	public Long getCallDetailID() {
		return callDetailID;
	}

	/**
	 * @param callDetailID the callDetailID to set
	 */
	public void setCallDetailID(Long callDetailID) {
		this.callDetailID = callDetailID;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * @return the questionID
	 */
	public Integer getQuestionID() {
		return questionID;
	}

	/**
	 * @param questionID the questionID to set
	 */
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	
//	/**
//	 * @return the benCallID
//	 */
//	public Long getBenCallID() {
//		return benCallID;
//	}
//
//	/**
//	 * @param benCallID the benCallID to set
//	 */
//	public void setBenCallID(Long benCallID) {
//		this.benCallID = benCallID;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
