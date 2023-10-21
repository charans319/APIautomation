

Feature: Validating Place API's

  Scenario: Home page default login
    Given User is on landing page
    When User login into application with username and password
    Then Home page is populated
    And Cards are displayed

    Scenario: Verify if place is being succesfully added using AddPlaceAPI

      Given Add place payload
      When user calls "AddPlaceAPI" with post http request
      Then the API call got success with status code 200
      And "status" is response body is "OK"
      And "scop" in response body is "APP"