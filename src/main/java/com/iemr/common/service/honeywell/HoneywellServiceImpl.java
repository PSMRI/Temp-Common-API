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
package com.iemr.common.service.honeywell;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.common.data.report.CallQualityReport;
import com.iemr.common.notification.exception.IEMRException;
import com.iemr.common.repository.report.CRMCallReportRepo;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.mapper.OutputMapper;

@Service
public class HoneywellServiceImpl implements HoneywellService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	InputMapper inputMapper = new InputMapper();
	@Autowired
	private CRMCallReportRepo crmCallReportRepository;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

//	@PersistenceContext
//	private EntityManager entityManager;
	@Override
	public String getDistrictWiseCallReport(String request) throws Exception {
		logger.info("honeywell-getDistrictWisePercentageReport- start");
		logger.debug("getDistrictWiseCallReport request: " + OutputMapper.gson().toJson(request));
		CallQualityReport call = null;
		try {
			call = InputMapper.gson().fromJson(request, CallQualityReport.class);
		} catch (Exception e) {
			throw new IEMRException("Date format incorrect");
		}
		// Integer
		// totalCalls=crmCallReportRepository.totalCallsCount(call.getStartDate(),call.getEndDate());
		Integer totalCalls = 0;
		List<Objects[]> callQuality = null;
		JSONArray responseArray = new JSONArray();
		Integer count = 0;
		double p = 0.0;
		try {
			callQuality = crmCallReportRepository.allDistrictsCount(call.getStartDateTime(), call.getEndDateTime());
			// List<CallType> callTypes =
			// crmCallReportRepository.getCallType(call.getProviderServiceMapID());

			Integer districtID;
			String district = null;
			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 1) {
					totalCalls += ((BigInteger) objects[2]).intValue();
				}
			}
			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 1) {
					logger.info("objects" + objects);
					districtID = (Integer) objects[0];
					district = (String) objects[1];
					count = ((BigInteger) objects[2]).intValue();
					// count=crmCallReportRepository.districtCallCount(call.getStartDate(),call.getEndDate(),districtID);
					JSONObject result = new JSONObject();
//					logger.info("count" + count);
					result.put("district", district);
					p = 100.0 * ((double) count / totalCalls);
					result.put("perc", String.format("% .2f", p));
					responseArray.put(result);
					logger.info("responseArray" + responseArray);
				}
			}
		} catch (Exception e) {
			throw new IEMRException("Error while fetching district data");
		}
//		if (!list.isEmpty()) {
//			for (BenDetails obj : list) {
//				count=0;
//				
//				if(obj !=null) {
//				if ( obj.getDistrictID() != null && obj.getDistrict() != null ) {
//					//Long size = prepareTypedQuerydistrictWise(call); 
//					logger.info("object"+obj);
//					logger.info("obj"+obj.getDistrict());
//					logger.info("obj"+obj.getDistrictID());
//		             count=crmCallReportRepository.districtCallCount(call.getStartDate(),call.getEndDate(),obj.getDistrictID());
//			JSONObject result = new JSONObject();
//			logger.info("count"+count);
//			result.put("district", obj.getDistrictID());
//			result.put("perc", (count/totalCalls)*100);
//			responseArray.put(result);
//			logger.info("responseArray"+responseArray);
//		}
//				}
//			}
		// logger.debug("getDistrictWiseCallReport response: " +
		// OutputMapper.gson().toJson(responseArray));
		logger.info("honeywell-getDistrictWisePercentageReport - end");

//		Map<String, Object> resMap = new HashMap<String, Object>();
//		List<ReportType> reportTypes = crmCallReportRepository.getReportType();
//		if (reportTypes != null) {
//			resMap.put("qaReportTypes", reportTypes);
		if (responseArray != null)
			return responseArray.toString();
		else
			throw new IEMRException("No data available");
	}

	@Override
	public String getRealtimeDistrictWiseCallReport() throws Exception {
		logger.info("honeywell-getDistrictWisePercentageReport- start");
		// CallQualityReport call=null;
//		try {
//		 call = InputMapper.gson().fromJson(request, CallQualityReport.class);
//		}
//		catch(Exception e)
//		{
//			throw new IEMRException("Date format incorrect");
//		}
		// Integer
		// totalCalls=crmCallReportRepository.totalCallsCount(call.getStartDate(),call.getEndDate());
		Integer totalCalls = 0;
		List<Objects[]> callQuality = null;
		JSONArray responseArray = new JSONArray();
		Integer count = 0;
		double p = 0.0;
		try {
			Timestamp current = new Timestamp(System.currentTimeMillis());
			java.util.Date endDate = current;
//          Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

			String str2 = sdf2.format(endDate.getTime());

			endDate = sdf2.parse(str2);

			String endDateTime = sdf2.format(endDate);
			Timestamp start = Timestamp.valueOf(endDateTime);
			callQuality = crmCallReportRepository.allDistrictsCount(start, current);
			// List<CallType> callTypes =
			// crmCallReportRepository.getCallType(call.getProviderServiceMapID());

			Integer districtID;
			String district = null;
			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 1) {
					totalCalls += ((BigInteger) objects[2]).intValue();
				}
			}
			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 1) {
//					logger.info("objects" + objects);
					districtID = (Integer) objects[0];
					district = (String) objects[1];
					count = ((BigInteger) objects[2]).intValue();
					// count=crmCallReportRepository.districtCallCount(call.getStartDate(),call.getEndDate(),districtID);
					JSONObject result = new JSONObject();
//					logger.info("count" + count);
					result.put("district", district);
					p = 100.0 * ((double) count / totalCalls);
					result.put("perc", String.format("% .2f", p));
					responseArray.put(result);
					logger.info("responseArray" + responseArray);
				}
			}
		} catch (Exception e) {
			throw new IEMRException("Error while fetching district data");
		}
//		if (!list.isEmpty()) {
//			for (BenDetails obj : list) {
//				count=0;
//				
//				if(obj !=null) {
//				if ( obj.getDistrictID() != null && obj.getDistrict() != null ) {
//					//Long size = prepareTypedQuerydistrictWise(call); 
//					logger.info("object"+obj);
//					logger.info("obj"+obj.getDistrict());
//					logger.info("obj"+obj.getDistrictID());
//		             count=crmCallReportRepository.districtCallCount(call.getStartDate(),call.getEndDate(),obj.getDistrictID());
//			JSONObject result = new JSONObject();
//			logger.info("count"+count);
//			result.put("district", obj.getDistrictID());
//			result.put("perc", (count/totalCalls)*100);
//			responseArray.put(result);
//			logger.info("responseArray"+responseArray);
//		}
//				}
//			}
		// logger.debug("getDistrictWiseCallReport response: " +
		// OutputMapper.gson().toJson(responseArray));
		logger.info("honeywell-getDistrictWisePercentageReport - end");

//		Map<String, Object> resMap = new HashMap<String, Object>();
//		List<ReportType> reportTypes = crmCallReportRepository.getReportType();
//		if (reportTypes != null) {
//			resMap.put("qaReportTypes", reportTypes);
		if (responseArray != null)
			return responseArray.toString();
		else
			throw new IEMRException("No data available");
	}

	@Override
	public String getUrbanRuralCallReport(String request) throws Exception {
		CallQualityReport call = null;
		Map<String, Double> responseMap = new HashMap<String, Double>();
		try {
			call = InputMapper.gson().fromJson(request, CallQualityReport.class);

//			Integer totalCalls = 0;
			List<Objects[]> callQuality = null;
//
//			JSONArray responseArray = new JSONArray();
//			Integer count = 0;
//			Integer count1 = 0;
//			double p = 0.0;
//			double p1 = 0.0;
//
//			System.out.println(call.getStartDate());
//			System.out.println(call.getEndDate());
			if (call != null)
				callQuality = crmCallReportRepository.allRuralCount(call.getStartDate(), call.getEndDate());
			else
				throw new Exception("Invalid request");
			
			
			Boolean isRural;

			Integer rCount = 0;
			Integer uCount = 0;
			Integer tCount = 0;

			JSONObject result = new JSONObject();
			for (Object[] objects : callQuality) {
				if (objects != null && objects.length > 1) {
					logger.info("objects" + objects);
					// tCount += ((Integer) objects[1]).intValue();
					isRural = (Boolean) objects[0];
					if (isRural == false) {
						uCount = ((BigInteger) objects[1]).intValue();
						tCount += ((BigInteger) objects[1]).intValue();
					}
					if (isRural == true) {
						rCount = ((BigInteger) objects[1]).intValue();
						tCount += ((BigInteger) objects[1]).intValue();
					}

				}

			}

			if (tCount > 0) {
				responseMap.put("rural",
						new Double(df2.format((rCount.doubleValue() * 100) / tCount.doubleValue())));
				responseMap.put("urban",
						new Double(df2.format((uCount.doubleValue() * 100) / tCount.doubleValue())));
			}

		}

		catch (Exception e) {
			throw new IEMRException("Error while fetching Urban And Rural data");
		}
		return new Gson().toJson(responseMap);

	}

//]]		

}
