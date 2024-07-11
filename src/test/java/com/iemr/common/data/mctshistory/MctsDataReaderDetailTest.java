package com.iemr.common.data.mctshistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MctsDataReaderDetailTest {

	@InjectMocks
    private MctsDataReaderDetail mctsDataReaderDetailUnderTest;

    @BeforeEach
    void setUp() {
        mctsDataReaderDetailUnderTest = new MctsDataReaderDetail();
    }

    @Test
    void testMotherValidRecordIDGetterAndSetter() {
        final Long motherValidRecordID = 0L;
        mctsDataReaderDetailUnderTest.setMotherValidRecordID(motherValidRecordID);
        assertThat(mctsDataReaderDetailUnderTest.getMotherValidRecordID()).isEqualTo(motherValidRecordID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        mctsDataReaderDetailUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(mctsDataReaderDetailUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testMCTSID_noGetterAndSetter() {
        final Long mCTSID_no = 0L;
        mctsDataReaderDetailUnderTest.setMCTSID_no(mCTSID_no);
        assertThat(mctsDataReaderDetailUnderTest.getMCTSID_no()).isEqualTo(mCTSID_no);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "Name";
        mctsDataReaderDetailUnderTest.setName(name);
        assertThat(mctsDataReaderDetailUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testHusband_NameGetterAndSetter() {
        final String husband_Name = "Husband_Name";
        mctsDataReaderDetailUnderTest.setHusband_Name(husband_Name);
        assertThat(mctsDataReaderDetailUnderTest.getHusband_Name()).isEqualTo(husband_Name);
    }

    @Test
    void testWhom_PhoneNoGetterAndSetter() {
        final String whom_PhoneNo = "Whom_PhoneNo";
        mctsDataReaderDetailUnderTest.setWhom_PhoneNo(whom_PhoneNo);
        assertThat(mctsDataReaderDetailUnderTest.getWhom_PhoneNo()).isEqualTo(whom_PhoneNo);
    }

    @Test
    void testBirth_DateGetterAndSetter() {
        final Date birth_Date = Date.valueOf(LocalDate.of(2020, 1, 1));
        mctsDataReaderDetailUnderTest.setBirth_Date(birth_Date);
        assertThat(mctsDataReaderDetailUnderTest.getBirth_Date()).isEqualTo(birth_Date);
    }

    @Test
    void testAgeGetterAndSetter() {
        final Integer age = 0;
        mctsDataReaderDetailUnderTest.setAge(age);
        assertThat(mctsDataReaderDetailUnderTest.getAge()).isEqualTo(age);
    }

    @Test
    void testCasteGetterAndSetter() {
        final String caste = "Caste";
        mctsDataReaderDetailUnderTest.setCaste(caste);
        assertThat(mctsDataReaderDetailUnderTest.getCaste()).isEqualTo(caste);
    }

    @Test
    void testState_IDGetterAndSetter() {
        final Long state_ID = 0L;
        mctsDataReaderDetailUnderTest.setState_ID(state_ID);
        assertThat(mctsDataReaderDetailUnderTest.getState_ID()).isEqualTo(state_ID);
    }

    @Test
    void testState_NameGetterAndSetter() {
        final String state_Name = "State_Name";
        mctsDataReaderDetailUnderTest.setState_Name(state_Name);
        assertThat(mctsDataReaderDetailUnderTest.getState_Name()).isEqualTo(state_Name);
    }

    @Test
    void testDistrict_IDGetterAndSetter() {
        final Long district_ID = 0L;
        mctsDataReaderDetailUnderTest.setDistrict_ID(district_ID);
        assertThat(mctsDataReaderDetailUnderTest.getDistrict_ID()).isEqualTo(district_ID);
    }

    @Test
    void testDistrict_NameGetterAndSetter() {
        final String district_Name = "District_Name";
        mctsDataReaderDetailUnderTest.setDistrict_Name(district_Name);
        assertThat(mctsDataReaderDetailUnderTest.getDistrict_Name()).isEqualTo(district_Name);
    }

    @Test
    void testTaluka_NameGetterAndSetter() {
        final String taluka_Name = "Taluka_Name";
        mctsDataReaderDetailUnderTest.setTaluka_Name(taluka_Name);
        assertThat(mctsDataReaderDetailUnderTest.getTaluka_Name()).isEqualTo(taluka_Name);
    }

    @Test
    void testTaluka_IDGetterAndSetter() {
        final Long taluka_ID = 0L;
        mctsDataReaderDetailUnderTest.setTaluka_ID(taluka_ID);
        assertThat(mctsDataReaderDetailUnderTest.getTaluka_ID()).isEqualTo(taluka_ID);
    }

    @Test
    void testBlock_IDGetterAndSetter() {
        final Long block_ID = 0L;
        mctsDataReaderDetailUnderTest.setBlock_ID(block_ID);
        assertThat(mctsDataReaderDetailUnderTest.getBlock_ID()).isEqualTo(block_ID);
    }

    @Test
    void testBlock_NameGetterAndSetter() {
        final String block_Name = "Block_Name";
        mctsDataReaderDetailUnderTest.setBlock_Name(block_Name);
        assertThat(mctsDataReaderDetailUnderTest.getBlock_Name()).isEqualTo(block_Name);
    }

    @Test
    void testSubCenter_IDGetterAndSetter() {
        final Long subCenter_ID = 0L;
        mctsDataReaderDetailUnderTest.setSubCenter_ID(subCenter_ID);
        assertThat(mctsDataReaderDetailUnderTest.getSubCenter_ID()).isEqualTo(subCenter_ID);
    }

    @Test
    void testSubCenter_NameGetterAndSetter() {
        final String subCenter_Name = "SubCenter_Name";
        mctsDataReaderDetailUnderTest.setSubCenter_Name(subCenter_Name);
        assertThat(mctsDataReaderDetailUnderTest.getSubCenter_Name()).isEqualTo(subCenter_Name);
    }

    @Test
    void testVillage_IDGetterAndSetter() {
        final Long village_ID = 0L;
        mctsDataReaderDetailUnderTest.setVillage_ID(village_ID);
        assertThat(mctsDataReaderDetailUnderTest.getVillage_ID()).isEqualTo(village_ID);
    }

    @Test
    void testVillage_NameGetterAndSetter() {
        final String village_Name = "Village_Name";
        mctsDataReaderDetailUnderTest.setVillage_Name(village_Name);
        assertThat(mctsDataReaderDetailUnderTest.getVillage_Name()).isEqualTo(village_Name);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "ModifiedBy";
        mctsDataReaderDetailUnderTest.setModifiedBy(modifiedBy);
        assertThat(mctsDataReaderDetailUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        mctsDataReaderDetailUnderTest.setLastModDate(lastModDate);
        assertThat(mctsDataReaderDetailUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testLMP_DateGetterAndSetter() {
        final Date lMP_Date = Date.valueOf(LocalDate.of(2020, 1, 1));
        mctsDataReaderDetailUnderTest.setLMP_Date(lMP_Date);
        assertThat(mctsDataReaderDetailUnderTest.getLMP_Date()).isEqualTo(lMP_Date);
    }

    @Test
    void testEquals() {
        assertThat(mctsDataReaderDetailUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(mctsDataReaderDetailUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(mctsDataReaderDetailUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(mctsDataReaderDetailUnderTest.toString()).isEqualTo("result");
    }
}
