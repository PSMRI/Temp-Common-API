package com.iemr.common.data.eausadha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@ExtendWith(MockitoExtension.class)
class ItemStockEntryTest {

	@InjectMocks
    private ItemStockEntry itemStockEntryUnderTest;

    @BeforeEach
    void setUp() {
        itemStockEntryUnderTest = new ItemStockEntry();
    }

    @Test
    void testItemStockEntryIDGetterAndSetter() {
        final Integer itemStockEntryID = 0;
        itemStockEntryUnderTest.setItemStockEntryID(itemStockEntryID);
        assertThat(itemStockEntryUnderTest.getItemStockEntryID()).isEqualTo(itemStockEntryID);
    }

    @Test
    void testFacilityIDGetterAndSetter() {
        final Integer facilityID = 0;
        itemStockEntryUnderTest.setFacilityID(facilityID);
        assertThat(itemStockEntryUnderTest.getFacilityID()).isEqualTo(facilityID);
    }

    @Test
    void testItemIDGetterAndSetter() {
        final Integer itemID = 0;
        itemStockEntryUnderTest.setItemID(itemID);
        assertThat(itemStockEntryUnderTest.getItemID()).isEqualTo(itemID);
    }

    @Test
    void testQuantityGetterAndSetter() {
        final Integer quantity = 0;
        itemStockEntryUnderTest.setQuantity(quantity);
        assertThat(itemStockEntryUnderTest.getQuantity()).isEqualTo(quantity);
    }

    @Test
    void testQuantityInHandGetterAndSetter() {
        final Integer quantityInHand = 0;
        itemStockEntryUnderTest.setQuantityInHand(quantityInHand);
        assertThat(itemStockEntryUnderTest.getQuantityInHand()).isEqualTo(quantityInHand);
    }

    @Test
    void testTotalCostPriceGetterAndSetter() {
        final Double totalCostPrice = 0.0;
        itemStockEntryUnderTest.setTotalCostPrice(totalCostPrice);
        assertThat(itemStockEntryUnderTest.getTotalCostPrice()).isEqualTo(totalCostPrice, within(0.0001));
    }

    @Test
    void testBatchNoGetterAndSetter() {
        final String batchNo = "batchNo";
        itemStockEntryUnderTest.setBatchNo(batchNo);
        assertThat(itemStockEntryUnderTest.getBatchNo()).isEqualTo(batchNo);
    }

    @Test
    void testExpiryDateGetterAndSetter() {
        final Date expiryDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        itemStockEntryUnderTest.setExpiryDate(expiryDate);
        assertThat(itemStockEntryUnderTest.getExpiryDate()).isEqualTo(expiryDate);
    }

    @Test
    void testEntryTypeIDGetterAndSetter() {
        final Integer entryTypeID = 0;
        itemStockEntryUnderTest.setEntryTypeID(entryTypeID);
        assertThat(itemStockEntryUnderTest.getEntryTypeID()).isEqualTo(entryTypeID);
    }

    @Test
    void testItemGetterAndSetter() {
        final ItemMaster item = new ItemMaster();
        itemStockEntryUnderTest.setItem(item);
        assertThat(itemStockEntryUnderTest.getItem()).isEqualTo(item);
    }

    @Test
    void testEntryTypeGetterAndSetter() {
        final String entryType = "entryType";
        itemStockEntryUnderTest.setEntryType(entryType);
        assertThat(itemStockEntryUnderTest.getEntryType()).isEqualTo(entryType);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        itemStockEntryUnderTest.setDeleted(deleted);
        assertThat(itemStockEntryUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final Character processed = 'a';
        itemStockEntryUnderTest.setProcessed(processed);
        assertThat(itemStockEntryUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        itemStockEntryUnderTest.setCreatedBy(createdBy);
        assertThat(itemStockEntryUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        itemStockEntryUnderTest.setCreatedDate(createdDate);
        assertThat(itemStockEntryUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        itemStockEntryUnderTest.setModifiedBy(modifiedBy);
        assertThat(itemStockEntryUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        itemStockEntryUnderTest.setLastModDate(lastModDate);
        assertThat(itemStockEntryUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testSyncFacilityIDGetterAndSetter() {
        final Integer syncFacilityID = 0;
        itemStockEntryUnderTest.setSyncFacilityID(syncFacilityID);
        assertThat(itemStockEntryUnderTest.getSyncFacilityID()).isEqualTo(syncFacilityID);
    }

    @Test
    void testVanSerialNoGetterAndSetter() {
        final Integer vanSerialNo = 0;
        itemStockEntryUnderTest.setVanSerialNo(vanSerialNo);
        assertThat(itemStockEntryUnderTest.getVanSerialNo()).isEqualTo(vanSerialNo);
    }

    @Test
    void testVanIdGetterAndSetter() {
        final Integer vanId = 0;
        itemStockEntryUnderTest.setVanId(vanId);
        assertThat(itemStockEntryUnderTest.getVanId()).isEqualTo(vanId);
    }

    @Test
    void testEquals() {
        assertThat(itemStockEntryUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(itemStockEntryUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(itemStockEntryUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(itemStockEntryUnderTest.toString()).isEqualTo("result");
    }
}
