package tests

import dto.UserDTO
import io.restassured.RestAssured
import org.apache.commons.lang3.StringUtils
import org.junit.FixMethodOrder
import spock.lang.IgnoreRest

import static helpers.StringHelper.randomEmail
import static org.hamcrest.Matchers.*

@FixMethodOrder
class SampleTest extends AbstractBaseSpec {

    private static final String postEndpoint = "users"
    private static final String getEndpoint = postEndpoint + "/{id}"

    def "POST - happy path - Create a new user by POST and verify created by GET"() {
        given:
        def testUser = UserDTO.getDefault()

        when: "POST - create a new user"
        def responsePost = post(testUser)
        Integer id = responsePost.getBody().jsonPath().get("data.id")
        println("Created user's id: " + id)

        then: "Verify POST response"
        reportInfo "Response body: " + responsePost.getBody().asString()
        responsePost.then()
                .statusCode(201)
                .body("data.id", is(not(null)))
                .body("data.name", equalTo(testUser.Name))
                .body("data.email", equalTo(testUser.Email))
                .body("data.gender", equalTo(testUser.Gender))
                .body("data.status", equalTo(testUser.Status))

        when: "GET - get the user by id"
        def responseGet = get(id)

        then: "Verify GET response"
        reportInfo "Response body: " + responseGet.getBody().asString()
        responseGet.then()
                .statusCode(200)
                .body("data.id", equalTo(id))
                .body("data.name", equalTo(testUser.Name))
                .body("data.email", equalTo(testUser.Email))
                .body("data.gender", equalTo(testUser.Gender))
                .body("data.status", equalTo(testUser.Status))
    }

    def "POST - validation tests - #type"() {
        given:
        def testUser = new UserDTO(email, name, gender, status)

        when:
        def responsePost = post(testUser)

        then:
        reportInfo "Response body: " + responsePost.getBody().asString()
        responsePost.then()
                .statusCode(422)
                .body("data.field", hasItem(errorField))
                .body("data.message", hasItem(errorMessage))

        where:
        type             | email            | name      | gender   | status   | errorField | errorMessage
        "missing email"  | null             | "My name" | "male"   | "active" | "email"    | "can't be blank"
        "invalid email"  | "string"         | "My name" | "male"   | "active" | "email"    | "is invalid"
        "missing name"   | getRandomEmail() | null      | "male"   | "active" | "name"     | "can't be blank"
        "missing gender" | getRandomEmail() | "My name" | null     | "active" | "gender"   | "can't be blank"
        "invalid gender" | getRandomEmail() | "My name" | "string" | "active" | "gender"   | "can't be blank"
        "missing status" | getRandomEmail() | "My name" | "male"   | null     | "status"   | "can't be blank"
        "invalid status" | getRandomEmail() | "My name" | "male"   | "string" | "status"   | "can't be blank"
    }

    def "POST - missing access-token"() {
        given:
        def testUser = UserDTO.getDefault()
        def request = RestAssured
                .given()
                .queryParam("email", testUser.Email)
                .queryParam("name", testUser.Name)
                .queryParam("gender", testUser.Gender)
                .queryParam("status", testUser.Status)

        when:
        def response = request.post(postEndpoint)

        then:
        reportInfo "Response body: " + response.getBody().asString()
        response.then()
                .statusCode(401)
                .body("data.message", equalTo("Authentication failed"))
    }

    private static def post(UserDTO user) {
        def request = RestAssured
                .given()
                .queryParam("access-token", ACCESS_TOKEN)

        if (StringUtils.isNotBlank(user.Email)) request.queryParam("email", user.Email)
        if (StringUtils.isNotBlank(user.Name)) request.queryParam("name", user.Name)
        if (StringUtils.isNotBlank(user.Gender)) request.queryParam("gender", user.Gender)
        if (StringUtils.isNotBlank(user.Status)) request.queryParam("status", user.Status)

        def response = request.post(postEndpoint)

        return response
    }

    private static def get(Integer id) {
        def request = RestAssured
                .given()
                .pathParam("id", id)

        def response = request.get(getEndpoint)

        return response
    }
}
