Feature: Circle Membership Functionality

Scenario: Navigating to Join Circle from Circle Membership

  Given the user is on Apollo 247 homepage
  When the user clicks on Circle Membership
  And the circle membership page is visible
  And the user clicks on Plans for You
  And the available plans page is visible
  And the user clicks on Join Circle
  Then the membership joining page is visible