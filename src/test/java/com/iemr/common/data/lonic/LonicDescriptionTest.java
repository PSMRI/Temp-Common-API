package com.iemr.common.data.lonic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LonicDescriptionTest {

	@InjectMocks
    private LonicDescription lonicDescriptionUnderTest;

    @BeforeEach
    void setUp() {
        lonicDescriptionUnderTest = new LonicDescription();
    }

    @Test
    void testTermGetterAndSetter() {
        final String term = "term";
        lonicDescriptionUnderTest.setTerm(term);
        assertThat(lonicDescriptionUnderTest.getTerm()).isEqualTo(term);
    }

    @Test
    void testLoinc_NumGetterAndSetter() {
        final String loinc_Num = "loinc_Num";
        lonicDescriptionUnderTest.setLoinc_Num(loinc_Num);
        assertThat(lonicDescriptionUnderTest.getLoinc_Num()).isEqualTo(loinc_Num);
    }

    @Test
    void testComponentGetterAndSetter() {
        final String component = "component";
        lonicDescriptionUnderTest.setComponent(component);
        assertThat(lonicDescriptionUnderTest.getComponent()).isEqualTo(component);
    }

    @Test
    void testSystemGetterAndSetter() {
        final String system = "system";
        lonicDescriptionUnderTest.setSystem(system);
        assertThat(lonicDescriptionUnderTest.getSystem()).isEqualTo(system);
    }

    @Test
    void testClass1GetterAndSetter() {
        final String class1 = "class1";
        lonicDescriptionUnderTest.setClass1(class1);
        assertThat(lonicDescriptionUnderTest.getClass1()).isEqualTo(class1);
    }

    @Test
    void testLong_common_nameGetterAndSetter() {
        final String long_common_name = "long_common_name";
        lonicDescriptionUnderTest.setLong_common_name(long_common_name);
        assertThat(lonicDescriptionUnderTest.getLong_common_name()).isEqualTo(long_common_name);
    }

    @Test
    void testPageNoGetterAndSetter() {
        final Integer pageNo = 0;
        lonicDescriptionUnderTest.setPageNo(pageNo);
        assertThat(lonicDescriptionUnderTest.getPageNo()).isEqualTo(pageNo);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        lonicDescriptionUnderTest.setStatus(status);
        assertThat(lonicDescriptionUnderTest.getStatus()).isEqualTo(status);
    }
}
