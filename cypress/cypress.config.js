const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    baseUrl: 'https://demo.seleniumeasy.com',
    env: {
      INPUT_FORM_URL: '/input-form-demo.html',
    },
    specPattern: 'cypress/e2e/*.{js,jsx,ts,tsx}',
  },
})
