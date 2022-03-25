package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet {
    int petId = 1048;
    String caminhoSite = "https://petstore.swagger.io/v2/pet";
    // Padrão
    // Given - Dado
    // .When - Quando
    // .Then - Então

    // Funções de Apoio

    public String lerJson(String caminhoJson) throws IOException {



        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test()
    public void incluirPet() throws IOException { // - Create - Post

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()                                                       //Given - "given this..."
                .contentType("application/json")                       //Tipo de conteúdo
                //web services síncronos -> "text/xml"  ex: Correios
                //web services assíncronos -> "application/json"   ex: iFood
                .log().all()                                          //Registra tudo do envio
                .body(jsonBody)
        .when()                                                       //When - "when blabla..."
                .post(caminhoSite)      //Coloca + endpoint
        .then()                                                       //Then - "then, this..."
                .log().all()                                          //Registra tudo do retorno
                .statusCode(200)                                      //Valida o código de estado nativo
                .body("id", is(petId))                      //Valida o código de estado no Json
                .body("name", is("Snoopy"))
                .body("category.name", is("dog"))
                .body("category.id", is(1))
        ;
    }

    @Test(priority = 1, dependsOnMethods = "incluirPet")
    public void consultarPet(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(caminhoSite +"/"+ petId)  //Get - Consulta
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Snoopy"))
                .body("status", is("available"))
                .body("tags.name[0]", stringContainsInOrder("vermifugado"))
        ;
    }

    @Test(priority = 2, dependsOnMethods = "consultarPet")
    public void alterarPet() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/newpet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(caminhoSite)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("sold"))
        ;
    }

    @Test(priority = 3, dependsOnMethods = "alterarPet")
    public void deletarPet(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(caminhoSite+"/"+petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(petId)))
        ;
    }

}
