Feature:

  @createBoard
  Scenario: getBoard
    Given I set endpoint "/boards/[brd.id]"
    When I send "GET" request
    Then I validate the status code is "200"