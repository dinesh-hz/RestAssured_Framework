Feature: my Host to check all request

  @try
  Scenario: user get all empolyess
    Given user send GEt request to "endpointalldataes"
    Then The Status code should be 200
    And The User name should be "Steve"
