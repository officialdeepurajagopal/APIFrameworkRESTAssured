Feature: Validating Place/Location API's' 

#Scenario: Validate whether Add Place is success or not
#    Given User send "addPlacePayLoad" Payload
#    When User calls "AddPlace" API with Post http request
#    Then The "statusCode" in response is 200
#    And The "status" in reponse is "OK" 
#    And The "scope" in reponse is "APP" 

@AddPlace
Scenario Outline: Validate whether Add Place is success or not 
	Given User send "addPlacePayLoad" Payload with "<name>" and "<language>" and "<address>" 
	When User calls "AddPlaceAPI" API with "POST" http request 
	Then The "statusCode" in response is 200 
	And The "status" in reponse is "OK" 
	And The "scope" in reponse is "APP" 
	And User confirms the "place_id" id present in the response 
	And verify "place_id" created for "<name>" using "GetPlaceAPI" 
	
	Examples: 
		|name|language|address|
		|Aadithya S Deepu|English|MRA 10 D|
		

@DeletePlace		
Scenario Outline: Validate whether DeletePlace functionality is working 

#	Given User send "addPlacePayLoad" Payload with "<name>" and "<language>" and "<address>"
#	When User calls "AddPlaceAPI" API with "POST" http request 
#	Then The "statusCode" in response is 200 
	Given  Given User send "deletePlacePayLoad" Payload
	When User calls "DeletePlaceAPI" API with "POST" http request
	Then The "statusCode" in response is 200  
	
	Examples: 
		|name|language|address|
		|Aadithya S Deepu|English|MRA 10 D|