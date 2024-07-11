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
class AddSupportActionTest {

	@InjectMocks
    private AddSupportAction addSupportActionUnderTest;

    @BeforeEach
    void setUp() {
        addSupportActionUnderTest = new AddSupportAction();
    }

    @Test
    void testCategoryGetterAndSetter() {
        final String category = "category";
        addSupportActionUnderTest.setCategory(category);
        assertThat(addSupportActionUnderTest.getCategory()).isEqualTo(category);
    }

    @Test
    void testActionTakenGetterAndSetter() {
        final String actionTaken = "actionTaken";
        addSupportActionUnderTest.setActionTaken(actionTaken);
        assertThat(addSupportActionUnderTest.getActionTaken()).isEqualTo(actionTaken);
    }

    @Test
    void testCommentsGetterAndSetter() {
        final String comments = "comments";
        addSupportActionUnderTest.setComments(comments);
        assertThat(addSupportActionUnderTest.getComments()).isEqualTo(comments);
    }

    @Test
    void testSubCategoryGetterAndSetter() {
        final String subCategory = "subCategory";
        addSupportActionUnderTest.setSubCategory(subCategory);
        assertThat(addSupportActionUnderTest.getSubCategory()).isEqualTo(subCategory);
    }

    @Test
    void testDateOfActionGetterAndSetter() {
        final Timestamp dateOfAction = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        addSupportActionUnderTest.setDateOfAction(dateOfAction);
        assertThat(addSupportActionUnderTest.getDateOfAction()).isEqualTo(dateOfAction);
    }
}
