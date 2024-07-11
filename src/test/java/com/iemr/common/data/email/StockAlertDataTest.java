package com.iemr.common.data.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@ExtendWith(MockitoExtension.class)
class StockAlertDataTest {

	@InjectMocks
    private StockAlertData stockAlertDataUnderTest;

    @BeforeEach
    void setUp() {
        stockAlertDataUnderTest = new StockAlertData();
    }

    @Test
    void testUuidGetterAndSetter() {
        final String uuid = "uuid";
        stockAlertDataUnderTest.setUuid(uuid);
        assertThat(stockAlertDataUnderTest.getUuid()).isEqualTo(uuid);
    }

    @Test
    void testFacilityIdGetterAndSetter() {
        final Integer facilityId = 0;
        stockAlertDataUnderTest.setFacilityId(facilityId);
        assertThat(stockAlertDataUnderTest.getFacilityId()).isEqualTo(facilityId);
    }

    @Test
    void testItemIDGetterAndSetter() {
        final Integer itemID = 0;
        stockAlertDataUnderTest.setItemID(itemID);
        assertThat(stockAlertDataUnderTest.getItemID()).isEqualTo(itemID);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        stockAlertDataUnderTest.setFacilityName(facilityName);
        assertThat(stockAlertDataUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testItemNameGetterAndSetter() {
        final String itemName = "itemName";
        stockAlertDataUnderTest.setItemName(itemName);
        assertThat(stockAlertDataUnderTest.getItemName()).isEqualTo(itemName);
    }

    @Test
    void testTotalquantityGetterAndSetter() {
        final Integer totalquantity = 0;
        stockAlertDataUnderTest.setTotalquantity(totalquantity);
        assertThat(stockAlertDataUnderTest.getTotalquantity()).isEqualTo(totalquantity);
    }

    @Test
    void testQuantityInHandGetterAndSetter() {
        final Integer quantityInHand = 0;
        stockAlertDataUnderTest.setQuantityInHand(quantityInHand);
        assertThat(stockAlertDataUnderTest.getQuantityInHand()).isEqualTo(quantityInHand);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        stockAlertDataUnderTest.setCreatedBy(createdBy);
        assertThat(stockAlertDataUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testEmailidGetterAndSetter() {
        final String emailid = "emailid";
        stockAlertDataUnderTest.setEmailid(emailid);
        assertThat(stockAlertDataUnderTest.getEmailid()).isEqualTo(emailid);
    }

    @Test
    void testDistrictNameGetterAndSetter() {
        final String districtName = "districtName";
        stockAlertDataUnderTest.setDistrictName(districtName);
        assertThat(stockAlertDataUnderTest.getDistrictName()).isEqualTo(districtName);
    }

    @Test
    void testQuantityinhandPercentGetterAndSetter() {
        final Double quantityinhandPercent = 0.0;
        stockAlertDataUnderTest.setQuantityinhandPercent(quantityinhandPercent);
        assertThat(stockAlertDataUnderTest.getQuantityinhandPercent()).isEqualTo(quantityinhandPercent, within(0.0001));
    }

    @Test
    void testEquals() {
        assertThat(stockAlertDataUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(stockAlertDataUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(stockAlertDataUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(stockAlertDataUnderTest.toString()).isEqualTo("result");
    }
}
