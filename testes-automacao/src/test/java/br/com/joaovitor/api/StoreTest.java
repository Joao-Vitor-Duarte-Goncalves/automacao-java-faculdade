package br.com.joaovitor.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Order(1)
    @DisplayName("Deve consultar o inventário da loja")
    public void testConsultarInventario() {
        given()
        .when()
            .get("/store/inventory")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .body("$", hasKey("available")); // Verifica se existe a chave 'available' no retorno
    }

    @Test
    @Order(2)
    @DisplayName("Deve realizar um pedido de compra com sucesso")
    public void testRealizarPedido() {
        String orderJson = "{\"id\": 5, \"petId\": 12345, \"quantity\": 1, \"shipDate\": \"2026-04-29T20:20:00.000Z\", \"status\": \"placed\", \"complete\": true}";

        given()
            .contentType("application/json")
            .body(orderJson)
        .when()
            .post("/store/order")
        .then()
            .statusCode(200)
            .body("id", is(5))
            .body("petId", is(12345))
            .body("status", is("placed"));
    }
}