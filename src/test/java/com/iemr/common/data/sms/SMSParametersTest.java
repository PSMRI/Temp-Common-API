package com.iemr.common.data.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SMSParametersTest {

	@InjectMocks
    private SMSParameters smsParametersUnderTest;

    @BeforeEach
    void setUp() {
        smsParametersUnderTest = new SMSParameters();
    }

    @Test
    void testToString() {
        assertThat(smsParametersUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSmsParameterIDGetterAndSetter() {
        final Integer smsParameterID = 0;
        smsParametersUnderTest.setSmsParameterID(smsParameterID);
        assertThat(smsParametersUnderTest.getSmsParameterID()).isEqualTo(smsParameterID);
    }

    @Test
    void testSmsParameterNameGetterAndSetter() {
        final String smsParameterName = "smsParameterName";
        smsParametersUnderTest.setSmsParameterName(smsParameterName);
        assertThat(smsParametersUnderTest.getSmsParameterName()).isEqualTo(smsParameterName);
    }

    @Test
    void testSmsParameterTypeGetterAndSetter() {
        final String smsParameterType = "smsParameterType";
        smsParametersUnderTest.setSmsParameterType(smsParameterType);
        assertThat(smsParametersUnderTest.getSmsParameterType()).isEqualTo(smsParameterType);
    }

    @Test
    void testDataClassNameGetterAndSetter() {
        final String dataClassName = "dataClassName";
        smsParametersUnderTest.setDataClassName(dataClassName);
        assertThat(smsParametersUnderTest.getDataClassName()).isEqualTo(dataClassName);
    }

    @Test
    void testDataNameGetterAndSetter() {
        final String dataName = "dataName";
        smsParametersUnderTest.setDataName(dataName);
        assertThat(smsParametersUnderTest.getDataName()).isEqualTo(dataName);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        smsParametersUnderTest.setDeleted(deleted);
        assertThat(smsParametersUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsParametersUnderTest.setCreatedBy(createdBy);
        assertThat(smsParametersUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsParametersUnderTest.setCreatedDate(createdDate);
        assertThat(smsParametersUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        smsParametersUnderTest.setModifiedBy(modifiedBy);
        assertThat(smsParametersUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsParametersUnderTest.setLastModDate(lastModDate);
        assertThat(smsParametersUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        smsParametersUnderTest.setServiceID(serviceID);
        assertThat(smsParametersUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testEquals() {
        assertThat(smsParametersUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsParametersUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsParametersUnderTest.hashCode()).isEqualTo(0);
    }
}
