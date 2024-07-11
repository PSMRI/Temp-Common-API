package com.iemr.common.data.notification;

import com.iemr.common.data.institute.Designation;
import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmergencyContactsTest {

    @Mock
    private ProviderServiceMapping mockProviderServiceMapping;
    @Mock
    private NotificationType mockNotificationType;
    @Mock
    private Designation mockDesignation;

    @InjectMocks
    private EmergencyContacts emergencyContactsUnderTest;

    @BeforeEach
    void setUp() {
        emergencyContactsUnderTest = new EmergencyContacts(0, 0, "emergContactName", "emergContactNo",
                "emergContactDesc", 0, mockProviderServiceMapping, 0, mockNotificationType, "location", false,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), mockDesignation);
    }

    @Test
    void testToString() {
        assertThat(emergencyContactsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        emergencyContactsUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(emergencyContactsUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testNotificationTypeIDGetterAndSetter() {
        final Integer notificationTypeID = 0;
        emergencyContactsUnderTest.setNotificationTypeID(notificationTypeID);
        assertThat(emergencyContactsUnderTest.getNotificationTypeID()).isEqualTo(notificationTypeID);
    }

    @Test
    void testEmergContactIDGetterAndSetter() {
        final Integer emergContactID = 0;
        emergencyContactsUnderTest.setEmergContactID(emergContactID);
        assertThat(emergencyContactsUnderTest.getEmergContactID()).isEqualTo(emergContactID);
    }

    @Test
    void testDesignationIDGetterAndSetter() {
        final Integer designationID = 0;
        emergencyContactsUnderTest.setDesignationID(designationID);
        assertThat(emergencyContactsUnderTest.getDesignationID()).isEqualTo(designationID);
    }

    @Test
    void testEmergContactNoGetterAndSetter() {
        final String emergContactNo = "emergContactNo";
        emergencyContactsUnderTest.setEmergContactNo(emergContactNo);
        assertThat(emergencyContactsUnderTest.getEmergContactNo()).isEqualTo(emergContactNo);
    }

    @Test
    void testEmergContactDescGetterAndSetter() {
        final String emergContactDesc = "emergContactDesc";
        emergencyContactsUnderTest.setEmergContactDesc(emergContactDesc);
        assertThat(emergencyContactsUnderTest.getEmergContactDesc()).isEqualTo(emergContactDesc);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        emergencyContactsUnderTest.setDeleted(deleted);
        assertThat(emergencyContactsUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        emergencyContactsUnderTest.setModifiedBy(modifiedBy);
        assertThat(emergencyContactsUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testEmergContactNameGetterAndSetter() {
        final String emergContactName = "emergContactName";
        emergencyContactsUnderTest.setEmergContactName(emergContactName);
        assertThat(emergencyContactsUnderTest.getEmergContactName()).isEqualTo(emergContactName);
    }

    @Test
    void testLocationGetterAndSetter() {
        final String location = "location";
        emergencyContactsUnderTest.setLocation(location);
        assertThat(emergencyContactsUnderTest.getLocation()).isEqualTo(location);
    }

    @Test
    void testInitializeEmergencyContacts() {
        // Setup
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        final NotificationType notificationType = new NotificationType();
        notificationType.setNotificationTypeID(0);
        final Notification notification = new Notification();
        notification.setNotificationDesc("notificationDesc");
        notification.setKmFileManagerID(0);
        final KMFileManager kmFileManager = new KMFileManager();
        notification.setKmFileManager(kmFileManager);
        notificationType.setNotifications(List.of(notification));

        final Designation designation = new Designation(0, "designationName");

        // Run the test
        final EmergencyContacts result = EmergencyContacts.initializeEmergencyContacts(0, 0, "emergContactName",
                "emergContactNo", "emergContactDesc", 0, providerServiceMapping, 0, notificationType, "location", false,
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), designation);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getNotificationTypeID()).isEqualTo(0);
        assertThat(result.getEmergContactID()).isEqualTo(0);
        assertThat(result.getDesignationID()).isEqualTo(0);
        assertThat(result.getEmergContactNo()).isEqualTo("emergContactNo");
        assertThat(result.getEmergContactDesc()).isEqualTo("emergContactDesc");
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getEmergContactName()).isEqualTo("emergContactName");
        assertThat(result.getLocation()).isEqualTo("location");
        assertThat(result.equals("obj")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
        assertThat(result.getMapper()).isEqualTo(new OutputMapper());
        assertThat(result.getDesignation()).isEqualTo(new Designation(0, "designationName"));
        assertThat(result.getProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getNotificationType()).isEqualTo(new NotificationType());
        assertThat(result.getProcessed()).isEqualTo("processed");
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getDesignationName()).isEqualTo("designationName");
    }

    @Test
    void testEquals() {
        assertThat(emergencyContactsUnderTest.equals("obj")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(emergencyContactsUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        emergencyContactsUnderTest.setMapper(mapper);
        assertThat(emergencyContactsUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testDesignationGetterAndSetter() {
        final Designation designation = new Designation(0, "designationName");
        emergencyContactsUnderTest.setDesignation(designation);
        assertThat(emergencyContactsUnderTest.getDesignation()).isEqualTo(designation);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        emergencyContactsUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(emergencyContactsUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testNotificationTypeGetterAndSetter() {
        final NotificationType notificationType = new NotificationType();
        emergencyContactsUnderTest.setNotificationType(notificationType);
        assertThat(emergencyContactsUnderTest.getNotificationType()).isEqualTo(notificationType);
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        emergencyContactsUnderTest.setProcessed(processed);
        assertThat(emergencyContactsUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        emergencyContactsUnderTest.setCreatedBy(createdBy);
        assertThat(emergencyContactsUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emergencyContactsUnderTest.setCreatedDate(createdDate);
        assertThat(emergencyContactsUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        emergencyContactsUnderTest.setLastModDate(lastModDate);
        assertThat(emergencyContactsUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testDesignationNameGetterAndSetter() {
        final String designationName = "designationName";
        emergencyContactsUnderTest.setDesignationName(designationName);
        assertThat(emergencyContactsUnderTest.getDesignationName()).isEqualTo(designationName);
    }
}
