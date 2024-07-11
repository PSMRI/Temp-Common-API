package com.iemr.common.service.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.repository.category.SubCategoryRepository;

@ExtendWith(MockitoExtension.class)
class SubCategoryServiceImplTest {

    @Mock
    private SubCategoryRepository subCategoryRepository;

    @InjectMocks
    private SubCategoryServiceImpl subCategoryService;

    @Test
    void testGetSubCategoriesReturnsCorrectData() {
        // Given
        Integer categoryId = 1;
        ArrayList<Object[]> mockData = new ArrayList<>();
        mockData.add(new Object[]{1, "SubCategory 1"});
        mockData.add(new Object[]{2, "SubCategory 2"});

        when(subCategoryRepository.findBy(categoryId)).thenReturn(mockData);

        // When
        List<SubCategoryDetails> result = subCategoryService.getSubCategories(categoryId);

        // Then
        assertNotNull(result, "The result should not be null.");
        assertEquals(2, result.size(), "The size of the results should match the expected size.");
        assertEquals(Integer.valueOf(1), result.get(0).getSubCategoryID(), "The ID of the first sub-category should match.");
        assertEquals("SubCategory 1", result.get(0).getSubCategoryName(), "The name of the first sub-category should match.");
        assertEquals(Integer.valueOf(2), result.get(1).getSubCategoryID(), "The ID of the second sub-category should match.");
        assertEquals("SubCategory 2", result.get(1).getSubCategoryName(), "The name of the second sub-category should match.");

        // Verify
        verify(subCategoryRepository, times(1)).findBy(categoryId);
    }
}
