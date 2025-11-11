Feature: Apollo 24/7 - Consultation Booking Automation

  Background: 
    Given User open Apollo Pharmacy website
		Then User login using mobile number and OTP
		|Book3.xlsx|
		When User click on Find Doctors
		Then Doctors module should be displayed
		
  @InvalidSearch
  Scenario Outline: Invalid Doctor search
   When User search on search bar
   Then search for invalid Doctor names <sheetno> and <rowno>
   Then No results found message should be displayed
   
   Examples:
   |sheetno|rowno|
   |   1   |  0  |
   |   1   |  1  |
   |   1   |  2  |
   

  @BrowseBySpecialty
  Scenario: Browse doctors by specialty
    When User click Dermatologist
    Then User navigates to Dermatologists
    Then Doctors should be displayed
 
 
