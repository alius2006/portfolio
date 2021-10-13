package tests

import io.restassured.RestAssured
import org.apache.commons.lang3.RandomStringUtils
import org.junit.FixMethodOrder

@FixMethodOrder
class SampleTest extends AbstractBaseSpec {

    private static String id

    def "POST"() {
        given:
        def email = RandomStringUtils.randomAlphabetic(10) + "@sometestemail.com"
        def request = RestAssured
                .given()
                .queryParam("access-token", ACCESS_TOKEN)
                .queryParam("email", email)
                .queryParam("name", "a@b.com")
                .queryParam("gender", "male")
                .queryParam("status", "active")

        when:
        def response = request.post("users")
        id = response.getBody().jsonPath().get("data.id")
        println("id: " + id)

        then:
        println("Response body:")
        println(response.getBody().asString())
        response.then().statusCode(201)
    }

    def "GET"() {
        given:
        def request = RestAssured.given()

        when:
        def response = request.get("users/${id}")

        then:
        println("Response body:")
        println(response.getBody().asString())
        response.then().statusCode(200)
    }
}
