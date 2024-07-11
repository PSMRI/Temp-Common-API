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
class BenMedHistoryTest {

	@InjectMocks
    private BenMedHistory benMedHistoryUnderTest;

  
	@Test
	void testToString() {
	    BenMedHistory benMedHistory = new BenMedHistory();
	    String expectedJson = "{\"benMedHistoryID\":null,\"beneficiaryRegID\":null,\"yearofIllness\":null,\"illnessTypeID\":null,\"illnessType\":null,\"surgeryID\":null,\"yearofSurgery\":null,\"deleted\":null,\"createdBy\":null}";
	    assertThat(benMedHistory.toString()).isEqualTo(expectedJson);
	}



    @Test
    void testBenMedHistoryIDGetterAndSetter() {
        final Long benMedHistoryID = 0L;
        benMedHistoryUnderTest.setBenMedHistoryID(benMedHistoryID);
        assertThat(benMedHistoryUnderTest.getBenMedHistoryID()).isEqualTo(benMedHistoryID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        benMedHistoryUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(benMedHistoryUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testI_beneficiaryGetterAndSetter() {
        final Beneficiary i_beneficiary = new Beneficiary();
        benMedHistoryUnderTest.setI_beneficiary(i_beneficiary);
        assertThat(benMedHistoryUnderTest.getI_beneficiary()).isEqualTo(i_beneficiary);
    }

    @Test
    void testYearofIllnessGetterAndSetter() {
        final Timestamp yearofIllness = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benMedHistoryUnderTest.setYearofIllness(yearofIllness);
        assertThat(benMedHistoryUnderTest.getYearofIllness()).isEqualTo(yearofIllness);
    }

    @Test
    void testIllnessTypeIDGetterAndSetter() {
        final Integer illnessTypeID = 0;
        benMedHistoryUnderTest.setIllnessTypeID(illnessTypeID);
        assertThat(benMedHistoryUnderTest.getIllnessTypeID()).isEqualTo(illnessTypeID);
    }

    @Test
    void testIllnessTypeGetterAndSetter() {
        final String illnessType = "illnessType";
        benMedHistoryUnderTest.setIllnessType(illnessType);
        assertThat(benMedHistoryUnderTest.getIllnessType()).isEqualTo(illnessType);
    }

    @Test
    void testSurgeryIDGetterAndSetter() {
        final Integer surgeryID = 0;
        benMedHistoryUnderTest.setSurgeryID(surgeryID);
        assertThat(benMedHistoryUnderTest.getSurgeryID()).isEqualTo(surgeryID);
    }

    @Test
    void testYearofSurgeryGetterAndSetter() {
        final Timestamp yearofSurgery = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benMedHistoryUnderTest.setYearofSurgery(yearofSurgery);
        assertThat(benMedHistoryUnderTest.getYearofSurgery()).isEqualTo(yearofSurgery);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        benMedHistoryUnderTest.setDeleted(deleted);
        assertThat(benMedHistoryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        benMedHistoryUnderTest.setCreatedBy(createdBy);
        assertThat(benMedHistoryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benMedHistoryUnderTest.setCreatedDate(createdDate);
        assertThat(benMedHistoryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        benMedHistoryUnderTest.setModifiedBy(modifiedBy);
        assertThat(benMedHistoryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        benMedHistoryUnderTest.setLastModDate(lastModDate);
        assertThat(benMedHistoryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        benMedHistoryUnderTest.setOutputMapper(outputMapper);
        assertThat(benMedHistoryUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(benMedHistoryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(benMedHistoryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(benMedHistoryUnderTest.hashCode()).isEqualTo(0);
    }
}
