package pages

import com.codeborne.selenide.Condition
import dto.InputFormDto

import static com.codeborne.selenide.Selectors.byAttribute
import static com.codeborne.selenide.Selectors.byName
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$

class InputFormPage extends Pages {

    InputFormPage() {
        elementToWaitFor = StateSelect
    }

    static def FirstNameInput = $(byName("first_name"))
    static def LastNameInput = $(byName("last_name"))
    static def EmailInput = $(byName("email"))
    static def PhoneInput = $(byName("phone"))
    static def AddressInput = $(byName("address"))
    static def CityInput = $(byName("city"))
    static def StateSelect = $(byName("state"))
    static def ZipCodeInput = $(byName("zip"))
    static def WebsiteInput = $(byName("website"))
    static def DescriptionTextArea = $(byName("comment"))
    static def SendButton = $(byAttribute("class", "btn btn-default"))

    static void setWholeForm(InputFormDto inputForm) {
        FirstNameInput.val(inputForm.FirstName)
        LastNameInput.val(inputForm.LastName)
        EmailInput.val(inputForm.Email)
        PhoneInput.val(inputForm.Phone)
        AddressInput.val(inputForm.Address)
        CityInput.val(inputForm.City)
        StateSelect.selectOption(inputForm.State)
        ZipCodeInput.val(inputForm.ZipCode)
        WebsiteInput.val(inputForm.Website)
        setHosting(inputForm.Hosting)
        DescriptionTextArea.val(inputForm.Description)
        SendButton.click()
    }

    private static void setHosting(boolean doYouHaveHosting) {
        def allHostingInputs = $$(byName("hosting"))
        def value = doYouHaveHosting ? "yes" : "no"
        def desiredInput = allHostingInputs.filterBy(Condition.attribute("value", value))[0]
        desiredInput.click()
    }
}
