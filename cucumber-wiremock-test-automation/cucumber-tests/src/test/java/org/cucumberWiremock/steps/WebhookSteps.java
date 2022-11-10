package org.cucumberWiremock.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumberWiremock.api.steps.WebhooksApiSteps;
import org.cucumberWiremock.dto.WebhookDto;
import org.junit.jupiter.api.Assertions;
import retrofit2.Response;

public class WebhookSteps {

    Response<WebhookDto> createWebhookResponse;

    @When("Send create webhook request to webhook.site")
    public void createToken() {
        this.createWebhookResponse = WebhooksApiSteps.createWebhook();
    }

    @Then("Verify response from webhook.site")
    public void verifyResponse() {
        Assertions.assertEquals(201, this.createWebhookResponse.code());
        Assertions.assertNotNull(this.createWebhookResponse.body());
        Assertions.assertNotNull(this.createWebhookResponse.body().uuid);
        Assertions.assertNotNull(this.createWebhookResponse.body().ip);
    }
}
