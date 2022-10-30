const emailInputSelector = '[name="email"]'
const testUrl = Cypress.env('INPUT_FORM_URL') as string

const testBody = (email: string, expectedClass: string): void => {
  cy.visit(testUrl)
  cy.get(emailInputSelector).type(email)
  cy.get(emailInputSelector).parents('div.form-group').should('have.class', expectedClass)
}

describe('Input test suite', () => {
  const badCaseData: string[] = ['email', '@mail.com', 'e@mail.', 'e@@mail.com'],
    goodCaseData: string[] = ['e@mail', 'e@mail.com']

  before(() => {
    cy.visit('/')
  })

  badCaseData.forEach((email) => {
    it(`Bad case - Email input with value: "${email}"`, () => {
      testBody(email, 'has-error')
    })
  })

  goodCaseData.forEach((email) => {
    it(`Good case - Email input with value: "${email}"`, () => {
      testBody(email, 'has-success')
    })
  })
})
