Feature: After logging in i should be able to create a user

  @TC_002
  Scenario Outline: Create user
    Given User in the Actitime home page
    When User click on users tab
    Then User click on new user button
    Then Fill in user data
    Then Click on save and send invite button
    Then User should get added successfully
    Examples:
      |  |