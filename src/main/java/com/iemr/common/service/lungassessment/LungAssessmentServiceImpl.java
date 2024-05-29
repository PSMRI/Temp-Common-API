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
package com.iemr.common.service.lungassessment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

//import javax.xml.ws.http.HTTPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.iemr.common.data.lungassessment.LungAssessment;
import com.iemr.common.data.lungassessment.LungAssessmentResponseDTO;
import com.iemr.common.data.lungassessment.LungAssessmentAuthenticateResponse;
import com.iemr.common.data.lungassessment.LungAssessmentValidateCoughReponseDTO;
import com.iemr.common.repo.lungassessment.LungAssessmentRepository;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class LungAssessmentServiceImpl implements LungAssessmentService {

	private static String lungAssessmentToken;
	private static long authCreatedAt;

	private static HttpUtils httpUtils = new HttpUtils();

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${lungAssessmentPath}")
	private String lungAssessmentPath;

	@Value("${lungAssessmentAdminLogin}")
	private String lungAssessmentAdminLoginUrl;

	@Value("${lungAssessmentEmail}")
	private String lungAssessmentEmail;

	@Value("${lungAssessmentPassword}")
	private String lungAssessmentPassword;

	@Value("${lungAssessmentValidateCough}")
	private String lungAssessmentValidateCoughUrl;

	@Value("${lungAssessmentStartAssesment}")
	private String lungAssessmentAssesmentUrl;

	@Value("${lungAssessmentGetAssesment}")
	private String lungAssessmentGetAssesmentUrl;

	@Autowired
	private LungAssessmentRepository lungAssessmentRepository;

	@Override
	public String getLungAssessmentAdminLogin(String email, String password) throws Exception {
		String lungAssessmentToken = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();

			MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
			bodyMap.add("email", email);
			bodyMap.add("password", password);


			logger.info("Lung assessment authentication request: " + bodyMap.toString());

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(lungAssessmentAdminLoginUrl, HttpMethod.POST,
					requestEntity, String.class);

			if (responseEntity.getStatusCode() != HttpStatus.OK) {

				throw new RuntimeException("Lung assessment authentication failed, statusCode : "
						+ responseEntity.getStatusCodeValue() + " response : " + responseEntity.toString());
			} else {
				String response = responseEntity.getBody() != null ? responseEntity.getBody() : null;
				LungAssessmentAuthenticateResponse responseBody = InputMapper.gson().fromJson(response,
						LungAssessmentAuthenticateResponse.class);

				if (responseBody != null && responseBody.getAccessToken() != null) {
					lungAssessmentToken = responseBody.getAccessToken();

					authCreatedAt = System.currentTimeMillis();
				}
			}

			logger.info("Lung assessment authentication response: " + lungAssessmentToken);

		} /*
			 * catch (HTTPException e) {
			 * logger.error("Lung assessment authentication error : " + e.getMessage(), e);
			 * throw new RuntimeException("get authentication failed with error", e); }
			 */catch (Exception e) {
			logger.error("Lung assessment authentication error : " + e.getMessage(), e);
			throw new RuntimeException("get authentication failed with error", e);
		}
		return lungAssessmentToken;
	}

	@Override
	public Boolean verifyCough(MultipartFile file, String authToken, Long patientId, String tempFileName) throws Exception {

		try {

			if (file == null || file.isEmpty())
				throw new Exception("file is missing,please pass a cough recording file");

			long currTime = System.currentTimeMillis();

			String decryptlungAssessmentEmail = lungAssessmentEmail;
			String decryptlungAssessmentPassword = lungAssessmentPassword;
			if (lungAssessmentToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
				lungAssessmentToken = getLungAssessmentAdminLogin(decryptlungAssessmentEmail, decryptlungAssessmentPassword);

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			headers.add("accessToken", authToken);

			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(lungAssessmentPath + tempFileName)));
			stream.write(bytes);
			stream.close();

			MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
			bodyMap.add("coughsoundfile", new FileSystemResource(lungAssessmentPath + tempFileName));

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

			logger.info("Lung assessment validate cough quality request : " + requestEntity);
			ResponseEntity<String> responseEntity = restTemplate.exchange(lungAssessmentValidateCoughUrl, HttpMethod.POST,
					requestEntity, String.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				String responseBody = responseEntity.getBody() != null ? responseEntity.getBody() : null;
				logger.info("Lung assessment validate cough quality response : " + responseBody);
				LungAssessmentValidateCoughReponseDTO obj = InputMapper.gson().fromJson(responseBody,
						LungAssessmentValidateCoughReponseDTO.class);

				Boolean isValidCough;
				if (obj != null) {
					isValidCough = (Boolean) obj.getData().get("isValidCough");
				} else
					throw new RuntimeException(
							"cough file validation is failed at lung assessment end : response" + responseBody);

				if (isValidCough != null)
					return isValidCough;
				else
					throw new RuntimeException("cough file validation is failed at lung assessment end : " + obj.getStatus());
			} else
				throw new RuntimeException("error from lung assessment validate cough API : " + responseEntity.toString());
		} catch (Exception e) {
			logger.error("Lung assessment validate cough quality exception : ", e);
			throw new RuntimeException("Lung assessment validate cough quality exception : " + e.getMessage());
		}

	}

	@Override
	public String initiateAssesment(String request, MultipartFile file) throws Exception {
		LungAssessment resultSet = new LungAssessment();
		try {
			if (file == null || file.isEmpty())
				throw new Exception("file is missing,please pass a cough recording file");

			LungAssessment lungAssessmentAssessmentRequestObj = InputMapper.gson().fromJson(request, LungAssessment.class);
			if (lungAssessmentAssessmentRequestObj != null && lungAssessmentAssessmentRequestObj.getSymptoms() != null) {
				lungAssessmentAssessmentRequestObj
						.setFrequent_cough(lungAssessmentAssessmentRequestObj.getSymptoms().getFrequent_cough());
				lungAssessmentAssessmentRequestObj.setSputum(lungAssessmentAssessmentRequestObj.getSymptoms().getSputum());
				lungAssessmentAssessmentRequestObj
						.setCough_at_night(lungAssessmentAssessmentRequestObj.getSymptoms().getCough_at_night());
				lungAssessmentAssessmentRequestObj.setWheezing(lungAssessmentAssessmentRequestObj.getSymptoms().getWheezing());
				lungAssessmentAssessmentRequestObj
						.setPain_in_chest(lungAssessmentAssessmentRequestObj.getSymptoms().getPain_in_chest());
				lungAssessmentAssessmentRequestObj
						.setShortness_of_breath(lungAssessmentAssessmentRequestObj.getSymptoms().getShortness_of_breath());
			}

			if (lungAssessmentAssessmentRequestObj.getPatientId() == null)
				throw new RuntimeException("Missing patient Id, please pass a valid patient Id");

			long currTime = System.currentTimeMillis();
			String decryptlungAssessmentEmail = lungAssessmentEmail;
			String decryptlungAssessmentPassword = lungAssessmentPassword;
			if (lungAssessmentToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
				lungAssessmentToken = getLungAssessmentAdminLogin(decryptlungAssessmentEmail, decryptlungAssessmentPassword);

			String tempFileName = "coughSoundAssessment" + lungAssessmentAssessmentRequestObj.getPatientId()
			+ System.currentTimeMillis() + ".wav";
			Boolean isCoughValidateSuccess = verifyCough(file, lungAssessmentToken, lungAssessmentAssessmentRequestObj.getPatientId(), tempFileName);

			if (isCoughValidateSuccess) {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				headers.add("accessToken", lungAssessmentToken);

				lungAssessmentAssessmentRequestObj.setAssessmentId(
						"pid" + lungAssessmentAssessmentRequestObj.getPatientId() + "salt" + System.currentTimeMillis());
				resultSet = lungAssessmentRepository.save(lungAssessmentAssessmentRequestObj);

				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("lungAssessmentPath" + tempFileName)));
				stream.write(bytes);
				stream.close();

				MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
				bodyMap.add("symptoms", new Gson().toJson(lungAssessmentAssessmentRequestObj.getSymptoms()));
				bodyMap.add("timestamp", lungAssessmentAssessmentRequestObj.getTimestamp());
				bodyMap.add("age", lungAssessmentAssessmentRequestObj.getAge());
				bodyMap.add("gender", lungAssessmentAssessmentRequestObj.getGender());
				bodyMap.add("assessmentId", lungAssessmentAssessmentRequestObj.getAssessmentId());
				bodyMap.add("patientId", lungAssessmentAssessmentRequestObj.getPatientId());
				bodyMap.add("coughsoundfile", new FileSystemResource(lungAssessmentPath + tempFileName));

				HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

				logger.info("Lung assessment API request: " + requestEntity);

				ResponseEntity<String> responseEntity = restTemplate.exchange(lungAssessmentAssesmentUrl, HttpMethod.POST,
						requestEntity, String.class);

				LungAssessmentResponseDTO lungAssessmentAssessmentResponseDTO;
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					String responseBody = responseEntity.getBody() != null ? responseEntity.getBody().toString() : null;
					lungAssessmentAssessmentResponseDTO = InputMapper.gson().fromJson(responseBody,
							LungAssessmentResponseDTO.class);
				} else
					throw new RuntimeException(
							"Lung assessment start assesment API exception. statusCode = " + responseEntity.getStatusCodeValue()
									+ " and response body from Lung assessment: " + responseEntity.getBody().toString());

				logger.info("start assesment success response: " + responseEntity.getBody());
				if (resultSet != null && resultSet.getId() != null && lungAssessmentAssessmentResponseDTO != null
						&& lungAssessmentAssessmentResponseDTO.getStatus().equalsIgnoreCase("SUCCESS")) {
					resultSet.setRecord_duration(lungAssessmentAssessmentResponseDTO.getData().getRecord_duration());
					resultSet.setStatus(lungAssessmentAssessmentResponseDTO.getData().getStatus());
					resultSet.setRisk(lungAssessmentAssessmentResponseDTO.getData().getRisk());
					resultSet.setCough_severity_score(lungAssessmentAssessmentResponseDTO.getData().getCough_severity_score());
					resultSet.setCough_pattern(lungAssessmentAssessmentResponseDTO.getData().getCough_pattern());
					resultSet.setDry_cough_count(lungAssessmentAssessmentResponseDTO.getData().getDry_cough_count());
					resultSet.setWet_cough_count(lungAssessmentAssessmentResponseDTO.getData().getWet_cough_count());
					resultSet.setSeverity(lungAssessmentAssessmentResponseDTO.getData().getSeverity());

					lungAssessmentRepository.save(resultSet);
				} else
					throw new RuntimeException("status from Lung assessment : " + lungAssessmentAssessmentResponseDTO.getStatus()
							+ " message from Lung assessment : " + lungAssessmentAssessmentResponseDTO.getData().getMessage());

			} else
				throw new RuntimeException("cough file validation is failed at lung assessment end");
		} catch (Exception e) {
			logger.error("Lung assessment API exception: " + e.getMessage());
			throw new RuntimeException("Lung assessment API exception : " + e.getMessage());
		}
		return new Gson().toJson(resultSet);
	}

	@Override
	public String getAssesment(String assessmentId) throws Exception {
		LungAssessmentResponseDTO lungAssessmentAssessmentResponseDTO = new LungAssessmentResponseDTO();
		LungAssessment lungAssessmentEntity = new LungAssessment();
		try {
			List<LungAssessment> assessmentResults = lungAssessmentRepository.findByAssessmentId(assessmentId);
			if (assessmentResults != null && assessmentResults.size() > 0) {
				if (assessmentResults.get(assessmentResults.size() - 1).getStatus() != null && assessmentResults
						.get(assessmentResults.size() - 1).getStatus().equalsIgnoreCase("SUCCESS")) {
					lungAssessmentEntity = assessmentResults.get(assessmentResults.size() - 1);
					return new Gson().toJson(lungAssessmentEntity);
				} else {
					long currTime = System.currentTimeMillis();

					String decryptlungAssessmentEmail = lungAssessmentEmail;
					String decryptlungAssessmentPassword = lungAssessmentPassword;
					if (lungAssessmentToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
						lungAssessmentToken = getLungAssessmentAdminLogin(decryptlungAssessmentEmail, decryptlungAssessmentPassword);

					RestTemplate restTemplate = new RestTemplate();
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.MULTIPART_FORM_DATA);
					headers.add("accessToken", lungAssessmentToken);

					logger.info("Lung assessment get assesment API - assessmentId =  " + assessmentId);

					MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
					bodyMap.add("assessmentId", assessmentId);

					HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
					logger.info("Lung assessment get assesment result request : " + requestEntity);
					ResponseEntity<String> responseEntity = restTemplate.exchange(lungAssessmentGetAssesmentUrl, HttpMethod.GET,
							requestEntity, String.class);


					if (responseEntity.getStatusCode() == HttpStatus.OK) {
						String responseBody = responseEntity.getBody() != null ? responseEntity.getBody().toString()
								: "";
						lungAssessmentAssessmentResponseDTO = InputMapper.gson().fromJson(responseBody,
								LungAssessmentResponseDTO.class);

						if (lungAssessmentEntity.getId() != null) {
							lungAssessmentEntity.setRecord_duration(lungAssessmentAssessmentResponseDTO.getData().getRecord_duration());
							lungAssessmentEntity.setStatus(lungAssessmentAssessmentResponseDTO.getData().getStatus());
							lungAssessmentEntity.setRisk(lungAssessmentAssessmentResponseDTO.getData().getRisk());
							lungAssessmentEntity.setCough_severity_score(
									lungAssessmentAssessmentResponseDTO.getData().getCough_severity_score());
							lungAssessmentEntity.setCough_pattern(lungAssessmentAssessmentResponseDTO.getData().getCough_pattern());
							lungAssessmentEntity.setDry_cough_count(lungAssessmentAssessmentResponseDTO.getData().getDry_cough_count());
							lungAssessmentEntity.setWet_cough_count(lungAssessmentAssessmentResponseDTO.getData().getWet_cough_count());
							lungAssessmentEntity.setSeverity(lungAssessmentAssessmentResponseDTO.getData().getSeverity());

							lungAssessmentRepository.save(lungAssessmentEntity);
						}

					} else
						throw new RuntimeException("Lung assessment get assesment API call failed with status code "
								+ responseEntity.getStatusCodeValue() + " and response : " + responseEntity);

					return new Gson().toJson(lungAssessmentEntity);

				}
			} else
				throw new Exception("Invalid assessment id, please pass correct assessment id");

		} catch (Exception e) {
			logger.error("get assesment API failed with error " + e.getMessage());
			throw new Exception("get assesment API failed with error : " + e.getLocalizedMessage());
		}

	}

	public String getAssessmentDetails(Long patientId) throws Exception {
		List<LungAssessment> resultSet = lungAssessmentRepository.findByPatientId(patientId);
		return new Gson().toJson(resultSet);
	}

}
