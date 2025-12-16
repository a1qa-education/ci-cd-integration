Feature: Demo test

  Background:
  Given main page is open

  @ui
  @Epic("Buttons")
  @Feature("Remove_buttons")
  @Story("Check_valid_buttons")
  @Severity(SeverityLevel.HIGH)
  @Test
  Scenario: Remove button
    When user clicks link 'Add/Remove Elements'
      And user click Add button
    Then remove button is displayed

  @ui
  @Epic("Login")
  @Feature("Authentication")
  @Story("Valid_user_login")
  @Severity(SeverityLevel.CRITICAL)
  Scenario Outline: Login page
    When user clicks link 'Form Authentication'
      And user inputs login "<login>"
      And user inputs password "<password>"
      And user click Login button
    Then message about <status> login is displayed
    Examples:
      | login        | password             | status        |
      | tomsmith     | SuperSecretPassword! | successful    |
      | tomsmith     | wrongpass            | unsuccessful  |
      | unknown      | anypass              | successful    |

  @ui
  @Epic("Login")
  @Feature("Authentication")
  @Story("Valid_user_login")
  @Severity(SeverityLevel.CRITICAL)
  Scenario: Login page negative check
    When user clicks link 'Form Authentication'
      And user inputs credentials
      | login     | password            |
      | tom smith | SuperSecretPassword!|
    And user click Login button
    Then message about unsuccessful login is displayed