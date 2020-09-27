Feature: login Page functionality
  In order to test login functionality
  As a Registered user
  Check user login conditions

  Scenario: Positive login flow
    Given user is on Application home page
    And Log in button is present on screen
    When user clicks on Log in button
    Then user is shown login screen
    When user enters "mikeP" in username field
    And user enters "123456" in password field
    And user clicks Log in button
    Then user is on home page
    And title of home page is "FreeCRM-HR Unlimited"

  Scenario Outline: Login failure
    Given user is on Application home page
    When user clicks on Sign in button
    Then user is displayed login screen
    When user enters "<UserName>" in username field
    And user enters "<Password>" in password field
    And user clicks Log in button
    Then user gets login failed error message

    Examples: 
      | userName  | Password |
      | incorrect |   123456 |
      | pinakinc  | wrongpwd |
      | wrongusr  | wrongpwd |

  Scenario: Existing user Verification
    Given user is on Application home page
    Then we verify following user exists
      | userName | Password |
      | Pinakinc | test123  |
      | tester   | yyy123   |
