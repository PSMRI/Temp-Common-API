package com.iemr.common.data.scheme;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SchemeTest {

    @Mock
    private KMFileManager mockKmFileManager;

    @InjectMocks
    private Scheme schemeUnderTest;

    @BeforeEach
    void setUp() {
        schemeUnderTest = new Scheme(0, "schemeName", "schemeDesc", 0, 0, false, "createdBy", mockKmFileManager);
    }

    @Test
    void testSchemeIDGetterAndSetter() {
        final Integer schemeID = 0;
        schemeUnderTest.setSchemeID(schemeID);
        assertThat(schemeUnderTest.getSchemeID()).isEqualTo(schemeID);
    }

    @Test
    void testSchemeNameGetterAndSetter() {
        final String schemeName = "schemeName";
        schemeUnderTest.setSchemeName(schemeName);
        assertThat(schemeUnderTest.getSchemeName()).isEqualTo(schemeName);
    }

    @Test
    void testSchemeDescGetterAndSetter() {
        final String schemeDesc = "schemeDesc";
        schemeUnderTest.setSchemeDesc(schemeDesc);
        assertThat(schemeUnderTest.getSchemeDesc()).isEqualTo(schemeDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        schemeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(schemeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        schemeUnderTest.setDeleted(deleted);
        assertThat(schemeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        schemeUnderTest.setCreatedBy(createdBy);
        assertThat(schemeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        schemeUnderTest.setCreatedDate(createdDate);
        assertThat(schemeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        schemeUnderTest.setModifiedBy(modifiedBy);
        assertThat(schemeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        schemeUnderTest.setLastModDate(lastModDate);
        assertThat(schemeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testKmFileManagerIDGetterAndSetter() {
        final Integer kmFileManagerID = 0;
        schemeUnderTest.setKmFileManagerID(kmFileManagerID);
        assertThat(schemeUnderTest.getKmFileManagerID()).isEqualTo(kmFileManagerID);
    }

    @Test
    void testKmFileManagerGetterAndSetter() {
        final KMFileManager kmFileManager = new KMFileManager();
        schemeUnderTest.setKmFileManager(kmFileManager);
        assertThat(schemeUnderTest.getKmFileManager()).isEqualTo(kmFileManager);
    }

    @Test
    void testKmFilePathGetterAndSetter() {
        final String kmFilePath = "kmFilePath";
        schemeUnderTest.setKmFilePath(kmFilePath);
        assertThat(schemeUnderTest.getKmFilePath()).isEqualTo(kmFilePath);
    }

    @Test
    void testToString() {
        assertThat(schemeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        schemeUnderTest.setOutputMapper(outputMapper);
        assertThat(schemeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(schemeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(schemeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(schemeUnderTest.hashCode()).isEqualTo(0);
    }
}
