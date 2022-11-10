Feature: WireMock test

  Background:
    Given Delete mappings
    And Delete requests

  Scenario: Use stub created in WireMock
    Given Create stub in WireMock
    And Verify that mapping has the same values
    When Send request to create a webhook on webhook.site
    Then Verify that the response has the stubbed values

  Scenario: Record stub by redirecting to webhook.site
    When Start snapshotting
    And Send request to create a webhook on webhook.site
    And Save snapshots as mappings
    Then Verify redirected response from webhook.site
    When Delete mapping used for snapshot
    Then Verify that the response was recorded
    When Send request to create a webhook on webhook.site
    Then Verify that the recorded response was used