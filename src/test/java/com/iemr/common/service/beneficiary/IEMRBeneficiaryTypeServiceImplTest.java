package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.data.beneficiary.BeneficiaryType;
import com.iemr.common.repository.beneficiary.IEMRBeneficiaryTypeRepository;
import com.iemr.common.utils.mapper.OutputMapper;

@ExtendWith(MockitoExtension.class)
class IEMRBeneficiaryTypeServiceImplTest {
    @Mock
    private IEMRBeneficiaryTypeRepository iEMRBeneficiaryTypeRepository;

    @InjectMocks
    private IEMRBeneficiaryTypeServiceImpl iEMRBeneficiaryTypeServiceImpl;

    @Test
    void testAddRelation() {
        BeneficiaryType beneficiaryType = new BeneficiaryType();
        beneficiaryType.setBeneficiaryType("Beneficiary Type");
        beneficiaryType.setBeneficiaryTypeID((short) 1);
        beneficiaryType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        beneficiaryType.setCreatedDate(mock(Timestamp.class));
        beneficiaryType.setDeleted(true);
        beneficiaryType.setLastModDate(mock(Timestamp.class));
        beneficiaryType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        beneficiaryType.setOutputMapper(new OutputMapper());
        when(iEMRBeneficiaryTypeRepository.save(Mockito.<BeneficiaryType>any())).thenReturn(beneficiaryType);

        BeneficiaryType i_beneficiaryType = new BeneficiaryType();
        i_beneficiaryType.setBeneficiaryType("Beneficiary Type");
        i_beneficiaryType.setBeneficiaryTypeID((short) 1);
        i_beneficiaryType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        i_beneficiaryType.setCreatedDate(mock(Timestamp.class));
        i_beneficiaryType.setDeleted(true);
        i_beneficiaryType.setLastModDate(mock(Timestamp.class));
        i_beneficiaryType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        i_beneficiaryType.setOutputMapper(new OutputMapper());

        BeneficiaryType actualAddRelationResult = iEMRBeneficiaryTypeServiceImpl.addRelation(i_beneficiaryType);

        verify(iEMRBeneficiaryTypeRepository).save(Mockito.<BeneficiaryType>any());
        assertSame(beneficiaryType, actualAddRelationResult);
    }

    @Test
    void testGetRelations() {
        ArrayList<BeneficiaryType> beneficiaryTypeList = new ArrayList<>();
        when(iEMRBeneficiaryTypeRepository.findAll()).thenReturn(beneficiaryTypeList);

        Iterable<BeneficiaryType> actualRelations = iEMRBeneficiaryTypeServiceImpl.getRelations();

        verify(iEMRBeneficiaryTypeRepository).findAll();
        assertTrue(((List<BeneficiaryType>) actualRelations).isEmpty());
        assertSame(beneficiaryTypeList, actualRelations);
    }
}
