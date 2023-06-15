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

import java.sql.Timestamp;

public class EverwellSupportAction {
	//private Long everwellid;
	private Boolean addDose;
	private Timestamp dateOfAction;
//	public Long getEverwellid() {
//		return everwellid;
//	}
//	public void setEverwellid(Long everwellid) {
//		this.everwellid = everwellid;
//	}
	public Boolean getAddDose() {
		return addDose;
	}
	public void setAddDose(Boolean addDose) {
		this.addDose = addDose;
	}
	public Timestamp getDateOfAction() {
		return dateOfAction;
	}
	public void setDateOfAction(Timestamp dateOfAction) {
		this.dateOfAction = dateOfAction;
	}

}
