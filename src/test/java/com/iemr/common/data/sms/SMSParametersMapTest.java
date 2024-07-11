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
class SMSParametersMapTest {

	@InjectMocks
    private SMSParametersMap smsParametersMapUnderTest;

    @BeforeEach
    void setUp() {
        smsParametersMapUnderTest = new SMSParametersMap();
    }

    @Test
    void testToString() {
        assertThat(smsParametersMapUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSmsParameterMapIDGetterAndSetter() {
        final Integer smsParameterMapID = 0;
        smsParametersMapUnderTest.setSmsParameterMapID(smsParameterMapID);
        assertThat(smsParametersMapUnderTest.getSmsParameterMapID()).isEqualTo(smsParameterMapID);
    }

    @Test
    void testSmsParameterIDGetterAndSetter() {
        final Integer smsParameterID = 0;
        smsParametersMapUnderTest.setSmsParameterID(smsParameterID);
        assertThat(smsParametersMapUnderTest.getSmsParameterID()).isEqualTo(smsParameterID);
    }

    @Test
    void testSmsParameterGetterAndSetter() {
        final SMSParameters smsParameter = new SMSParameters();
        smsParametersMapUnderTest.setSmsParameter(smsParameter);
        assertThat(smsParametersMapUnderTest.getSmsParameter()).isEqualTo(smsParameter);
    }

    @Test
    void testSmsTypeIDGetterAndSetter() {
        final Integer smsTypeID = 0;
        smsParametersMapUnderTest.setSmsTypeID(smsTypeID);
        assertThat(smsParametersMapUnderTest.getSmsTypeID()).isEqualTo(smsTypeID);
    }

    @Test
    void testSmsTypeGetterAndSetter() {
        final SMSType smsType = new SMSType();
        smsParametersMapUnderTest.setSmsType(smsType);
        assertThat(smsParametersMapUnderTest.getSmsType()).isEqualTo(smsType);
    }

    @Test
    void testSmsTemplateIDGetterAndSetter() {
        final Integer smsTemplateID = 0;
        smsParametersMapUnderTest.setSmsTemplateID(smsTemplateID);
        assertThat(smsParametersMapUnderTest.getSmsTemplateID()).isEqualTo(smsTemplateID);
    }

    @Test
    void testSmsParameterNameGetterAndSetter() {
        final String smsParameterName = "smsParameterName";
        smsParametersMapUnderTest.setSmsParameterName(smsParameterName);
        assertThat(smsParametersMapUnderTest.getSmsParameterName()).isEqualTo(smsParameterName);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        smsParametersMapUnderTest.setDeleted(deleted);
        assertThat(smsParametersMapUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsParametersMapUnderTest.setCreatedBy(createdBy);
        assertThat(smsParametersMapUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsParametersMapUnderTest.setCreatedDate(createdDate);
        assertThat(smsParametersMapUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        smsParametersMapUnderTest.setModifiedBy(modifiedBy);
        assertThat(smsParametersMapUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsParametersMapUnderTest.setLastModDate(lastModDate);
        assertThat(smsParametersMapUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(smsParametersMapUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsParametersMapUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsParametersMapUnderTest.hashCode()).isEqualTo(0);
    }
}
