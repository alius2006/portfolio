package tests

import dto.UserDTO
import io.restassured.RestAssured
import org.apache.commons.lang3.StringUtils
import org.junit.FixMethodOrder

import static helpers.StringHelper.randomEmail
import static org.hamcrest.Matchers.*

@FixMethodOrder
class SampleTest extends AbstractBaseSpec {

    private static final String postEndpoint = "users"
    private static final String getEndpoint = postEndpoint + "/{id}"
    private static final String putEndpoint = getEndpoint
    private static final String deleteEndpoint = getEndpoint

    def "POST - happy path - Create a new user by POST and verify created by GET"() {
        given:
        def testUser = UserDTO.getDefault()

        when: "POST - create a new user"
        def responsePost = post(testUser)
        Integer id = responsePost.getBody().jsonPath().get("data.id")

        then: "Verify POST response"
        reportInfo "Response body: " + responsePost.getBody().asString()
        responsePost.then()
                .statusCode(201)
                .body("data.id", is(not(null)))
                .body("data.name", equalTo(testUser.Name))
                .body("data.email", equalTo(testUser.Email))
                .body("data.gender", equalTo(testUser.Gender))
                .body("data.status", equalTo(testUser.Status))

        when: "Verify by GET - get the user by id"
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

        cleanup:
        if (id != null) delete(id)
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

    def "POST - duplicate email"() {
        given: "POST a test user"
        def testUser = UserDTO.getDefault()
        Integer id = post(testUser).getBody().jsonPath().get("data.id")

        when: "Try to POST a user with the same email"
        def response = post(testUser)

        then: "Verify response"
        reportInfo "Response body: " + response.getBody().asString()
        response.then()
                .statusCode(422)
                .body("data.field", hasItem("email"))
                .body("data.message", hasItem("has already been taken"))

        cleanup:
        if (id != null) delete(id)
    }

    def "PUT - happy path - Modify an existing user by PUT and verify modified by GET"() {
        given: "POST a test user"
        def testUser1 = UserDTO.getDefault()
        def testUser2 = new UserDTO(getRandomEmail(), "New name", "female", "inactive")
        Integer id = post(testUser1).getBody().jsonPath().get("data.id")

        when: "PUT"
        def responsePut = put(testUser2, id)

        then: "Verify response"
        reportInfo "Response body: " + responsePut.getBody().asString()
        responsePut.then()
                .statusCode(200)
                .body("data.id", equalTo(id))
                .body("data.name", equalTo(testUser2.Name))
                .body("data.email", equalTo(testUser2.Email))
                .body("data.gender", equalTo(testUser2.Gender))
                .body("data.status", equalTo(testUser2.Status))

        when: "Verify by GET - get the user by id"
        def responseGet = get(id)

        then: "Verify GET response"
        reportInfo "Response body: " + responseGet.getBody().asString()
        responseGet.then()
                .statusCode(200)
                .body("data.id", equalTo(id))
                .body("data.name", equalTo(testUser2.Name))
                .body("data.email", equalTo(testUser2.Email))
                .body("data.gender", equalTo(testUser2.Gender))
                .body("data.status", equalTo(testUser2.Status))

        cleanup:
        if (id != null) delete(id)
    }

    def "DELETE - happy path - DELETE a user, verify deleted by GET and try to DELETE again"() {
        given: "POST a test user"
        def testUser = UserDTO.getDefault()
        Integer id = post(testUser).getBody().jsonPath().get("data.id")

        when: "DELETE"
        def responseDelete1 = delete(id)

        then: "Verify DELETE first response"
        reportInfo "Response body: " + responseDelete1.getBody().asString()
        responseDelete1.then().statusCode(204)

        when: "Verify deleted using GET"
        def responseGet = get(id)

        then:
        reportInfo "Response body: " + responseGet.getBody().asString()
        responseGet.then()
                .statusCode(404)
                .body("data.message", equalTo("Resource not found"))

        when: "Try to DELETE again"
        def responseDelete2 = delete(id)

        then: "Verify DELETE second response"
        reportInfo "Response body: " + responseDelete2.getBody().asString()
        responseDelete2.then()
                .statusCode(404)
                .body("data.message", equalTo("Resource not found"))
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

    private static def put(UserDTO user, Integer id) {
        def request = RestAssured
                .given()
                .pathParam("id", id)
                .queryParam("access-token", ACCESS_TOKEN)

        if (StringUtils.isNotBlank(user.Email)) request.queryParam("email", user.Email)
        if (StringUtils.isNotBlank(user.Name)) request.queryParam("name", user.Name)
        if (StringUtils.isNotBlank(user.Gender)) request.queryParam("gender", user.Gender)
        if (StringUtils.isNotBlank(user.Status)) request.queryParam("status", user.Status)

        def response = request.put(putEndpoint)

        return response
    }

    private static def get(Integer id) {
        def request = RestAssured
                .given()
                .pathParam("id", id)

        def response = request.get(getEndpoint)

        return response
    }

    private static def delete(Integer id) {
        def request = RestAssured
                .given()
                .pathParam("id", id)
                .queryParam("access-token", ACCESS_TOKEN)

        def response = request.delete(deleteEndpoint)

        return response
    }
}
