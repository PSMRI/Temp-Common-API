package com.iemr.common.data.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_RoleTest {

	@InjectMocks
    private M_Role mRoleUnderTest;

    @BeforeEach
    void setUp() {
        mRoleUnderTest = new M_Role();
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Integer roleID = 0;
        mRoleUnderTest.setRoleID(roleID);
        assertThat(mRoleUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testSetRoleID1() {
        // Setup
        // Run the test
        mRoleUnderTest.setRoleID(0);

        // Verify the results
    }

    @Test
    void testRoleNameGetterAndSetter() {
        final String roleName = "roleName";
        mRoleUnderTest.setRoleName(roleName);
        assertThat(mRoleUnderTest.getRoleName()).isEqualTo(roleName);
    }

    @Test
    void testRoleDescGetterAndSetter() {
        final String roleDesc = "roleDesc";
        mRoleUnderTest.setRoleDesc(roleDesc);
        assertThat(mRoleUnderTest.getRoleDesc()).isEqualTo(roleDesc);
    }

    @Test
    void testIsDeleted() {
        // Setup
        // Run the test
        final boolean result = mRoleUnderTest.isDeleted();

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSetDeleted1() {
        // Setup
        // Run the test
        mRoleUnderTest.setDeleted(false);

        // Verify the results
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mRoleUnderTest.setCreatedBy(createdBy);
        assertThat(mRoleUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        mRoleUnderTest.setCreatedDate(createdDate);
        assertThat(mRoleUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mRoleUnderTest.setModifiedBy(modifiedBy);
        assertThat(mRoleUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        mRoleUnderTest.setLastModDate(lastModDate);
        assertThat(mRoleUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testIsWrapUpTimeGetterAndSetter() {
        final Boolean isWrapUpTime = false;
        mRoleUnderTest.setIsWrapUpTime(isWrapUpTime);
        assertThat(mRoleUnderTest.getIsWrapUpTime()).isFalse();
    }

    @Test
    void testWrapUpTimeGetterAndSetter() {
        final Integer wrapUpTime = 0;
        mRoleUnderTest.setWrapUpTime(wrapUpTime);
        assertThat(mRoleUnderTest.getWrapUpTime()).isEqualTo(wrapUpTime);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mRoleUnderTest.setDeleted(deleted);
        assertThat(mRoleUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testToString() {
        assertThat(mRoleUnderTest.toString()).isEqualTo("result");
    }
}
