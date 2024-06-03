
@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on E-commerce Page
    When I am logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name					  | password 	   |
      | guusje@test.com | Testing1233. |
