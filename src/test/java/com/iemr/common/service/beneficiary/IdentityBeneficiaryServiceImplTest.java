package com.iemr.common.service.beneficiary;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.mockito.MockitoAnnotations;

import java.util.Set;

import com.iemr.common.repository.beneficiary.GovtIdentityTypeRepository;
import com.iemr.common.data.beneficiary.GovtIdentityType;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.is;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class IdentityBeneficiaryServiceImplTest {

    private final GovtIdentityTypeRepository govtIdentityTypeRepositoryMock = mock(GovtIdentityTypeRepository.class, "govtIdentityTypeRepository");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private GovtIdentityTypeServiceImpl target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //Sapient generated method id: ${ce34b8d3-199f-378c-90eb-9ed1aef6e53c}, hash: 774ACA351D3905999668C549FB1166BC
    @Test()
    void getActiveIDTypesWhenObjectLengthGreaterThanOrEqualsTo3() {
        /* Branches:* (for-each(resultSet)) : true* (object != null) : true* (object.length >= 3) : true*/
        //Arrange Statement(s)
        target = new GovtIdentityTypeServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Object[] objectArray = new Object[]{1, "A", false};
        Set<Object[]> objectSet = new HashSet<>();
        objectSet.add(objectArray);
        doReturn(objectSet).when(govtIdentityTypeRepositoryMock).getActiveIDTypes();

        //Act Statement(s)
        List<GovtIdentityType> result = target.getActiveIDTypes();

        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result.size(), equalTo(1));
            assertThat(result.get(0), is(instanceOf(GovtIdentityType.class)));
            verify(govtIdentityTypeRepositoryMock).getActiveIDTypes();
        });
    }
}
