package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class RegisterStepDefinition extends BaseClass{

    @Given("User is on Homepage")
    public void website() throws IOException {
        setup();
    }

    @When("User navigates to register page and enters valid details and clicks on register button")
    public void registrationDetails() throws IOException {
        pageFactory.getRegisterUser().registerUser();
    }

    @Then("User is registered")
    public void user_is_registered() throws IOException {
        pageFactory.getRegisterUser().verifyHomepage();
        close();
    }
}