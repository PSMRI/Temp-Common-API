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
package com.iemr.common.service.otp;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.primitives.Ints;
import com.iemr.common.data.otp.OTPRequestParsor;
import com.iemr.common.service.users.IEMRAdminUserServiceImpl;
import com.iemr.common.utils.CryptoUtil;
import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.http.HttpUtils;

/***
 * 
 * @author NE298657
 * @date DD/MM/YYYY - 10/08/2020
 * 
 * @implSpec handle OTP flow business rule
 */

@Service
public class OTPHandlerImpl implements OTPHandler {
	
	@Autowired
	private CryptoUtil cryptoUtil;
	
	@Autowired
	HttpUtils httpUtils;
	@Autowired
	private IEMRAdminUserServiceImpl iEMRAdminUserServiceImpl;

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private LoadingCache<String, String> otpCache;

	private static final Integer EXPIRE_MIN = 5;
	private static final String SMS_GATEWAY_URL = ConfigProperties.getPropertyByName("sms-gateway-url");

	// Constructor for new object creation
	public OTPHandlerImpl() {
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
				.build(new CacheLoader<String, String>() {
					public String load(String key) {
						return "0";
					}
				});
	}

	/***
	 * @param obj
	 * @return success if OTP sent successfully
	 */
	@Override
	public String sendOTP(OTPRequestParsor obj) throws Exception {
		int otp = generateOTP(obj.getMobNo());
		sendSMS(otp, obj.getMobNo(), "OTP is ");
		return "success";
	}

	/***
	 * @param obj
	 * @return OTP verification success or failure
	 * 
	 */
	@Override
	public JSONObject validateOTP(OTPRequestParsor obj) throws Exception {
		String cachedOTP = otpCache.get(obj.getMobNo());
		String inputOTPEncrypted = getEncryptedOTP(obj.getOtp());

		if (cachedOTP.equalsIgnoreCase(inputOTPEncrypted)) {
			JSONObject responseObj = new JSONObject();
			responseObj.put("userName", obj.getMobNo());
			responseObj.put("userID", obj.getMobNo());

			JSONObject responseOBJ = iEMRAdminUserServiceImpl.generateKeyPostOTPValidation(responseObj);

			return responseOBJ;
		} else {
			throw new Exception("Please enter valid OTP");
		}

	}

	/***
	 * @param obj
	 * @return success if OTP re-sent successfully
	 */
	@Override
	public String resendOTP(OTPRequestParsor obj) throws Exception {
		int otp = generateOTP(obj.getMobNo());
		sendSMS(otp, obj.getMobNo(), "OTP is ");
		return "success";
	}

	// generate 6 digit random no #
	public int generateOTP(String authKey) throws Exception {
		String generatedPassword = null;

//		Random random = new Random();
		Random random = SecureRandom.getInstanceStrong();
		int otp = 100000 + random.nextInt(900000);

		generatedPassword = getEncryptedOTP(otp);

		if (otpCache != null)
			otpCache.put(authKey, generatedPassword);
		else {
			OTPHandlerImpl obj = new OTPHandlerImpl();
			obj.otpCache.put(authKey, generatedPassword);
		}
		return otp;
	}

	// SHA-256 encoding logic implemented
	private String getEncryptedOTP(int otp) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] bytes = md.digest(Ints.toByteArray(otp));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

	// send SMS to user
	private void sendSMS(int otp, String phoneNo, String msgText) throws Exception {
		// Boolean doSendSMS = ConfigProperties.getBoolean("send-sms");

		String sendSMSURL = ConfigProperties.getPropertyByName("send-message-url");
		String sendSMSAPI = OTPHandlerImpl.SMS_GATEWAY_URL + "/" + sendSMSURL;
		String senderName = ConfigProperties.getPropertyByName("sms-username");
		String senderPassword = ConfigProperties.getPropertyByName("sms-password");
		String senderNumber = ConfigProperties.getPropertyByName("sms-sender-number");

		sendSMSAPI = sendSMSAPI.replace("USERNAME", senderName).replace("PASSWORD", senderPassword)
				.replace("SENDER_NUMBER", senderNumber);

		sendSMSAPI = sendSMSAPI
				.replace("SMS_TEXT",
						msgText.concat(String.valueOf(otp))
								.concat(" for Tele-consultation verification and validity is 5 mins"))
				.replace("RECEIVER_NUMBER", phoneNo);

		ResponseEntity<String> response = httpUtils.getV1(sendSMSAPI);
		if (response.getStatusCodeValue() == 200) {
			String smsResponse = response.getBody();
			// JSONObject obj = new JSONObject(smsResponse);
			// String jobID = obj.getString("JobId");
			switch (smsResponse) {
			case "0x200 - Invalid Username or Password":
			case "0x201 - Account suspended due to one of several defined reasons":
			case "0x202 - Invalid Source Address/Sender ID. As per GSM standard, the sender ID should "
					+ "be within 11 characters":
			case "0x203 - Message length exceeded (more than 160 characters) if concat is set to 0":
			case "0x204 - Message length exceeded (more than 459 characters) in concat is set to 1":
			case "0x205 - DRL URL is not set":
			case "0x206 - Only the subscribed service type can be accessed – "
					+ "make sure of the service type you are trying to connect with":
			case "0x207 - Invalid Source IP – kindly check if the IP is responding":
			case "0x208 - Account deactivated/expired":
			case "0x209 - Invalid message length (less than 160 characters) if concat is set to 1":
			case "0x210 - Invalid Parameter values":
			case "0x211 - Invalid Message Length (more than 280 characters)":
			case "0x212 - Invalid Message Length":
			case "0x213 - Invalid Destination Number":
				throw new Exception(smsResponse);
			default:
				logger.info("SMS Sent successfully by calling API " + sendSMSAPI);
				logger.info("SMS Sent successfully sent to : " + phoneNo);
				break;
			}
		} else {
			throw new Exception(response.getStatusCodeValue() + " and error " + response.getStatusCode().toString());
		}
	}
}
