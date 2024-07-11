package com.iemr.common.data.helpline104history;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.directory.SubDirectory;
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
class DirectoryserviceTest {

	@InjectMocks
    private Directoryservice directoryserviceUnderTest;

    @BeforeEach
    void setUp() {
        directoryserviceUnderTest = new Directoryservice();
    }

    @Test
    void testToString() {
        assertThat(directoryserviceUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testDirectoryServiceIDGetterAndSetter() {
        final Long directoryServiceID = 0L;
        directoryserviceUnderTest.setDirectoryServiceID(directoryServiceID);
        assertThat(directoryserviceUnderTest.getDirectoryServiceID()).isEqualTo(directoryServiceID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        directoryserviceUnderTest.setRequestID(requestID);
        assertThat(directoryserviceUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        directoryserviceUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(directoryserviceUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        directoryserviceUnderTest.setBenCallID(benCallID);
        assertThat(directoryserviceUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Integer institutionID = 0;
        directoryserviceUnderTest.setInstitutionID(institutionID);
        assertThat(directoryserviceUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstituteGetterAndSetter() {
        final Institute institute = new Institute(0, "institutionName", 0, 0, 0);
        directoryserviceUnderTest.setInstitute(institute);
        assertThat(directoryserviceUnderTest.getInstitute()).isEqualTo(institute);
    }

    @Test
    void testInstituteDirectoryIDGetterAndSetter() {
        final Integer instituteDirectoryID = 0;
        directoryserviceUnderTest.setInstituteDirectoryID(instituteDirectoryID);
        assertThat(directoryserviceUnderTest.getInstituteDirectoryID()).isEqualTo(instituteDirectoryID);
    }

    @Test
    void testInstituteDirectoryGetterAndSetter() {
        final Directory instituteDirectory = new Directory(0, "directoryName");
        directoryserviceUnderTest.setInstituteDirectory(instituteDirectory);
        assertThat(directoryserviceUnderTest.getInstituteDirectory()).isEqualTo(instituteDirectory);
    }

    @Test
    void testInstituteSubDirectoryIDGetterAndSetter() {
        final Integer instituteSubDirectoryID = 0;
        directoryserviceUnderTest.setInstituteSubDirectoryID(instituteSubDirectoryID);
        assertThat(directoryserviceUnderTest.getInstituteSubDirectoryID()).isEqualTo(instituteSubDirectoryID);
    }

    @Test
    void testInstituteSubDirectoryGetterAndSetter() {
        final SubDirectory instituteSubDirectory = new SubDirectory(0, 0, "instituteSubDirectoryName");
        directoryserviceUnderTest.setInstituteSubDirectory(instituteSubDirectory);
        assertThat(directoryserviceUnderTest.getInstituteSubDirectory()).isEqualTo(instituteSubDirectory);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        directoryserviceUnderTest.setRemarks(remarks);
        assertThat(directoryserviceUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        directoryserviceUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(directoryserviceUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        directoryserviceUnderTest.setDeleted(deleted);
        assertThat(directoryserviceUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        directoryserviceUnderTest.setProcessed(processed);
        assertThat(directoryserviceUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        directoryserviceUnderTest.setCreatedBy(createdBy);
        assertThat(directoryserviceUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        directoryserviceUnderTest.setCreatedDate(createdDate);
        assertThat(directoryserviceUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        directoryserviceUnderTest.setModifiedBy(modifiedBy);
        assertThat(directoryserviceUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        directoryserviceUnderTest.setLastModDate(lastModDate);
        assertThat(directoryserviceUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        directoryserviceUnderTest.setOutputMapper(outputMapper);
        assertThat(directoryserviceUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(directoryserviceUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(directoryserviceUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(directoryserviceUnderTest.hashCode()).isEqualTo(0);
    }
}
