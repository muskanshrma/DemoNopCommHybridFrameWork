Feature: HomePage functionalities

  Scenario: Successfully register with valid details and logout
    Given User is on Homepage
    When User navigates to register page and enters valid details and clicks on register button
    Then User is registered

  Scenario: Add and Compare two products in comparison page
    Given User is on Homepage
    When User clicks on compare button on 2 products and navigates to compare page
    Then User can Compare products