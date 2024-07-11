package com.iemr.common.data.mctshistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MctsCallResponseDetailTest {

	@InjectMocks
    private MctsCallResponseDetail mctsCallResponseDetailUnderTest;

    @BeforeEach
    void setUp() {
        mctsCallResponseDetailUnderTest = new MctsCallResponseDetail();
    }

    @Test
    void testMctsCallResponseIDGetterAndSetter() {
        final Long mctsCallResponseID = 0L;
        mctsCallResponseDetailUnderTest.setMctsCallResponseID(mctsCallResponseID);
        assertThat(mctsCallResponseDetailUnderTest.getMctsCallResponseID()).isEqualTo(mctsCallResponseID);
    }

    @Test
    void testMotherIDGetterAndSetter() {
        final Long motherID = 0L;
        mctsCallResponseDetailUnderTest.setMotherID(motherID);
        assertThat(mctsCallResponseDetailUnderTest.getMotherID()).isEqualTo(motherID);
    }

    @Test
    void testChildIDGetterAndSetter() {
        final Long childID = 0L;
        mctsCallResponseDetailUnderTest.setChildID(childID);
        assertThat(mctsCallResponseDetailUnderTest.getChildID()).isEqualTo(childID);
    }

    @Test
    void testCallDetailIDGetterAndSetter() {
        final Long callDetailID = 0L;
        mctsCallResponseDetailUnderTest.setCallDetailID(callDetailID);
        assertThat(mctsCallResponseDetailUnderTest.getCallDetailID()).isEqualTo(callDetailID);
    }

    @Test
    void testAnswerGetterAndSetter() {
        final String answer = "answer";
        mctsCallResponseDetailUnderTest.setAnswer(answer);
        assertThat(mctsCallResponseDetailUnderTest.getAnswer()).isEqualTo(answer);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        mctsCallResponseDetailUnderTest.setRemarks(remarks);
        assertThat(mctsCallResponseDetailUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testQuestionIDGetterAndSetter() {
        final Integer questionID = 0;
        mctsCallResponseDetailUnderTest.setQuestionID(questionID);
        assertThat(mctsCallResponseDetailUnderTest.getQuestionID()).isEqualTo(questionID);
    }

    @Test
    void testToString() {
        assertThat(mctsCallResponseDetailUnderTest.toString()).isEqualTo("result");
    }
}
