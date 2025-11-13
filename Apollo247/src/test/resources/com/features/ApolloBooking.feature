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
    Scenario: Book an online consultation
     Given the user is on the Apollo Pharmacy homepage
     When the user applies filters to find doctors
     And selects a doctor from the filtered list
     And clicks on Online Consult
     And chooses a date and time slot
     And selects a patient or member from the list
     And clicks on Proceed
     Then the user should be redirected to the payment page

   

