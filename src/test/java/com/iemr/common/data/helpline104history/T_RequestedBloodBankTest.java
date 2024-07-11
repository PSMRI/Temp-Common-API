package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class T_RequestedBloodBankTest {

	@InjectMocks
    private T_RequestedBloodBank tRequestedBloodBankUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tRequestedBloodBankUnderTest = new T_RequestedBloodBank();
    }

    @Test
    void testRequestedBloodBankIDGetterAndSetter() {
        final Long requestedBloodBankID = 0L;
        tRequestedBloodBankUnderTest.setRequestedBloodBankID(requestedBloodBankID);
        assertThat(tRequestedBloodBankUnderTest.getRequestedBloodBankID()).isEqualTo(requestedBloodBankID);
    }

    @Test
    void testBloodReqIDGetterAndSetter() {
        final Long bloodReqID = 0L;
        tRequestedBloodBankUnderTest.setBloodReqID(bloodReqID);
        assertThat(tRequestedBloodBankUnderTest.getBloodReqID()).isEqualTo(bloodReqID);
    }

    @Test
    void testBloodBankAddressGetterAndSetter() {
        final String bloodBankAddress = "BloodBankAddress";
        tRequestedBloodBankUnderTest.setBloodBankAddress(bloodBankAddress);
        assertThat(tRequestedBloodBankUnderTest.getBloodBankAddress()).isEqualTo(bloodBankAddress);
    }

    @Test
    void testBBPersonNameGetterAndSetter() {
        final String bBPersonName = "BBPersonName";
        tRequestedBloodBankUnderTest.setBBPersonName(bBPersonName);
        assertThat(tRequestedBloodBankUnderTest.getBBPersonName()).isEqualTo(bBPersonName);
    }

    @Test
    void testBBMobileNoGetterAndSetter() {
        final String bBMobileNo = "BBMobileNo";
        tRequestedBloodBankUnderTest.setBBMobileNo(bBMobileNo);
        assertThat(tRequestedBloodBankUnderTest.getBBMobileNo()).isEqualTo(bBMobileNo);
    }

    @Test
    void testBBPersonDesignationGetterAndSetter() {
        final String bBPersonDesignation = "BBPersonDesignation";
        tRequestedBloodBankUnderTest.setBBPersonDesignation(bBPersonDesignation);
        assertThat(tRequestedBloodBankUnderTest.getBBPersonDesignation()).isEqualTo(bBPersonDesignation);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(tRequestedBloodBankUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(tRequestedBloodBankUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(tRequestedBloodBankUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(tRequestedBloodBankUnderTest.toString()).isEqualTo("result");
    }
}
