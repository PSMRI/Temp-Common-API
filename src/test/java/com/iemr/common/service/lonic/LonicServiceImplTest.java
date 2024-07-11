package com.iemr.common.service.lonic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.iemr.common.data.lonic.LonicDescription;
import com.iemr.common.repository.lonic.LonicRepository;

@ExtendWith(MockitoExtension.class)
class LonicServiceImplTest {

	@Mock
	private LonicRepository lonicRepository;

	@InjectMocks
	private LonicServiceImpl lonicService;

	private static final int LONIC_PAGE_SIZE = 10; // Assuming this is the value in application.properties for
													// lonicPageSize

	@Test
	void testFindLonicRecordList_Failure_InvalidRequest() {
		LonicDescription lonicDescription = new LonicDescription(); // term and pageNo are null

		Exception exception = assertThrows(Exception.class, () -> {
			lonicService.findLonicRecordList(lonicDescription);
		});

		String expectedMessage = "invalid request";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
