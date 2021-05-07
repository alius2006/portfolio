package tests

import com.codeborne.selenide.Configuration
import spock.lang.Specification

class AbstractBaseTest extends Specification {
    {
        Configuration.reopenBrowserOnFail = true
        Configuration.reportsFolder = "target/spock-reports"
        Configuration.headless = false
        Configuration.browser = "chrome"
    }

    def setupSpec() {

    }
}