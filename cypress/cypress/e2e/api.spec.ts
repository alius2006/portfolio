describe('API test suite', () => {
  it('Webhook site call', () => {
    cy.createToken().then((responseBody) => {
      expect(responseBody.uuid.length).to.be.greaterThan(0)
    })
  })
})
