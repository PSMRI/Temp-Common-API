package com.iemr.common.data.users;

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
class LoginSecurityQuestionsTest {

	@InjectMocks
    private LoginSecurityQuestions loginSecurityQuestionsUnderTest;

    @BeforeEach
    void setUp() {
        loginSecurityQuestionsUnderTest = new LoginSecurityQuestions();
    }

    @Test
    void testGetLoginSecurityQuestions() {
        // Setup
        final LoginSecurityQuestions expectedResult = new LoginSecurityQuestions();
        expectedResult.setQuestionID(0);
        expectedResult.setQuestion("question");
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Run the test
        final LoginSecurityQuestions result = loginSecurityQuestionsUnderTest.getLoginSecurityQuestions(0, "question",
                false, "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testQuestionIDGetterAndSetter() {
        final Integer questionID = 0;
        loginSecurityQuestionsUnderTest.setQuestionID(questionID);
        assertThat(loginSecurityQuestionsUnderTest.getQuestionID()).isEqualTo(questionID);
    }

    @Test
    void testQuestionGetterAndSetter() {
        final String question = "question";
        loginSecurityQuestionsUnderTest.setQuestion(question);
        assertThat(loginSecurityQuestionsUnderTest.getQuestion()).isEqualTo(question);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        loginSecurityQuestionsUnderTest.setDeleted(deleted);
        assertThat(loginSecurityQuestionsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        loginSecurityQuestionsUnderTest.setCreatedBy(createdBy);
        assertThat(loginSecurityQuestionsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginSecurityQuestionsUnderTest.setCreatedDate(createdDate);
        assertThat(loginSecurityQuestionsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        loginSecurityQuestionsUnderTest.setModifiedBy(modifiedBy);
        assertThat(loginSecurityQuestionsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        loginSecurityQuestionsUnderTest.setLastModDate(lastModDate);
        assertThat(loginSecurityQuestionsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testGetSecurityQuestions() {
        // Setup
        final LoginSecurityQuestions expectedResult = new LoginSecurityQuestions();
        expectedResult.setQuestionID(0);
        expectedResult.setQuestion("question");
        expectedResult.setDeleted(false);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        // Run the test
        final LoginSecurityQuestions result = loginSecurityQuestionsUnderTest.getSecurityQuestions(0, "question");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(loginSecurityQuestionsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        loginSecurityQuestionsUnderTest.setOutputMapper(outputMapper);
        assertThat(loginSecurityQuestionsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(loginSecurityQuestionsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(loginSecurityQuestionsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(loginSecurityQuestionsUnderTest.hashCode()).isEqualTo(0);
    }
}
