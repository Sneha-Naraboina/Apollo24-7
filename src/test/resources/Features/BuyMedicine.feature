
Feature: Search Medicines on Apollo 24/7
@first
  Scenario: Search with valid test name
   
   Given user is on buy medicine page
   And user clicks on the Lab Tests
   And user cliks on the serach bar
   And user enters valid test name from sheet <sheet> and row <row>
   Then search related tests should be displayed
   
   Examples:

	| sheet      | row  |
	| 1          | 0    |
	| 1          | 1    |
    
    
        
 @verify	
 Scenario: Verify Browse by Health Conditions section is visible and clickable
 	Given user be on buy medicine page
    When  user navigates to Browse by Health Conditions
    And click on Diabetes care
    Then health conditions element should be displayed
    
 @sample
 Scenario Outline: Verify search functionality with different types of input
 Given the user is on the buy medicine page
   When the user clicks on search box
   And the user enters medicine name from sheet <sheet> and row <row> in the search box
    Then the system should display results
    Examples:

	| sheet      | row  |
	| 0          | 0    |
	| 0          | 1    |

@fourth
Scenario: Verify  getoffonmedicines
Given the user is on the buy medicine page
When user clicks on Get 20% off on medicine
And user navigates to the upload prescriptions page
And click on the view all categories in the product categories 
Then results should be displayed

@fifth
Scenario: Verify cart
Given the user is on the buy medicine page
When user click the first product
And click on cart icon 
Then verify no product to be visible


  
   
