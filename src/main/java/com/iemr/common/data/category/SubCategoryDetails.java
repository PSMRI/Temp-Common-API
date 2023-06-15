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
package com.iemr.common.data.category;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.data.beneficiary.BeneficiaryRegistrationData;
import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_SubCategory")
@Data
public class SubCategoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "SubCategoryID")
	private Integer subCategoryID;

	@Expose
	@Column(name = "CategoryID")
	private Integer categoryID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private CategoryDetails categoryDetails;

	@Expose
	@Column(name = "SubCategoryName")
	private String subCategoryName;

	@Expose
	@Column(name = "SubCatFilePath")
	private String subCatFilePath;

	@Expose
	@Column(name = "SubCategoryDesc")
	private String subCategoryDesc;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
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

	// private Set<SubCategoryDetails> subCategories;
	@Transient
	@Expose
	private ArrayList<KMFileManager> fileManger;

	@Transient
	private Integer providerServiceMapID;
	
	@Transient
	@Expose
	private String fileURL;
	
	@Transient
	@Expose
	private String fileNameWithExtension;


	/**
	 * default constructor
	 */
	public SubCategoryDetails() {
	}

	/**
	 * Cosntructor with parameters
	 * 
	 * @param SubCategoryID
	 * @param SubCategoryName
	 */
	public SubCategoryDetails(Integer SubCategoryID, String SubCategoryName, String SubCatFilePath, String fileURL, String fileNameWithExtension) {

		this.subCategoryID = SubCategoryID;
		this.subCategoryName = SubCategoryName;
		this.subCatFilePath = SubCatFilePath;
		this.fileURL=fileURL;
		this.fileNameWithExtension=fileNameWithExtension;
	}

	public SubCategoryDetails(Integer SubCategoryID, String SubCategoryName) {

		this.subCategoryID = SubCategoryID;
		this.subCategoryName = SubCategoryName;
	}

	public SubCategoryDetails(Integer SubCategoryID, String SubCategoryName, String SubCatFilePath,
			CategoryDetails category) throws IEMRException {
		this.subCategoryID = SubCategoryID;
		this.subCategoryName = SubCategoryName;
		this.subCatFilePath = SubCatFilePath;
		this.categoryDetails = InputMapper.gson().fromJson(category.toString(), CategoryDetails.class);
		this.categoryID = categoryDetails.getCategoryID();
	}

	public SubCategoryDetails(String SubCategoryDesc, String SubCategoryName, String SubCatFilePath) {

		this.subCategoryDesc = SubCategoryDesc;
		this.subCategoryName = SubCategoryName;
		this.subCatFilePath = SubCatFilePath;
	}

	/**
	 * @return the subCategoryID
	 */
	public Integer getSubCategoryID() {
		return subCategoryID;
	}

	/**
	 * @param subCategoryID
	 *            the subCategoryID to set
	 */
	public void setSubCategoryID(Integer subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	/**
	 * @return the categoryID
	 */
	public Integer getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID
	 *            the categoryID to set
	 */
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName
	 *            the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	/**
	 * @return the subCategoryDesc
	 */
	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}

	/**
	 * @param subCategoryDesc
	 *            the subCategoryDesc to set
	 */
	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Timestamp getLastModDate() {
		return lastModDate;
	}

	/**
	 * @param lastModDate
	 *            the lastModDate to set
	 */
	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getSubCatFilePath() {
		return subCatFilePath;
	}

	public void setSubCatFilePath(String subCatFilePath) {
		this.subCatFilePath = subCatFilePath;
	}

	public void setFileManger(ArrayList<KMFileManager> fileManger) {
		this.fileManger = fileManger;
	}

	public ArrayList<KMFileManager> getFileManger() {
		return fileManger;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
