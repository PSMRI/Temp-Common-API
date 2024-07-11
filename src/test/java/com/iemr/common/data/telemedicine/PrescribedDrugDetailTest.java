package com.iemr.common.data.telemedicine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PrescribedDrugDetailTest {

	@InjectMocks
    private PrescribedDrugDetail prescribedDrugDetailUnderTest;

    @BeforeEach
    void setUp() {
        prescribedDrugDetailUnderTest = new PrescribedDrugDetail();
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        prescribedDrugDetailUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(prescribedDrugDetailUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenVisitIDGetterAndSetter() {
        final Long benVisitID = 0L;
        prescribedDrugDetailUnderTest.setBenVisitID(benVisitID);
        assertThat(prescribedDrugDetailUnderTest.getBenVisitID()).isEqualTo(benVisitID);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        prescribedDrugDetailUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(prescribedDrugDetailUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testVisitCodeGetterAndSetter() {
        final Long visitCode = 0L;
        prescribedDrugDetailUnderTest.setVisitCode(visitCode);
        assertThat(prescribedDrugDetailUnderTest.getVisitCode()).isEqualTo(visitCode);
    }

    @Test
    void testPrescriptionIDGetterAndSetter() {
        final Long prescriptionID = 0L;
        prescribedDrugDetailUnderTest.setPrescriptionID(prescriptionID);
        assertThat(prescribedDrugDetailUnderTest.getPrescriptionID()).isEqualTo(prescriptionID);
    }

    @Test
    void testFormNameGetterAndSetter() {
        final String formName = "formName";
        prescribedDrugDetailUnderTest.setFormName(formName);
        assertThat(prescribedDrugDetailUnderTest.getFormName()).isEqualTo(formName);
    }

    @Test
    void testDrugTradeOrBrandNameGetterAndSetter() {
        final String drugTradeOrBrandName = "drugTradeOrBrandName";
        prescribedDrugDetailUnderTest.setDrugTradeOrBrandName(drugTradeOrBrandName);
        assertThat(prescribedDrugDetailUnderTest.getDrugTradeOrBrandName()).isEqualTo(drugTradeOrBrandName);
    }

    @Test
    void testDrugIDGetterAndSetter() {
        final Integer drugID = 0;
        prescribedDrugDetailUnderTest.setDrugID(drugID);
        assertThat(prescribedDrugDetailUnderTest.getDrugID()).isEqualTo(drugID);
    }

    @Test
    void testDrugNameGetterAndSetter() {
        final String drugName = "drugName";
        prescribedDrugDetailUnderTest.setDrugName(drugName);
        assertThat(prescribedDrugDetailUnderTest.getDrugName()).isEqualTo(drugName);
    }

    @Test
    void testDrugStrengthGetterAndSetter() {
        final String drugStrength = "drugStrength";
        prescribedDrugDetailUnderTest.setDrugStrength(drugStrength);
        assertThat(prescribedDrugDetailUnderTest.getDrugStrength()).isEqualTo(drugStrength);
    }

    @Test
    void testDoseGetterAndSetter() {
        final String dose = "dose";
        prescribedDrugDetailUnderTest.setDose(dose);
        assertThat(prescribedDrugDetailUnderTest.getDose()).isEqualTo(dose);
    }

    @Test
    void testRouteGetterAndSetter() {
        final String route = "route";
        prescribedDrugDetailUnderTest.setRoute(route);
        assertThat(prescribedDrugDetailUnderTest.getRoute()).isEqualTo(route);
    }

    @Test
    void testFrequencyGetterAndSetter() {
        final String frequency = "frequency";
        prescribedDrugDetailUnderTest.setFrequency(frequency);
        assertThat(prescribedDrugDetailUnderTest.getFrequency()).isEqualTo(frequency);
    }

    @Test
    void testDurationGetterAndSetter() {
        final String duration = "duration";
        prescribedDrugDetailUnderTest.setDuration(duration);
        assertThat(prescribedDrugDetailUnderTest.getDuration()).isEqualTo(duration);
    }

    @Test
    void testUnitGetterAndSetter() {
        final String unit = "unit";
        prescribedDrugDetailUnderTest.setUnit(unit);
        assertThat(prescribedDrugDetailUnderTest.getUnit()).isEqualTo(unit);
    }

    @Test
    void testRelationToFoodGetterAndSetter() {
        final String relationToFood = "relationToFood";
        prescribedDrugDetailUnderTest.setRelationToFood(relationToFood);
        assertThat(prescribedDrugDetailUnderTest.getRelationToFood()).isEqualTo(relationToFood);
    }

    @Test
    void testInstructionsGetterAndSetter() {
        final String instructions = "instructions";
        prescribedDrugDetailUnderTest.setInstructions(instructions);
        assertThat(prescribedDrugDetailUnderTest.getInstructions()).isEqualTo(instructions);
    }

    @Test
    void testQtyPrescribedGetterAndSetter() {
        final Integer qtyPrescribed = 0;
        prescribedDrugDetailUnderTest.setQtyPrescribed(qtyPrescribed);
        assertThat(prescribedDrugDetailUnderTest.getQtyPrescribed()).isEqualTo(qtyPrescribed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        prescribedDrugDetailUnderTest.setCreatedBy(createdBy);
        assertThat(prescribedDrugDetailUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        prescribedDrugDetailUnderTest.setModifiedBy(modifiedBy);
        assertThat(prescribedDrugDetailUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testVanSerialNoGetterAndSetter() {
        final Long vanSerialNo = 0L;
        prescribedDrugDetailUnderTest.setVanSerialNo(vanSerialNo);
        assertThat(prescribedDrugDetailUnderTest.getVanSerialNo()).isEqualTo(vanSerialNo);
    }

    @Test
    void testVehicalNoGetterAndSetter() {
        final String vehicalNo = "vehicalNo";
        prescribedDrugDetailUnderTest.setVehicalNo(vehicalNo);
        assertThat(prescribedDrugDetailUnderTest.getVehicalNo()).isEqualTo(vehicalNo);
    }

    @Test
    void testVanIDGetterAndSetter() {
        final Integer vanID = 0;
        prescribedDrugDetailUnderTest.setVanID(vanID);
        assertThat(prescribedDrugDetailUnderTest.getVanID()).isEqualTo(vanID);
    }

    @Test
    void testParkingPlaceIDGetterAndSetter() {
        final Integer parkingPlaceID = 0;
        prescribedDrugDetailUnderTest.setParkingPlaceID(parkingPlaceID);
        assertThat(prescribedDrugDetailUnderTest.getParkingPlaceID()).isEqualTo(parkingPlaceID);
    }

    @Test
    void testSyncedByGetterAndSetter() {
        final String syncedBy = "syncedBy";
        prescribedDrugDetailUnderTest.setSyncedBy(syncedBy);
        assertThat(prescribedDrugDetailUnderTest.getSyncedBy()).isEqualTo(syncedBy);
    }

    @Test
    void testSyncedDateGetterAndSetter() {
        final Timestamp syncedDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        prescribedDrugDetailUnderTest.setSyncedDate(syncedDate);
        assertThat(prescribedDrugDetailUnderTest.getSyncedDate()).isEqualTo(syncedDate);
    }

    @Test
    void testReservedForChangeGetterAndSetter() {
        final String reservedForChange = "reservedForChange";
        prescribedDrugDetailUnderTest.setReservedForChange(reservedForChange);
        assertThat(prescribedDrugDetailUnderTest.getReservedForChange()).isEqualTo(reservedForChange);
    }

    @Test
    void testIsEDLGetterAndSetter() {
        final Boolean isEDL = false;
        prescribedDrugDetailUnderTest.setIsEDL(isEDL);
        assertThat(prescribedDrugDetailUnderTest.getIsEDL()).isFalse();
    }
}
