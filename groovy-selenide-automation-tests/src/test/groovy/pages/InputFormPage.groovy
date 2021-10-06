package pages

import com.codeborne.selenide.Condition

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Selectors.*

class InputFormPage extends Pages {

    InputFormPage() {
        elementToWaitFor = StateSelect
    }

    def FirstNameInput = $(byName("first_name"))
    def LastNameInput = $(byName("last_name"))
    def EmailInput = $(byName("email"))
    def PhoneInput = $(byName("phone"))
    def AddressInput = $(byName("address"))
    def CityInput = $(byName("city"))
    def StateSelect = $(byName("state"))
    def ZipCodeInput = $(byName("zip"))
    def WebsiteInput = $(byName("website"))
    def DescriptionTextArea = $(byName("comment"))
    def SendButton = $(byAttribute("type", "submit"))






    private static setHosting(boolean doYouHaveHosting) {
        def allHostingInputs = $$(byName("hosting"))
        def value = doYouHaveHosting ? "yes" : "no"
        def desiredInput = allHostingInputs.filterBy(Condition.attribute("value", value))[0]
        desiredInput.click()
    }
}
