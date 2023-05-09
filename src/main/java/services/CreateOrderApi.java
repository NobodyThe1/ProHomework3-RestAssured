package services;

import dto.PetOrderDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CreateOrderApi {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String ORDER = "/store/order";
    private RequestSpecification spec;

    public CreateOrderApi() {
        spec = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse createOrder (PetOrderDTO petOrderDTO) {

        return given(spec)
                    .log().all()
                    .body(petOrderDTO)
                .when()
                    .post(ORDER)
                .then()
                    .log().all();
    }
}
