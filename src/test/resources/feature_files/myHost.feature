
Feature: my Host to check all request


  Scenario:  get all user dataes with get Request
    Given user send GEt request to "Endurl"
    Then The Status code should be 200 and Type "get"
    And I verify allid should be here "id"


  Scenario: get a user body with get Request
    Given I send the get Request "Endurl" with "getuserid"
    Then The Status code should be 200 and Type "get"
    Then I check the body value with "kumar"

  Scenario: Add a new user and verified creation with post Request
    Given I send  POST request to Add "Endurl" with the following data
      | firstname       | dinesh               |
      | lastname        | Murugan              |
      | emailid         | dineshmeij@gmail.com |
      | age             | 28                   |
      | city            | Nagercoil            |
      | landmark        | Bus Stop             |
      | district        | Kanyakumari          |
      | skilname        | Manual Testing       |
      | skillevel       | Intermediate         |
      | experienceYears | 4                    |
    Then The Status code should be 201 and Type "post"
    And verify the created user data should contain the Jsonbody
      | emailid   | dineshmeij@gmail.com |
      | firstname | dinesh               |


  Scenario: Verify updating after existing user's information with patch Request
    Given I send the get Request "Endurl" with "updatauserid"
    Then the Resopons stroe with userid
    Then The Status code should be 200 and Type "get"
    And I send the patch Request "Endurl" with userid
      | firstname | asds |
      | age       | 12   |
    Then The Status code should be 200 and Type "patch"
    And verify the existingUser and updatauserbody

  @try
  Scenario: Verify existing user body information fullyreplace with put Request
    Given I send the get Request "Endurl" with "updatauserid"
    Then The Status code should be 200 and Type "get"
    When the Resopons stroe with userid
    And I send the put Request "Endurl" with new body
      | firstname       | dinesh               |
      | lastname        | Murugan              |
      | emailid         | dineshmeij@gmail.com |
      | age             | 28                   |
      | city            | Nagercoil            |
      | landmark        | Bus Stop             |
      | district        | Kanyakumari          |
    Then The Status code should be 200 and Type "put"
