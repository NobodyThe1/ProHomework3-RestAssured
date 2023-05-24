package petstore_tests;

import dto.PetOrderDTO;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.CreateOrderApi;

public class CreateNewOrderTests {

    @Test
    /*
    Проверка: создать новый заказ с корректно заполненными полями, найти его по id
    Ожидаемый результат: заказ создан, ищется
     */
    public void createNewOrderGetOrder() {
        CreateOrderApi createOrderApi = new CreateOrderApi();

        PetOrderDTO petOrderDTO = PetOrderDTO.builder()
                .id(9L)
                .petId(1L)
                .quantity(1L)
                .shipDate("2022-05-10T14:15:14.598Z")
                .complete(true)
                .status("placed")
                .build();

        ValidatableResponse createNewOrder = createOrderApi.createOrder(petOrderDTO);

        ValidatableResponse getOrder = createOrderApi.getOrder("9");

        getOrder
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
     /*
    Проверка: создать новый заказ с датой в другом формате
    Ожидаемый результат: тест падает
     */
    public void createNewOrderWithIncorrectDateFormat() {
        CreateOrderApi createOrderApi = new CreateOrderApi();

        PetOrderDTO petOrderDTO = PetOrderDTO.builder()
                .id(1021L)
                .petId(2L)
                .quantity(1L)
                .shipDate("10.05.2023")
                .build();

        ValidatableResponse response = createOrderApi.createOrder(petOrderDTO);

        response
                .statusCode(HttpStatus.SC_OK);
    }
}
