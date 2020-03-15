

@web @invalidSignUp
Feature:  Verify Invalid Signup

  Background:
    Given I am on the darksky Register page

  @invalidSignUp-1

  Scenario:  Verify invalid sign up error message
   When I click on Register button
   Then I verify I am on Register page by asserting Register header


