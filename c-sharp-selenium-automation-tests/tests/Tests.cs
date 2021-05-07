using NUnit.Framework;
using OpenQA.Selenium;

namespace c_sharp_selenium_automation_tests.tests
{
    public class Tests: AbstractBaseTest
    {
        [SetUp]
        public void Setup()
        {
            Driver.Url = "https://wikipedia.org";
        }
        
        [TearDown]
        public void TearDown()
        {
            // TODO: geckodriver process remains running for some reason
            Driver.Close();
        }

        [Test]
        public void Wikipedia()
        {
            var heading = Driver.FindElement(By.ClassName("central-textlogo-wrapper"));
            var headingText = heading.FindElement(By.TagName("span"));
            Assert.AreEqual("Wikipedia", headingText.GetAttribute("innerText"));
        }
    }
}