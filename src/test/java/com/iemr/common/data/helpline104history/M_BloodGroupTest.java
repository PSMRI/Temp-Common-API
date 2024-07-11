package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_BloodGroupTest {

	@InjectMocks
    private M_BloodGroup mBloodGroupUnderTest;

    @BeforeEach
    void setUp() {
        mBloodGroupUnderTest = new M_BloodGroup(0, "bloodGroup", "bloodGroupDesc");
    }

    @Test
    void testToString() {
        assertThat(mBloodGroupUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testBloodGroupGetterAndSetter() {
        final String bloodGroup = "bloodGroup";
        mBloodGroupUnderTest.setBloodGroup(bloodGroup);
        assertThat(mBloodGroupUnderTest.getBloodGroup()).isEqualTo(bloodGroup);
    }

    @Test
    void testBloodGroupDescGetterAndSetter() {
        final String bloodGroupDesc = "bloodGroupDesc";
        mBloodGroupUnderTest.setBloodGroupDesc(bloodGroupDesc);
        assertThat(mBloodGroupUnderTest.getBloodGroupDesc()).isEqualTo(bloodGroupDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mBloodGroupUnderTest.setDeleted(deleted);
        assertThat(mBloodGroupUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mBloodGroupUnderTest.setCreatedBy(createdBy);
        assertThat(mBloodGroupUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        mBloodGroupUnderTest.setCreatedDate(createdDate);
        assertThat(mBloodGroupUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mBloodGroupUnderTest.setModifiedBy(modifiedBy);
        assertThat(mBloodGroupUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        mBloodGroupUnderTest.setLastModDate(lastModDate);
        assertThat(mBloodGroupUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testGetBloodGroupID() {
        assertThat(mBloodGroupUnderTest.getBloodGroupID()).isEqualTo(0);
    }
}
