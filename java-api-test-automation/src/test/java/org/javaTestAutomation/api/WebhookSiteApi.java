package org.javaTestAutomation.api;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;

public interface WebhookSiteApi {
    @POST("token")
    Call<CreateTokenResponseBody> createWebhookToken();

    @GET("requests")
    Call<GetRequestsResponseBody> getRequests(
            @Query("sorting") String sorting,
            @Query("query") String query
    );

    @DELETE("request")
    Call<Object> deleteRequests();

    @POST("{token}")
    Call<Void> postRequest(
            @Path("token") String token,
            @Body Object object
    );

    class CreateTokenResponseBody {
        public String uuid;
        public boolean password;
    }

    class GetRequestsResponseBody {
        public List<WebhookDataEntry> data;
        public int total;
        public int from;
        public int to;

    }

    class JobBody {
        public ArrayList<JobPart> jobParts;
        public String event;
    }

    class JobPart{
        public String uid;
        public String task;
    }


    class WebhookDataEntry {
        public String content;
    }

    class DownloadFileAsyncWebhookContentBody {
        public String result;
        public ConnectorAsyncTask connectorAsyncTask;
    }

    class ConnectorAsyncTask {
        public String id;
    }

    class JobErrorBody{
        public String jobUid;
        public String error;
        public String event;
        public int timestamp;
    }
}

