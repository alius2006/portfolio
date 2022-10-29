# Cypress test automation
## Getting started
### Dependencies
* Node.js
### Run tests
Use this command to run the tests
```
npm run cy:open
```

To execute the tests multiple times use:

```
$ npx cypress-repeat run -n <N> ... rest of "cypress run" arguments
```

i.e.

```
$ npx cypress-repeat run -n 3 --browser chrome --headless
```

To execute single test multiple times use:

```
$ npx cypress-repeat run -n 3 --browser chrome --headless --spec "cypress/e2e/api.spec.js"
```
For more details see <a href="https://github.com/bahmutov/cypress-repeat/blob/main/README.md">cypress-repeat
README.MD</a>