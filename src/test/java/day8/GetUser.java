package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void test_GetUser(ITestContext context){
        String Bearer_Token="5c566de61251e064a557b5f7163ef5761edfee9da4f65c62a206066cddb53154";

        int id= (Integer) context.getSuite().getAttribute("user_id");

        given()
                .headers("Authorization","Bearer "+Bearer_Token)
                .pathParam("id",id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();



    }
}
