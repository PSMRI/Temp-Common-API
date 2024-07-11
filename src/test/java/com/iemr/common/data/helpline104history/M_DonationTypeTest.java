package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_DonationTypeTest {

	@InjectMocks
    private M_DonationType mDonationTypeUnderTest;

    @BeforeEach
    void setUp() {
        mDonationTypeUnderTest = new M_DonationType(0, "donationType", "donationTypeDesc");
    }

    @Test
    void testDonationTypeGetterAndSetter() {
        final String donationType = "donationType";
        mDonationTypeUnderTest.setDonationType(donationType);
        assertThat(mDonationTypeUnderTest.getDonationType()).isEqualTo(donationType);
    }

    @Test
    void testDonationTypeDescGetterAndSetter() {
        final String donationTypeDesc = "donationTypeDesc";
        mDonationTypeUnderTest.setDonationTypeDesc(donationTypeDesc);
        assertThat(mDonationTypeUnderTest.getDonationTypeDesc()).isEqualTo(donationTypeDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mDonationTypeUnderTest.setDeleted(deleted);
        assertThat(mDonationTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mDonationTypeUnderTest.setCreatedBy(createdBy);
        assertThat(mDonationTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mDonationTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(mDonationTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testGetDonationTypeID() {
        assertThat(mDonationTypeUnderTest.getDonationTypeID()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(mDonationTypeUnderTest.toString()).isEqualTo("result");
    }
}
