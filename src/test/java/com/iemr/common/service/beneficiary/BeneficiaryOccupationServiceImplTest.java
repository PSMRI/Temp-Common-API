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
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.beneficiary.BeneficiaryOccupation;
import com.iemr.common.repository.beneficiary.BeneficiaryOccupationRepository;

@ExtendWith(MockitoExtension.class)
class BeneficiaryOccupationServiceImplTest {
    @Mock
    private BeneficiaryOccupationRepository beneficiaryOccupationRepository;

    @InjectMocks
    private BeneficiaryOccupationServiceImpl beneficiaryOccupationServiceImpl;

    

  
    @Test
    void testGetActiveOccupations() {
        // Arrange
        when(beneficiaryOccupationRepository.getActiveOccupations()).thenReturn(new HashSet<>());

        // Act
        List<BeneficiaryOccupation> actualActiveOccupations = beneficiaryOccupationServiceImpl.getActiveOccupations();

        // Assert
        verify(beneficiaryOccupationRepository).getActiveOccupations();
        assertTrue(actualActiveOccupations.isEmpty());
    }

    
    @Test
    void testGetActiveOccupations2() {
        // Arrange
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(new Object[]{"42"});
        when(beneficiaryOccupationRepository.getActiveOccupations()).thenReturn(objectArraySet);

        // Act
        List<BeneficiaryOccupation> actualActiveOccupations = beneficiaryOccupationServiceImpl.getActiveOccupations();

        // Assert
        verify(beneficiaryOccupationRepository).getActiveOccupations();
        assertTrue(actualActiveOccupations.isEmpty());
    }

    
    @Test
    void testGetActiveOccupations3() {
        // Arrange
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(null);
        when(beneficiaryOccupationRepository.getActiveOccupations()).thenReturn(objectArraySet);

        // Act
        List<BeneficiaryOccupation> actualActiveOccupations = beneficiaryOccupationServiceImpl.getActiveOccupations();

        // Assert
        verify(beneficiaryOccupationRepository).getActiveOccupations();
        assertTrue(actualActiveOccupations.isEmpty());
    }

   
    @Test
    void testGetActiveOccupations4() {
        // Arrange
        HashSet<Object[]> objectArraySet = new HashSet<>();
        objectArraySet.add(new Object[]{1L, "42"});
        when(beneficiaryOccupationRepository.getActiveOccupations()).thenReturn(objectArraySet);

        // Act
        List<BeneficiaryOccupation> actualActiveOccupations = beneficiaryOccupationServiceImpl.getActiveOccupations();

        // Assert
        verify(beneficiaryOccupationRepository).getActiveOccupations();
        assertEquals(1, actualActiveOccupations.size());
    }
}
