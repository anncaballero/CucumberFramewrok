Feature: Report

Background:
Given I am logged into HRMS
And I navigated to the Reports page

Scenario: Search for invalid report
When I enter invalid report
And I click the search button
Then I see no records found message

Scenario: Search for valid report
When I enter valid report
And I click the search button
Then I see the search report is displayed

