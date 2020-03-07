#Author: Testing team(annscaballero@gmail.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to the Add Employee Page

  @temp
  Scenario: Add new employee
    When I add "John", "S" and "Smith"
    And I click Save
    Then I see employee has been succesfully added

  @regression
  Scenario Outline: Add new employee
    When I add "<FirstName>", "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     |            | Smith    |
      | Jane      | A          | Smith    |
      | Sasha     | A          | Smith    |
      | David     | J          | Smith    |

  @smoke
  Scenario: Add and modify employee details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | John      | J          | Smith    |
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | N78787886     | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Other         | Afghan      | 1980-10-10 |
      | Nhkjkgkhgkg   | 2018-12-08     | yiy-45-6789 | uyiy    | Female | Married       | Burmese     | 1980-10-10 |
      
  #Scenario: Add employee without employee ID
    #When I add firstName, middleName and lastName
    #And I delete employee ID
    #And I click save
    #Then I see employee without employee ID is being added
#
  #Scenario: Add employee negative scenario
    #When I click save
    #Then I see required error message next to the first and last name
#
  #Scenario: Add employee and login credentials
    #When I add firstName, middleName and lastName
    #And I click on create longin checkbox
    #And I enter username, password and confirm password
    #When I click save
    #Then I see employee has been succesfully added
    
    Scenario: Add Employee and validate database
    When I add "James", "John" and "Smith"
    And I click Save
    And I see employee has been succesfully added
    Then I collect employee data from database
    And I verify employee data is matched
    
    
