package com.iemr.common.data.report;

import com.iemr.common.data.callhandling.CallType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CallQualityReportTest {

	@InjectMocks
    private CallQualityReport callQualityReportUnderTest;

    @BeforeEach
    void setUp() {
        callQualityReportUnderTest = new CallQualityReport();
    }

    @Test
    void testFactBenCallIDGetterAndSetter() {
        final Long factBenCallID = 0L;
        callQualityReportUnderTest.setFactBenCallID(factBenCallID);
        assertThat(callQualityReportUnderTest.getFactBenCallID()).isEqualTo(factBenCallID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        callQualityReportUnderTest.setBenCallID(benCallID);
        assertThat(callQualityReportUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        callQualityReportUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(callQualityReportUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCallTimeGetterAndSetter() {
        final Timestamp callTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setCallTime(callTime);
        assertThat(callQualityReportUnderTest.getCallTime()).isEqualTo(callTime);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        callQualityReportUnderTest.setRemarks(remarks);
        assertThat(callQualityReportUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        callQualityReportUnderTest.setCallTypeID(callTypeID);
        assertThat(callQualityReportUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testCallTypeObjGetterAndSetter() {
        final CallType callTypeObj = new CallType();
        callQualityReportUnderTest.setCallTypeObj(callTypeObj);
        assertThat(callQualityReportUnderTest.getCallTypeObj()).isEqualTo(callTypeObj);
    }

    @Test
    void testCallClosureTypeGetterAndSetter() {
        final String callClosureType = "callClosureType";
        callQualityReportUnderTest.setCallClosureType(callClosureType);
        assertThat(callQualityReportUnderTest.getCallClosureType()).isEqualTo(callClosureType);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        callQualityReportUnderTest.setCallType(callType);
        assertThat(callQualityReportUnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testCallSubTypeGetterAndSetter() {
        final String callSubType = "callSubType";
        callQualityReportUnderTest.setCallSubType(callSubType);
        assertThat(callQualityReportUnderTest.getCallSubType()).isEqualTo(callSubType);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        callQualityReportUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(callQualityReportUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        callQualityReportUnderTest.setPhoneNo(phoneNo);
        assertThat(callQualityReportUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testIsOutboundGetterAndSetter() {
        final Boolean isOutbound = false;
        callQualityReportUnderTest.setIsOutbound(isOutbound);
        assertThat(callQualityReportUnderTest.getIsOutbound()).isFalse();
    }

    @Test
    void testReceivedRoleNameGetterAndSetter() {
        final String receivedRoleName = "receivedRoleName";
        callQualityReportUnderTest.setReceivedRoleName(receivedRoleName);
        assertThat(callQualityReportUnderTest.getReceivedRoleName()).isEqualTo(receivedRoleName);
    }

    @Test
    void testStartDateGetterAndSetter() {
        final Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setStartDate(startDate);
        assertThat(callQualityReportUnderTest.getStartDate()).isEqualTo(startDate);
    }

    @Test
    void testEndDateGetterAndSetter() {
        final Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setEndDate(endDate);
        assertThat(callQualityReportUnderTest.getEndDate()).isEqualTo(endDate);
    }

    @Test
    void testSearchCriteriaGetterAndSetter() {
        final String searchCriteria = "searchCriteria";
        callQualityReportUnderTest.setSearchCriteria(searchCriteria);
        assertThat(callQualityReportUnderTest.getSearchCriteria()).isEqualTo(searchCriteria);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setCreatedDate(createdDate);
        assertThat(callQualityReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        callQualityReportUnderTest.setUserID(userID);
        assertThat(callQualityReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testUserReportObjGetterAndSetter() {
        final UserReport userReportObj = new UserReport();
        callQualityReportUnderTest.setUserReportObj(userReportObj);
        assertThat(callQualityReportUnderTest.getUserReportObj()).isEqualTo(userReportObj);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Long roleID = 0L;
        callQualityReportUnderTest.setRoleID(roleID);
        assertThat(callQualityReportUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testWorkingLocationIDGetterAndSetter() {
        final Integer workingLocationID = 0;
        callQualityReportUnderTest.setWorkingLocationID(workingLocationID);
        assertThat(callQualityReportUnderTest.getWorkingLocationID()).isEqualTo(workingLocationID);
    }

    @Test
    void testFactCreatedDateGetterAndSetter() {
        final Long factCreatedDate = 0L;
        callQualityReportUnderTest.setFactCreatedDate(factCreatedDate);
        assertThat(callQualityReportUnderTest.getFactCreatedDate()).isEqualTo(factCreatedDate);
    }

    @Test
    void testLocationIDGetterAndSetter() {
        final Long locationID = 0L;
        callQualityReportUnderTest.setLocationID(locationID);
        assertThat(callQualityReportUnderTest.getLocationID()).isEqualTo(locationID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Long districtID = 0L;
        callQualityReportUnderTest.setDistrictID(districtID);
        assertThat(callQualityReportUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final String district = "district";
        callQualityReportUnderTest.setDistrict(district);
        assertThat(callQualityReportUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testSubdistrictIDGetterAndSetter() {
        final Long subdistrictID = 0L;
        callQualityReportUnderTest.setSubdistrictID(subdistrictID);
        assertThat(callQualityReportUnderTest.getSubdistrictID()).isEqualTo(subdistrictID);
    }

    @Test
    void testFileNameGetterAndSetter() {
        final String fileName = "fileName";
        callQualityReportUnderTest.setFileName(fileName);
        assertThat(callQualityReportUnderTest.getFileName()).isEqualTo(fileName);
    }

    @Test
    void testVillageIDGetterAndSetter() {
        final Long villageID = 0L;
        callQualityReportUnderTest.setVillageID(villageID);
        assertThat(callQualityReportUnderTest.getVillageID()).isEqualTo(villageID);
    }

    @Test
    void testStartDateTimeGetterAndSetter() {
        final Timestamp startDateTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setStartDateTime(startDateTime);
        assertThat(callQualityReportUnderTest.getStartDateTime()).isEqualTo(startDateTime);
    }

    @Test
    void testEndDateTimeGetterAndSetter() {
        final Timestamp endDateTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callQualityReportUnderTest.setEndDateTime(endDateTime);
        assertThat(callQualityReportUnderTest.getEndDateTime()).isEqualTo(endDateTime);
    }

    @Test
    void testBenReportGetterAndSetter() {
        final BenDetails benReport = new BenDetails();
        callQualityReportUnderTest.setBenReport(benReport);
        assertThat(callQualityReportUnderTest.getBenReport()).isEqualTo(benReport);
    }

    @Test
    void testEquals() {
        assertThat(callQualityReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(callQualityReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(callQualityReportUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(callQualityReportUnderTest.toString()).isEqualTo("result");
    }
}
