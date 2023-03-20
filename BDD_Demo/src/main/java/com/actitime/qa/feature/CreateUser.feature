Feature: After logged in I should be able to create a user

  @TC_002
  Scenario Outline: Create user
    Given User in the Actitime home page
    When User clicks on users tab
    Then User clicks on new user button
    Then Fill up user data
    Then Click on save and send invite button
    Then User should get added successfully
    Examples:
      |  |