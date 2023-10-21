
Feature: validating place API's

  Scenario: Verify if place is being succesfully added using AddPlaceAPI

Given Add place payload
When user calls "Awith post http request
Then the API call got success with status code 200
And "status" is response body is "OK"
And "scop" in response body is "APP"