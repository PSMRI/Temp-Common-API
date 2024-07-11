package com.iemr.common.data.userbeneficiarydata;

import com.iemr.common.data.beneficiary.Beneficiary;
import com.iemr.common.data.users.User;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MaritalStatusTest {

	@InjectMocks
    private MaritalStatus maritalStatusUnderTest;

    @BeforeEach
    void setUp() {
        maritalStatusUnderTest = new MaritalStatus();
    }

    @Test
    void testGetMaritalStatus() {
        // Setup
        final MaritalStatus expectedResult = new MaritalStatus();
        expectedResult.setMaritalStatusID(0);
        final Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryRegID(0L);
        expectedResult.setI_beneficiary(Set.of(beneficiary));
        expectedResult.setStatus("status");
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final MaritalStatus result = maritalStatusUnderTest.getMaritalStatus(0, "Status");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        assertThat(maritalStatusUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testMaritalStatusIDGetterAndSetter() {
        final Integer maritalStatusID = 0;
        maritalStatusUnderTest.setMaritalStatusID(maritalStatusID);
        assertThat(maritalStatusUnderTest.getMaritalStatusID()).isEqualTo(maritalStatusID);
    }

    @Test
    void testI_beneficiaryGetterAndSetter() {
        final Set<Beneficiary> i_beneficiary = Set.of(new Beneficiary());
        maritalStatusUnderTest.setI_beneficiary(i_beneficiary);
        assertThat(maritalStatusUnderTest.getI_beneficiary()).isEqualTo(i_beneficiary);
    }

    @Test
    void testM_userGetterAndSetter() {
        final Set<User> m_user = Set.of(new User());
        maritalStatusUnderTest.setM_user(m_user);
        assertThat(maritalStatusUnderTest.getM_user()).isEqualTo(m_user);
    }

    @Test
    void testStatusGetterAndSetter() {
        final String status = "status";
        maritalStatusUnderTest.setStatus(status);
        assertThat(maritalStatusUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testStatusDescGetterAndSetter() {
        final String statusDesc = "statusDesc";
        maritalStatusUnderTest.setStatusDesc(statusDesc);
        assertThat(maritalStatusUnderTest.getStatusDesc()).isEqualTo(statusDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        maritalStatusUnderTest.setDeleted(deleted);
        assertThat(maritalStatusUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        maritalStatusUnderTest.setCreatedBy(createdBy);
        assertThat(maritalStatusUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        maritalStatusUnderTest.setCreatedDate(createdDate);
        assertThat(maritalStatusUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        maritalStatusUnderTest.setModifiedBy(modifiedBy);
        assertThat(maritalStatusUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        maritalStatusUnderTest.setLastModDate(lastModDate);
        assertThat(maritalStatusUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        maritalStatusUnderTest.setOutputMapper(outputMapper);
        assertThat(maritalStatusUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(maritalStatusUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(maritalStatusUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(maritalStatusUnderTest.hashCode()).isEqualTo(0);
    }
}
