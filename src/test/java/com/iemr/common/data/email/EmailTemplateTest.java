package com.iemr.common.data.email;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmailTemplateTest {

	@InjectMocks
    private EmailTemplate emailTemplateUnderTest;

    @BeforeEach
    void setUp() {
        emailTemplateUnderTest = new EmailTemplate();
    }

    @Test
    void testToString() {
        assertThat(emailTemplateUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testEmailTemplateIDGetterAndSetter() {
        final Integer emailTemplateID = 0;
        emailTemplateUnderTest.setEmailTemplateID(emailTemplateID);
        assertThat(emailTemplateUnderTest.getEmailTemplateID()).isEqualTo(emailTemplateID);
    }

    @Test
    void testEmailTemplateNameGetterAndSetter() {
        final String emailTemplateName = "emailTemplateName";
        emailTemplateUnderTest.setEmailTemplateName(emailTemplateName);
        assertThat(emailTemplateUnderTest.getEmailTemplateName()).isEqualTo(emailTemplateName);
    }

    @Test
    void testEmailTemplateGetterAndSetter() {
        final String emailTemplate = "emailTemplate";
        emailTemplateUnderTest.setEmailTemplate(emailTemplate);
        assertThat(emailTemplateUnderTest.getEmailTemplate()).isEqualTo(emailTemplate);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        emailTemplateUnderTest.setDeleted(deleted);
        assertThat(emailTemplateUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        emailTemplateUnderTest.setOutputMapper(outputMapper);
        assertThat(emailTemplateUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(emailTemplateUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(emailTemplateUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(emailTemplateUnderTest.hashCode()).isEqualTo(0);
    }
}
