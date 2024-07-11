package com.iemr.common.data.report;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DimUserReportTest {

	@InjectMocks
    private DimUserReport dimUserReportUnderTest;

    @BeforeEach
    void setUp() {
        dimUserReportUnderTest = new DimUserReport();
    }

    @Test
    void testDim_USERIDGetterAndSetter() {
        final Long dim_USERID = 0L;
        dimUserReportUnderTest.setDim_USERID(dim_USERID);
        assertThat(dimUserReportUnderTest.getDim_USERID()).isEqualTo(dim_USERID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        dimUserReportUnderTest.setUserID(userID);
        assertThat(dimUserReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testEmpIDGetterAndSetter() {
        final String empID = "empID";
        dimUserReportUnderTest.setEmpID(empID);
        assertThat(dimUserReportUnderTest.getEmpID()).isEqualTo(empID);
    }

    @Test
    void testFirstNameGetterAndSetter() {
        final String firstName = "firstName";
        dimUserReportUnderTest.setFirstName(firstName);
        assertThat(dimUserReportUnderTest.getFirstName()).isEqualTo(firstName);
    }
}
