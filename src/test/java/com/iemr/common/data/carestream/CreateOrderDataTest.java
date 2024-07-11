package com.iemr.common.data.carestream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CreateOrderDataTest {

	@InjectMocks
    private CreateOrderData createOrderDataUnderTest;

    @BeforeEach
    void setUp() {
        createOrderDataUnderTest = new CreateOrderData("firstName", "middleName", "lastName", "gender", "dob",
                "patientID", "acc");
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        createOrderDataUnderTest.setFirstName(firstName);
        assertThat(createOrderDataUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testMiddleNameGetterAndSetter() {
        final String middleName = "middleName";
        createOrderDataUnderTest.setMiddleName(middleName);
        assertThat(createOrderDataUnderTest.getMiddleName()).isEqualTo(middleName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "lastName";
        createOrderDataUnderTest.setLastName(lastName);
        assertThat(createOrderDataUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "gender";
        createOrderDataUnderTest.setGender(gender);
        assertThat(createOrderDataUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testDobGetterAndSetter() {
        final String dob = "dob";
        createOrderDataUnderTest.setDob(dob);
        assertThat(createOrderDataUnderTest.getDob()).isEqualTo(dob);
    }

    @Test
    void testPatientIDGetterAndSetter() {
        final String patientID = "patientID";
        createOrderDataUnderTest.setPatientID(patientID);
        assertThat(createOrderDataUnderTest.getPatientID()).isEqualTo(patientID);
    }

    @Test
    void testAccGetterAndSetter() {
        final String acc = "acc";
        createOrderDataUnderTest.setAcc(acc);
        assertThat(createOrderDataUnderTest.getAcc()).isEqualTo(acc);
    }
}
