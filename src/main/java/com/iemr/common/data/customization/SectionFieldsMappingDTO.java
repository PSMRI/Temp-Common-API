package com.iemr.common.data.customization;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SectionFieldsMappingDTO {
	
	private Integer sectionId;
	private String sectionName;
	private String createdBy;
	private Integer serviceProviderId;
	private List<SectionAndFieldsMapping> fields;

}
