package tests

import io.restassured.RestAssured
import spock.lang.Specification

abstract class AbstractBaseSpec extends Specification {

    public static final String ACCESS_TOKEN = "2428330a09cca541699dcb36a115f925fe58453fe92e402e2694ef5752f28c7a"
    protected static final String SPECIAL_CHARS = " !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"

    def setupSpec() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.baseURI = "https://gorest.co.in/public/v1"
    }
}
