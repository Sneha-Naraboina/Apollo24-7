Feature: Circle Membership Functionality

Scenario: Clicking on Circle Membership opens the available Plans 
Given the user is on Apollo247 homepage
When the user clicks on Circle Membership
Then the plans for you page is visible 

@Join
Scenario: Navigate to Join Circle from CircleMembership
    Given the user on Apollo247 homepage2
    When the user clicks on the Circle Membership
    And the user clicks on Join Circle
    And join circle page is displayed
    Then any one plan is selected
    


#@no
#Scenario: Complete login and prepare for payment after selecting plan
    #Given the user is on the Apollo247 homepage
    #When the user clicked on Circle Membership
    #And the user clicked on Join Circle
    #And the user clicks on Login to Continue
    #And the user clicks on search mobile number
    #And the user enters phone number from <rowIndex>
    #And the user clicks on Continue
    #And wait for OTP entry
    #And the user waits for OTP and clicks verify
    #Then user should be logged in Succesfully

#Examples: 
   #| rowIndex |
   #|  0  	   |
 
  
 @coupon
 Scenario: Entering Coupons
    Given the user is on the Apollo247 homepage3
    When the user clicked on the Circle Membership
    And the user clicks on the Join Circle
    And the user clicks on the apply Coupon
    And the user enters coupon code from <rowIndex>
    Then the user clicks on Cancel
    
 Examples:
    | rowIndex |
    |    0     |
    
    
@tandc
Scenario: To view terms and Conditions
   Given the user is on the Apollo247 homepage4
   When the user clicks on Circle Membership4
   And user clicks on the Join Circle4
   And the user clicks on Login to Continue
   And user clicks on the terms
   Then terms and Conditions page should be displayed
   
   
@location
Scenario: To enter pincode
  Given the user is on the Apollo24 homepage5
  When the user clicks on Buy Insurance
  And user navigates to insurance page
  And the user clicks on Change Location
  And the user enters the pincode from sheet <sheet> and row <row>
  Then user clicks on submit
  
Examples: 
	| sheet | row |
	|   2   |  0  |
	|   2   |  1  |
   
   
   
   
   
   