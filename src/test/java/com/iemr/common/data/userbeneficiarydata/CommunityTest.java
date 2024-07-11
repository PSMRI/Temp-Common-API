package com.iemr.common.data.userbeneficiarydata;

import com.iemr.common.data.beneficiary.BenDemographics;
import com.iemr.common.data.users.UserDemographics;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CommunityTest {

	@InjectMocks
    private Community communityUnderTest;

    @BeforeEach
    void setUp() {
        communityUnderTest = new Community();
    }

    @Test
    void testGetCommunity1() {
        // Setup
        final Community expectedResult = new Community();
        expectedResult.setCommunityID(0);
        final BenDemographics benDemographics = new BenDemographics();
        expectedResult.setI_bendemographics(Set.of(benDemographics));
        expectedResult.setCommunityType("communityType");
        expectedResult.setCommunityDesc("communityDesc");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Community result = communityUnderTest.getCommunity(0, "communityType", "communityDesc");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetCommunity2() {
        // Setup
        final Community expectedResult = new Community();
        expectedResult.setCommunityID(0);
        final BenDemographics benDemographics = new BenDemographics();
        expectedResult.setI_bendemographics(Set.of(benDemographics));
        expectedResult.setCommunityType("communityType");
        expectedResult.setCommunityDesc("communityDesc");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final Community result = communityUnderTest.getCommunity(0, "communityType");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(communityUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCommunityIDGetterAndSetter() {
        final Integer communityID = 0;
        communityUnderTest.setCommunityID(communityID);
        assertThat(communityUnderTest.getCommunityID()).isEqualTo(communityID);
    }

    @Test
    void testI_bendemographicsGetterAndSetter() {
        final Set<BenDemographics> i_bendemographics = Set.of(new BenDemographics());
        communityUnderTest.setI_bendemographics(i_bendemographics);
        assertThat(communityUnderTest.getI_bendemographics()).isEqualTo(i_bendemographics);
    }

    @Test
    void testM_userdemographicsGetterAndSetter() {
        final Set<UserDemographics> m_userdemographics = Set.of();
        communityUnderTest.setM_userdemographics(m_userdemographics);
        assertThat(communityUnderTest.getM_userdemographics()).isEqualTo(m_userdemographics);
    }

    @Test
    void testCommunityTypeGetterAndSetter() {
        final String communityType = "communityType";
        communityUnderTest.setCommunityType(communityType);
        assertThat(communityUnderTest.getCommunityType()).isEqualTo(communityType);
    }

    @Test
    void testCommunityDescGetterAndSetter() {
        final String communityDesc = "communityDesc";
        communityUnderTest.setCommunityDesc(communityDesc);
        assertThat(communityUnderTest.getCommunityDesc()).isEqualTo(communityDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        communityUnderTest.setDeleted(deleted);
        assertThat(communityUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        communityUnderTest.setCreatedBy(createdBy);
        assertThat(communityUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        communityUnderTest.setCreatedDate(createdDate);
        assertThat(communityUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        communityUnderTest.setModifiedBy(modifiedBy);
        assertThat(communityUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        communityUnderTest.setLastModDate(lastModDate);
        assertThat(communityUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        communityUnderTest.setOutputMapper(outputMapper);
        assertThat(communityUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(communityUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(communityUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(communityUnderTest.hashCode()).isEqualTo(0);
    }
}
