Feature: To verify text on Homepage of www.freecrm.com

  Scenario: To verify user name on Homepage
    Given I open the "chrome" browser on "windows" and "local"
    When User navigates to the landing page
    And clicks the Login button on the landing page
    And User enters "chaubalpinakin@gmail.com" as username
    And User enters "Pc9121975!" as password
    And User clicks the Login button
    Then User should be shown "Pinakin Chaubal" on top left corner
