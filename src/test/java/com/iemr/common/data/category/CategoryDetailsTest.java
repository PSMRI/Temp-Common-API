package com.iemr.common.data.category;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CategoryDetailsTest {

	@InjectMocks
    private CategoryDetails categoryDetailsUnderTest;

    @BeforeEach
    void setUp() {
        categoryDetailsUnderTest = new CategoryDetails(0, "CategoryName", false);
    }

    @Test
    void testCategoryIDGetterAndSetter() {
        final Integer categoryID = 0;
        categoryDetailsUnderTest.setCategoryID(categoryID);
        assertThat(categoryDetailsUnderTest.getCategoryID()).isEqualTo(categoryID);
    }

    @Test
    void testSubServiceIDGetterAndSetter() {
        final Integer subServiceID = 0;
        categoryDetailsUnderTest.setSubServiceID(subServiceID);
        assertThat(categoryDetailsUnderTest.getSubServiceID()).isEqualTo(subServiceID);
    }

    @Test
    void testCategoryNameGetterAndSetter() {
        final String categoryName = "CategoryName";
        categoryDetailsUnderTest.setCategoryName(categoryName);
        assertThat(categoryDetailsUnderTest.getCategoryName()).isEqualTo(categoryName);
    }

    @Test
    void testCategoryDescGetterAndSetter() {
        final String categoryDesc = "categoryDesc";
        categoryDetailsUnderTest.setCategoryDesc(categoryDesc);
        assertThat(categoryDetailsUnderTest.getCategoryDesc()).isEqualTo(categoryDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        categoryDetailsUnderTest.setDeleted(deleted);
        assertThat(categoryDetailsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        categoryDetailsUnderTest.setCreatedBy(createdBy);
        assertThat(categoryDetailsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        categoryDetailsUnderTest.setCreatedDate(createdDate);
        assertThat(categoryDetailsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        categoryDetailsUnderTest.setModifiedBy(modifiedBy);
        assertThat(categoryDetailsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        categoryDetailsUnderTest.setLastModDate(lastModDate);
        assertThat(categoryDetailsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        categoryDetailsUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(categoryDetailsUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testFeedbackNatureIDGetterAndSetter() {
        final Integer feedbackNatureID = 0;
        categoryDetailsUnderTest.setFeedbackNatureID(feedbackNatureID);
        assertThat(categoryDetailsUnderTest.getFeedbackNatureID()).isEqualTo(feedbackNatureID);
    }

    @Test
    void testToString() {
        assertThat(categoryDetailsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testIsWellBeingGetterAndSetter() {
        final Boolean isWellBeing = false;
        categoryDetailsUnderTest.setIsWellBeing(isWellBeing);
        assertThat(categoryDetailsUnderTest.getIsWellBeing()).isFalse();
    }

    @Test
    void testSubCategoriesGetterAndSetter() {
        final Set<SubCategoryDetails> subCategories = Set.of(
                new SubCategoryDetails(0, "SubCategoryName", "SubCatFilePath", "fileURL", "fileNameWithExtension"));
        categoryDetailsUnderTest.setSubCategories(subCategories);
        assertThat(categoryDetailsUnderTest.getSubCategories()).isEqualTo(subCategories);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        categoryDetailsUnderTest.setOutputMapper(outputMapper);
        assertThat(categoryDetailsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(categoryDetailsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(categoryDetailsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(categoryDetailsUnderTest.hashCode()).isEqualTo(0);
    }
}
