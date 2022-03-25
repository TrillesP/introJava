package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class Pet {

    // Padrão
    // Given - Dado
    // .When - Quando
    // .Then - Então

    // Funções de Apoio

    public String lerJson(String caminhoJson) throws IOException {



        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirPet() throws IOException { // - Create - Post

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()                                                       //Given - "given this..."
                .contentType("application/json")                       //Tipo de conteúdo
                //web services síncronos -> "text/xml"  ex: Correios
                //web services assíncronos -> "application/json"   ex: iFood
                .log().all()                                          //Registra tudo do envio
                .body(jsonBody)
        .when()                                                       //When - "when blabla..."
                .post("https://petstore.swagger.io/v2/pet")      //Comando + endpoint
        .then()                                                       //Then - "then, this..."
                .log().all()                                          //Registra tudo do retorno
                .statusCode(200)                                      //Valida o código de estado nativo
                .body("id", is(1048))                      //Valida o código de estado no Json
                .body("name", is("Snoopy"))
                .body("category.name", is("dog"))
                .body("category.id", is(1))
        ;
    }

}
