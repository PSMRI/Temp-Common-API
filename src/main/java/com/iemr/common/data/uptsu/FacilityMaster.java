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
package com.iemr.common.data.uptsu;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_blockSubcenterMapping")
public class FacilityMaster {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "Id", insertable = false)
	private Integer id;
	
	@Expose
	@Column(name = "Employee_Code")
	private String employeeCode;
	
	@Expose
	@Column(name = "Employee_Name")
	private String employeeName;
	
	@Expose
	@Column(name = "Survey_facility_code")
	private String surveyFacilityCode;
	
	@Expose
	@Column(name = "Office_type")
	private String officeType;
	
	@Expose
	@Column(name = "Office_Category")
	private String officeCategory;
	
	@Expose
	@Column(name = "Posting_Office")
	private String postingOffice;
	
	@Expose
	@Column(name = "Post_District")
	private String postDistrict;
	
	@Expose
	@Column(name = "Designationid")
	private Integer designationId;
	
	@Expose
	@Column(name = "Designation")
	private String designation;
	
	@Expose
	@Column(name = "Des_Category")
	private String desCategory;
	
	@Expose
	@Column(name = "Des_SubCategory")
	private String desSubCategory;
	
	@Expose
	@Column(name = "Employee_Type")
	private String employeeType;
	
	@Expose
	@Column(name = "Cadre")
	private String cadre;
	
	@Expose
	@Column(name = "ActiveStatus")
	private String activeStatus;
	
	@Expose
	@Column(name = "Present_MobileNo")
	private String presentMobileNo;
	
	
	@Expose
	@Column(name = "DivisionName")
	private String divisionName;
	
	@Expose
	@Column(name = "DivisionCode")
	private Integer divisionCode;
	
	@Expose
	@Column(name = "DistrictName")
	private String districtName;
	
	@Expose
	@Column(name = "D_LGD")
	private Integer dLGD;
	
	@Expose
	@Column(name = "TehsilName")
	private String tehsilName;
	
	@Expose
	@Column(name = "T_LGD")
	private Integer tLGD;
	
	@Expose
	@Column(name = "BlockName")
	private String blockName;
	
	@Expose
	@Column(name = "B_LGD")
	private Integer bLGD;
	
	@Expose
	@Column(name = "GramPanchayatName")
	private String gramPanchayatName;
	
	@Expose
	@Column(name = "G_LGD")
	private Integer gLGD;
	
	@Expose
	@Column(name = "VillageName")
	private String villageName;
	
	@Expose
	@Column(name = "VillageCode")
	private Integer villageCode;
	
	@Expose
	@Column(name = "FacilityName")
	private String facilityName;
	
	@Expose
	@Column(name = "FacilityCode")
	private String facilityCode;
	
	@Expose
	@Column(name = "FacilityType")
	private String facilityType;
	
	@Expose
	@Column(name = "FC_Status")
	private String fcStatus;
	
	@Expose
	@Column(name = "FacilityClassification")
	private String facilityClassification;
	
	@Expose
	@Column(name = "FacilityCategory")
	private String facilityCategory;
	
	@Expose
	@Column(name = "Longitude")
	private String longitude;
	
	@Expose
	@Column(name = "Latitude")
	private String latitude;
	
	@Expose
	@Column(name = "HIMSCode")
	private Integer himsCode;
	
	@Expose
	@Column(name = "HWCStatus")
	private String hwcStatus;
	
	@Expose
	@Column(name = "FRUStatus")
	private String fruStatus;
	
	@Expose
	@Column(name = "HFRID")
	private String hfrId;
	
	@Expose
	@Column(name = "HPR_Code")
	private String hprCode;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name = "Processed", insertable = false)
	private String processed;
	
	@Expose
	@Column(name = "createdBy", updatable = false)
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Expose
	@Column(name = "ModifiedBy", insertable = false, updatable = true)
	private String modifiedBy;
	
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	
	
	
	

}
