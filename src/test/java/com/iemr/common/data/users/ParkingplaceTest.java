package com.iemr.common.data.users;

import com.iemr.common.data.location.*;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ParkingplaceTest {

	@InjectMocks
    private Parkingplace parkingplaceUnderTest;

    @BeforeEach
    void setUp() {
        parkingplaceUnderTest = new Parkingplace();
    }

    @Test
    void testGetDefaultConstructor() {
        // Setup
        final Parkingplace expectedResult = new Parkingplace();
        expectedResult.setParkingPlaceName("parkingPlaceName");
        expectedResult.setParkingPlaceDesc("parkingPlaceDesc");
        expectedResult.setProviderServiceMapID(0);
        expectedResult.setCountryID(0);
        expectedResult.setCountryName("countryName");
        expectedResult.setStateID(0);
        final States state = new States();
        expectedResult.setState(state);
        expectedResult.setStateName("stateName");
        expectedResult.setDistrictID(0);
        expectedResult.setDistrictName("districtName");
        expectedResult.setDistrictBlockID(0);
        final DistrictBlock districtBlock = new DistrictBlock();
        expectedResult.setDistrictBlock(districtBlock);
        expectedResult.setBlockName("blockName");
        expectedResult.setDistrictBranchID(0);
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping();
        expectedResult.setDistrictBranchMapping(districtBranchMapping);
        expectedResult.setVillageName("villageName");
        expectedResult.setAreaHQAddress("areaHQAddress");
        expectedResult.setDeleted(false);
        expectedResult.setProcessed("processed");
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Date.valueOf(LocalDate.of(2020, 1, 1)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Date.valueOf(LocalDate.of(2020, 1, 1)));
        expectedResult.setParkingPlaceID(0);
        final ProviderServiceMapping m_providerServiceMapping = new ProviderServiceMapping();
        expectedResult.setM_providerServiceMapping(m_providerServiceMapping);

        // Run the test
        final Parkingplace result = parkingplaceUnderTest.getDefaultConstructor();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetParkingPlace() {
        // Setup
        final ProviderServiceMapping m_providerServiceMapping = new ProviderServiceMapping(false, 0);
        final Parkingplace expectedResult = new Parkingplace();
        expectedResult.setParkingPlaceName("parkingPlaceName");
        expectedResult.setParkingPlaceDesc("parkingPlaceDesc");
        expectedResult.setProviderServiceMapID(0);
        expectedResult.setCountryID(0);
        expectedResult.setCountryName("countryName");
        expectedResult.setStateID(0);
        final States state = new States();
        expectedResult.setState(state);
        expectedResult.setStateName("stateName");
        expectedResult.setDistrictID(0);
        expectedResult.setDistrictName("districtName");
        expectedResult.setDistrictBlockID(0);
        final DistrictBlock districtBlock = new DistrictBlock();
        expectedResult.setDistrictBlock(districtBlock);
        expectedResult.setBlockName("blockName");
        expectedResult.setDistrictBranchID(0);
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping();
        expectedResult.setDistrictBranchMapping(districtBranchMapping);
        expectedResult.setVillageName("villageName");
        expectedResult.setAreaHQAddress("areaHQAddress");
        expectedResult.setDeleted(false);
        expectedResult.setProcessed("processed");
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedDate(Date.valueOf(LocalDate.of(2020, 1, 1)));
        expectedResult.setModifiedBy("modifiedBy");
        expectedResult.setLastModDate(Date.valueOf(LocalDate.of(2020, 1, 1)));
        expectedResult.setParkingPlaceID(0);
        final ProviderServiceMapping m_providerServiceMapping1 = new ProviderServiceMapping();
        expectedResult.setM_providerServiceMapping(m_providerServiceMapping1);

        // Run the test
        final Parkingplace result = parkingplaceUnderTest.getParkingPlace(0, "parkingPlaceName", "parkingPlaceDesc",
                "areaHQAddress", 0, false, 0, "countryName", 0, "stateName", 0, "districtName", 0, "blockName", 0,
                "villageName", m_providerServiceMapping, 0, "serviceName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testParkingPlaceNameGetterAndSetter() {
        final String parkingPlaceName = "parkingPlaceName";
        parkingplaceUnderTest.setParkingPlaceName(parkingPlaceName);
        assertThat(parkingplaceUnderTest.getParkingPlaceName()).isEqualTo(parkingPlaceName);
    }

    @Test
    void testParkingPlaceDescGetterAndSetter() {
        final String parkingPlaceDesc = "parkingPlaceDesc";
        parkingplaceUnderTest.setParkingPlaceDesc(parkingPlaceDesc);
        assertThat(parkingplaceUnderTest.getParkingPlaceDesc()).isEqualTo(parkingPlaceDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        parkingplaceUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(parkingplaceUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testCountryIDGetterAndSetter() {
        final Integer countryID = 0;
        parkingplaceUnderTest.setCountryID(countryID);
        assertThat(parkingplaceUnderTest.getCountryID()).isEqualTo(countryID);
    }

    @Test
    void testCountryNameGetterAndSetter() {
        final String countryName = "countryName";
        parkingplaceUnderTest.setCountryName(countryName);
        assertThat(parkingplaceUnderTest.getCountryName()).isEqualTo(countryName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        parkingplaceUnderTest.setStateID(stateID);
        assertThat(parkingplaceUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testStateGetterAndSetter() {
        final States state = new States();
        parkingplaceUnderTest.setState(state);
        assertThat(parkingplaceUnderTest.getState()).isEqualTo(state);
    }

    @Test
    void testStateNameGetterAndSetter() {
        final String stateName = "stateName";
        parkingplaceUnderTest.setStateName(stateName);
        assertThat(parkingplaceUnderTest.getStateName()).isEqualTo(stateName);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        parkingplaceUnderTest.setDistrictID(districtID);
        assertThat(parkingplaceUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictNameGetterAndSetter() {
        final String districtName = "districtName";
        parkingplaceUnderTest.setDistrictName(districtName);
        assertThat(parkingplaceUnderTest.getDistrictName()).isEqualTo(districtName);
    }

    @Test
    void testDistrictBlockIDGetterAndSetter() {
        final Integer districtBlockID = 0;
        parkingplaceUnderTest.setDistrictBlockID(districtBlockID);
        assertThat(parkingplaceUnderTest.getDistrictBlockID()).isEqualTo(districtBlockID);
    }

    @Test
    void testDistrictBlockGetterAndSetter() {
        final DistrictBlock districtBlock = new DistrictBlock(0, "BlockName");
        parkingplaceUnderTest.setDistrictBlock(districtBlock);
        assertThat(parkingplaceUnderTest.getDistrictBlock()).isEqualTo(districtBlock);
    }

    @Test
    void testBlockNameGetterAndSetter() {
        final String blockName = "blockName";
        parkingplaceUnderTest.setBlockName(blockName);
        assertThat(parkingplaceUnderTest.getBlockName()).isEqualTo(blockName);
    }

    @Test
    void testDistrictBranchIDGetterAndSetter() {
        final Integer districtBranchID = 0;
        parkingplaceUnderTest.setDistrictBranchID(districtBranchID);
        assertThat(parkingplaceUnderTest.getDistrictBranchID()).isEqualTo(districtBranchID);
    }

    @Test
    void testDistrictBranchMappingGetterAndSetter() {
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        parkingplaceUnderTest.setDistrictBranchMapping(districtBranchMapping);
        assertThat(parkingplaceUnderTest.getDistrictBranchMapping()).isEqualTo(districtBranchMapping);
    }

    @Test
    void testVillageNameGetterAndSetter() {
        final String villageName = "villageName";
        parkingplaceUnderTest.setVillageName(villageName);
        assertThat(parkingplaceUnderTest.getVillageName()).isEqualTo(villageName);
    }

    @Test
    void testAreaHQAddressGetterAndSetter() {
        final String areaHQAddress = "areaHQAddress";
        parkingplaceUnderTest.setAreaHQAddress(areaHQAddress);
        assertThat(parkingplaceUnderTest.getAreaHQAddress()).isEqualTo(areaHQAddress);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        parkingplaceUnderTest.setDeleted(deleted);
        assertThat(parkingplaceUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        parkingplaceUnderTest.setProcessed(processed);
        assertThat(parkingplaceUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        parkingplaceUnderTest.setCreatedBy(createdBy);
        assertThat(parkingplaceUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        parkingplaceUnderTest.setCreatedDate(createdDate);
        assertThat(parkingplaceUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        parkingplaceUnderTest.setModifiedBy(modifiedBy);
        assertThat(parkingplaceUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        parkingplaceUnderTest.setLastModDate(lastModDate);
        assertThat(parkingplaceUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        parkingplaceUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(parkingplaceUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testToString() {
        assertThat(parkingplaceUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testM_providerServiceMappingGetterAndSetter() {
        final ProviderServiceMapping m_providerServiceMapping = new ProviderServiceMapping(false, 0);
        parkingplaceUnderTest.setM_providerServiceMapping(m_providerServiceMapping);
        assertThat(parkingplaceUnderTest.getM_providerServiceMapping()).isEqualTo(m_providerServiceMapping);
    }

    @Test
    void testM_countryGetterAndSetter() {
        final Country m_country = new Country();
        parkingplaceUnderTest.setM_country(m_country);
        assertThat(parkingplaceUnderTest.getM_country()).isEqualTo(m_country);
    }

    @Test
    void testM_districtGetterAndSetter() {
        final Districts m_district = new Districts(0, "DistrictName", 0, "stateName");
        parkingplaceUnderTest.setM_district(m_district);
        assertThat(parkingplaceUnderTest.getM_district()).isEqualTo(m_district);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        parkingplaceUnderTest.setOutputMapper(outputMapper);
        assertThat(parkingplaceUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(parkingplaceUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(parkingplaceUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(parkingplaceUnderTest.hashCode()).isEqualTo(0);
    }
}
