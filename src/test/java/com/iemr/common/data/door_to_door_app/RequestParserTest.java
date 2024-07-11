package com.iemr.common.data.door_to_door_app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RequestParserTest {

	@InjectMocks
    private RequestParser requestParserUnderTest;

    @BeforeEach
    void setUp() {
        requestParserUnderTest = new RequestParser(0L, "suspectedTB", "suspectedHRP", "suspectedNCD",
                "suspectedNCDDiseases");
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        requestParserUnderTest.setUserID(userID);
        assertThat(requestParserUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testBenRegIDGetterAndSetter() {
        final Long benRegID = 0L;
        requestParserUnderTest.setBenRegID(benRegID);
        assertThat(requestParserUnderTest.getBenRegID()).isEqualTo(benRegID);
    }

    @Test
    void testVisitCodeGetterAndSetter() {
        final Long visitCode = 0L;
        requestParserUnderTest.setVisitCode(visitCode);
        assertThat(requestParserUnderTest.getVisitCode()).isEqualTo(visitCode);
    }

    @Test
    void testSuspectedTBGetterAndSetter() {
        final String suspectedTB = "suspectedTB";
        requestParserUnderTest.setSuspectedTB(suspectedTB);
        assertThat(requestParserUnderTest.getSuspectedTB()).isEqualTo(suspectedTB);
    }

    @Test
    void testSuspectedHRPGetterAndSetter() {
        final String suspectedHRP = "suspectedHRP";
        requestParserUnderTest.setSuspectedHRP(suspectedHRP);
        assertThat(requestParserUnderTest.getSuspectedHRP()).isEqualTo(suspectedHRP);
    }

    @Test
    void testSuspectedNCDGetterAndSetter() {
        final String suspectedNCD = "suspectedNCD";
        requestParserUnderTest.setSuspectedNCD(suspectedNCD);
        assertThat(requestParserUnderTest.getSuspectedNCD()).isEqualTo(suspectedNCD);
    }

    @Test
    void testSuspectedNCDDiseasesGetterAndSetter() {
        final String suspectedNCDDiseases = "suspectedNCDDiseases";
        requestParserUnderTest.setSuspectedNCDDiseases(suspectedNCDDiseases);
        assertThat(requestParserUnderTest.getSuspectedNCDDiseases()).isEqualTo(suspectedNCDDiseases);
    }

    @Test
    void testEquals() {
        assertThat(requestParserUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(requestParserUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(requestParserUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(requestParserUnderTest.toString()).isEqualTo("result");
    }
}
