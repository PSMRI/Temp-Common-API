package com.iemr.common.data.everwell;

import com.iemr.common.data.beneficiary.BenPhoneMap;
import com.iemr.common.model.beneficiary.BeneficiaryDemographicsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class EverwellRegistration1097IdentityTest {

    @Mock
    private BeneficiaryDemographicsModel mockBendemographics;

    @InjectMocks
    private EverwellRegistration1097Identity everwellRegistration1097IdentityUnderTest;

    @BeforeEach
    void setUp() {
        everwellRegistration1097IdentityUnderTest = new EverwellRegistration1097Identity(0, 0, "firstName", "lastName",
                0, 0, 0, new ArrayList<>(List.of(new BenPhoneMap())), 0, 0, false, "createdBy", 0, mockBendemographics,
                false);
    }
}
