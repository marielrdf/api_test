Feature: my Profile Trello
  Scenario: I get my all boards
    Given I set endpoint "/members/me/boards"
    When I send "GET" request
    Then I validate the status code is "200"