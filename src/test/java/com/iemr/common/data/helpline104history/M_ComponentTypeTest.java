package com.iemr.common.data.helpline104history;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class M_ComponentTypeTest {

	@InjectMocks
    private M_ComponentType mComponentTypeUnderTest;

    @BeforeEach
    void setUp() {
        mComponentTypeUnderTest = new M_ComponentType(0, "componentType", "componentTypeDesc");
    }

    @Test
    void testComponentTypeIDGetterAndSetter() {
        final Integer componentTypeID = 0;
        mComponentTypeUnderTest.setComponentTypeID(componentTypeID);
        assertThat(mComponentTypeUnderTest.getComponentTypeID()).isEqualTo(componentTypeID);
    }

    @Test
    void testComponentTypeGetterAndSetter() {
        final String componentType = "componentType";
        mComponentTypeUnderTest.setComponentType(componentType);
        assertThat(mComponentTypeUnderTest.getComponentType()).isEqualTo(componentType);
    }

    @Test
    void testComponentTypeDescGetterAndSetter() {
        final String componentTypeDesc = "componentTypeDesc";
        mComponentTypeUnderTest.setComponentTypeDesc(componentTypeDesc);
        assertThat(mComponentTypeUnderTest.getComponentTypeDesc()).isEqualTo(componentTypeDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        mComponentTypeUnderTest.setDeleted(deleted);
        assertThat(mComponentTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        mComponentTypeUnderTest.setCreatedBy(createdBy);
        assertThat(mComponentTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        mComponentTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(mComponentTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }
}
