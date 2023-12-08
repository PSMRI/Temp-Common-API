package com.iemr.common.model.eAusadha;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EAusadhaDTO {
	
	private Integer facilityId;
	private Timestamp inwardDate;

}
