package org.cucumberWiremock.dto;

public class StartSnapshottingSettingsDto {

    public int priority;
    public Request request;
    public Response response;

    public static class Request {
        public String method;
    }

    public static class Response {
        public String proxyBaseUrl;
    }
}
