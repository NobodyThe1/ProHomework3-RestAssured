package petstore_tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.UserNameApi;

public class GetUserByNameTests {

    @Test
    /*
    Проверка: получить данные пользователя по тестовому имени, указанному в спецификации
    Ожидаемый результат: пользователь найден, все нужные поля возвращаются
     */
    public void getUserBySpecifiedName() {
        UserNameApi userNameApi = new UserNameApi();

        ValidatableResponse response = userNameApi.getUserName("user1");

        response
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetUserName.json"));
    }

    @Test
    /*
    Проверка: получить данные пользователя по имени, которое предположительно существует
    Ожидаемый результат: пользователь найден, все нужные поля возвращаются
     */
    public void getUserBySuggestedName() {
        UserNameApi userNameApi = new UserNameApi();

        ValidatableResponse response = userNameApi.getUserName("string");

        response
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/GetUserName.json"));
    }
}
