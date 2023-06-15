/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.common.data.category.CategoryDetails;
import com.iemr.common.data.category.SubCategoryDetails;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.service.SubService;
import com.iemr.common.repository.category.CategoryRepository;
import com.iemr.common.repository.category.SubCategoryRepository;
import com.iemr.common.repository.kmfilemanager.KMFileManagerRepository;
import com.iemr.common.repository.services.ServiceTypeRepository;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.exception.IEMRException;
import com.iemr.common.utils.mapper.InputMapper;

@Service
public class CommonServiceImpl implements CommonService {

	/**
	 * Designation repository
	 */
	private ServiceTypeRepository serviceTypeRepository;
	private CategoryRepository categoryRepository;
	private SubCategoryRepository subCategoryRepository;
	private KMFileManagerRepository kmFileManagerRepository;

	private InputMapper inputMapper = new InputMapper();

	/*
	 * private ConfigProperties configProperties;
	 * 
	 * @Autowired public void setConfigProperties(ConfigProperties
	 * configProperties) { this.configProperties = configProperties; }
	 */

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	@Autowired
	public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository) {

		this.subCategoryRepository = subCategoryRepository;
	}

	@Autowired
	public void setServiceTypeRepository(ServiceTypeRepository serviceTypeRepository) {

		this.serviceTypeRepository = serviceTypeRepository;
	}

	@Autowired
	public void setKmFileManagerRepository(KMFileManagerRepository kmFileManagerRepository) {
		this.kmFileManagerRepository = kmFileManagerRepository;
	}

	
	@Override
	public Iterable<CategoryDetails> getCategories() {
		List<CategoryDetails> categoriesList = new ArrayList<CategoryDetails>();
		// ArrayList<Objects[]> lists = categoryRepository.findBy();
		// for (Object[] objects : lists)
		// {
		// if (objects != null && objects.length > 1)
		// {
		// System.out.println(objects);
		// categoriesList.add(new CategoryDetails((Integer) objects[0], (String)
		// objects[1]));
		// }
		// }
		categoriesList = categoryRepository.findBy();
		return categoriesList;
	}

	@Override
	public Iterable<SubCategoryDetails> getSubCategories(String request) throws IEMRException {
		SubCategoryDetails subCategoryDetails = inputMapper.gson().fromJson(request, SubCategoryDetails.class);
		List<SubCategoryDetails> subCategoriesList = new ArrayList<SubCategoryDetails>();
		ArrayList<Objects[]> lists = subCategoryRepository.findByCategoryID(subCategoryDetails.getCategoryID());
		for (Object[] objects : lists) {
			if (objects != null && objects.length > 1) {
				String SubCatFilePath = (String) objects[2];
				String fileUIDAsURI = null;
				String fileNameWithExtension = null;
				if(SubCatFilePath!=null) {
				fileUIDAsURI=getFilePath(SubCatFilePath);
				List<Objects[]> fileNameList = kmFileManagerRepository.getFileNameByUID(SubCatFilePath);
				Object[] fileobjects = fileNameList.get(0);
				fileNameWithExtension= (String)fileobjects[0]+ (String) fileobjects[1];
				}
				subCategoriesList.add(new SubCategoryDetails((Integer) objects[0], (String) objects[1], SubCatFilePath, fileUIDAsURI, fileNameWithExtension));
			}
		}
		return subCategoriesList;
	}
	
	private String getFilePath(String fileUID)
	{
		String fileUIDAsURI = null;

			String dmsPath = ConfigProperties.getPropertyByName("km-base-path");
			String dmsProtocol = ConfigProperties.getPropertyByName("km-base-protocol");
			String userName = ConfigProperties.getPropertyByName("km-guest-user");
			String userPassword = ConfigProperties.getPassword("km-guest-user");
			fileUIDAsURI =
					dmsProtocol + "://" + userName + ":" + userPassword + "@" + dmsPath + "/Download?uuid=" + fileUID;
		
		return fileUIDAsURI;
	}

	@Override
	public List<SubCategoryDetails> getSubCategoryFiles(String request) throws IEMRException {
		SubCategoryDetails subCategoryDetails;
		subCategoryDetails = inputMapper.gson().fromJson(request, SubCategoryDetails.class);
		List<SubCategoryDetails> subCategoriesList = new ArrayList<SubCategoryDetails>();
		if (subCategoryDetails.getSubCategoryID() != null) {
			subCategoriesList = subCategoryRepository.findBySubCategoryID(subCategoryDetails.getSubCategoryID());
		} else if ((subCategoryDetails.getCategoryID() != null)
				&& (subCategoryDetails.getProviderServiceMapID() != null)) {
			subCategoriesList = subCategoryRepository.findByProviderServiceMapCategoryID(
					subCategoryDetails.getProviderServiceMapID(), subCategoryDetails.getCategoryID());
		} else if (subCategoryDetails.getProviderServiceMapID() != null) {
			subCategoriesList = subCategoryRepository
					.findByProviderServiceMapID(subCategoryDetails.getProviderServiceMapID());
		}
		for (int index = 0; index < subCategoriesList.size(); index++) {
			SubCategoryDetails subCategory = subCategoriesList.get(index);
			if (subCategory.getSubCatFilePath() != null && subCategory.getSubCatFilePath().length() > 0) {
				subCategoriesList.get(index).setFileManger(kmFileManagerRepository
						.getKMFileLists(subCategoryDetails.getProviderServiceMapID(), subCategory.getSubCatFilePath()));
			}
		}
		return subCategoriesList;
	}

	@Override
	public List<SubCategoryDetails> getSubCategoryFilesWithURL(String request) throws IEMRException {
		SubCategoryDetails subCategoryDetails;
		subCategoryDetails = inputMapper.gson().fromJson(request, SubCategoryDetails.class);
		List<SubCategoryDetails> subCategoriesList = new ArrayList<SubCategoryDetails>();
		if (subCategoryDetails.getSubCategoryID() != null) {
			subCategoriesList = subCategoryRepository.findBySubCategoryID(subCategoryDetails.getSubCategoryID());
		} else if ((subCategoryDetails.getCategoryID() != null)
				&& (subCategoryDetails.getProviderServiceMapID() != null)) {
			subCategoriesList = subCategoryRepository.findByProviderServiceMapCategoryID(
					subCategoryDetails.getProviderServiceMapID(), subCategoryDetails.getCategoryID());
		} else if (subCategoryDetails.getProviderServiceMapID() != null) {
			subCategoriesList = subCategoryRepository
					.findByProviderServiceMapID(subCategoryDetails.getProviderServiceMapID());
		}
		for (int index = 0; index < subCategoriesList.size(); index++) {
			SubCategoryDetails subCategory = subCategoriesList.get(index);
			if (subCategory.getSubCatFilePath() != null && subCategory.getSubCatFilePath().length() > 0) {
				String subCatFilePath = subCategory.getSubCatFilePath();
				String dmsPath = ConfigProperties.getPropertyByName("km-base-path");
				String dmsProtocol = ConfigProperties.getPropertyByName("km-base-protocol");
				String userName = ConfigProperties.getPropertyByName("km-guest-user");
				String userPassword = ConfigProperties.getPassword("km-guest-user");
				String fileUIDAsURI = dmsProtocol + "://" + userName + ":" + userPassword + "@" + dmsPath
						+ "/Download?uuid=" + subCategory.getSubCatFilePath();
				subCategory.setSubCatFilePath(fileUIDAsURI);
				subCategoriesList.get(index).setFileManger(kmFileManagerRepository
						.getKMFileLists(subCategoryDetails.getProviderServiceMapID(), subCatFilePath));
			}
		}
		return subCategoriesList;
	}

	@Override
	public Iterable<CategoryDetails> getCategories(String request) throws IEMRException {
		CategoryDetails categoryRequest = inputMapper.gson().fromJson(request, CategoryDetails.class);
		List<CategoryDetails> categoriesList = new ArrayList<CategoryDetails>();
		// ArrayList<Objects[]> lists =
		// categoryRepository.getAllCategories(categoryRequest.getSubServiceID(),
		// categoryRequest.getProviderServiceMapID());
		// for (Object[] objects : lists)
		// {
		// if (objects != null && objects.length > 1)
		// {
		// System.out.println(objects);
		// categoriesList.add(new CategoryDetails((Integer) objects[0], (String)
		// objects[1]));
		// }
		// }
		if (categoryRequest.getIsWellBeing() != null) {
			categoriesList = categoryRepository.getAllCategories(categoryRequest.getSubServiceID(),
					categoryRequest.getProviderServiceMapID(), categoryRequest.getIsWellBeing());
		} else {
			categoriesList = categoryRepository.getAllCategories(categoryRequest.getSubServiceID(),
					categoryRequest.getProviderServiceMapID());
		}
		return categoriesList;
	}

	@Override
	public Iterable<SubService> getActiveServiceTypes(String request) throws IEMRException {
		SubService subServiceRequest = inputMapper.gson().fromJson(request, SubService.class);
		List<SubService> subServices = new ArrayList<SubService>();
		ArrayList<Objects[]> lists = serviceTypeRepository
				.findActiveServiceTypes(subServiceRequest.getProviderServiceMapID());
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 4) {
				subServices.add(new SubService((Integer) objects[0], (String) objects[1], (String) objects[2],
						(Boolean) objects[3]));
			}
		}
		return subServices;
	}

}
