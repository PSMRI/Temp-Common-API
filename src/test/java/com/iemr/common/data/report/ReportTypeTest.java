package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ReportTypeTest {

	@InjectMocks
    private ReportType reportTypeUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        reportTypeUnderTest = new ReportType();
    }

    @Test
    void testQAreportTypeIDGetterAndSetter() {
        final Integer qAreportTypeID = 0;
        reportTypeUnderTest.setQAreportTypeID(qAreportTypeID);
        assertThat(reportTypeUnderTest.getQAreportTypeID()).isEqualTo(qAreportTypeID);
    }

    @Test
    void testReportTypeGetterAndSetter() {
        final String reportType = "reportType";
        reportTypeUnderTest.setReportType(reportType);
        assertThat(reportTypeUnderTest.getReportType()).isEqualTo(reportType);
    }

    @Test
    void testReportTypeDescGetterAndSetter() {
        final String reportTypeDesc = "reportTypeDesc";
        reportTypeUnderTest.setReportTypeDesc(reportTypeDesc);
        assertThat(reportTypeUnderTest.getReportTypeDesc()).isEqualTo(reportTypeDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        reportTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(reportTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        reportTypeUnderTest.setDeleted(deleted);
        assertThat(reportTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        reportTypeUnderTest.setCreatedBy(createdBy);
        assertThat(reportTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        reportTypeUnderTest.setCreatedDate(createdDate);
        assertThat(reportTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        reportTypeUnderTest.setProcessed(processed);
        assertThat(reportTypeUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        reportTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(reportTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        reportTypeUnderTest.setLastModDate(lastModDate);
        assertThat(reportTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }
}
