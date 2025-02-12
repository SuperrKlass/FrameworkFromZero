import controllers.UserController;
import io.restassured.response.Response;
import models.user.AddUserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class ApiTests {
    @Test
    void createUserControllerTest() {
        Response response = new UserController().createUser(DEFAULT_USER);
        AddUserResponse createUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertFalse(createUserResponse.getMessage().isEmpty());
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
}
