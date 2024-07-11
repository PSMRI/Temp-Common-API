package com.iemr.common.data.everwell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EverwellSupportActionTest {

	@InjectMocks
    private EverwellSupportAction everwellSupportActionUnderTest;

    @BeforeEach
    void setUp() {
        everwellSupportActionUnderTest = new EverwellSupportAction();
    }

    @Test
    void testAddDoseGetterAndSetter() {
        final Boolean addDose = false;
        everwellSupportActionUnderTest.setAddDose(addDose);
        assertThat(everwellSupportActionUnderTest.getAddDose()).isFalse();
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final Timestamp dateOfAction = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellSupportActionUnderTest.setDateOfAction(dateOfAction);
        assertThat(everwellSupportActionUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }
}
