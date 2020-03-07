@sprint @login
Feature: Login

  @test
  Scenario: Valid login
    Given I open browser and navigate to the HRMS
    When I enter valid username and password
    And I click on login button
    Then I succesfully logged in

  @regression
  Scenario: Invalid login
    Given I open browser and navigate to the HRMS
    When I enter valid username and invalid password
    And I click on login button
    Then I see error message

  @regression
  Scenario Outline: Invalid LOgin and error message validation
    When I enter"<Username>" and "<Password>"
    And I click on login button
    Then I see "<ErrorMessage>"

    Examples: 
      | Username | Password   | ErrorMessage             |
      | Admin    | Admin123   | Invalid credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax@123 | Username cannot be empty |
      |          |            | Username cannot be empty |
