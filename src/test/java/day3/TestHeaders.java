package day3;
import io.restassured.http.Header;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

public class TestHeaders {

    @Test
    void testheaders_value(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Server","gws");


    }

    @Test
    void getheaders(){

        Response res=given()
                .when()
                .get("https://www.google.com/");

        //get single header
        String headervalue=res.getHeader("Content-Type");
        System.out.println("value of Content-Type is "+headervalue);

        Headers myheaders= res.getHeaders();
        for (Header hd:myheaders){

            System.out.println(hd.getName()+"   "+hd.getValue());

        }
    }
}
