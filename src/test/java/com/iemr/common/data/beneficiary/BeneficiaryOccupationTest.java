package com.iemr.common.data.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.annotations.Expose;
import com.iemr.common.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@ExtendWith(MockitoExtension.class)
class BeneficiaryOccupationTest {

	@Test
    public void testConstructorAndGettersAndSetters() {
        BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();

        beneficiaryOccupation.setOccupationID(1L);
        beneficiaryOccupation.setOccupationType("Test Occupation Type");

        assertEquals(1L, beneficiaryOccupation.getOccupationID());
        assertEquals("Test Occupation Type", beneficiaryOccupation.getOccupationType());

        beneficiaryOccupation.setOccupationType("Updated Occupation Type");
        assertEquals("Updated Occupation Type", beneficiaryOccupation.getOccupationType());
    }

    @Test
    public void testGetOccupation() {
        BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
        BeneficiaryOccupation result1 = beneficiaryOccupation.getOccupation(1L, "Test Occupation Type");
        BeneficiaryOccupation result2 = beneficiaryOccupation.getOccupation(1L, "Test Occupation Type", null, null, null);

        assertEquals(1L, result1.getOccupationID());
        assertEquals("Test Occupation Type", result1.getOccupationType());

        assertEquals(1L, result2.getOccupationID());
        assertEquals("Test Occupation Type", result2.getOccupationType());
        assertEquals(null, result2.getDeleted());
        assertEquals(null, result2.getCreatedBy());
    }

    @Test
    public void testToString() {
        BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
        beneficiaryOccupation.setOccupationID(1L);
        beneficiaryOccupation.setOccupationType("Test Occupation Type");
        beneficiaryOccupation.setDeleted(null);
        beneficiaryOccupation.setCreatedBy(null);
        String expectedJson = "{\"occupationID\":\"1\",\"occupationType\":\"Test Occupation Type\",\"deleted\":null,\"createdby\":null}";

        assertEquals(expectedJson, beneficiaryOccupation.toString());
    }

    @Test
    public void testGettersAndSettersForTransientFields() {
        BeneficiaryOccupation beneficiaryOccupation = new BeneficiaryOccupation();
        Set<BenDemographics> benDemographicsSet = new HashSet<>();
        beneficiaryOccupation.setI_BenDemographics(benDemographicsSet);
        OutputMapper outputMapper = new OutputMapper();
        beneficiaryOccupation.setOutputMapper(outputMapper);

        assertSame(benDemographicsSet, beneficiaryOccupation.getI_BenDemographics());
        assertSame(outputMapper, beneficiaryOccupation.getOutputMapper());
    }
    
    @Test
    public void testFieldsAndAnnotations() throws NoSuchFieldException {
        Field occupationIDField = BeneficiaryOccupation.class.getDeclaredField("occupationID");
        Id idAnnotation = occupationIDField.getAnnotation(Id.class);
        assertNotNull(idAnnotation);
        assertTrue(occupationIDField.isAnnotationPresent(GeneratedValue.class));
        GeneratedValue generatedValueAnnotation = occupationIDField.getAnnotation(GeneratedValue.class);
        assertEquals(GenerationType.IDENTITY, generatedValueAnnotation.strategy());
        assertTrue(occupationIDField.isAnnotationPresent(Column.class));
        Column columnAnnotation = occupationIDField.getAnnotation(Column.class);
        assertEquals("OccupationID", columnAnnotation.name());
        assertTrue(occupationIDField.isAnnotationPresent(Expose.class));
        assertEquals(Long.class, occupationIDField.getType());

        Field i_BenDemographicsField = BeneficiaryOccupation.class.getDeclaredField("i_BenDemographics");
        assertTrue(i_BenDemographicsField.isAnnotationPresent(Transient.class));
        assertEquals(Set.class, i_BenDemographicsField.getType());

        Field occupationTypeField = BeneficiaryOccupation.class.getDeclaredField("occupationType");
        assertTrue(occupationTypeField.isAnnotationPresent(Column.class));
        columnAnnotation = occupationTypeField.getAnnotation(Column.class);
        assertEquals("OccupationType", columnAnnotation.name());
        assertTrue(occupationTypeField.isAnnotationPresent(Expose.class));
        assertEquals(String.class, occupationTypeField.getType());

        Field deletedField = BeneficiaryOccupation.class.getDeclaredField("deleted");
        assertTrue(deletedField.isAnnotationPresent(Column.class));
        columnAnnotation = deletedField.getAnnotation(Column.class);
        assertEquals("Deleted", columnAnnotation.name());
        assertFalse(columnAnnotation.insertable());
        assertTrue(columnAnnotation.updatable());
        assertTrue(deletedField.isAnnotationPresent(Expose.class));
        assertEquals(Boolean.class, deletedField.getType());

        Field createdbyField = BeneficiaryOccupation.class.getDeclaredField("createdby");
        assertTrue(createdbyField.isAnnotationPresent(Column.class));
        columnAnnotation = createdbyField.getAnnotation(Column.class);
        assertEquals("CreatedBy", columnAnnotation.name());
        assertTrue(createdbyField.isAnnotationPresent(Expose.class));
        assertEquals(String.class, createdbyField.getType());

        Field modifiedbyField = BeneficiaryOccupation.class.getDeclaredField("modifiedby");
        assertTrue(modifiedbyField.isAnnotationPresent(Column.class));
        columnAnnotation = modifiedbyField.getAnnotation(Column.class);
        assertEquals("ModifiedBy", columnAnnotation.name());
        assertEquals(String.class, modifiedbyField.getType());
    }

}
