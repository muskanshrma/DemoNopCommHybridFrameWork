Feature: HomePage functionalities

  Scenario: Successfully register with valid details and logout
    Given User is on Homepage
    When User navigates to register page and enters valid details and clicks on register button
    Then User is registered

  Scenario: Add and Compare two products in comparison page
    Given User is on Homepage
    When User clicks on compare button on 2 products and navigates to compare page
    Then User can Compare products

  Scenario: Edit User account details
    Given User is on Homepage
    When User clicks on my account button and edits details and clicks save button
    Then User details are saved

  Scenario: Add product to cart and checkout
    Given User is on Homepage
    When user logs in and add product to cart and checkout
    Then Order is placed successfully