package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/*
Different ways to create post request
HashMap
using org.json
using POJO class(plain old java object)
using external json file
 */

public class PostCreationWays {

    // @Test
    void Postusinghashmap() {

        HashMap data = new HashMap();
        data.put("name", "Surya");
        data.put("location", "india");
        data.put("phone", "1234345");
        String coursesArr[] = {"java", "selenium"};
        data.put("courses", coursesArr);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Surya"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("selenium"))
                .header("Content-Type", "application/json");


    }

    // @Test
    void PostusingjsonObject() {

        JSONObject data = new JSONObject();
        data.put("name", "Surya");
        data.put("location", "india");
        data.put("phone", "1234345");
        String coursesArr[] = {"java", "selenium"};
        data.put("courses", coursesArr);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Surya"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("selenium"))
                .header("Content-Type", "application/json");


    }

   // @Test
    void PostusingPojo() {

        Post_PojoRequest data = new Post_PojoRequest();
        data.setName("Surya");
        data.setLocation("india");
        data.setPhone("1234345");
        String coursesArr[] = {"java", "selenium"};
        data.setCoursesArr(coursesArr);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Surya"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("selenium"))
                .header("Content-Type", "application/json");

    }
    @Test
    void postusingexternalfile() throws FileNotFoundException {

        File f =new File("C:\\MyProjects\\API_RestAssured\\body.JSON");

        FileReader fr=new FileReader(f);

        JSONTokener jt =new JSONTokener(fr);

        JSONObject data=new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Surya"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("selenium"))
                .header("Content-Type", "application/json");


    }
}