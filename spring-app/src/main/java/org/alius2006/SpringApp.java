package org.alius2006;

import org.alius2006.beans.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company = context.getBean(Company.class);
        System.out.println();
    }

}
