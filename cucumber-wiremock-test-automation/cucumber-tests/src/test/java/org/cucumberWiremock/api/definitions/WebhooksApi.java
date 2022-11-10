package org.cucumberWiremock.api.definitions;

import org.cucumberWiremock.dto.WebhookDto;
import retrofit2.Call;
import retrofit2.http.POST;

public interface WebhooksApi {

    @POST("/token")
    Call<WebhookDto> createWebhook();
}
