import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Authentication {

    static RequestSpecification getTrelloAuthentication(){
        return new RequestSpecBuilder().setBaseUri("https://api.trello.com/1")
                .addQueryParam("key", "a5c14264c267638eef4d4bc13e666b81")
                .addQueryParam("token", "165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63")
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
