import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class desafioCBTestAPI extends urlBaseTestAPI {

    private static final String ADD_PRODUTO_ENDPOINT = "/add";
    private static final String ATUALIZA_PRODUTO_ENDPOINT = ("/" + IdRandom());
    private static final String DELETAR_PRODUTO_ENDPOINT = ("/3");


    private static String IdRandom (){
        String valor;
        for (; true; ){
            String[] a = {"1", "2", "3", "4"};
            Random r = new Random();
            int b = r.nextInt(a.length);
            valor = a[b];
            return valor;
        }
    }


    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void CT_001_buscarProduto(){
        when()
                .get()
        .then()
                .statusCode(200)
                .body("products[0].title", equalTo("Essence Mascara Lash Princess"))
                .body("products[0].id",equalTo(1))
                .body("products[1].category",equalTo("beauty"));

    }

    @Test
    public void CT_002_adicionarProduto() throws IOException {
        String JsonBody = lerJson("docJson/addProduto.json");

        given()
                .body(JsonBody)

        .when()
                .post(ADD_PRODUTO_ENDPOINT)

        .then()
                .statusCode(201)
                .body("title",equalTo("Camarao do rei"))
                .body("id",equalTo(195))
                .body("price",equalTo(69.99F))
                .body("category", equalTo("camarao"));

    }

    @Test
    public void CT_003_atualizarProdutoPUT() throws IOException {
        String JsonBory = lerJson("docJson/atualizarProdutoPUT.json");

        given()
                .body(JsonBory)

        .when()
                .put(ATUALIZA_PRODUTO_ENDPOINT)

        .then()
                .statusCode(200)
                .body("title",equalTo("camarao da rainha"))
                .body("price",equalTo(10.99F))
                .body("category",equalTo("camarao"));

    }

    @Test
    public void CT_004_atualizarProdutoPATCH() throws IOException {
        String JsonBory = lerJson("docJson/atualizarProdutoPATCH.json");

        given()
                .body(JsonBory)

        .when()
                .patch(ATUALIZA_PRODUTO_ENDPOINT)

        .then()
                .statusCode(200)
                .body("price",equalTo(59.99F))
                .body("category",equalTo("camarao"));

    }

    @Test
    public void CT_005_excluirProduto(){
        when()
                .delete(DELETAR_PRODUTO_ENDPOINT)

        .then()
                .statusCode(200)
                .body("id", equalTo (3))
                .body("isDeleted", equalTo(true))
        ;
        System.out.println("Foi Excluido com sucesso!");
    }
}
