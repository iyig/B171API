package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.Before;
import io.restassured.specification.RequestSpecification;

public class PetStoreBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }
}
