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

public class AddSupportAction {
private String Category;
private String ActionTaken;
private String Comments;
private String SubCategory;
private Timestamp DateOfAction;
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public String getActionTaken() {
	return ActionTaken;
}
public void setActionTaken(String actionTaken) {
	ActionTaken = actionTaken;
}
public String getComments() {
	return Comments;
}
public void setComments(String comments) {
	Comments = comments;
}
public String getSubCategory() {
	return SubCategory;
}
public void setSubCategory(String subCategory) {
	SubCategory = subCategory;
}
public Timestamp getDateOfAction() {
	return DateOfAction;
}
public void setDateOfAction(Timestamp dateOfAction) {
	DateOfAction = dateOfAction;
}

}
