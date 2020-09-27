@Regression
Feature: To test login functionality to www.freecrm.com

  @Smoke
  Scenario: To test a successful login
    Given User navigates to the login page
    When User enters “admin” as username
    And User enters “admin” as password
    And User clicks the Login button
    Then User should be shown User Name on top left corner

  @Sanity
  Scenario: To test a unsuccessful login with incorrect username
    Given User navigates to the login page
    When User enters “admin1” as username
    And User enters “admin” as password
    And User clicks the Login button
    Then User should be shown the login page

  @Negative
  Scenario: To test a unsuccessful login with incorrect password
    Given User navigates to the login page
    When User enters “admin” as username
    And User enters “admin1” as password
    And User clicks the Login button
    Then User should be shown the login page
