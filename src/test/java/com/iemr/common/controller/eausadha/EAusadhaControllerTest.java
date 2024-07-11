package com.iemr.common.controller.eausadha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.common.model.eAusadha.EAusadhaDTO;
import com.iemr.common.service.beneficiary.EAusadhaService;
import com.iemr.common.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EAusadhaControllerTest {
	
	@InjectMocks
	EAusadhaController eAusadhaController;
	
	@Mock
	private EAusadhaService eAusadhaService;
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testCreateEAusadha() throws Exception {
		OutputResponse response = new OutputResponse();
		String Authorization = "authorization";
		EAusadhaDTO eAusadhaDTO = new EAusadhaDTO();
		eAusadhaDTO.setFacilityId(123);
		eAusadhaDTO.setInwardDate(Timestamp.from(Instant.now()));
		String res = eAusadhaDTO.toString();
		when(eAusadhaService.createEAusadha(eAusadhaDTO, Authorization)).thenReturn(res);
		response.setResponse(res.toString());
		Assertions.assertEquals(response.toString(), eAusadhaController.createEAusadha(eAusadhaDTO, Authorization));
	}
	
	@Test
	void testCreateEAusadha_CatchBlock() throws Exception {
		String Authorization = "authorization";
		EAusadhaDTO eAusadhaDTO = new EAusadhaDTO();
		eAusadhaDTO.setFacilityId(123);
		when(eAusadhaService.createEAusadha(eAusadhaDTO, Authorization)).thenThrow(NotFoundException.class);
		String response = eAusadhaController.createEAusadha(eAusadhaDTO, Authorization);
		Assertions.assertEquals(response, eAusadhaController.createEAusadha(eAusadhaDTO, Authorization));
	}

}
