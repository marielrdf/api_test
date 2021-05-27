Feature:
  Scenario: getBoard
    Given I set endpoint "/board/[board.id]"
    When I send "GET" request
    Then I validate the status code is "200"