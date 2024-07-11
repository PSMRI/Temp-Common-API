package com.iemr.common.data.sms;

import com.iemr.common.data.users.ServiceMaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SMSTypeTest {

	@InjectMocks
    private SMSType smsTypeUnderTest;

    @BeforeEach
    void setUp() {
        smsTypeUnderTest = new SMSType();
    }

    @Test
    void testToString() {
        assertThat(smsTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSmsTypeIDGetterAndSetter() {
        final Integer smsTypeID = 0;
        smsTypeUnderTest.setSmsTypeID(smsTypeID);
        assertThat(smsTypeUnderTest.getSmsTypeID()).isEqualTo(smsTypeID);
    }

    @Test
    void testSmsTypeGetterAndSetter() {
        final String smsType = "smsType";
        smsTypeUnderTest.setSmsType(smsType);
        assertThat(smsTypeUnderTest.getSmsType()).isEqualTo(smsType);
    }

    @Test
    void testDescriptionGetterAndSetter() {
        final String description = "description";
        smsTypeUnderTest.setDescription(description);
        assertThat(smsTypeUnderTest.getDescription()).isEqualTo(description);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Integer serviceID = 0;
        smsTypeUnderTest.setServiceID(serviceID);
        assertThat(smsTypeUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testServiceGetterAndSetter() {
        final ServiceMaster service = new ServiceMaster();
        smsTypeUnderTest.setService(service);
        assertThat(smsTypeUnderTest.getService()).isEqualTo(service);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        smsTypeUnderTest.setDeleted(deleted);
        assertThat(smsTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsTypeUnderTest.setCreatedBy(createdBy);
        assertThat(smsTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsTypeUnderTest.setCreatedDate(createdDate);
        assertThat(smsTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        smsTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(smsTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsTypeUnderTest.setLastModDate(lastModDate);
        assertThat(smsTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testEquals() {
        assertThat(smsTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
