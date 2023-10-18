package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC04_PartialUpdateBooking extends HerokuAppBaseUrl {

    /*
 Given
             https://restful-booker.herokuapp.com/booking/:id
             And
             {
             "firstname" : "Ugur",
             "lastname" : "Iyigünler"
}

 When
 Kullanici PATCH Request gönderir

 Then
 Status Code : 200
 And
 {
    "firstname" : "Ugur",
    "lastname" : "Iyigünler",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
 */

    @Test
    public void partialUpdateBooking() {

        spec.pathParams("first","booking", "second",bookingId);

        HerokuAppTestData obj=new HerokuAppTestData();
 Map<String, Object> payLoad=obj.getPayLoad("Ugur", "Iyigunler", null, null, null, null);




        Response response=given(spec).body(payLoad).when().patch("{first}/{second}");
        Map<String, Object> actualData=response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("firstname"),actualData.get("Firstname"));
        assertEquals(payLoad.get("Lastname"),actualData.get("Lastname"));

    }
}