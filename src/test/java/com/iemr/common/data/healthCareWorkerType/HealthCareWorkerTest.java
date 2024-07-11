package com.iemr.common.data.healthCareWorkerType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class HealthCareWorkerTest {

	@InjectMocks
    private HealthCareWorker healthCareWorkerUnderTest;

    @BeforeEach
    void setUp() {
        healthCareWorkerUnderTest = new HealthCareWorker((short) 0, "healthCareWorkerType", "healthCareWorkerDesc",
                false, "createdBy", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "modifiedBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
    }

    @Test
    void testHealthCareWorkerIDGetterAndSetter() {
        final Short healthCareWorkerID = (short) 0;
        healthCareWorkerUnderTest.setHealthCareWorkerID(healthCareWorkerID);
        assertThat(healthCareWorkerUnderTest.getHealthCareWorkerID()).isEqualTo(healthCareWorkerID);
    }

    @Test
    void testHealthCareWorkerTypeGetterAndSetter() {
        final String healthCareWorkerType = "healthCareWorkerType";
        healthCareWorkerUnderTest.setHealthCareWorkerType(healthCareWorkerType);
        assertThat(healthCareWorkerUnderTest.getHealthCareWorkerType()).isEqualTo(healthCareWorkerType);
    }

    @Test
    void testHealthCareWorkerDescGetterAndSetter() {
        final String healthCareWorkerDesc = "healthCareWorkerDesc";
        healthCareWorkerUnderTest.setHealthCareWorkerDesc(healthCareWorkerDesc);
        assertThat(healthCareWorkerUnderTest.getHealthCareWorkerDesc()).isEqualTo(healthCareWorkerDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        healthCareWorkerUnderTest.setDeleted(deleted);
        assertThat(healthCareWorkerUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        healthCareWorkerUnderTest.setCreatedBy(createdBy);
        assertThat(healthCareWorkerUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        healthCareWorkerUnderTest.setCreatedDate(createdDate);
        assertThat(healthCareWorkerUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        healthCareWorkerUnderTest.setModifiedBy(modifiedBy);
        assertThat(healthCareWorkerUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        healthCareWorkerUnderTest.setLastModDate(lastModDate);
        assertThat(healthCareWorkerUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testToString() {
        assertThat(healthCareWorkerUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testEquals() {
        assertThat(healthCareWorkerUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(healthCareWorkerUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(healthCareWorkerUnderTest.hashCode()).isEqualTo(0);
    }
}
