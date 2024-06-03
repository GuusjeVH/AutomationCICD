
@tag
Feature: Purchase the order from E-commerce Website
  I want to use this template for my feature file

	Background: 
	Given I landed on E-commerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given I am logged in with username <name> and password <password>
    When I add the product <productName> from Cart
    And I checkout <productName> and submit the order
    Then I verify the confirmation message "THANKYOU FOR THE ORDER." is displayed
    Examples: 
      | name					  | password 		|	productName	|
      | guusje@test.com | Testing123. |	ZARA COAT 3 |