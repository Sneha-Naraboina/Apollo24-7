Feature: Shop by Category Functionality


Scenario: User Landing on HomePage
Given the user is on the Apollo 247 homepage
When the user clicks on Health Monitors under Shop by Category
Then the categories page should be displayed


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



Scenario Outline: user Landing on sports nutrition page
Given the user is on Nutritional Drinks and Supplements page
When the user clicks on Nutritional Drinks and Supplements
And the user clicks on Nutritional Drinks
And the user clicks on Sports Nutrition
And the user clicks on sortBy dropdown
And user select SortOption from Excel <sheet> <row>
Then the user verifies the Sports Nutrition page is displayed

Examples:
| sheet | row |
| 0     |  1 |
| 0     |  2 |

  
 











