import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TrelloTest {
    public static RequestSpecification req;
    public static ResponseSpecification response;

    public TrelloTest(){
        req = Authentication.getTrelloAuthentication();
        response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
    }


    @Test
    public void testGit(){
        given().spec(req).log().all().
                when().get("/members/me/boards").
                then().spec(response).log().all();
    }
}
