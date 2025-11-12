Feature: Validate Find Doctors functionality on Apollo Pharmacy website

  Scenario: Verify Find Doctors page and search bar visibility
    Given User opens Apollo Pharmacy homepage
    When User clicks on Find Doctors
    Then Validate the title of the webpage

  Scenario: Validate Browse by Specialty and navigate to Dermatology doctors
    Given User opens Apollo Pharmacy homepage
    When User clicks on Find Doctors
    Then Validate the title of the webpage
    Then Validate that Browse by Specialty option is displayed
    And User clicks on Dermatology
    Then User should navigate to Dermatologists page