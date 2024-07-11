package com.iemr.common.data.beneficiary;

import com.iemr.common.data.callhandling.OutboundCallRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BenOutboundCallAllocationTest {

	@InjectMocks
    private BenOutboundCallAllocation benOutboundCallAllocationUnderTest;

    @BeforeEach
    void setUp() {
        benOutboundCallAllocationUnderTest = new BenOutboundCallAllocation();
    }

    @Test
    void testAllocateNoGetterAndSetter() {
        final Integer allocateNo = 0;
        benOutboundCallAllocationUnderTest.setAllocateNo(allocateNo);
        assertThat(benOutboundCallAllocationUnderTest.getAllocateNo()).isEqualTo(allocateNo);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final List<Integer> userID = List.of(0);
        benOutboundCallAllocationUnderTest.setUserID(userID);
        assertThat(benOutboundCallAllocationUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testOutboundCallRequestsGetterAndSetter() {
        final OutboundCallRequest[] outboundCallRequests = new OutboundCallRequest[]{new OutboundCallRequest()};
        benOutboundCallAllocationUnderTest.setOutboundCallRequests(outboundCallRequests);
        assertThat(benOutboundCallAllocationUnderTest.getOutboundCallRequests()).isEqualTo(outboundCallRequests);
    }

    @Test
    void testEquals() {
        assertThat(benOutboundCallAllocationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(benOutboundCallAllocationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(benOutboundCallAllocationUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(benOutboundCallAllocationUnderTest.toString()).isEqualTo("BenOutboundCallAllocation(allocateNo=null, userID=null, outboundCallRequests=null)");
    }

}
