package org.cucumberWiremock.steps;

import com.google.gson.Gson;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumberWiremock.api.steps.WebhooksApiSteps;
import org.cucumberWiremock.api.steps.WireMockApiSteps;
import org.cucumberWiremock.dto.MappingDto;
import org.cucumberWiremock.dto.MappingsDto;
import org.cucumberWiremock.dto.WebhookDto;
import org.junit.jupiter.api.Assertions;
import retrofit2.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class WireMockSteps {

    public static final String defaultMappingId = "5be77c6a-e43a-4e24-b4f7-e4a3000e2af5";
    public static final String defaultWebhookMockUuid = "33658ee2-7250-4847-a2a1-c2252e11c111";
    public static final String defaultWebhookIp = "88.103.230.194";
    private static final String recordingProxyBaseUrl = WebhooksApiSteps.BASE_URL;
    private Response<WebhookDto> createWebhookResponse;
    Response<MappingDto> startSnapshottingResponse;
    private String createdToken;

    @Given("Delete mappings")
    public void deleteMappings() {
        Response<Void> response = WireMockApiSteps.deleteMappings();
        Assertions.assertEquals(200, response.code());
    }

    @Given("Delete requests")
    public void deleteRequests() {
        Response<Void> response = WireMockApiSteps.deleteRequests();
        Assertions.assertEquals(200, response.code());
    }

    @Given("Create stub in WireMock")
    public void createDefaultStub() {
        InputStream file;
        MappingDto mapping;
        try {
            file = new FileInputStream("src/test/resources/stub.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            mapping = new ObjectMapper().readValue(file, MappingDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Response<MappingDto> createStubResponse = WireMockApiSteps.createMapping(mapping);

        Assertions.assertEquals(201, createStubResponse.code());
        Assertions.assertNotNull(createStubResponse.body());
        Assertions.assertEquals(WireMockSteps.defaultMappingId, createStubResponse.body().id);
        Assertions.assertEquals(WireMockSteps.defaultMappingId, createStubResponse.body().uuid);
        WebhookDto webhook = new Gson().fromJson(createStubResponse.body().response.body, WebhookDto.class);
        Assertions.assertEquals(WireMockSteps.defaultWebhookMockUuid, webhook.uuid);
        Assertions.assertEquals(WireMockSteps.defaultWebhookIp, webhook.ip);
    }

    @Given("Verify that mapping has the same values")
    public void verifyDefaultMapping() {
        Response<MappingsDto> getMappingsResponse = WireMockApiSteps.getMappings();
        Assertions.assertEquals(200, getMappingsResponse.code());
        Assertions.assertNotNull(getMappingsResponse.body());
        Assertions.assertEquals(1, getMappingsResponse.body().meta.total);
        Assertions.assertEquals(1, getMappingsResponse.body().mappings.size());
        Assertions.assertEquals(defaultMappingId, getMappingsResponse.body().mappings.get(0).id);
        final String mockBody = getMappingsResponse.body().mappings.get(0).response.body;
        WebhookDto webhook = new Gson().fromJson(mockBody, WebhookDto.class);
        Assertions.assertEquals(defaultWebhookMockUuid, webhook.uuid);
        Assertions.assertEquals(defaultWebhookIp, webhook.ip);
    }

    @When("Send request to create a webhook on webhook.site")
    public void createWebhook() {
        this.createWebhookResponse = WireMockApiSteps.createWebhook();
    }

    @Then("Verify that the response has the stubbed values")
    public void verifyStubbedResponse() {
        Assertions.assertEquals(201, this.createWebhookResponse.code());
        Assertions.assertNotNull(this.createWebhookResponse.body());
        Assertions.assertEquals(defaultWebhookMockUuid, this.createWebhookResponse.body().uuid);
        Assertions.assertEquals(defaultWebhookIp, this.createWebhookResponse.body().ip);
    }

    @When("Start snapshotting")
    public void startSnapshotting() {
        startSnapshottingResponse = WireMockApiSteps.startSnapshotting(recordingProxyBaseUrl);
        Assertions.assertEquals(201, this.startSnapshottingResponse.code());
        Assertions.assertNotNull(this.startSnapshottingResponse.body());
    }

    @When("Save snapshots as mappings")
    public void saveSnapshotsAsMappings() {
        WireMockApiSteps.saveSnapshotAsMapping();
    }

    @Then("Verify redirected response from webhook.site")
    public void verifyNewWebhook() {
        Assertions.assertEquals(201, this.createWebhookResponse.code());
        Assertions.assertNotNull(this.createWebhookResponse.body());
        Assertions.assertNotNull(this.createWebhookResponse.body().uuid);
    }

    @When("Delete mapping used for snapshot")
    public void deleteSnapshotMapping() {
        assert this.startSnapshottingResponse.body() != null;
        WireMockApiSteps.deleteMapping(this.startSnapshottingResponse.body().id);
    }

    @Then("Verify that the response was recorded")
    public void verifyAddedMapping() {
        Response<MappingsDto> response = WireMockApiSteps.getMappings();
        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(response.body());
        Assertions.assertEquals(1, response.body().meta.total);
        Assertions.assertEquals(1, response.body().mappings.size());
        MappingDto mapping = response.body().mappings.get(0);
        WebhookDto webhook = new Gson().fromJson(mapping.response.body, WebhookDto.class);
        createdToken = webhook.uuid;
    }

    @Then("Verify that the recorded response was used")
    public void verifyUsedRecording() {
        Assertions.assertEquals(201, this.createWebhookResponse.code());
        Assertions.assertNotNull(this.createWebhookResponse.body());
        Assertions.assertEquals(createdToken, this.createWebhookResponse.body().uuid);
    }


}
