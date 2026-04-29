package br.com.joaovitor.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testConsultarPetPorId() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .contentType("application/json")
        .when()
            .get("/pet/1") // Vamos tentar consultar o Pet com ID 1
        .then()
            .statusCode(anyOf(is(200), is(404))) // Aceita 200 se existir ou 404 se não
            .log().all();
    }
}