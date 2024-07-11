package com.iemr.common.data.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MDSR_CDREmailTest {

	@InjectMocks
    private MDSR_CDREmail mdsrCdrEmailUnderTest;

    @BeforeEach
    void setUp() {
        mdsrCdrEmailUnderTest = new MDSR_CDREmail();
    }

    @Test
    void testBenImrMmrIDGetterAndSetter() {
        final Long benImrMmrID = 0L;
        mdsrCdrEmailUnderTest.setBenImrMmrID(benImrMmrID);
        assertThat(mdsrCdrEmailUnderTest.getBenImrMmrID()).isEqualTo(benImrMmrID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Integer benCallID = 0;
        mdsrCdrEmailUnderTest.setBenCallID(benCallID);
        assertThat(mdsrCdrEmailUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Integer beneficiaryRegID = 0;
        mdsrCdrEmailUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(mdsrCdrEmailUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mdsrCdrEmailUnderTest.setCreatedBy(createdBy);
        assertThat(mdsrCdrEmailUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testWithin42daysOfDeliveryGetterAndSetter() {
        final String within42daysOfDelivery = "within42daysOfDelivery";
        mdsrCdrEmailUnderTest.setWithin42daysOfDelivery(within42daysOfDelivery);
        assertThat(mdsrCdrEmailUnderTest.getWithin42daysOfDelivery()).isEqualTo(within42daysOfDelivery);
    }

    @Test
    void testDuringDeliveryGetterAndSetter() {
        final String duringDelivery = "duringDelivery";
        mdsrCdrEmailUnderTest.setDuringDelivery(duringDelivery);
        assertThat(mdsrCdrEmailUnderTest.getDuringDelivery()).isEqualTo(duringDelivery);
    }

    @Test
    void testDuringPregnancyGetterAndSetter() {
        final String duringPregnancy = "duringPregnancy";
        mdsrCdrEmailUnderTest.setDuringPregnancy(duringPregnancy);
        assertThat(mdsrCdrEmailUnderTest.getDuringPregnancy()).isEqualTo(duringPregnancy);
    }

    @Test
    void testTransitTypeGetterAndSetter() {
        final String transitType = "transitType";
        mdsrCdrEmailUnderTest.setTransitType(transitType);
        assertThat(mdsrCdrEmailUnderTest.getTransitType()).isEqualTo(transitType);
    }

    @Test
    void testFacilityIDGetterAndSetter() {
        final Integer facilityID = 0;
        mdsrCdrEmailUnderTest.setFacilityID(facilityID);
        assertThat(mdsrCdrEmailUnderTest.getFacilityID()).isEqualTo(facilityID);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        mdsrCdrEmailUnderTest.setFacilityName(facilityName);
        assertThat(mdsrCdrEmailUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testNoofDeliveryGetterAndSetter() {
        final Integer noofDelivery = 0;
        mdsrCdrEmailUnderTest.setNoofDelivery(noofDelivery);
        assertThat(mdsrCdrEmailUnderTest.getNoofDelivery()).isEqualTo(noofDelivery);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        mdsrCdrEmailUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(mdsrCdrEmailUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testReasonOfDeathGetterAndSetter() {
        final String reasonOfDeath = "reasonOfDeath";
        mdsrCdrEmailUnderTest.setReasonOfDeath(reasonOfDeath);
        assertThat(mdsrCdrEmailUnderTest.getReasonOfDeath()).isEqualTo(reasonOfDeath);
    }

    @Test
    void testReferenceDateGetterAndSetter() {
        final Timestamp referenceDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        mdsrCdrEmailUnderTest.setReferenceDate(referenceDate);
        assertThat(mdsrCdrEmailUnderTest.getReferenceDate()).isEqualTo(referenceDate);
    }

    @Test
    void testRelationshipTypeGetterAndSetter() {
        final Integer relationshipType = 0;
        mdsrCdrEmailUnderTest.setRelationshipType(relationshipType);
        assertThat(mdsrCdrEmailUnderTest.getRelationshipType()).isEqualTo(relationshipType);
    }

    @Test
    void testRelativeMobileNumberGetterAndSetter() {
        final Long relativeMobileNumber = 0L;
        mdsrCdrEmailUnderTest.setRelativeMobileNumber(relativeMobileNumber);
        assertThat(mdsrCdrEmailUnderTest.getRelativeMobileNumber()).isEqualTo(relativeMobileNumber);
    }

    @Test
    void testSupportServicesNameGetterAndSetter() {
        final String[] supportServicesName = new String[]{"supportServicesName"};
        mdsrCdrEmailUnderTest.setSupportServicesName(supportServicesName);
        assertThat(mdsrCdrEmailUnderTest.getSupportServicesName()).isEqualTo(supportServicesName);
    }

    @Test
    void testSupportServicesName_dbGetterAndSetter() {
        final String supportServicesName_db = "supportServicesName_db";
        mdsrCdrEmailUnderTest.setSupportServicesName_db(supportServicesName_db);
        assertThat(mdsrCdrEmailUnderTest.getSupportServicesName_db()).isEqualTo(supportServicesName_db);
    }

    @Test
    void testSupportServicesIDGetterAndSetter() {
        final String[] supportServicesID = new String[]{"supportServicesID"};
        mdsrCdrEmailUnderTest.setSupportServicesID(supportServicesID);
        assertThat(mdsrCdrEmailUnderTest.getSupportServicesID()).isEqualTo(supportServicesID);
    }

    @Test
    void testSupportServicesID_dbGetterAndSetter() {
        final String supportServicesID_db = "supportServicesID_db";
        mdsrCdrEmailUnderTest.setSupportServicesID_db(supportServicesID_db);
        assertThat(mdsrCdrEmailUnderTest.getSupportServicesID_db()).isEqualTo(supportServicesID_db);
    }

    @Test
    void testTypeOfDeliveryGetterAndSetter() {
        final String typeOfDelivery = "typeOfDelivery";
        mdsrCdrEmailUnderTest.setTypeOfDelivery(typeOfDelivery);
        assertThat(mdsrCdrEmailUnderTest.getTypeOfDelivery()).isEqualTo(typeOfDelivery);
    }

    @Test
    void testTypeOfInfromationGetterAndSetter() {
        final String typeOfInfromation = "typeOfInfromation";
        mdsrCdrEmailUnderTest.setTypeOfInfromation(typeOfInfromation);
        assertThat(mdsrCdrEmailUnderTest.getTypeOfInfromation()).isEqualTo(typeOfInfromation);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        mdsrCdrEmailUnderTest.setUserID(userID);
        assertThat(mdsrCdrEmailUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testVictimAgeGetterAndSetter() {
        final Integer victimAge = 0;
        mdsrCdrEmailUnderTest.setVictimAge(victimAge);
        assertThat(mdsrCdrEmailUnderTest.getVictimAge()).isEqualTo(victimAge);
    }

    @Test
    void testVictimDistrictGetterAndSetter() {
        final Integer victimDistrict = 0;
        mdsrCdrEmailUnderTest.setVictimDistrict(victimDistrict);
        assertThat(mdsrCdrEmailUnderTest.getVictimDistrict()).isEqualTo(victimDistrict);
    }

    @Test
    void testVictimNameGetterAndSetter() {
        final String victimName = "victimName";
        mdsrCdrEmailUnderTest.setVictimName(victimName);
        assertThat(mdsrCdrEmailUnderTest.getVictimName()).isEqualTo(victimName);
    }

    @Test
    void testVictimTalukGetterAndSetter() {
        final Integer victimTaluk = 0;
        mdsrCdrEmailUnderTest.setVictimTaluk(victimTaluk);
        assertThat(mdsrCdrEmailUnderTest.getVictimTaluk()).isEqualTo(victimTaluk);
    }

    @Test
    void testVictimVillageGetterAndSetter() {
        final Integer victimVillage = 0;
        mdsrCdrEmailUnderTest.setVictimVillage(victimVillage);
        assertThat(mdsrCdrEmailUnderTest.getVictimVillage()).isEqualTo(victimVillage);
    }

    @Test
    void testStagesOfDeathGetterAndSetter() {
        final Map<String, String> stagesOfDeath = Map.ofEntries(Map.entry("value", "value"));
        mdsrCdrEmailUnderTest.setStagesOfDeath(stagesOfDeath);
        assertThat(mdsrCdrEmailUnderTest.getStagesOfDeath()).isEqualTo(stagesOfDeath);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mdsrCdrEmailUnderTest.setModifiedBy(modifiedBy);
        assertThat(mdsrCdrEmailUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        mdsrCdrEmailUnderTest.setRequestID(requestID);
        assertThat(mdsrCdrEmailUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testInformerCategoryGetterAndSetter() {
        final String informerCategory = "informerCategory";
        mdsrCdrEmailUnderTest.setInformerCategory(informerCategory);
        assertThat(mdsrCdrEmailUnderTest.getInformerCategory()).isEqualTo(informerCategory);
    }

    @Test
    void testSelectedCategoryGetterAndSetter() {
        final String selectedCategory = "selectedCategory";
        mdsrCdrEmailUnderTest.setSelectedCategory(selectedCategory);
        assertThat(mdsrCdrEmailUnderTest.getSelectedCategory()).isEqualTo(selectedCategory);
    }

    @Test
    void testInformerNameGetterAndSetter() {
        final String informerName = "informerName";
        mdsrCdrEmailUnderTest.setInformerName(informerName);
        assertThat(mdsrCdrEmailUnderTest.getInformerName()).isEqualTo(informerName);
    }

    @Test
    void testInformerMobileNumberGetterAndSetter() {
        final String informerMobileNumber = "informerMobileNumber";
        mdsrCdrEmailUnderTest.setInformerMobileNumber(informerMobileNumber);
        assertThat(mdsrCdrEmailUnderTest.getInformerMobileNumber()).isEqualTo(informerMobileNumber);
    }

    @Test
    void testInformerDistrictidGetterAndSetter() {
        final Integer informerDistrictid = 0;
        mdsrCdrEmailUnderTest.setInformerDistrictid(informerDistrictid);
        assertThat(mdsrCdrEmailUnderTest.getInformerDistrictid()).isEqualTo(informerDistrictid);
    }

    @Test
    void testInformerTalukidGetterAndSetter() {
        final Integer informerTalukid = 0;
        mdsrCdrEmailUnderTest.setInformerTalukid(informerTalukid);
        assertThat(mdsrCdrEmailUnderTest.getInformerTalukid()).isEqualTo(informerTalukid);
    }

    @Test
    void testInformerVillageidGetterAndSetter() {
        final Integer informerVillageid = 0;
        mdsrCdrEmailUnderTest.setInformerVillageid(informerVillageid);
        assertThat(mdsrCdrEmailUnderTest.getInformerVillageid()).isEqualTo(informerVillageid);
    }

    @Test
    void testInformerAddressGetterAndSetter() {
        final String informerAddress = "informerAddress";
        mdsrCdrEmailUnderTest.setInformerAddress(informerAddress);
        assertThat(mdsrCdrEmailUnderTest.getInformerAddress()).isEqualTo(informerAddress);
    }

    @Test
    void testIdentityTypeGetterAndSetter() {
        final String identityType = "identityType";
        mdsrCdrEmailUnderTest.setIdentityType(identityType);
        assertThat(mdsrCdrEmailUnderTest.getIdentityType()).isEqualTo(identityType);
    }

    @Test
    void testInformerIdNoGetterAndSetter() {
        final String informerIdNo = "informerIdNo";
        mdsrCdrEmailUnderTest.setInformerIdNo(informerIdNo);
        assertThat(mdsrCdrEmailUnderTest.getInformerIdNo()).isEqualTo(informerIdNo);
    }

    @Test
    void testVictimAddressGetterAndSetter() {
        final String victimAddress = "victimAddress";
        mdsrCdrEmailUnderTest.setVictimAddress(victimAddress);
        assertThat(mdsrCdrEmailUnderTest.getVictimAddress()).isEqualTo(victimAddress);
    }

    @Test
    void testTransitTypeIDGetterAndSetter() {
        final Integer transitTypeID = 0;
        mdsrCdrEmailUnderTest.setTransitTypeID(transitTypeID);
        assertThat(mdsrCdrEmailUnderTest.getTransitTypeID()).isEqualTo(transitTypeID);
    }

    @Test
    void testBaseCommunityIDGetterAndSetter() {
        final Integer baseCommunityID = 0;
        mdsrCdrEmailUnderTest.setBaseCommunityID(baseCommunityID);
        assertThat(mdsrCdrEmailUnderTest.getBaseCommunityID()).isEqualTo(baseCommunityID);
    }

    @Test
    void testBaseCommunityGetterAndSetter() {
        final String baseCommunity = "baseCommunity";
        mdsrCdrEmailUnderTest.setBaseCommunity(baseCommunity);
        assertThat(mdsrCdrEmailUnderTest.getBaseCommunity()).isEqualTo(baseCommunity);
    }

    @Test
    void testVictimGuardianGetterAndSetter() {
        final String victimGuardian = "victimGuardian";
        mdsrCdrEmailUnderTest.setVictimGuardian(victimGuardian);
        assertThat(mdsrCdrEmailUnderTest.getVictimGuardian()).isEqualTo(victimGuardian);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mdsrCdrEmailUnderTest.setDeleted(deleted);
        assertThat(mdsrCdrEmailUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testDeathConfirmedGetterAndSetter() {
        final Boolean deathConfirmed = false;
        mdsrCdrEmailUnderTest.setDeathConfirmed(deathConfirmed);
        assertThat(mdsrCdrEmailUnderTest.getDeathConfirmed()).isFalse();
    }

    @Test
    void testAbove42daysOfDeliveryGetterAndSetter() {
        final String above42daysOfDelivery = "above42daysOfDelivery";
        mdsrCdrEmailUnderTest.setAbove42daysOfDelivery(above42daysOfDelivery);
        assertThat(mdsrCdrEmailUnderTest.getAbove42daysOfDelivery()).isEqualTo(above42daysOfDelivery);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        mdsrCdrEmailUnderTest.setCreatedDate(createdDate);
        assertThat(mdsrCdrEmailUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }
}
