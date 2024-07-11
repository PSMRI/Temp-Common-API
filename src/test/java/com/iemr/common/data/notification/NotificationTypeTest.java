package com.iemr.common.data.notification;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NotificationTypeTest {

	@InjectMocks
    private NotificationType notificationTypeUnderTest;

    @BeforeEach
    void setUp() {
        notificationTypeUnderTest = new NotificationType();
    }

    @Test
    void testToString() {
        assertThat(notificationTypeUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testNotificationTypeIDGetterAndSetter() {
        final Integer notificationTypeID = 0;
        notificationTypeUnderTest.setNotificationTypeID(notificationTypeID);
        assertThat(notificationTypeUnderTest.getNotificationTypeID()).isEqualTo(notificationTypeID);
    }

    @Test
    void testNotificationsGetterAndSetter() {
        final List<Notification> notifications = List.of(new Notification());
        notificationTypeUnderTest.setNotifications(notifications);
        assertThat(notificationTypeUnderTest.getNotifications()).isEqualTo(notifications);
    }

    @Test
    void testNotificationTypeGetterAndSetter() {
        final String notificationType = "notificationType";
        notificationTypeUnderTest.setNotificationType(notificationType);
        assertThat(notificationTypeUnderTest.getNotificationType()).isEqualTo(notificationType);
    }

    @Test
    void testNotificationTypeDescGetterAndSetter() {
        final String notificationTypeDesc = "notificationTypeDesc";
        notificationTypeUnderTest.setNotificationTypeDesc(notificationTypeDesc);
        assertThat(notificationTypeUnderTest.getNotificationTypeDesc()).isEqualTo(notificationTypeDesc);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        notificationTypeUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(notificationTypeUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        notificationTypeUnderTest.setDeleted(deleted);
        assertThat(notificationTypeUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        notificationTypeUnderTest.setCreatedBy(createdBy);
        assertThat(notificationTypeUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        notificationTypeUnderTest.setModifiedBy(modifiedBy);
        assertThat(notificationTypeUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testInitializeNotificationTypes() {
        // Run the test
        final NotificationType result = NotificationType.initializeNotificationTypes(0, "notificationTypeName",
                "notificationTypeDesc", false);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getNotificationTypeID()).isEqualTo(0);
        assertThat(result.getNotifications()).isEqualTo(List.of(new Notification()));
        assertThat(result.getNotificationType()).isEqualTo("notificationType");
        assertThat(result.getNotificationTypeDesc()).isEqualTo("notificationTypeDesc");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getEmergencyContacts()).isEqualTo(List.of(new EmergencyContacts()));
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testEmergencyContactsGetterAndSetter() {
        final List<EmergencyContacts> emergencyContacts = List.of(new EmergencyContacts());
        notificationTypeUnderTest.setEmergencyContacts(emergencyContacts);
        assertThat(notificationTypeUnderTest.getEmergencyContacts()).isEqualTo(emergencyContacts);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationTypeUnderTest.setCreatedDate(createdDate);
        assertThat(notificationTypeUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationTypeUnderTest.setLastModDate(lastModDate);
        assertThat(notificationTypeUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        notificationTypeUnderTest.setOutputMapper(outputMapper);
        assertThat(notificationTypeUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(notificationTypeUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(notificationTypeUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(notificationTypeUnderTest.hashCode()).isEqualTo(0);
    }
}
