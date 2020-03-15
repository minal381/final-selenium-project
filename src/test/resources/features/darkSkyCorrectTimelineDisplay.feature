@web @correctTimeLine
Feature:  Verify Timeline Display

  Background:
    Given I am on Darksky home page

  @timeLineDisplay
  Scenario: Verify timline is displayed in correct format

  Then I verify timeline is displayed with two hours incremented
