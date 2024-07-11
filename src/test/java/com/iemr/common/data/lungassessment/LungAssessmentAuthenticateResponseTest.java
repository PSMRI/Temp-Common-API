package com.iemr.common.data.lungassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LungAssessmentAuthenticateResponseTest {

	@InjectMocks
    private LungAssessmentAuthenticateResponse lungAssessmentAuthenticateResponseUnderTest;

    @BeforeEach
    void setUp() {
        lungAssessmentAuthenticateResponseUnderTest = new LungAssessmentAuthenticateResponse();
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        lungAssessmentAuthenticateResponseUnderTest.setStatus(status);
        assertThat(lungAssessmentAuthenticateResponseUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testAccessTokenGetterAndSetter() {
        final String accessToken = "accessToken";
        lungAssessmentAuthenticateResponseUnderTest.setAccessToken(accessToken);
        assertThat(lungAssessmentAuthenticateResponseUnderTest.getAccessToken()).isEqualTo(accessToken);
    }

    @Test
    void testToString() {
        assertThat(lungAssessmentAuthenticateResponseUnderTest.toString()).isEqualTo("result");
    }
}
