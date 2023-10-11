package com.iemr.common.model.esanjeevani;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ESanjeevaniPatientRegistration {

	private String abhaAddress;
	private String abhaNumber;
	private int age;
	private String birthdate;
	private String displayName;
	private String firstName;
	private String middleName;
	private String lastName;
	private int genderCode;
	private String genderDisplay;
	private boolean isBlock;
	private String source;
    
	private ArrayList<ESanjeevaniPatientAddress> lstPatientAddress;
	private ArrayList<ESanjeevaniPatientContactDetail> lstPatientContactDetail;

}
