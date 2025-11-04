Feature: Reqres API Testing


#  @try
  Scenario: Get user by ID
    When User sends a GET request to "/api/users/2"
    Then The Status code should be 200


  Scenario: Login with valid credentials
    When User sends a POST request to "/api/login" with valid credentials
      | email    | eve.holt@reqres.in |
      | password | cityslicka         |
    Then The Status code should be 200
    And The Response should contain to get a token

  Scenario: Update user with PUT
    When User sends a PUT request to "/api/users/2" with updated data
      | name | dioooo |
      | age  | 50000  |
    Then The Status code should be 200

  Scenario: Update user with PATCH
    When User sends a PATCH request to "/api/users/2" with partial update
    Then The Status code should be 200

  Scenario: Delete user
    When User sends a DELETE request to "/api/users/2"
    Then The Status code should be for delete 204
