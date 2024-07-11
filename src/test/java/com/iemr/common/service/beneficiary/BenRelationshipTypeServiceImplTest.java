package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.beneficiary.BenRelationshipType;
import com.iemr.common.repository.beneficiary.BeneficiaryRelationshipTypeRepository;

@ExtendWith(MockitoExtension.class)
class BenRelationshipTypeServiceImplTest {
    @InjectMocks
    private BenRelationshipTypeServiceImpl benRelationshipTypeServiceImpl;

    @Mock
    private BeneficiaryRelationshipTypeRepository beneficiaryRelationshipTypeRepository;

    

    @Test
    void testGetActiveRelationshipTypes() {
        when(beneficiaryRelationshipTypeRepository.getActiveRelationships()).thenReturn(new HashSet<>());

        List<BenRelationshipType> actualActiveRelationshipTypes = benRelationshipTypeServiceImpl
                .getActiveRelationshipTypes();

        verify(beneficiaryRelationshipTypeRepository).getActiveRelationships();
        assertTrue(actualActiveRelationshipTypes.isEmpty());
    }

    @Test
    void testGetActiveRelationshipTypes2() {
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(new Object[]{"42"});
        when(beneficiaryRelationshipTypeRepository.getActiveRelationships()).thenReturn(objectArraySet);

        List<BenRelationshipType> actualActiveRelationshipTypes = benRelationshipTypeServiceImpl
                .getActiveRelationshipTypes();

        verify(beneficiaryRelationshipTypeRepository).getActiveRelationships();
        assertTrue(actualActiveRelationshipTypes.isEmpty());
    }

    @Test
    void testGetActiveRelationshipTypes3() {
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(null);
        when(beneficiaryRelationshipTypeRepository.getActiveRelationships()).thenReturn(objectArraySet);

        List<BenRelationshipType> actualActiveRelationshipTypes = benRelationshipTypeServiceImpl
                .getActiveRelationshipTypes();

        verify(beneficiaryRelationshipTypeRepository).getActiveRelationships();
        assertTrue(actualActiveRelationshipTypes.isEmpty());
    }

    @Test
    void testGetActiveRelationshipTypes4() {
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(new Object[]{2, "42"});
        when(beneficiaryRelationshipTypeRepository.getActiveRelationships()).thenReturn(objectArraySet);

        List<BenRelationshipType> actualActiveRelationshipTypes = benRelationshipTypeServiceImpl
                .getActiveRelationshipTypes();

        verify(beneficiaryRelationshipTypeRepository).getActiveRelationships();
        assertEquals(1, actualActiveRelationshipTypes.size());
    }

    @Test
    void testGetActiveRelationshipTypes5() {
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(new Object[]{1, "42"});
        when(beneficiaryRelationshipTypeRepository.getActiveRelationships()).thenReturn(objectArraySet);

        List<BenRelationshipType> actualActiveRelationshipTypes = benRelationshipTypeServiceImpl
                .getActiveRelationshipTypes();

        verify(beneficiaryRelationshipTypeRepository).getActiveRelationships();
        assertEquals(1, actualActiveRelationshipTypes.size());
    }
}
