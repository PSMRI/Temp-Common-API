package com.iemr.common.data.uptsu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SmsRequestOBJTest {

	@InjectMocks
    private SmsRequestOBJ smsRequestOBJUnderTest;

    @BeforeEach
    void setUp() {
        smsRequestOBJUnderTest = new SmsRequestOBJ();
    }

    @Test
    void testChoNameGetterAndSetter() {
        final String choName = "choName";
        smsRequestOBJUnderTest.setChoName(choName);
        assertThat(smsRequestOBJUnderTest.getChoName()).isEqualTo(choName);
    }

    @Test
    void testFacilityPhoneNoGetterAndSetter() {
        final String facilityPhoneNo = "facilityPhoneNo";
        smsRequestOBJUnderTest.setFacilityPhoneNo(facilityPhoneNo);
        assertThat(smsRequestOBJUnderTest.getFacilityPhoneNo()).isEqualTo(facilityPhoneNo);
    }

    @Test
    void testBenPhoneNoGetterAndSetter() {
        final String benPhoneNo = "benPhoneNo";
        smsRequestOBJUnderTest.setBenPhoneNo(benPhoneNo);
        assertThat(smsRequestOBJUnderTest.getBenPhoneNo()).isEqualTo(benPhoneNo);
    }

    @Test
    void testEmployeeCodeGetterAndSetter() {
        final String employeeCode = "employeeCode";
        smsRequestOBJUnderTest.setEmployeeCode(employeeCode);
        assertThat(smsRequestOBJUnderTest.getEmployeeCode()).isEqualTo(employeeCode);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        smsRequestOBJUnderTest.setFacilityName(facilityName);
        assertThat(smsRequestOBJUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testHfrIdGetterAndSetter() {
        final String hfrId = "hfrId";
        smsRequestOBJUnderTest.setHfrId(hfrId);
        assertThat(smsRequestOBJUnderTest.getHfrId()).isEqualTo(hfrId);
    }

    @Test
    void testBeneficiaryNameGetterAndSetter() {
        final String beneficiaryName = "beneficiaryName";
        smsRequestOBJUnderTest.setBeneficiaryName(beneficiaryName);
        assertThat(smsRequestOBJUnderTest.getBeneficiaryName()).isEqualTo(beneficiaryName);
    }

    @Test
    void testBeneficiaryIdGetterAndSetter() {
        final Long beneficiaryId = 0L;
        smsRequestOBJUnderTest.setBeneficiaryId(beneficiaryId);
        assertThat(smsRequestOBJUnderTest.getBeneficiaryId()).isEqualTo(beneficiaryId);
    }

    @Test
    void testSmsTemplateIDGetterAndSetter() {
        final Integer smsTemplateID = 0;
        smsRequestOBJUnderTest.setSmsTemplateID(smsTemplateID);
        assertThat(smsRequestOBJUnderTest.getSmsTemplateID()).isEqualTo(smsTemplateID);
    }

    @Test
    void testChoSmsGetterAndSetter() {
        final String choSms = "choSms";
        smsRequestOBJUnderTest.setChoSms(choSms);
        assertThat(smsRequestOBJUnderTest.getChoSms()).isEqualTo(choSms);
    }

    @Test
    void testBenSmsGetterAndSetter() {
        final String benSms = "benSms";
        smsRequestOBJUnderTest.setBenSms(benSms);
        assertThat(smsRequestOBJUnderTest.getBenSms()).isEqualTo(benSms);
    }

    @Test
    void testSmsTemplateTypeIDGetterAndSetter() {
        final Integer smsTemplateTypeID = 0;
        smsRequestOBJUnderTest.setSmsTemplateTypeID(smsTemplateTypeID);
        assertThat(smsRequestOBJUnderTest.getSmsTemplateTypeID()).isEqualTo(smsTemplateTypeID);
    }

    @Test
    void testAppointmentTimeGetterAndSetter() {
        final String appointmentTime = "appointmentTime";
        smsRequestOBJUnderTest.setAppointmentTime(appointmentTime);
        assertThat(smsRequestOBJUnderTest.getAppointmentTime()).isEqualTo(appointmentTime);
    }

    @Test
    void testAppointmentDateGetterAndSetter() {
        final String appointmentDate = "appointmentDate";
        smsRequestOBJUnderTest.setAppointmentDate(appointmentDate);
        assertThat(smsRequestOBJUnderTest.getAppointmentDate()).isEqualTo(appointmentDate);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        smsRequestOBJUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(smsRequestOBJUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsRequestOBJUnderTest.setCreatedBy(createdBy);
        assertThat(smsRequestOBJUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testEquals() {
        assertThat(smsRequestOBJUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsRequestOBJUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsRequestOBJUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(smsRequestOBJUnderTest.toString()).isEqualTo("result");
    }
}
