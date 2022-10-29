import { navigateToMenuItem } from '../utils/navigationUtils';

Cypress.Commands.add('navigateToInputFormSubmit', () => {
  navigateToMenuItem('Input Forms', 'Input Form Submit')
  cy.url().should('include', 'input-form-demo.html')
})