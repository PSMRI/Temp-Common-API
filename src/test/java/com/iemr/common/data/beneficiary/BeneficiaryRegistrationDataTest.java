package com.iemr.common.data.beneficiary;

import com.iemr.common.data.callhandling.CallType;
import com.iemr.common.data.directory.Directory;
import com.iemr.common.data.location.States;
import com.iemr.common.data.userbeneficiarydata.*;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BeneficiaryRegistrationDataTest {

	
	@InjectMocks
    private BeneficiaryRegistrationData beneficiaryRegistrationDataUnderTest;


	@Test
	void testToString() {
	    BeneficiaryRegistrationData beneficiaryRegistrationData = new BeneficiaryRegistrationData();
	    String expectedJson = "{\"m_Title\":null,\"m_Status\":null,\"i_BeneficiaryEducation\":null,\"states\":null,\"m_genders\":null,\"m_maritalStatuses\":null,\"m_communities\":null,\"m_language\":null,\"directory\":null,\"sexualOrientations\":null,\"callTypes\":null,\"benRelationshipTypes\":null,\"beneficiaryOccupations\":null,\"govtIdentityTypes\":null}";
	    assertThat(beneficiaryRegistrationData.toString()).isEqualTo(expectedJson);
	}

    @Test
    void testM_TitleGetterAndSetter() {
        final List<Title> m_Title = List.of(new Title());
        beneficiaryRegistrationDataUnderTest.setM_Title(m_Title);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_Title()).isEqualTo(m_Title);
    }

    @Test
    void testM_StatusGetterAndSetter() {
        final List<Status> m_Status = List.of(new Status());
        beneficiaryRegistrationDataUnderTest.setM_Status(m_Status);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_Status()).isEqualTo(m_Status);
    }

    @Test
    void testI_BeneficiaryEducationGetterAndSetter() {
        final List<BeneficiaryEducation> i_BeneficiaryEducation = List.of(
                new BeneficiaryEducation(0L, "educationType"));
        beneficiaryRegistrationDataUnderTest.setI_BeneficiaryEducation(i_BeneficiaryEducation);
        assertThat(beneficiaryRegistrationDataUnderTest.getI_BeneficiaryEducation()).isEqualTo(i_BeneficiaryEducation);
    }

    @Test
    void testStatesGetterAndSetter() {
        final List<States> states = List.of(new States());
        beneficiaryRegistrationDataUnderTest.setStates(states);
        assertThat(beneficiaryRegistrationDataUnderTest.getStates()).isEqualTo(states);
    }

    @Test
    void testM_gendersGetterAndSetter() {
        final List<Gender> m_genders = List.of(new Gender());
        beneficiaryRegistrationDataUnderTest.setM_genders(m_genders);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_genders()).isEqualTo(m_genders);
    }

    @Test
    void testM_maritalStatusesGetterAndSetter() {
        final List<MaritalStatus> m_maritalStatuses = List.of(new MaritalStatus());
        beneficiaryRegistrationDataUnderTest.setM_maritalStatuses(m_maritalStatuses);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_maritalStatuses()).isEqualTo(m_maritalStatuses);
    }

    @Test
    void testM_communitiesGetterAndSetter() {
        final List<Community> m_communities = List.of(new Community());
        beneficiaryRegistrationDataUnderTest.setM_communities(m_communities);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_communities()).isEqualTo(m_communities);
    }

    @Test
    void testM_languageGetterAndSetter() {
        final List<Language> m_language = List.of(
                new Language(0, "languageName", "languageDesc", "propertyFilePath", "IVRFilePath"));
        beneficiaryRegistrationDataUnderTest.setM_language(m_language);
        assertThat(beneficiaryRegistrationDataUnderTest.getM_language()).isEqualTo(m_language);
    }

    @Test
    void testDirectoryGetterAndSetter() {
        final List<Directory> directory = List.of(new Directory(0, "directoryName"));
        beneficiaryRegistrationDataUnderTest.setDirectory(directory);
        assertThat(beneficiaryRegistrationDataUnderTest.getDirectory()).isEqualTo(directory);
    }

    @Test
    void testSexualOrientationsGetterAndSetter() {
        final List<SexualOrientation> sexualOrientations = List.of(
                new SexualOrientation((short) 0, "sexualOrientation"));
        beneficiaryRegistrationDataUnderTest.setSexualOrientations(sexualOrientations);
        assertThat(beneficiaryRegistrationDataUnderTest.getSexualOrientations()).isEqualTo(sexualOrientations);
    }

    @Test
    void testCallTypesGetterAndSetter() {
        final List<CallType> callTypes = List.of(new CallType());
        beneficiaryRegistrationDataUnderTest.setCallTypes(callTypes);
        assertThat(beneficiaryRegistrationDataUnderTest.getCallTypes()).isEqualTo(callTypes);
    }

    @Test
    void testBenRelationshipTypesGetterAndSetter() {
        final List<BenRelationshipType> benRelationshipTypes = List.of(
                new BenRelationshipType(0, "benRelationshipType", false));
        beneficiaryRegistrationDataUnderTest.setBenRelationshipTypes(benRelationshipTypes);
        assertThat(beneficiaryRegistrationDataUnderTest.getBenRelationshipTypes()).isEqualTo(benRelationshipTypes);
    }

    @Test
    void testBeneficiaryOccupationsGetterAndSetter() {
        final List<BeneficiaryOccupation> beneficiaryOccupations = List.of(new BeneficiaryOccupation());
        beneficiaryRegistrationDataUnderTest.setBeneficiaryOccupations(beneficiaryOccupations);
        assertThat(beneficiaryRegistrationDataUnderTest.getBeneficiaryOccupations()).isEqualTo(beneficiaryOccupations);
    }

    @Test
    void testGovtIdentityTypesGetterAndSetter() {
        final List<GovtIdentityType> govtIdentityTypes = List.of(new GovtIdentityType());
        beneficiaryRegistrationDataUnderTest.setGovtIdentityTypes(govtIdentityTypes);
        assertThat(beneficiaryRegistrationDataUnderTest.getGovtIdentityTypes()).isEqualTo(govtIdentityTypes);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        beneficiaryRegistrationDataUnderTest.setOutputMapper(outputMapper);
        assertThat(beneficiaryRegistrationDataUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testEquals() {
        assertThat(beneficiaryRegistrationDataUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(beneficiaryRegistrationDataUnderTest.canEqual("other")).isFalse();
    }

}
