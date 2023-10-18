package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationContactList {
    public static void main(String[] args) {
        System.out.println(generateToken());
    }

    public static String generateToken(){
        String body = "\n" +
                "    \"email\": \"kwasi.willson@free2ducks.com\",\n" +
                "    \"password\": \"1234567\"\n" +
                "}";

        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        response.prettyPrint();

        return response.jsonPath().getString("token");
    }

}
