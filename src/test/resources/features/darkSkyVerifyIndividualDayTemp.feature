  @web @individualDayTemp
  Feature: Verify Individual Day Temp Timeline

    Background:
      Given I am on Darksky Home Page

    @verifyTempTimeline
     Scenario: Verify individual day temp timeline
     When I expand todays timeline
     Then I verify lowest and highest temp is displayed correctly