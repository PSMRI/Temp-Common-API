package com.iemr.common.data.callhandling;

import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PhoneBlockTest {

    @InjectMocks
    private PhoneBlock phoneBlockUnderTest;

    @BeforeEach
    void setUp() {
        phoneBlockUnderTest = new PhoneBlock();
    }

    @Test
    void testNoOfNuisanceCallGetterAndSetter() {
        final Integer noOfNuisanceCall = 0;
        phoneBlockUnderTest.setNoOfNuisanceCall(noOfNuisanceCall);
        assertThat(phoneBlockUnderTest.getNoOfNuisanceCall()).isEqualTo(noOfNuisanceCall);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        phoneBlockUnderTest.setPhoneNo(phoneNo);
        assertThat(phoneBlockUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testCtiCampaignNameGetterAndSetter() {
        final String ctiCampaignName = "ctiCampaignName";
        phoneBlockUnderTest.setCtiCampaignName(ctiCampaignName);
        assertThat(phoneBlockUnderTest.getCtiCampaignName()).isEqualTo(ctiCampaignName);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        phoneBlockUnderTest.setCreatedBy(createdBy);
        assertThat(phoneBlockUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        phoneBlockUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(phoneBlockUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testPhoneBlockIDGetterAndSetter() {
        final Long phoneBlockID = 0L;
        phoneBlockUnderTest.setPhoneBlockID(phoneBlockID);
        assertThat(phoneBlockUnderTest.getPhoneBlockID()).isEqualTo(phoneBlockID);
    }

    @Test
    void testIsBlockedGetterAndSetter() {
        final Boolean isBlocked = false;
        phoneBlockUnderTest.setIsBlocked(isBlocked);
        assertThat(phoneBlockUnderTest.getIsBlocked()).isFalse();
    }

    @Test
    void testBlockStartDateGetterAndSetter() {
        final Timestamp blockStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneBlockUnderTest.setBlockStartDate(blockStartDate);
        assertThat(phoneBlockUnderTest.getBlockStartDate()).isEqualTo(blockStartDate);
    }

    @Test
    void testBlockEndDateGetterAndSetter() {
        final Timestamp blockEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneBlockUnderTest.setBlockEndDate(blockEndDate);
        assertThat(phoneBlockUnderTest.getBlockEndDate()).isEqualTo(blockEndDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        phoneBlockUnderTest.setModifiedBy(modifiedBy);
        assertThat(phoneBlockUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testInitializePhoneBlockForCreate() {
        // Run the test
        final PhoneBlock result = PhoneBlock.initializePhoneBlockForCreate(0L, "phoneNo", 0, 0, false,
                "ctiCampaignName", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "callIDs");
        assertThat(result.getNoOfNuisanceCall()).isEqualTo(0);
        assertThat(result.getPhoneNo()).isEqualTo("phoneNo");
        assertThat(result.getCtiCampaignName()).isEqualTo("ctiCampaignName");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getPhoneBlockID()).isEqualTo(0L);
        assertThat(result.getIsBlocked()).isFalse();
        assertThat(result.getBlockStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getBlockEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getCallIDs()).isEqualTo("callIDs");
        assertThat(result.getBenCallIDs()).isEqualTo(List.of("value"));
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testInitializePhoneBlock() {
        // Setup
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);

        // Run the test
        final PhoneBlock result = PhoneBlock.initializePhoneBlock(0L, "phoneNo", 0, 0, false, "ctiCampaignName",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), providerServiceMapping, "callIDs");
        assertThat(result.getNoOfNuisanceCall()).isEqualTo(0);
        assertThat(result.getPhoneNo()).isEqualTo("phoneNo");
        assertThat(result.getCtiCampaignName()).isEqualTo("ctiCampaignName");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getPhoneBlockID()).isEqualTo(0L);
        assertThat(result.getIsBlocked()).isFalse();
        assertThat(result.getBlockStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getBlockEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getCallIDs()).isEqualTo("callIDs");
        assertThat(result.getBenCallIDs()).isEqualTo(List.of("value"));
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(phoneBlockUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        phoneBlockUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(phoneBlockUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        phoneBlockUnderTest.setDeleted(deleted);
        assertThat(phoneBlockUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneBlockUnderTest.setCreatedDate(createdDate);
        assertThat(phoneBlockUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneBlockUnderTest.setLastModDate(lastModDate);
        assertThat(phoneBlockUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testCallIDsGetterAndSetter() {
        final String callIDs = "callIDs";
        phoneBlockUnderTest.setCallIDs(callIDs);
        assertThat(phoneBlockUnderTest.getCallIDs()).isEqualTo(callIDs);
    }

    @Test
    void testBenCallIDsGetterAndSetter() {
        final List<String> benCallIDs = List.of("value");
        phoneBlockUnderTest.setBenCallIDs(benCallIDs);
        assertThat(phoneBlockUnderTest.getBenCallIDs()).isEqualTo(benCallIDs);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        phoneBlockUnderTest.setOutputMapper(outputMapper);
        assertThat(phoneBlockUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(phoneBlockUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(phoneBlockUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(phoneBlockUnderTest.hashCode()).isEqualTo(0);
    }
}
