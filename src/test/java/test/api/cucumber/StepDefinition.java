package test.api.cucumber;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import test.api.RequestManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    String url;
    Response response;


    @Given("I set endpoint {string}")
    public void iSetEndpoint(String endPoint) {
        this.url = endPoint;
    }

    @When("I send {string} request")
    public void iSendRequest(String method) {
        response = RequestManager.get(url);
    }

    @Then("I validate the status code is {string}")
    public void iValidateTheStatusCodeIs(String statusCode) {
        assertEquals( String.valueOf(response.statusCode()), statusCode);
    }
}
