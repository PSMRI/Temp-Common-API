package com.iemr.common.data.callhandling;

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
class CallTypeTest {

	@InjectMocks
    private CallType callTypeUnderTest;

    @BeforeEach
    void setUp() {
        callTypeUnderTest = new CallType();
    }

    @Test
    void testCreateCallTypes() {
        // Setup
        final CallType expectedResult = new CallType();
        expectedResult.setCallTypeID(0);
        expectedResult.setCallGroupType("callGroupType");
        expectedResult.setCallType("callType");
        expectedResult.setCallTypeDesc("callTypeDesc");
        expectedResult.setIsInbound(false);
        expectedResult.setIsOutbound(false);
        expectedResult.setFitToBlock(false);
        expectedResult.setFitForFollowUp(false);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final CallType result = callTypeUnderTest.createCallTypes(0, "callType", "callTypeDesc", "callGroupType", false,
                false, false, false);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(callTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCallGroupTypeGetterAndSetter() {
        final String callGroupType = "callGroupType";
        callTypeUnderTest.setCallGroupType(callGroupType);
        assertThat(callTypeUnderTest.getCallGroupType()).isEqualTo(callGroupType);
    }

    @Test
    void testCallTypeGetterAndSetter() {
        final String callType = "callType";
        callTypeUnderTest.setCallType(callType);
        assertThat(callTypeUnderTest.getCallType()).isEqualTo(callType);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        callTypeUnderTest.setCallTypeID(callTypeID);
        assertThat(callTypeUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testBeneficiaryCallsGetterAndSetter() {
        final List<BeneficiaryCall> beneficiaryCalls = List.of(new BeneficiaryCall());
        callTypeUnderTest.setBeneficiaryCalls(beneficiaryCalls);
        assertThat(callTypeUnderTest.getBeneficiaryCalls()).isEqualTo(beneficiaryCalls);
    }

    @Test
    void testCallTypeDescGetterAndSetter() {
        final String callTypeDesc = "callTypeDesc";
        callTypeUnderTest.setCallTypeDesc(callTypeDesc);
        assertThat(callTypeUnderTest.getCallTypeDesc()).isEqualTo(callTypeDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        callTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(callTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testIsInboundGetterAndSetter() {
        final Boolean isInbound = false;
        callTypeUnderTest.setIsInbound(isInbound);
        assertThat(callTypeUnderTest.getIsInbound()).isFalse();
    }

    @Test
    void testIsOutboundGetterAndSetter() {
        final Boolean isOutbound = false;
        callTypeUnderTest.setIsOutbound(isOutbound);
        assertThat(callTypeUnderTest.getIsOutbound()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        callTypeUnderTest.setDeleted(deleted);
        assertThat(callTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        callTypeUnderTest.setCreatedBy(createdBy);
        assertThat(callTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callTypeUnderTest.setCreatedDate(createdDate);
        assertThat(callTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        callTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(callTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        callTypeUnderTest.setLastModDate(lastModDate);
        assertThat(callTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFitToBlockGetterAndSetter() {
        final Boolean fitToBlock = false;
        callTypeUnderTest.setFitToBlock(fitToBlock);
        assertThat(callTypeUnderTest.getFitToBlock()).isFalse();
    }

    @Test
    void testFitForFollowUpGetterAndSetter() {
        final Boolean fitForFollowUp = false;
        callTypeUnderTest.setFitForFollowUp(fitForFollowUp);
        assertThat(callTypeUnderTest.getFitForFollowUp()).isFalse();
    }

    @Test
    void testMaxRedialGetterAndSetter() {
        final Integer maxRedial = 0;
        callTypeUnderTest.setMaxRedial(maxRedial);
        assertThat(callTypeUnderTest.getMaxRedial()).isEqualTo(maxRedial);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        callTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(callTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(callTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(callTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(callTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
