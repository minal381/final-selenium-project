@web @verifyDealPrice
Feature: Verify deal price

  Scenario: Verify todays deal price value
    Given I'm on default locations search result screen
    Then I verify todays deal is less than $200