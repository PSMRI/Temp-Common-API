package com.iemr.common.data.eausadha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ItemMasterTest {

	@InjectMocks
    private ItemMaster itemMasterUnderTest;

    @BeforeEach
    void setUp() {
        itemMasterUnderTest = new ItemMaster();
    }

    @Test
    void testItemIDGetterAndSetter() {
        final Integer itemID = 0;
        itemMasterUnderTest.setItemID(itemID);
        assertThat(itemMasterUnderTest.getItemID()).isEqualTo(itemID);
    }

    @Test
    void testItemNameGetterAndSetter() {
        final String itemName = "itemName";
        itemMasterUnderTest.setItemName(itemName);
        assertThat(itemMasterUnderTest.getItemName()).isEqualTo(itemName);
    }

    @Test
    void testIsEDLGetterAndSetter() {
        final Boolean isEDL = false;
        itemMasterUnderTest.setIsEDL(isEDL);
        assertThat(itemMasterUnderTest.getIsEDL()).isFalse();
    }

    @Test
    void testItemDescGetterAndSetter() {
        final String itemDesc = "itemDesc";
        itemMasterUnderTest.setItemDesc(itemDesc);
        assertThat(itemMasterUnderTest.getItemDesc()).isEqualTo(itemDesc);
    }

    @Test
    void testItemCodeGetterAndSetter() {
        final String itemCode = "itemCode";
        itemMasterUnderTest.setItemCode(itemCode);
        assertThat(itemMasterUnderTest.getItemCode()).isEqualTo(itemCode);
    }

    @Test
    void testItemCategoryIDGetterAndSetter() {
        final Integer itemCategoryID = 0;
        itemMasterUnderTest.setItemCategoryID(itemCategoryID);
        assertThat(itemMasterUnderTest.getItemCategoryID()).isEqualTo(itemCategoryID);
    }

    @Test
    void testIsMedicalGetterAndSetter() {
        final Boolean isMedical = false;
        itemMasterUnderTest.setIsMedical(isMedical);
        assertThat(itemMasterUnderTest.getIsMedical()).isFalse();
    }

    @Test
    void testItemFormIDGetterAndSetter() {
        final Integer itemFormID = 0;
        itemMasterUnderTest.setItemFormID(itemFormID);
        assertThat(itemMasterUnderTest.getItemFormID()).isEqualTo(itemFormID);
    }

    @Test
    void testPharmacologyCategoryIDGetterAndSetter() {
        final Integer pharmacologyCategoryID = 0;
        itemMasterUnderTest.setPharmacologyCategoryID(pharmacologyCategoryID);
        assertThat(itemMasterUnderTest.getPharmacologyCategoryID()).isEqualTo(pharmacologyCategoryID);
    }

    @Test
    void testManufacturerIDGetterAndSetter() {
        final Integer manufacturerID = 0;
        itemMasterUnderTest.setManufacturerID(manufacturerID);
        assertThat(itemMasterUnderTest.getManufacturerID()).isEqualTo(manufacturerID);
    }

    @Test
    void testStrengthGetterAndSetter() {
        final String strength = "strength";
        itemMasterUnderTest.setStrength(strength);
        assertThat(itemMasterUnderTest.getStrength()).isEqualTo(strength);
    }

    @Test
    void testUomIDGetterAndSetter() {
        final Integer uomID = 0;
        itemMasterUnderTest.setUomID(uomID);
        assertThat(itemMasterUnderTest.getUomID()).isEqualTo(uomID);
    }

    @Test
    void testIsScheduledDrugGetterAndSetter() {
        final Boolean isScheduledDrug = false;
        itemMasterUnderTest.setIsScheduledDrug(isScheduledDrug);
        assertThat(itemMasterUnderTest.getIsScheduledDrug()).isFalse();
    }

    @Test
    void testCompositionGetterAndSetter() {
        final String composition = "composition";
        itemMasterUnderTest.setComposition(composition);
        assertThat(itemMasterUnderTest.getComposition()).isEqualTo(composition);
    }

    @Test
    void testRouteIDGetterAndSetter() {
        final Integer routeID = 0;
        itemMasterUnderTest.setRouteID(routeID);
        assertThat(itemMasterUnderTest.getRouteID()).isEqualTo(routeID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        itemMasterUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(itemMasterUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        itemMasterUnderTest.setStatus(status);
        assertThat(itemMasterUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testDiscontinuedGetterAndSetter() {
        final Boolean discontinued = false;
        itemMasterUnderTest.setDiscontinued(discontinued);
        assertThat(itemMasterUnderTest.getDiscontinued()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        itemMasterUnderTest.setDeleted(deleted);
        assertThat(itemMasterUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final Character processed = 'a';
        itemMasterUnderTest.setProcessed(processed);
        assertThat(itemMasterUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        itemMasterUnderTest.setCreatedBy(createdBy);
        assertThat(itemMasterUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        itemMasterUnderTest.setCreatedDate(createdDate);
        assertThat(itemMasterUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        itemMasterUnderTest.setModifiedBy(modifiedBy);
        assertThat(itemMasterUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        itemMasterUnderTest.setLastModDate(lastModDate);
        assertThat(itemMasterUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testSctCodeGetterAndSetter() {
        final String sctCode = "sctCode";
        itemMasterUnderTest.setSctCode(sctCode);
        assertThat(itemMasterUnderTest.getSctCode()).isEqualTo(sctCode);
    }

    @Test
    void testSctTermGetterAndSetter() {
        final String sctTerm = "sctTerm";
        itemMasterUnderTest.setSctTerm(sctTerm);
        assertThat(itemMasterUnderTest.getSctTerm()).isEqualTo(sctTerm);
    }

    @Test
    void testQuantityGetterAndSetter() {
        final Integer quantity = 0;
        itemMasterUnderTest.setQuantity(quantity);
        assertThat(itemMasterUnderTest.getQuantity()).isEqualTo(quantity);
    }

    @Test
    void testEquals() {
        assertThat(itemMasterUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(itemMasterUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(itemMasterUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(itemMasterUnderTest.toString()).isEqualTo("result");
    }
}
