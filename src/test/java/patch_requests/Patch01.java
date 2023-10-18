package patch_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_Data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
    @Test
    public void patch01() {


//set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data

        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> payLoad = obj.getPayLoad(null, "Wash the dishes", null);
        Map<String, Object> expectedData = obj.getPayLoad(10, "Wash the dishes", true);
        //Send teh request and get the responsd
        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
    }
}