export function navigateToMenuItem(firstLevelText, secondLevelText) {
  cy.get('#navbar-brand-centered').within(() => {
    cy.contains(firstLevelText).as('firstLevelLink')
    cy.get('@firstLevelLink').click()
    cy.get('@firstLevelLink')
      .parent()
      .contains('li', secondLevelText)
      .click()
  })
}