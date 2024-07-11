package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_104drugmappingTest {

	@InjectMocks
    private M_104drugmapping m104drugmappingUnderTest;

    @BeforeEach
    void setUp() {
        m104drugmappingUnderTest = new M_104drugmapping();
    }

    @Test
    void testToString() {
        assertThat(m104drugmappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDrugMapIDGetterAndSetter() {
        final Integer drugMapID = 0;
        m104drugmappingUnderTest.setDrugMapID(drugMapID);
        assertThat(m104drugmappingUnderTest.getDrugMapID()).isEqualTo(drugMapID);
    }

    @Test
    void testDrugIdGetterAndSetter() {
        final Integer drugId = 0;
        m104drugmappingUnderTest.setDrugId(drugId);
        assertThat(m104drugmappingUnderTest.getDrugId()).isEqualTo(drugId);
    }

    @Test
    void testDrugNameGetterAndSetter() {
        final String drugName = "drugName";
        m104drugmappingUnderTest.setDrugName(drugName);
        assertThat(m104drugmappingUnderTest.getDrugName()).isEqualTo(drugName);
    }

    @Test
    void testDrugGroupIDGetterAndSetter() {
        final Integer drugGroupID = 0;
        m104drugmappingUnderTest.setDrugGroupID(drugGroupID);
        assertThat(m104drugmappingUnderTest.getDrugGroupID()).isEqualTo(drugGroupID);
    }

    @Test
    void testDrugGroupNameGetterAndSetter() {
        final String drugGroupName = "drugGroupName";
        m104drugmappingUnderTest.setDrugGroupName(drugGroupName);
        assertThat(m104drugmappingUnderTest.getDrugGroupName()).isEqualTo(drugGroupName);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        m104drugmappingUnderTest.setRemarks(remarks);
        assertThat(m104drugmappingUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        m104drugmappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(m104drugmappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        m104drugmappingUnderTest.setDeleted(deleted);
        assertThat(m104drugmappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testEquals() {
        assertThat(m104drugmappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(m104drugmappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(m104drugmappingUnderTest.hashCode()).isEqualTo(0);
    }
}
