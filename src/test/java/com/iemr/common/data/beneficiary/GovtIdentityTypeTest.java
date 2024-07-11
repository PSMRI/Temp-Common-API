package com.iemr.common.data.beneficiary;

import com.iemr.common.utils.mapper.OutputMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GovtIdentityTypeTest {

	@InjectMocks
	private GovtIdentityType govtIdentityTypeUnderTest;

	@BeforeEach
	void setUp() {
		govtIdentityTypeUnderTest = new GovtIdentityType();
	}

	@Test
	void testGetDefaultConstructor() {
		GovtIdentityType expectedResult = new GovtIdentityType();
		GovtIdentityType result = govtIdentityTypeUnderTest.getDefaultConstructor();
		assertThat(result).isNotSameAs(expectedResult).isEqualToComparingFieldByFieldRecursively(expectedResult);
	}

	@Test
	void testGetConstructor() {
		GovtIdentityType expectedResult = new GovtIdentityType();
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setFirstName("John");
		OutputMapper outputMapper = new OutputMapper();
		expectedResult.setGovtIdentityTypeID(0);
		expectedResult.setI_Beneficiaries(List.of(beneficiary));
		expectedResult.setIdentityType("identityType");
		expectedResult.setIsGovtID(false);
		expectedResult.setOutputMapper(outputMapper);
		GovtIdentityType result = govtIdentityTypeUnderTest.getConstructor(0, "identityType", false);
		assertThat(result).isNotSameAs(expectedResult).isEqualToComparingFieldByFieldRecursively(expectedResult);
	}

	@Test
	void testToString() throws Exception {
		assertThat(govtIdentityTypeUnderTest.toString()).isEqualTo(
				"{\"govtIdentityTypeID\":null,\"identityType\":null,\"isGovtID\":null,\"deleted\":null,\"createdBy\":null}");
	}

	@Test
	void testGovtIdentityTypeIDGetterAndSetter() {
		final Integer govtIdentityTypeID = 0;
		govtIdentityTypeUnderTest.setGovtIdentityTypeID(govtIdentityTypeID);
		assertThat(govtIdentityTypeUnderTest.getGovtIdentityTypeID()).isEqualTo(govtIdentityTypeID);
	}

	@Test
	void testI_BeneficiariesGetterAndSetter() {
		final List<Beneficiary> i_Beneficiaries = List.of(new Beneficiary());
		govtIdentityTypeUnderTest.setI_Beneficiaries(i_Beneficiaries);
		assertThat(govtIdentityTypeUnderTest.getI_Beneficiaries()).isEqualTo(i_Beneficiaries);
	}

	@Test
	void testIdentityTypeGetterAndSetter() {
		final String identityType = "identityType";
		govtIdentityTypeUnderTest.setIdentityType(identityType);
		assertThat(govtIdentityTypeUnderTest.getIdentityType()).isEqualTo(identityType);
	}

	@Test
	void testIsGovtIDGetterAndSetter() {
		final Boolean isGovtID = false;
		govtIdentityTypeUnderTest.setIsGovtID(isGovtID);
		assertThat(govtIdentityTypeUnderTest.getIsGovtID()).isFalse();
	}

	@Test
	void testDeletedGetterAndSetter() {
		final Boolean deleted = false;
		govtIdentityTypeUnderTest.setDeleted(deleted);
		assertThat(govtIdentityTypeUnderTest.getDeleted()).isFalse();
	}

	@Test
	void testCreatedByGetterAndSetter() {
		final String createdBy = "createdBy";
		govtIdentityTypeUnderTest.setCreatedBy(createdBy);
		assertThat(govtIdentityTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void testCreatedDateGetterAndSetter() {
		final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		govtIdentityTypeUnderTest.setCreatedDate(createdDate);
		assertThat(govtIdentityTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
	}

	@Test
	void testModifiedByGetterAndSetter() {
		final String modifiedBy = "modifiedBy";
		govtIdentityTypeUnderTest.setModifiedBy(modifiedBy);
		assertThat(govtIdentityTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
	}

	@Test
	void testLastModDateGetterAndSetter() {
		final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		govtIdentityTypeUnderTest.setLastModDate(lastModDate);
		assertThat(govtIdentityTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
	}

	@Test
	void testIdentityNameIdGetterAndSetter() {
		final Integer identityNameId = 0;
		govtIdentityTypeUnderTest.setIdentityNameId(identityNameId);
		assertThat(govtIdentityTypeUnderTest.getIdentityNameId()).isEqualTo(identityNameId);
	}

	@Test
	void testOutputMapperGetterAndSetter() {
		final OutputMapper outputMapper = new OutputMapper();
		govtIdentityTypeUnderTest.setOutputMapper(outputMapper);
		assertThat(govtIdentityTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
	}

	@Test
	void testEquals() {
		assertThat(govtIdentityTypeUnderTest.equals("o")).isFalse();
	}

	@Test
	void testCanEqual() {
		assertThat(govtIdentityTypeUnderTest.canEqual("other")).isFalse();
	}

	@Test
	void testHashCode() {
		assertThat(govtIdentityTypeUnderTest.hashCode()).isEqualTo(0);
	}
}
