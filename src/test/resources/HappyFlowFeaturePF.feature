@Sanity1
Feature: To verify details on Homepage of www.freecrm.com

  Scenario: To verify user name on Homepage
    Given The user opens the "chrome" browser on "windows" and "local"
    When The user navigates to the landing page
    And The user clicks the Login button on the landing page
    And The user enters "chaubalpinakin@gmail.com" as username
    And The user enters "Pc9121975!" as password
    And The user clicks the Login button
    Then The user should be shown "Pinakin Chaubal" on top left corner
  
  Scenario: To verify account type on Homepage
    Given The user opens the "chrome" browser on "windows" and "local"
    When The user navigates to the landing page
    And The user clicks the Login button on the landing page
    And The user enters "chaubalpinakin@gmail.com" as username
    And The user enters "Pc9121975!" as password
    And The user clicks the Login button
    Then The user should be shown "Free account1" for the account type
    
