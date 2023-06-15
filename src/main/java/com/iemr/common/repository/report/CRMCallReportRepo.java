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
package com.iemr.common.repository.report;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.report.CallDetailsReport;
import com.iemr.common.data.report.MedHistory;
import com.iemr.common.data.report.ReportType;
import com.iemr.common.data.report.UnBlockedPhoneReport;

@Repository
@RestResource(exported = false)
public interface CRMCallReportRepo extends CrudRepository<CallDetailsReport, Integer> {
	@Query("select r from CallDetailsReport r where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID ")
	ArrayList<CallDetailsReport> getReportsByDate(@Param("startDate") Integer startDate,
			@Param("endDate") Integer endDate, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select r from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID and ben.gender like :gender")
	ArrayList<CallDetailsReport> getReportsByGender(@Param("startDate") Integer startDate,
			@Param("endDate") Integer endDate, @Param("gender") String gender,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select r from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID and ben.dob >= :minDOB and ben.dob <= :maxDOB")
	ArrayList<CallDetailsReport> getReportsByAgeGroup(@Param("startDate") Integer startDate,
			@Param("endDate") Integer endDate, @Param("maxDOB") Timestamp startAge, @Param("minDOB") Timestamp endAge,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select r from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID "
			+ "and (ben.gender like :gender or ben.gender is null) "
			+ "and (r.callType like :beneficiaryCallType or r.callType is null) "
			+ "and (r.callSubType like :beneficiaryCallSubType or r.callSubType is null) "
			+ "and (ben.state like :state or ben.state is null) "
			+ "and (ben.district like :district or ben.district is null) "
			+ "and (ben.preferredLanguage like :beneficiaryPreferredLanguage or ben.preferredLanguage is null) "
			+ "and (ben.sexualOrientation like :beneficiarySexualOrientation or ben.sexualOrientation is null) ")
	ArrayList<CallDetailsReport> getAllReportsByDate(@Param("startDate") Timestamp timestamp,
			@Param("endDate") Timestamp timestamp2, @Param("gender") String gender, @Param("state") String state,
			@Param("district") String district, @Param("beneficiaryCallType") String beneficiaryCallType,
			@Param("beneficiaryCallSubType") String beneficiaryCallSubType,
			@Param("beneficiaryPreferredLanguage") String beneficiaryPreferredLanguage,
			@Param("beneficiarySexualOrientation") String beneficiarySexualOrientation,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select count(r) from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID "
			+ "and (ben.state like :state or ben.state is null) "
			+ "and (ben.district like :district or ben.district is null) "
			+ "and ben.dob >= :maxDOB and ben.dob <= :minDOB ")
	Long getCallCountsByAgeGroup(@Param("startDate") Timestamp timestamp, @Param("endDate") Timestamp timestamp2,
			@Param("maxDOB") Timestamp beneficiaryMinAge, @Param("minDOB") Timestamp beneficiaryMaxAge,
			@Param("state") String state, @Param("district") String district,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select count(r) from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID "
			+ "and (ben.state like :state or ben.state is null) "
			+ "and (ben.district like :district or ben.district is null) and ben.gender = :gender")
	Long getCallCountsByGender(@Param("startDate") Timestamp timestamp, @Param("endDate") Timestamp timestamp2,
			@Param("gender") String gender, @Param("state") String state, @Param("district") String district,
			@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select count(r) from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID "
			+ "and (ben.state like :state or ben.state is null) "
			+ "and (ben.district like :district or ben.district is null) "
			+ "and (ben.sexualOrientation = :beneficiarySexualOrientation) ")
	Long getCallCountsBySexualOrientation(@Param("startDate") Timestamp timestamp,
			@Param("endDate") Timestamp timestamp2,
			@Param("beneficiarySexualOrientation") String beneficiarySexualOrientation, @Param("state") String state,
			@Param("district") String district, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select count(r) from CallDetailsReport r join r.benReport ben "
			+ "where r.callStartTime >= :startDate and r.callStartTime <= :endDate "
			+ "and r.providerServiceMapID = :providerServiceMapID "
			+ "and (ben.state like :state or ben.state is null) "
			+ "and (ben.district like :district or ben.district is null) "
			+ "and (ben.preferredLanguage like :beneficiaryPreferredLanguage) ")
	Long getCountsByPreferredLanguage(@Param("startDate") Timestamp timestamp, @Param("endDate") Timestamp timestamp2,
			@Param("beneficiaryPreferredLanguage") String beneficiaryPreferredLanguage, @Param("state") String state,
			@Param("district") String district, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT phoneBlock " + "FROM UnBlockedPhoneReport phoneBlock "
			+ "where phoneBlock.lastModDate >= :blockStartDate and phoneBlock.lastModDate <= :blockEndDate "
			+ "and phoneBlock.providerServiceMapID = :providerServiceMapID and phoneBlock.isBlocked = false ")
	List<UnBlockedPhoneReport> getUnBlockedUser(@Param("blockStartDate") Timestamp blockStartDate,
			@Param("blockEndDate") Timestamp blockEndDate, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT COUNT(feedbackReport.factFeedbackID) " + "FROM FeedbackReport feedbackReport "
			+ "where feedbackReport.createdDate >= :startDate and feedbackReport.createdDate <= :endDate "
			+ "and feedbackReport.providerServiceMapID = :providerServiceMapID and feedbackReport.feedbackTypeID = :feedbackTypeID")
	Long getFeedbackByFeedbackTypeID(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("feedbackTypeID") Integer feedbackTypeID);

	@Query("SELECT COUNT(feedbackReport.factFeedbackID) " + "FROM FeedbackReport feedbackReport "
			+ "where feedbackReport.createdDate >= :startDate and feedbackReport.createdDate <= :endDate "
			+ "and feedbackReport.providerServiceMapID = :providerServiceMapID and feedbackReport.feedbackNatureID = :feedbackNatureID")
	Long getFeedbackByFeedbackNatureID(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("feedbackNatureID") Integer feedbackNatureID);

	@Query("SELECT COUNT(callQualityReport.factBenCallID), callQualityReport.callSubType "
			+ "FROM CallQualityReport callQualityReport "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID and callQualityReport.callTypeID = :callTypeID ")
	public List<Objects[]> getCallTypeWiseReportByCallTypeID(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("callTypeID") Integer callTypeID) throws Exception;

	@Query("SELECT COUNT(callQualityReport.factBenCallID), callQualityReport.callSubType "
			+ "FROM CallQualityReport callQualityReport "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID group by callQualityReport.callSubType ")
	public List<Objects[]> getCallTypeWiseReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID)
			throws Exception;

	@Query("SELECT COUNT(callQualityReport.factBenCallID), userReport.empID, userReport.firstName, userReport.lastName, userReport.middleName "
			+ "FROM CallQualityReport callQualityReport " + "inner join callQualityReport.userReportObj userReport "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID and callQualityReport.userID = :userID")
	public List<Objects[]> getAgentWiseReportByUserID(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("userID") Long userID);

	@Query("SELECT COUNT(callQualityReport.factBenCallID), userReport.empID, userReport.firstName, userReport.lastName, userReport.middleName "
			+ "FROM CallQualityReport callQualityReport " + "inner join callQualityReport.userReportObj userReport "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID group by callQualityReport.userID order by callQualityReport.userID asc ")
	public List<Objects[]> getAgentWiseReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT COUNT(*), callQualityReport.receivedRoleName " + "FROM CallQualityReport callQualityReport "
			+ "inner join callQualityReport.userReportObj userReport "
			+ "inner join userReport.userServiceRoleReport userRoleMapping "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID and userRoleMapping.roleID = :roleID ")
	public List<Objects[]> getSkillSetWiseReportByRoleID(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("roleID") Long roleID);

	@Query("SELECT COUNT(*), callQualityReport.receivedRoleName " + "FROM CallQualityReport callQualityReport "
			+ "inner join callQualityReport.userReportObj userReport "
			+ "inner join userReport.userServiceRoleReport userRoleMapping "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID group by userRoleMapping.roleID ")
	public List<Objects[]> getSkillSetWiseReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT COUNT(callQualityReport.factBenCallID), callQualityReport.createdDate "
			+ "FROM CallQualityReport callQualityReport "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID group by callQualityReport.factCreatedDate ")
	public List<Objects[]> getDateWiseReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID)
			throws Exception;

	@Query("SELECT COUNT(callQualityReport.factBenCallID), location.locationName "
			+ "FROM CallQualityReport callQualityReport " + "inner join callQualityReport.userReportObj userReport "
			+ "left outer join userReport.userServiceRoleReport userRoleMapping "
			+ "left outer join userRoleMapping.workLocation location "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID group by location.psAddMapID ")
	public List<Objects[]> getLocationWiseReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("SELECT COUNT(callQualityReport.factBenCallID), location.locationName "
			+ "FROM CallQualityReport callQualityReport " + "inner join callQualityReport.userReportObj userReport "
			+ "left outer join userReport.userServiceRoleReport userRoleMapping "
			+ "left outer join userRoleMapping.workLocation location "
			+ "where callQualityReport.createdDate >= :startDate and callQualityReport.createdDate <= :endDate "
			+ "and callQualityReport.providerServiceMapID = :providerServiceMapID and location.psAddMapID= :psAddMapID")
	public List<Objects[]> getLocationWiseReportByLocationID(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("psAddMapID") Integer psAddMapID);

	@Query("SELECT callType " + "FROM CallType callType "
			+ "where callType.providerServiceMapID = :providerServiceMapID ")
	public List<CallType> getCallType(@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query("SELECT p FROM CallType p "
			+ "where p.providerServiceMapID = :providerServiceMapID and p.deleted=false order by p.callType ")
	public List<CallType> getCallTypeInOrder(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select provider.stateID from ProviderServiceMapping provider "
			+ "where provider.providerServiceMapID=:providerServiceMapID ")
	public Integer getStateByProvider(@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query("select districts from Districts districts "
			+ "where districts.stateID=:stateID order by districts.districtName asc")
	public List<Districts> getDistrictByStateID(@Param("stateID") Integer stateID);

	@Query("select medHistory from MedHistory medHistory " + "where medHistory.benCallID in :benCallID ")
	public ArrayList<MedHistory> getMedicalHistoryByBenIDs(@Param("benCallID") List<Long> benCallID);

	@Query("SELECT reportType " + "FROM ReportType reportType ")
	public List<ReportType> getReportType();

	// 15-09-2020
//	@Query(value="select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
//			+ "CallTypeName,max(CONVERT(CallDuration, unsigned)),RecordingFilePath"
//			+ " from db_reporting.fact_bencall t1 "
//			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
//			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate "
//			+ "and t1.CallTypeName= :callTypeName  group by ReceivedRoleName,ReceivedAgentID",nativeQuery=true)
	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,max(CZCallDuration),RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and t1.CZCallDuration is not null and (t1.CallReceivedUserID=t1.CallEndUserID) group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getHAHTValidCalls(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,max(CZCallDuration),RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ " LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and t1.CallSubTypeName like '%Disconnected%' and t1.CZCallDuration is not null  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getHAHTDisconnectedCalls(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,min(CZCallDuration),RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN  (select * from db_iemr.t_104benmedhistory where IsChiefComplaint is true)t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and t3.DiseaseSummary is not null and t1.CZCallDuration is not null  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getLAHTAlgorithmCalls(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,CZCallDuration,RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and (t1.CallReceivedUserID=t1.CallEndUserID) and t3.SelecteDiagnosis is not null  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getDSusedValidCallAtHAO(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,CZCallDuration,RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and (t1.CallReceivedUserID=t1.CallEndUserID) and (t3.DiseaseSummary is not null or t3.SelecteDiagnosis is not null)  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getRandomPickup(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,min(CZCallDuration),RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN db_reporting.fact_104benmedhistory t3 ON t1.BenCallID=t3.BenCallID "
			+ "LEFT JOIN db_iemr.m_userservicerolemapping t4 ON t1.CallEndUserID=t4.UserID "
			+ " LEFT JOIN db_iemr.m_role t5 ON t5.RoleID=t4.RoleID where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and t5.RoleName='MO' and t1.CZCallDuration is not null  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getLAHTTransferCallsMO(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value = "select t1.CreatedDate,CallID,ReceivedAgentID,t2.FirstName,ReceivedRoleName,t3.DiseaseSummary,t3.SelecteDiagnosis,"
			+ "CallTypeName,CZCallDuration,t3.ActionByHAO,RecordingFilePath" + " from db_reporting.fact_bencall t1 "
			+ "LEFT JOIN db_reporting.dim_user t2 ON t1.CallReceivedUserID=t2.UserID LEFT JOIN (select * from db_reporting.fact_104benmedhistory where DiseaseSummary is null and SelecteDiagnosis is null)t3 ON t1.BenCallID=t3.BenCallID LEFT JOIN db_identity.i_beneficiarymapping t4 ON t1.BeneficiaryRegID=t4.BenRegId where ReceivedRoleName= :receivedRoleName "
			+ " and t1.CreatedDate >= :startDate and t1.CreatedDate <= :endDate and t1.ProviderServiceMapID= :providerServiceMapID "
			+ "and t1.CallTypeName= :callTypeName and (t1.CZcallStartTime <= t4.CreatedDate and t1.CZcallEndTime >= t4.CreatedDate) and (t1.CallReceivedUserID=t1.CallEndUserID)  group by ReceivedRoleName,ReceivedAgentID", nativeQuery = true)
	public List<Objects[]> getOtherAdviceCalls(@Param("receivedRoleName") String receivedRoleName,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("callTypeName") String callTypeName, @Param("providerServiceMapID") Integer providerServiceMapID);
//	@Query("select report from CallReport report "
//			+ "where report.receivedRoleName=:receivedRoleName and report.callTypeName=:callTypeName and report.agentID is not null and report.phoneNo is not null "
//			+ "and report.createdDate >= :startDate and report.createdDate <= :endDate ")
//	public List<CallReport> getAllBenCallIDs(@Param("receivedRoleName") String receivedRoleName,@Param("callTypeName") String callTypeName,@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
//Honeywell 23-09-2020
//	@Query(value="SELECT COUNT( benCallDetail.BenCallID) FROM db_reporting.fact_bencall benCallDetail where benCallDetail.CreatedDate >= :startDate and benCallDetail.CreatedDate <= :endDate",nativeQuery=true)
//	public Integer totalCallsCount(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
//	@Query("SELECT benCallDetail.beneficiaryReport FROM CallReport benCallDetail left join BenDetails t2 on benCallDetail.beneficiaryRegID=t2.beneficiaryRegID "
//			+ " where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate group by t2.districtID ")
//	public List<BenDetails> allDistrictIDs(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
//	@Query(value="SELECT COUNT(distinct benCallDetail.BenCallID) "
//			+ "FROM db_reporting.fact_bencall benCallDetail "
//			+ "inner join db_reporting.dim_beneficiary ben "
//			+ "on ben.BeneficiaryRegID=benCallDetail.BeneficiaryRegID "
//			+ " where benCallDetail.CreatedDate >= :startDate and benCallDetail.CreatedDate <= :endDate and ben.PermDistrictId = :PermDistrictId ",nativeQuery=true)
//	public Integer districtCallCount(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,@Param("PermDistrictId") Integer PermDistrictId);
//	@Query(value="SELECT ben.PermDistrictId,ben.PermDistrict,COUNT(distinct  benCallDetail.CallID)  "
//			+ "FROM db_reporting.fact_bencall benCallDetail "
//			+ "inner join db_reporting.dim_beneficiary ben on ben.BeneficiaryRegID=benCallDetail.BeneficiaryRegID "
//			+ "where benCallDetail.CreatedDate >= :startDate and benCallDetail.CreatedDate <= :endDate and PermDistrictId is not null and PermDistrict is not null group by ben.PermDistrictId,ben.PermDistrict ",nativeQuery=true)
//	public List<Objects[]> allDistrictsCount(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

	@Query(value = "SELECT  ba.PermDistrictId, ba.PermDistrict, count(distinct bc.CallID) FROM db_iemr.t_bencall bc "
			+ " INNER JOIN db_identity.i_beneficiarymapping bm ON bc.BeneficiaryRegID = bm.benRegid "
			+ " INNER JOIN db_identity.i_beneficiaryaddress ba ON bm.benaddressid = ba.vanserialno AND ba.vanid = bm.vanid "
			+ " WHERE bc.CreatedDate >= :startDate AND bc.CreatedDate <= :endDate AND ba.PermDistrictId is not null "
			+ " AND  ba.PermDistrict is not null " + " GROUP BY ba.PermDistrictId, ba.PermDistrict", nativeQuery = true)
	public List<Objects[]> allDistrictsCount(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate);

	@Query(value = "SELECT Isrural, count(Dim_BeneficiaryID) FROM db_reporting.dim_beneficiary"
			+ " WHERE CreatedDate >= :startDate AND CreatedDate <= :endDate AND Isrural is not null GROUP BY Isrural", nativeQuery = true)
	public List<Objects[]> allRuralCount(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

//	@Query(value = "SELECT COUNT(Isrural) FROM db_reporting.dim_beneficiary "
//			+ " WHERE CreatedDate >= :startDate AND CreatedDate <= :endDate AND Isrural IS FALSE AND Isrural IS NOT NULL", nativeQuery = true)
//	 public int allUrbanCount(@Param("startDate") Timestamp startDate,
//			@Param("endDate") Timestamp endDate);

	// district wise call volume report
	// 01-07-2021
	// Ne298657
	@Query(value = " CALL db_reporting.Pr_DistrictwisecallvolumeReport(:startDate, :endDate, :providerServiceMapID, :districtID) "
			+ " ", nativeQuery = true)
	public List<Object[]> districtWiseCallVolumeReport(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("districtID") Long districtID);

}
