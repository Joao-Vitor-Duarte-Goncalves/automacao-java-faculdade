package br.com.joaovitor.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Garante a ordem dos testes
public class UserTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Order(1)
    @DisplayName("Deve criar um novo usuário com sucesso")
    public void testCriarUsuario() {
        String userJson = "{\"id\": 1010, \"username\": \"joaovitor\", \"firstName\": \"Joao\", \"lastName\": \"Vitor\", \"email\": \"joao@teste.com\", \"password\": \"12345\", \"phone\": \"9999999\", \"userStatus\": 1}";

        given()
            .contentType("application/json")
            .body(userJson)
        .when()
            .post("/user")
        .then()
            .statusCode(200)
            .body("message", is("1010"));
    }

    @Test
    @Order(2)
    @DisplayName("Deve consultar o usuário criado")
    public void testConsultarUsuario() {
        given()
            .pathParam("username", "joaovitor")
        .when()
            .get("/user/{username}")
        .then()
            .statusCode(200)
            .body("username", is("joaovitor"))
            .body("email", is("joao@teste.com"));
    }
}