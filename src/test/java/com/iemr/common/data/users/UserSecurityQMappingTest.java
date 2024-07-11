package com.iemr.common.data.users;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserSecurityQMappingTest {

    @Mock
    private LoginSecurityQuestions mockM_LoginSecurityQuestions;

    @InjectMocks
    private UserSecurityQMapping userSecurityQMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userSecurityQMappingUnderTest = new UserSecurityQMapping(0L, 0L, "questionID", mockM_LoginSecurityQuestions,
                "answers", "mobileNumber", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testUserSecurityQAIDGetterAndSetter() {
        final Long userSecurityQAID = 0L;
        userSecurityQMappingUnderTest.setUserSecurityQAID(userSecurityQAID);
        assertThat(userSecurityQMappingUnderTest.getUserSecurityQAID()).isEqualTo(userSecurityQAID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        userSecurityQMappingUnderTest.setUserID(userID);
        assertThat(userSecurityQMappingUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testAnswersGetterAndSetter() {
        final String answers = "answers";
        userSecurityQMappingUnderTest.setAnswers(answers);
        assertThat(userSecurityQMappingUnderTest.getAnswers()).isEqualTo(answers);
    }

    @Test
    void testMobileNumberGetterAndSetter() {
        final String mobileNumber = "mobileNumber";
        userSecurityQMappingUnderTest.setMobileNumber(mobileNumber);
        assertThat(userSecurityQMappingUnderTest.getMobileNumber()).isEqualTo(mobileNumber);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        userSecurityQMappingUnderTest.setDeleted(deleted);
        assertThat(userSecurityQMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        userSecurityQMappingUnderTest.setCreatedBy(createdBy);
        assertThat(userSecurityQMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userSecurityQMappingUnderTest.setCreatedDate(createdDate);
        assertThat(userSecurityQMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        userSecurityQMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(userSecurityQMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        userSecurityQMappingUnderTest.setLastModDate(lastModDate);
        assertThat(userSecurityQMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testQuestionIDGetterAndSetter() {
        final String questionID = "questionID";
        userSecurityQMappingUnderTest.setQuestionID(questionID);
        assertThat(userSecurityQMappingUnderTest.getQuestionID()).isEqualTo(questionID);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userSecurityQMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testM_LoginSecurityQuestionsGetterAndSetter() {
        final LoginSecurityQuestions m_LoginSecurityQuestions = new LoginSecurityQuestions();
        userSecurityQMappingUnderTest.setM_LoginSecurityQuestions(m_LoginSecurityQuestions);
        assertThat(userSecurityQMappingUnderTest.getM_LoginSecurityQuestions()).isEqualTo(m_LoginSecurityQuestions);
    }

    @Test
    void testOutputMapperGetterAndSetter() throws Exception {
        final OutputMapper outputMapper = new OutputMapper();
        userSecurityQMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(userSecurityQMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(userSecurityQMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(userSecurityQMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(userSecurityQMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
