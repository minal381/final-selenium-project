@web @roomCountDropdown
  Feature: Verify room count dropdown

    @roomCountDropdown-1
    Scenario Outline:Verify room count dropdown
     Given I am on hotels home page
      When I select <select_rooms> from room dropdown
      And I verify <number_of_room_dropdown> is displayed

      Examples:
     |select_rooms|number_of_room_dropdown|
     |1          |     1                  |
     |2          |     2                  |
     |3          |     3                  |
     |4          |     4                  |
     |5          |     5                  |
     |6          |     6                  |
     |7          |     7                  |
     |8          |     8                  |
     |9+         |     0                  |