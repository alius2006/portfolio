using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;

namespace c_sharp_selenium_automation_tests.tests

{
    public abstract class AbstractBaseTest
    {
        protected readonly IWebDriver Driver;

        protected AbstractBaseTest()
        {
            Driver = new FirefoxDriver();
        }
    }
}