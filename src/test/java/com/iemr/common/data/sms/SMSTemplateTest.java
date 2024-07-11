package com.iemr.common.data.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SMSTemplateTest {

	@InjectMocks
    private SMSTemplate smsTemplateUnderTest;

    @BeforeEach
    void setUp() {
        smsTemplateUnderTest = new SMSTemplate();
    }

    @Test
    void testToString() {
        assertThat(smsTemplateUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSmsTemplateIDGetterAndSetter() {
        final Integer smsTemplateID = 0;
        smsTemplateUnderTest.setSmsTemplateID(smsTemplateID);
        assertThat(smsTemplateUnderTest.getSmsTemplateID()).isEqualTo(smsTemplateID);
    }

    @Test
    void testSmsParameterMapsGetterAndSetter() {
        final List<SMSParametersMap> smsParameterMaps = List.of(new SMSParametersMap());
        smsTemplateUnderTest.setSmsParameterMaps(smsParameterMaps);
        assertThat(smsTemplateUnderTest.getSmsParameterMaps()).isEqualTo(smsParameterMaps);
    }

    @Test
    void testSmsTemplateNameGetterAndSetter() {
        final String smsTemplateName = "smsTemplateName";
        smsTemplateUnderTest.setSmsTemplateName(smsTemplateName);
        assertThat(smsTemplateUnderTest.getSmsTemplateName()).isEqualTo(smsTemplateName);
    }

    @Test
    void testSmsTemplateGetterAndSetter() {
        final String smsTemplate = "smsTemplate";
        smsTemplateUnderTest.setSmsTemplate(smsTemplate);
        assertThat(smsTemplateUnderTest.getSmsTemplate()).isEqualTo(smsTemplate);
    }

    @Test
    void testDltTemplateIdGetterAndSetter() {
        final String dltTemplateId = "dltTemplateId";
        smsTemplateUnderTest.setDltTemplateId(dltTemplateId);
        assertThat(smsTemplateUnderTest.getDltTemplateId()).isEqualTo(dltTemplateId);
    }

    @Test
    void testSmsSenderIDGetterAndSetter() {
        final String smsSenderID = "smsSenderID";
        smsTemplateUnderTest.setSmsSenderID(smsSenderID);
        assertThat(smsTemplateUnderTest.getSmsSenderID()).isEqualTo(smsSenderID);
    }

    @Test
    void testSmsTypeIDGetterAndSetter() {
        final Integer smsTypeID = 0;
        smsTemplateUnderTest.setSmsTypeID(smsTypeID);
        assertThat(smsTemplateUnderTest.getSmsTypeID()).isEqualTo(smsTypeID);
    }

    @Test
    void testSmsTypeGetterAndSetter() {
        final SMSType smsType = new SMSType();
        smsTemplateUnderTest.setSmsType(smsType);
        assertThat(smsTemplateUnderTest.getSmsType()).isEqualTo(smsType);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        smsTemplateUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(smsTemplateUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        smsTemplateUnderTest.setDeleted(deleted);
        assertThat(smsTemplateUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsTemplateUnderTest.setCreatedBy(createdBy);
        assertThat(smsTemplateUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsTemplateUnderTest.setCreatedDate(createdDate);
        assertThat(smsTemplateUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        smsTemplateUnderTest.setModifiedBy(modifiedBy);
        assertThat(smsTemplateUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsTemplateUnderTest.setLastModDate(lastModDate);
        assertThat(smsTemplateUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(smsTemplateUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsTemplateUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsTemplateUnderTest.hashCode()).isEqualTo(0);
    }
}
