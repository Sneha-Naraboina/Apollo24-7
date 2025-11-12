Feature: Search Medicines on Apollo 24/7

  Scenario: Search with valid medicine name
    Given user has to be on Home page
    When Navigate to Buy Medicine
    And Navigate to Searchbar
    And Enter valid medicine name
    And Click search
    Then search related products should be displayed
    
    
    
    
    
    
    
    
    
 @verify	
 Scenario: Verify Browse by Health Conditions section is visible and clickable
 	Given user be on buy medicine page
    When  user navigates to Browse by Health Conditions
    And click on Diabetes care
    Then health conditions element should be displayed
    
    





   
