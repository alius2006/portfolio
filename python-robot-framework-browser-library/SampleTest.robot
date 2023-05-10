*** Settings ***
Library  Browser
Test Setup    Browser.New Browser    chromium    headless=false
Test Teardown    Close Browser

*** Test Cases ***
Sample test
    [Documentation]  Open a page
    Browser.New Page    https://automationintesting.com/selenium/testpage/
    Browser.Wait for elements state    xpath=//input[@id='firstname']  visible  3s