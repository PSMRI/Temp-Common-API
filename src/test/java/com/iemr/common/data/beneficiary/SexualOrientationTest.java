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
class SexualOrientationTest {

	@InjectMocks
    private SexualOrientation sexualOrientationUnderTest;

    @BeforeEach
    void setUp() {
        sexualOrientationUnderTest = new SexualOrientation((short) 0, "sexualOrientation");
    }

    @Test
    void testToString() throws Exception {
        assertThat(sexualOrientationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSexualOrientationIdGetterAndSetter() {
        final Short sexualOrientationId = (short) 0;
        sexualOrientationUnderTest.setSexualOrientationId(sexualOrientationId);
        assertThat(sexualOrientationUnderTest.getSexualOrientationId()).isEqualTo(sexualOrientationId);
    }

    @Test
    void testI_BeneficiariesGetterAndSetter() {
        final Set<Beneficiary> i_Beneficiaries = Set.of(new Beneficiary());
        sexualOrientationUnderTest.setI_Beneficiaries(i_Beneficiaries);
        assertThat(sexualOrientationUnderTest.getI_Beneficiaries()).isEqualTo(i_Beneficiaries);
    }

    @Test
    void testSexualOrientationGetterAndSetter() {
        final String sexualOrientation = "sexualOrientation";
        sexualOrientationUnderTest.setSexualOrientation(sexualOrientation);
        assertThat(sexualOrientationUnderTest.getSexualOrientation()).isEqualTo(sexualOrientation);
    }

    @Test
    void testSexualOrientationDescGetterAndSetter() {
        final String sexualOrientationDesc = "sexualOrientationDesc";
        sexualOrientationUnderTest.setSexualOrientationDesc(sexualOrientationDesc);
        assertThat(sexualOrientationUnderTest.getSexualOrientationDesc()).isEqualTo(sexualOrientationDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        sexualOrientationUnderTest.setDeleted(deleted);
        assertThat(sexualOrientationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        sexualOrientationUnderTest.setCreatedBy(createdBy);
        assertThat(sexualOrientationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        sexualOrientationUnderTest.setCreatedDate(createdDate);
        assertThat(sexualOrientationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        sexualOrientationUnderTest.setModifiedBy(modifiedBy);
        assertThat(sexualOrientationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        sexualOrientationUnderTest.setLastModDate(lastModDate);
        assertThat(sexualOrientationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        sexualOrientationUnderTest.setOutputMapper(outputMapper);
        assertThat(sexualOrientationUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(sexualOrientationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(sexualOrientationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(sexualOrientationUnderTest.hashCode()).isEqualTo(0);
    }
}
