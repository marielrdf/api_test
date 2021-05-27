Feature:
  Scenario: post Board
    Given I set endpoint "/boards"
    And I set a body
    """
    {"name" : "new Board"}
    """
    When I send "POST" request
    Then I validate the status code is "200"
