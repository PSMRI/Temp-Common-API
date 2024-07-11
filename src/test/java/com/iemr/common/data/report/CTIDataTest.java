package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CTIDataTest {

	@InjectMocks
    private CTIData ctiDataUnderTest;

    @BeforeEach
    void setUp() {
        ctiDataUnderTest = new CTIData();
    }

    @Test
    void testToString() {
        assertThat(ctiDataUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testResponseGetterAndSetter() {
        final CTIResponse response = new CTIResponse();
        ctiDataUnderTest.setResponse(response);
        assertThat(ctiDataUnderTest.getResponse()).isEqualTo(response);
    }
}
