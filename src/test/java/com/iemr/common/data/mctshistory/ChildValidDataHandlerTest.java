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
class ChildValidDataHandlerTest {

	@InjectMocks
    private ChildValidDataHandler childValidDataHandlerUnderTest;

    @BeforeEach
    void setUp() {
        childValidDataHandlerUnderTest = new ChildValidDataHandler();
    }

    @Test
    void testRowIDGetterAndSetter() {
        final Long rowID = 0L;
        childValidDataHandlerUnderTest.setRowID(rowID);
        assertThat(childValidDataHandlerUnderTest.getRowID()).isEqualTo(rowID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        childValidDataHandlerUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(childValidDataHandlerUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testMCTSID_no_Child_IDGetterAndSetter() {
        final Long mCTSID_no_Child_ID = 0L;
        childValidDataHandlerUnderTest.setMCTSID_no_Child_ID(mCTSID_no_Child_ID);
        assertThat(childValidDataHandlerUnderTest.getMCTSID_no_Child_ID()).isEqualTo(mCTSID_no_Child_ID);
    }

    @Test
    void testChild_NameGetterAndSetter() {
        final String child_Name = "Child_Name";
        childValidDataHandlerUnderTest.setChild_Name(child_Name);
        assertThat(childValidDataHandlerUnderTest.getChild_Name()).isEqualTo(child_Name);
    }

    @Test
    void testFather_NameGetterAndSetter() {
        final String father_Name = "Father_Name";
        childValidDataHandlerUnderTest.setFather_Name(father_Name);
        assertThat(childValidDataHandlerUnderTest.getFather_Name()).isEqualTo(father_Name);
    }

    @Test
    void testMother_NameGetterAndSetter() {
        final String mother_Name = "Mother_Name";
        childValidDataHandlerUnderTest.setMother_Name(mother_Name);
        assertThat(childValidDataHandlerUnderTest.getMother_Name()).isEqualTo(mother_Name);
    }

    @Test
    void testMother_IDGetterAndSetter() {
        final Long mother_ID = 0L;
        childValidDataHandlerUnderTest.setMother_ID(mother_ID);
        assertThat(childValidDataHandlerUnderTest.getMother_ID()).isEqualTo(mother_ID);
    }

    @Test
    void testDOBGetterAndSetter() {
        final Date dOB = Date.valueOf(LocalDate.of(2020, 1, 1));
        childValidDataHandlerUnderTest.setDOB(dOB);
        assertThat(childValidDataHandlerUnderTest.getDOB()).isEqualTo(dOB);
    }

    @Test
    void testGenderGetterAndSetter() {
        final String gender = "Gender";
        childValidDataHandlerUnderTest.setGender(gender);
        assertThat(childValidDataHandlerUnderTest.getGender()).isEqualTo(gender);
    }

    @Test
    void testCasteGetterAndSetter() {
        final String caste = "Caste";
        childValidDataHandlerUnderTest.setCaste(caste);
        assertThat(childValidDataHandlerUnderTest.getCaste()).isEqualTo(caste);
    }

    @Test
    void testPhone_NoGetterAndSetter() {
        final String phone_No = "Phone_No";
        childValidDataHandlerUnderTest.setPhone_No(phone_No);
        assertThat(childValidDataHandlerUnderTest.getPhone_No()).isEqualTo(phone_No);
    }

    @Test
    void testState_IDGetterAndSetter() {
        final Long state_ID = 0L;
        childValidDataHandlerUnderTest.setState_ID(state_ID);
        assertThat(childValidDataHandlerUnderTest.getState_ID()).isEqualTo(state_ID);
    }

    @Test
    void testState_NameGetterAndSetter() {
        final String state_Name = "State_Name";
        childValidDataHandlerUnderTest.setState_Name(state_Name);
        assertThat(childValidDataHandlerUnderTest.getState_Name()).isEqualTo(state_Name);
    }

    @Test
    void testDistrict_IDGetterAndSetter() {
        final Long district_ID = 0L;
        childValidDataHandlerUnderTest.setDistrict_ID(district_ID);
        assertThat(childValidDataHandlerUnderTest.getDistrict_ID()).isEqualTo(district_ID);
    }

    @Test
    void testDistrict_NameGetterAndSetter() {
        final String district_Name = "District_Name";
        childValidDataHandlerUnderTest.setDistrict_Name(district_Name);
        assertThat(childValidDataHandlerUnderTest.getDistrict_Name()).isEqualTo(district_Name);
    }

    @Test
    void testTaluka_NameGetterAndSetter() {
        final String taluka_Name = "Taluka_Name";
        childValidDataHandlerUnderTest.setTaluka_Name(taluka_Name);
        assertThat(childValidDataHandlerUnderTest.getTaluka_Name()).isEqualTo(taluka_Name);
    }

    @Test
    void testTaluka_IDGetterAndSetter() {
        final Long taluka_ID = 0L;
        childValidDataHandlerUnderTest.setTaluka_ID(taluka_ID);
        assertThat(childValidDataHandlerUnderTest.getTaluka_ID()).isEqualTo(taluka_ID);
    }

    @Test
    void testBlock_IDGetterAndSetter() {
        final Long block_ID = 0L;
        childValidDataHandlerUnderTest.setBlock_ID(block_ID);
        assertThat(childValidDataHandlerUnderTest.getBlock_ID()).isEqualTo(block_ID);
    }

    @Test
    void testBlock_NameGetterAndSetter() {
        final String block_Name = "Block_Name";
        childValidDataHandlerUnderTest.setBlock_Name(block_Name);
        assertThat(childValidDataHandlerUnderTest.getBlock_Name()).isEqualTo(block_Name);
    }

    @Test
    void testVillage_IDGetterAndSetter() {
        final Long village_ID = 0L;
        childValidDataHandlerUnderTest.setVillage_ID(village_ID);
        assertThat(childValidDataHandlerUnderTest.getVillage_ID()).isEqualTo(village_ID);
    }

    @Test
    void testVillage_NameGetterAndSetter() {
        final String village_Name = "Village_Name";
        childValidDataHandlerUnderTest.setVillage_Name(village_Name);
        assertThat(childValidDataHandlerUnderTest.getVillage_Name()).isEqualTo(village_Name);
    }

    @Test
    void testGP_VillageGetterAndSetter() {
        final String gP_Village = "GP_Village";
        childValidDataHandlerUnderTest.setGP_Village(gP_Village);
        assertThat(childValidDataHandlerUnderTest.getGP_Village()).isEqualTo(gP_Village);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "Address";
        childValidDataHandlerUnderTest.setAddress(address);
        assertThat(childValidDataHandlerUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testCreated_ByGetterAndSetter() {
        final String created_By = "Created_By";
        childValidDataHandlerUnderTest.setCreated_By(created_By);
        assertThat(childValidDataHandlerUnderTest.getCreated_By()).isEqualTo(created_By);
    }

    @Test
    void testUpdated_ByGetterAndSetter() {
        final String updated_By = "Updated_By";
        childValidDataHandlerUnderTest.setUpdated_By(updated_By);
        assertThat(childValidDataHandlerUnderTest.getUpdated_By()).isEqualTo(updated_By);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "CreatedBy";
        childValidDataHandlerUnderTest.setCreatedBy(createdBy);
        assertThat(childValidDataHandlerUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Date createdDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        childValidDataHandlerUnderTest.setCreatedDate(createdDate);
        assertThat(childValidDataHandlerUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "ModifiedBy";
        childValidDataHandlerUnderTest.setModifiedBy(modifiedBy);
        assertThat(childValidDataHandlerUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Date lastModDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        childValidDataHandlerUnderTest.setLastModDate(lastModDate);
        assertThat(childValidDataHandlerUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(childValidDataHandlerUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(childValidDataHandlerUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(childValidDataHandlerUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(childValidDataHandlerUnderTest.toString()).isEqualTo("result");
    }
}
