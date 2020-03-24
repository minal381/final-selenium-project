@web @regression @hotelsWithinTenMiles
Feature: Hotel Search

  Background:
    Given I am on default locations search result screen


 Scenario: List of all of hotel within 10 miles radius of airport or downtown

   Then I verify system displays all hotels within 10 miles radius of airport
   And I verify Hilton Hotel is within radius
