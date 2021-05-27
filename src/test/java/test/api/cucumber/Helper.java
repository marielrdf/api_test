package test.api.cucumber;

import io.restassured.response.Response;

import java.util.HashMap;

public class Helper {
    Response response;
    HashMap<String, Object> mapa;

    public Helper() {
        mapa = new HashMap<>();
    }
}
