module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: ['eslint:all', 'plugin:cypress/recommended', 'plugin:prettier/recommended'],
  overrides: [
    {
      extends: ['plugin:@typescript-eslint/all', 'plugin:prettier/recommended'],
      files: '*.ts',
      parserOptions: {
        project: './tsconfig.json',
      },
      rules: {
        '@typescript-eslint/method-signature-style': 'off',
        '@typescript-eslint/no-magic-numbers': 'off',
        '@typescript-eslint/prefer-readonly-parameter-types': 'off',
        'max-statements': 'off',
        'no-ternary': 'off',
        'one-var': 'off',
        'sort-vars': 'off',
      },
    },
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  plugins: ['@typescript-eslint', 'cypress', 'prettier'],
  root: true,
}
