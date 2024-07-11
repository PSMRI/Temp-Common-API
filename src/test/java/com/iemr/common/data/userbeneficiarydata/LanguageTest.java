package com.iemr.common.data.userbeneficiarydata;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.notification.Notification;
import com.iemr.common.data.users.UserLangMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LanguageTest {

	@InjectMocks
    private Language languageUnderTest;

    @BeforeEach
    void setUp() {
        languageUnderTest = new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath");
    }

    @Test
    void testToString() {
        assertThat(languageUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testLanguageIDGetterAndSetter() {
        final Integer languageID = 0;
        languageUnderTest.setLanguageID(languageID);
        assertThat(languageUnderTest.getLanguageID()).isEqualTo(languageID);
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        languageUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(languageUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testM_UserLangMappingsGetterAndSetter() {
        final Set<UserLangMapping> m_UserLangMappings = Set.of(new UserLangMapping());
        languageUnderTest.setM_UserLangMappings(m_UserLangMappings);
        assertThat(languageUnderTest.getM_UserLangMappings()).isEqualTo(m_UserLangMappings);
    }

    @Test
    void testNotificationsGetterAndSetter() {
        final Set<Notification> notifications = Set.of(new Notification());
        languageUnderTest.setNotifications(notifications);
        assertThat(languageUnderTest.getNotifications()).isEqualTo(notifications);
    }

    @Test
    void testLanguageNameGetterAndSetter() {
        final String languageName = "languageName";
        languageUnderTest.setLanguageName(languageName);
        assertThat(languageUnderTest.getLanguageName()).isEqualTo(languageName);
    }

    @Test
    void testLanguageDescGetterAndSetter() {
        final String languageDesc = "languageDesc";
        languageUnderTest.setLanguageDesc(languageDesc);
        assertThat(languageUnderTest.getLanguageDesc()).isEqualTo(languageDesc);
    }

    @Test
    void testPropertyFilePathGetterAndSetter() {
        final String propertyFilePath = "propertyFilePath";
        languageUnderTest.setPropertyFilePath(propertyFilePath);
        assertThat(languageUnderTest.getPropertyFilePath()).isEqualTo(propertyFilePath);
    }

    @Test
    void testIvrFilePathGetterAndSetter() {
        final String ivrFilePath = "IVRFilePath";
        languageUnderTest.setIvrFilePath(ivrFilePath);
        assertThat(languageUnderTest.getIvrFilePath()).isEqualTo(ivrFilePath);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        languageUnderTest.setDeleted(deleted);
        assertThat(languageUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        languageUnderTest.setCreatedBy(createdBy);
        assertThat(languageUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        languageUnderTest.setCreatedDate(createdDate);
        assertThat(languageUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        languageUnderTest.setModifiedBy(modifiedBy);
        assertThat(languageUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        languageUnderTest.setLastModDate(lastModDate);
        assertThat(languageUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        languageUnderTest.setOutputMapper(outputMapper);
        assertThat(languageUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(languageUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(languageUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(languageUnderTest.hashCode()).isEqualTo(0);
    }
}
