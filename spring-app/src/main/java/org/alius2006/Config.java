package org.alius2006;

import org.alius2006.beans.Address;
import org.alius2006.beans.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Company.class)
public class Config {

    @Bean
    public Address getAddress() {
        return new Address("Grimmauld Place", 12);
    }
}
