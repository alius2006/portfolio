package org.javaTestAutomation.dto;

import java.util.List;

public class WebhookRequests {
    public List<WebhookDataEntry> data;
    public int total;
    public int from;
    public int to;

    public static class WebhookDataEntry {
        public String content;
    }
}
