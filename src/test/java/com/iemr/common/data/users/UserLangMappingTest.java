package com.iemr.common.data.users;

import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserLangMappingTest {

	@InjectMocks
    private UserLangMapping userLangMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userLangMappingUnderTest = new UserLangMapping();
    }

    @Test
    void testCreateUserLangMapping() {
        // Setup
        final UserLangMapping expectedResult = new UserLangMapping();
        expectedResult.setUserLangID(0);
        expectedResult.setLanguageID(0);
        final Language m_language = new Language();
        m_language.setLanguageName("languageName");
        expectedResult.setM_language(m_language);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final UserLangMapping result = userLangMappingUnderTest.createUserLangMapping(0, 0L, 0, "languageName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userLangMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testUserLangIDGetterAndSetter() {
        final Integer userLangID = 0;
        userLangMappingUnderTest.setUserLangID(userLangID);
        assertThat(userLangMappingUnderTest.getUserLangID()).isEqualTo(userLangID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        userLangMappingUnderTest.setUserID(userID);
        assertThat(userLangMappingUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testM_userGetterAndSetter() {
        final User m_user = new User();
        userLangMappingUnderTest.setM_user(m_user);
        assertThat(userLangMappingUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testLanguageIDGetterAndSetter() {
        final Integer languageID = 0;
        userLangMappingUnderTest.setLanguageID(languageID);
        assertThat(userLangMappingUnderTest.getLanguageID()).isEqualTo(languageID);
    }

    @Test
    void testM_languageGetterAndSetter() {
        final Language m_language = new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath");
        userLangMappingUnderTest.setM_language(m_language);
        assertThat(userLangMappingUnderTest.getM_language()).isEqualTo(m_language);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userLangMappingUnderTest.setDeleted(deleted);
        assertThat(userLangMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        userLangMappingUnderTest.setCreatedBy(createdBy);
        assertThat(userLangMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userLangMappingUnderTest.setCreatedDate(createdDate);
        assertThat(userLangMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        userLangMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(userLangMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userLangMappingUnderTest.setLastModDate(lastModDate);
        assertThat(userLangMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testCanReadGetterAndSetter() {
        final Boolean canRead = false;
        userLangMappingUnderTest.setCanRead(canRead);
        assertThat(userLangMappingUnderTest.getCanRead()).isFalse();
    }

    @Test
    void testCanWriteGetterAndSetter() {
        final Boolean canWrite = false;
        userLangMappingUnderTest.setCanWrite(canWrite);
        assertThat(userLangMappingUnderTest.getCanWrite()).isFalse();
    }

    @Test
    void testCanSpeakGetterAndSetter() {
        final Boolean canSpeak = false;
        userLangMappingUnderTest.setCanSpeak(canSpeak);
        assertThat(userLangMappingUnderTest.getCanSpeak()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        userLangMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(userLangMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userLangMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userLangMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userLangMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
