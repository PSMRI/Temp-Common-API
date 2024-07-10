package com.iemr.common.data.customization;

import java.util.List;

import lombok.Data;

@Data
public class SectionProjectMappingDTO {
	
	private Integer projectId;
	private String projectName;
	private Integer serviceProviderId;
	private String createdBy;
	private List<SectionProjectMapping> sections;

}
