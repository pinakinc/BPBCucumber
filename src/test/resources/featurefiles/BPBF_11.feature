Feature: To test login functionality to www.freecrm.com

  Scenario: To test a successful login
    Given User navigates to the login page
    When User enters "admin" as username
    And User enters "admin" as password
    And User clicks the Login button
    Then User should be shown User Name on top left corner
