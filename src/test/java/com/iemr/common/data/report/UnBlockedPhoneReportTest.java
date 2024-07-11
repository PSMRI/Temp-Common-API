package com.iemr.common.data.report;

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
class UnBlockedPhoneReportTest {

	@InjectMocks
    private UnBlockedPhoneReport unBlockedPhoneReportUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        unBlockedPhoneReportUnderTest = new UnBlockedPhoneReport();
    }

    @Test
    void testToString() throws Exception {
        assertThat(unBlockedPhoneReportUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testFact_phoneBlockIDGetterAndSetter() {
        final Long fact_phoneBlockID = 0L;
        unBlockedPhoneReportUnderTest.setFact_phoneBlockID(fact_phoneBlockID);
        assertThat(unBlockedPhoneReportUnderTest.getFact_phoneBlockID()).isEqualTo(fact_phoneBlockID);
    }

    @Test
    void testPhoneBlockIDGetterAndSetter() {
        final Long phoneBlockID = 0L;
        unBlockedPhoneReportUnderTest.setPhoneBlockID(phoneBlockID);
        assertThat(unBlockedPhoneReportUnderTest.getPhoneBlockID()).isEqualTo(phoneBlockID);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        unBlockedPhoneReportUnderTest.setPhoneNo(phoneNo);
        assertThat(unBlockedPhoneReportUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        unBlockedPhoneReportUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(unBlockedPhoneReportUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testNoOfNuisanceCallGetterAndSetter() {
        final Integer noOfNuisanceCall = 0;
        unBlockedPhoneReportUnderTest.setNoOfNuisanceCall(noOfNuisanceCall);
        assertThat(unBlockedPhoneReportUnderTest.getNoOfNuisanceCall()).isEqualTo(noOfNuisanceCall);
    }

    @Test
    void testIsBlockedGetterAndSetter() {
        final Boolean isBlocked = false;
        unBlockedPhoneReportUnderTest.setIsBlocked(isBlocked);
        assertThat(unBlockedPhoneReportUnderTest.getIsBlocked()).isFalse();
    }

    @Test
    void testBlockStartDateGetterAndSetter() {
        final Timestamp blockStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        unBlockedPhoneReportUnderTest.setBlockStartDate(blockStartDate);
        assertThat(unBlockedPhoneReportUnderTest.getBlockStartDate()).isEqualTo(blockStartDate);
    }

    @Test
    void testBlockEndDateGetterAndSetter() {
        final Timestamp blockEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        unBlockedPhoneReportUnderTest.setBlockEndDate(blockEndDate);
        assertThat(unBlockedPhoneReportUnderTest.getBlockEndDate()).isEqualTo(blockEndDate);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        unBlockedPhoneReportUnderTest.setDeleted(deleted);
        assertThat(unBlockedPhoneReportUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        unBlockedPhoneReportUnderTest.setCreatedBy(createdBy);
        assertThat(unBlockedPhoneReportUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        unBlockedPhoneReportUnderTest.setCreatedDate(createdDate);
        assertThat(unBlockedPhoneReportUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        unBlockedPhoneReportUnderTest.setModifiedBy(modifiedBy);
        assertThat(unBlockedPhoneReportUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        unBlockedPhoneReportUnderTest.setLastModDate(lastModDate);
        assertThat(unBlockedPhoneReportUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        unBlockedPhoneReportUnderTest.setOutputMapper(outputMapper);
        assertThat(unBlockedPhoneReportUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(unBlockedPhoneReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(unBlockedPhoneReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(unBlockedPhoneReportUnderTest.hashCode()).isEqualTo(0);
    }
}
