package com.iemr.common.model.esanjeevani;

import lombok.Data;

@Data
public class ESanjeevaniPatientAddress {
	
    private String addressLine1;
    private String addressType;
    private String addressUse;
    private int blockCode;
    private String blockDisplay;
    private int cityCode;
    private String cityDisplay;
    private String countryCode;
    private String countryDisplay;
    private int districtCode;
    private String districtDisplay;
    private String postalCode;
    private int stateCode;
    private String stateDisplay;

}
