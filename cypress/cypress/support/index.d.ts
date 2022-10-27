declare namespace Cypress {
    interface Chainable<Subject = any> {
        /**
         * Navigate in menu to Input forms / Input form submit and verify URL.
         *
         * @file support/commands/generalCommands.js
         *
         */
        navigateToInputFormSubmit(): Chainable<any>;
    }
}