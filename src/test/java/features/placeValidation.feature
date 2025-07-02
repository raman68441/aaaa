Feature: Add Place API validation

  Scenario: Verify that Add Place API is working
    Given Add Place Payload
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "kathriki ramanjaneylu" using "getPlaceAPI"

    Given Update Place Payload with "123 Updated Lane"
    When user calls "updatePlaceAPI" with "PUT" http request
    Then the API call got success with status code 200
    Then "msg" in response body is "Address successfully updated"