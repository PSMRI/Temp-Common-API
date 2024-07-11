package com.iemr.common.data.helpline104history;

import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class T_EpidemicOutbreakTest {

	@InjectMocks
    private T_EpidemicOutbreak tEpidemicOutbreakUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tEpidemicOutbreakUnderTest = new T_EpidemicOutbreak();
    }

    @Test
    void testToString() throws Exception {
        assertThat(tEpidemicOutbreakUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOutbreakComplaintIDGetterAndSetter() {
        final Long outbreakComplaintID = 0L;
        tEpidemicOutbreakUnderTest.setOutbreakComplaintID(outbreakComplaintID);
        assertThat(tEpidemicOutbreakUnderTest.getOutbreakComplaintID()).isEqualTo(outbreakComplaintID);
    }

    @Test
    void testRequestIDGetterAndSetter() {
        final String requestID = "requestID";
        tEpidemicOutbreakUnderTest.setRequestID(requestID);
        assertThat(tEpidemicOutbreakUnderTest.getRequestID()).isEqualTo(requestID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        tEpidemicOutbreakUnderTest.setBenCallID(benCallID);
        assertThat(tEpidemicOutbreakUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        tEpidemicOutbreakUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(tEpidemicOutbreakUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testNatureOfComplaintGetterAndSetter() {
        final String natureOfComplaint = "natureOfComplaint";
        tEpidemicOutbreakUnderTest.setNatureOfComplaint(natureOfComplaint);
        assertThat(tEpidemicOutbreakUnderTest.getNatureOfComplaint()).isEqualTo(natureOfComplaint);
    }

    @Test
    void testTotalPeopleAffectedGetterAndSetter() {
        final Integer totalPeopleAffected = 0;
        tEpidemicOutbreakUnderTest.setTotalPeopleAffected(totalPeopleAffected);
        assertThat(tEpidemicOutbreakUnderTest.getTotalPeopleAffected()).isEqualTo(totalPeopleAffected);
    }

    @Test
    void testAffectedDistrictIDGetterAndSetter() {
        final Integer affectedDistrictID = 0;
        tEpidemicOutbreakUnderTest.setAffectedDistrictID(affectedDistrictID);
        assertThat(tEpidemicOutbreakUnderTest.getAffectedDistrictID()).isEqualTo(affectedDistrictID);
    }

    @Test
    void testM_districtGetterAndSetter() {
        final Districts m_district = new Districts(0, "DistrictName", 0, "stateName");
        tEpidemicOutbreakUnderTest.setM_district(m_district);
        assertThat(tEpidemicOutbreakUnderTest.getM_district()).isEqualTo(m_district);
    }

    @Test
    void testAffectedDistrictBlockIDGetterAndSetter() {
        final Integer affectedDistrictBlockID = 0;
        tEpidemicOutbreakUnderTest.setAffectedDistrictBlockID(affectedDistrictBlockID);
        assertThat(tEpidemicOutbreakUnderTest.getAffectedDistrictBlockID()).isEqualTo(affectedDistrictBlockID);
    }

    @Test
    void testM_districtblockGetterAndSetter() {
        final DistrictBlock m_districtblock = new DistrictBlock(0, "BlockName");
        tEpidemicOutbreakUnderTest.setM_districtblock(m_districtblock);
        assertThat(tEpidemicOutbreakUnderTest.getM_districtblock()).isEqualTo(m_districtblock);
    }

    @Test
    void testAffectedVillageIDGetterAndSetter() {
        final Integer affectedVillageID = 0;
        tEpidemicOutbreakUnderTest.setAffectedVillageID(affectedVillageID);
        assertThat(tEpidemicOutbreakUnderTest.getAffectedVillageID()).isEqualTo(affectedVillageID);
    }

    @Test
    void testDistrictBranchMappingGetterAndSetter() {
        final DistrictBranchMapping districtBranchMapping = new DistrictBranchMapping(0, "VillageName", "PanchayatName",
                "Habitat", "PinCode");
        tEpidemicOutbreakUnderTest.setDistrictBranchMapping(districtBranchMapping);
        assertThat(tEpidemicOutbreakUnderTest.getDistrictBranchMapping()).isEqualTo(districtBranchMapping);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        tEpidemicOutbreakUnderTest.setServiceID(serviceID);
        assertThat(tEpidemicOutbreakUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testRemarksGetterAndSetter() {
        final String remarks = "remarks";
        tEpidemicOutbreakUnderTest.setRemarks(remarks);
        assertThat(tEpidemicOutbreakUnderTest.getRemarks()).isEqualTo(remarks);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        tEpidemicOutbreakUnderTest.setDeleted(deleted);
        assertThat(tEpidemicOutbreakUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        tEpidemicOutbreakUnderTest.setCreatedBy(createdBy);
        assertThat(tEpidemicOutbreakUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        tEpidemicOutbreakUnderTest.setModifiedBy(modifiedBy);
        assertThat(tEpidemicOutbreakUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        tEpidemicOutbreakUnderTest.setCreatedDate(createdDate);
        assertThat(tEpidemicOutbreakUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        tEpidemicOutbreakUnderTest.setOutputMapper(outputMapper);
        assertThat(tEpidemicOutbreakUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(tEpidemicOutbreakUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(tEpidemicOutbreakUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(tEpidemicOutbreakUnderTest.hashCode()).isEqualTo(0);
    }
}
