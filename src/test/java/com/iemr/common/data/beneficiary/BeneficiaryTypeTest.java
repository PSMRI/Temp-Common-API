package com.iemr.common.data.beneficiary;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class BeneficiaryTypeTest {

	@InjectMocks
    private BeneficiaryType beneficiaryTypeUnderTest;

    @BeforeEach
    void setUp() {
        beneficiaryTypeUnderTest = new BeneficiaryType((short) 0, "beneficiaryType", false, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testBeneficiaryTypeIDGetterAndSetter() {
        final Short beneficiaryTypeID = (short) 0;
        beneficiaryTypeUnderTest.setBeneficiaryTypeID(beneficiaryTypeID);
        assertThat(beneficiaryTypeUnderTest.getBeneficiaryTypeID()).isEqualTo(beneficiaryTypeID);
    }

    @Test
    void testBeneficiaryTypeGetterAndSetter() {
        final String beneficiaryType = "beneficiaryType";
        beneficiaryTypeUnderTest.setBeneficiaryType(beneficiaryType);
        assertThat(beneficiaryTypeUnderTest.getBeneficiaryType()).isEqualTo(beneficiaryType);
    }

    @Test
    void testIsDeleted() {
        assertThat(beneficiaryTypeUnderTest.isDeleted()).isFalse();
    }

    @Test
    void testSetDeleted() {
        // Setup
        // Run the test
        beneficiaryTypeUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        beneficiaryTypeUnderTest.setCreatedBy(createdBy);
        assertThat(beneficiaryTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryTypeUnderTest.setCreatedDate(createdDate);
        assertThat(beneficiaryTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        beneficiaryTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(beneficiaryTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        beneficiaryTypeUnderTest.setLastModDate(lastModDate);
        assertThat(beneficiaryTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        BeneficiaryType beneficiaryType = new BeneficiaryType();
        String expectedJson = "{\"beneficiaryTypeID\":0,\"beneficiaryType\":\"beneficiaryType\",\"deleted\":false,\"createdBy\":\"createdBy\",\"createdDate\":null,\"modifiedBy\":null,\"lastModDate\":null}";
        assertThat(beneficiaryType.toString()).isEqualTo(expectedJson);
    }


    @Test
    void testGetDeleted() {
        assertThat(beneficiaryTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        beneficiaryTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(beneficiaryTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(beneficiaryTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(beneficiaryTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(beneficiaryTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
