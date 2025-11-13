Feature: Shop by Category Functionality


Scenario: User Landing on HomePage
Given the user is on the Apollo 247 homepage
When the user clicks on Health Monitors under Shop by Category
Then the categories page should be displayed


#Scenario: User Landing on Health Monitors Page
#Given the user is on Health Monitors Page
#When the user clicks on Brands 
#And user selects on ApolloPharmacy option
#And user selects on Doctors choice option
#Then user select multiple option at a time

Scenario: user Landing on HealthMonitors Page
Given the user is on Health Monitors Page
When the user clicks on Apollo products
And user clicks on personal care products
And user clicks on Baby care prodcuts
Then user clicls on OTC products

Scenario: user Landing on Nutritional Drinks and Supplements page
Given the user is on Nutritional Drinks and Supplements page
When the user clicks on Nutritional Drinks and Supplements
And the user clicks on Nutritional Drinks
And the user clicks on Sports Nutrition
Then the user verifies the Sports Nutrition page is displayed




  











