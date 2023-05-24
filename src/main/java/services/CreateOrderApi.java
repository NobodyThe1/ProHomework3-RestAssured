package services;

import dto.PetOrderDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CreateOrderApi extends Specifications {
    private static final String ORDER = "/store/order";

    public ValidatableResponse createOrder (PetOrderDTO petOrderDTO) {

        return given(requestSpec)
                    .log().all()
                    .body(petOrderDTO)
                .when()
                    .post(ORDER)
                .then()
                    .log().all();
    }

    public ValidatableResponse getOrder (String id) {

            return given(requestSpec)
                        .log().all()
                    .when()
                        .get(ORDER + "/" + id)
                    .then()
                        .log().all();
    }
}
