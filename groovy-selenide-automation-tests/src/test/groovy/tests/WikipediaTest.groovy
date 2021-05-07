package tests

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Selectors.byAttribute
import static com.codeborne.selenide.Selectors.byTagName
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class WikipediaTest extends AbstractBaseTest{

    def "Wikipedia"() {
        when:
        open("https://www.wikipedia.org/")

        then:
        $(byAttribute("class", "central-textlogo-wrapper")).
                $(byTagName("span")).shouldHave(text("Wikipedia"))
    }
}
