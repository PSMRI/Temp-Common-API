package com.iemr.common.data.snomedct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SCTDescriptionTest {

	@InjectMocks
    private SCTDescription sctDescriptionUnderTest;

    @BeforeEach
    void setUp() {
        sctDescriptionUnderTest = new SCTDescription("conceptID", "term");
    }

   

    @Test
    void testTermGetterAndSetter() {
        final String term = "term";
        sctDescriptionUnderTest.setTerm(term);
        assertThat(sctDescriptionUnderTest.getTerm()).isEqualTo(term);
    }

    @Test
    void testCaseSignificanceIDGetterAndSetter() {
        final String caseSignificanceID = "caseSignificanceID";
        sctDescriptionUnderTest.setCaseSignificanceID(caseSignificanceID);
        assertThat(sctDescriptionUnderTest.getCaseSignificanceID()).isEqualTo(caseSignificanceID);
    }

    @Test
    void testSctDesIDGetterAndSetter() {
        final Long sctDesID = 0L;
        sctDescriptionUnderTest.setSctDesID(sctDesID);
        assertThat(sctDescriptionUnderTest.getSctDesID()).isEqualTo(sctDesID);
    }

    @Test
    void testActiveGetterAndSetter() {
        final String active = "active";
        sctDescriptionUnderTest.setActive(active);
        assertThat(sctDescriptionUnderTest.getActive()).isEqualTo(active);
    }

    @Test
    void testConceptIDGetterAndSetter() {
        final String conceptID = "conceptID";
        sctDescriptionUnderTest.setConceptID(conceptID);
        assertThat(sctDescriptionUnderTest.getConceptID()).isEqualTo(conceptID);
    }

    @Test
    void testPageNoGetterAndSetter() {
        final Integer pageNo = 0;
        sctDescriptionUnderTest.setPageNo(pageNo);
        assertThat(sctDescriptionUnderTest.getPageNo()).isEqualTo(pageNo);
    }
}
