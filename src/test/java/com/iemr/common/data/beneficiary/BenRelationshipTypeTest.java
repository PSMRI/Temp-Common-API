package com.iemr.common.data.beneficiary;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BenRelationshipTypeTest {

	@InjectMocks
	private BenRelationshipType benRelationshipTypeUnderTest;

	@BeforeEach
	void setUp() {
		benRelationshipTypeUnderTest = new BenRelationshipType(0, "benRelationshipType", false);
	}

	@Test
	void testBenRelationshipIDGetterAndSetter() {
		final Integer benRelationshipID = 0;
		benRelationshipTypeUnderTest.setBenRelationshipID(benRelationshipID);
		assertThat(benRelationshipTypeUnderTest.getBenRelationshipID()).isEqualTo(benRelationshipID);
	}

	@Test
	void testBenRelationshipTypeGetterAndSetter() {
		final String benRelationshipType = "benRelationshipType";
		benRelationshipTypeUnderTest.setBenRelationshipType(benRelationshipType);
		assertThat(benRelationshipTypeUnderTest.getBenRelationshipType()).isEqualTo(benRelationshipType);
	}

	@Test
	void testDeletedGetterAndSetter() {
		final Boolean deleted = false;
		benRelationshipTypeUnderTest.setDeleted(deleted);
		assertThat(benRelationshipTypeUnderTest.getDeleted()).isFalse();
	}

	@Test
	void testToString() {
		assertThat(benRelationshipTypeUnderTest.toString()).isEqualTo(
				"{\"benRelationshipID\":0,\"benPhoneMap\":null,\"benRelationshipType\":\"benRelationshipType\",\"deleted\":false,\"createdBy\":null}");
	}

	@Test
	void testBenPhoneMapGetterAndSetter() {
		final Set<BenPhoneMap> benPhoneMap = Set.of(new BenPhoneMap());
		benRelationshipTypeUnderTest.setBenPhoneMap(benPhoneMap);
		assertThat(benRelationshipTypeUnderTest.getBenPhoneMap()).isEqualTo(benPhoneMap);
	}

	@Test
	void testCreatedByGetterAndSetter() {
		final String createdBy = "createdBy";
		benRelationshipTypeUnderTest.setCreatedBy(createdBy);
		assertThat(benRelationshipTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void testCreatedDateGetterAndSetter() {
		final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		benRelationshipTypeUnderTest.setCreatedDate(createdDate);
		assertThat(benRelationshipTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
	}

	@Test
	void testModifiedByGetterAndSetter() {
		final String modifiedBy = "modifiedBy";
		benRelationshipTypeUnderTest.setModifiedBy(modifiedBy);
		assertThat(benRelationshipTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
	}

	@Test
	void testLastModDateGetterAndSetter() {
		final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
		benRelationshipTypeUnderTest.setLastModDate(lastModDate);
		assertThat(benRelationshipTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
	}

	@Test
	void testOutputMapperGetterAndSetter() {
		final OutputMapper outputMapper = new OutputMapper();
		benRelationshipTypeUnderTest.setOutputMapper(outputMapper);
		assertThat(benRelationshipTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
	}

	@Test
	void testEquals() {
		assertThat(benRelationshipTypeUnderTest.equals("o")).isFalse();
	}

	@Test
	void testCanEqual() {
		assertThat(benRelationshipTypeUnderTest.canEqual("other")).isFalse();
	}

	@Test
	void testHashCode() {
		assertThat(benRelationshipTypeUnderTest.hashCode()).isEqualTo(0);
	}
}
