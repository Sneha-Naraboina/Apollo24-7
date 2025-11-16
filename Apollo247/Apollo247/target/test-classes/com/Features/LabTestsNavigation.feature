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

#@SortBy
#Scenario: Navigate to Lab Tests and apply Sort By option
#    Given user is on Apollo247 Homepage
#    When user clicks on Lab Tests Link
#   And user clicks on View All Link
#   Then should be display View All page
#   When I click on the Sort By dropdown
#   And I select SortOption from Sortby
#   Then the list of lab tests should be display
 

@TopDeals
Scenario Outline: Navigate to Lab Tests and apply TopDeals and CBC Tests filters
    Given user is on Apollo247 Homepage
    When user clicks on Lab Tests Link
    And user clicks on View All Link
    Then should be display View All page
    When I select filters from Excel <sheet> <row>
    Then the filtered list of lab tests should be displayed

Examples:
| sheet | row |
| 0     |  3  |
| 0     |  4  |
    
@Search
Scenario Outline: Navigate to Lab Tests and search for test
Given user is on Apollo247 Homepage
    When user clicks on Lab Tests Link
    And user clicks on View All Link
    Then should be display View All page
    And click on search
    And Enter the Test from <sheet> and <row> in lab test for search
    And click Entered Test in search
    Then verify Test results for SearchBox

Examples:
| sheet | row |
| 1     |  1   |
| 1     |  2   |

@ViewCart
Scenario: Add a test to the cart and verify cart count
    Given user is on Apollo247 Homepage
    When user clicks on Lab Tests Link
    And user clicks on View All Link
    Then should be display View All page
    When I click on the Add to Cart button for a test
    Then a pop-up should appear at the bottom right of the page
    And click on View Details
    Then verify the Cart Details
