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
class NoteTest {

	@InjectMocks
    private Note noteUnderTest;

    @BeforeEach
    void setUp() {
        noteUnderTest = new Note();
    }

    @Test
    void testUserIdGetterAndSetter() {
        final Integer userId = 0;
        noteUnderTest.setUserId(userId);
        assertThat(noteUnderTest.getUserId()).isEqualTo(userId);
    }

    @Test
    void testUserDescriptionGetterAndSetter() {
        final String userDescription = "userDescription";
        noteUnderTest.setUserDescription(userDescription);
        assertThat(noteUnderTest.getUserDescription()).isEqualTo(userDescription);
    }

    @Test
    void testActionTakenGetterAndSetter() {
        final String actionTaken = "actionTaken";
        noteUnderTest.setActionTaken(actionTaken);
        assertThat(noteUnderTest.getActionTaken()).isEqualTo(actionTaken);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        noteUnderTest.setComments(comments);
        assertThat(noteUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        noteUnderTest.setCategory(category);
        assertThat(noteUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "subCategory";
        noteUnderTest.setSubCategory(subCategory);
        assertThat(noteUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testTimestampGetterAndSetter() {
        final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        noteUnderTest.setTimestamp(timestamp);
        assertThat(noteUnderTest.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final Timestamp dateOfAction = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        noteUnderTest.setDateOfAction(dateOfAction);
        assertThat(noteUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }
}
