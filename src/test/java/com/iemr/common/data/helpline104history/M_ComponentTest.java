package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_ComponentTest {

	@InjectMocks
    private M_Component mComponentUnderTest;

    @BeforeEach
    void setUp() {
        mComponentUnderTest = new M_Component(0, "component", "componentDesc");
    }

    @Test
    void testComponentIDGetterAndSetter() {
        final Integer componentID = 0;
        mComponentUnderTest.setComponentID(componentID);
        assertThat(mComponentUnderTest.getComponentID()).isEqualTo(componentID);
    }

    @Test
    void testComponentGetterAndSetter() {
        final String component = "component";
        mComponentUnderTest.setComponent(component);
        assertThat(mComponentUnderTest.getComponent()).isEqualTo(component);
    }

    @Test
    void testComponentDescGetterAndSetter() {
        final String componentDesc = "componentDesc";
        mComponentUnderTest.setComponentDesc(componentDesc);
        assertThat(mComponentUnderTest.getComponentDesc()).isEqualTo(componentDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mComponentUnderTest.setDeleted(deleted);
        assertThat(mComponentUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mComponentUnderTest.setCreatedBy(createdBy);
        assertThat(mComponentUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mComponentUnderTest.setModifiedBy(modifiedBy);
        assertThat(mComponentUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testToString() {
        assertThat(mComponentUnderTest.toString()).isEqualTo("result");
    }
}
