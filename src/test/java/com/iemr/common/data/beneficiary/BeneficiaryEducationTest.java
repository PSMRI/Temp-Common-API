package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BeneficiaryEducationTest {

	@Test
    public void testGettersAndSetters() {
        BeneficiaryEducation beneficiaryEducation = new BeneficiaryEducation(1L, "Test Education Type");

        assertEquals(1L, beneficiaryEducation.getEducationID());
        assertEquals("Test Education Type", beneficiaryEducation.getEducationType());

        beneficiaryEducation.setEducationType("Updated Education Type");
        assertEquals("Updated Education Type", beneficiaryEducation.getEducationType());
    }

	@Test
	public void testToString() {
	    BeneficiaryEducation beneficiaryEducation = new BeneficiaryEducation(1L, "Test Education Type");
	    beneficiaryEducation.setDeleted(null); // Set default null value for "Deleted" field
	    beneficiaryEducation.setCreatedBy(null); // Set default null value for "CreatedBy" field
	    String expectedJson = "{\"educationID\":\"1\",\"educationType\":\"Test Education Type\",\"deleted\":null,\"createdBy\":null}";

	    assertEquals(expectedJson, beneficiaryEducation.toString());
	}

}
