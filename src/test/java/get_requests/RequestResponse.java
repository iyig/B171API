package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/9898";

        Response response = given().when().get(url);
       // response.prettyPrint();

   // Status kod nasıl yazdırılır?
        System.out.println("Status Kod: " +response.statusCode());
        System.out.println("response.contentType = " + response.contentType());

        //Status Line Nalıl yazdırılır?
        System.out.println("Status line:"+ response.statusLine());

        // Header bölümünden bir başlık nasıl yazdırılır

        System.out.println("Header | Server:" + response.header("Server"));

        //Header bölümündeki tüm başlıklar nasıl yazdırılır

        System.out.println("Headers: \n" + response.headers());

        //Time bilgisi nasıl yazdırılır

        System.out.println("Time: " + response.time());
    }
}

