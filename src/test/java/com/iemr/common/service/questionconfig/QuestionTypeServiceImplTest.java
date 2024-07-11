package com.iemr.common.service.questionconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.questionconfig.QuestionTypeDetail;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.questionconfig.QuestionTypeRepository;

@ExtendWith(MockitoExtension.class)
class QuestionTypeServiceImplTest {

	@InjectMocks
	private QuestionTypeServiceImpl questionTypeService;

	@Mock
	private QuestionTypeRepository questionTypeRepository;

	@Test
	void testCreateQuestionType() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Given
		String jsonInput = "[{\"id\":1,\"type\":\"Multiple Choice\",\"description\":\"Choose one or more from a list.\"}]";
		QuestionTypeDetail questionTypeDetail = new QuestionTypeDetail(); // Populate with appropriate values
		questionTypeDetail.setQuestionTypeID(1L);
		questionTypeDetail.setQuestionType("Multiple Choice");
		questionTypeDetail.setQuestionTypeDesc("Choose one or more from a list.");

		when(questionTypeRepository.save(any(QuestionTypeDetail.class))).thenReturn(questionTypeDetail);

		// When
		String result = questionTypeService.createQuestionType(jsonInput);

		// Then
		assertNotNull(result);
	}

	@Test
	void testGetQuestionTypeList() {
		assertEquals(questionTypeRepository.getQuestionTypeList().toString(),
				questionTypeService.getQuestionTypeList().toString());
	}

}
