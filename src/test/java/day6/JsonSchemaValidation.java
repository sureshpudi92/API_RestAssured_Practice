package day6;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidation {

    @Test
    void SchemValidation(){

        given()
                .when()
                .get("http://localhost:3000/students/1")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("studentsjsonschema.json"));
    }


}
