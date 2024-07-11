package com.iemr.common.data.everwell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BenPhoneMapsTest {

	@InjectMocks
    private BenPhoneMaps benPhoneMapsUnderTest;

    @BeforeEach
    void setUp() {
        benPhoneMapsUnderTest = new BenPhoneMaps(0, "phoneNo", "createdBy", false);
    }
}
