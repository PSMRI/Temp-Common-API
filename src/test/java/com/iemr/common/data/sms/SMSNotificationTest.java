package com.iemr.common.data.sms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SMSNotificationTest {

	@InjectMocks
    private SMSNotification smsNotificationUnderTest;

    @BeforeEach
    void setUp() {
        smsNotificationUnderTest = new SMSNotification();
    }

    @Test
    void testToString() {
        assertThat(smsNotificationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testSmsNotificatioIDGetterAndSetter() {
        final Long smsNotificatioID = 0L;
        smsNotificationUnderTest.setSmsNotificatioID(smsNotificatioID);
        assertThat(smsNotificationUnderTest.getSmsNotificatioID()).isEqualTo(smsNotificatioID);
    }

    @Test
    void testSmsTemplateIDGetterAndSetter() {
        final Integer smsTemplateID = 0;
        smsNotificationUnderTest.setSmsTemplateID(smsTemplateID);
        assertThat(smsNotificationUnderTest.getSmsTemplateID()).isEqualTo(smsTemplateID);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        smsNotificationUnderTest.setPhoneNo(phoneNo);
        assertThat(smsNotificationUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testSmsGetterAndSetter() {
        final String sms = "sms";
        smsNotificationUnderTest.setSms(sms);
        assertThat(smsNotificationUnderTest.getSms()).isEqualTo(sms);
    }

    @Test
    void testSmsTriggerDateGetterAndSetter() {
        final Timestamp smsTriggerDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsNotificationUnderTest.setSmsTriggerDate(smsTriggerDate);
        assertThat(smsNotificationUnderTest.getSmsTriggerDate()).isEqualTo(smsTriggerDate);
    }

    @Test
    void testSmsSentDateGetterAndSetter() {
        final Timestamp smsSentDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsNotificationUnderTest.setSmsSentDate(smsSentDate);
        assertThat(smsNotificationUnderTest.getSmsSentDate()).isEqualTo(smsSentDate);
    }

    @Test
    void testSmsStatusGetterAndSetter() {
        final Integer smsStatus = 0;
        smsNotificationUnderTest.setSmsStatus(smsStatus);
        assertThat(smsNotificationUnderTest.getSmsStatus()).isEqualTo(smsStatus);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        smsNotificationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(smsNotificationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testSenderIDGetterAndSetter() {
        final Integer senderID = 0;
        smsNotificationUnderTest.setSenderID(senderID);
        assertThat(smsNotificationUnderTest.getSenderID()).isEqualTo(senderID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        smsNotificationUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(smsNotificationUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        smsNotificationUnderTest.setBenCallID(benCallID);
        assertThat(smsNotificationUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testReceivingUserIDGetterAndSetter() {
        final Long receivingUserID = 0L;
        smsNotificationUnderTest.setReceivingUserID(receivingUserID);
        assertThat(smsNotificationUnderTest.getReceivingUserID()).isEqualTo(receivingUserID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        smsNotificationUnderTest.setDeleted(deleted);
        assertThat(smsNotificationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        smsNotificationUnderTest.setCreatedBy(createdBy);
        assertThat(smsNotificationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsNotificationUnderTest.setCreatedDate(createdDate);
        assertThat(smsNotificationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        smsNotificationUnderTest.setModifiedBy(modifiedBy);
        assertThat(smsNotificationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        smsNotificationUnderTest.setLastModDate(lastModDate);
        assertThat(smsNotificationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testTransactionIDGetterAndSetter() {
        final String transactionID = "transactionID";
        smsNotificationUnderTest.setTransactionID(transactionID);
        assertThat(smsNotificationUnderTest.getTransactionID()).isEqualTo(transactionID);
    }

    @Test
    void testIsTransactionErrorGetterAndSetter() {
        final Boolean isTransactionError = false;
        smsNotificationUnderTest.setIsTransactionError(isTransactionError);
        assertThat(smsNotificationUnderTest.getIsTransactionError()).isFalse();
    }

    @Test
    void testTransactionErrorGetterAndSetter() {
        final String transactionError = "transactionError";
        smsNotificationUnderTest.setTransactionError(transactionError);
        assertThat(smsNotificationUnderTest.getTransactionError()).isEqualTo(transactionError);
    }

    @Test
    void testEquals() {
        assertThat(smsNotificationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(smsNotificationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(smsNotificationUnderTest.hashCode()).isEqualTo(0);
    }
}
