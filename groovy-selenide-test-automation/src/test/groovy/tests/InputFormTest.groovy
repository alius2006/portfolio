package tests

import dto.InputFormDto
import pages.InputFormPage
import pages.LandingPage

import static enums.TreeMenuItemsFirstLevel.INPUT_FORMS
import static enums.TreeMenuItemsSecondLevel.INPUT_FORM_SUBMIT
import static com.codeborne.selenide.Selenide.*

class InputFormTest extends AbstractBaseTest {

    def setup() {
        when: "Navigate through the tree menu to the Input Form Submit page"
        LandingPage.navigateToTreeFirstLevel(INPUT_FORMS, INPUT_FORM_SUBMIT)

        then: "The Input Form Submit page should be displayed"
        new InputFormPage().waitForPageLoad()
    }

    def "Smoke test"() {
        given:
        def testInputForm = InputFormDto.getDefault()

        when: "Fill in the form"
        InputFormPage.setWholeForm(testInputForm)

        then: "Check the outcome"
        assert true // The form does nothing

        cleanup:
        open()
    }
}
