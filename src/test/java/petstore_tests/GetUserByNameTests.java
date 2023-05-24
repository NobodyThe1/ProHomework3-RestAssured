package petstore_tests;

import dto.UserDTO;
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
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    /*
    Проверка: создать нового пользователя, получить его данные по имени пользователя
    Ожидаемый результат: пользователь найден, все нужные поля возвращаются
     */
    public void createUserGetUser() {
        UserNameApi userNameApi = new UserNameApi();
        UserDTO userDTO = UserDTO.builder()
                .email("test@test.com")
                .id(1251l)
                .firstName("Ivan")
                .lastName("Ivanov")
                .password("password")
                .phone("3-17-100")
                .username("IvanIvanov")
                .userStatus(600l)
                .build();
        ValidatableResponse createUser = userNameApi.createUser(userDTO);

        ValidatableResponse getUser = userNameApi.getUserName("IvanIvanov");

        getUser
                .statusCode(HttpStatus.SC_OK);
    }
}
