Feature: Register

  Scenario: Successfully register with valid details and logout
    Given User is on Homepage
    When User navigates to register page and enters valid details and clicks on register button
    Then User is registered

