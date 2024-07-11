package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserReportTest {

	@InjectMocks
    private UserReport userReportUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userReportUnderTest = new UserReport();
    }

    @Test
    void testDim_USERIDGetterAndSetter() {
        final Long dim_USERID = 0L;
        userReportUnderTest.setDim_USERID(dim_USERID);
        assertThat(userReportUnderTest.getDim_USERID()).isEqualTo(dim_USERID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        userReportUnderTest.setUserID(userID);
        assertThat(userReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        userReportUnderTest.setFirstName(firstName);
        assertThat(userReportUnderTest.getFirstName()).isEqualTo(firstName);
    }

    @Test
    void testMiddleNameGetterAndSetter() {
        final String middleName = "middleName";
        userReportUnderTest.setMiddleName(middleName);
        assertThat(userReportUnderTest.getMiddleName()).isEqualTo(middleName);
    }

    @Test
    void testLastNameGetterAndSetter() {
        final String lastName = "lastName";
        userReportUnderTest.setLastName(lastName);
        assertThat(userReportUnderTest.getLastName()).isEqualTo(lastName);
    }

    @Test
    void testEmpIDGetterAndSetter() {
        final String empID = "empID";
        userReportUnderTest.setEmpID(empID);
        assertThat(userReportUnderTest.getEmpID()).isEqualTo(empID);
    }

    @Test
    void testUserServiceRoleReportGetterAndSetter() {
        final UserServiceRoleReport userServiceRoleReport = new UserServiceRoleReport();
        userReportUnderTest.setUserServiceRoleReport(userServiceRoleReport);
        assertThat(userReportUnderTest.getUserServiceRoleReport()).isEqualTo(userServiceRoleReport);
    }

    @Test
    void testEquals() {
        assertThat(userReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(userReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(userReportUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userReportUnderTest.toString()).isEqualTo("result");
    }
}
