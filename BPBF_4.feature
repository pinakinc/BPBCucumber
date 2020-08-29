Feature: Test for a DataTable

  Scenario Outline: To test a successful login
    Given User navigates to the login page
    Then Verify that "<userName>" are able to Login to the System

    Examples: 
      | userName | password |
      | KamleshP | xyz      |
      | RamK     | abc      |
      | MikeP    | mkpe     |
