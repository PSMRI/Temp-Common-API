package com.iemr.common.service.swaasa;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.ws.http.HTTPException;

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
import com.iemr.common.data.swaasa.Swaasa;
import com.iemr.common.data.swaasa.SwaasaAssessmentResponseDTO;
import com.iemr.common.data.swaasa.SwaasaAuthenticateResponse;
import com.iemr.common.data.swaasa.SwaasaValidateCoughReponseDTO;
import com.iemr.common.repo.swaasa.SwaasaRepository;
import com.iemr.common.utils.CryptoUtil;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class SwassaServiceImpl implements SwaasaService {

	private static String swaasaToken;
	private static long authCreatedAt;

	private static HttpUtils httpUtils = new HttpUtils();
	
	@Autowired
	private CryptoUtil cryptoUtil;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${swaasaPath}")
	private String swaasaPath;

	@Value("${swaasaAdminLogin}")
	private String swaasaAdminLoginUrl;

	@Value("${swaasaEmail}")
	private String swassaEmail;

	@Value("${swaasaPassword}")
	private String swaasaPassword;

	@Value("${swaasaValidateCough}")
	private String swaasaValidateCoughUrl;

	@Value("${swaasaStartAssesment}")
	private String swassaAssesmentUrl;

	@Value("${swaasaGetAssesment}")
	private String swaasaGetAssesmentUrl;

	@Autowired
	private SwaasaRepository swaasaRepository;

	@Override
	public String getSwaasaAdminLogin(String email, String password) throws Exception {
		String swaasaToken = null;
		try {
			// Calling Swassa API to authenticate the user and get the access token
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
			bodyMap.add("email", email);
			bodyMap.add("password", password);

//			SwaasaAuthenticate authRequest = new SwaasaAuthenticate();
//			authRequest.setEmail(email);
//			authRequest.setPassword(password);

			logger.info("swaasa authentication request: " + bodyMap.toString());

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
			// HttpEntity<Object> requestEntity = new HttpEntity<Object>(authRequest,
			// headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(swaasaAdminLoginUrl, HttpMethod.POST,
					requestEntity, String.class);

			// Check if the response is successful
			if (responseEntity.getStatusCode() != HttpStatus.OK) {
				// API call failed, throw an exception

				throw new RuntimeException("swaasa authentication failed, statusCode : "
						+ responseEntity.getStatusCodeValue() + " response : " + responseEntity.toString());
			} else {
				String response = responseEntity.getBody() != null ? responseEntity.getBody() : null;
				SwaasaAuthenticateResponse responseBody = InputMapper.gson().fromJson(response,
						SwaasaAuthenticateResponse.class);

				if (responseBody != null && responseBody.getAccessToken() != null) {
					swaasaToken = responseBody.getAccessToken();

					authCreatedAt = System.currentTimeMillis();
				}
			}

			logger.info("swaasa authentication response: " + swaasaToken);

		} catch (HTTPException e) {
			logger.error("swaasa authentication error : " + e.getMessage(), e);
			throw new RuntimeException("get authentication failed with error", e);
		} catch (Exception e) {
			logger.error("swaasa authentication error : " + e.getMessage(), e);
			throw new RuntimeException("get authentication failed with error", e);
		}
		return swaasaToken;
	}

	@Override
	public Boolean verifyCough(MultipartFile file, String authToken, Long patientId) throws Exception {

		try {

			if (file == null || file.isEmpty())
				throw new Exception("file is missing,please pass a cough recording file");

			long currTime = System.currentTimeMillis();
			
			String decryptswaasaEmail = cryptoUtil.decrypt(swassaEmail);
			String decryptswaasaPassword = cryptoUtil.decrypt(swaasaPassword);
			if (swaasaToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
				swaasaToken = getSwaasaAdminLogin(decryptswaasaEmail, decryptswaasaPassword);

			// Calling verify cough API to validate the cough quality
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			headers.add("accessToken", authToken);

			byte[] bytes = file.getBytes();
			String tempFileName = "coughSoundVerify" + patientId + System.currentTimeMillis() + ".wav";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(swaasaPath + tempFileName)));
			stream.write(bytes);
			stream.close();

			MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
			bodyMap.add("coughsoundfile", new FileSystemResource(swaasaPath + tempFileName));

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

			logger.info("swaasa validate cough quality request : " + requestEntity);
			ResponseEntity<String> responseEntity = restTemplate.exchange(swaasaValidateCoughUrl, HttpMethod.POST,
					requestEntity, String.class);

			// Check if the response is successful
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				// API call failed, throw an exception
				String responseBody = responseEntity.getBody() != null ? responseEntity.getBody() : null;
				logger.info("swaasa validate cough quality response : " + responseBody);
				SwaasaValidateCoughReponseDTO obj = InputMapper.gson().fromJson(responseBody,
						SwaasaValidateCoughReponseDTO.class);

				Boolean isValidCough;
				if (obj != null) {
					isValidCough = (Boolean) obj.getData().get("isValidCough");
				} else
					throw new RuntimeException(
							"cough file validation is failed at swaasa end : response" + responseBody);

				if (isValidCough != null)
					return isValidCough;
				else
					throw new RuntimeException("cough file validation is failed at swaasa end : " + obj.getStatus());
			} else
				throw new RuntimeException("error from swaasa validate cough API : " + responseEntity.toString());
		} catch (Exception e) {
			logger.error("swaasa validate cough quality exception : ", e);
			throw new RuntimeException("swaasa validate cough quality exception : " + e.getMessage());
		}

	}

	@Override
	public String initiateAssesment(String request, MultipartFile file) throws Exception {
		Swaasa resultSet = new Swaasa();
		try {
			if (file == null || file.isEmpty())
				throw new Exception("file is missing,please pass a cough recording file");

			// map symptoms object to main entity
			Swaasa swaasaAssessmentRequestObj = InputMapper.gson().fromJson(request, Swaasa.class);
			if (swaasaAssessmentRequestObj != null && swaasaAssessmentRequestObj.getSymptoms() != null) {
				swaasaAssessmentRequestObj
						.setFrequent_cough(swaasaAssessmentRequestObj.getSymptoms().getFrequent_cough());
				swaasaAssessmentRequestObj.setSputum(swaasaAssessmentRequestObj.getSymptoms().getSputum());
				swaasaAssessmentRequestObj
						.setCough_at_night(swaasaAssessmentRequestObj.getSymptoms().getCough_at_night());
				swaasaAssessmentRequestObj.setWheezing(swaasaAssessmentRequestObj.getSymptoms().getWheezing());
				swaasaAssessmentRequestObj
						.setPain_in_chest(swaasaAssessmentRequestObj.getSymptoms().getPain_in_chest());
				swaasaAssessmentRequestObj
						.setShortness_of_breath(swaasaAssessmentRequestObj.getSymptoms().getShortness_of_breath());
			}

			if (swaasaAssessmentRequestObj.getPatientId() == null)
				throw new RuntimeException("Missing patient Id, please pass a valid patient Id");

			// check if swaasa session is active
			long currTime = System.currentTimeMillis();
			String decryptswaasaEmail = cryptoUtil.decrypt(swassaEmail);
			String decryptswaasaPassword = cryptoUtil.decrypt(swaasaPassword);
			if (swaasaToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
				swaasaToken = getSwaasaAdminLogin(decryptswaasaEmail, decryptswaasaPassword);

			// call swaasa verify cough API
			Boolean isCoughValidateSuccess = verifyCough(file, swaasaToken, swaasaAssessmentRequestObj.getPatientId());

			// Calling Swassa API to create the assessment, if validate cough is
			// success/true
			if (isCoughValidateSuccess) {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				headers.add("accessToken", swaasaToken);

				// create a random AssessmentId
				swaasaAssessmentRequestObj.setAssessmentId(
						"pid" + swaasaAssessmentRequestObj.getPatientId() + "salt" + System.currentTimeMillis());
				// save the request to DB
				resultSet = swaasaRepository.save(swaasaAssessmentRequestObj);

				// create file to system, share the path with swaasa API
				byte[] bytes = file.getBytes();
				String tempFileName = "coughSoundAssessment" + swaasaAssessmentRequestObj.getPatientId()
						+ System.currentTimeMillis() + ".wav";
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("swaasaPath" + tempFileName)));
				stream.write(bytes);
				stream.close();

				MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
//				bodyMap.add("coughsoundfile", new FileSystemResource("D:\\swaasa_audio\\" + tempFileName));
				bodyMap.add("symptoms", new Gson().toJson(swaasaAssessmentRequestObj.getSymptoms()));
				bodyMap.add("timestamp", swaasaAssessmentRequestObj.getTimestamp());
				bodyMap.add("age", swaasaAssessmentRequestObj.getAge());
				bodyMap.add("gender", swaasaAssessmentRequestObj.getGender());
				bodyMap.add("assessmentId", swaasaAssessmentRequestObj.getAssessmentId());
				bodyMap.add("patientId", swaasaAssessmentRequestObj.getPatientId());
				bodyMap.add("coughsoundfile", new FileSystemResource("swaasaPath" + tempFileName));

				HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

				logger.info("swaasa assessment API request: " + requestEntity);

				ResponseEntity<String> responseEntity = restTemplate.exchange(swassaAssesmentUrl, HttpMethod.POST,
						requestEntity, String.class);

				// Check if the response is successful
				SwaasaAssessmentResponseDTO swaasaAssessmentResponseDTO;
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					// API call failed, throw an exception
					String responseBody = responseEntity.getBody() != null ? responseEntity.getBody().toString() : null;
					swaasaAssessmentResponseDTO = InputMapper.gson().fromJson(responseBody,
							SwaasaAssessmentResponseDTO.class);
				} else
					throw new RuntimeException(
							"swaasa start assesment API exception. statusCode = " + responseEntity.getStatusCodeValue()
									+ " and response body from Swaasa: " + responseEntity.getBody().toString());

				logger.info("start assesment success response: " + responseEntity.getBody());
				if (resultSet != null && resultSet.getId() != null && swaasaAssessmentResponseDTO != null
						&& swaasaAssessmentResponseDTO.getStatus().equalsIgnoreCase("SUCCESS")) {
					resultSet.setRecord_duration(swaasaAssessmentResponseDTO.getData().getRecord_duration());
					resultSet.setStatus(swaasaAssessmentResponseDTO.getData().getStatus());
					resultSet.setRisk(swaasaAssessmentResponseDTO.getData().getRisk());
					resultSet.setCough_severity_score(swaasaAssessmentResponseDTO.getData().getCough_severity_score());
					resultSet.setCough_pattern(swaasaAssessmentResponseDTO.getData().getCough_pattern());
					resultSet.setDry_cough_count(swaasaAssessmentResponseDTO.getData().getDry_cough_count());
					resultSet.setWet_cough_count(swaasaAssessmentResponseDTO.getData().getWet_cough_count());
					resultSet.setSeverity(swaasaAssessmentResponseDTO.getData().getSeverity());

					// update the result in DB
					swaasaRepository.save(resultSet);
				} else
					throw new RuntimeException("status from Swaasa : " + swaasaAssessmentResponseDTO.getStatus()
							+ " message from Swaasa : " + swaasaAssessmentResponseDTO.getData().getMessage());

			} else
				throw new RuntimeException("cough file validation is failed at swaasa end");
		} catch (Exception e) {
			logger.error("swaasa assessment API exception: " + e.getMessage());
			throw new RuntimeException("swaasa assessment API exception : " + e.getMessage());
		}
		return new Gson().toJson(resultSet);
	}

	@Override
	public String getAssesment(String assessmentId) throws Exception {
		SwaasaAssessmentResponseDTO swaasaAssessmentResponseDTO = new SwaasaAssessmentResponseDTO();
		Swaasa swaasaEntity = new Swaasa();
		try {
			List<Swaasa> assessmentResults = swaasaRepository.findByAssessmentId(assessmentId);
			if (assessmentResults != null && assessmentResults.size() > 0) {
				if (assessmentResults.get(assessmentResults.size() - 1).getStatus() != null && assessmentResults
						.get(assessmentResults.size() - 1).getStatus().equalsIgnoreCase("SUCCESS")) {
					swaasaEntity = assessmentResults.get(assessmentResults.size() - 1);
					return new Gson().toJson(swaasaEntity);
				} else {
					long currTime = System.currentTimeMillis();
					
					String decryptswaasaEmail = cryptoUtil.decrypt(swassaEmail);
					String decryptswaasaPassword = cryptoUtil.decrypt(swaasaPassword);
					if (swaasaToken == null || (((currTime - authCreatedAt) / (60 * 1000))) > 110)
						swaasaToken = getSwaasaAdminLogin(decryptswaasaEmail, decryptswaasaPassword);

					// Calling Swassa API to get the assessment result
					RestTemplate restTemplate = new RestTemplate();
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.MULTIPART_FORM_DATA);
					headers.add("accessToken", swaasaToken);

					logger.info("swaasa get assesment API - assessmentId =  " + assessmentId);

					MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<String, Object>();
					bodyMap.add("assessmentId", assessmentId);

					HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
					logger.info("swaasa get assesment result request : " + requestEntity);
					ResponseEntity<String> responseEntity = restTemplate.exchange(swaasaGetAssesmentUrl, HttpMethod.GET,
							requestEntity, String.class);

					// Check if the response is successful

					if (responseEntity.getStatusCode() == HttpStatus.OK) {
						// API call failed, throw an exception
						String responseBody = responseEntity.getBody() != null ? responseEntity.getBody().toString()
								: "";
						swaasaAssessmentResponseDTO = InputMapper.gson().fromJson(responseBody,
								SwaasaAssessmentResponseDTO.class);

						if (swaasaEntity.getId() != null) {
							swaasaEntity.setRecord_duration(swaasaAssessmentResponseDTO.getData().getRecord_duration());
							swaasaEntity.setStatus(swaasaAssessmentResponseDTO.getData().getStatus());
							swaasaEntity.setRisk(swaasaAssessmentResponseDTO.getData().getRisk());
							swaasaEntity.setCough_severity_score(
									swaasaAssessmentResponseDTO.getData().getCough_severity_score());
							swaasaEntity.setCough_pattern(swaasaAssessmentResponseDTO.getData().getCough_pattern());
							swaasaEntity.setDry_cough_count(swaasaAssessmentResponseDTO.getData().getDry_cough_count());
							swaasaEntity.setWet_cough_count(swaasaAssessmentResponseDTO.getData().getWet_cough_count());
							swaasaEntity.setSeverity(swaasaAssessmentResponseDTO.getData().getSeverity());

							swaasaRepository.save(swaasaEntity);
						}

					} else
						throw new RuntimeException("Swassa get assesment API call failed with status code "
								+ responseEntity.getStatusCodeValue() + " and response : " + responseEntity);

					return new Gson().toJson(swaasaEntity);

				}
			} else
				throw new Exception("Invalid assessment id, please pass correct assessment id");

		} catch (Exception e) {
			logger.error("get assesment API failed with error " + e.getMessage());
			throw new Exception("get assesment API failed with error : " + e.getLocalizedMessage());
		}

	}

	public String getAssessmentDetails(Long patientId) throws Exception {
		List<Swaasa> resultSet = swaasaRepository.findByPatientId(patientId);
		return new Gson().toJson(resultSet);
	}

}
