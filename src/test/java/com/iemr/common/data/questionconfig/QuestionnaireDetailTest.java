package com.iemr.common.data.questionconfig;

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
class QuestionnaireDetailTest {

	@InjectMocks
    private QuestionnaireDetail questionnaireDetailUnderTest;

    @BeforeEach
    void setUp() {
        questionnaireDetailUnderTest = new QuestionnaireDetail(0L, "question", "questionDesc");
    }

    @Test
    void testToString() {
        assertThat(questionnaireDetailUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testQuestionIDGetterAndSetter() {
        final Long questionID = 0L;
        questionnaireDetailUnderTest.setQuestionID(questionID);
        assertThat(questionnaireDetailUnderTest.getQuestionID()).isEqualTo(questionID);
    }

    @Test
    void testQuestionGetterAndSetter() {
        final String question = "question";
        questionnaireDetailUnderTest.setQuestion(question);
        assertThat(questionnaireDetailUnderTest.getQuestion()).isEqualTo(question);
    }

    @Test
    void testQuestionDescGetterAndSetter() {
        final String questionDesc = "questionDesc";
        questionnaireDetailUnderTest.setQuestionDesc(questionDesc);
        assertThat(questionnaireDetailUnderTest.getQuestionDesc()).isEqualTo(questionDesc);
    }

    @Test
    void testQuestionTypeDetailGetterAndSetter() {
        final QuestionTypeDetail questionTypeDetail = new QuestionTypeDetail(0L, "questionType", "questionTypeDesc");
        questionnaireDetailUnderTest.setQuestionTypeDetail(questionTypeDetail);
        assertThat(questionnaireDetailUnderTest.getQuestionTypeDetail()).isEqualTo(questionTypeDetail);
    }

    @Test
    void testAnswerTypeGetterAndSetter() {
        final String answerType = "answerType";
        questionnaireDetailUnderTest.setAnswerType(answerType);
        assertThat(questionnaireDetailUnderTest.getAnswerType()).isEqualTo(answerType);
    }

    @Test
    void testTriggerFeedbackGetterAndSetter() {
        final Boolean triggerFeedback = false;
        questionnaireDetailUnderTest.setTriggerFeedback(triggerFeedback);
        assertThat(questionnaireDetailUnderTest.getTriggerFeedback()).isFalse();
    }

    @Test
    void testTriggerFeedbackForGetterAndSetter() {
        final String triggerFeedbackFor = "triggerFeedbackFor";
        questionnaireDetailUnderTest.setTriggerFeedbackFor(triggerFeedbackFor);
        assertThat(questionnaireDetailUnderTest.getTriggerFeedbackFor()).isEqualTo(triggerFeedbackFor);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        questionnaireDetailUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(questionnaireDetailUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        questionnaireDetailUnderTest.setDeleted(deleted);
        assertThat(questionnaireDetailUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        questionnaireDetailUnderTest.setCreatedBy(createdBy);
        assertThat(questionnaireDetailUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        questionnaireDetailUnderTest.setCreatedDate(createdDate);
        assertThat(questionnaireDetailUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final Boolean modifiedBy = false;
        questionnaireDetailUnderTest.setModifiedBy(modifiedBy);
        assertThat(questionnaireDetailUnderTest.getModifiedBy()).isFalse();
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        questionnaireDetailUnderTest.setLastModDate(lastModDate);
        assertThat(questionnaireDetailUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        questionnaireDetailUnderTest.setOutputMapper(outputMapper);
        assertThat(questionnaireDetailUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(questionnaireDetailUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(questionnaireDetailUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(questionnaireDetailUnderTest.hashCode()).isEqualTo(0);
    }
}
