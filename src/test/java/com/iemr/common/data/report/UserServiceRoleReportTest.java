package com.iemr.common.data.report;

import com.iemr.common.data.users.WorkLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceRoleReportTest {

	@InjectMocks
    private UserServiceRoleReport userServiceRoleReportUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userServiceRoleReportUnderTest = new UserServiceRoleReport();
    }

    @Test
    void testUSRMappingIDGetterAndSetter() {
        final Long uSRMappingID = 0L;
        userServiceRoleReportUnderTest.setUSRMappingID(uSRMappingID);
        assertThat(userServiceRoleReportUnderTest.getUSRMappingID()).isEqualTo(uSRMappingID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        userServiceRoleReportUnderTest.setUserID(userID);
        assertThat(userServiceRoleReportUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Long roleID = 0L;
        userServiceRoleReportUnderTest.setRoleID(roleID);
        assertThat(userServiceRoleReportUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testWorkingLocationIDGetterAndSetter() {
        final Long workingLocationID = 0L;
        userServiceRoleReportUnderTest.setWorkingLocationID(workingLocationID);
        assertThat(userServiceRoleReportUnderTest.getWorkingLocationID()).isEqualTo(workingLocationID);
    }

    @Test
    void testWorkLocationGetterAndSetter() {
        final WorkLocation workLocation = new WorkLocation();
        userServiceRoleReportUnderTest.setWorkLocation(workLocation);
        assertThat(userServiceRoleReportUnderTest.getWorkLocation()).isEqualTo(workLocation);
    }

    @Test
    void testEquals() {
        assertThat(userServiceRoleReportUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(userServiceRoleReportUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(userServiceRoleReportUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() throws Exception {
        assertThat(userServiceRoleReportUnderTest.toString()).isEqualTo("result");
    }
}
