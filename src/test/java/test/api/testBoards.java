package test.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import test.api.Authentication;
import test.api.Board;
import test.api.RequestManager;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBoards {
    public static RequestSpecification req;
    public static ResponseSpecification response;
    private Response res;
    private Board newBoard;

    public testBoards(){
        req = Authentication.getTrelloAuthentication();
        response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
    }


    @BeforeEach
    public void postBoards(){
        Response responsePost = RequestManager.post("/boards" , "{\"name\" : \"newBoard_T\"}");
        newBoard = responsePost.as(Board.class);
        System.out.println(newBoard.getId() +"    "+newBoard.getName() + "   " + newBoard.isClosed());
    }

    @Test
    public void getBoards(){
        String id = newBoard.getId();
        Board getTest = RequestManager.get("/boards/"+id).as(Board.class);
        assertEquals( id, getTest.getId());
        assertEquals( newBoard.getName(), getTest.getName());
    }

    @AfterEach
    public void deleteBoards(){
        String id = newBoard.getId();
        RequestManager.delete("/boards/"+id);
    }
}
