package com.iemr.common.data.helpline104history;

import com.iemr.common.data.location.Districts;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class T_BloodRequestTest {

	@InjectMocks
    private T_BloodRequest tBloodRequestUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tBloodRequestUnderTest = new T_BloodRequest();
    }

    @Test
    void testToString() throws Exception {
        assertThat(tBloodRequestUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testBloodReqIDGetterAndSetter() {
        final Long bloodReqID = 0L;
        tBloodRequestUnderTest.setBloodReqID(bloodReqID);
        assertThat(tBloodRequestUnderTest.getBloodReqID()).isEqualTo(bloodReqID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        tBloodRequestUnderTest.setRequestID(requestID);
        assertThat(tBloodRequestUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        tBloodRequestUnderTest.setBenCallID(benCallID);
        assertThat(tBloodRequestUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        tBloodRequestUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(tBloodRequestUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testRecipientBeneficiaryIDGetterAndSetter() {
        final Long recipientBeneficiaryID = 0L;
        tBloodRequestUnderTest.setRecipientBeneficiaryID(recipientBeneficiaryID);
        assertThat(tBloodRequestUnderTest.getRecipientBeneficiaryID()).isEqualTo(recipientBeneficiaryID);
    }

    @Test
    void testRecipientNameGetterAndSetter() {
        final String recipientName = "recipientName";
        tBloodRequestUnderTest.setRecipientName(recipientName);
        assertThat(tBloodRequestUnderTest.getRecipientName()).isEqualTo(recipientName);
    }

    @Test
    void testRecipientAgeGetterAndSetter() {
        final Integer recipientAge = 0;
        tBloodRequestUnderTest.setRecipientAge(recipientAge);
        assertThat(tBloodRequestUnderTest.getRecipientAge()).isEqualTo(recipientAge);
    }

    @Test
    void testRecipientGenderIDGetterAndSetter() {
        final Short recipientGenderID = (short) 0;
        tBloodRequestUnderTest.setRecipientGenderID(recipientGenderID);
        assertThat(tBloodRequestUnderTest.getRecipientGenderID()).isEqualTo(recipientGenderID);
    }

    @Test
    void testTypeOfRequestGetterAndSetter() {
        final String typeOfRequest = "typeOfRequest";
        tBloodRequestUnderTest.setTypeOfRequest(typeOfRequest);
        assertThat(tBloodRequestUnderTest.getTypeOfRequest()).isEqualTo(typeOfRequest);
    }

    @Test
    void testBloodGroupIDGetterAndSetter() {
        final Integer bloodGroupID = 0;
        tBloodRequestUnderTest.setBloodGroupID(bloodGroupID);
        assertThat(tBloodRequestUnderTest.getBloodGroupID()).isEqualTo(bloodGroupID);
    }

    @Test
    void testM_bloodGroupGetterAndSetter() {
        final M_BloodGroup m_bloodGroup = new M_BloodGroup(0, "bloodGroup", "bloodGroupDesc");
        tBloodRequestUnderTest.setM_bloodGroup(m_bloodGroup);
        assertThat(tBloodRequestUnderTest.getM_bloodGroup()).isEqualTo(m_bloodGroup);
    }

    @Test
    void testComponentTypeIDGetterAndSetter() {
        final Integer componentTypeID = 0;
        tBloodRequestUnderTest.setComponentTypeID(componentTypeID);
        assertThat(tBloodRequestUnderTest.getComponentTypeID()).isEqualTo(componentTypeID);
    }

    @Test
    void testM_componentTypeGetterAndSetter() {
        final M_ComponentType m_componentType = new M_ComponentType(0, "componentType", "componentTypeDesc");
        tBloodRequestUnderTest.setM_componentType(m_componentType);
        assertThat(tBloodRequestUnderTest.getM_componentType()).isEqualTo(m_componentType);
    }

    @Test
    void testUnitRequiredGetterAndSetter() {
        final String unitRequired = "unitRequired";
        tBloodRequestUnderTest.setUnitRequired(unitRequired);
        assertThat(tBloodRequestUnderTest.getUnitRequired()).isEqualTo(unitRequired);
    }

    @Test
    void testHospitalAdmittedGetterAndSetter() {
        final String hospitalAdmitted = "hospitalAdmitted";
        tBloodRequestUnderTest.setHospitalAdmitted(hospitalAdmitted);
        assertThat(tBloodRequestUnderTest.getHospitalAdmitted()).isEqualTo(hospitalAdmitted);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        tBloodRequestUnderTest.setDistrictID(districtID);
        assertThat(tBloodRequestUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testM_districtGetterAndSetter() {
        final Districts m_district = new Districts(0, "DistrictName", 0, "stateName");
        tBloodRequestUnderTest.setM_district(m_district);
        assertThat(tBloodRequestUnderTest.getM_district()).isEqualTo(m_district);
    }

    @Test
    void testOutboundNeededGetterAndSetter() {
        final Boolean outboundNeeded = false;
        tBloodRequestUnderTest.setOutboundNeeded(outboundNeeded);
        assertThat(tBloodRequestUnderTest.getOutboundNeeded()).isFalse();
    }

    @Test
    void testOutboundDateGetterAndSetter() {
        final Timestamp outboundDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tBloodRequestUnderTest.setOutboundDate(outboundDate);
        assertThat(tBloodRequestUnderTest.getOutboundDate()).isEqualTo(outboundDate);
    }

    @Test
    void testBloodBankAddressGetterAndSetter() {
        final String bloodBankAddress = "bloodBankAddress";
        tBloodRequestUnderTest.setBloodBankAddress(bloodBankAddress);
        assertThat(tBloodRequestUnderTest.getBloodBankAddress()).isEqualTo(bloodBankAddress);
    }

    @Test
    void testBbPersonNameGetterAndSetter() {
        final String bbPersonName = "bbPersonName";
        tBloodRequestUnderTest.setBbPersonName(bbPersonName);
        assertThat(tBloodRequestUnderTest.getBbPersonName()).isEqualTo(bbPersonName);
    }

    @Test
    void testBbPersonDesignationGetterAndSetter() {
        final String bbPersonDesignation = "bbPersonDesignation";
        tBloodRequestUnderTest.setBbPersonDesignation(bbPersonDesignation);
        assertThat(tBloodRequestUnderTest.getBbPersonDesignation()).isEqualTo(bbPersonDesignation);
    }

    @Test
    void testBbMobileNoGetterAndSetter() {
        final String bbMobileNo = "bbMobileNo";
        tBloodRequestUnderTest.setBbMobileNo(bbMobileNo);
        assertThat(tBloodRequestUnderTest.getBbMobileNo()).isEqualTo(bbMobileNo);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        tBloodRequestUnderTest.setRemarks(remarks);
        assertThat(tBloodRequestUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testFeedbackGetterAndSetter() {
        final String feedback = "feedback";
        tBloodRequestUnderTest.setFeedback(feedback);
        assertThat(tBloodRequestUnderTest.getFeedback()).isEqualTo(feedback);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        tBloodRequestUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(tBloodRequestUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        tBloodRequestUnderTest.setCreatedDate(createdDate);
        assertThat(tBloodRequestUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        tBloodRequestUnderTest.setDeleted(deleted);
        assertThat(tBloodRequestUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        tBloodRequestUnderTest.setOutputMapper(outputMapper);
        assertThat(tBloodRequestUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(tBloodRequestUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(tBloodRequestUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(tBloodRequestUnderTest.hashCode()).isEqualTo(0);
    }
}
