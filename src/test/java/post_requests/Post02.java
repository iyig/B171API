package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Post02 extends JsonPlaceHolderBaseUrl {


/*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
     */

    @Test
    public void post02() {
//Set the URL
spec.pathParam("first","todos");

String payload=" {\n" +
        "                \"userId\": 55,\n" +
        "                \"title\": \"Tidy your room\",\n" +
        "                \"completed\": false,\n" +
        "                \"id\": 201\n" +
        "            }";

//Send the request and get the response

       Response response= given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
        // do assertion

        assertEquals(200,response.statusCode());
       JsonPath json= response.jsonPath();
       assertEquals(55,json.getInt("userId"));
       assertEquals("Tıdy your room",json.getString("title"));
       assertFalse(json.getBoolean("completed"));

    }

    @Test
    public void post02Map() {


        spec.pathParam("first","todos");
        //SEt the expected data (payload)
        Map<String, Object> payload= new HashMap<>();

payload.put("userId", 55);
payload.put("title", "Tidy your room");
payload.put("completed", false);

        System.out.println(payload);

        // Send the request and get the response
 //Serialization java dataların Json datalarına dönüştürülmesi
       Response response= given(spec).body(payload).when().post("{first}");
       response.prettyPrint();

       // Do assertion
        // De-Serialization: Json datanın java datasına dönüştürülmesl
       Map<String ,Object>actualData= response.as(HashMap.class);
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));

    }
}
