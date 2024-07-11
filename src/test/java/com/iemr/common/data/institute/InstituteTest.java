package com.iemr.common.data.institute;

import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.directory.InstituteDirectoryMapping;
import com.iemr.common.data.directory.SubDirectory;
import com.iemr.common.data.feedback.FeedbackDetails;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class InstituteTest {

	@InjectMocks
    private Institute instituteUnderTest;

    @BeforeEach
    void setUp() {
        instituteUnderTest = new Institute(0, "institutionName", 0, 0, 0);
    }

    @Test
    void testInstitutionNameGetterAndSetter() {
        final String institutionName = "institutionName";
        instituteUnderTest.setInstitutionName(institutionName);
        assertThat(instituteUnderTest.getInstituteName()).isEqualTo(institutionName);
    }

    @Test
    void testInstitutionIDGetterAndSetter() {
        final Integer institutionID = 0;
        instituteUnderTest.setInstitutionID(institutionID);
        assertThat(instituteUnderTest.getInstitutionID()).isEqualTo(institutionID);
    }

    @Test
    void testInstitutionName1GetterAndSetter() {
        final String institutionName = "institutionName";
        instituteUnderTest.setInstitutionName(institutionName);
        assertThat(instituteUnderTest.getInstitutionName()).isEqualTo(institutionName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        instituteUnderTest.setStateID(stateID);
        assertThat(instituteUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        instituteUnderTest.setDistrictID(districtID);
        assertThat(instituteUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDistrictBranchMappingIDGetterAndSetter() {
        final Integer districtBranchMappingID = 0;
        instituteUnderTest.setDistrictBranchMappingID(districtBranchMappingID);
        assertThat(instituteUnderTest.getDistrictBranchMappingID()).isEqualTo(districtBranchMappingID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        instituteUnderTest.setDeleted(deleted);
        assertThat(instituteUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        instituteUnderTest.setCreatedBy(createdBy);
        assertThat(instituteUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        instituteUnderTest.setCreatedDate(createdDate);
        assertThat(instituteUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        instituteUnderTest.setModifiedBy(modifiedBy);
        assertThat(instituteUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        instituteUnderTest.setLastModDate(lastModDate);
        assertThat(instituteUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(instituteUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testInstituteDirectoryGetterAndSetter() {
        final List<InstituteDirectoryMapping> instituteDirectory = List.of(
                new InstituteDirectoryMapping(0L, 0, new Institute(), false, 0, new Directory(0, "directoryName"), 0,
                        new SubDirectory(0, 0, "instituteSubDirectoryName")));
        instituteUnderTest.setInstituteDirectory(instituteDirectory);
        assertThat(instituteUnderTest.getInstituteDirectory()).isEqualTo(instituteDirectory);
    }

    @Test
    void testFeedbackDetailsGetterAndSetter() {
        final Set<FeedbackDetails> feedbackDetails = Set.of(new FeedbackDetails());
        instituteUnderTest.setFeedbackDetails(feedbackDetails);
        assertThat(instituteUnderTest.getFeedbackDetails()).isEqualTo(feedbackDetails);
    }

    @Test
    void testInstitutionTypeIdGetterAndSetter() {
        final Integer institutionTypeId = 0;
        instituteUnderTest.setInstitutionTypeId(institutionTypeId);
        assertThat(instituteUnderTest.getInstitutionTypeId()).isEqualTo(institutionTypeId);
    }

    @Test
    void testStatesGetterAndSetter() {
        final States states = new States();
        instituteUnderTest.setStates(states);
        assertThat(instituteUnderTest.getStates()).isEqualTo(states);
    }

    @Test
    void testDistrictGetterAndSetter() {
        final Districts district = new Districts(0, "DistrictName", 0, "stateName");
        instituteUnderTest.setDistrict(district);
        assertThat(instituteUnderTest.getDistrict()).isEqualTo(district);
    }

    @Test
    void testBlockIDGetterAndSetter() {
        final Integer blockID = 0;
        instituteUnderTest.setBlockID(blockID);
        assertThat(instituteUnderTest.getBlockID()).isEqualTo(blockID);
    }

    @Test
    void testDistrictBlockGetterAndSetter() {
        final DistrictBlock districtBlock = new DistrictBlock(0, "BlockName");
        instituteUnderTest.setDistrictBlock(districtBlock);
        assertThat(instituteUnderTest.getDistrictBlock()).isEqualTo(districtBlock);
    }

    @Test
    void testM_districtbranchmappingGetterAndSetter() {
        final DistrictBranchMapping m_districtbranchmapping = new DistrictBranchMapping(0, "VillageName",
                "PanchayatName", "Habitat", "PinCode");
        instituteUnderTest.setM_districtbranchmapping(m_districtbranchmapping);
        assertThat(instituteUnderTest.getM_districtbranchmapping()).isEqualTo(m_districtbranchmapping);
    }

    @Test
    void testGovtInstituteIDGetterAndSetter() {
        final String govtInstituteID = "govtInstituteID";
        instituteUnderTest.setGovtInstituteID(govtInstituteID);
        assertThat(instituteUnderTest.getGovtInstituteID()).isEqualTo(govtInstituteID);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        instituteUnderTest.setAddress(address);
        assertThat(instituteUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testContactPerson1GetterAndSetter() {
        final String contactPerson1 = "contactPerson1";
        instituteUnderTest.setContactPerson1(contactPerson1);
        assertThat(instituteUnderTest.getContactPerson1()).isEqualTo(contactPerson1);
    }

    @Test
    void testContactPerson1_EmailGetterAndSetter() {
        final String contactPerson1_Email = "contactPerson1_Email";
        instituteUnderTest.setContactPerson1_Email(contactPerson1_Email);
        assertThat(instituteUnderTest.getContactPerson1_Email()).isEqualTo(contactPerson1_Email);
    }

    @Test
    void testContactNo1GetterAndSetter() {
        final String contactNo1 = "contactNo1";
        instituteUnderTest.setContactNo1(contactNo1);
        assertThat(instituteUnderTest.getContactNo1()).isEqualTo(contactNo1);
    }

    @Test
    void testContactPerson2GetterAndSetter() {
        final String contactPerson2 = "contactPerson2";
        instituteUnderTest.setContactPerson2(contactPerson2);
        assertThat(instituteUnderTest.getContactPerson2()).isEqualTo(contactPerson2);
    }

    @Test
    void testContactPerson2_EmailGetterAndSetter() {
        final String contactPerson2_Email = "contactPerson2_Email";
        instituteUnderTest.setContactPerson2_Email(contactPerson2_Email);
        assertThat(instituteUnderTest.getContactPerson2_Email()).isEqualTo(contactPerson2_Email);
    }

    @Test
    void testContactNo2GetterAndSetter() {
        final String contactNo2 = "contactNo2";
        instituteUnderTest.setContactNo2(contactNo2);
        assertThat(instituteUnderTest.getContactNo2()).isEqualTo(contactNo2);
    }

    @Test
    void testContactPerson3GetterAndSetter() {
        final String contactPerson3 = "contactPerson3";
        instituteUnderTest.setContactPerson3(contactPerson3);
        assertThat(instituteUnderTest.getContactPerson3()).isEqualTo(contactPerson3);
    }

    @Test
    void testContactPerson3_EmailGetterAndSetter() {
        final String contactPerson3_Email = "contactPerson3_Email";
        instituteUnderTest.setContactPerson3_Email(contactPerson3_Email);
        assertThat(instituteUnderTest.getContactPerson3_Email()).isEqualTo(contactPerson3_Email);
    }

    @Test
    void testContactNo3GetterAndSetter() {
        final String contactNo3 = "contactNo3";
        instituteUnderTest.setContactNo3(contactNo3);
        assertThat(instituteUnderTest.getContactNo3()).isEqualTo(contactNo3);
    }

    @Test
    void testWebsiteGetterAndSetter() {
        final String website = "website";
        instituteUnderTest.setWebsite(website);
        assertThat(instituteUnderTest.getWebsite()).isEqualTo(website);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        instituteUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(instituteUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        instituteUnderTest.setProcessed(processed);
        assertThat(instituteUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        instituteUnderTest.setOutputMapper(outputMapper);
        assertThat(instituteUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(instituteUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(instituteUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(instituteUnderTest.hashCode()).isEqualTo(0);
    }
}
