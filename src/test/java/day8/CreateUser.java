package day8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

public class CreateUser {

    @Test
    void test_CreateUser(ITestContext context){
        String Bearer_Token="5c566de61251e064a557b5f7163ef5761edfee9da4f65c62a206066cddb53154";
        Faker faker=new Faker();
        JSONObject js=new JSONObject();
        js.put("name",faker.name().fullName());
        js.put("gender","male");
        js.put("email",faker.internet().emailAddress());
        js.put("status","inactive");

         int id=given()
                .headers("Authorization","Bearer "+Bearer_Token)
                .contentType("application/json")
                .body(js.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                        .jsonPath().getInt("id");

         System.out.println("Generated id id "+id);
       // context.setAttribute("user_id",id);// test level
       context.getSuite().setAttribute("user_id",id);// suite level




    }

}
