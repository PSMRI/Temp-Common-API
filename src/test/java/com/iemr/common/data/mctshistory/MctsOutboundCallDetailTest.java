package com.iemr.common.data.mctshistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MctsOutboundCallDetailTest {

	@InjectMocks
    private MctsOutboundCallDetail mctsOutboundCallDetailUnderTest;

    @BeforeEach
    void setUp() {
        mctsOutboundCallDetailUnderTest = new MctsOutboundCallDetail();
    }

    @Test
    void testObCallIDGetterAndSetter() {
        final Long obCallID = 0L;
        mctsOutboundCallDetailUnderTest.setObCallID(obCallID);
        assertThat(mctsOutboundCallDetailUnderTest.getObCallID()).isEqualTo(obCallID);
    }

    @Test
    void testCallDetailIDGetterAndSetter() {
        final Long callDetailID = 0L;
        mctsOutboundCallDetailUnderTest.setCallDetailID(callDetailID);
        assertThat(mctsOutboundCallDetailUnderTest.getCallDetailID()).isEqualTo(callDetailID);
    }

    @Test
    void testAllocatedUserIDGetterAndSetter() {
        final Integer allocatedUserID = 0;
        mctsOutboundCallDetailUnderTest.setAllocatedUserID(allocatedUserID);
        assertThat(mctsOutboundCallDetailUnderTest.getAllocatedUserID()).isEqualTo(allocatedUserID);
    }

    @Test
    void testRemarkGetterAndSetter() {
        final String remark = "remark";
        mctsOutboundCallDetailUnderTest.setRemark(remark);
        assertThat(mctsOutboundCallDetailUnderTest.getRemark()).isEqualTo(remark);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Long providerServiceMapID = 0L;
        mctsOutboundCallDetailUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(mctsOutboundCallDetailUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testSmsAdviceGetterAndSetter() {
        final String smsAdvice = "smsAdvice";
        mctsOutboundCallDetailUnderTest.setSmsAdvice(smsAdvice);
        assertThat(mctsOutboundCallDetailUnderTest.getSmsAdvice()).isEqualTo(smsAdvice);
    }

    @Test
    void testCallTypeIDGetterAndSetter() {
        final Integer callTypeID = 0;
        mctsOutboundCallDetailUnderTest.setCallTypeID(callTypeID);
        assertThat(mctsOutboundCallDetailUnderTest.getCallTypeID()).isEqualTo(callTypeID);
    }

    @Test
    void testToString() {
        assertThat(mctsOutboundCallDetailUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCallTimeGetterAndSetter() {
        final Timestamp callTime = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        mctsOutboundCallDetailUnderTest.setCallTime(callTime);
        assertThat(mctsOutboundCallDetailUnderTest.getCallTime()).isEqualTo(callTime);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        mctsOutboundCallDetailUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(mctsOutboundCallDetailUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testIsMotherGetterAndSetter() {
        final Boolean isMother = false;
        mctsOutboundCallDetailUnderTest.setIsMother(isMother);
        assertThat(mctsOutboundCallDetailUnderTest.getIsMother()).isFalse();
    }
}
