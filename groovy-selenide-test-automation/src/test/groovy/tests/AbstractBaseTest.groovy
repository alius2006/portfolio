package tests

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverRunner
import helperMethods.Log
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.Logs
import pages.LandingPage
import spock.lang.Specification

import java.time.Duration
import java.time.LocalTime
import java.util.logging.Level

import static com.codeborne.selenide.Selenide.closeWebDriver
import static com.codeborne.selenide.Selenide.open

class AbstractBaseTest extends Specification {
    {
        // Configuration
        Configuration.reopenBrowserOnFail = true
        Configuration.reportsFolder = "target/spock-reports"
        Configuration.headless = false
        Configuration.browser = "chrome"
        ChromeOptions options = new ChromeOptions()
        options.addArguments('--incognito')
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options)
    }

    public static final String BASE_URL = "https://demo.seleniumeasy.com/"
    public static final Duration TIMEOUT_SHORT = Duration.ofSeconds(4)
    public static final Duration TIMEOUT_MID = Duration.ofSeconds(8)
    public static final Duration TIMEOUT_LONG = Duration.ofSeconds(16)

    // For custom logging
    public static String currentFeatureName = ""
    public static String lastError = ""
    public static Boolean hasPassed = true

    def setupSpec() {
        open(BASE_URL)
        new LandingPage().waitForPageLoad(TIMEOUT_MID)
        LandingPage.closeAdAlert()
    }

    def setup() {
        // For custom logging
        currentFeatureName = this.getSpecificationContext().currentFeature.name
        hasPassed = true
    }

    def cleanup() {
        // Log result
        def result = hasPassed ? "PASSED" : "FAILED"
        String logText = "\n" + result + ": " + currentFeatureName + "\n" + LocalTime.now()
        println("Log text: " + logText)
        Log.customLog(logText)
        // Log browser console
        Logs logs = WebDriverRunner.getWebDriver().manage().logs()
        LogEntries entries = logs.get(LogType.BROWSER)
        for (LogEntry entry : entries) {
            if (entry.getLevel() == Level.SEVERE) {
                Log.customLog(entry.getLevel().toString() + ": " + entry.getMessage())
            }
        }
    }

    def cleanupSpec() {
        closeWebDriver()
    }
}