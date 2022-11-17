package org.javaTestAutomation.tests;

import org.javaTestAutomation.enums.Severity;
import org.javaTestAutomation.steps.WebhookSiteSteps;

public class BaseTest {

    // TODO: Logging
    // TODO: Retries
    // TODO: Parameterized test
    // TODO: Rules

    public static final Severity LOG_LEVEL = Severity.fromValue(Integer.parseInt(System.getProperty("LOG_LEVEL")));
    protected static final WebhookSiteSteps webhookSiteSteps = new WebhookSiteSteps();


}
