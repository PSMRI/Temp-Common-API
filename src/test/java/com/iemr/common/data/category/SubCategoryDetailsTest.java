package com.iemr.common.data.category;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class SubCategoryDetailsTest {

	@InjectMocks
    private SubCategoryDetails subCategoryDetailsUnderTest;

    @BeforeEach
    void setUp() {
        subCategoryDetailsUnderTest = new SubCategoryDetails(0, "SubCategoryName", "SubCatFilePath", "fileURL",
                "fileNameWithExtension");
    }

    @Test
    void testSubCategoryIDGetterAndSetter() {
        final Integer subCategoryID = 0;
        subCategoryDetailsUnderTest.setSubCategoryID(subCategoryID);
        assertThat(subCategoryDetailsUnderTest.getSubCategoryID()).isEqualTo(subCategoryID);
    }

    @Test
    void testCategoryIDGetterAndSetter() {
        final Integer categoryID = 0;
        subCategoryDetailsUnderTest.setCategoryID(categoryID);
        assertThat(subCategoryDetailsUnderTest.getCategoryID()).isEqualTo(categoryID);
    }

    @Test
    void testSubCategoryNameGetterAndSetter() {
        final String subCategoryName = "SubCategoryName";
        subCategoryDetailsUnderTest.setSubCategoryName(subCategoryName);
        assertThat(subCategoryDetailsUnderTest.getSubCategoryName()).isEqualTo(subCategoryName);
    }

    @Test
    void testSubCategoryDescGetterAndSetter() {
        final String subCategoryDesc = "SubCategoryDesc";
        subCategoryDetailsUnderTest.setSubCategoryDesc(subCategoryDesc);
        assertThat(subCategoryDetailsUnderTest.getSubCategoryDesc()).isEqualTo(subCategoryDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        subCategoryDetailsUnderTest.setDeleted(deleted);
        assertThat(subCategoryDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        subCategoryDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(subCategoryDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subCategoryDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(subCategoryDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        subCategoryDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(subCategoryDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        subCategoryDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(subCategoryDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testSubCatFilePathGetterAndSetter() {
        final String subCatFilePath = "SubCatFilePath";
        subCategoryDetailsUnderTest.setSubCatFilePath(subCatFilePath);
        assertThat(subCategoryDetailsUnderTest.getSubCatFilePath()).isEqualTo(subCatFilePath);
    }

    @Test
    void testFileMangerGetterAndSetter() {
        final ArrayList<KMFileManager> fileManger = new ArrayList<>(List.of(new KMFileManager()));
        subCategoryDetailsUnderTest.setFileManger(fileManger);
        assertThat(subCategoryDetailsUnderTest.getFileManger()).isEqualTo(fileManger);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        subCategoryDetailsUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(subCategoryDetailsUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testToString() {
        assertThat(subCategoryDetailsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCategoryDetailsGetterAndSetter() {
        final CategoryDetails categoryDetails = new CategoryDetails(0, "CategoryName", false);
        subCategoryDetailsUnderTest.setCategoryDetails(categoryDetails);
        assertThat(subCategoryDetailsUnderTest.getCategoryDetails()).isEqualTo(categoryDetails);
    }

    @Test
    void testFileURLGetterAndSetter() {
        final String fileURL = "fileURL";
        subCategoryDetailsUnderTest.setFileURL(fileURL);
        assertThat(subCategoryDetailsUnderTest.getFileURL()).isEqualTo(fileURL);
    }

    @Test
    void testFileNameWithExtensionGetterAndSetter() {
        final String fileNameWithExtension = "fileNameWithExtension";
        subCategoryDetailsUnderTest.setFileNameWithExtension(fileNameWithExtension);
        assertThat(subCategoryDetailsUnderTest.getFileNameWithExtension()).isEqualTo(fileNameWithExtension);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        subCategoryDetailsUnderTest.setOutputMapper(outputMapper);
        assertThat(subCategoryDetailsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(subCategoryDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(subCategoryDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(subCategoryDetailsUnderTest.hashCode()).isEqualTo(0);
    }
}
