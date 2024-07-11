package com.iemr.common.data.location;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TaluksTest {

	@InjectMocks
    private Taluks taluksUnderTest;

    @BeforeEach
    void setUp() {
        taluksUnderTest = new Taluks(0, "talukName");
    }

    @Test
    void testToString() {
        assertThat(taluksUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testTalukIDGetterAndSetter() {
        final Integer talukID = 0;
        taluksUnderTest.setTalukID(talukID);
        assertThat(taluksUnderTest.getTalukID()).isEqualTo(talukID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        taluksUnderTest.setDistrictID(districtID);
        assertThat(taluksUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testTalukNameGetterAndSetter() {
        final String talukName = "talukName";
        taluksUnderTest.setTalukName(talukName);
        assertThat(taluksUnderTest.getTalukName()).isEqualTo(talukName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        taluksUnderTest.setStateID(stateID);
        assertThat(taluksUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        taluksUnderTest.setDeleted(deleted);
        assertThat(taluksUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        taluksUnderTest.setCreatedBy(createdBy);
        assertThat(taluksUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        taluksUnderTest.setCreatedDate(createdDate);
        assertThat(taluksUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        taluksUnderTest.setModifiedBy(modifiedBy);
        assertThat(taluksUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        taluksUnderTest.setLastModDate(lastModDate);
        assertThat(taluksUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        taluksUnderTest.setOutputMapper(outputMapper);
        assertThat(taluksUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(taluksUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(taluksUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(taluksUnderTest.hashCode()).isEqualTo(0);
    }
}
