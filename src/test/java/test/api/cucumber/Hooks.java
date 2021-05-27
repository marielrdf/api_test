package test.api.cucumber;

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
        resBoard = RequestManager.post("/boards" , "{\"name\" : \"newBoard_T\"}");
    }
}