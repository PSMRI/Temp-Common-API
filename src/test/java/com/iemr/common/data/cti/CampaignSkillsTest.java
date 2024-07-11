package com.iemr.common.data.cti;

import com.google.gson.JsonArray;
import com.iemr.common.utils.mapper.OutputMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CampaignSkillsTest {

    private CampaignSkills campaignSkillsUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        campaignSkillsUnderTest = new CampaignSkills();
    }

    @Test
    void testCampaign_nameGetterAndSetter() {
        final String campaign_name = "campaign_name";
        campaignSkillsUnderTest.setCampaign_name(campaign_name);
        assertThat(campaignSkillsUnderTest.getCampaignName()).isEqualTo(campaign_name);
    }

    @Test
    void testResponseGetterAndSetter() {
        final CTIResponse response = new CTIResponse();
        campaignSkillsUnderTest.setResponse(response);
        assertThat(campaignSkillsUnderTest.getResponse()).isEqualTo(response);
    }

    @Test
    void testToString() throws Exception {
        assertThat(campaignSkillsUnderTest.toString()).isEqualTo("result");
    }

    @Test
    void testGetLogger() {
        assertThat(campaignSkillsUnderTest.getLogger()).isEqualTo(campaignSkillsUnderTest.logger);
    }

    @Test
    void testOutputMapperGetterAndSetter() {
        final OutputMapper outputMapper = new OutputMapper();
        campaignSkillsUnderTest.setOutputMapper(outputMapper);
        assertThat(campaignSkillsUnderTest.getOutputMapper()).isEqualTo(outputMapper);
    }

    @Test
    void testCampaign_name1GetterAndSetter() {
        final String campaign_name = "campaign_name";
        campaignSkillsUnderTest.setCampaign_name(campaign_name);
        assertThat(campaignSkillsUnderTest.getCampaign_name()).isEqualTo(campaign_name);
    }

    @Test
    void testCampaignGetterAndSetter() {
        final String campaign = "campaign";
        campaignSkillsUnderTest.setCampaign(campaign);
        assertThat(campaignSkillsUnderTest.getCampaign()).isEqualTo(campaign);
    }

    @Test
    void testWeightageGetterAndSetter() {
        final String weightage = "weightage";
        campaignSkillsUnderTest.setWeightage(weightage);
        assertThat(campaignSkillsUnderTest.getWeightage()).isEqualTo(weightage);
    }

    @Test
    void testSkillsGetterAndSetter() {
        final JsonArray skills = new JsonArray(0);
        campaignSkillsUnderTest.setSkills(skills);
        assertThat(campaignSkillsUnderTest.getSkills()).isEqualTo(skills);
    }

    @Test
    void testCampaignskillsGetterAndSetter() {
        final JsonArray campaignskills = new JsonArray(0);
        campaignSkillsUnderTest.setCampaignskills(campaignskills);
        assertThat(campaignSkillsUnderTest.getCampaignskills()).isEqualTo(campaignskills);
    }

    @Test
    void testEquals() throws Exception {
        assertThat(campaignSkillsUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() throws Exception {
        assertThat(campaignSkillsUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() throws Exception {
        assertThat(campaignSkillsUnderTest.hashCode()).isEqualTo(0);
    }
}
