@playlist
Feature: PlayList of an User

  Scenario Outline: Validate the order of songs in the recent playlist
    Given User reads the songs in the given "<Album>" with <NumberOfUsers> and <capacity>
    When User selects <number> songs and plays it in an order
    Then User validates the top <capacity> songs in the playlist

    Examples:
      | Album |number|NumberOfUsers|capacity|
      | ARR |6    | 2  |3|