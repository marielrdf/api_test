import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Boards {
    public static RequestSpecification req;
    public static ResponseSpecification response;
    private Response res;
    private Board newBoard;

    public Boards(){
        req = Authentication.getTrelloAuthentication();
        response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
    }


    @BeforeEach
    public void postBoards(){
        newBoard = given().spec(req).body("{\"name\" : \"newBoard_T\"}")
                .log().all().
                when().post("/boards").as(Board.class);
    }

    @Test
    public void getBoards(){
        String id = newBoard.getId();
        given().spec(req).body("{\"name\" : \"newBoard_T\"}")
                .log().all().
                when().get("/boards/"+id).
                then().spec(response).log().all();
    }

    @AfterEach
    public void deleteBoards(){
        String id = newBoard.getId();
        given().spec(req)
                .log().all().
                when().delete("/boards/"+id).
                then().spec(response).log().all();
    }
}
