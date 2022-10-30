class CreateWebhookResponseBody {
  public uuid = ''
}

Cypress.Commands.add('createToken', () => {
  Cypress.log({ name: 'CUSTOM - call webhook.site' })
  cy.request({
    headers: {
      // eslint-disable-next-line @typescript-eslint/naming-convention
      Accept: 'application/json',
    },
    method: 'POST',
    retryOnNetworkFailure: true,
    url: 'https://webhook.site/token',
  }).then((response: Cypress.Response<CreateWebhookResponseBody>) => {
    expect(response).property('status').to.equal(201)
    return response.body
  })
})
