package org.cucumberWiremock.dto;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class MappingDto{
    public String id;
    public String name;
    public Request request;
    public Response response;
    public String uuid;
    public int priority;
    public int insertionIndex;
    public boolean persistent;

    public static class Request{
        public String url;
        public String method;
    }

    public static class Response{
        public int status;
        public String proxyBaseUrl;
        public String body;
        public Headers headers;
    }

    public static class Headers{
        @JsonProperty("Server")
        public String server;
        @JsonProperty("Content-Type")
        public String contentType;
        @JsonProperty("Vary")
        public String vary;
        @JsonProperty("Cache-Control")
        public String cacheControl;
        @JsonProperty("Date")
        public String date;
        @JsonProperty("X-RateLimit-Limit")
        public String xRateLimitLimit;
        @JsonProperty("X-RateLimit-Remaining")
        public String xRateLimitRemaining;
    }
}
