package org.cucumberWiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class ProxyApp {

    public static final int SERVER_HTTP_PORT = 8081;

    public static void main(String[] args) {
        WireMockServer server = getBaseServer();
        server.start();
        System.out.println("The server is running on port " + server.port());
    }

    private static WireMockServer getBaseServer() {
        return new WireMockServer(
                options()
                        .port(SERVER_HTTP_PORT)
                        .notifier(new ConsoleNotifier(true))
        );
    }
}
