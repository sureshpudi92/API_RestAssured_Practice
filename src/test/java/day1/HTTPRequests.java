package day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
given()--content type,authentication,add param,set cookies,headers..etc
when()--get,post,put,delete
then()--validate status code,response ,headers..etc

 */
public class HTTPRequests {

    int id;

    @Test(priority = 1)
    void getUser(){

        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                . then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }
    @Test(priority = 2)
    void createUser(){

        HashMap data=new HashMap();
        data.put("name","suresh");
        data.put("job","engineer");

       id= given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("https://reqres.in/api/users")
               .jsonPath().getInt("id");
                //.then()
                //.statusCode(201)
                //.log().all();

    }
    @Test(priority = 3,dependsOnMethods = {"createUser"})
    void UpdateUser() {

        HashMap data = new HashMap();
        data.put("name", "rakesh");
        data.put("job", "teacher");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(201)
                .log().all();
    }
    @Test(priority = 4)
    void deleteUser(){

        given()
                .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204).log().all();
    }

}
