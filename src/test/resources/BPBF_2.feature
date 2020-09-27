Feature: Test for a DataTable

  Scenario: To test a successful login
    Given User navigates to the login page
    Then Verify that following users are able to Login
      | userName | password |
      | KamleshP | xyz      |
      | RamK     | abc      |
      | MikeP    | mkpe     |
