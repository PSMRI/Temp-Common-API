package com.iemr.common.data.notification;

import com.iemr.common.data.kmfilemanager.KMFileManager;
import com.iemr.common.data.userbeneficiarydata.Language;
import com.iemr.common.data.users.ProviderServiceMapping;
import com.iemr.common.data.users.Role;
import com.iemr.common.data.users.User;
import com.iemr.common.data.users.WorkLocation;
import com.iemr.common.notification.agent.UserNotificationMapping;
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
class NotificationTest {

	@InjectMocks
    private Notification notificationUnderTest;

    @BeforeEach
    void setUp() {
        notificationUnderTest = new Notification();
    }

    @Test
    void testToString() {
        assertThat(notificationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        notificationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(notificationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testRoleIDGetterAndSetter() {
        final Integer roleID = 0;
        notificationUnderTest.setRoleID(roleID);
        assertThat(notificationUnderTest.getRoleID()).isEqualTo(roleID);
    }

    @Test
    void testNotificationIDGetterAndSetter() {
        final Integer notificationID = 0;
        notificationUnderTest.setNotificationID(notificationID);
        assertThat(notificationUnderTest.getNotificationID()).isEqualTo(notificationID);
    }

    @Test
    void testNotificationGetterAndSetter() {
        final String notification = "notification";
        notificationUnderTest.setNotification(notification);
        assertThat(notificationUnderTest.getNotification()).isEqualTo(notification);
    }

    @Test
    void testNotificationDescGetterAndSetter() {
        final String notificationDesc = "notificationDesc";
        notificationUnderTest.setNotificationDesc(notificationDesc);
        assertThat(notificationUnderTest.getNotificationDesc()).isEqualTo(notificationDesc);
    }

    @Test
    void testNotificationTypeIDGetterAndSetter() {
        final Integer notificationTypeID = 0;
        notificationUnderTest.setNotificationTypeID(notificationTypeID);
        assertThat(notificationUnderTest.getNotificationTypeID()).isEqualTo(notificationTypeID);
    }

    @Test
    void testValidTillGetterAndSetter() {
        final Timestamp validTill = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setValidTill(validTill);
        assertThat(notificationUnderTest.getValidTill()).isEqualTo(validTill);
    }

    @Test
    void testValidFromGetterAndSetter() {
        final Timestamp validFrom = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setValidFrom(validFrom);
        assertThat(notificationUnderTest.getValidFrom()).isEqualTo(validFrom);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        notificationUnderTest.setDeleted(deleted);
        assertThat(notificationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        notificationUnderTest.setCreatedBy(createdBy);
        assertThat(notificationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setCreatedDate(createdDate);
        assertThat(notificationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        notificationUnderTest.setModifiedBy(modifiedBy);
        assertThat(notificationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setLastModDate(lastModDate);
        assertThat(notificationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testRoleIDsGetterAndSetter() {
        final List<Integer> roleIDs = List.of(0);
        notificationUnderTest.setRoleIDs(roleIDs);
        assertThat(notificationUnderTest.getRoleIDs()).isEqualTo(roleIDs);
    }

    @Test
    void testKmFileManagerIDGetterAndSetter() {
        final Integer kmFileManagerID = 0;
        notificationUnderTest.setKmFileManagerID(kmFileManagerID);
        assertThat(notificationUnderTest.getKmFileManagerID()).isEqualTo(kmFileManagerID);
    }

    @Test
    void testKmFileManagerGetterAndSetter() {
        final KMFileManager kmFileManager = new KMFileManager();
        notificationUnderTest.setKmFileManager(kmFileManager);
        assertThat(notificationUnderTest.getKmFileManager()).isEqualTo(kmFileManager);
    }

    @Test
    void testValidStartDateGetterAndSetter() {
        final Timestamp validStartDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setValidStartDate(validStartDate);
        assertThat(notificationUnderTest.getValidStartDate()).isEqualTo(validStartDate);
    }

    @Test
    void testValidEndDateGetterAndSetter() {
        final Timestamp validEndDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        notificationUnderTest.setValidEndDate(validEndDate);
        assertThat(notificationUnderTest.getValidEndDate()).isEqualTo(validEndDate);
    }

    @Test
    void testInitializeNotification() {
        // Setup
        final NotificationType notificationType = new NotificationType();
        notificationType.setNotificationTypeID(0);
        final Notification notification = new Notification();
        notification.setNotificationDesc("notificationDesc");
        notification.setKmFileManagerID(0);
        final KMFileManager kmFileManager = new KMFileManager();
        notification.setKmFileManager(kmFileManager);
        notificationType.setNotifications(List.of(notification));

        final Role role = new Role();
        role.setDeleted(false);
        role.setCreatedBy("createdBy");
        role.setCreatedDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        role.setModifiedBy("modifiedBy");
        role.setLastModDate(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));

        final KMFileManager kmFileManager1 = new KMFileManager();
        kmFileManager1.setFileUID("fileUID");
        kmFileManager1.setFileCheckSum("fileCheckSum");
        kmFileManager1.setKmUploadStatus("kmUploadStatus");
        kmFileManager1.setVersionNo("versionNo");
        kmFileManager1.setKmFileManagerID(0);

        final WorkLocation workingLocation = new WorkLocation();
        workingLocation.setPsAddMapID(0);
        final Notification notification1 = new Notification();
        notification1.setNotificationDesc("notificationDesc");
        notification1.setKmFileManagerID(0);
        final KMFileManager kmFileManager2 = new KMFileManager();
        notification1.setKmFileManager(kmFileManager2);
        workingLocation.setNotifications(List.of(notification1));

        final Language language = new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath");
        final User user = new User();
        user.setUserID(0L);
        user.setTitleID(0);
        user.setFirstName("firstName");
        user.setMiddleName("middleName");
        user.setLastName("lastName");

        // Run the test
        final Notification result = Notification.initializeNotification(0, "notification", "notificationDesc", 0,
                notificationType, 0, role, 0, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), false, 0, kmFileManager1, 0,
                workingLocation, 0, language, 0, user);
        assertThat(result.toString()).isEqualTo("result");
        assertThat(result.getProviderServiceMapID()).isEqualTo(0);
        assertThat(result.getRoleID()).isEqualTo(0);
        assertThat(result.getNotificationID()).isEqualTo(0);
        assertThat(result.getNotification()).isEqualTo("notification");
        assertThat(result.getNotificationDesc()).isEqualTo("notificationDesc");
        assertThat(result.getNotificationTypeID()).isEqualTo(0);
        assertThat(result.getValidTill()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getValidFrom()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getCreatedBy()).isEqualTo("createdBy");
        assertThat(result.getCreatedDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getModifiedBy()).isEqualTo("modifiedBy");
        assertThat(result.getLastModDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getRoleIDs()).isEqualTo(List.of(0));
        assertThat(result.getKmFileManagerID()).isEqualTo(0);
        assertThat(result.getKmFileManager()).isEqualTo(new KMFileManager());
        assertThat(result.getValidStartDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getValidEndDate()).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        assertThat(result.getLanguageID()).isEqualTo(0);
        assertThat(result.getLanguageIDs()).isEqualTo(List.of(0));
        assertThat(result.getUserID()).isEqualTo(0);
        assertThat(result.getWorkingLocationID()).isEqualTo(0);
        assertThat(result.getWorkingLocationIDs()).isEqualTo(List.of(0));
        assertThat(result.getUserIDs()).isEqualTo(List.of(0));
        assertThat(result.getNotificationType()).isEqualTo(new NotificationType());
        assertThat(result.getRole()).isEqualTo(new Role());
        assertThat(result.getProviderServiceMapping()).isEqualTo(new ProviderServiceMapping(false, 0));
        assertThat(result.getUserNotificationMappings()).isEqualTo(List.of(new UserNotificationMapping()));
        assertThat(result.getWorkingLocation()).isEqualTo(new WorkLocation());
        assertThat(result.getLanguage())
                .isEqualTo(new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
        assertThat(result.getUser()).isEqualTo(new User());
        assertThat(result.getKmFilePath()).isEqualTo("kmFilePath");
        assertThat(result.getOutputMapper()).isEqualTo(new OutputMapper());
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isEqualTo(0);
    }

    @Test
    void testKmFilePathGetterAndSetter() {
        final String kmFilePath = "kmFilePath";
        notificationUnderTest.setKMFilePath(kmFilePath);
        assertThat(notificationUnderTest.getKmFilePath()).isEqualTo(kmFilePath);
    }

    @Test
    void testLanguageIDGetterAndSetter() {
        final Integer languageID = 0;
        notificationUnderTest.setLanguageID(languageID);
        assertThat(notificationUnderTest.getLanguageID()).isEqualTo(languageID);
    }

    @Test
    void testLanguageIDsGetterAndSetter() {
        final List<Integer> languageIDs = List.of(0);
        notificationUnderTest.setLanguageIDs(languageIDs);
        assertThat(notificationUnderTest.getLanguageIDs()).isEqualTo(languageIDs);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Integer userID = 0;
        notificationUnderTest.setUserID(userID);
        assertThat(notificationUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testWorkingLocationIDGetterAndSetter() {
        final Integer workingLocationID = 0;
        notificationUnderTest.setWorkingLocationID(workingLocationID);
        assertThat(notificationUnderTest.getWorkingLocationID()).isEqualTo(workingLocationID);
    }

    @Test
    void testWorkingLocationIDsGetterAndSetter() {
        final List<Integer> workingLocationIDs = List.of(0);
        notificationUnderTest.setWorkingLocationIDs(workingLocationIDs);
        assertThat(notificationUnderTest.getWorkingLocationIDs()).isEqualTo(workingLocationIDs);
    }

    @Test
    void testUserIDsGetterAndSetter() {
        final List<Integer> userIDs = List.of(0);
        notificationUnderTest.setUserIDs(userIDs);
        assertThat(notificationUnderTest.getUserIDs()).isEqualTo(userIDs);
    }

    @Test
    void testNotificationTypeGetterAndSetter() {
        final NotificationType notificationType = new NotificationType();
        notificationUnderTest.setNotificationType(notificationType);
        assertThat(notificationUnderTest.getNotificationType()).isEqualTo(notificationType);
    }

    @Test
    void testRoleGetterAndSetter() {
        final Role role = new Role();
        notificationUnderTest.setRole(role);
        assertThat(notificationUnderTest.getRole()).isEqualTo(role);
    }

    @Test
    void testProviderServiceMappingGetterAndSetter() {
        final ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping(false, 0);
        notificationUnderTest.setProviderServiceMapping(providerServiceMapping);
        assertThat(notificationUnderTest.getProviderServiceMapping()).isEqualTo(providerServiceMapping);
    }

    @Test
    void testUserNotificationMappingsGetterAndSetter() {
        final List<UserNotificationMapping> userNotificationMappings = List.of(new UserNotificationMapping());
        notificationUnderTest.setUserNotificationMappings(userNotificationMappings);
        assertThat(notificationUnderTest.getUserNotificationMappings()).isEqualTo(userNotificationMappings);
    }

    @Test
    void testWorkingLocationGetterAndSetter() {
        final WorkLocation workingLocation = new WorkLocation();
        notificationUnderTest.setWorkingLocation(workingLocation);
        assertThat(notificationUnderTest.getWorkingLocation()).isEqualTo(workingLocation);
    }

    @Test
    void testLanguageGetterAndSetter() {
        final Language language = new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath");
        notificationUnderTest.setLanguage(language);
        assertThat(notificationUnderTest.getLanguage()).isEqualTo(language);
    }

    @Test
    void testUserGetterAndSetter() {
        final User user = new User();
        notificationUnderTest.setUser(user);
        assertThat(notificationUnderTest.getUser()).isEqualTo(user);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        notificationUnderTest.setOutputMapper(outputMapper);
        assertThat(notificationUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(notificationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(notificationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(notificationUnderTest.hashCode()).isEqualTo(0);
    }
}
