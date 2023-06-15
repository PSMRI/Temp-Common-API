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

import java.sql.Timestamp;

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
@Table(name="t_emailnotification")
public class EmailNotification {
	
	@Transient
	public static final int NOT_SENT = 0;
	@Transient
	public static final int IN_PROGRESS = 1;
	@Transient
	public static final int SENT = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmailNotificationID")
	private Integer EmailNotificationID;
	
	@Column(name = "EmailTemplateID")
	@Expose
	private Integer EmailTemplateID;
	
	@Column(name = "SenderID")
	Integer senderID;
	
	@Column(name = "ReceivingUserID")
	Integer receivingUserID;
	
	@Column(name = "BenCallID")
	Long benCallID;
	
	@Column(name = "BeneficiaryRegID")
	Long beneficiaryRegID;
	
	@Column(name = "PhoneNo")
	String phoneNo;
	
	@Column(name = "ReceiverEmailID")
	String emailID;
	
	@Column(name = "Email")
	String email;
	
	@Column(name = "EmailTriggerDate")
	Timestamp emailTriggerDate;
	
	@Column(name = "EmailStatus")
	Integer emailStatus;
	
	@Column(name = "EmailSentDate")
	Timestamp emailSentDate;
	
	@Column(name = "TransactionID")
	String transactionID;
	
	@Column(name = "isTransactionError")
	Boolean isTransactionError;
	
	@Column(name = "TransactionError")
	String transactionError;
	
	@Column(name = "ProviderServiceMapID")
	Integer providerServiceMapID;

	@Column(name = "Deleted", insertable = false, updatable = false)
	Boolean deleted;

	@Column(name = "CreatedBy", insertable = true, updatable = false)
	String createdBy;
	
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	Timestamp createdDate;
	
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	String modifiedBy;
	
	@Column(name = "LastModDate", insertable = false, updatable = false)
	Timestamp lastModDate;
	
	@Transient
	Long FeedbackID;
	
	@Transient
	Boolean is1097;
	
	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
	
}
