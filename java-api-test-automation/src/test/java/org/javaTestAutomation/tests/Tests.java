package org.javaTestAutomation.tests;

import org.javaTestAutomation.api.WebhookSiteApi;
import org.javaTestAutomation.api.WebhookSiteApi.GetRequestsResponseBody;
import org.javaTestAutomation.steps.WebhookSiteSteps;
import org.junit.Test;
import retrofit2.Response;

public class Tests extends BaseTest {

    @Test
    public void getWebhooks() {
        Response<GetRequestsResponseBody> response = webhookSiteSteps.getWebhooks();
        System.out.println();
    }
}
