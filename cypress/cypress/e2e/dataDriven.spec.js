describe('Input test suite', () => {

  const testUrl = Cypress.env('INPUT_FORM_URL')
  const emailInputSelector = '[name="email"]'
  const data = [
    ['email', false],
    ['@mail.com', false],
    ['e@mail.', false],
    ['e@@mail.com', false],
    ['e@mail', true],
    ['e@mail.com', true]
  ]

  before(() => {
    cy.visit('/')
  })

  data.forEach((data) => {
    it(`Email input with value: "${data[0]}"`, () => {
      const expectedClass = data[1] ? 'has-success' : 'has-error'
      cy.visit(testUrl)
      cy.get(emailInputSelector).type(data[0])
      cy.get(emailInputSelector)
        .parents('div.form-group')
        .should('have.class', expectedClass)
    })
  })
})