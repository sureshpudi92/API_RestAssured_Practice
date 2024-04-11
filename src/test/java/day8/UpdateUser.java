package day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    @Test
    void test_UpdateUser(ITestContext context){
        String Bearer_Token="5c566de61251e064a557b5f7163ef5761edfee9da4f65c62a206066cddb53154";
        Faker faker=new Faker();
        JSONObject js=new JSONObject();
        js.put("name",faker.name().fullName());
        js.put("gender","female");
        js.put("email",faker.internet().emailAddress());
        js.put("status","active");


        int id= (Integer) context.getSuite().getAttribute("user_id");

     given()
                .headers("Authorization","Bearer "+Bearer_Token)
                .contentType("application/json")
                .body(js.toString())
                .pathParam("id",id)
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();



    }
}
