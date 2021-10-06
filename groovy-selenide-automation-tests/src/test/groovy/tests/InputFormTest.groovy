package tests

import pages.InputFormPage
import pages.LandingPage

import static enums.TreeMenuItemsFirstLevel.INPUT_FORMS
import static enums.TreeMenuItemsSecondLevel.INPUT_FORM_SUBMIT

class InputFormTest extends AbstractBaseTest {

    def "Input form"() {
        when: "Navigate through the tree menu to the Input Form Submit page"
        LandingPage.navigateToTreeFirstLevel(INPUT_FORMS, INPUT_FORM_SUBMIT)

        then: "The Input Form Submit page should be displayed"
        new InputFormPage().waitForPageLoad()

        when: "Fill in the form"
    }
}
