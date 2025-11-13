Feature: Circle Membership Functionality

Scenario: Clicking on Circle Membership opens the available Plans 
Given the user is on Apollo247 homepage
When the user clicks on Circle Membership
Then the plans for you page is visible 

@Join
Scenario: Navigate to Join Circle from CircleMembership
    Given the user on Apollo247 homepage
    When the user clicks on the Circle Membership
    And the user clicks on Join Circle
    And join circle page is displayed
    Then any one plan is selected
    



Scenario: Complete login and prepare for payment after selecting plan
    Given the user is on the Apollo247 homepage
    When the user clicked on Circle Membership
    And the user clicked on Join Circle
    And join circle page is visible
    And the user clicks on Login to Continue
    And the user enters phone number
    And the user clicks on Continue
    And wait for OTP entry
    And the user clicks on Verify after entering OTP manually
    Then user is logged in



