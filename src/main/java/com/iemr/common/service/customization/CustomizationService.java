package com.iemr.common.service.customization;

import com.iemr.common.data.customization.SectionFieldsMappingDTO;
import com.iemr.common.data.customization.SectionProjectMappingDTO;

public interface CustomizationService {
	
	public String addProject(String request, String Authorization) throws Exception;
	
	public String getProjectNames(Integer serviceProviderId);
	

	public String updateProject(String request, String Authorization) throws Exception;
	
	public String saveProjectToServiceline(String request, String Authorization) throws Exception;
	
	public String fetchProjectServiceline(String request, String Authorization) throws Exception;

	public String updateProjectToServiceline(String request, String Authorization) throws Exception;

	public String getSections();

	public String saveSectionAndFields(SectionFieldsMappingDTO sectionFieldsMappingDTO, String Authorization) throws Exception;
	
	public String mapSectionToProject(SectionProjectMappingDTO sectionProjectMappingDTO, String Authorization) throws Exception;
	
	public String fetchMappedSectionsInProject(String request, String Authorization) throws Exception;
	
	public String fetchMappedFields(String request, String Authorization) throws Exception;
	
	public String fetchAllData(String request, String Authorization) throws Exception;
	
	public String getfileldType();
	
	public String updateSectionAndFields(String request, String Authorization) throws Exception;
}
