package com.iemr.common.data.users;

import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmployeeSignatureTest {

	@InjectMocks
    private EmployeeSignature employeeSignatureUnderTest;

    @BeforeEach
    void setUp() {
        employeeSignatureUnderTest = new EmployeeSignature(0L, "content".getBytes(), "fileType", "fileName");
    }

    @Test
    void testToString() {
        assertThat(employeeSignatureUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testUserSignatureIDGetterAndSetter() {
        final Long userSignatureID = 0L;
        employeeSignatureUnderTest.setUserSignatureID(userSignatureID);
        assertThat(employeeSignatureUnderTest.getUserSignatureID()).isEqualTo(userSignatureID);
    }

    @Test
    void testUserIDGetterAndSetter() {
        final Long userID = 0L;
        employeeSignatureUnderTest.setUserID(userID);
        assertThat(employeeSignatureUnderTest.getUserID()).isEqualTo(userID);
    }

    @Test
    void testFileNameGetterAndSetter() {
        final String fileName = "fileName";
        employeeSignatureUnderTest.setFileName(fileName);
        assertThat(employeeSignatureUnderTest.getFileName()).isEqualTo(fileName);
    }

    @Test
    void testFileTypeGetterAndSetter() {
        final String fileType = "fileType";
        employeeSignatureUnderTest.setFileType(fileType);
        assertThat(employeeSignatureUnderTest.getFileType()).isEqualTo(fileType);
    }

    @Test
    void testFileContentGetterAndSetter() {
        final String fileContent = "fileContent";
        employeeSignatureUnderTest.setFileContent(fileContent);
        assertThat(employeeSignatureUnderTest.getFileContent()).isEqualTo(fileContent);
    }

    @Test
    void testSignatureGetterAndSetter() {
        final byte[] signature = "content".getBytes();
        employeeSignatureUnderTest.setSignature(signature);
        assertThat(employeeSignatureUnderTest.getSignature()).isEqualTo(signature);
    }

    @Test
    void testDeletedGetterAndSetter() {
        final Boolean deleted = false;
        employeeSignatureUnderTest.setDeleted(deleted);
        assertThat(employeeSignatureUnderTest.getDeleted()).isFalse();
    }

    @Test
    void testCreatedByGetterAndSetter() {
        final String createdBy = "createdBy";
        employeeSignatureUnderTest.setCreatedBy(createdBy);
        assertThat(employeeSignatureUnderTest.getCreatedBy()).isEqualTo(createdBy);
    }

    @Test
    void testCreatedDateGetterAndSetter() {
        final Timestamp createdDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        employeeSignatureUnderTest.setCreatedDate(createdDate);
        assertThat(employeeSignatureUnderTest.getCreatedDate()).isEqualTo(createdDate);
    }

    @Test
    void testModifiedByGetterAndSetter() {
        final String modifiedBy = "modifiedBy";
        employeeSignatureUnderTest.setModifiedBy(modifiedBy);
        assertThat(employeeSignatureUnderTest.getModifiedBy()).isEqualTo(modifiedBy);
    }

    @Test
    void testLastModDateGetterAndSetter() {
        final Timestamp lastModDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        employeeSignatureUnderTest.setLastModDate(lastModDate);
        assertThat(employeeSignatureUnderTest.getLastModDate()).isEqualTo(lastModDate);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        employeeSignatureUnderTest.setOutputMapper(outputMapper);
        assertThat(employeeSignatureUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(employeeSignatureUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(employeeSignatureUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(employeeSignatureUnderTest.hashCode()).isEqualTo(0);
    }
}
