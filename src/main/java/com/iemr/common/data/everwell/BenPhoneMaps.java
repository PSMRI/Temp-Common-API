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
package com.iemr.common.data.everwell;

public class BenPhoneMaps {

	private Integer benRelationshipID;
	private String phoneNo;
	private String phoneNoEverwell;
	private String createdBy;
	private boolean deleted;
	
	public BenPhoneMaps() {
		
	}
	
	public BenPhoneMaps(Integer benRelationshipID, String phoneNo, String createdBy,boolean deleted ) {
		this.benRelationshipID = benRelationshipID;
		this.phoneNo = phoneNo;
		this.createdBy = createdBy;
		this.deleted = deleted;
	}
	
//	public BenPhoneMaps(Integer benRelationshipID, String phoneNo, String createdBy,boolean deleted ) {
//		this.benRelationshipID = benRelationshipID;
//		this.phoneNoEverwell = phoneNo;
//		this.createdBy = createdBy;
//		this.deleted = deleted;
//	}
}
