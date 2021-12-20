package helpers

import org.apache.commons.lang3.RandomStringUtils

class StringHelper {

    static String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@sometestemail.com"
    }
}
