@NegativeGrid
Feature: To verify text on Homepage of www.freecrm.com

  Scenario: To verify user name on Homepage
    Given The user opens the "chrome" browser on "windows" and "grid"
    When The user navigates to the landing page
    And The user clicks the Login button on the landing page
    And The user enters "chaubalpinakin@gmail.com" as username
    And The user enters "Pc9121975!" as password
    And The user clicks the Login button
    Then The user should be shown "Pinakin Chaubal1" on top left corner
