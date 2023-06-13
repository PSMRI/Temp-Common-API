package com.iemr.common.controller.brd;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.service.brd.BRDIntegrationService;
import com.iemr.common.utils.response.OutputResponse;

@RestController
@RequestMapping("/brd")
@CrossOrigin()
public class BRDIntegrationController {

	private Logger logger = LoggerFactory.getLogger(BRDIntegrationController.class);

	@Autowired
	private BRDIntegrationService integrationService;

	@RequestMapping(value = "/getIntegrationData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	@CrossOrigin()
	public String getDetails(@RequestBody String request) {
		OutputResponse response = new OutputResponse();
		String brdDetails = null;
		try {
			JSONObject json = new JSONObject(request);
			String startDate = json.getString("startDate");
			String endDate = json.getString("endDate");
			brdDetails = integrationService.getData(startDate, endDate);
			response.setResponse(brdDetails);
		} catch (Exception e) {
			logger.error("Error while getching BRD Integration data :" + e);
			response.setError(5000, "Unable to get BRD data");
		}
		return response.toStringWithSerializeNulls();
	}

}
