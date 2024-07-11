package com.iemr.common.service.questionconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.questionconfig.QuestionnaireDetail;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.questionconfig.QuestionnaireRepository;

@ExtendWith(MockitoExtension.class)
class QuestionnaireServiceImplTest {

	@InjectMocks
	private QuestionnaireServiceImpl questionnaireService;

	@Mock
	private QuestionnaireRepository questionnaireRepository;

	@Test
	void testCreateQuestionnaire() throws IEMRException, com.iemr.common.utils.exception.IEMRException {
		// Given
		String jsonInput = "[{\"id\":1,\"name\":\"Survey 1\",\"description\":\"A sample survey.\"}]";
		QuestionnaireDetail detail = new QuestionnaireDetail();

		detail.setQuestionID(1L);
		detail.setQuestion("Survey 1");
		detail.setQuestionDesc("A sample survey.");

		when(questionnaireRepository.save(any(QuestionnaireDetail.class))).thenReturn(detail);

		// When
		String result = questionnaireService.createQuestionnaire(jsonInput);

		// Then
		assertNotNull(result);
	}

	@Test
	void testGetQuestionnaireList() {
		assertEquals(questionnaireRepository.getQuestionnaireList().toString(),
				questionnaireService.getQuestionnaireList().toString());
	}

}
