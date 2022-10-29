describe('Form test suite', () => {

  const testUrl = Cypress.env('INPUT_FORM_URL')

  beforeEach(() => {
    cy.visit('/')
  })

  it('Open the website', () => {
    cy.get('#name-and-slogan').within(() => {
      cy.get('a').should('have.text', 'Selenium Easy')
      cy.get('#site-slogan').should('have.text', 'Complete Automation Testing Tutorials')
    })
  })

  it('Fill in a form', () => {
    cy.intercept('POST', testUrl).as('postForm')
    cy.navigateToInputFormSubmit()
    cy.get('[name="first_name"]').type('Charlie')
    cy.get('[name="last_name"]').type('McAlister')
    cy.get('[name="email"]').type('mcalister.charlie@google.com')
    cy.get('[name="phone"]').type('(854)1234567')
    cy.get('[name="address"]').type('3111 Broadway')
    cy.get('[name="city"]').type('New York City')
    cy.get('[name="state"]').select('New York')
    cy.get('[name="zip"]').type('10027')
    cy.get('[name="website"]').type('https://www.myownsite.com')
    checkHosting(false)
    cy.get('[name="comment"]').type('A description of the project')
    cy.get('fieldset button[type="submit"]').click()
    cy.wait('@postForm');
  })
})

function checkHosting(haveHosting) {
  const value = haveHosting ? 'yes' : 'no'
  cy.get(`[name="hosting"][value="${value}"]`).check()
}