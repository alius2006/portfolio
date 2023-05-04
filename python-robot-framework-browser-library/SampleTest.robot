*** Settings ***
Library  Browser

*** Test Cases ***
Sample test
    [Documentation]  Open a page

    Browser.New Browser    chromium    headless=false
    Browser.New Page    https://automationintesting.com/selenium/testpage/
    Browser.Wait for elements state    xpath=//input[@id='firstname']  visible  3s

Test Teardown Keyword
    [Documentation]  Close browser

    Close Browser