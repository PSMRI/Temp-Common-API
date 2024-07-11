package com.iemr.common.data.lungassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SymptomsDTOTest {

	@InjectMocks
    private SymptomsDTO symptomsDTOUnderTest;

    @BeforeEach
    void setUp() {
        symptomsDTOUnderTest = new SymptomsDTO();
    }

    @Test
    void testFrequent_coughGetterAndSetter() {
        final Integer frequent_cough = 0;
        symptomsDTOUnderTest.setFrequent_cough(frequent_cough);
        assertThat(symptomsDTOUnderTest.getFrequent_cough()).isEqualTo(frequent_cough);
    }

    @Test
    void testSputumGetterAndSetter() {
        final Integer sputum = 0;
        symptomsDTOUnderTest.setSputum(sputum);
        assertThat(symptomsDTOUnderTest.getSputum()).isEqualTo(sputum);
    }

    @Test
    void testCough_at_nightGetterAndSetter() {
        final Integer cough_at_night = 0;
        symptomsDTOUnderTest.setCough_at_night(cough_at_night);
        assertThat(symptomsDTOUnderTest.getCough_at_night()).isEqualTo(cough_at_night);
    }

    @Test
    void testWheezingGetterAndSetter() {
        final Integer wheezing = 0;
        symptomsDTOUnderTest.setWheezing(wheezing);
        assertThat(symptomsDTOUnderTest.getWheezing()).isEqualTo(wheezing);
    }

    @Test
    void testPain_in_chestGetterAndSetter() {
        final Integer pain_in_chest = 0;
        symptomsDTOUnderTest.setPain_in_chest(pain_in_chest);
        assertThat(symptomsDTOUnderTest.getPain_in_chest()).isEqualTo(pain_in_chest);
    }

    @Test
    void testShortness_of_breathGetterAndSetter() {
        final Integer shortness_of_breath = 0;
        symptomsDTOUnderTest.setShortness_of_breath(shortness_of_breath);
        assertThat(symptomsDTOUnderTest.getShortness_of_breath()).isEqualTo(shortness_of_breath);
    }
}
