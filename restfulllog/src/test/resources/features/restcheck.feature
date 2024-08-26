#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
Feature: verify restassured using pojo
Scenario Outline: check get functionalities
Given I enter the <baseuri>
And I assing resquest specification
And I enter header
And I enter enteries
And I take response
And I print response
And I take id from table
And I take get geturi
And I assing resquest specification
And I enter header
And I take get response
And I print response
And I take put uri
And I assing resquest specification
And I enter header
And I enter put enteries
And I take put response
And I print response
And I take delete uri
And I assing resquest specification
And I enter header
And I take delete response
And I print response
Examples:
|baseuri|
|http://localhost:8082/sgtest-employee/api/v1/employees|


