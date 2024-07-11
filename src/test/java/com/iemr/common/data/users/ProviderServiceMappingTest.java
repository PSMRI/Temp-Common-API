package com.iemr.common.data.users;

import com.iemr.common.data.callhandling.PhoneBlock;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.feedback.FeedbackSeverity;
import com.iemr.common.data.feedback.FeedbackType;
import com.iemr.common.data.notification.EmergencyContacts;
import com.iemr.common.data.notification.Notification;
import com.iemr.common.data.userbeneficiarydata.Status;
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
class ProviderServiceMappingTest {

	@InjectMocks
    private ProviderServiceMapping providerServiceMappingUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        providerServiceMappingUnderTest = new ProviderServiceMapping(false, 0);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() {
        final Integer providerServiceMapID = 0;
        providerServiceMappingUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(providerServiceMappingUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testCtiCampaignNameGetterAndSetter() {
        final String ctiCampaignName = "ctiCampaignName";
        providerServiceMappingUnderTest.setCtiCampaignName(ctiCampaignName);
        assertThat(providerServiceMappingUnderTest.getCtiCampaignName()).isEqualTo(ctiCampaignName);
    }

    @Test
    void testStateIDGetterAndSetter() {
        final Integer stateID = 0;
        providerServiceMappingUnderTest.setStateID(stateID);
        assertThat(providerServiceMappingUnderTest.getStateID()).isEqualTo(stateID);
    }

    @Test
    void testToString() throws Exception {
        assertThat(providerServiceMappingUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testM_UserServiceRoleMappingsGetterAndSetter() {
        final List<UserServiceRoleMapping> m_UserServiceRoleMappings = List.of(new UserServiceRoleMapping());
        providerServiceMappingUnderTest.setM_UserServiceRoleMappings(m_UserServiceRoleMappings);
        assertThat(providerServiceMappingUnderTest.getM_UserServiceRoleMappings()).isEqualTo(m_UserServiceRoleMappings);
    }

    @Test
    void testNotificationsGetterAndSetter() {
        final List<Notification> notifications = List.of(new Notification());
        providerServiceMappingUnderTest.setNotifications(notifications);
        assertThat(providerServiceMappingUnderTest.getNotifications()).isEqualTo(notifications);
    }

    @Test
    void testServiceRoleScreenMappingGetterAndSetter() {
        final List<ServiceRoleScreenMapping> serviceRoleScreenMapping = List.of(new ServiceRoleScreenMapping());
        providerServiceMappingUnderTest.setServiceRoleScreenMapping(serviceRoleScreenMapping);
        assertThat(providerServiceMappingUnderTest.getServiceRoleScreenMapping()).isEqualTo(serviceRoleScreenMapping);
    }

    @Test
    void testScreensGetterAndSetter() {
        final List<Screen> screens = List.of(new Screen());
        providerServiceMappingUnderTest.setScreens(screens);
        assertThat(providerServiceMappingUnderTest.getScreens()).isEqualTo(screens);
    }

    @Test
    void testDirectoriesGetterAndSetter() {
        final List<Directory> directories = List.of(new Directory(0, "directoryName"));
        providerServiceMappingUnderTest.setDirectories(directories);
        assertThat(providerServiceMappingUnderTest.getDirectories()).isEqualTo(directories);
    }

    @Test
    void testFeedbacksGetterAndSetter() {
        final List<FeedbackType> feedbacks = List.of(new FeedbackType(0, "feedbackTypeName"));
        providerServiceMappingUnderTest.setFeedbacks(feedbacks);
        assertThat(providerServiceMappingUnderTest.getFeedbacks()).isEqualTo(feedbacks);
    }

    @Test
    void testFeedbackSeveritiesGetterAndSetter() {
        final List<FeedbackSeverity> feedbackSeverities = List.of(new FeedbackSeverity(0, "severityTypeName"));
        providerServiceMappingUnderTest.setFeedbackSeverities(feedbackSeverities);
        assertThat(providerServiceMappingUnderTest.getFeedbackSeverities()).isEqualTo(feedbackSeverities);
    }

    @Test
    void testEmergencyContactsGetterAndSetter() {
        final List<EmergencyContacts> emergencyContacts = List.of(new EmergencyContacts());
        providerServiceMappingUnderTest.setEmergencyContacts(emergencyContacts);
        assertThat(providerServiceMappingUnderTest.getEmergencyContacts()).isEqualTo(emergencyContacts);
    }

    @Test
    void testBlockNumbersGetterAndSetter() {
        final List<PhoneBlock> blockNumbers = List.of(new PhoneBlock());
        providerServiceMappingUnderTest.setBlockNumbers(blockNumbers);
        assertThat(providerServiceMappingUnderTest.getBlockNumbers()).isEqualTo(blockNumbers);
    }

    @Test
    void testServiceProviderIDGetterAndSetter() {
        final Short serviceProviderID = (short) 0;
        providerServiceMappingUnderTest.setServiceProviderID(serviceProviderID);
        assertThat(providerServiceMappingUnderTest.getServiceProviderID()).isEqualTo(serviceProviderID);
    }

    @Test
    void testServiceProviderGetterAndSetter() {
        final ServiceProvider serviceProvider = new ServiceProvider();
        providerServiceMappingUnderTest.setServiceProvider(serviceProvider);
        assertThat(providerServiceMappingUnderTest.getServiceProvider()).isEqualTo(serviceProvider);
    }

    @Test
    void testServiceIDGetterAndSetter() {
        final Short serviceID = (short) 0;
        providerServiceMappingUnderTest.setServiceID(serviceID);
        assertThat(providerServiceMappingUnderTest.getServiceID()).isEqualTo(serviceID);
    }

    @Test
    void testM_ServiceMasterGetterAndSetter() {
        final ServiceMaster m_ServiceMaster = new ServiceMaster();
        providerServiceMappingUnderTest.setM_ServiceMaster(m_ServiceMaster);
        assertThat(providerServiceMappingUnderTest.getM_ServiceMaster()).isEqualTo(m_ServiceMaster);
    }

    @Test
    void testCountryIDGetterAndSetter() {
        final Integer countryID = 0;
        providerServiceMappingUnderTest.setCountryID(countryID);
        assertThat(providerServiceMappingUnderTest.getCountryID()).isEqualTo(countryID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        providerServiceMappingUnderTest.setDistrictID(districtID);
        assertThat(providerServiceMappingUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testCityIDGetterAndSetter() {
        final Integer cityID = 0;
        providerServiceMappingUnderTest.setCityID(cityID);
        assertThat(providerServiceMappingUnderTest.getCityID()).isEqualTo(cityID);
    }

    @Test
    void testDistrictBlockIDGetterAndSetter() {
        final Integer districtBlockID = 0;
        providerServiceMappingUnderTest.setDistrictBlockID(districtBlockID);
        assertThat(providerServiceMappingUnderTest.getDistrictBlockID()).isEqualTo(districtBlockID);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        providerServiceMappingUnderTest.setAddress(address);
        assertThat(providerServiceMappingUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        providerServiceMappingUnderTest.setDeleted(deleted);
        assertThat(providerServiceMappingUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        providerServiceMappingUnderTest.setCreatedBy(createdBy);
        assertThat(providerServiceMappingUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        providerServiceMappingUnderTest.setCreatedDate(createdDate);
        assertThat(providerServiceMappingUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        providerServiceMappingUnderTest.setModifiedBy(modifiedBy);
        assertThat(providerServiceMappingUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        providerServiceMappingUnderTest.setLastModDate(lastModDate);
        assertThat(providerServiceMappingUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testStatusIDGetterAndSetter() {
        final Integer statusID = 0;
        providerServiceMappingUnderTest.setStatusID(statusID);
        assertThat(providerServiceMappingUnderTest.getStatusID()).isEqualTo(statusID);
    }

    @Test
    void testAPIMANClientIDGetterAndSetter() {
        final String aPIMANClientID = "aPIMANClientID";
        providerServiceMappingUnderTest.setAPIMANClientID(aPIMANClientID);
        assertThat(providerServiceMappingUnderTest.getAPIMANClientID()).isEqualTo(aPIMANClientID);
    }

    @Test
    void testAPIMANClientKeyGetterAndSetter() {
        final String aPIMANClientKey = "aPIMANClientKey";
        providerServiceMappingUnderTest.setAPIMANClientKey(aPIMANClientKey);
        assertThat(providerServiceMappingUnderTest.getAPIMANClientKey()).isEqualTo(aPIMANClientKey);
    }

    @Test
    void testStatusGetterAndSetter() {
        final Status status = new Status();
        providerServiceMappingUnderTest.setStatus(status);
        assertThat(providerServiceMappingUnderTest.getStatus()).isEqualTo(status);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        providerServiceMappingUnderTest.setOutputMapper(outputMapper);
        assertThat(providerServiceMappingUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testIsDialPreferenceManualGetterAndSetter() {
        final Boolean isDialPreferenceManual = false;
        providerServiceMappingUnderTest.setIsDialPreferenceManual(isDialPreferenceManual);
        assertThat(providerServiceMappingUnderTest.getIsDialPreferenceManual()).isFalse();
    }

    @Test
    void testPreviewWindowTimeGetterAndSetter() {
        final Integer previewWindowTime = 0;
        providerServiceMappingUnderTest.setPreviewWindowTime(previewWindowTime);
        assertThat(providerServiceMappingUnderTest.getPreviewWindowTime()).isEqualTo(previewWindowTime);
    }

    @Test
    void testEquals() {
        assertThat(providerServiceMappingUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(providerServiceMappingUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(providerServiceMappingUnderTest.hashCode()).isEqualTo(0);
    }
}
