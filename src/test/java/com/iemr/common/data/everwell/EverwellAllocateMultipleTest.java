package com.iemr.common.data.everwell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EverwellAllocateMultipleTest {

	@InjectMocks
    private EverwellAllocateMultiple everwellAllocateMultipleUnderTest;

    @BeforeEach
    void setUp() {
        everwellAllocateMultipleUnderTest = new EverwellAllocateMultiple();
    }

    @Test
    void testAllocateNoGetterAndSetter() {
        final Integer allocateNo = 0;
        everwellAllocateMultipleUnderTest.setAllocateNo(allocateNo);
        assertThat(everwellAllocateMultipleUnderTest.getAllocateNo()).isEqualTo(allocateNo);
    }

    @Test
    void testAgentIdGetterAndSetter() {
        final List<Integer> agentId = List.of(0);
        everwellAllocateMultipleUnderTest.setAgentId(agentId);
        assertThat(everwellAllocateMultipleUnderTest.getAgentId()).isEqualTo(agentId);
    }

    @Test
    void testOutboundCallRequestsGetterAndSetter() {
        final EverwellDetails[] outboundCallRequests = new EverwellDetails[]{new EverwellDetails()};
        everwellAllocateMultipleUnderTest.setOutboundCallRequests(outboundCallRequests);
        assertThat(everwellAllocateMultipleUnderTest.getOutboundCallRequests()).isEqualTo(outboundCallRequests);
    }

    @Test
    void testEquals() {
        assertThat(everwellAllocateMultipleUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(everwellAllocateMultipleUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(everwellAllocateMultipleUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(everwellAllocateMultipleUnderTest.toString()).isEqualTo("result");
    }
}
