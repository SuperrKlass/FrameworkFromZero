import controllers.UserController;
import io.restassured.response.Response;
import models.user.AddUserResponse;
import models.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static testdata.TestData.*;

public class ApiTests {
    @Test
    void createUserControllerTest() {
        Response response = new UserController().createUser(DEFAULT_USER);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertEquals("0",createUserResponse.getMessage());
    }

    @Test
    void createUserControllerTest2() {
        Response response = new UserController().createUser(INVALID_USER);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertFalse(createUserResponse.getMessage().isEmpty());
    }

    static Stream<User> users() {
        return Stream.of(DEFAULT_USER, INVALID_USER);
    }

    @ParameterizedTest
    @MethodSource("users")
    void createUserParametrizedTest(User user) {
        Response response = new UserController().createUser(user);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertFalse(createUserResponse.getMessage().isEmpty());
    }
}
