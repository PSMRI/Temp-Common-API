package com.iemr.common.service.beneficiary;

import java.util.Set;

import com.iemr.common.model.eAusadha.EAusadhaDTO;

public interface EAusadhaService {

	String createEAusadha(EAusadhaDTO eAusadhaDTO, String Authorization) throws Exception;

}
