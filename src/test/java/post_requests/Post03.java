package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.jsonplaceholder.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {


    @Test
    public void post03() {
   spec.pathParam("first","todos");

   //set teh expected data
        JsonPlaceHolderPojo payLoad=new JsonPlaceHolderPojo(55,"Tidy your room", false);

   //Send the request and get the response
        Response response=given(spec).body(payLoad).when().post("{first}");//Serialization
        response.prettyPrint();

        //Do assertion
                 JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class);// De-serialization
        assertEquals(201, response.statusCode());
        assertEquals(payLoad.getUserId(),actualData.getUserId());
        assertEquals(payLoad.getTitle(),actualData.getTitle());
        assertEquals(payLoad.getCompleted(),actualData.getCompleted());

    }
}
