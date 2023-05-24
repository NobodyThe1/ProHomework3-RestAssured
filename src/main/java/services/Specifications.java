package services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Specifications {

    protected RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(System.getProperty("base.url", "https://petstore.swagger.io/v2"))
            .setContentType(ContentType.JSON)
            .build();

    protected ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody((JsonSchemaValidator.matchesJsonSchemaInClasspath(System.getProperty("schema", "schema/GetUserName.json"))))
            .build();

}

