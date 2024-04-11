package day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Cookies {

    @Test
    void getcookies(){

        given()
                .when()
                .get("https://www.google.com/")
                .then()
                //.cookie("AEC","Ae3NU9PL-peSTyw92Wl5Oe4zrLaO8uMbbYcjKjX17S-AYjZAcvSxyJbFHQ")
                .log().all();


    }

    @Test
    void Allcookieinfo(){

       Response  res =given()
                .when()
                .get("https://www.google.com/");

       //get single cookie
      String Cookie_value =res.getCookie("AEC");
        System.out.println("value is  "+Cookie_value);

        //get all cookies

        Map<String,String>cookies_values=res.getCookies();
        System.out.println(cookies_values.keySet());

        for(String K:cookies_values.keySet()){

            String Cookie_values =res.getCookie(K);
            System.out.println((K+"    "+Cookie_values));
        }




    }

}
