package com.iemr.common.data.request_logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CallLoggerTest {

	@InjectMocks
    private CallLogger callLoggerUnderTest;

    @BeforeEach
    void setUp() {
        callLoggerUnderTest = new CallLogger();
    }

    @Test
    void testTBenCallLogIDGetterAndSetter() {
        final Long tBenCallLogID = 0L;
        callLoggerUnderTest.setTBenCallLogID(tBenCallLogID);
        assertThat(callLoggerUnderTest.getTBenCallLogID()).isEqualTo(tBenCallLogID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        callLoggerUnderTest.setBenCallID(benCallID);
        assertThat(callLoggerUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testCallIDGetterAndSetter() {
        final String callID = "callID";
        callLoggerUnderTest.setCallID(callID);
        assertThat(callLoggerUnderTest.getCallID()).isEqualTo(callID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        callLoggerUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(callLoggerUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCallEndTimeGetterAndSetter() {
        final Timestamp callEndTime = new Timestamp(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null);
        callLoggerUnderTest.setCallEndTime(callEndTime);
        assertThat(callLoggerUnderTest.getCallEndTime()).isEqualTo(callEndTime);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        callLoggerUnderTest.setRemarks(remarks);
        assertThat(callLoggerUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testCallClosureTypeGetterAndSetter() {
        final String callClosureType = "callClosureType";
        callLoggerUnderTest.setCallClosureType(callClosureType);
        assertThat(callLoggerUnderTest.getCallClosureType()).isEqualTo(callClosureType);
    }

    @Test
    void testDispositionStatusIDGetterAndSetter() {
        final Integer dispositionStatusID = 0;
        callLoggerUnderTest.setDispositionStatusID(dispositionStatusID);
        assertThat(callLoggerUnderTest.getDispositionStatusID()).isEqualTo(dispositionStatusID);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        callLoggerUnderTest.setCallTypeID(callTypeID);
        assertThat(callLoggerUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testEmergencyTypeGetterAndSetter() {
        final Short emergencyType = (short) 0;
        callLoggerUnderTest.setEmergencyType(emergencyType);
        assertThat(callLoggerUnderTest.getEmergencyType()).isEqualTo(emergencyType);
    }

    @Test
    void testAPINameGetterAndSetter() {
        final String aPIName = "APIName";
        callLoggerUnderTest.setAPIName(aPIName);
        assertThat(callLoggerUnderTest.getAPIName()).isEqualTo(aPIName);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        callLoggerUnderTest.setDeleted(deleted);
        assertThat(callLoggerUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        callLoggerUnderTest.setCreatedBy(createdBy);
        assertThat(callLoggerUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        callLoggerUnderTest.setModifiedBy(modifiedBy);
        assertThat(callLoggerUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = new Timestamp(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null);
        callLoggerUnderTest.setLastModDate(lastModDate);
        assertThat(callLoggerUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testRequestOBJGetterAndSetter() {
        final String requestOBJ = "requestOBJ";
        callLoggerUnderTest.setRequestOBJ(requestOBJ);
        assertThat(callLoggerUnderTest.getRequestOBJ()).isEqualTo(requestOBJ);
    }

    @Test
    void testEquals() {
        assertThat(callLoggerUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(callLoggerUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(callLoggerUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(callLoggerUnderTest.toString()).isEqualTo("result");
    }
}
