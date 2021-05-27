package test.api.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import test.api.RequestManager;

public class Hooks {
    Response resBoard;
    Helper helper;

    public Hooks(Helper helper) {
        this.helper = helper;
    }

    @Before("@createBoard")
    public void createBoard() {
        Response res = RequestManager.post("/boards", "{\"name\" : \"newBoard_T\"}");
        helper.mapa.put("brd", res);
    }

    @After("@createBoard")
    public void deleteBoard() {
        Response response = (Response) (helper.mapa.get("brd"));
        RequestManager.delete("/boards/" + response.path("id"));
    }
}