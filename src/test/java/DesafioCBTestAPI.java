
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.when;

public class DesafioCBTestAPI {

    String urlBase = "https://dummyjson.com/products";

    public String lerJson(String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get(caminhoJson)));

    }

    @Test
    public void buscarProduto(){

        when()
                .get(urlBase)
        .then()
                .log().all()
                .statusCode(200)
                .body("products[0].title", equalTo("Essence Mascara Lash Princess"))
                .body("products[0].id",equalTo(1))
                .body("products[1].category",equalTo("beauty"));

    }

    @Test
    public void adicionarProduto() throws IOException {
        String JsonBody = lerJson("docJson/addProduto.json");
        String addProduto = "/add";

        given()
                .contentType("application/json")
                .log().all()
                .body(JsonBody)

        .when()
                .post(urlBase + addProduto)

        .then()
                .log().all()
                .statusCode(201)
                .body("title",equalTo("Camarao do rei"))
                .body("id",equalTo(195))
                .body("price",equalTo(69.99F))
                .body("category", equalTo("camarao"));

    }

    @Test
    public void atualizarProdutoTotal() throws IOException {
        String JsonBory = lerJson("docJson/atualizarProdutoTotal.json");
        String id = "1";

        given()
                .contentType("application/json")
                .log().all()
                .body(JsonBory)

        .when()
                .put(urlBase + "/" + id)

        .then()
                .log().all()
                .statusCode(200)
                .body("title",equalTo("camarao da rainha"))
                .body("id",equalTo(1))
                .body("price",equalTo(10.99F))
                .body("category",equalTo("camarao"));

    }

    @Test
    public void atualizarProdutoParcial() throws IOException {
        String JsonBory = lerJson("docJson/atualizarProdutoParcial.json");
        String id = "2";

        given()
                .contentType("application/json")
                .log().all()
                .body(JsonBory)

        .when()
                .patch(urlBase + "/" + id)

        .then()
                .log().all()
                .statusCode(200)
                .body("id",equalTo(2))
                .body("price",equalTo(59.99F))
                .body("category",equalTo("camarao"));

    }

    @Test
    public void excluirProduto(){
        String id = "3";

        given()
                .contentType("application/json")
                .log().all()

        .when()
                .delete(urlBase + "/" + id)

        .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo (3))
                .body("isDeleted", equalTo(true))
        ;
        System.out.println("Foi Excluido com sucesso!");
    }
}
