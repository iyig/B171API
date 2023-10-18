package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends HerokuAppBaseUrl {
/*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
      {
            "firstname": "Bradley",
            "lastname": "Pearson",
            "totalprice": 132,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2022-10-27",
                "checkout": "2022-11-07"
            },
            "additionalneeds": "None"
        }
     */

    @Test
    public void get07() {
        // Set the URL
  spec.pathParams("first","booking","second", 23);


         //Set the expected date

        //Send the request and get the response
        Response response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();

//Do assertion
       //1.YOl
     //   response.then()
            //    .statusCode(200)
            //    .contentType(ContentType.JSON)
           //     .body("firstname", equalTo("John"))
          //      .body("lastname", equalTo("Smith"))
          //      .body("totalprice", equalTo(111))
          //      .body("depositpaid", equalTo(true))
         //       .body("bookingdates.checkin", equalTo("2018-01-01"))
            //    .body("bookingdates.checkout", equalTo("2019-01-01"))
             //   .body("additionalneeds", equalTo("Breakfast"));

        // JsonPath alıştırmaları
       JsonPath json= response.jsonPath();
        String firstname = json.getString("firstname");
        System.out.println("Firstname :"+ firstname);


        int totalprice=json.getInt("totalprice");
        System.out.println("Total Price:"+ totalprice);


        String checkIn=json.getString("bookingdates.checkin");
        System.out.println("CheckIn:" + checkIn);

        //2.Yol
   assertEquals(200,response.statusCode());
   assertTrue( response.contentType().contains("application/json"));
   assertEquals("Josh", json.getString("firstname"));
   assertEquals("Allen", json.getString("lastname"));
   assertEquals(111, json.getInt("totalprice"));
   assertTrue( json.getBoolean("depositpaid"));
   assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
   assertEquals("2019-01-01", json.getString("bookingdates.checkout"));
        assertEquals("superb owls", json.getString("additionalneeds"));
    }
}
