package com.iemr.common.data.otp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OTPRequestParsorTest {

	@InjectMocks
    private OTPRequestParsor otpRequestParsorUnderTest;

    @BeforeEach
    void setUp() {
        otpRequestParsorUnderTest = new OTPRequestParsor();
    }

    @Test
    void testMobNoGetterAndSetter() {
        final String mobNo = "mobNo";
        otpRequestParsorUnderTest.setMobNo(mobNo);
        assertThat(otpRequestParsorUnderTest.getMobNo()).isEqualTo(mobNo);
    }

    @Test
    void testOtpGetterAndSetter() {
        final int otp = 0;
        otpRequestParsorUnderTest.setOtp(otp);
        assertThat(otpRequestParsorUnderTest.getOtp()).isEqualTo(otp);
    }

    @Test
    void testEquals() {
        assertThat(otpRequestParsorUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(otpRequestParsorUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(otpRequestParsorUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(otpRequestParsorUnderTest.toString()).isEqualTo("result");
    }
}
