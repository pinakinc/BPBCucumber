Feature: To test login functionality to www.freecrm.com

  Scenario Outline: To test a successful login
    Given User navigates to the login page
    When User enters "<userName>" as username
    And User enters "<password>" as password
    And User clicks the Login button
    Then User should be shown User Name on top left corner

    Examples: 
      | userName  | password  |
      | admin     | admin     |
      | superuser | superuser |
