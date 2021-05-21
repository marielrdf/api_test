
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    public static RequestSpecification req;
    public static ResponseSpecification response;

    public Test1(){
        req = new RequestSpecBuilder().setBaseUri("https://api.github.com").build();
        response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
    }


    @Test
    public void testGit(){
        given().spec(req).log().all().
                when().get("/users/lufercc").
                then().spec(response).log().all();
    }

    @Test
    public void testFail(){
        given().log().all().
                when().get("https://ssl.gstatic.com/gb/images/a/99be7c5086.png").
                then().spec(response).log().all();
    }

    @Test
    public void testGetRepos(){
        given().spec(req).log().all().
                when().get("/users/lufercc/repos").
                then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void testBaseUrl(){
        Response res = given().spec(req).log().all().
            when().get("/users/lufercc")
                .then().log().all().extract().response();

        String name = res.path("login");
        int id = res.path("id");

        assertEquals( "luferccc", name);
        System.out.println("this is the id: "+ id +" and name: " + name);

    }
}
