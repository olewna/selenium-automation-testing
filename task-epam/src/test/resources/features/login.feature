Feature: User Login

  Scenario: Test error message when no username is given
    Given User is on the login page "https://www.saucedemo.com/"
    When User writes wrong credentials
    And User deletes credentials
    And User clicks login button
    Then Error message should contain "Username is required"

  Scenario: Test error message when no password is given
    Given User is on the login page "https://www.saucedemo.com/"
    When User types credentials into fields and deletes only password field
    And User clicks login button
    Then Error message should contain "Password is required"

  Scenario Outline: Validate dashboard title after login
    Given User logs on "https://www.saucedemo.com/" with username "<username>" and password "<password>"
    When Homepage is loaded
    Then Dashboard title should be "Swag Labs"
    Examples:
      | username | password |
#      | locked_out_user | secret_sauce |
      | standard_user | secret_sauce |
      | problem_user | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user | secret_sauce |
      | visual_user | secret_sauce |
