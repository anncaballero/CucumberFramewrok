Feature: Validating Syntax /createEmployee.php HRMS API
Background:
Given user generates token

@SyntaxHRMSAPI
Scenario: This test will check to see if an Employee has been created
Given user calls createEmployee API to verify that an emloyee was created
When User retrieves response for createEmployeeAPI
Then status code is 200 for createEmployeeAPI
Then user validates employee was created