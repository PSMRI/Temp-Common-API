package com.iemr.common.data.helpline104history;

import com.iemr.common.data.institute.Institute;
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
class RequestedInstitutionTest {

	@InjectMocks
    private RequestedInstitution requestedInstitutionUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        requestedInstitutionUnderTest = new RequestedInstitution();
    }

    @Test
    void testOrganDonationIDGetterAndSetter() {
        final Long organDonationID = 0L;
        requestedInstitutionUnderTest.setOrganDonationID(organDonationID);
        assertThat(requestedInstitutionUnderTest.getOrganDonationID()).isEqualTo(organDonationID);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        requestedInstitutionUnderTest.setCreatedBy(createdBy);
        assertThat(requestedInstitutionUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testToString() throws Exception {
        assertThat(requestedInstitutionUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testRequestedInstitutionIDGetterAndSetter() {
        final Long requestedInstitutionID = 0L;
        requestedInstitutionUnderTest.setRequestedInstitutionID(requestedInstitutionID);
        assertThat(requestedInstitutionUnderTest.getRequestedInstitutionID()).isEqualTo(requestedInstitutionID);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Integer institutionID = 0;
        requestedInstitutionUnderTest.setInstitutionID(institutionID);
        assertThat(requestedInstitutionUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstituteGetterAndSetter() {
        final Institute institute = new Institute(0, "institutionName", 0, 0, 0);
        requestedInstitutionUnderTest.setInstitute(institute);
        assertThat(requestedInstitutionUnderTest.getInstitute()).isEqualTo(institute);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        requestedInstitutionUnderTest.setDeleted(deleted);
        assertThat(requestedInstitutionUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        requestedInstitutionUnderTest.setCreatedDate(createdDate);
        assertThat(requestedInstitutionUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        requestedInstitutionUnderTest.setModifiedBy(modifiedBy);
        assertThat(requestedInstitutionUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        requestedInstitutionUnderTest.setLastModDate(lastModDate);
        assertThat(requestedInstitutionUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        requestedInstitutionUnderTest.setOutputMapper(outputMapper);
        assertThat(requestedInstitutionUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(requestedInstitutionUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(requestedInstitutionUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(requestedInstitutionUnderTest.hashCode()).isEqualTo(0);
    }
}
