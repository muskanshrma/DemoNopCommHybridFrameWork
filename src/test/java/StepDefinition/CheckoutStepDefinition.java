package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CheckoutStepDefinition extends BaseClass{

    @When("user logs in and add product to cart and checkout")
    public void addProductToCart() throws IOException {
        pageFactory.getAddToCartAndCheckout().addToCart();
    }

    @Then("Order is placed successfully")
    public void productOrderPlaced() throws IOException {
        pageFactory.getAddToCartAndCheckout().verifyOrderPlaced();
        close();
    }
}