package com.iemr.common.data.uptsu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FacilityMasterTest {

	@InjectMocks
    private FacilityMaster facilityMasterUnderTest;

    @BeforeEach
    void setUp() {
        facilityMasterUnderTest = new FacilityMaster(0, "employeeCode", "employeeName", "surveyFacilityCode",
                "officeType", "officeCategory", "postingOffice", "postDistrict", 0, "designation", "desCategory",
                "desSubCategory", "employeeType", "cadre", "activeStatus", "presentMobileNo", "divisionName", 0,
                "districtName", 0, "tehsilName", 0, "blockName", 0, "gramPanchayatName", 0, "villageName", 0,
                "facilityName", "facilityCode", "facilityType", "fcStatus", "facilityClassification",
                "facilityCategory", "longitude", "latitude", 0, "hwcStatus", "fruStatus", "hfrId", "hprCode", 0, false,
                "processed", "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testIdGetterAndSetter() {
        final Integer id = 0;
        facilityMasterUnderTest.setId(id);
        assertThat(facilityMasterUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testEmployeeCodeGetterAndSetter() {
        final String employeeCode = "employeeCode";
        facilityMasterUnderTest.setEmployeeCode(employeeCode);
        assertThat(facilityMasterUnderTest.getEmployeeCode()).isEqualTo(employeeCode);
    }

    @Test
    void testEmployeeNameGetterAndSetter() {
        final String employeeName = "employeeName";
        facilityMasterUnderTest.setEmployeeName(employeeName);
        assertThat(facilityMasterUnderTest.getEmployeeName()).isEqualTo(employeeName);
    }

    @Test
    void testSurveyFacilityCodeGetterAndSetter() {
        final String surveyFacilityCode = "surveyFacilityCode";
        facilityMasterUnderTest.setSurveyFacilityCode(surveyFacilityCode);
        assertThat(facilityMasterUnderTest.getSurveyFacilityCode()).isEqualTo(surveyFacilityCode);
    }

    @Test
    void testOfficeTypeGetterAndSetter() {
        final String officeType = "officeType";
        facilityMasterUnderTest.setOfficeType(officeType);
        assertThat(facilityMasterUnderTest.getOfficeType()).isEqualTo(officeType);
    }

    @Test
    void testOfficeCategoryGetterAndSetter() {
        final String officeCategory = "officeCategory";
        facilityMasterUnderTest.setOfficeCategory(officeCategory);
        assertThat(facilityMasterUnderTest.getOfficeCategory()).isEqualTo(officeCategory);
    }

    @Test
    void testPostingOfficeGetterAndSetter() {
        final String postingOffice = "postingOffice";
        facilityMasterUnderTest.setPostingOffice(postingOffice);
        assertThat(facilityMasterUnderTest.getPostingOffice()).isEqualTo(postingOffice);
    }

    @Test
    void testPostDistrictGetterAndSetter() {
        final String postDistrict = "postDistrict";
        facilityMasterUnderTest.setPostDistrict(postDistrict);
        assertThat(facilityMasterUnderTest.getPostDistrict()).isEqualTo(postDistrict);
    }

    @Test
    void testDesignationIdGetterAndSetter() {
        final Integer designationId = 0;
        facilityMasterUnderTest.setDesignationId(designationId);
        assertThat(facilityMasterUnderTest.getDesignationId()).isEqualTo(designationId);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final String designation = "designation";
        facilityMasterUnderTest.setDesignation(designation);
        assertThat(facilityMasterUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testDesCategoryGetterAndSetter() {
        final String desCategory = "desCategory";
        facilityMasterUnderTest.setDesCategory(desCategory);
        assertThat(facilityMasterUnderTest.getDesCategory()).isEqualTo(desCategory);
    }

    @Test
    void testDesSubCategoryGetterAndSetter() {
        final String desSubCategory = "desSubCategory";
        facilityMasterUnderTest.setDesSubCategory(desSubCategory);
        assertThat(facilityMasterUnderTest.getDesSubCategory()).isEqualTo(desSubCategory);
    }

    @Test
    void testEmployeeTypeGetterAndSetter() {
        final String employeeType = "employeeType";
        facilityMasterUnderTest.setEmployeeType(employeeType);
        assertThat(facilityMasterUnderTest.getEmployeeType()).isEqualTo(employeeType);
    }

    @Test
    void testCadreGetterAndSetter() {
        final String cadre = "cadre";
        facilityMasterUnderTest.setCadre(cadre);
        assertThat(facilityMasterUnderTest.getCadre()).isEqualTo(cadre);
    }

    @Test
    void testActiveStatusGetterAndSetter() {
        final String activeStatus = "activeStatus";
        facilityMasterUnderTest.setActiveStatus(activeStatus);
        assertThat(facilityMasterUnderTest.getActiveStatus()).isEqualTo(activeStatus);
    }

    @Test
    void testPresentMobileNoGetterAndSetter() {
        final String presentMobileNo = "presentMobileNo";
        facilityMasterUnderTest.setPresentMobileNo(presentMobileNo);
        assertThat(facilityMasterUnderTest.getPresentMobileNo()).isEqualTo(presentMobileNo);
    }

    @Test
    void testDivisionNameGetterAndSetter() {
        final String divisionName = "divisionName";
        facilityMasterUnderTest.setDivisionName(divisionName);
        assertThat(facilityMasterUnderTest.getDivisionName()).isEqualTo(divisionName);
    }

    @Test
    void testDivisionCodeGetterAndSetter() {
        final Integer divisionCode = 0;
        facilityMasterUnderTest.setDivisionCode(divisionCode);
        assertThat(facilityMasterUnderTest.getDivisionCode()).isEqualTo(divisionCode);
    }

    @Test
    void testDistrictNameGetterAndSetter() {
        final String districtName = "districtName";
        facilityMasterUnderTest.setDistrictName(districtName);
        assertThat(facilityMasterUnderTest.getDistrictName()).isEqualTo(districtName);
    }

    @Test
    void testDLGDGetterAndSetter() {
        final Integer dLGD = 0;
        facilityMasterUnderTest.setDLGD(dLGD);
        assertThat(facilityMasterUnderTest.getDLGD()).isEqualTo(dLGD);
    }

    @Test
    void testTehsilNameGetterAndSetter() {
        final String tehsilName = "tehsilName";
        facilityMasterUnderTest.setTehsilName(tehsilName);
        assertThat(facilityMasterUnderTest.getTehsilName()).isEqualTo(tehsilName);
    }

    @Test
    void testTLGDGetterAndSetter() {
        final Integer tLGD = 0;
        facilityMasterUnderTest.setTLGD(tLGD);
        assertThat(facilityMasterUnderTest.getTLGD()).isEqualTo(tLGD);
    }

    @Test
    void testBlockNameGetterAndSetter() {
        final String blockName = "blockName";
        facilityMasterUnderTest.setBlockName(blockName);
        assertThat(facilityMasterUnderTest.getBlockName()).isEqualTo(blockName);
    }

    @Test
    void testBLGDGetterAndSetter() {
        final Integer bLGD = 0;
        facilityMasterUnderTest.setBLGD(bLGD);
        assertThat(facilityMasterUnderTest.getBLGD()).isEqualTo(bLGD);
    }

    @Test
    void testGramPanchayatNameGetterAndSetter() {
        final String gramPanchayatName = "gramPanchayatName";
        facilityMasterUnderTest.setGramPanchayatName(gramPanchayatName);
        assertThat(facilityMasterUnderTest.getGramPanchayatName()).isEqualTo(gramPanchayatName);
    }

    @Test
    void testGLGDGetterAndSetter() {
        final Integer gLGD = 0;
        facilityMasterUnderTest.setGLGD(gLGD);
        assertThat(facilityMasterUnderTest.getGLGD()).isEqualTo(gLGD);
    }

    @Test
    void testVillageNameGetterAndSetter() {
        final String villageName = "villageName";
        facilityMasterUnderTest.setVillageName(villageName);
        assertThat(facilityMasterUnderTest.getVillageName()).isEqualTo(villageName);
    }

    @Test
    void testVillageCodeGetterAndSetter() {
        final Integer villageCode = 0;
        facilityMasterUnderTest.setVillageCode(villageCode);
        assertThat(facilityMasterUnderTest.getVillageCode()).isEqualTo(villageCode);
    }

    @Test
    void testFacilityNameGetterAndSetter() {
        final String facilityName = "facilityName";
        facilityMasterUnderTest.setFacilityName(facilityName);
        assertThat(facilityMasterUnderTest.getFacilityName()).isEqualTo(facilityName);
    }

    @Test
    void testFacilityCodeGetterAndSetter() {
        final String facilityCode = "facilityCode";
        facilityMasterUnderTest.setFacilityCode(facilityCode);
        assertThat(facilityMasterUnderTest.getFacilityCode()).isEqualTo(facilityCode);
    }

    @Test
    void testFacilityTypeGetterAndSetter() {
        final String facilityType = "facilityType";
        facilityMasterUnderTest.setFacilityType(facilityType);
        assertThat(facilityMasterUnderTest.getFacilityType()).isEqualTo(facilityType);
    }

    @Test
    void testFcStatusGetterAndSetter() {
        final String fcStatus = "fcStatus";
        facilityMasterUnderTest.setFcStatus(fcStatus);
        assertThat(facilityMasterUnderTest.getFcStatus()).isEqualTo(fcStatus);
    }

    @Test
    void testFacilityClassificationGetterAndSetter() {
        final String facilityClassification = "facilityClassification";
        facilityMasterUnderTest.setFacilityClassification(facilityClassification);
        assertThat(facilityMasterUnderTest.getFacilityClassification()).isEqualTo(facilityClassification);
    }

    @Test
    void testFacilityCategoryGetterAndSetter() {
        final String facilityCategory = "facilityCategory";
        facilityMasterUnderTest.setFacilityCategory(facilityCategory);
        assertThat(facilityMasterUnderTest.getFacilityCategory()).isEqualTo(facilityCategory);
    }

    @Test
    void testLongitudeGetterAndSetter() {
        final String longitude = "longitude";
        facilityMasterUnderTest.setLongitude(longitude);
        assertThat(facilityMasterUnderTest.getLongitude()).isEqualTo(longitude);
    }

    @Test
    void testLatitudeGetterAndSetter() {
        final String latitude = "latitude";
        facilityMasterUnderTest.setLatitude(latitude);
        assertThat(facilityMasterUnderTest.getLatitude()).isEqualTo(latitude);
    }

    @Test
    void testHimsCodeGetterAndSetter() {
        final Integer himsCode = 0;
        facilityMasterUnderTest.setHimsCode(himsCode);
        assertThat(facilityMasterUnderTest.getHimsCode()).isEqualTo(himsCode);
    }

    @Test
    void testHwcStatusGetterAndSetter() {
        final String hwcStatus = "hwcStatus";
        facilityMasterUnderTest.setHwcStatus(hwcStatus);
        assertThat(facilityMasterUnderTest.getHwcStatus()).isEqualTo(hwcStatus);
    }

    @Test
    void testFruStatusGetterAndSetter() {
        final String fruStatus = "fruStatus";
        facilityMasterUnderTest.setFruStatus(fruStatus);
        assertThat(facilityMasterUnderTest.getFruStatus()).isEqualTo(fruStatus);
    }

    @Test
    void testHfrIdGetterAndSetter() {
        final String hfrId = "hfrId";
        facilityMasterUnderTest.setHfrId(hfrId);
        assertThat(facilityMasterUnderTest.getHfrId()).isEqualTo(hfrId);
    }

    @Test
    void testHprCodeGetterAndSetter() {
        final String hprCode = "hprCode";
        facilityMasterUnderTest.setHprCode(hprCode);
        assertThat(facilityMasterUnderTest.getHprCode()).isEqualTo(hprCode);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        facilityMasterUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(facilityMasterUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        facilityMasterUnderTest.setDeleted(deleted);
        assertThat(facilityMasterUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        facilityMasterUnderTest.setProcessed(processed);
        assertThat(facilityMasterUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        facilityMasterUnderTest.setCreatedBy(createdBy);
        assertThat(facilityMasterUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        facilityMasterUnderTest.setCreatedDate(createdDate);
        assertThat(facilityMasterUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        facilityMasterUnderTest.setModifiedBy(modifiedBy);
        assertThat(facilityMasterUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        facilityMasterUnderTest.setLastModDate(lastModDate);
        assertThat(facilityMasterUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(facilityMasterUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(facilityMasterUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(facilityMasterUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(facilityMasterUnderTest.toString()).isEqualTo("result");
    }
}
