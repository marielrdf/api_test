import io.cucumber.java.en.*;

public class MyStepdefs {
    @Given("test hola mundo")
    public void testHolaMundo() {
        System.out.println("hola mundo ");
    }
}
