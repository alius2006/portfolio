package pages


import com.codeborne.selenide.SelenideElement
import enums.TreeMenuItemsFirstLevel
import enums.TreeMenuItemsSecondLevel
import helperMethods.Elements

import static com.codeborne.selenide.Condition.appear
import static com.codeborne.selenide.Condition.disappear
import static com.codeborne.selenide.Condition.exactText
import static com.codeborne.selenide.Selectors.*
import static com.codeborne.selenide.Selenide.$

class LandingPage extends Pages {

    LandingPage() {
        elementToWaitFor = StartPracticingButton
    }

    public static def AdAlert = $(byId("at-cv-lightbox-win"))
    public static def AdCloseButton = $(byId("at-cv-lightbox-close"))
    public static def StartPracticingButton = $(byId("btn_basic_example"))
    public static def TreeMenuUl = $(byId("treemenu"))

    static void navigateToTreeFirstLevel(TreeMenuItemsFirstLevel firstLevelItem, TreeMenuItemsSecondLevel secondLevelItem) {
        def link1 = getTreeItemElementFirstLevel(firstLevelItem)
        Elements.scrollElementIntoView(link1)
        link1.click()
        def link2 = getTreeItemElementSecondLevel(link1, secondLevelItem)
        link2.should(appear).click()
    }

    static void closeAdAlert() {
        AdCloseButton.should(appear).click()
        AdCloseButton.should(disappear)
    }

    private static def getTreeItemElementFirstLevel(TreeMenuItemsFirstLevel item) {
        def allFirstLevelHrefs = TreeMenuUl.$$(byAttribute("href", "#"))
        return allFirstLevelHrefs.filterBy(exactText(item.getValue()))[0]
    }

    private static def getTreeItemElementSecondLevel(SelenideElement firstLevelItem, TreeMenuItemsSecondLevel secondLevelItem) {
        def allSecondLevelHrefs = firstLevelItem.parent().$$(byTagName("a"))
        return allSecondLevelHrefs.filterBy(exactText(secondLevelItem.getValue()))[0]
    }
}
