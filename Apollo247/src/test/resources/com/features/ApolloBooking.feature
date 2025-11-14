Feature: Validate Find Doctors functionality on Apollo Pharmacy website
  @TC_01
  Scenario: Verify Find Doctors page and search bar visibility
    Given User opens Apollo Pharmacy homepage
    When User clicks on Find Doctors
    Then Validate the title of the webpage

  @TC_02
  Scenario: Validate Browse by Specialty and navigate to Dermatology doctors
    Given User opens Apollo Pharmacy homepage
    When User clicks on Find Doctors
    Then Validate that Browse by Specialty option is displayed
    And User clicks on Dermatology
    Then User should navigate to Dermatologists page
    
   @TC_03 
    Scenario Outline: Book an online consultation
     Given the user is on the Apollo Pharmacy homepage
     When the user applies filters <sheetno><rowno> to find doctors
     And selects a doctor from the filtered list and clicks on Online Consult
     And clicks on Continue
     Then validate tha login popup
     
      
   Examples:
   |sheetno|rowno|
   |   0   |  0  |
   |   0   |  1  |
 

   @TC_04
   Scenario Outline: Invalid Doctor search
   Given User clicks on Dermatology and navigated to Dermatologist page
   When User search on search bar
   And search for invalid Doctor names <sheetno><rowno>
   Then No results found message should be displayed 
   
  Examples:
   |sheetno|rowno|
   |   1   |  0  |
   |   1   |  1  |
   
 	#@TC_05
 	#Scenario: Try booking without login
 	# Given User is on home page and navigated to booking page
    # When User is not logged in 
    # And User tries to book a consultation
    # Then the user should be redirected to the login page

 


