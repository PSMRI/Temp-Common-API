package com.iemr.common.data.lungassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LungAssessmentResponseDTOTest {

	@InjectMocks
    private LungAssessmentResponseDTO lungAssessmentResponseDTOUnderTest;

    @BeforeEach
    void setUp() {
        lungAssessmentResponseDTOUnderTest = new LungAssessmentResponseDTO();
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        lungAssessmentResponseDTOUnderTest.setStatus(status);
        assertThat(lungAssessmentResponseDTOUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testDataGetterAndSetter() {
        final LungAssessment data = new LungAssessment();
        lungAssessmentResponseDTOUnderTest.setData(data);
        assertThat(lungAssessmentResponseDTOUnderTest.getData()).isEqualTo(data);
    }

    @Test
    void testAssessmentIdGetterAndSetter() {
        final String assessmentId = "assessmentId";
        lungAssessmentResponseDTOUnderTest.setAssessmentId(assessmentId);
        assertThat(lungAssessmentResponseDTOUnderTest.getAssessmentId()).isEqualTo(assessmentId);
    }
}
