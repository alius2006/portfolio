describe('API test suite', () => {

  it('Webhook site call', () => {
    Cypress.log({ name: 'CUSTOM - call webhook.stie'})
    cy.request({
      method: 'POST',
      url: 'https://webhook.site/token',
      headers: {
        Accept: 'application/json'
      },
      retryOnNetworkFailure: true
    }).then((response) => {
      expect(response).property('status').to.equal(201)
      expect(response.body.uuid).not.empty
    })
  })
})