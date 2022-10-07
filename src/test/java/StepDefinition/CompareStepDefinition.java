package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CompareStepDefinition extends BaseClass{

    @When("User clicks on compare button on 2 products and navigates to compare page")
    public void addToComparison() throws IOException {
        pageFactory.getComparePage().compare();
    }

    @Then("User can Compare products")
    public void productComparison() throws IOException {
        pageFactory.getComparePage().verifyComparison();
        close();
    }
}