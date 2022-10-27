describe("Example test suite", () => {
  beforeEach(() => {
    cy.visit('/')
  })

  it.skip('Open the website', () => {
    cy.get('#name-and-slogan').within(() => {
      cy.get('a').should('have.text', 'Selenium Easy')
      cy.get('#site-slogan').should('have.text', 'Complete Automation Testing Tutorials')
    })
  })

  it('Fill in a form', () => {
    cy.navigateToInputFormSubmit()
    cy.get('[name="first_name"]').type('Charlie')
    cy.get('fieldset button[type="submit"]').click()
  })
})
