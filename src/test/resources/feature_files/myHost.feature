Feature: my Host to check all request


  Scenario: user get all empolyess
    Given user send GEt request to "endpointalldataes"
    Then The Status code should be 200
    And The User name should be "Steve"


  Scenario: Add a new user and verify creation
    Given the user sends a POST request to "postendurl" with the following data
      | firstname | Dinesh               |
      | lastname  | Murugan              |
      | emailid   | dineshmeij@gmail.com |
      | age       | 28                   |
      | city      | Nagercoil            |
      | landmark  | Bus Stop             |
      | district  | Kanyakumari          |
    Then The Status code should be 201
    And the created user data should contain
      | emailid | dineshmeij@gmail.com |
      | name    | dinesh               |

  @try
  Scenario: Verify updating after existing user's information
    Given I send the get Request "Endurl" with "userid"
    Then the Resopons stroe with userid
    Then The Status code should be 200 and Type "get"
    And I send the patch Request "Endurl" with userid
      | firstname | ds |
      | age       | 28  |
    Then The Status code should be 200 and Type "patch"
    And verify the existingUser and updatauserbody
