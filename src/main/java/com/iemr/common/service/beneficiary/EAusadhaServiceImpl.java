package com.iemr.common.service.beneficiary;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.iemr.common.data.eausadha.ItemMaster;
import com.iemr.common.data.eausadha.ItemStockEntry;
import com.iemr.common.data.facility.Facility;
import com.iemr.common.model.eAusadha.EAusadhaDTO;
import com.iemr.common.repository.eausadha.ItemMasterRepo;
import com.iemr.common.repository.eausadha.ItemStockEntryRepo;
import com.iemr.common.repository.facility.FacilityRepo;

@Service
public class EAusadhaServiceImpl implements EAusadhaService {

	@Autowired
	private FacilityRepo facilityRepo;
	@Autowired
	private ItemMasterRepo itemMasterRepo;
	@Autowired
	private ItemStockEntryRepo itemStockEntryRepo;

	@Value("${eAusadhaUrl}")
	private String eAusadhaUrl;


	@Value("${eausadhaAuthorization}")
	private String authorization;


	

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public String createEAusadha(EAusadhaDTO eAusadhaDTO, String Authorization) throws Exception {
		List<Map<String, String>> failedStockList = new ArrayList<>();
		String drugId = null;
		String batchNumber = null;
		String drugName = null;
		Integer lengthOfArray = null;

		String inwardDate = null;


		Map<String, String> resMap = new HashMap<>();
		Map<String, String> resultMap = new HashMap<>();
		Map<String, Object> responseMap = new HashMap<>();

		String institutionId = facilityRepo.fetchInstitutionId(eAusadhaDTO.getFacilityId());

		if (eAusadhaDTO.getInwardDate() != null) {
			LocalDateTime localDateTime = eAusadhaDTO.getInwardDate().toLocalDateTime();
			SimpleDateFormat inwardDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			inwardDate = inwardDateFormat.format(eAusadhaDTO.getInwardDate());


		}

		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", MediaType.APPLICATION_JSON + ";charset=utf-8");
		headers.add("AUTHORIZATION", authorization);
		// create a map to hold both inwardDate and institutionId
		Map<String, Object> request = new HashMap<>();
		request.put("InwardDate", inwardDate);
		request.put("InstituteId", institutionId);

		HttpEntity<Map<String, Object>> requestObj = new HttpEntity<>(request, headers);

		logger.info("calling eausadha api:" + request);

		ResponseEntity<String> response = restTemplate.exchange(eAusadhaUrl, HttpMethod.POST, requestObj, String.class);
		logger.info("getting eausadha response:" + response);

		if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
			String responseStr = response.getBody();
			JSONArray responseArray = new JSONArray(responseStr);
			lengthOfArray = responseArray.length();
			Integer successCount = 0;


			for (int i = 0; i < lengthOfArray; i++) {
				JSONObject obj = responseArray.getJSONObject(i);

				drugId = obj.getString("Drug_id");
				batchNumber = obj.getString("Batch_number");
				drugName = obj.getString("Drug_name");


				List<ItemMaster> itemCodeList = itemMasterRepo.findByItemCode(drugId);
				ItemMaster itemCode=null;
				if (!itemCodeList.isEmpty()) {
					 itemCode = itemCodeList.get(0);
				}

				Integer facilityId = eAusadhaDTO.getFacilityId();
				if (itemCode != null && null != itemCode.getItemID()) {
					Integer itemId = itemCode.getItemID();
					ItemStockEntry itemStock = itemStockEntryRepo.getItemStocks(itemId, batchNumber);
					if (itemStock == null && ObjectUtils.isEmpty(itemStock)) {
						ItemStockEntry itemStockEntry = saveItemStockEntry(obj, facilityId, itemId);

						if (itemStockEntry != null && itemStockEntry.getItemStockEntryID() != null) {

							itemStockEntryRepo.updateVanSerialNo(itemStockEntry.getItemStockEntryID());
						}
						successCount++;
					}
				} else {
					Map<String, String> failedStockItem = new HashMap<>();
					failedStockItem.put("DrugName", drugName);
					failedStockItem.put("BatchNo", batchNumber);
					failedStockList.add(failedStockItem);
				}

			}
			if (0 == successCount) {
				throw new Exception("Error while entering the stocks");
			} else {
				resultMap.put("response", "Stock entered Successfully");
				responseMap.put("response", resultMap);
				responseMap.put("failedStocks", failedStockList);
			}

		} else
			throw new Exception("Error while getting stock response" + response.toString());
		return new Gson().toJson(responseMap);

	}

	private ItemStockEntry saveItemStockEntry(JSONObject responseOBJ, Integer faciityId, Integer itemId) {
		ItemStockEntry newItem = new ItemStockEntry();
		newItem.setFacilityID(faciityId);
		newItem.setItemID(itemId);
		newItem.setBatchNo(responseOBJ.getString("Batch_number"));
		newItem.setQuantityInHand(responseOBJ.getInt("Quantity_In_Units"));
		newItem.setQuantity(responseOBJ.getInt("Quantity_In_Units"));
		newItem.setSyncFacilityID(faciityId);
		newItem.setEntryType("eAusadhaStockEntry");
		newItem.setEntryTypeID(1000);
		Date date = Date.valueOf(responseOBJ.getString("Exp_date"));
		newItem.setExpiryDate(date);
		newItem.setCreatedBy("user");
		itemStockEntryRepo.save(newItem);
		return newItem;
	}

}
