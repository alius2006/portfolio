package org.alius2006;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final String text = "test";

    public String getText() {
        return text;
    }
}
