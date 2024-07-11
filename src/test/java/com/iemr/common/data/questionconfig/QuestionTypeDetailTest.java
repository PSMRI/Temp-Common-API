package com.iemr.common.data.questionconfig;

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
class QuestionTypeDetailTest {

	@InjectMocks
    private QuestionTypeDetail questionTypeDetailUnderTest;

    @BeforeEach
    void setUp() {
        questionTypeDetailUnderTest = new QuestionTypeDetail(0L, "questionType", "questionTypeDesc");
    }

    @Test
    void testToString() {
        assertThat(questionTypeDetailUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testQuestionTypeIDGetterAndSetter() {
        final Long questionTypeID = 0L;
        questionTypeDetailUnderTest.setQuestionTypeID(questionTypeID);
        assertThat(questionTypeDetailUnderTest.getQuestionTypeID()).isEqualTo(questionTypeID);
    }

    @Test
    void testQuestionTypeGetterAndSetter() {
        final String questionType = "questionType";
        questionTypeDetailUnderTest.setQuestionType(questionType);
        assertThat(questionTypeDetailUnderTest.getQuestionType()).isEqualTo(questionType);
    }

    @Test
    void testQuestionTypeDescGetterAndSetter() {
        final String questionTypeDesc = "questionTypeDesc";
        questionTypeDetailUnderTest.setQuestionTypeDesc(questionTypeDesc);
        assertThat(questionTypeDetailUnderTest.getQuestionTypeDesc()).isEqualTo(questionTypeDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        questionTypeDetailUnderTest.setDeleted(deleted);
        assertThat(questionTypeDetailUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        questionTypeDetailUnderTest.setCreatedBy(createdBy);
        assertThat(questionTypeDetailUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        questionTypeDetailUnderTest.setCreatedDate(createdDate);
        assertThat(questionTypeDetailUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final Boolean modifiedBy = false;
        questionTypeDetailUnderTest.setModifiedBy(modifiedBy);
        assertThat(questionTypeDetailUnderTest.getModifiedBy()).isFalse();
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        questionTypeDetailUnderTest.setLastModDate(lastModDate);
        assertThat(questionTypeDetailUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testQuestionnaireDetailsGetterAndSetter() {
        final List<QuestionnaireDetail> questionnaireDetails = List.of(
                new QuestionnaireDetail(0L, "question", "questionDesc"));
        questionTypeDetailUnderTest.setQuestionnaireDetails(questionnaireDetails);
        assertThat(questionTypeDetailUnderTest.getQuestionnaireDetails()).isEqualTo(questionnaireDetails);
    }

    @Test
    void testEquals() {
        assertThat(questionTypeDetailUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(questionTypeDetailUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(questionTypeDetailUnderTest.hashCode()).isEqualTo(0);
    }
}
