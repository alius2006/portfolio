package org.cucumberWiremock.api.steps;

import org.cucumberWiremock.api.definitions.WebhooksApi;
import org.cucumberWiremock.dto.WebhookDto;
import org.cucumberWiremock.utils.RetrofitUtils;
import retrofit2.Response;

public class WebhooksApiSteps {

    public static final String BASE_URL = "https://webhook.site";
    public static final WebhooksApi webhooksApi = RetrofitUtils.getRetrofit(BASE_URL).create(WebhooksApi.class);

    public static Response<WebhookDto> createWebhook() {
        return (Response<WebhookDto>) RetrofitUtils.executeCall(
                webhooksApi.createWebhook()
        );
    }
}
