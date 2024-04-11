package day7;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentications {

    @Test(priority = 1)
    void basicAuth(){

        given()
                .auth().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true))
                .log().all();

    }
    @Test(priority =2)
    void DigestAuth(){

        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true))
                .log().all();

    }
    @Test(priority =3)
    void PreemptiveAuth(){

        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .body("authenticated",equalTo(true))
                .log().all();

    }
    @Test(priority =4)
    void BearerToken(){

        String bearertoken="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";
        given()
                .headers("Authorization","Bearer "+bearertoken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();

    }
    //@Test
    void oauth1(){


        given()
                .auth().oauth("consumerkey","consumersecret","accesstoken","tokensecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test(priority =5)
    void oauth2() {


        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }
}
