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
     When the user applies filters <rowno><sheetno> to find doctors
     And selects a doctor from the filtered list and clicks on Online Consult
     And clicks on Continue
     Then validate tha login popup
     
      
   Examples:
   |sheetno|rowno|
   |   0   |  0  |
   |   0   |  1  |
 

   @TC_04
   Scenario Outline: Valid Doctor search
   Given User clicks on Dermatology and navigated to Dermatologist page
   When User clicks on search bar
   And search for Valid Doctor names <sheetno> <rowno>
   Then List of Doctors should be displayed with that name  
   Then The selected doctor profile is displayed
   
  Examples:
   |sheetno|rowno|
   |   1  |  0  |
   |   1  |  1  |
   
   @TC_05
   Scenario: Validate ENT  doctor booking withpout login
   Given User is on Apollo Pharmacy home page
   When when user clicks on Find Doctors 
   And User clicks on ENT speciality
   Then should navigate to ENT consultation page 
   And user selects a doctor from the list of dotors 
   Then user tries to book consultation without login
   Then login popup should be displayed
   
@TC_06
   Scenario: Search with invalid specialty 
    Given User is on the Find Doctors page
    When User clicks on Dermatology and navigates to Dermatologist page
    Then User enters an invalid specialty in the search bar
    And clicks on the Search button
    Then The system should display No result found message


