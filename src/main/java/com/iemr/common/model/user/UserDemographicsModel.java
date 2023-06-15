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
package com.iemr.common.model.user;

import com.iemr.common.model.userbeneficiary.CityModel;
import com.iemr.common.model.userbeneficiary.CommunityModel;
import com.iemr.common.model.userbeneficiary.CountryModel;
import com.iemr.common.model.userbeneficiary.ReligionModel;
import com.iemr.common.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class UserDemographicsModel
{
	private Integer demographicID;
	private Integer userID;
	private UserModel user;
	private String fathersName;
	private String mothersName;
	private Integer communityID;
	private CommunityModel community;
	private Integer religionID;
	private ReligionModel m_religion;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;
	private Integer CityID;
	private CityModel m_city;
	private Integer StateID;
	private StateModel m_state;
	private Integer CountryID;
	private CountryModel m_country;
	private String PinCode;
	private Boolean IsPresent;
	private Boolean IsPermanent;
	private Boolean Deleted;
	
	// private String CreatedBy;
	// private Timestamp CreatedDate;
	// private String ModifiedBy;
	// private Timestamp LastModDate;
}
