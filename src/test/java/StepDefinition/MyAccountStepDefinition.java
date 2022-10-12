package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class MyAccountStepDefinition extends BaseClass{

    @When("User clicks on my account button and edits details and clicks save button")
    public void editAccountDetails() throws IOException {
        pageFactory.getMyAccountPage().editDetails();
    }

    @Then("User details are saved")
    public void saveDetails() throws IOException {
        pageFactory.getMyAccountPage().verifyEdit();
        close();
    }
}