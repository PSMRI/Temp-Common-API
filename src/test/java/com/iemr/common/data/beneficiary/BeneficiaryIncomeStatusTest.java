package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BeneficiaryIncomeStatusTest {

	@Test
    public void testGettersAndSetters() {
        BeneficiaryIncomeStatus beneficiaryIncomeStatus = new BeneficiaryIncomeStatus(1, "Test Income Status");

        assertEquals(1, beneficiaryIncomeStatus.getIncomeStatusID());
        assertEquals("Test Income Status", beneficiaryIncomeStatus.getIncomeStatus());

        beneficiaryIncomeStatus.setIncomeStatus("Updated Income Status");
        assertEquals("Updated Income Status", beneficiaryIncomeStatus.getIncomeStatus());
    }

    @Test
    public void testToString() {
        BeneficiaryIncomeStatus beneficiaryIncomeStatus = new BeneficiaryIncomeStatus(1, "Test Income Status");
        beneficiaryIncomeStatus.setDeleted(null); // Set default null value for "Deleted" field
        beneficiaryIncomeStatus.setCreatedBy(null); // Set default null value for "CreatedBy" field
        String expectedJson = "{\"incomeStatusID\":1,\"incomeStatus\":\"Test Income Status\",\"deleted\":null,\"createdBy\":null}";

        assertEquals(expectedJson, beneficiaryIncomeStatus.toString());
    }

    @Test
    public void testAllFields() {
        BeneficiaryIncomeStatus beneficiaryIncomeStatus = new BeneficiaryIncomeStatus(1, "Test Income Status");
        beneficiaryIncomeStatus.setDeleted(true);
        beneficiaryIncomeStatus.setCreatedBy("test_user");
        beneficiaryIncomeStatus.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        beneficiaryIncomeStatus.setLastModDate(new Timestamp(System.currentTimeMillis()));

        assertEquals(true, beneficiaryIncomeStatus.getDeleted());
        assertEquals("test_user", beneficiaryIncomeStatus.getCreatedBy());

        // Verify createdDate and lastModDate are not null
        assertNotNull(beneficiaryIncomeStatus.getCreatedDate());
        assertNotNull(beneficiaryIncomeStatus.getLastModDate());
    }

}
