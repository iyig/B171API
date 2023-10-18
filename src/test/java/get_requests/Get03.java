package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get03 {
    @Test
    public void get03() {
   //Set the URL
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/9898";

        //Set the expected

        //3.Send the request and get the response

        given()
                .when()
                .then()//4.Do assertion
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 404 Not Found")
                .body("name",containsString("Pamuk"))
                .body("status", equalTo("available"))
                .body("category.name",equalTo("Köpek"))
                .body("tags[0].name",equalTo("Sibirya Kurdu"));
    }

    @Test
    public void get03SoftAssertion() {


        //1.set the URL

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/9898";

        //2.Set the expected data

        // 3.Send the request and get the response
        given()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name",containsString("Pamuk")
                ,"status", equalTo("available")
                ,"category.name",equalTo("Köpek")
                ,"tags[0].name", equalTo("Sibirya Kurdu"));
    }
}
