package com.iemr.common.data.lungassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LungAssessmentValidateCoughReponseDTOTest {

	@InjectMocks
    private LungAssessmentValidateCoughReponseDTO lungAssessmentValidateCoughReponseDTOUnderTest;

    @BeforeEach
    void setUp() {
        lungAssessmentValidateCoughReponseDTOUnderTest = new LungAssessmentValidateCoughReponseDTO();
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        lungAssessmentValidateCoughReponseDTOUnderTest.setStatus(status);
        assertThat(lungAssessmentValidateCoughReponseDTOUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testDataGetterAndSetter() {
        final Map<String, Object> data = Map.ofEntries(Map.entry("value", "value"));
        lungAssessmentValidateCoughReponseDTOUnderTest.setData(data);
        assertThat(lungAssessmentValidateCoughReponseDTOUnderTest.getData()).isEqualTo(data);
    }
}
