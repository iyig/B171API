package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class Get02 {

    @Test
    public void get02() {
/*

        2. Set the expected data
        3. Send the request and get the response
        4. Do assertion
    */
// 1. Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/0";
       // 2. Set the expected data
        /*
    Bu işlem basamağını POST, PUT gibi body gerektiren sorgularda ve
    GET, DELETE gibi response'tan beklediğimiz datayı biliyorsak kullanabilirz.
*/

   // 3. Send the request and get the response
  Response response= given().when().get();
  response.prettyPrint();

  //Do assertion

  response
        .then()
          .statusCode(404)
          .statusLine("HTTP/1.1 404 Not Found")
          .body(containsString("Pet not found"))
          .body(not(containsString("TechProEd")))
          .header("Server", "Jetty(9.2.9.v20150224)");
    }
}