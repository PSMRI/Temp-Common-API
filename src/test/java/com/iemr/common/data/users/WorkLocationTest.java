package com.iemr.common.data.users;

import com.iemr.common.data.notification.Notification;
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
class WorkLocationTest {

	@InjectMocks
    private WorkLocation workLocationUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        workLocationUnderTest = new WorkLocation();
    }

    @Test
    void testToString() throws Exception {
        assertThat(workLocationUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testPsAddMapIDGetterAndSetter() {
        final Integer psAddMapID = 0;
        workLocationUnderTest.setPsAddMapID(psAddMapID);
        assertThat(workLocationUnderTest.getPsAddMapID()).isEqualTo(psAddMapID);
    }

    @Test
    void testNotificationsGetterAndSetter() {
        final List<Notification> notifications = List.of(new Notification());
        workLocationUnderTest.setNotifications(notifications);
        assertThat(workLocationUnderTest.getNotifications()).isEqualTo(notifications);
    }

    @Test
    void testProviderServiceMapIDGetterAndSetter() throws Exception {
        final Integer providerServiceMapID = 0;
        workLocationUnderTest.setProviderServiceMapID(providerServiceMapID);
        assertThat(workLocationUnderTest.getProviderServiceMapID()).isEqualTo(providerServiceMapID);
    }

    @Test
    void testDistrictIDGetterAndSetter() {
        final Integer districtID = 0;
        workLocationUnderTest.setDistrictID(districtID);
        assertThat(workLocationUnderTest.getDistrictID()).isEqualTo(districtID);
    }

    @Test
    void testDeletedGetterAndSetter() throws Exception {
        final Boolean deleted = false;
        workLocationUnderTest.setDeleted(deleted);
        assertThat(workLocationUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testLocationNameGetterAndSetter() {
        final String locationName = "locationName";
        workLocationUnderTest.setLocationName(locationName);
        assertThat(workLocationUnderTest.getLocationName()).isEqualTo(locationName);
    }

    @Test
    void testAddressGetterAndSetter() {
        final String address = "address";
        workLocationUnderTest.setAddress(address);
        assertThat(workLocationUnderTest.getAddress()).isEqualTo(address);
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        workLocationUnderTest.setProcessed(processed);
        assertThat(workLocationUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() throws Exception {
        final String createdBy = "CreatedBy";
        workLocationUnderTest.setCreatedBy(createdBy);
        assertThat(workLocationUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testModifiedByGetterAndSetter() throws Exception {
        final String modifiedBy = "ModifiedBy";
        workLocationUnderTest.setModifiedBy(modifiedBy);
        assertThat(workLocationUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() throws Exception {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        workLocationUnderTest.setCreatedDate(createdDate);
        assertThat(workLocationUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testLastModDateGetterAndSetter() throws Exception {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        workLocationUnderTest.setLastModDate(lastModDate);
        assertThat(workLocationUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testMapperGetterAndSetter() {
        final OutputMapper mapper = new OutputMapper();
        workLocationUnderTest.setMapper(mapper);
        assertThat(workLocationUnderTest.getMapper()).isEqualTo(mapper);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(workLocationUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(workLocationUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(workLocationUnderTest.hashCode()).isEqualTo(0);
    }
}
