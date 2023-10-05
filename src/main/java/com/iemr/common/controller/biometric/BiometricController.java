package com.iemr.common.controller.biometric;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

import com.iemr.common.service.biometric.BiometricService;
import com.iemr.common.utils.response.OutputResponse;

 

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/biometric")
public class BiometricController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private BiometricService biometricService;
	@CrossOrigin
	@RequestMapping(value = { "/getBiometricData/{pid}" }, method = { RequestMethod.GET }, headers = "Authorization")
	public String saveBenNurseDataCAC(@PathVariable("pid") String pid,
			@RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();
		try {
			String pidResponse = biometricService.getBioData(pid);
			response.setResponse(pidResponse);
		}catch (Exception e) {
			logger.error("Error while fetching Biometric data : "+e.getMessage());
		}
		return response.toString();
	}
}