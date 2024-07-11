package com.iemr.common.service.customization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;
import com.iemr.common.data.customization.FieldType;
import com.iemr.common.data.customization.ProjectCustomization;
import com.iemr.common.data.customization.SectionAndFieldsMapping;
import com.iemr.common.data.customization.SectionFieldsMappingDTO;
import com.iemr.common.data.customization.SectionMasterCustomization;
import com.iemr.common.data.customization.SectionProjectMapping;
import com.iemr.common.data.customization.SectionProjectMappingDTO;
import com.iemr.common.data.customization.ServicelineCustomization;
import com.iemr.common.data.customization.V_CustomizationDataFields;
import com.iemr.common.repo.customization.FieldTypeRepo;
import com.iemr.common.repo.customization.ProjectCustomizationRepo;
import com.iemr.common.repo.customization.SectionAndFieldsMappingRepo;
import com.iemr.common.repo.customization.SectionMasterCustomizationRepo;
import com.iemr.common.repo.customization.SectionProjectMappingRepo;
import com.iemr.common.repo.customization.ServicelineCustomizationRepo;
import com.iemr.common.repo.customization.V_CustomizationDataFieldsRepo;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class CustomizationServiceImpl implements CustomizationService {

	@Autowired
	private ProjectCustomizationRepo projectCustomizationRepo;
	@Autowired
	private SectionMasterCustomizationRepo sectionMasterCustomizationRepo;
	@Autowired
	private ServicelineCustomizationRepo servicelineCustomizationRepo;
	@Autowired
	private SectionAndFieldsMappingRepo sectionAndFieldsMappingRepo;
	@Autowired
	private SectionProjectMappingRepo sectionProjectMappingRepo;
	@Autowired
	private V_CustomizationDataFieldsRepo v_CustomizationDataFieldsRepo;
	@Autowired
	private FieldTypeRepo fieldTypeRepo;

	@Override
	public String addProject(String request, String Authorization) throws Exception {

		ProjectCustomization projectCustomization = InputMapper.gson().fromJson(request, ProjectCustomization.class);
		try {
			Set<ProjectCustomization> existingProjects = projectCustomizationRepo.findByProjectName(
					projectCustomization.getProjectName(), projectCustomization.getServiceProviderId());

			if (existingProjects.isEmpty()) {
				projectCustomization.setDeleted(false);
				projectCustomizationRepo.save(projectCustomization);
				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("response", "Project Added Successfully");
				return new Gson().toJson(responseMap);
			} else {
				throw new IEMRException("project already exists");
			}
		} catch (IEMRException e) {
			throw new IEMRException(e.getMessage());
		}
	}

	@Override
	public String getProjectNames(Integer serviceProviderId) {
		ArrayList<ProjectCustomization> resultSet = projectCustomizationRepo.findByServiceProviderId(serviceProviderId);
		return new Gson().toJson(resultSet);
	}

	@Override
	public String updateProject(String request, String Authorization) throws Exception {

		ProjectCustomization projectCustomization = InputMapper.gson().fromJson(request, ProjectCustomization.class);
		try {
			Integer serviceProviderId = projectCustomizationRepo
					.findServiceProviderId(projectCustomization.getServiceProviderId());
			if (projectCustomization.getProjectId() != null && serviceProviderId != null) {
				projectCustomizationRepo.save(projectCustomization);
			}
			if (projectCustomization.getDeleted() != null && projectCustomization.getDeleted()) {
				int updateRecords = servicelineCustomizationRepo.updateDeletedFlag(projectCustomization.getProjectId(),
						projectCustomization.getProjectName(), projectCustomization.getDeleted());
			}
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "Project updated Successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String saveProjectToServiceline(String request, String Authorization) throws Exception {
		ServicelineCustomization[] requests = InputMapper.gson().fromJson(request, ServicelineCustomization[].class);
		try {
			for (ServicelineCustomization servicelineCustomization : requests) {
				Set<ServicelineCustomization> existingProjects = servicelineCustomizationRepo.findByProjectName(
						servicelineCustomization.getServiceLineId(), servicelineCustomization.getServiceProviderId(),
						servicelineCustomization.getStateId(), servicelineCustomization.getDistrictId(),
						servicelineCustomization.getBlockId());
				if (existingProjects.isEmpty()) {
					servicelineCustomization.setDeleted(false);
					servicelineCustomizationRepo.save(servicelineCustomization);
				} else {
					throw new IEMRException("project already mapped with this serviceLine and block");
				}
			}
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "Save Project to Serviceline Successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String fetchProjectServiceline(String request, String Authorization) throws Exception {
		ServicelineCustomization servicelineCustomization = InputMapper.gson().fromJson(request,
				ServicelineCustomization.class);
		try {
			List<ServicelineCustomization> resultSet = servicelineCustomizationRepo.getServicelineProject(
					servicelineCustomization.getServiceLineId(), servicelineCustomization.getServiceLine(),
					servicelineCustomization.getStateId(), servicelineCustomization.getStateName(),
					servicelineCustomization.getDistrictId(), servicelineCustomization.getDistrictName(),
					servicelineCustomization.getServiceProviderId());
			return new Gson().toJson(resultSet);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String updateProjectToServiceline(String request, String Authorization) throws Exception {
		ServicelineCustomization servicelineCustomization = InputMapper.gson().fromJson(request,
				ServicelineCustomization.class);
		try {
			/*
			 * Integer serviceProviderId = servicelineCustomizationRepo
			 * .findServiceProviderId(servicelineCustomization.getServiceProviderId());
			 */
			Integer id = servicelineCustomizationRepo.findServiceProviderId(
					servicelineCustomization.getServiceProviderId(), servicelineCustomization.getServiceLineId(),
					servicelineCustomization.getStateId(), servicelineCustomization.getDistrictId(),
					servicelineCustomization.getBlockId());
			if (id != null) {
				servicelineCustomization.setId(id);
				servicelineCustomizationRepo.save(servicelineCustomization);
			} else
				throw new IllegalArgumentException("Invalid request: please pass valid request");
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "Project to Serviceline Updated Successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String getSections() {
		ArrayList<SectionMasterCustomization> resultSet = sectionMasterCustomizationRepo.findSections();
		return new Gson().toJson(resultSet);
	}

	@Override
	public String saveSectionAndFields(SectionFieldsMappingDTO sectionFieldsMappingDTO, String Authorization)
			throws Exception {
		try {

			if (sectionFieldsMappingDTO != null && sectionFieldsMappingDTO.getFields() != null
					&& sectionFieldsMappingDTO.getFields().size() > 0) {
				SectionAndFieldsMapping sectionAndFieldsMapping;
				List<SectionAndFieldsMapping> sectionAndFieldsMappingList = new ArrayList<>();
				for (SectionAndFieldsMapping sectionFieldsMapping : sectionFieldsMappingDTO.getFields()) {
					List<SectionAndFieldsMapping> byFieldName = sectionAndFieldsMappingRepo
							.getByFieldName(sectionFieldsMapping.getFieldName());
					sectionAndFieldsMapping = new SectionAndFieldsMapping();
					sectionAndFieldsMapping.setSectionId(sectionFieldsMappingDTO.getSectionId());
					sectionAndFieldsMapping.setCreatedBy(sectionFieldsMappingDTO.getCreatedBy());
					sectionAndFieldsMapping.setAllowMax(sectionFieldsMapping.getAllowMax());
					sectionAndFieldsMapping.setFieldName(sectionFieldsMapping.getFieldName());
					sectionAndFieldsMapping.setPlaceholder(sectionFieldsMapping.getPlaceholder());
					sectionAndFieldsMapping.setFieldTypeId(sectionFieldsMapping.getFieldTypeId());
					sectionAndFieldsMapping.setFieldType(sectionFieldsMapping.getFieldType());
					sectionAndFieldsMapping.setAllowMin(sectionFieldsMapping.getAllowMin());
					sectionAndFieldsMapping.setRank(sectionFieldsMapping.getRank());
					sectionAndFieldsMapping.setAllowText(sectionFieldsMapping.getAllowText());
					sectionAndFieldsMapping.setIsRequired(sectionFieldsMapping.getIsRequired());
					sectionAndFieldsMapping.setIsEditable(sectionFieldsMapping.getIsEditable());
					sectionAndFieldsMapping.setFieldTitle(sectionFieldsMapping.getFieldTitle());
					sectionAndFieldsMapping.setServiceProviderId(sectionFieldsMappingDTO.getServiceProviderId());
					sectionAndFieldsMapping.setDeleted(false);
					if (sectionFieldsMapping.getOptions() != null && sectionFieldsMapping.getOptions().length > 0) {
						StringBuffer sb = new StringBuffer();
						for (String option : sectionFieldsMapping.getOptions()) {
							sb.append(option).append(",");
						}
						if (sb.length() >= 1)
							sectionAndFieldsMapping.setOption(sb.substring(0, sb.length() - 1));
					}
					if (ObjectUtils.isEmpty(byFieldName) || byFieldName.size() == 0)// Added by Ravi
						sectionAndFieldsMappingList.add(sectionAndFieldsMapping);

				}
				if (!ObjectUtils.isEmpty(sectionAndFieldsMappingList) && sectionAndFieldsMappingList.size() > 0)// Added
																												// by
																												// Ravi
					sectionAndFieldsMappingRepo.saveAll(sectionAndFieldsMappingList);
			} else
				throw new IllegalArgumentException("Invalid request: please pass valid request");
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "section and fields mapping done successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String mapSectionToProject(SectionProjectMappingDTO sectionProjectMappingDTO, String Authorization)
			throws Exception {
		try {
			List<Integer> sectionIds = new ArrayList<>();
			if (sectionProjectMappingDTO != null && sectionProjectMappingDTO.getSections() != null
					&& sectionProjectMappingDTO.getSections().size() > 0) {
				List<SectionProjectMapping> mappedSectionsInProject = sectionProjectMappingRepo.findMappedSectionsInProject(sectionProjectMappingDTO.getProjectId(),sectionProjectMappingDTO.getProjectName(),
						sectionProjectMappingDTO.getServiceProviderId());
				for (SectionProjectMapping sectionProjectMapping : mappedSectionsInProject) {
					sectionIds.add(sectionProjectMapping.getSectionId());
				}
				List<SectionProjectMapping> sectionProjectMappingList = new ArrayList<>();
				for (SectionProjectMapping mapping : sectionProjectMappingDTO.getSections()) {
					
					SectionProjectMapping sectionProjectMapping = new SectionProjectMapping();
					sectionProjectMapping.setProjectId(sectionProjectMappingDTO.getProjectId());
					sectionProjectMapping.setProjectName(sectionProjectMappingDTO.getProjectName());
					sectionProjectMapping.setServiceProviderId(sectionProjectMappingDTO.getServiceProviderId());
					sectionProjectMapping.setCreatedBy(sectionProjectMappingDTO.getCreatedBy());
					sectionProjectMapping.setDeleted(false);
					sectionProjectMapping.setSectionId(mapping.getSectionId());
					sectionProjectMapping.setSectionName(mapping.getSectionName());

					sectionProjectMappingList.add(sectionProjectMapping);
				}
				sectionProjectMappingRepo.saveAll(sectionProjectMappingList);
			} else
				throw new IllegalArgumentException("Invalid request: please pass valid request");
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "section and project mapping done successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String fetchMappedSectionsInProject(String request, String Authorization) throws Exception {
		SectionProjectMapping sectionProjectMapping = InputMapper.gson().fromJson(request, SectionProjectMapping.class);
		try {
			List<SectionProjectMapping> resultSet = sectionProjectMappingRepo.findMappedSectionsInProject(
					sectionProjectMapping.getProjectId(), sectionProjectMapping.getProjectName(),
					sectionProjectMapping.getServiceProviderId());
			return new Gson().toJson(resultSet);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String fetchMappedFields(String request, String Authorization) throws Exception {
		SectionAndFieldsMapping sectionAndFieldsMapping = InputMapper.gson().fromJson(request,
				SectionAndFieldsMapping.class);
		try {
			List<SectionAndFieldsMapping> resultSet = sectionAndFieldsMappingRepo
					.findSectionIdAndSectionNameAndServiceProviderId(sectionAndFieldsMapping.getSectionId(),
							sectionAndFieldsMapping.getServiceProviderId());

			String sectionName = sectionMasterCustomizationRepo.findSectionName(sectionAndFieldsMapping.getSectionId());
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("sectionId", sectionAndFieldsMapping.getSectionId());
			responseMap.put("sectionName", sectionName);
			responseMap.put("serviceProviderId", sectionAndFieldsMapping.getServiceProviderId());

			List<Map<String, Object>> fieldsList = new ArrayList<>();
			for (SectionAndFieldsMapping field : resultSet) {
				Map<String, Object> fieldMap = new HashMap<>();
				fieldMap.put("id", field.getId());
				fieldMap.put("fieldName", field.getFieldName());
				fieldMap.put("placeholder", field.getPlaceholder());
				fieldMap.put("fieldTypeId", field.getFieldTypeId());
				fieldMap.put("fieldType", field.getFieldType());
				fieldMap.put("allowMin", field.getAllowMin());
				fieldMap.put("allowMax", field.getAllowMax());
				fieldMap.put("rank", field.getRank());
				fieldMap.put("allowText", field.getAllowText());
				fieldMap.put("isRequired", field.getIsRequired());
				fieldMap.put("isEditable", field.getIsEditable());
				fieldMap.put("fieldTitle", field.getFieldTitle());
				fieldMap.put("deleted", field.getDeleted());
				fieldMap.put("createdBy", field.getCreatedBy());

				if (field.getOption() != null) {
					String[] options = field.getOption().split(",");
					fieldMap.put("options", options);
				}
				fieldsList.add(fieldMap);
			}
			responseMap.put("fields", fieldsList);
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String fetchAllData(String request, String Authorization) throws Exception {
		V_CustomizationDataFields customizationDataFields = InputMapper.gson().fromJson(request,
				V_CustomizationDataFields.class);
		List<V_CustomizationDataFields> responseList = new ArrayList<>();
		Integer projectId=null;
		try {
			ServicelineCustomization data = servicelineCustomizationRepo.checkExistingData(
					customizationDataFields.getServiceLineId(), customizationDataFields.getServiceLine(),
					customizationDataFields.getStateId(), customizationDataFields.getDistrictId(),
					customizationDataFields.getBlockId(), customizationDataFields.getServiceProviderId());
			if(data != null) {
				projectId = data.getProjectId();
			}
			List<V_CustomizationDataFields> tempList = v_CustomizationDataFieldsRepo.getAllData(
					customizationDataFields.getServiceLine(), customizationDataFields.getServiceLineId(),
					customizationDataFields.getStateId(), customizationDataFields.getDistrictId(),
					customizationDataFields.getBlockId(), customizationDataFields.getServiceProviderId(), projectId);
			if (tempList != null) {
				for (V_CustomizationDataFields resultset : tempList) {
					if (resultset.getOption() != null) {
						resultset.setOptions(resultset.getOption().split(","));
					}

					responseList.add(resultset);
				}
			}
			return new Gson().toJson(responseList);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String getfileldType() {
		List<FieldType> resultSet = fieldTypeRepo.findFields();
		return new Gson().toJson(resultSet);
	}

	@Override
	public String updateSectionAndFields(String request, String Authorization) throws Exception {
		SectionAndFieldsMapping sectionAndFieldsMapping = InputMapper.gson().fromJson(request,
				SectionAndFieldsMapping.class);
		try {
			if (sectionAndFieldsMapping.getId() != null) {
				SectionAndFieldsMapping response = sectionAndFieldsMappingRepo.getById(sectionAndFieldsMapping.getId());
				if (response != null) {
					if (sectionAndFieldsMapping.getFieldName() != null)
						response.setFieldName(sectionAndFieldsMapping.getFieldName());
					if (sectionAndFieldsMapping.getIsRequired() != null)
						response.setIsRequired(sectionAndFieldsMapping.getIsRequired());
					if (sectionAndFieldsMapping.getDeleted() != null)
						response.setDeleted(sectionAndFieldsMapping.getDeleted());
					if (sectionAndFieldsMapping.getIsEditable() != null)
						response.setIsEditable(sectionAndFieldsMapping.getIsEditable());

					if (sectionAndFieldsMapping.getFieldTitle() != null)
						response.setFieldTitle(sectionAndFieldsMapping.getFieldTitle());
					if (sectionAndFieldsMapping.getAllowMin() != null)
						response.setAllowMin(sectionAndFieldsMapping.getAllowMin());
					if (sectionAndFieldsMapping.getAllowMax() != null)
						response.setAllowMax(sectionAndFieldsMapping.getAllowMax());
					if (sectionAndFieldsMapping.getAllowText() != null)
						response.setAllowText(sectionAndFieldsMapping.getAllowText());
					if (sectionAndFieldsMapping.getPlaceholder() != null)
						response.setPlaceholder(sectionAndFieldsMapping.getPlaceholder());
					if (sectionAndFieldsMapping.getFieldType() != null)
						response.setFieldType(sectionAndFieldsMapping.getFieldType());
					if (sectionAndFieldsMapping.getOptions() != null
							&& sectionAndFieldsMapping.getOptions().length > 0) {
						StringBuffer sb = new StringBuffer();
						for (String option : sectionAndFieldsMapping.getOptions()) {
							sb.append(option).append(",");
						}
						if (sb.length() >= 1)
							response.setOption(sb.substring(0, sb.length() - 1));
					}
				}
				sectionAndFieldsMappingRepo.save(response);
			} else
				throw new IllegalArgumentException("Invalid request: please pass valid request");
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("response", "section and fields mapping updated successfully");
			return new Gson().toJson(responseMap);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
