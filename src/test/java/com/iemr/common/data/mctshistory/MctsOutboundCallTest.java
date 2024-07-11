package com.iemr.common.data.mctshistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MctsOutboundCallTest {

	@InjectMocks
    private MctsOutboundCall mctsOutboundCallUnderTest;

    @BeforeEach
    void setUp() {
        mctsOutboundCallUnderTest = new MctsOutboundCall();
    }

    @Test
    void testObCallIDGetterAndSetter() {
        final Long obCallID = 0L;
        mctsOutboundCallUnderTest.setObCallID(obCallID);
        assertThat(mctsOutboundCallUnderTest.getObCallID()).isEqualTo(obCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        mctsOutboundCallUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(mctsOutboundCallUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Long providerServiceMapID = 0L;
        mctsOutboundCallUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(mctsOutboundCallUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testOutboundCallTypeGetterAndSetter() {
        final String outboundCallType = "outboundCallType";
        mctsOutboundCallUnderTest.setOutboundCallType(outboundCallType);
        assertThat(mctsOutboundCallUnderTest.getOutboundCallType()).isEqualTo(outboundCallType);
    }

    @Test
    void testToString() {
        assertThat(mctsOutboundCallUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testCallDateFromGetterAndSetter() {
        final Date callDateFrom = Date.valueOf(LocalDate.of(2020, 1, 1));
        mctsOutboundCallUnderTest.setCallDateFrom(callDateFrom);
        assertThat(mctsOutboundCallUnderTest.getCallDateFrom()).isEqualTo(callDateFrom);
    }

    @Test
    void testMctsDataReaderDetailGetterAndSetter() {
        final MctsDataReaderDetail mctsDataReaderDetail = new MctsDataReaderDetail();
        mctsOutboundCallUnderTest.setMctsDataReaderDetail(mctsDataReaderDetail);
        assertThat(mctsOutboundCallUnderTest.getMctsDataReaderDetail()).isEqualTo(mctsDataReaderDetail);
    }

    @Test
    void testAllocationStatusGetterAndSetter() {
        final String allocationStatus = "allocationStatus";
        mctsOutboundCallUnderTest.setAllocationStatus(allocationStatus);
        assertThat(mctsOutboundCallUnderTest.getAllocationStatus()).isEqualTo(allocationStatus);
    }
}
