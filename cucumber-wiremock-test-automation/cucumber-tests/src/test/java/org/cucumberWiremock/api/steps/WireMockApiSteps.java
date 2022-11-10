package org.cucumberWiremock.api.steps;

import org.cucumberWiremock.api.definitions.WebhooksApi;
import org.cucumberWiremock.api.definitions.WireMockApi;
import org.cucumberWiremock.dto.*;
import org.cucumberWiremock.utils.RetrofitUtils;
import retrofit2.Response;

public class WireMockApiSteps {

    public static final String BASE_URL = "http://localhost:8081";
    public static final WebhooksApi mockedWebhooksApi = RetrofitUtils.getRetrofit(BASE_URL).create(WebhooksApi.class);
    public static final WireMockApi wireMocksApi = RetrofitUtils.getRetrofit(BASE_URL).create(WireMockApi.class);

    public static Response<WebhookDto> createWebhook() {
        return (Response<WebhookDto>) RetrofitUtils.executeCall(
                mockedWebhooksApi.createWebhook()
        );
    }

    public static Response<MappingsDto> getMappings() {
        return (Response<MappingsDto>) RetrofitUtils.executeCall(
                wireMocksApi.getMappings()
        );
    }

    public static Response<MappingDto> startSnapshotting(String proxyBaseUrl) {
        StartSnapshottingSettingsDto startSnapshottingSettings = new StartSnapshottingSettingsDto();
        startSnapshottingSettings.priority = 1;
        startSnapshottingSettings.request = new StartSnapshottingSettingsDto.Request();
        startSnapshottingSettings.request.method = "ANY";
        startSnapshottingSettings.response = new StartSnapshottingSettingsDto.Response();
        startSnapshottingSettings.response.proxyBaseUrl = proxyBaseUrl;

        return (Response<MappingDto>) RetrofitUtils.executeCall(
                wireMocksApi.startSnapshotting(startSnapshottingSettings)
        );
    }

    public static Response<Void> saveSnapshotAsMapping() {
        SnapshotSettingsDto snapshot = new SnapshotSettingsDto();
        snapshot.persist = false;
        return (Response<Void>) RetrofitUtils.executeCall(
                wireMocksApi.saveSnapshotsAsMappings(snapshot)
        );
    }

    public static Response<MappingDto> createMapping(MappingDto mapping) {
        return (Response<MappingDto>) RetrofitUtils.executeCall(
                wireMocksApi.createMapping(mapping)
        );
    }

    public static Response<Void> deleteMappings() {
        return (Response<Void>) RetrofitUtils.executeCall(
                wireMocksApi.deleteMappings()
        );
    }

    public static Response<Void> deleteMapping(String uuid) {
        return (Response<Void>) RetrofitUtils.executeCall(
                wireMocksApi.deleteMapping(uuid)
        );
    }

    public static Response<Void> deleteRequests() {
        return (Response<Void>) RetrofitUtils.executeCall(
                wireMocksApi.deleteRequests()
        );
    }
}
