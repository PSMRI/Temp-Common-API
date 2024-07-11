package com.iemr.common.data.everwell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EverwellFeedbackTest {

	@InjectMocks
    private EverwellFeedback everwellFeedbackUnderTest;

    @BeforeEach
    void setUp() {
        everwellFeedbackUnderTest = new EverwellFeedback();
    }

    @Test
    void testEfidGetterAndSetter() {
        final Long efid = 0L;
        everwellFeedbackUnderTest.setEfid(efid);
        assertThat(everwellFeedbackUnderTest.getEfid()).isEqualTo(efid);
    }

    @Test
    void testEapiIdGetterAndSetter() {
        final Long eapiId = 0L;
        everwellFeedbackUnderTest.setEapiId(eapiId);
        assertThat(everwellFeedbackUnderTest.getEapiId()).isEqualTo(eapiId);
    }

    @Test
    void testIdGetterAndSetter() {
        final Long id = 0L;
        everwellFeedbackUnderTest.setId(id);
        assertThat(everwellFeedbackUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testProviderServiceMapIdGetterAndSetter() {
        final Integer providerServiceMapId = 0;
        everwellFeedbackUnderTest.setProviderServiceMapId(providerServiceMapId);
        assertThat(everwellFeedbackUnderTest.getProviderServiceMapId()).isEqualTo(providerServiceMapId);
    }

    @Test
    void testActionTakenGetterAndSetter() {
        final String actionTaken = "actionTaken";
        everwellFeedbackUnderTest.setActionTaken(actionTaken);
        assertThat(everwellFeedbackUnderTest.getActionTaken()).isEqualTo(actionTaken);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        everwellFeedbackUnderTest.setCategory(category);
        assertThat(everwellFeedbackUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "subCategory";
        everwellFeedbackUnderTest.setSubCategory(subCategory);
        assertThat(everwellFeedbackUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final Timestamp dateOfAction = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellFeedbackUnderTest.setDateOfAction(dateOfAction);
        assertThat(everwellFeedbackUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        everwellFeedbackUnderTest.setComments(comments);
        assertThat(everwellFeedbackUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testSecondaryPhoneNoGetterAndSetter() {
        final String secondaryPhoneNo = "secondaryPhoneNo";
        everwellFeedbackUnderTest.setSecondaryPhoneNo(secondaryPhoneNo);
        assertThat(everwellFeedbackUnderTest.getSecondaryPhoneNo()).isEqualTo(secondaryPhoneNo);
    }

    @Test
    void testIsManualDoseProcessedGetterAndSetter() {
        final Boolean isManualDoseProcessed = false;
        everwellFeedbackUnderTest.setIsManualDoseProcessed(isManualDoseProcessed);
        assertThat(everwellFeedbackUnderTest.getIsManualDoseProcessed()).isFalse();
    }

    @Test
    void testIsMissedDoseProcessedGetterAndSetter() {
        final Boolean isMissedDoseProcessed = false;
        everwellFeedbackUnderTest.setIsMissedDoseProcessed(isMissedDoseProcessed);
        assertThat(everwellFeedbackUnderTest.getIsMissedDoseProcessed()).isFalse();
    }

    @Test
    void testIsSupportActionProcessedGetterAndSetter() {
        final Boolean isSupportActionProcessed = false;
        everwellFeedbackUnderTest.setIsSupportActionProcessed(isSupportActionProcessed);
        assertThat(everwellFeedbackUnderTest.getIsSupportActionProcessed()).isFalse();
    }

    @Test
    void testIsMobileNumberProcessedGetterAndSetter() {
        final Boolean isMobileNumberProcessed = false;
        everwellFeedbackUnderTest.setIsMobileNumberProcessed(isMobileNumberProcessed);
        assertThat(everwellFeedbackUnderTest.getIsMobileNumberProcessed()).isFalse();
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        everwellFeedbackUnderTest.setDeleted(deleted);
        assertThat(everwellFeedbackUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testProcessedGetterAndSetter() {
        final String processed = "processed";
        everwellFeedbackUnderTest.setProcessed(processed);
        assertThat(everwellFeedbackUnderTest.getProcessed()).isEqualTo(processed);
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        everwellFeedbackUnderTest.setCreatedBy(createdBy);
        assertThat(everwellFeedbackUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellFeedbackUnderTest.setCreatedDate(createdDate);
        assertThat(everwellFeedbackUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        everwellFeedbackUnderTest.setModifiedBy(modifiedBy);
        assertThat(everwellFeedbackUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        everwellFeedbackUnderTest.setLastModDate(lastModDate);
        assertThat(everwellFeedbackUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testIsCompletedGetterAndSetter() {
        final Boolean isCompleted = false;
        everwellFeedbackUnderTest.setIsCompleted(isCompleted);
        assertThat(everwellFeedbackUnderTest.getIsCompleted()).isFalse();
    }

    @Test
    void testEquals() {
        assertThat(everwellFeedbackUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(everwellFeedbackUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(everwellFeedbackUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(everwellFeedbackUnderTest.toString()).isEqualTo("result");
    }
}
