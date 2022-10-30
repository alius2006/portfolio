declare namespace Cypress {
  interface Chainable<> {
    /**
     * Navigate in menu to Input forms / Input form submit and verify URL.
     *
     * @file support/commands/uiCommands.ts
     */
    navigateToInputFormSubmit(): Chainable<void>

    /**
     * Create a webhook site token
     *
     * @file support/commands/apiCommands.ts
     */
    createToken(): Chainable<CreateWebhookResponseBody>
  }
}
