package org.cucumberWiremock.api.definitions;

import org.cucumberWiremock.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface WireMockApi {

    @GET("/__admin/mappings")
    Call<MappingsDto> getMappings();

    @POST("/__admin/mappings")
    Call<MappingDto> createMapping(
            @Body MappingDto mapping
    );

    @POST("/__admin/mappings")
    Call<MappingDto> startSnapshotting(
            @Body StartSnapshottingSettingsDto startSnapshottingBody
    );

    @POST("/__admin/recordings/snapshot")
    Call<Void> saveSnapshotsAsMappings(
            @Body SnapshotSettingsDto snapshot
    );

    @DELETE("/__admin/mappings")
    Call<Void> deleteMappings();

    @DELETE("/__admin/mappings/{uuid}")
    Call<Void> deleteMapping(
            @Path("uuid") String uuid
    );

    @DELETE("/__admin/requests")
    Call<Void> deleteRequests();
}
