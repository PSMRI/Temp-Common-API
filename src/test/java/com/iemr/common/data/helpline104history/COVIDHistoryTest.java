package com.iemr.common.data.helpline104history;

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
class COVIDHistoryTest {

	@InjectMocks
    private COVIDHistory covidHistoryUnderTest;

    @BeforeEach
    void setUp() {
        covidHistoryUnderTest = new COVIDHistory();
    }

    @Test
    void testToString() {
        assertThat(covidHistoryUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCovid19IDGetterAndSetter() {
        final Long covid19ID = 0L;
        covidHistoryUnderTest.setCovid19ID(covid19ID);
        assertThat(covidHistoryUnderTest.getCovid19ID()).isEqualTo(covid19ID);
    }

    @Test
    void testBenHistoryIDGetterAndSetter() {
        final Long benHistoryID = 0L;
        covidHistoryUnderTest.setBenHistoryID(benHistoryID);
        assertThat(covidHistoryUnderTest.getBenHistoryID()).isEqualTo(benHistoryID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        covidHistoryUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(covidHistoryUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        covidHistoryUnderTest.setBenCallID(benCallID);
        assertThat(covidHistoryUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testSymptomsGetterAndSetter() {
        final String symptoms = "symptoms";
        covidHistoryUnderTest.setSymptoms(symptoms);
        assertThat(covidHistoryUnderTest.getSymptoms()).isEqualTo(symptoms);
    }

    @Test
    void testMedical_consultationGetterAndSetter() {
        final Boolean medical_consultation = false;
        covidHistoryUnderTest.setMedical_consultation(medical_consultation);
        assertThat(covidHistoryUnderTest.getMedical_consultation()).isFalse();
    }

    @Test
    void testSuspected_COVID19GetterAndSetter() {
        final Boolean suspected_COVID19 = false;
        covidHistoryUnderTest.setSuspected_COVID19(suspected_COVID19);
        assertThat(covidHistoryUnderTest.getSuspected_COVID19()).isFalse();
    }

    @Test
    void testRecommendationGetterAndSetter() {
        final String recommendation = "recommendation";
        covidHistoryUnderTest.setRecommendation(recommendation);
        assertThat(covidHistoryUnderTest.getRecommendation()).isEqualTo(recommendation);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        covidHistoryUnderTest.setCreatedDate(createdDate);
        assertThat(covidHistoryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        covidHistoryUnderTest.setOutputMapper(outputMapper);
        assertThat(covidHistoryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(covidHistoryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(covidHistoryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(covidHistoryUnderTest.hashCode()).isEqualTo(0);
    }
}
