package org.alius2006;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;

@RunWith(Cucumber.class)
@ComponentScan(basePackages = "org.alius2006")
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "html:target/testResults.html"}
)
public class BaseTest {
}
