package day3;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathAndQueryParameters  {

    @Test
    void testQuerypathparameters(){

        given()
                .pathParam("mypath","users") //path params
                .queryParam("page",2)   //query params
                .queryParam("id",5)     //query parms
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
