Feature: Shop by Category Functionality


Scenario: User Landing on HomePage
Given the user is on the Apollo 247 homepage
When the user clicks on Health Monitors under Shop by Category
Then the categories page should be displayed

Scenario: User Landing on Health Monitors Page
Given the user is on Health Monitors Page
When the user clicks on Brands 
And verify the Brands has multiple options 
And user click on ApolloPharmacy option
And user click on Doctors choice option
Then user select multiple option at a time



