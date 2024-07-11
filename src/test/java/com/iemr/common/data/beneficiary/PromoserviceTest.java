package com.iemr.common.data.beneficiary;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PromoserviceTest {

	@InjectMocks
    private Promoservice promoserviceUnderTest;

    @BeforeEach
    void setUp() {
        promoserviceUnderTest = new Promoservice("pamphlet", "radio", "television", "familyFriends", "healthcareWorker",
                "others", "notDisclosed");
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        promoserviceUnderTest.setId(id);
        assertThat(promoserviceUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testPamphletGetterAndSetter() {
        final String pamphlet = "pamphlet";
        promoserviceUnderTest.setPamphlet(pamphlet);
        assertThat(promoserviceUnderTest.getPamphlet()).isEqualTo(pamphlet);
    }

    @Test
    void testRadioGetterAndSetter() {
        final String radio = "radio";
        promoserviceUnderTest.setRadio(radio);
        assertThat(promoserviceUnderTest.getRadio()).isEqualTo(radio);
    }

    @Test
    void testTelevisionGetterAndSetter() {
        final String television = "television";
        promoserviceUnderTest.setTelevision(television);
        assertThat(promoserviceUnderTest.getTelevision()).isEqualTo(television);
    }

    @Test
    void testFamilyFriendsGetterAndSetter() {
        final String familyFriends = "familyFriends";
        promoserviceUnderTest.setFamilyFriends(familyFriends);
        assertThat(promoserviceUnderTest.getFamilyFriends()).isEqualTo(familyFriends);
    }

    @Test
    void testHealthcareWorkerGetterAndSetter() {
        final String healthcareWorker = "healthcareWorker";
        promoserviceUnderTest.setHealthcareWorker(healthcareWorker);
        assertThat(promoserviceUnderTest.getHealthcareWorker()).isEqualTo(healthcareWorker);
    }

    @Test
    void testOthersGetterAndSetter() {
        final String others = "others";
        promoserviceUnderTest.setOthers(others);
        assertThat(promoserviceUnderTest.getOthers()).isEqualTo(others);
    }

    @Test
    void testNotDisclosedGetterAndSetter() {
        final String notDisclosed = "notDisclosed";
        promoserviceUnderTest.setNotDisclosed(notDisclosed);
        assertThat(promoserviceUnderTest.getNotDisclosed()).isEqualTo(notDisclosed);
    }

    @Test
    void testToString() throws Exception {
        assertThat(promoserviceUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        promoserviceUnderTest.setOutputMapper(outputMapper);
        assertThat(promoserviceUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(promoserviceUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(promoserviceUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(promoserviceUnderTest.hashCode()).isEqualTo(0);
    }
}
