package com.iemr.common.data.beneficiary;

import com.iemr.common.dto.identity.BenFamilyDTO;
import com.iemr.common.dto.identity.Phone;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BenPhoneMapTest {

	@Mock
	private BenRelationshipType mockBenRelationshipType;

	@InjectMocks
	private BenPhoneMap benPhoneMapUnderTest;

	@BeforeEach
	void setUp() {
		benPhoneMapUnderTest = new BenPhoneMap(0L, 0L, 0L, 0, "phoneNo", 0, false, mockBenRelationshipType, 0);
	}

	@Test
	void testBenPhMapIDGetterAndSetter() {
		final Long benPhMapID = 0L;
		benPhoneMapUnderTest.setBenPhMapID(benPhMapID);
		assertThat(benPhoneMapUnderTest.getBenPhMapID()).isEqualTo(benPhMapID);
	}

	@Test
	void testBenificiaryRegIDGetterAndSetter() {
		final Long benificiaryRegID = 0L;
		benPhoneMapUnderTest.setBenificiaryRegID(benificiaryRegID);
		assertThat(benPhoneMapUnderTest.getBenificiaryRegID()).isEqualTo(benificiaryRegID);
	}

	@Test
	void testBeneficiaryGetterAndSetter() {
		final Beneficiary beneficiary = new Beneficiary();
		benPhoneMapUnderTest.setBeneficiary(beneficiary);
		assertThat(benPhoneMapUnderTest.getBeneficiary()).isEqualTo(beneficiary);
	}

	@Test
	void testParentBenRegIDGetterAndSetter() {
		final Long parentBenRegID = 0L;
		benPhoneMapUnderTest.setParentBenRegID(parentBenRegID);
		assertThat(benPhoneMapUnderTest.getParentBenRegID()).isEqualTo(parentBenRegID);
	}

	@Test
	void testParentBeneficiaryGetterAndSetter() {
		final Beneficiary parentBeneficiary = new Beneficiary();
		benPhoneMapUnderTest.setParentBeneficiary(parentBeneficiary);
		assertThat(benPhoneMapUnderTest.getParentBeneficiary()).isEqualTo(parentBeneficiary);
	}

	@Test
	void testBenRelationshipIDGetterAndSetter() {
		final Integer benRelationshipID = 0;
		benPhoneMapUnderTest.setBenRelationshipID(benRelationshipID);
		assertThat(benPhoneMapUnderTest.getBenRelationshipID()).isEqualTo(benRelationshipID);
	}

	@Test
	void testBenRelationshipTypeGetterAndSetter() {
		final BenRelationshipType benRelationshipType = new BenRelationshipType(0, "benRelationshipType", false);
		benPhoneMapUnderTest.setBenRelationshipType(benRelationshipType);
		assertThat(benPhoneMapUnderTest.getBenRelationshipType()).isEqualTo(benRelationshipType);
	}

	@Test
	void testPhoneTypeIDGetterAndSetter() {
		final Integer phoneTypeID = 0;
		benPhoneMapUnderTest.setPhoneTypeID(phoneTypeID);
		assertThat(benPhoneMapUnderTest.getPhoneTypeID()).isEqualTo(phoneTypeID);
	}

	@Test
	void testPhoneTypeGetterAndSetter() {
		final PhoneType phoneType = new PhoneType();
		benPhoneMapUnderTest.setPhoneType(phoneType);
		assertThat(benPhoneMapUnderTest.getPhoneType()).isEqualTo(phoneType);
	}

	@Test
	void testDeletedGetterAndSetter() {
		final Boolean deleted = false;
		benPhoneMapUnderTest.setDeleted(deleted);
		assertThat(benPhoneMapUnderTest.getDeleted()).isFalse();
	}

	@Test
	void testCreatedByGetterAndSetter() {
		final String createdBy = "createdBy";
		benPhoneMapUnderTest.setCreatedBy(createdBy);
		assertThat(benPhoneMapUnderTest.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void testCreatedDateGetterAndSetter() {
		final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		benPhoneMapUnderTest.setCreatedDate(createdDate);
		assertThat(benPhoneMapUnderTest.getCreatedDate()).isEqualTo(createdDate);
	}

	@Test
	void testModifiedByGetterAndSetter() {
		final String modifiedBy = "modifiedBy";
		benPhoneMapUnderTest.setModifiedBy(modifiedBy);
		assertThat(benPhoneMapUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
	}

	@Test
	void testLastModDateGetterAndSetter() {
		final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		benPhoneMapUnderTest.setLastModDate(lastModDate);
		assertThat(benPhoneMapUnderTest.getLastModDate()).isEqualTo(lastModDate);
	}

	@Test
	void testOutputMapperGetterAndSetter() {
		final OutputMapper outputMapper = new OutputMapper();
		benPhoneMapUnderTest.setOutputMapper(outputMapper);
		assertThat(benPhoneMapUnderTest.getOutputMapper()).isEqualTo(outputMapper);
	}

	@Test
	void testPhoneNoGetterAndSetter() {
		final String phoneNo = "phoneNo";
		benPhoneMapUnderTest.setPhoneNo(phoneNo);
		assertThat(benPhoneMapUnderTest.getPhoneNo()).isEqualTo(phoneNo);
	}

	@Test
	void testToString() {
		String expectedJson = "{\"benPhMapID\":\"0\",\"benificiaryRegID\":\"0\",\"parentBenRegID\":\"0\",\"benRelationshipID\":0,\"benRelationshipName\":null,\"benRelationshipType\":{\"benRelationshipID\":0,\"benPhoneMap\":null,\"benRelationshipType\":null,\"deleted\":false,\"createdBy\":null},\"phoneNo\":\"phoneNo\",\"phoneTypeID\":0,\"phoneTypeName\":null,\"deleted\":false,\"createdBy\":null}";
		assertThat(benPhoneMapUnderTest.toString()).isEqualTo(expectedJson);

	}

	@Test
	void testNuisanceCallCountGetterAndSetter() {
		final Integer nuisanceCallCount = 0;
		benPhoneMapUnderTest.setNuisanceCallCount(nuisanceCallCount);
		assertThat(benPhoneMapUnderTest.getNuisanceCallCount()).isEqualTo(nuisanceCallCount);
	}

	@Test
	void testCreateBenPhoneMaps() {
		BenPhoneMap benPhoneMap = new BenPhoneMap();
		benPhoneMap.setBenificiaryRegID(0L);
		benPhoneMap.setParentBenRegID(0L);
		benPhoneMap.setDeleted(false);
		benPhoneMap.setNuisanceCallCount(0);
		benPhoneMap.setBenPhMapID(0L);
		Beneficiary beneficiary = new Beneficiary();
		benPhoneMap.setBeneficiary(beneficiary);
		Beneficiary parentBeneficiary = new Beneficiary();
		benPhoneMap.setParentBeneficiary(parentBeneficiary);
		benPhoneMap.setBenRelationshipID(0);
		benPhoneMap.setPhoneNo("phoneNo");
		benPhoneMap.setPhoneTypeID(0);
		PhoneType phoneType = new PhoneType();
		benPhoneMap.setPhoneType(phoneType);
		benPhoneMap.setCreatedBy("createdBy");
		benPhoneMap.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
		benPhoneMap.setModifiedBy("modifiedBy");
		benPhoneMap.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
		benPhoneMap.setIs1097(false);
		OutputMapper outputMapper = new OutputMapper();
		benPhoneMap.setOutputMapper(outputMapper);
		List<BenPhoneMap> expectedResult = List.of(benPhoneMap);
		// Verify the results
		assertThat(benPhoneMap).isEqualTo(expectedResult.get(0));
	}

	@Test
	void testBenRelationshipNameGetterAndSetter() {
		final String benRelationshipName = "benRelationshipName";
		benPhoneMapUnderTest.setBenRelationshipName(benRelationshipName);
		assertThat(benPhoneMapUnderTest.getBenRelationshipName()).isEqualTo(benRelationshipName);
	}

	@Test
	void testPhoneTypeNameGetterAndSetter() {
		final String phoneTypeName = "phoneTypeName";
		benPhoneMapUnderTest.setPhoneTypeName(phoneTypeName);
		assertThat(benPhoneMapUnderTest.getPhoneTypeName()).isEqualTo(phoneTypeName);
	}

	@Test
	void testIs1097GetterAndSetter() {
		final Boolean is1097 = false;
		benPhoneMapUnderTest.setIs1097(is1097);
		assertThat(benPhoneMapUnderTest.getIs1097()).isFalse();
	}

	@Test
	void testEquals() {
		assertThat(benPhoneMapUnderTest.equals("o")).isFalse();
	}

	@Test
	void testCanEqual() {
		assertThat(benPhoneMapUnderTest.canEqual("other")).isFalse();
	}

	@Test
	void testHashCode() {
		assertThat(benPhoneMapUnderTest.hashCode()).isEqualTo(0);
	}
}
