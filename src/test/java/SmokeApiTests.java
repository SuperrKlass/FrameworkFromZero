import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SmokeApiTests {
    String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

    @Test
    void simpleTest() {
        /// AAA -> Arrange - Act - Assert

        Response response = given()
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .baseUri(BASE_URL)
                .when()
                    .body(body)
                    .post("user")
                .andReturn();

        int actualCode = response.getStatusCode();

        Assertions.assertEquals(200, actualCode);
    }

    @Test
    void simpleTestWithBody() {

        given()
                    .baseUri(BASE_URL)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .post("user")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", notNullValue(String.class));
    }
}
