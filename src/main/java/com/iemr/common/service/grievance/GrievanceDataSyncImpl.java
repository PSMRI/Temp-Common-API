package com.iemr.common.service.grievance;



	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.json.JSONObject;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.util.LinkedMultiValueMap;
	import org.springframework.util.MultiValueMap;
	import org.springframework.web.client.RestTemplate;

	import com.google.gson.JsonElement;
	import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;
	import com.iemr.common.data.grievance.GrievanceDetails;
	import com.iemr.common.data.grievance.GrievanceTransaction;

	import com.iemr.common.repository.grievance.GrievanceDataRepo;
	import com.iemr.common.repository.grievance.GrievanceFetchBenDetailsRepo;
	import com.iemr.common.repository.grievance.GrievanceTransactionRepo;
	import com.iemr.common.repository.location.LocationStateRepository;
	import com.iemr.common.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class GrievanceDataSyncImpl {
	    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	    RestTemplate restTemplateLogin = new RestTemplate();

	    @Autowired
	    private GrievanceDataRepo grievanceDataRepo;

	    @Autowired
	    private GrievanceTransactionRepo grievanceTransactionRepo;
	    
	    @Autowired
	    private GrievanceFetchBenDetailsRepo grievanceFetchBenDetailsRepo;

	    @Autowired
	    private LocationStateRepository locationStateRepository;

	    @Value("${greivanceUserAuthenticate}")
	    private String grievanceUserAuthenticate;

	    @Value("${updateGrievanceDetails}")
	    private String updateGrievanceDetails;

	    @Value("${updateGrievanceTransactionDetails}")
	    private String updateGrievanceTransactionDetails;

	    @Value("${grievanceUserName}")
	    private String grievanceUserName;

	    @Value("${grievancePassword}")
	    private String grievancePassword;

	    @Value("${grievanceDataSyncDuration}")
	    private String grievanceDataSyncDuration;

	    private static String GRIEVANCE_AUTH_TOKEN;
	    private static Long GRIEVANCE_TOKEN_EXP;

	    public List<Map<String, Object>> dataSyncToGrievance(String grievanceAuthorization, String registeringUser,
	            String Authorization) {

	        int count = 0;
	        List<Map<String, Object>> responseData = new ArrayList<>();
	        List<GrievanceDetails> grievanceDetailsListAS = null;
	        try {
	            // Loop to fetch data for multiple pages
	            while (count >= 0) {
	                RestTemplate restTemplate = new RestTemplate();

	                if (GRIEVANCE_AUTH_TOKEN != null && GRIEVANCE_TOKEN_EXP != null
	                        && GRIEVANCE_TOKEN_EXP > System.currentTimeMillis()) {
	                    // no need of calling auth API
	                } else {
	                    // call method to generate Auth Token at Everwell end
	                    generateGrievanceAuthToken();
	                }

	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	                headers.add("user-agent",
	                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	                headers.add("AUTHORIZATION", GRIEVANCE_AUTH_TOKEN);

	                Date date = new Date();
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	                String text = sqlDate.toString();
	                Timestamp currentDate = new Timestamp(sqlDate.getTime());
	                Calendar calendar = Calendar.getInstance();
	                calendar.setTime(sqlDate);
	                calendar.add(Calendar.DATE, -Integer.parseInt(grievanceDataSyncDuration));
	                Date beforeDate = calendar.getTime();
	                Timestamp lastDate = new Timestamp(beforeDate.getTime());

	                // Request object
	                HttpEntity<Object> request = new HttpEntity<Object>(headers);

	                // Call rest-template to call API to download master data for given table
	                ResponseEntity<String> response = restTemplate.exchange(updateGrievanceDetails, HttpMethod.POST, request,
	                        String.class);

	                if (response != null && response.hasBody()) {
	                    JSONObject obj = new JSONObject(response.getBody());
	                    if (obj != null && obj.has("data") && obj.has("statusCode") && obj.getInt("statusCode") == 200) {
	                        logger.info("Grievance data details response: " + response.getBody());

	                        String responseStr = response.getBody();
	                        JsonObject jsnOBJ = new JsonObject();
	                        JsonParser jsnParser = new JsonParser();
	                        JsonElement jsnElmnt = jsnParser.parse(responseStr);
	                        jsnOBJ = jsnElmnt.getAsJsonObject();
	                        JsonObject grievanceJsonData = jsnOBJ.getAsJsonObject("data");

	                        if (Integer.parseInt(jsnOBJ.get("TotalRecords").toString()) > 0) {
	                            GrievanceDetails[] grievanceDetailsArray = InputMapper.gson().fromJson(jsnOBJ.get("Data").toString(), GrievanceDetails[].class);
	                            List<GrievanceDetails> grievanceDetailsList = Arrays.asList(grievanceDetailsArray);

	                            // Fetch transaction details and integrate them with the grievance details
//	                            for (GrievanceDetails grievance : grievanceDetailsList) {
//	                                String complaintId = grievance.getGrievanceId();
//	                                String formattedComplaintId = complaintId.replace("\\/", "/");
//	                                grievance.setGrievanceId(formattedComplaintId);
//
//	                                // Fetch related grievance transaction details
//	                                List<GrievanceTransactionDetails> transactionDetailsList = fetchGrievanceTransactions(formattedComplaintId);
//
//	                                if (transactionDetailsList != null && !transactionDetailsList.isEmpty()) {
//	                                    // Save transactions to the t_grievance_transaction table
//	                                    grievanceTransactionRepo.saveAll(transactionDetailsList);
//	                                    // Add the transaction list to the grievance object
//	                                    grievance.setGrievanceTransactionDetails(transactionDetailsList);
//	                                }
//
//	                                // Adding other grievance-related fields
//	                                grievance.setSubjectOfComplaint(grievanceJsonData.get("subject").getAsString());
//	                                ArrayList<Object[]> lists = grievanceFetchBenDetailsRepo.findByComplaintId(formattedComplaintId);
//
//	                                for (Object[] objects : lists) {
//	                                    if (objects != null && objects.length <= 4) {
//	                                        grievance.setComplaintId((String) objects[0]);
//	                                        grievance.setBeneficiaryRegId((Long) objects[1]);
//	                                        grievance.setBencallId((Long) objects[2]);
//	                                        grievance.setProviderServiceMapId((Integer) objects[3]);
//	                                        String state = locationStateRepository.findByStateIDForGrievance((Integer) objects[4]);
//	                                        grievance.setState(state);
//	                                    }
//	                                }
//
//	                                grievance.setAgentId(grievance.getAgentId());
//	                                grievance.setDeleted(grievance.getDeleted());
//	                                grievance.setCreatedBy(registeringUser);
//	                                grievance.setProcessed('N');
//	                                grievance.setIsAllocated(false);
//	                                grievance.setCallCounter(0);
//	                                grievance.setRetryNeeded(true);
//	                            }

	                           //////////////////////
	                         // Loop through the fetched grievance list and integrate transaction details
	                            for (GrievanceDetails grievance : grievanceDetailsList) {
	                                String complaintId = grievanceJsonData.get("complainId").getAsString();
	                                String formattedComplaintId = complaintId.replace("\\/", "/");
	                                
	                                // Check if the complaintId is already present in the t_grievance_worklist table
	                                boolean complaintExists = grievanceDataRepo.existsByComplaintId(formattedComplaintId);
	                                if (complaintExists) {
	                                    throw new RuntimeException("Complaint ID " + formattedComplaintId + " already exists in the grievance worklist table.");
	                                }
	                                
	                                
	                                grievance.setComplaintId(formattedComplaintId);

	                                // Fetch related grievance transaction details
	                                List<GrievanceTransaction> transactionDetailsList = fetchGrievanceTransactions(formattedComplaintId);

	                                if (transactionDetailsList != null && !transactionDetailsList.isEmpty()) {
	                                    // Loop through each transaction and set individual properties
	                                    for (GrievanceTransaction transactionDetails : transactionDetailsList) {

	                                    	  // Assuming transactionDetailsJson is the JSON object representing a single transaction from the API response
	                                        JsonObject transactionDetailsJson = grievanceJsonData.getAsJsonObject("transactionDetails"); // or another relevant path
	                                        
	                                        // Adding properties for each transaction detail
	                                       // transactionDetails.setComplaintId(formattedComplaintId);
	                                        // Assuming these fields are coming from your API response
	                                        transactionDetails.setActionTakenBy(transactionDetailsJson.get("actionTakenBy").getAsString());
	                                        transactionDetails.setStatus(transactionDetailsJson.get("status").getAsString());
	                                        transactionDetails.setFileName(transactionDetailsJson.has("fileName") ? transactionDetailsJson.get("fileName").getAsString() : null);
	                                        transactionDetails.setFileType(transactionDetailsJson.has("fileType") ? transactionDetailsJson.get("fileType").getAsString() : null);
	                                        transactionDetails.setRedressed(transactionDetailsJson.get("redressed").getAsString());
	                                        transactionDetails.setCreatedAt(Timestamp.valueOf(transactionDetailsJson.get("createdAt").getAsString()));
	                                        transactionDetails.setUpdatedAt(Timestamp.valueOf(transactionDetailsJson.get("updatedAt").getAsString()));
	                                        transactionDetails.setComment(transactionDetailsJson.get("comment").getAsString());

	                                        // Save individual transaction detail in the t_grievance_transaction table
	                                        grievanceTransactionRepo.save(transactionDetails);
	                                    }

	                                    // Add the transaction list to the grievance object
	                                    grievance.setGrievanceTransactionDetails(transactionDetailsList);
	                                }

	                                // Adding other grievance-related fields (similar to the existing code)
	                                grievance.setSubjectOfComplaint(grievanceJsonData.get("subject").getAsString());
	                                ArrayList<Object[]> lists = grievanceFetchBenDetailsRepo.findByComplaintId(formattedComplaintId);

	                                for (Object[] objects : lists) {
	                                    if (objects != null && objects.length <= 4) {
	                                        grievance.setComplaintId((String) objects[0]);
	                                        grievance.setBeneficiaryRegId((Long) objects[1]);
	                                        grievance.setBencallId((Long) objects[2]);
	                                        grievance.setProviderServiceMapId((Integer) objects[3]);
	                                        String state = locationStateRepository.findByStateIDForGrievance((Integer) objects[4]);
	                                        grievance.setState(state);
	                                    }
	                                }

	                                // Setting remaining grievance properties (similar to the existing code)
	                                grievance.setAgentId(grievance.getAgentId());
	                                grievance.setDeleted(grievance.getDeleted());
	                                grievance.setCreatedBy(registeringUser);
	                                grievance.setProcessed('N');
	                                grievance.setIsAllocated(false);
	                                grievance.setCallCounter(0);
	                                grievance.setRetryNeeded(true);
	                            }

	                            // Save the grievance details to the t_grievance table
	                            grievanceDetailsListAS = (List<GrievanceDetails>) grievanceDataRepo.saveAll(grievanceDetailsList);

	                            // Combine grievance and transaction data for response 
	                            
	                            for (GrievanceDetails grievance : grievanceDetailsListAS) {
	                                Map<String, Object> combinedData = new HashMap<>();
	                                combinedData.put("complaintID", grievance.getGrievanceId());
	                                combinedData.put("subjectOfComplaint", grievance.getSubjectOfComplaint());
	                                combinedData.put("complaint", grievance.getComplaint());
	                                combinedData.put("beneficiaryRegID", grievance.getBeneficiaryRegId());
	                                combinedData.put("providerServiceMapId", grievance.getProviderServiceMapId());
	                             //   combinedData.put("firstName", grievance.getFirstName());
	                             //   combinedData.put("lastName", grievance.getLastName());
	                                combinedData.put("primaryNumber", grievance.getPrimaryNumber());

	                                // Add transaction data
	                                List<Map<String, Object>> transactions = new ArrayList<>();
	                                for (GrievanceTransaction transaction : grievance.getGrievanceTransactionDetails()) {
	                                    Map<String, Object> transactionData = new HashMap<>();
	                                    transactionData.put("actionTakenBy", transaction.getActionTakenBy());
	                                    transactionData.put("status", transaction.getStatus());
	                                    transactionData.put("fileName", transaction.getFileName());
	                                    transactionData.put("fileType", transaction.getFileType());
	                                    transactionData.put("redressed", transaction.getRedressed());
	                                    transactionData.put("createdAt", transaction.getCreatedAt().toString());
	                                    transactionData.put("updatedAt", transaction.getUpdatedAt().toString());
	                                    transactionData.put("comment", transaction.getComment());
	                                    transactions.add(transactionData);
	                                }

	                                combinedData.put("transaction", transactions);
	                                combinedData.put("severity", grievance.getSeverety());
	                                combinedData.put("state", grievance.getState());
	                                combinedData.put("agentId", grievance.getAgentId());
	                                combinedData.put("deleted", grievance.getDeleted());
	                                combinedData.put("createdBy", grievance.getCreatedBy());
	                                combinedData.put("createdDate", grievance.getCreatedDate());
	                                combinedData.put("lastModDate", grievance.getLastModDate());
	                                combinedData.put("isCompleted", grievance.getIsCompleted());
	                             //   combinedData.put("gender", grievance.getGender());
	                             //   combinedData.put("district", grievance.getDistrict());
	                             //   combinedData.put("beneficiaryID", grievance.getBeneficiaryId());
	                             //   combinedData.put("age", grievance.getAge());
	                                combinedData.put("retryNeeded", grievance.getRetryNeeded());
	                                combinedData.put("callCounter", grievance.getCallCounter());
	                            //    combinedData.put("lastCall", grievance.getLastCall());

	                                responseData.add(combinedData);
	                            }
	                        

	                            // Return the combined response as required
	                     //       return responseData;

	                        } else {
	                            logger.info("No records found for page = " + count);
	                            count = -1;
	                        }
	                    }
	                }
	            }
	        } catch (Exception e) {
	            logger.error("Error in saving data into t_grievanceworklist: ", e);
	        }
	        return responseData;
	    }

	    private List<GrievanceTransaction> fetchGrievanceTransactions(String complaintId) {
	        List<GrievanceTransaction> transactionDetailsList = new ArrayList<>();
	        try {
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	            headers.add("user-agent",
	                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	            headers.add("AUTHORIZATION", GRIEVANCE_AUTH_TOKEN);

	            HttpEntity<Object> request = new HttpEntity<Object>(headers);
	            RestTemplate restTemplate = new RestTemplate();
	            ResponseEntity<String> response = restTemplate.exchange(updateGrievanceTransactionDetails, HttpMethod.POST, request, String.class);

	            if (response != null && response.hasBody()) {
	                JSONObject obj = new JSONObject(response.getBody());
	                if (obj != null && obj.has("data") && obj.has("statusCode") && obj.getInt("statusCode") == 200) {
	                    JsonObject jsnOBJ = new JsonObject();
	                    JsonParser jsnParser = new JsonParser();
	                    JsonElement jsnElmnt = jsnParser.parse(response.getBody());
	                    jsnOBJ = jsnElmnt.getAsJsonObject();
	                    GrievanceTransaction[] transactionDetailsArray = InputMapper.gson().fromJson(jsnOBJ.get("Data").toString(), GrievanceTransaction[].class);
	                    transactionDetailsList = Arrays.asList(transactionDetailsArray);
	                }
	            }
	        } catch (Exception e) {
	            logger.error("Error fetching grievance transaction details for complaintId " + complaintId, e);
	        }
	        return transactionDetailsList;
	    }

	    private void generateGrievanceAuthToken() {
	        String Authorization = "";
	        String registeringUser = "";
	        MultiValueMap<String, String> requestData = new LinkedMultiValueMap<String, String>();
	        requestData.add("username", grievanceUserName);
	        requestData.add("password", grievancePassword);
	        requestData.add("grant_type", "password");
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        httpHeaders.add("user-agent",
	                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

	        HttpEntity<MultiValueMap<String, String>> httpRequestEntity = new HttpEntity<MultiValueMap<String, String>>(
	                requestData, httpHeaders);
	        ResponseEntity<String> responseEntity = restTemplateLogin.exchange(grievanceUserAuthenticate, HttpMethod.POST,
	                httpRequestEntity, String.class);

	        if (responseEntity != null && responseEntity.getStatusCodeValue() == 200 && responseEntity.hasBody()) {
	            String responseBody = responseEntity.getBody();
	            JsonObject jsnOBJ = new JsonObject();
	            JsonParser jsnParser = new JsonParser();
	            JsonElement jsnElmnt = jsnParser.parse(responseBody);
	            jsnOBJ = jsnElmnt.getAsJsonObject();
	            GRIEVANCE_AUTH_TOKEN = jsnOBJ.get("token_type").getAsString() + " "
	                    + jsnOBJ.get("access_token").getAsString();
	            
	            JsonObject grievanceLoginJsonData = jsnOBJ.getAsJsonObject("data");
	            Authorization = grievanceLoginJsonData.get("key").getAsString();
	            registeringUser = grievanceLoginJsonData.get("userName").getAsString();
	            
	            logger.info("Auth key generated at : " + System.currentTimeMillis() + ", Key : " + GRIEVANCE_AUTH_TOKEN);

	            Date date = new Date();
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	            Calendar grievanceCalendar = Calendar.getInstance();
	            grievanceCalendar.setTime(sqlDate);
	            grievanceCalendar.add(Calendar.DATE, 29);
	            Date grievanceTokenEndDate = grievanceCalendar.getTime();
	            // setting Token expiry - 29 days
	            GRIEVANCE_TOKEN_EXP = grievanceTokenEndDate.getTime();

	            int count = 3;
	            while (count > 0) {
	                List<Map<String, Object>> savedGrievanceData = dataSyncToGrievance(GRIEVANCE_AUTH_TOKEN, registeringUser,
	                        Authorization);
	                if (savedGrievanceData != null)
	                    break;
	                else
	                    count--;
	            }
	        }
	    }
	}


