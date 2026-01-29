Feature: Facebook login

  Scenario: Login with data from Excel
    Given user reads login data from Excel
    When user logs into Facebook
    Then user should see the homepage