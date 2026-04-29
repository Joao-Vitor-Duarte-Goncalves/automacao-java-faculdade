package br.com.joaovitor.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class PetTest {

    @Test
    public void testAdicionarNovoPet() {
        String petJson = "{\"id\": 12345, \"name\": \"Snoopy\", \"status\": \"available\"}";

        given()
            .baseUri("https://petstore.swagger.io/v2")
            .contentType("application/json")
            .body(petJson)
        .when()
            .post("/pet")
        .then()
            .statusCode(200)
            .body("name", is("Snoopy"))
            .body("status", is("available"));
    }
}