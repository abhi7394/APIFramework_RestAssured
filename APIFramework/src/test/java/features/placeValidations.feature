Feature: Validating Place APIs

Scenario Outline: Verify if place is being added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "post" HTTP request
	Then API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
	
Examples:
	|name	|language	|address	|
	|aaahouse|English|ooga buga ooga|	