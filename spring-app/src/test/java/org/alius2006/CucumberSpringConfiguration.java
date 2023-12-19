package org.alius2006;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = BaseTest.class)
public class CucumberSpringConfiguration {
}
