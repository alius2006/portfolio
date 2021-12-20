package helperMethods

import static com.codeborne.selenide.Selectors.byId
import static com.codeborne.selenide.Selectors.byXpath
import static com.codeborne.selenide.Selenide.$

class DOM {
    static String getDomTree() {
        return $(byId("app")).innerHtml().toString()
    }

    static String getHtml() {
        return $(byXpath("//*")).innerHtml().toString()
    }
}
