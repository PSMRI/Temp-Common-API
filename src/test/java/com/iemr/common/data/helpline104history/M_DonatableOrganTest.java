package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_DonatableOrganTest {

	@InjectMocks
    private M_DonatableOrgan mDonatableOrganUnderTest;

    @BeforeEach
    void setUp() {
        mDonatableOrganUnderTest = new M_DonatableOrgan(0, "donatableOrgan", "donatableOrganDesc");
    }

    @Test
    void testDonatableOrganGetterAndSetter() {
        final String donatableOrgan = "donatableOrgan";
        mDonatableOrganUnderTest.setDonatableOrgan(donatableOrgan);
        assertThat(mDonatableOrganUnderTest.getDonatableOrgan()).isEqualTo(donatableOrgan);
    }

    @Test
    void testDonatableOrganDescGetterAndSetter() {
        final String donatableOrganDesc = "donatableOrganDesc";
        mDonatableOrganUnderTest.setDonatableOrganDesc(donatableOrganDesc);
        assertThat(mDonatableOrganUnderTest.getDonatableOrganDesc()).isEqualTo(donatableOrganDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mDonatableOrganUnderTest.setDeleted(deleted);
        assertThat(mDonatableOrganUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mDonatableOrganUnderTest.setCreatedBy(createdBy);
        assertThat(mDonatableOrganUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mDonatableOrganUnderTest.setModifiedBy(modifiedBy);
        assertThat(mDonatableOrganUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testGetDonatableOrganID() {
        assertThat(mDonatableOrganUnderTest.getDonatableOrganID()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(mDonatableOrganUnderTest.toString()).isEqualTo("result");
    }
}
