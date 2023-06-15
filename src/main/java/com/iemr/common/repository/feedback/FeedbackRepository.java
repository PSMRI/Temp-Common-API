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
package com.iemr.common.repository.feedback;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.data.feedback.FeedbackDetails;

@Repository
@RestResource(exported = false)
public interface FeedbackRepository extends CrudRepository<FeedbackDetails, Long> {

	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
			+ "from FeedbackDetails where beneficiaryRegID = :id order by feedbackID desc")
	public ArrayList<Objects[]> findByBeneficiaryID(@Param("id") Long id);

	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, serviceAvailDate, "
			+ "feedbackAgainst from FeedbackDetails where feedbackID = :id order by feedbackID desc")
	public ArrayList<Objects[]> findByFeedbackID(@Param("id") Long id);

	@Query("SELECT tf.feedbackID, tf.institutionID, tf.designationID, tf.severityID, "
			+ "tf.feedbackStatusID, tf.feedback, tf.serviceID, tf.userID, tf.sMSPhoneNo, "
			+ "tf.serviceAvailDate, tf.createdBy, tf.createdDate, tf.modifiedBy, "
			+ "tf.lastModDate, tf.emailStatusID, "
			+ "ct.feedbackTypeName as FeedbackTypeName, mi.institutionName as InstitutionName, "
			+ "md.designationName as DesignationName, si.severityTypeName as SeverityTypeName, "
			+ "ms.feedbackStatus as FeedbackStatus, '', "
			+ "concat(coalesce(mu.firstName,''), ' ',coalesce(mu.middleName,''), ' ', coalesce(mu.lastName,'')) as UserName, "
			+ "ems.emailStatus as EmailStatus, tf.feedbackAgainst, it, tf.instituteTypeID "
			+ "FROM FeedbackDetails tf left JOIN tf.feedbackType ct left JOIN tf.institute mi "
			+ "left JOIN tf.designation md left JOIN tf.severity si left JOIN tf.feedbackStatus ms "
			+ "left JOIN tf.mservicemaster sm left JOIN tf.mUser mu left join tf.instituteType it "
			+ "left JOIN tf.emailStatus ems where tf.serviceID = :serviceID ORDER by tf.feedbackID desc")
	ArrayList<Object[]> getAllData(@Param("serviceID") Integer serviceID);

	@Query("SELECT tf.feedbackID, tf.institutionID, tf.designationID, tf.severityID, tf.feedbackStatusID, "
			+ "tf.feedback, tf.serviceID, tf.userID, tf.sMSPhoneNo, tf.serviceAvailDate, tf.createdBy, "
			+ "tf.createdDate, tf.modifiedBy, tf.lastModDate, tf.emailStatusID, "
			+ "ct.feedbackTypeName as feedbackTypeName, tf.feedbackAgainst, tf.instituteType, tf.instituteTypeID "
			+ "FROM FeedbackDetails tf  left JOIN tf.feedbackType ct "
			+ " WHERE tf.createdDate>:date1 and tf.serviceID = :serviceID and tf.beneficiaryRegID is not null "
			+ "order by tf.feedbackID desc")
	ArrayList<Object[]> findByDatesBetween(@Param("date1") Timestamp date1, @Param("serviceID") Integer serviceID);

	@Query("SELECT tf.feedbackID, tf.institutionID, tf.designationID, tf.severityID, tf.feedbackStatusID, "
			+ "tf.feedback, tf.serviceID, tf.userID, tf.sMSPhoneNo, tf.serviceAvailDate, tf.createdBy, "
			+ "tf.createdDate, tf.modifiedBy, tf.lastModDate, tf.emailStatusID, "
			+ " ct.feedbackTypeName as FeedbackTypeName, mi.institutionName as InstitutionName, "
			+ " md.designationName as DesignationName, si.severityTypeName as SeverityTypeName, "
			+ " ms.feedbackStatus as FeedbackStatus, '', "
			+ " concat(coalesce(mu.firstName, ''), ' ',coalesce(mu.middleName,''), ' ', coalesce(mu.lastName,'')) as UserName, "
			+ " ems.emailStatus as EmailStatus, tf.feedbackAgainst, it, tf.instituteTypeID  "
			+ "FROM FeedbackDetails tf left JOIN tf.feedbackType ct left JOIN tf.institute mi "
			+ "left JOIN tf.designation md left JOIN tf.severity si left JOIN tf.feedbackStatus ms "
			+ "left JOIN tf.mservicemaster sm left JOIN tf.mUser mu left JOIN tf.emailStatus ems "
			+ "left join tf.instituteType it "
			+ "WHERE tf.createdDate>:startDate and tf.createdDate<:endDate and tf.serviceID = :serviceID "
			+ "and tf.beneficiaryRegID is not null order by tf.feedbackID desc")

	ArrayList<Object[]> getDateBetween(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("serviceID") Integer serviceID);

	@Query("SELECT tf.feedbackID, tf.institutionID, tf.designationID, tf.severityID, tf.feedbackStatusID, "
			+ " tf.feedback, tf.serviceID, tf.userID, tf.sMSPhoneNo, tf.serviceAvailDate, "
			+ " tf.createdBy, tf.createdDate, tf.modifiedBy, tf.lastModDate, tf.emailStatusID, "
			+ " ct.feedbackTypeName as FeedbackTypeName, mi.institutionName as InstitutionName,"
			+ " md.designationName as DesignationName, si.severityTypeName as SeverityTypeName,"
			+ " ms.feedbackStatus as FeedbackStatus, '',"
			+ " concat(coalesce(mu.firstName,''), ' ',coalesce(mu.middleName,''), ' ', "
			+ " coalesce(mu.lastName,'')) as UserName, ems.emailStatus as EmailStatus, tf.feedbackAgainst, "
			+ "it, tf.instituteTypeID "
			+ " FROM FeedbackDetails tf left JOIN tf.feedbackType ct left JOIN tf.institute mi "
			+ "left JOIN tf.designation md left JOIN tf.severity si left JOIN tf.feedbackStatus ms "
			+ "left JOIN tf.mservicemaster sm left JOIN tf.mUser mu left JOIN tf.emailStatus ems "
			+ "left join tf.instituteType it WHERE tf.feedbackID =:feedbackId ")
	ArrayList<Object[]> getFeedbackByID(@Param("feedbackId") Long feedbackId);

	@Transactional
	@Modifying
	@Query("update FeedbackDetails " + "set feedbackStatusID = :feedbackStatusID, " + "emailStatusID = :emailStatusID "
			+ "where feedbackID=:feedbackID")
	Integer updateStatusByID(@Param("feedbackID") Long feedbackID, @Param("feedbackStatusID") Integer feedbackStatusID,
			@Param("emailStatusID") Integer emailStatusID);

	@Transactional
	@Modifying
	@Query("UPDATE FeedbackDetails SET feedbackStatusID = :feedbackStatusID, emailStatusID = :emailStatusID, "
			+ " feedbackTypeID = :feedbackTypeID, instiName = :instituteName, instituteTypeID = :instTypeID, "
			+ " designationID = :designationID, severityID = :severityID, feedbackAgainst = :feedbackAgainst, "
			+ " feedbackNatureID = :feedbackNatureID, feedback = :feedback  where feedbackID=:feedbackID")
	Integer updateStatusByIDNew(@Param("feedbackID") Long feedbackID,
			@Param("feedbackStatusID") Integer feedbackStatusID, @Param("emailStatusID") Integer emailStatusID,
			@Param("feedbackTypeID") Integer feedbackTypeID, @Param("instituteName") String instituteName,
			@Param("instTypeID") Integer instTypeID, @Param("designationID") Integer designationID,
			@Param("severityID") Integer severityID, @Param("feedbackAgainst") String feedbackAgainst,
			@Param("feedbackNatureID") Integer feedbackNatureID, @Param("feedback") String feedback);

	@Transactional
	@Modifying
	@Query("update FeedbackDetails " + "set feedbackStatusID = :feedbackStatusID " + "where feedbackID=:feedbackID")
	Integer updateFeedbackStatusByID(@Param("feedbackID") Long feedbackID,
			@Param("feedbackStatusID") Integer feedbackStatusID);

	@Transactional
	@Modifying
	@Query("update FeedbackDetails " + "set emailStatusID = :emailStatusID " + "where feedbackID=:feedbackID")
	Integer updateEmailStatusByID(@Param("feedbackID") Long feedbackID, @Param("emailStatusID") Integer emailStatusID);

	// @Query("SELECT feedback.feedbackID, feedback.mUser, feedback.institutionID,
	// feedback.institute, "
	// + "feedback.designationID, feedback.designation, feedback.severityID,
	// feedback.severity, "
	// + "feedback.feedbackStatusID, feedback.feedbackStatus, feedback.serviceID,
	// feedback.mservicemaster, "
	// + "feedback.userID, feedback.emailStatusID, feedback.emailStatus,
	// feedback.sMSPhoneNo, "
	// + "feedback.serviceAvailDate, feedback.createdBy, feedback.createdDate,
	// feedback.modifiedBy, "
	// + "feedback.lastModDate, feedback.feedback, feedback.deleted,
	// feedback.feedbackTypeID, feedback.feedbackType, "
	// + "feedback.stateID, feedback.state, feedback.districtID, feedback.district,
	// "
	// + "feedback.blockID, feedback.districtBlock, feedback.districtBranchID,
	// feedback.districtBranchMapping, "
	// + "feedback.instituteTypeID, feedback.instituteType,
	// feedback.feedbackNatureID, feedback.feedbackNatureDetail "
	// + "FROM FeedbackDetails feedback left JOIN feedback.institute "
	// + "left JOIN feedback.designation left JOIN feedback.severity left JOIN
	// feedback.feedbackStatus "
	// + "left JOIN feedback.feedbackType left JOIN feedback.mservicemaster left
	// JOIN feedback.mUser "
	// + "left JOIN feedback.emailStatus left JOIN feedback.state left JOIN
	// feedback.district "
	// + "left JOIN feedback.districtBlock left JOIN feedback.districtBranchMapping
	// left JOIN feedback.instituteType "
	// + "left JOIN feedback.feedbackNatureDetail " + "where feedback.serviceID =
	// :serviceID and feedback.deleted=false
	// "
	// + "and feedback.createdDate >= :startDate and feedback.createdDate <=
	// :endDate "
	// + "ORDER by feedback.feedbackID desc")
	// List<Objects[]> getFeedbacksList(
	// @Param("serviceID") Integer serviceID, @Param("startDate") Timestamp
	// startDate,
	// @Param("endDate") Timestamp endDate);

	@Query("SELECT feedback FROM FeedbackDetails feedback "
			+ "where feedback.serviceID = :serviceID and feedback.deleted=false "
			+ "and Date(feedback.createdDate) >= Date(:startDate) and Date(feedback.createdDate) <= Date(:endDate) "
			+ "and feedback.beneficiaryRegID is not null " + "ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getFeedbacksList(@Param("serviceID") Integer serviceID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	// @Query("SELECT feedback.feedbackID, feedback.mUser, feedback.institutionID,
	// feedback.institute, "
	// + "feedback.designationID, feedback.designation, feedback.severityID,
	// feedback.severity, "
	// + "feedback.feedbackStatusID, feedback.feedbackStatus, feedback.serviceID,
	// feedback.mservicemaster, "
	// + "feedback.userID, feedback.emailStatusID, feedback.emailStatus,
	// feedback.sMSPhoneNo, "
	// + "feedback.serviceAvailDate, feedback.createdBy, feedback.createdDate,
	// feedback.modifiedBy, "
	// + "feedback.lastModDate, feedback.feedback, feedback.deleted,
	// feedback.feedbackTypeID, feedback.feedbackType, "
	// + "feedback.stateID, feedback.state, feedback.districtID, feedback.district,
	// "
	// + "feedback.blockID, feedback.districtBlock, feedback.districtBranchID,
	// feedback.districtBranchMapping, "
	// + "feedback.instituteTypeID, feedback.instituteType,
	// feedback.feedbackNatureID, feedback.feedbackNatureDetail "
	// + "FROM FeedbackDetails feedback left JOIN feedback.institute "
	// + "left JOIN feedback.designation left JOIN feedback.severity left JOIN
	// feedback.feedbackStatus "
	// + "left JOIN feedback.feedbackType left JOIN feedback.mservicemaster left
	// JOIN feedback.mUser "
	// + "left JOIN feedback.emailStatus left JOIN feedback.state left JOIN
	// feedback.district "
	// + "left JOIN feedback.districtBlock left JOIN feedback.districtBranchMapping
	// left JOIN feedback.instituteType "
	// + "left JOIN feedback.feedbackNatureDetail " + "where feedback.serviceID =
	// :serviceID and "
	// + "feedback.beneficiaryRegID = :beneficiaryRegID and feedback.deleted=false "
	// + "ORDER by feedback.feedbackID desc")
	// List<Objects[]> getFeedbacksListForBeneficiary(@Param("serviceID") Integer
	// serviceID,
	// @Param("beneficiaryRegID") Long beneficiaryRegID);

	@Query("SELECT feedback FROM FeedbackDetails feedback "
			+ "where feedback.serviceID = :serviceID and feedback.beneficiaryRegID = :beneficiaryRegID and "
			+ "feedback.deleted=false and feedback.beneficiaryRegID is not null ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getFeedbacksListForBeneficiary(@Param("serviceID") Integer serviceID,
			@Param("beneficiaryRegID") Long beneficiaryRegID);

	// @Query("SELECT feedback.feedbackID, feedback.mUser, feedback.institutionID,
	// feedback.institute, "
	// + "feedback.designationID, feedback.designation, feedback.severityID,
	// feedback.severity, "
	// + "feedback.feedbackStatusID, feedback.feedbackStatus, feedback.serviceID,
	// feedback.mservicemaster, "
	// + "feedback.userID, feedback.emailStatusID, feedback.emailStatus,
	// feedback.sMSPhoneNo, "
	// + "feedback.serviceAvailDate, feedback.createdBy, feedback.createdDate,
	// feedback.modifiedBy, "
	// + "feedback.lastModDate, feedback.feedback, feedback.deleted,
	// feedback.feedbackTypeID, feedback.feedbackType, "
	// + "feedback.stateID, feedback.state, feedback.districtID, feedback.district,
	// "
	// + "feedback.blockID, feedback.districtBlock, feedback.districtBranchID,
	// feedback.districtBranchMapping, "
	// + "feedback.instituteTypeID, feedback.instituteType,
	// feedback.feedbackNatureID, feedback.feedbackNatureDetail "
	// + "FROM FeedbackDetails feedback left JOIN feedback.institute "
	// + "left JOIN feedback.designation left JOIN feedback.severity left JOIN
	// feedback.feedbackStatus "
	// + "left JOIN feedback.feedbackType left JOIN feedback.mservicemaster left
	// JOIN feedback.mUser "
	// + "left JOIN feedback.emailStatus left JOIN feedback.state left JOIN
	// feedback.district "
	// + "left JOIN feedback.districtBlock left JOIN feedback.districtBranchMapping
	// left JOIN feedback.instituteType "
	// + "left JOIN feedback.feedbackNatureDetail " + "where feedback.serviceID =
	// :serviceID and "
	// + "feedback.feedbackID = :feedbackID and feedback.deleted=false " + "ORDER by
	// feedback.feedbackID desc")
	// List<Objects[]> getFeedbacksList(@Param("serviceID") Integer serviceID,
	// @Param("feedbackID") Long feedbackID);

	@Query("SELECT feedback FROM FeedbackDetails feedback " + "where feedback.requestID = :requestID and "
			+ "feedback.deleted = false and feedback.beneficiaryRegID is not null ")
	List<FeedbackDetails> getFeedbacksList(@Param("requestID") String requestID);

	@Query("SELECT f FROM FeedbackDetails f WHERE feedbackID = :feedbackID AND deleted=false ")
	public ArrayList<FeedbackDetails> findByFeedbackIDNew(@Param("feedbackID") Long feedbackID);

	@Query(value = "SELECT im.BenRegId FROM "
			+ " db_identity.i_beneficiarycontacts ic INNER JOIN db_identity.i_beneficiarymapping im "
			+ " ON ic.VanSerialNo = im.BenContactsId AND ic.VanID = im.VanID "
			+ " WHERE ic.PreferredPhoneNum = :phoneNum", nativeQuery = true)
	public ArrayList<BigInteger> findByPhoneNum(@Param("phoneNum") String phoneNum);
	
	@Query(value = "SELECT im.BenRegId FROM "
			+ " db_1097_identity.i_beneficiarycontacts ic INNER JOIN db_1097_identity.i_beneficiarymapping im "
			+ " ON ic.VanSerialNo = im.BenContactsId AND ic.VanID = im.VanID "
			+ " WHERE ic.PreferredPhoneNum = :phoneNum", nativeQuery = true)
	public ArrayList<BigInteger> findByPhoneNumFor1097(@Param("phoneNum") String phoneNum);

	@Query("SELECT f FROM FeedbackDetails f WHERE beneficiaryRegID IN :ids AND deleted=false ")
	public ArrayList<FeedbackDetails> findByBenRegIDs(@Param("ids") List<Long> ids);

	@Query("SELECT feedback FROM FeedbackDetails feedback "
			+ "where feedback.serviceID = :serviceID and feedback.feedbackID = :feedbackID and "
			+ "feedback.deleted = false and feedback.beneficiaryRegID is not null "
			+ "ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getFeedbacksList(@Param("serviceID") Integer serviceID, @Param("feedbackID") Long feedbackID);

	@Query("SELECT feedback FROM FeedbackDetails feedback "
			+ "where feedback.serviceID = :serviceID and feedback.deleted=false "
			+ "and feedback.createdDate >= :startDate and feedback.createdDate <= :endDate "
			+ "and feedback.feedbackTypeID = :feedbackTypeID  and feedback.beneficiaryRegID is not null "
			+ "ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getFeedbacksListByType(@Param("serviceID") Integer serviceID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("feedbackTypeID") Integer feedbackTypeID);

	@Query("SELECT feedback FROM FeedbackDetails feedback " + "where feedback.feedbackID = :feedbackID and "
			+ "feedback.deleted = false and feedback.beneficiaryRegID is not null ")
	FeedbackDetails getFeedback(@Param("feedbackID") Long feedbackID);

	@Query("SELECT feedback FROM FeedbackDetails feedback " + "where feedback.benCallID = :benCallID and "
			+ "feedback.deleted=false and feedback.benCallID is not null ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getFeedbacksListForCallDetailID(@Param("benCallID") Long benCallID);

	@Query("SELECT feedback FROM FeedbackDetails feedback "
			+ "where feedback.serviceID = :serviceID and feedback.deleted=false "
			+ "and Date(feedback.lastModDate) >= Date(:startDate) and Date(feedback.lastModDate) <= Date(:endDate) "
			+ "and feedback.beneficiaryRegID is not null and feedback.createdDate != feedback.lastModDate "
			+ "ORDER by feedback.feedbackID desc")
	List<FeedbackDetails> getGrievancesByUpdatedDate(@Param("serviceID") Integer serviceID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	@Query("select feedback from FeedbackDetails feedback " + "where feedback.feedbackID = :feedbackID ")
	public FeedbackDetails getFeedbackDetail(@Param("feedbackID") Long feedbackID);

	@Transactional
	@Modifying
	@Query("update FeedbackDetails set feedbackStatusID = :feedbackStatusID, emailStatusID = :emailStatusID, feedback = :feedback "
			+ "where feedbackID = :feedbackID")
	Integer updateFeedbackDetail(@Param("feedbackID") Long feedbackID,
			@Param("feedbackStatusID") Integer feedbackStatusID, @Param("emailStatusID") Integer emailStatusID,
			@Param("feedback") String feedback);

}
