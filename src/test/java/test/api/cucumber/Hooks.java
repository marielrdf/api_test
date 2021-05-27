package test.api.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import test.api.RequestManager;

public class Hooks {
    Response resBoard;
    Helper helper;

    public Hooks(Helper helper){
        this.helper = helper;
    }

    @Before
    public void createBoard(){
        helper.response = RequestManager.post("/boards" , "{\"name\" : \"newBoard_T\"}");
    }

    @After
    public void deleteBoard() {
        RequestManager.delete("/boards/"+helper.response.path("id"));
    }
}