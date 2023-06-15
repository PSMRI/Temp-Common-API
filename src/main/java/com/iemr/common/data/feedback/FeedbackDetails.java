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
package com.iemr.common.data.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.institute.Institute;
import com.iemr.common.data.institute.InstituteType;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.data.users.EmailStatus;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_feedback")
@Data
public class FeedbackDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;

	@Column(name = "requestID")
	@Expose
	private String requestID;

	@OneToMany(mappedBy = "feedbackDetails")
	@Transient
	@Expose
	private List<FeedbackRequest> feedbackRequests;

	@OneToMany(mappedBy = "feedbackDetails")
	@Transient
	@Expose
	private List<FeedbackResponse> feedbackResponses;

	@Transient
	@Expose
	private List<FeedbackRequest> consolidatedRequests;

	@Column(name = "InstitutionID")
	@Expose
	private Long institutionID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstitutionID", insertable = false, updatable = false)
	@Expose
	private Institute institute;
	
	@Column(name = "institutionname")
	@Expose
	private String instiName;

	@Transient
	@Expose
	private String instituteName = "";

	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	private Designation designation;
	@Transient
	@Expose
	private String designationName = "";

	@Column(name = "SeverityID")
	@Expose
	private Integer severityID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SeverityID", insertable = false, updatable = false)
	@Expose
	private FeedbackSeverity severity;
	@Transient
	@Expose
	private String severityTypeName = "";

	@Column(name = "FeedbackTypeID")
	@Expose
	private Integer feedbackTypeID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackTypeID", insertable = false, updatable = false)
	@Expose
	private FeedbackType feedbackType;
	@Transient
	@Expose
	private String feedbackTypeName = "";

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Transient
	@Expose
	private Beneficiary beneficiary;

	@Transient
	@Expose
	private String beneficiaryName;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer serviceID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProviderServiceMapID", insertable = false, updatable = false)
	@Expose
	private ProviderServiceMapping mservicemaster;
	@Transient
	@Expose
	private String serviceName = "";

	@Column(name = "UserID")
	@Expose
	private Integer userID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", insertable = false, updatable = false)
	@Expose
	private User mUser;
	@Transient
	@Expose
	private String userName;

	@Column(name = "SMSPhoneNo")
	@Expose
	private String sMSPhoneNo;
	@Column(name = "ServiceAvailDate")
	@Expose
	private Timestamp serviceAvailDate;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	@Expose
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;

	@Column(name = "FeedbackStatusID")
	@Expose
	private Integer feedbackStatusID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackStatusID", insertable = false, updatable = false)
	@Expose
	private FeedbackStatus feedbackStatus;
	@Transient
	@Expose
	private String feedbackStatusName;

	@Column(name = "Feedback")
	@Expose
	private String feedback;

	@Column(name = "EmailStatusID")
	@Expose
	private Integer emailStatusID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmailStatusID", insertable = false, updatable = false)
	@Expose
	private EmailStatus emailStatus;
	@Transient
	@Expose
	private String emailStatusName;

	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;

	@Transient
	@Expose
	private Integer subServiceID;

	@Transient
	@Expose
	private Timestamp startDate = new Timestamp(0);

	@Transient
	@Expose
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());

	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StateID", insertable = false, updatable = false)
	@Expose
	private States state;

	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DistrictID", insertable = false, updatable = false)
	@Expose
	private Districts district;

	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BlockID", insertable = false, updatable = false)
	@Expose
	private DistrictBlock districtBlock;

	@Column(name = "DistrictBranchID")
	@Expose
	private Integer districtBranchID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DistrictBranchID", insertable = false, updatable = false)
	@Expose
	private DistrictBranchMapping districtBranchMapping;

	@Column(name = "InstitutionTypeID")
	@Expose
	private Integer instituteTypeID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "InstitutionTypeID", insertable = false, updatable = false)
	@Expose
	private InstituteType instituteType;

	/**
	 * join to get feedback nature
	 */
	@Expose
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FeedbackNatureID", insertable = false, updatable = false)
	@Expose
	private FeedbackNatureDetail feedbackNatureDetail;

	@Expose
	@Column(name = "CategoryID")
	private Integer categoryID;

	@Expose
	@Column(name = "SubCategoryID")
	private Integer subCategoryID;

	@Column(name = "FeedbackAgainst")
	@Expose
	private String feedbackAgainst;

	public FeedbackDetails() {

	}

	public FeedbackDetails(Long feedbackID, Long institutionID,String instiName, Integer designationID, Integer severityID,
			Integer feedbackTypeID, Integer feedbackStatusID, String feedback, Long beneficiaryRegID, Integer serviceID,
			Integer userID, String sMSPhoneNo, Timestamp serviceAvailDate, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, String feedbackAgainst) {
		super();
		this.feedbackID = feedbackID;
		this.institutionID = institutionID;
		this.instiName = instiName;
		this.designationID = designationID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.beneficiaryRegID = beneficiaryRegID;
		this.serviceID = serviceID;
		this.userID = userID;
		this.sMSPhoneNo = sMSPhoneNo;
		this.serviceAvailDate = serviceAvailDate;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.feedbackAgainst = feedbackAgainst;
	}

	public FeedbackDetails(Long feedbackID, Integer severityID, Integer feedbackTypeID, Integer feedbackStatusID,
			String feedback, String createdBy, String feedbackAgainst) {
		this.feedbackID = feedbackID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.createdBy = createdBy;
		this.feedbackAgainst = feedbackAgainst;
	}

	public FeedbackDetails(Long feedbackID, Integer severityID, Integer feedbackTypeID, Integer feedbackStatusID,
			String feedback, String createdBy, Timestamp serviceAvailDate, String feedbackAgainst) {
		this.feedbackID = feedbackID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.createdBy = createdBy;
		this.serviceAvailDate = serviceAvailDate;
		this.feedbackAgainst = feedbackAgainst;
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public Long getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(Long institutionID) {
		this.institutionID = institutionID;
	}
	
	public String getInstiName() {
		return instiName;
	}

	public void setInstiName(String instiName) {
		this.instiName = instiName;
	}


	public Integer getDesignationID() {
		return designationID;
	}

	public void setDesignationID(Integer designationID) {
		this.designationID = designationID;
	}

	public Integer getSeverityID() {
		return severityID;
	}

	public void setSeverityID(Integer severityID) {
		this.severityID = severityID;
	}

	public Integer getFeedbackTypeID() {
		return feedbackTypeID;
	}

	public void setFeedbackTypeID(Integer feedbackTypeID) {
		this.feedbackTypeID = feedbackTypeID;
	}

	public Integer getFeedbackStatusID() {
		return feedbackStatusID;
	}

	public void setFeedbackStatusID(Integer feedbackStatusID) {
		this.feedbackStatusID = feedbackStatusID;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getsMSPhoneNo() {
		return sMSPhoneNo;
	}

	public void setsMSPhoneNo(String sMSPhoneNo) {
		this.sMSPhoneNo = sMSPhoneNo;
	}

	public Timestamp getServiceAvailDate() {
		return serviceAvailDate;
	}

	public void setServiceAvailDate(Timestamp serviceAvailDate) {
		this.serviceAvailDate = serviceAvailDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public Integer getSubServiceID() {
		return subServiceID;
	}

	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "feedback")
	// private List<FeedbackRequest> feedbackRequestDetails;

	// /**
	// * @return the feedbackRquestDetails
	// */
	// public List<FeedbackRequest> getFeedbackRequestDetails() {
	// return feedbackRequestDetails;
	// }
	//
	// /**
	// * @param feedbackRquestDetails
	// * the feedbackRquestDetails to set
	// */
	// public void setFeedbackRequestDetails(List<FeedbackRequest>
	// feedbackRequestDetails) {
	// this.feedbackRequestDetails = feedbackRequestDetails;
	// }

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

	public Integer getEmailStatusID() {
		return emailStatusID;
	}

	public void setEmailStatusID(Integer emailStatusID) {
		this.emailStatusID = emailStatusID;
	}

	public static FeedbackDetails initializeFeedbackDetailsWithAllFeilds(Long feedbackID, User mUser,
			Long institutionID,String instiName, Institute institute, Integer designationID, Designation designation, Integer severityID,
			FeedbackSeverity severity, Integer feedbackStatusID, FeedbackStatus feedbackStatus, Integer serviceID,
			ProviderServiceMapping mservicemaster, Integer userID, Integer emailStatusID, EmailStatus emailStatus,
			String sMSPhoneNo, Timestamp serviceAvailDate, String createdBy, Timestamp createdDate, String modifiedBy,
			Timestamp lastModDate, String feedback, Boolean deleted, Integer feedbackTypeID, FeedbackType feedbackType,
			Integer stateID, States state, Integer districtID, Districts district, Integer blockID,
			DistrictBlock districtBlock, Integer districtBranchID, DistrictBranchMapping districtBranchMapping,
			Integer instituteTypeID, InstituteType instituteType, Integer feedbackNatureID,
			FeedbackNatureDetail feedbackNatureDetail, String feedbackAgainst) {
		FeedbackDetails feedbackDetails = new FeedbackDetails();
		feedbackDetails.feedbackID = feedbackID;
		feedbackDetails.mUser = mUser;
		feedbackDetails.userName = (mUser != null
				? (((mUser.getFirstName() == null) ? "" : mUser.getFirstName()) + " "
						+ ((mUser.getMiddleName() == null) ? "" : mUser.getMiddleName()) + " "
						+ ((mUser.getLastName() == null) ? "" : mUser.getLastName()))
				: "").trim();
		feedbackDetails.institutionID = institutionID;
		feedbackDetails.instiName = instiName;
		feedbackDetails.institute = institute;
		feedbackDetails.instituteName = (institute != null
				? ((institute.getInstitutionName() != null) ? institute.getInstitutionName() : "")
				: "");
		feedbackDetails.designationID = designationID;
		feedbackDetails.designation = designation;
		feedbackDetails.designationName = (designation != null
				? ((designation.getDesignationName() != null) ? designation.getDesignationName() : "")
				: "");
		feedbackDetails.severityID = severityID;
		feedbackDetails.severity = severity;
		feedbackDetails.severityTypeName = ((severity != null && severity.getSeverityTypeName() != null)
				? severity.getSeverityTypeName()
				: "");
		feedbackDetails.feedbackStatusID = feedbackStatusID;
		feedbackDetails.feedbackStatus = feedbackStatus;
		feedbackDetails.feedbackStatusName = (feedbackStatus != null
				? ((feedbackStatus.getFeedbackStatus() != null) ? feedbackStatus.getFeedbackStatus() : "")
				: "");
		feedbackDetails.serviceID = serviceID;
		feedbackDetails.mservicemaster = mservicemaster;
		feedbackDetails.serviceName = ((mservicemaster != null && mservicemaster.getM_ServiceMaster() != null
				&& mservicemaster.getM_ServiceMaster().getServiceName() != null)
						? (mservicemaster.getM_ServiceMaster().getServiceName())
						: "");
		feedbackDetails.userID = userID;
		feedbackDetails.emailStatusID = emailStatusID;
		feedbackDetails.emailStatus = emailStatus;
		feedbackDetails.emailStatusName = (emailStatus != null
				? ((emailStatus.getEmailStatus() != null) ? emailStatus.getEmailStatus() : "")
				: "");
		feedbackDetails.feedbackTypeID = feedbackTypeID;
		feedbackDetails.feedbackType = feedbackType;
		feedbackDetails.feedbackTypeName = (feedbackType != null && (feedbackType.getFeedbackTypeName() != null))
				? feedbackType.getFeedbackTypeName()
				: "";
		feedbackDetails.sMSPhoneNo = sMSPhoneNo;
		feedbackDetails.serviceAvailDate = serviceAvailDate;
		feedbackDetails.createdBy = createdBy;
		feedbackDetails.createdDate = createdDate;
		feedbackDetails.modifiedBy = modifiedBy;
		feedbackDetails.lastModDate = lastModDate;
		// feedbackDetails.beneficiaryRegID = beneficiary.getBeneficiaryRegID();
		feedbackDetails.feedback = feedback;
		feedbackDetails.deleted = deleted;
		feedbackDetails.stateID = stateID;
		feedbackDetails.state = state;
		feedbackDetails.districtID = districtID;
		feedbackDetails.district = district;
		feedbackDetails.blockID = blockID;
		feedbackDetails.districtBlock = districtBlock;
		feedbackDetails.districtBranchID = districtBranchID;
		feedbackDetails.districtBranchMapping = districtBranchMapping;
		feedbackDetails.instituteTypeID = instituteTypeID;
		feedbackDetails.instituteType = instituteType;
		feedbackDetails.feedbackNatureID = feedbackNatureID;
		feedbackDetails.feedbackNatureDetail = feedbackNatureDetail;
		feedbackDetails.feedbackAgainst = feedbackAgainst;
		return feedbackDetails;
	}

	public void setFeedbackRequests(List<FeedbackRequest> feedbackRequests) {
		this.feedbackRequests = feedbackRequests;
	}

	public void setFeedbackResponses(List<FeedbackResponse> feedbackResponses) {
		this.feedbackResponses = feedbackResponses;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setConsolidatedRequests(List<FeedbackRequest> feedbackRequests,
			List<FeedbackResponse> feedbackResponses) {
		List<FeedbackRequest> consolidatedRequests = new ArrayList<FeedbackRequest>();
		for (FeedbackRequest feedbackRequest : feedbackRequests) {
			for (FeedbackResponse feedbackResponse : feedbackResponses) {
				if (feedbackResponse.getFeedbackRequestID().equals(feedbackRequest.getFeedbackRequestID())
						&& (feedbackRequest.getResponseUpdatedBy() == null)) {
					feedbackRequest.updateResponses(feedbackResponse.getResponseSummary(),
							feedbackResponse.getComments(), feedbackResponse.getCreatedDate(),
							feedbackResponse.getCreatedBy(), feedbackResponse.getKmFileManager(),
							feedbackResponse.getAttachmentPath());
				}
			}
			consolidatedRequests.add(feedbackRequest);
		}
		this.consolidatedRequests = consolidatedRequests;
	}

	/* RANDOM CHANGE TO SIMULATE DELTA CHANGES - JENKINS */
	// SUNIL TODO - PLEASE DELETE
	public String getRandomMessage() {
		return null;
	}

}
