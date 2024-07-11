package com.iemr.common.data.nhm_dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NHMAgentRequestTest {

	@InjectMocks
    private NHMAgentRequest nhmAgentRequestUnderTest;

    @BeforeEach
    void setUp() {
        nhmAgentRequestUnderTest = new NHMAgentRequest();
    }

    @Test
    void testCampaign_nameGetterAndSetter() {
        final String campaign_name = "campaign_name";
        nhmAgentRequestUnderTest.setCampaign_name(campaign_name);
        assertThat(nhmAgentRequestUnderTest.getCampaign_name()).isEqualTo(campaign_name);
    }

    @Test
    void testEquals() {
        assertThat(nhmAgentRequestUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(nhmAgentRequestUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(nhmAgentRequestUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(nhmAgentRequestUnderTest.toString()).isEqualTo("result");
    }
}
