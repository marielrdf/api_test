package test.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestManager {

    private static RequestSpecification requestSpecification = Authentication.getTrelloAuthentication();

    public static Response get(String url) {
        return given().spec(requestSpecification)
                .when().log().all()
                .get(url);
    }

    public static Response post(String url, String body) {
        return given().spec(requestSpecification)
                .body(body)
                .when().log().all()
                .post(url);
    }

    public static Response delete(String url) {
        return given().spec(requestSpecification)
                .when().log().all()
                .delete(url);
    }
}
