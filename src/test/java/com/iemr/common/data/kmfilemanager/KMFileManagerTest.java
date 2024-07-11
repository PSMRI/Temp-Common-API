package com.iemr.common.data.kmfilemanager;

import com.iemr.common.data.notification.Notification;
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
class KMFileManagerTest {

	@InjectMocks
    private KMFileManager kmFileManagerUnderTest;

    @BeforeEach
    void setUp() {
        kmFileManagerUnderTest = new KMFileManager(0, 0, "fileUID", "fileName", "fileExtension", "versionNo",
                "fileCheckSum", "kmUploadStatus", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), false, "createdBy");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        kmFileManagerUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(kmFileManagerUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testKmFileManagerIDGetterAndSetter() {
        final Integer kmFileManagerID = 0;
        kmFileManagerUnderTest.setKmFileManagerID(kmFileManagerID);
        assertThat(kmFileManagerUnderTest.getKmFileManagerID()).isEqualTo(kmFileManagerID);
    }

    @Test
    void testFileUIDGetterAndSetter() {
        final String fileUID = "fileUID";
        kmFileManagerUnderTest.setFileUID(fileUID);
        assertThat(kmFileManagerUnderTest.getFileUID()).isEqualTo(fileUID);
    }

    @Test
    void testFileNameGetterAndSetter() {
        final String fileName = "fileName";
        kmFileManagerUnderTest.setFileName(fileName);
        assertThat(kmFileManagerUnderTest.getFileName()).isEqualTo(fileName);
    }

    @Test
    void testFileExtensionGetterAndSetter() {
        final String fileExtension = "fileExtension";
        kmFileManagerUnderTest.setFileExtension(fileExtension);
        assertThat(kmFileManagerUnderTest.getFileExtension()).isEqualTo(fileExtension);
    }

    @Test
    void testVersionNoGetterAndSetter() {
        final String versionNo = "versionNo";
        kmFileManagerUnderTest.setVersionNo(versionNo);
        assertThat(kmFileManagerUnderTest.getVersionNo()).isEqualTo(versionNo);
    }

    @Test
    void testFileCheckSumGetterAndSetter() {
        final String fileCheckSum = "fileCheckSum";
        kmFileManagerUnderTest.setFileCheckSum(fileCheckSum);
        assertThat(kmFileManagerUnderTest.getFileCheckSum()).isEqualTo(fileCheckSum);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        kmFileManagerUnderTest.setUserID(userID);
        assertThat(kmFileManagerUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testKmUploadStatusGetterAndSetter() {
        final String kmUploadStatus = "kmUploadStatus";
        kmFileManagerUnderTest.setKmUploadStatus(kmUploadStatus);
        assertThat(kmFileManagerUnderTest.getKmUploadStatus()).isEqualTo(kmUploadStatus);
    }

    @Test
    void testValidFromGetterAndSetter() {
        final Timestamp validFrom = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        kmFileManagerUnderTest.setValidFrom(validFrom);
        assertThat(kmFileManagerUnderTest.getValidFrom()).isEqualTo(validFrom);
    }

    @Test
    void testValidUptoGetterAndSetter() {
        final Timestamp validUpto = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        kmFileManagerUnderTest.setValidUpto(validUpto);
        assertThat(kmFileManagerUnderTest.getValidUpto()).isEqualTo(validUpto);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        kmFileManagerUnderTest.setDeleted(deleted);
        assertThat(kmFileManagerUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        kmFileManagerUnderTest.setCreatedBy(createdBy);
        assertThat(kmFileManagerUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        kmFileManagerUnderTest.setCreatedDate(createdDate);
        assertThat(kmFileManagerUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        kmFileManagerUnderTest.setModifiedBy(modifiedBy);
        assertThat(kmFileManagerUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        kmFileManagerUnderTest.setLastModDate(lastModDate);
        assertThat(kmFileManagerUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        kmFileManagerUnderTest.setOutputMapper(outputMapper);
        assertThat(kmFileManagerUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testCategoryIDGetterAndSetter() {
        final Integer categoryID = 0;
        kmFileManagerUnderTest.setCategoryID(categoryID);
        assertThat(kmFileManagerUnderTest.getCategoryID()).isEqualTo(categoryID);
    }

    @Test
    void testSubCategoryIDGetterAndSetter() {
        final Integer subCategoryID = 0;
        kmFileManagerUnderTest.setSubCategoryID(subCategoryID);
        assertThat(kmFileManagerUnderTest.getSubCategoryID()).isEqualTo(subCategoryID);
    }

    @Test
    void testFileContentGetterAndSetter() {
        final String fileContent = "fileContent";
        kmFileManagerUnderTest.setFileContent(fileContent);
        assertThat(kmFileManagerUnderTest.getFileContent()).isEqualTo(fileContent);
    }

    @Test
    void testToString() {
        assertThat(kmFileManagerUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testNotificationGetterAndSetter() {
        final Notification notification = new Notification();
        kmFileManagerUnderTest.setNotification(notification);
        assertThat(kmFileManagerUnderTest.getNotification()).isEqualTo(notification);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        kmFileManagerUnderTest.setVanID(vanID);
        assertThat(kmFileManagerUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testEquals() {
        assertThat(kmFileManagerUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(kmFileManagerUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(kmFileManagerUnderTest.hashCode()).isEqualTo(0);
    }
}
