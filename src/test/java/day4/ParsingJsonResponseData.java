package day4;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ParsingJsonResponseData {
    @Test
    void getbooknamejsonbody() {

        //Approach1
        given()
                .when()
                .get("https://simple-books-api.glitch.me/books")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("[5].name", equalTo("Viscount Who Loved Me"))
                .log().body();


    } //Approach2

    @Test
    void parsingjsonbody() {

        Response res =
                given()
                        .contentType("application/json")
                        .when()
                        .get("https://simple-books-api.glitch.me/books");
      /*  Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
        String bookname = res.jsonPath().get("[5].name").toString();  //validation 1
        Assert.assertEquals(bookname, "Viscount Who Loved Me"); */

        //validation 2

     /*   JSONArray jsonarrayobject=new JSONArray(res.asString());
        for(int i=0; i<jsonarrayobject.length();i++){
           JSONObject jsonobject=jsonarrayobject.getJSONObject(i);
           String booknames=jsonobject.getString("name");
            System.out.println(booknames);

        } */

        //validation 3
        JSONArray jsonarrayobject=new JSONArray(res.asString());

        boolean status=false;
        for(int i=0; i<jsonarrayobject.length();i++){
            JSONObject jsonobject=jsonarrayobject.getJSONObject(i);
            String bookname=jsonobject.getString("name");
            if (bookname.equals("Just as I Am")){

                status=true;
                break;
            }
        }
Assert.assertEquals(status,true);

        }
    }