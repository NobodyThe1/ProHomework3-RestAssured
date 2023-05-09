package services;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserNameApi {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String USER_NAME = "/user";
    private RequestSpecification spec;

    public UserNameApi() {
        spec = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse getUserName(String username) {

        return given(spec)
                  .log().all()
                .when()
                  .get(USER_NAME + "/" + username)
                .then()
                  .log().all();
    }
}
