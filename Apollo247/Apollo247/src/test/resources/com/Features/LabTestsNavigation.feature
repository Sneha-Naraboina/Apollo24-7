Feature:	Lab Tests Navigation

Verify that user can navigate to Lab Tests page from homepage
@ViewAllPage
Scenario: Navigate  to Lab Tests page

Given user is on Apollo247 Homepage
When user clicks on Lab Tests Link
And user clicks on View All Link
Then should be display View All page

@CartFunctionality
Scenario: Add a test to the cart and verify cart count
    Given user is on Apollo247 Homepage
    When user clicks on Lab Tests Link
    And user clicks on View All Link
    Then should be display View All page
    When I click on the Add to Cart button for a test
    Then a pop-up should appear at the bottom right of the page

@SortBy
Scenario Outline: Navigate to Lab Tests and apply Sort By option
    Given user is on Apollo247 Homepage
    When user clicks on Lab Tests Link
    And user clicks on View All Link
    Then should be display View All page
    When I click on the Sort By dropdown
    And I select SortOption from Excel <sheetno> <row>
    Then the list of lab tests should be display
 


Examples:
| sheetno | row |
| 0       | 1   |
| 0       | 2   |
