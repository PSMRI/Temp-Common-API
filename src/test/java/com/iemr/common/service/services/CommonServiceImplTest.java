package com.iemr.common.service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.repository.category.CategoryRepository;
import com.iemr.common.repository.category.SubCategoryRepository;
import com.iemr.common.repository.kmfilemanager.KMFileManagerRepository;
import com.iemr.common.repository.services.ServiceTypeRepository;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@ExtendWith(MockitoExtension.class)
class CommonServiceImplTest {

	@InjectMocks
	CommonServiceImpl commonService;

	@Mock
	private ServiceTypeRepository serviceTypeRepository;
	@Mock
	private CategoryRepository categoryRepository;
	@Mock
	private SubCategoryRepository subCategoryRepository;
	@Mock
	private KMFileManagerRepository kmFileManagerRepository;
	@Mock
	private InputMapper inputMapper = new InputMapper();

	@Test
	void testGetCategoriesReturnsData() {
		// Local setup for this test case
		List<CategoryDetails> localMockCategories = new ArrayList<>();
		localMockCategories.add(new CategoryDetails(1, "Category 1"));
		localMockCategories.add(new CategoryDetails(2, "Category 2"));

		// Setup our mock repository
		when(categoryRepository.findBy()).thenReturn((ArrayList<CategoryDetails>) localMockCategories);

		// Execute the service call
		Iterable<CategoryDetails> categories = commonService.getCategories();

		// Assert the response
		List<CategoryDetails> resultList = new ArrayList<>();
		categories.forEach(resultList::add);
		assertEquals(2, resultList.size());
		assertEquals(localMockCategories, resultList);
	}

	@Test
	void testGetCategoriesReturnsEmptyList() {
		// Local setup for this test case with an empty list
		List<CategoryDetails> localEmptyList = new ArrayList<>();

		// Setup our mock repository to return an empty list
		when(categoryRepository.findBy()).thenReturn((ArrayList<CategoryDetails>) localEmptyList);

		// Execute the service call
		Iterable<CategoryDetails> categories = commonService.getCategories();

		// Assert the response
		List<CategoryDetails> resultList = new ArrayList<>();
		categories.forEach(resultList::add);
		assertEquals(0, resultList.size());
	}

}
