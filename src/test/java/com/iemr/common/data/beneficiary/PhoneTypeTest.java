package com.iemr.common.data.beneficiary;

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
class PhoneTypeTest {

	@InjectMocks
    private PhoneType phoneTypeUnderTest;

    @BeforeEach
    void setUp() {
        phoneTypeUnderTest = new PhoneType();
    }

    @Test
    void testCreatePhoneType() {
        // Setup
        final PhoneType expectedResult = new PhoneType();
        expectedResult.setPhoneTypeID(0);
        final BenPhoneMap benPhoneMap = new BenPhoneMap();
        expectedResult.setBenPhoneMap(Set.of(benPhoneMap));
        expectedResult.setPhoneType("phoneType");
        expectedResult.setDeleted(false);
        final OutputMapper outputMapper = new OutputMapper();
        expectedResult.setOutputMapper(outputMapper);

        // Run the test
        final PhoneType result = phoneTypeUnderTest.createPhoneType(0, "phoneType", false);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testToString() throws Exception {
        assertThat(phoneTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testPhoneTypeIDGetterAndSetter() {
        final Integer phoneTypeID = 0;
        phoneTypeUnderTest.setPhoneTypeID(phoneTypeID);
        assertThat(phoneTypeUnderTest.getPhoneTypeID()).isEqualTo(phoneTypeID);
    }

    @Test
    void testBenPhoneMapGetterAndSetter() {
        final Set<BenPhoneMap> benPhoneMap = Set.of(new BenPhoneMap());
        phoneTypeUnderTest.setBenPhoneMap(benPhoneMap);
        assertThat(phoneTypeUnderTest.getBenPhoneMap()).isEqualTo(benPhoneMap);
    }

    @Test
    void testPhoneTypeGetterAndSetter() {
        final String phoneType = "phoneType";
        phoneTypeUnderTest.setPhoneType(phoneType);
        assertThat(phoneTypeUnderTest.getPhoneType()).isEqualTo(phoneType);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        phoneTypeUnderTest.setDeleted(deleted);
        assertThat(phoneTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        phoneTypeUnderTest.setCreatedBy(createdBy);
        assertThat(phoneTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneTypeUnderTest.setCreatedDate(createdDate);
        assertThat(phoneTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        phoneTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(phoneTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        phoneTypeUnderTest.setLastModDate(lastModDate);
        assertThat(phoneTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        phoneTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(phoneTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(phoneTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(phoneTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(phoneTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
