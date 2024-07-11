package com.iemr.common.service.beneficiary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.data.beneficiary.GovtIdentityType;
import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;

@ExtendWith(MockitoExtension.class)
class GovtIdentityTypeServiceImplTest {
    @Mock
    private GovtIdentityTypeRepository govtIdentityTypeRepository;

    @InjectMocks
    private GovtIdentityTypeServiceImpl govtIdentityTypeServiceImpl;


    @Test
    void testGetActiveIDTypes()  {
			Object[] data1 = new Object[] { 1, "Passport", true };
			Object[] data2 = new Object[] { 2, "Driver's License", true };
			HashSet<Object[]> objectArraySet = new HashSet<>();
			objectArraySet.add(data1);
			objectArraySet.add(data2);

			when(govtIdentityTypeRepository.getActiveIDTypes()).thenReturn(objectArraySet);
			List<GovtIdentityType> actualActiveIDTypes = govtIdentityTypeServiceImpl.getActiveIDTypes();
			verify(govtIdentityTypeRepository).getActiveIDTypes();
			assertEquals(2, actualActiveIDTypes.size());
	    }
    
    @Test
    void testGetActiveIDTypes2() {
			HashSet<Object[]> objectArraySet = new HashSet<>();
			when(govtIdentityTypeRepository.getActiveIDTypes()).thenReturn(objectArraySet);
			List<GovtIdentityType> actualActiveIDTypes = govtIdentityTypeServiceImpl.getActiveIDTypes();
			verify(govtIdentityTypeRepository).getActiveIDTypes();
			assertTrue(actualActiveIDTypes.isEmpty());
	    }

    @Test
    void testGetActiveIDTypes3() {
		HashSet<Object[]> objectArraySet = new HashSet<>();
		objectArraySet.add(null);
		when(govtIdentityTypeRepository.getActiveIDTypes()).thenReturn(objectArraySet);
		List<GovtIdentityType> actualActiveIDTypes = govtIdentityTypeServiceImpl.getActiveIDTypes();
		verify(govtIdentityTypeRepository).getActiveIDTypes();
		assertTrue(actualActiveIDTypes.isEmpty());
    }
}
