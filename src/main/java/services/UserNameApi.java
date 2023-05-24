package services;

import dto.UserDTO;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserNameApi extends Specifications {
    private static final String USER_NAME = "/user";

    public ValidatableResponse createUser(UserDTO userDTO) {

        return given(requestSpec)
                    .log().all()
                    .body(userDTO)
                .when()
                    .post(USER_NAME)
                .then()
                    .log().all();
    }

    public ValidatableResponse getUserName(String username) {

        return given(requestSpec)
                  .log().all()
                .when()
                  .get(USER_NAME + "/" + username)
                .then()
                  .spec(responseSpec)
                  .log().all();
    }
}
