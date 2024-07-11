package com.iemr.common.data.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmailNotificationTest {

	@InjectMocks
    private EmailNotification emailNotificationUnderTest;

    @BeforeEach
    void setUp() {
        emailNotificationUnderTest = new EmailNotification();
    }

    @Test
    void testToString() {
        assertThat(emailNotificationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testEmailNotificationIDGetterAndSetter() {
        final Integer emailNotificationID = 0;
        emailNotificationUnderTest.setEmailNotificationID(emailNotificationID);
        assertThat(emailNotificationUnderTest.getEmailNotificationID()).isEqualTo(emailNotificationID);
    }

    @Test
    void testEmailTemplateIDGetterAndSetter() {
        final Integer emailTemplateID = 0;
        emailNotificationUnderTest.setEmailTemplateID(emailTemplateID);
        assertThat(emailNotificationUnderTest.getEmailTemplateID()).isEqualTo(emailTemplateID);
    }

    @Test
    void testSenderIDGetterAndSetter() {
        final Integer senderID = 0;
        emailNotificationUnderTest.setSenderID(senderID);
        assertThat(emailNotificationUnderTest.getSenderID()).isEqualTo(senderID);
    }

    @Test
    void testReceivingUserIDGetterAndSetter() {
        final Integer receivingUserID = 0;
        emailNotificationUnderTest.setReceivingUserID(receivingUserID);
        assertThat(emailNotificationUnderTest.getReceivingUserID()).isEqualTo(receivingUserID);
    }

    @Test
    void testBenCallIDGetterAndSetter() {
        final Long benCallID = 0L;
        emailNotificationUnderTest.setBenCallID(benCallID);
        assertThat(emailNotificationUnderTest.getBenCallID()).isEqualTo(benCallID);
    }

    @Test
    void testBeneficiaryRegIDGetterAndSetter() {
        final Long beneficiaryRegID = 0L;
        emailNotificationUnderTest.setBeneficiaryRegID(beneficiaryRegID);
        assertThat(emailNotificationUnderTest.getBeneficiaryRegID()).isEqualTo(beneficiaryRegID);
    }

    @Test
    void testPhoneNoGetterAndSetter() {
        final String phoneNo = "phoneNo";
        emailNotificationUnderTest.setPhoneNo(phoneNo);
        assertThat(emailNotificationUnderTest.getPhoneNo()).isEqualTo(phoneNo);
    }

    @Test
    void testEmailIDGetterAndSetter() {
        final String emailID = "emailID";
        emailNotificationUnderTest.setEmailID(emailID);
        assertThat(emailNotificationUnderTest.getEmailID()).isEqualTo(emailID);
    }

    @Test
    void testEmailGetterAndSetter() {
        final String email = "email";
        emailNotificationUnderTest.setEmail(email);
        assertThat(emailNotificationUnderTest.getEmail()).isEqualTo(email);
    }

    @Test
    void testEmailTriggerDateGetterAndSetter() {
        final Timestamp emailTriggerDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailNotificationUnderTest.setEmailTriggerDate(emailTriggerDate);
        assertThat(emailNotificationUnderTest.getEmailTriggerDate()).isEqualTo(emailTriggerDate);
    }

    @Test
    void testEmailStatusGetterAndSetter() {
        final Integer emailStatus = 0;
        emailNotificationUnderTest.setEmailStatus(emailStatus);
        assertThat(emailNotificationUnderTest.getEmailStatus()).isEqualTo(emailStatus);
    }

    @Test
    void testEmailSentDateGetterAndSetter() {
        final Timestamp emailSentDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailNotificationUnderTest.setEmailSentDate(emailSentDate);
        assertThat(emailNotificationUnderTest.getEmailSentDate()).isEqualTo(emailSentDate);
    }

    @Test
    void testTransactionIDGetterAndSetter() {
        final String transactionID = "transactionID";
        emailNotificationUnderTest.setTransactionID(transactionID);
        assertThat(emailNotificationUnderTest.getTransactionID()).isEqualTo(transactionID);
    }

    @Test
    void testIsTransactionErrorGetterAndSetter() {
        final Boolean isTransactionError = false;
        emailNotificationUnderTest.setIsTransactionError(isTransactionError);
        assertThat(emailNotificationUnderTest.getIsTransactionError()).isFalse();
    }

    @Test
    void testTransactionErrorGetterAndSetter() {
        final String transactionError = "transactionError";
        emailNotificationUnderTest.setTransactionError(transactionError);
        assertThat(emailNotificationUnderTest.getTransactionError()).isEqualTo(transactionError);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        emailNotificationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(emailNotificationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        emailNotificationUnderTest.setDeleted(deleted);
        assertThat(emailNotificationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        emailNotificationUnderTest.setCreatedBy(createdBy);
        assertThat(emailNotificationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailNotificationUnderTest.setCreatedDate(createdDate);
        assertThat(emailNotificationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        emailNotificationUnderTest.setModifiedBy(modifiedBy);
        assertThat(emailNotificationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emailNotificationUnderTest.setLastModDate(lastModDate);
        assertThat(emailNotificationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testFeedbackIDGetterAndSetter() {
        final Long feedbackID = 0L;
        emailNotificationUnderTest.setFeedbackID(feedbackID);
        assertThat(emailNotificationUnderTest.getFeedbackID()).isEqualTo(feedbackID);
    }

    @Test
    void testIs1097GetterAndSetter() {
        final Boolean is1097 = false;
        emailNotificationUnderTest.setIs1097(is1097);
        assertThat(emailNotificationUnderTest.getIs1097()).isFalse();
    }

    @Test
    void testEquals() {
        assertThat(emailNotificationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(emailNotificationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(emailNotificationUnderTest.hashCode()).isEqualTo(0);
    }
}
