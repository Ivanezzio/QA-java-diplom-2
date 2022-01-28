import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseSpec {
    public RequestSpecification getBaseSpecs(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://stellarburgers.nomoreparties.site/")
                .build();
    }
}
