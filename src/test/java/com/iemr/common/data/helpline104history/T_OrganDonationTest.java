package com.iemr.common.data.helpline104history;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class T_OrganDonationTest {

	@InjectMocks
    private T_OrganDonation tOrganDonationUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tOrganDonationUnderTest = new T_OrganDonation();
    }

    @Test
    void testToString() throws Exception {
        assertThat(tOrganDonationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOrganDonationIDGetterAndSetter() {
        final Long organDonationID = 0L;
        tOrganDonationUnderTest.setOrganDonationID(organDonationID);
        assertThat(tOrganDonationUnderTest.getOrganDonationID()).isEqualTo(organDonationID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        tOrganDonationUnderTest.setRequestID(requestID);
        assertThat(tOrganDonationUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        tOrganDonationUnderTest.setBenCallID(benCallID);
        assertThat(tOrganDonationUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        tOrganDonationUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(tOrganDonationUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testDonarNameGetterAndSetter() {
        final String donarName = "donarName";
        tOrganDonationUnderTest.setDonarName(donarName);
        assertThat(tOrganDonationUnderTest.getDonarName()).isEqualTo(donarName);
    }

    @Test
    void testDonarAgeGetterAndSetter() {
        final Integer donarAge = 0;
        tOrganDonationUnderTest.setDonarAge(donarAge);
        assertThat(tOrganDonationUnderTest.getDonarAge()).isEqualTo(donarAge);
    }

    @Test
    void testDonarGenderIDGetterAndSetter() {
        final Short donarGenderID = (short) 0;
        tOrganDonationUnderTest.setDonarGenderID(donarGenderID);
        assertThat(tOrganDonationUnderTest.getDonarGenderID()).isEqualTo(donarGenderID);
    }

    @Test
    void testDonationTypeIDGetterAndSetter() {
        final Integer donationTypeID = 0;
        tOrganDonationUnderTest.setDonationTypeID(donationTypeID);
        assertThat(tOrganDonationUnderTest.getDonationTypeID()).isEqualTo(donationTypeID);
    }

    @Test
    void testM_donationTypeGetterAndSetter() {
        final M_DonationType m_donationType = new M_DonationType(0, "donationType", "donationTypeDesc");
        tOrganDonationUnderTest.setM_donationType(m_donationType);
        assertThat(tOrganDonationUnderTest.getM_donationType()).isEqualTo(m_donationType);
    }

    @Test
    void testDonatableOrganIDGetterAndSetter() {
        final Integer donatableOrganID = 0;
        tOrganDonationUnderTest.setDonatableOrganID(donatableOrganID);
        assertThat(tOrganDonationUnderTest.getDonatableOrganID()).isEqualTo(donatableOrganID);
    }

    @Test
    void testM_donatableOrganGetterAndSetter() {
        final M_DonatableOrgan m_donatableOrgan = new M_DonatableOrgan(0, "donatableOrgan", "donatableOrganDesc");
        tOrganDonationUnderTest.setM_donatableOrgan(m_donatableOrgan);
        assertThat(tOrganDonationUnderTest.getM_donatableOrgan()).isEqualTo(m_donatableOrgan);
    }

    @Test
    void testAcceptorHospitalIDGetterAndSetter() {
        final Integer acceptorHospitalID = 0;
        tOrganDonationUnderTest.setAcceptorHospitalID(acceptorHospitalID);
        assertThat(tOrganDonationUnderTest.getAcceptorHospitalID()).isEqualTo(acceptorHospitalID);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        tOrganDonationUnderTest.setRemarks(remarks);
        assertThat(tOrganDonationUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        tOrganDonationUnderTest.setDistrictID(districtID);
        assertThat(tOrganDonationUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        tOrganDonationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(tOrganDonationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testIsSelfGetterAndSetter() {
        final Boolean isSelf = false;
        tOrganDonationUnderTest.setIsSelf(isSelf);
        assertThat(tOrganDonationUnderTest.getIsSelf()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        tOrganDonationUnderTest.setDeleted(deleted);
        assertThat(tOrganDonationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "createdBy";
        tOrganDonationUnderTest.setCreatedBy(createdBy);
        assertThat(tOrganDonationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        tOrganDonationUnderTest.setCreatedDate(createdDate);
        assertThat(tOrganDonationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "modifiedBy";
        tOrganDonationUnderTest.setModifiedBy(modifiedBy);
        assertThat(tOrganDonationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        tOrganDonationUnderTest.setOutputMapper(outputMapper);
        assertThat(tOrganDonationUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(tOrganDonationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(tOrganDonationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(tOrganDonationUnderTest.hashCode()).isEqualTo(0);
    }
}
