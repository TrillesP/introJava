package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Users {

    int usersId = 2048;
    String caminhoSite = "https://petstore.swagger.io/v2/user";
    String username = "TGod";
    String password = "12345pw";
    String token = "";
    // Padrão
    // Given - Dado
    // .When - Quando
    // .Then - Então

    // Funções de Apoio

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirUsers() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/users.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(caminhoSite)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is(Integer.toString(usersId)))
                .body("type", is("unknown"))

        ;
    }
    @Test(priority = 1, dependsOnMethods = "incluirUsers")
    public void consultarUsers(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(caminhoSite+"/"+username)
        .then()
                .log().all()
                .statusCode(200)
                .body("email", is("pedrotrillesmachado@hotmail.com"))
                .body("phone", is("21 88999-9999"))
        ;
    }
    @Test
    public void login(){
        String mensagem =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(caminhoSite+"/login?username="+username+"&password="+password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
        .extract()
                .path("message")

        ;
        System.out.println("A mensagem é: "+mensagem);
        token = mensagem.substring(23);
        System.out.println("O token é: "+token);
    }

}
