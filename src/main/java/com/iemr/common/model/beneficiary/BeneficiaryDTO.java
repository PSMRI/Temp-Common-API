package com.iemr.common.model.beneficiary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDTO {
	private BeneficiaryModel beneficiaryModel;
    private String otherFields;
	
}
