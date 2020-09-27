Feature: To test Contact and Deal creation functionality

  Background: 
    Given User navigates to the login page
    When User enters “admin” as username
    And User enters “admin” as password
    And User clicks the Login button

  Scenario: To test a successful contact creation
    Given User creates a new Contact
    Then User should be shown Contact Confirmation page

  Scenario: To test a successful Deal creation
    Given User creates a new Deal
    Then User should be shown Deal Confirmation page
