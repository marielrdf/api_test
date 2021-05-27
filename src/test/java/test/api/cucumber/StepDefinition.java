package test.api.cucumber;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import test.api.RequestManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    String url;
    String body;
    Response response;

    Helper helper;

    public StepDefinition(Helper helper) {
        this.helper = helper;
    }

    @Given("I set endpoint {string}")
    public void iSetEndpoint(String endPoint) {
        this.url = Utils.buildEndpoind(helper, endPoint);
    }

    @When("I send {string} request")
    public void iSendRequest(String method) {
        if (method.equals("POST")) {
            response = RequestManager.post(url, body);
        }
        if (method.equals("GET")) {
            response = RequestManager.get(url);
        }
    }

    @Then("I validate the status code is {string}")
    public void iValidateTheStatusCodeIs(String statusCode) {
        assertEquals(String.valueOf(response.statusCode()), statusCode);
    }

    @And("I set a body")
    public void iSetABody(String body) {
        this.body = body;
    }
}
