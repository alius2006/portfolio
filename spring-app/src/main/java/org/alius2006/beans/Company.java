package org.alius2006.beans;

import org.springframework.stereotype.Component;

@Component
public class Company {
    private Address address;

    public Company(Address address) {
        this.address = address;
    }
}
